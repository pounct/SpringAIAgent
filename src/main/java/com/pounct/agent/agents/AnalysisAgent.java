package com.pounct.agent.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AnalysisAgent {
    private final ChatClient chatClient;
    private String systemMessagePrompt = """
            Your role generate a financial report of a gived company using actual financial data
            a report include de company information like name web contry
            and include a conclusion
            """;

    private final String[] tools = new String[]{"tool1", "tool2"};
    public AnalysisAgent(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem(systemMessagePrompt)
                .defaultFunctions(tools)
                .build();
    }
    public String analysisReport(String company){
        return chatClient
                .prompt()
                //.system(systemMessagePrompt)
                .user("Company : "+ company)
                //.functions(tools)
                .call().content();
    }
}
