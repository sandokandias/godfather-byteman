package br.com.zup.godfather.agent;

import br.com.zup.godfather.agent.utils.JsonUtils;
import br.com.zup.godfather.agent.utils.ProducerManager;

public class JacksonHelper {

    public JacksonHelper() {
    }

    public void traceAsObject(Object obj) {
        String json = JsonUtils.write(obj);
        System.out.println("Collecting obj from Jackson.readValue " + json);
        ProducerManager.send(json);
    }
}
