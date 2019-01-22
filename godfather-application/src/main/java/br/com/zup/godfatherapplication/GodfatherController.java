package br.com.zup.godfatherapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class GodfatherController {

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> post(@RequestBody Map<String, Object> body) {
        System.out.println("Request ==> " + body);
        Map<String, Object> response = new HashMap<>();
        response.put("requestId", UUID.randomUUID().toString());
        return response;
    }
}
