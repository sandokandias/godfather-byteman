package br.com.zup.godfatherapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GodfatherController {

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> post(@RequestBody Map<String, String> body) {
        System.out.println("PostMapping ==> " + body);
        body.put("status", "CREATED");
        return body;
    }
}
