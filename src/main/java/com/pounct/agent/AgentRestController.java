package com.pounct.agent;

import com.pounct.agent.agents.AnalysisAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentRestController {
    private AnalysisAgent analysisAgent;

    public AgentRestController(AnalysisAgent analysisAgent) {
        this.analysisAgent = analysisAgent;
    }

    @GetMapping(value = "/ask", produces = MediaType.TEXT_PLAIN_VALUE)
    public String askAgent(String company){
        return analysisAgent.analysisReport(company);
    }
}
