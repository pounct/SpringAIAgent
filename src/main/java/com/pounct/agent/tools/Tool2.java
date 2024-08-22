package com.pounct.agent.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("tool1")
@Description("""
        get others informations about the given company including others information
        """)
public class Tool2 implements Function<Tool2.Request, Tool2.Response> {

    private static Logger log = LoggerFactory.getLogger(Tool2.class);
    public record Request(String company){};
    public record Response(String otherInfos){};

    @Override
    public Response apply(Request request) {
        // consulyayion de la bdd
        log.info("------------------ other information function start...-----------------");
        return new Response("others informations....");
    }

}
