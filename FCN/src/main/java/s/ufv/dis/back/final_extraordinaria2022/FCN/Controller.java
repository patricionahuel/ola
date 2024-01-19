package s.ufv.dis.back.final_extraordinaria2022.FCN;

import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    public List<RequestData> requests = new ArrayList<>();

    @PostMapping("/people")
    public ResponseEntity<String> guardarDatos(@RequestBody Map<String, Object> requestMap) {
        return procesarSolicitud(requestMap);
    }

    @PostMapping("/Starship")
    public ResponseEntity<String> guardarDatosStarship(@RequestBody Map<String, Object> requestMap) {
        return procesarSolicitud(requestMap);
    }

    private ResponseEntity<String> procesarSolicitud(Map<String, Object> requestMap) {
        try {
            String entity = (String) requestMap.get("entity");
            Integer id = (Integer) requestMap.get("id");
            String url = "https://swapi.dev/api/" + entity + "/" + id;
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String respuestaApi = response.getBody();

                // Suponiendo que DataHandler puede convertir la respuesta en un objeto RequestData
                RequestData requestData = DataHandler.getInstance().convertirAResponseData(respuestaApi, entity, id);
                guardarRespuestaTemporal(requestData);

                requests.add(requestData); // Añadir a la lista de requests
                guardarPeticionesEnArchivo(); // Guardar la lista en un archivo

                return ResponseEntity.ok("Datos de '" + entity + "' guardados exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la respuesta de la API");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }

    private void guardarRespuestaTemporal(RequestData requestData) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Serializar el objeto requestData a JSON
        JsonObject requestDataJson = (JsonObject) gson.toJsonTree(requestData);
        requestDataJson.remove("entity"); // Eliminar campo 'entity' del objeto 'data'
        requestDataJson.remove("id");     // Eliminar campo 'id' del objeto 'data'

        // Crear JsonObject y agregar 'entity', 'id' y 'data'
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("entity", requestData.getEntity());
        jsonObject.addProperty("id", requestData.getId());
        jsonObject.add("data", requestDataJson);

        // Escribir el objeto JSON en el archivo
        try (FileWriter file = new FileWriter("peticiones.json")) {
            file.write(gson.toJson(requests));
        }
    }



    private void guardarPeticionesEnArchivo() {
        try (FileWriter file = new FileWriter("peticiones.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(requests);
            file.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/requests")
    public ResponseEntity<List<RequestData>> obtenerPeticionesAnteriores() {
        List<RequestData> requestList = leerPeticionesDeArchivo();
        return ResponseEntity.ok(requestList);
    }

    private List<RequestData> leerPeticionesDeArchivo() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("peticiones.json")));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<RequestData>>() {}.getType();
            return gson.fromJson(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }



}








