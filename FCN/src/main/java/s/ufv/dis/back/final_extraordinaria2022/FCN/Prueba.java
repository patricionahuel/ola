package s.ufv.dis.back.final_extraordinaria2022.FCN;

import com.google.gson.JsonObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Prueba {
    /*@PostMapping("/")
public ResponseEntity<String> guardarDatos(@RequestBody Map<String, Object> requestMap) {
    try {
        String entity = (String) requestMap.get("entity");
        Integer id = (Integer) requestMap.get("id");

        // Realizar la solicitud GET a la URL deseada
        String url = "https://swapi.dev/api/" + entity + "/" + id;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        // Verificar el estado de la respuesta
        if (response.getStatusCode() == HttpStatus.OK) {
            String respuestaApi = response.getBody();

            // Crear un objeto JSON con los datos de la respuesta
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("entity", entity);
            jsonObject.addProperty("id", id);

            // Formatear el JSON de la respuesta y agregarlo al objeto JSON
            String respuestaFormateada =DataHandler.getInstance().formatearJson(respuestaApi);
            jsonObject.addProperty("data", respuestaFormateada);

            // Convertir el objeto JSON a una cadena
            String jsonBody = jsonObject.toString();

            // Guardar la cadena JSON en un archivo
            try (FileWriter file = new FileWriter("datos_" + entity + "_" + id + ".json")) {
                file.write(jsonBody);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al escribir en el archivo");
            }

            return ResponseEntity.ok("Datos de '" + entity + "' guardados exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la respuesta de la API");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
    }
}*/
    /*
    @PostMapping("/people")
    public ResponseEntity<String> guardarDatos(@RequestBody Map<String, Object> requestMap) {
        try {
            String entity = (String) requestMap.get("entity");
            Integer id = (Integer) requestMap.get("id");

            // Realizar la solicitud GET a la URL deseada
            String url = "https://swapi.dev/api/" + entity + "/" + id;
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

            // Verificar el estado de la respuesta
            if (response.getStatusCode() == HttpStatus.OK) {
                String respuestaApi = response.getBody();

                // Crear un objeto JSON con los datos de la respuesta
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("entity", entity);
                jsonObject.addProperty("id", id);

                // Formatear el JSON de la respuesta y agregarlo al objeto JSON
                String respuestaFormateada =DataHandler.getInstance().formatearJson(respuestaApi);
                jsonObject.addProperty("data", respuestaFormateada);

                // Convertir el objeto JSON a una cadena
                String jsonBody = jsonObject.toString();

                // Guardar la cadena JSON en un archivo
                try (FileWriter file = new FileWriter("datos_" + entity  + ".json")) {
                    file.write(respuestaFormateada);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al escribir en el archivo");
                }

                return ResponseEntity.ok("Datos de '" + entity + "' guardados exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la respuesta de la API");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
    @PostMapping("/Starship")
    public ResponseEntity<String> guardarDatosStarship(@RequestBody Map<String, Object> requestMap) {
        try {
            String entity = (String) requestMap.get("entity");
            Integer id = (Integer) requestMap.get("id");

            // Realizar la solicitud GET a la URL deseada
            String url = "https://swapi.dev/api/" + entity + "/"  + id;
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

            // Verificar el estado de la respuesta
            if (response.getStatusCode() == HttpStatus.OK) {
                String respuestaApi = response.getBody();

                // Crear un objeto JSON con los datos de la respuesta
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("entity", entity);
                jsonObject.addProperty("page", id);

                // Formatear el JSON de la respuesta y agregarlo al objeto JSON
                String respuestaFormateada = DataHandler.getInstance().formatearJson(respuestaApi);
                jsonObject.addProperty("data", respuestaFormateada);

                // Convertir el objeto JSON a una cadena
                String jsonBody = jsonObject.toString();

                // Guardar la cadena JSON en un archivo
                try (FileWriter file = new FileWriter("datos_" + entity +  ".json")) {
                    file.write(respuestaFormateada);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al escribir en el archivo");
                }

                return ResponseEntity.ok("Datos de '" + entity + "' guardados exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la respuesta de la API");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }*/
}
