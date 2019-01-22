package br.com.zup.godfather.agent;

import br.com.zup.godfather.agent.utils.JsonUtils;
import br.com.zup.godfather.agent.utils.ProducerManager;

public class JacksonHelper {

    public JacksonHelper() {
    }

    public void traceAsObject(Object obj) {
        String json = JsonUtils.write(obj);
        System.out.println("AGENT collecting event from class com.fasterxml.jackson.databind.ObjectMapper.readValue \n Payload = " + json);
        ProducerManager.send(json);
    }
}
