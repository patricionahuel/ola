package s.ufv.dis.back.final_extraordinaria2022.FCN;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class DataHandler {
    @Autowired
    private RestTemplate restTemplate;
    private static DataHandler instance = new DataHandler();
    private final Gson gson = new Gson();
    private DataHandler() {
    }

    public static DataHandler getInstance (){
        return instance;
    }

    // Función para formatear el JSON
    public String formatearJson(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();

        // Recorremos el JSON y eliminamos las propiedades con valores que contienen '\n' y '\'
        eliminarCaracteres(jsonObject);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonObject);
    }

    public void eliminarCaracteres(JsonObject jsonObject) {
        for (String key : jsonObject.keySet()) {
            if (jsonObject.get(key).isJsonPrimitive()) {
                String value = jsonObject.get(key).getAsString();
                value = value.replace("\\n", "").replace("\\", "");
                jsonObject.addProperty(key, value);
            } else if (jsonObject.get(key).isJsonObject()) {
                eliminarCaracteres(jsonObject.get(key).getAsJsonObject());
            }
        }
    }
    public RequestData convertirAResponseData(String respuestaJson, String entity, int id) {
        JsonObject jsonObj = JsonParser.parseString(respuestaJson).getAsJsonObject();
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();

        if (entity.equals("people")) {
            // Extracción de campos específicos de People
            String name = jsonObj.get("name").getAsString();
            String height = jsonObj.get("height").getAsString();
            String mass = jsonObj.get("mass").getAsString();
            String hairColor = jsonObj.get("hair_color").getAsString();
            String skinColor = jsonObj.get("skin_color").getAsString();
            String eyeColor = jsonObj.get("eye_color").getAsString();
            String birthYear = jsonObj.get("birth_year").getAsString();
            String gender = jsonObj.get("gender").getAsString();
            String homeworld = jsonObj.get("homeworld").getAsString();
            ArrayList<String> films = gson.fromJson(jsonObj.get("films").getAsJsonArray(), listType);
            ArrayList<String> species = gson.fromJson(jsonObj.get("species").getAsJsonArray(), listType);
            ArrayList<String> vehicles = gson.fromJson(jsonObj.get("vehicles").getAsJsonArray(), listType);
            ArrayList<String> starships = gson.fromJson(jsonObj.get("starships").getAsJsonArray(), listType);
            String created = jsonObj.get("created").getAsString();
            String edited = jsonObj.get("edited").getAsString();
            String url = jsonObj.get("url").getAsString();

            People peopleData = new People(name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeworld, films, species, vehicles, starships, created, edited, url);
            return new RequestData(entity, id, peopleData);
        } else if (entity.equals("starships")) {
            // Extracción de campos específicos de Starships
            String model = jsonObj.get("model").getAsString();
            String manufacturer = jsonObj.get("manufacturer").getAsString();
            String costInCredits = jsonObj.get("cost_in_credits").getAsString();
            String length = jsonObj.get("length").getAsString();
            String maxAtmospheringSpeed = jsonObj.get("max_atmosphering_speed").getAsString();
            String crew = jsonObj.get("crew").getAsString();
            String passengers = jsonObj.get("passengers").getAsString();
            String cargoCapacity = jsonObj.get("cargo_capacity").getAsString();
            String consumables = jsonObj.get("consumables").getAsString();
            String hyperdriveRating = jsonObj.get("hyperdrive_rating").getAsString();
            String MGLT = jsonObj.get("MGLT").getAsString();
            String starshipClass = jsonObj.get("starship_class").getAsString();
            ArrayList<String> pilots = gson.fromJson(jsonObj.get("pilots").getAsJsonArray(), listType);
            ArrayList<String> films = gson.fromJson(jsonObj.get("films").getAsJsonArray(), listType);
            String created = jsonObj.get("created").getAsString();
            String edited = jsonObj.get("edited").getAsString();
            String url = jsonObj.get("url").getAsString();

            Starship starshipData = new Starship(model, manufacturer, costInCredits, length, maxAtmospheringSpeed, crew, passengers, cargoCapacity, consumables, hyperdriveRating, MGLT, starshipClass, pilots, films);
            return new RequestData(entity, id, starshipData);
        } else {
            throw new IllegalArgumentException("Tipo de entidad no soportada: " + entity);
        }
    }




}
