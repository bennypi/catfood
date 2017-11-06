package de.bennypi.catfood.actuator_connector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class Connector {

    private RestTemplate client = new RestTemplate();

    @Value("${catfood.actuator.url}")
    private String actuatorURL;

    public boolean deployFood() {
        try {
        ResponseEntity<String> response = client.getForEntity(actuatorURL, String.class);
        log.debug(response.getStatusCode().toString());
        return response.getStatusCode().is2xxSuccessful();
        } catch (RestClientException e) {
            log.warn("Cannot connect to catfood actuator");
            return false;
        }
    }

}
