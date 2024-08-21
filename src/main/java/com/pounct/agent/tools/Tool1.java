package com.pounct.agent.tools;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("tool1")
@Description("""
        get informations about the given company including :
        - compaby name
        - country
        - domain
        - foundation year
        """)
public class Tool1 implements Function<Tool1.Request, Tool1.Response> {

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
        return new Response(request.company,"info1","info1",1923);
    }

}
