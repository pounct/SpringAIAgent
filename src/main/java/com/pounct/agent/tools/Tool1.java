package com.pounct.agent.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("tool2")
@Description("""
        get informations about the given company including :
        - compaby name
        - country
        - domain
        - foundation year
        """)
public class Tool1 implements Function<Tool1.Request, Tool1.Response> {

    private static Logger log = LoggerFactory.getLogger(Tool1.class);
    public record Request(String company){};
    public record Response(
            String company,
            String country,
            String domain,
            int foundationYear
    ){};

    @Override
    public Response apply(Request request) {
        // consulyayion de la bdd
        log.info("------------------ identification function start...-----------------");
        return new Response(request.company,"info1","info1",1923);
    }

}
