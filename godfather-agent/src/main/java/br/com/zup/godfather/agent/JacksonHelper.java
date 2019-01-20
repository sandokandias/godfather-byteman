package br.com.zup.godfather.agent;

import br.com.zup.godfather.agent.utils.JsonUtils;
import br.com.zup.godfather.agent.utils.ProducerManager;

public class JacksonHelper {

    public JacksonHelper() {
    }

    public void trace(Object obj) {
        String event = JsonUtils.writeAsString(obj);
        System.out.println("Collecting event " + event);
        ProducerManager.send(event);
    }
}
