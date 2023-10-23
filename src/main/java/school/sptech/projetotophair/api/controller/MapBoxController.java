package school.sptech.projetotophair.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClients;

@RestController
public class MapBoxController {

    private static final String MAPBOX_ACCESS_TOKEN = "pk.eyJ1Ijoic2l0YXZhcmVzIiwiYSI6ImNsbmpjcHJnbTB0OXQyam83MGl5MmFjZGkifQ.1Nm5ZlbXimV_j9Vb4f4FPg"; // Inserir token MapBox
    private static final String GEOCODING_API_URL = "https://api.mapbox.com/geocoding/v5/mapbox.places/";

    @GetMapping("/mapbox/directions")
    public ResponseEntity<String> getDirections(
            @RequestParam double startLongitude, @RequestParam double startLatitude,
            @RequestParam double endLongitude, @RequestParam double endLatitude) {

        // Crie a URL para a solicitação de direções
        String directionsApiUrl = "https://api.mapbox.com/directions/v5/mapbox/driving/"
                + startLongitude + "," + startLatitude + ";"
                + endLongitude + "," + endLatitude
                + "?access_token=" + MAPBOX_ACCESS_TOKEN;

        // Execute a solicitação de direções
        String directionsResponse = executeHttpRequest(directionsApiUrl);

        return ResponseEntity.ok(directionsResponse);
    }

    @GetMapping("/mapbox/geocode")
    public ResponseEntity<String> geocodeAddress(@RequestParam String address) {
        // Codifique o endereço usando a API de geocodificação do Mapbox
        String geocodeApiUrl = GEOCODING_API_URL + address + ".json?access_token=" + MAPBOX_ACCESS_TOKEN;
        String geocodeResponse = executeHttpRequest(geocodeApiUrl);

        return ResponseEntity.ok(geocodeResponse);
    }

    private String executeHttpRequest(String apiUrl) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiUrl);

        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                return responseBody;
            } else {
                // Handle null response entity
                return "No response entity";
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors
            return "Error: " + e.getMessage();
        }
    }
}
