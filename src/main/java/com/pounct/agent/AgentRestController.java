package com.pounct.agent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentRestController {
    private ChatClient chatClient;
    private String systemMessagePrompt = """
            Your role generate a financial report of a gived company using actual financial data
            a report include de company information like name web contry
            and include a conclusion
            """;

    public AgentRestController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping(value = "/ask", produces = MediaType.TEXT_PLAIN_VALUE)
    public String askAgent(String company){
        return chatClient
                .prompt()
                .system(systemMessagePrompt)
                .user("Company : "+ company)
                .functions("tool1")
                .call().content();
    }
}
