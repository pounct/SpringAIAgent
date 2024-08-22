package com.pounct.agent.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AnalysisAgent {
    private ChatClient chatClient;
    private String systemMessagePrompt = """
            Your role generate a financial report of a gived company using actual financial data
            a report include de company information like name web contry
            and include a conclusion
            """;

    public AnalysisAgent(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    public String analisisReport(String company){
        return chatClient
                .prompt()
                .system(systemMessagePrompt)
                .user("Company : "+ company)
                .functions("tool1", "tool2")
                .call().content();
    }
}
