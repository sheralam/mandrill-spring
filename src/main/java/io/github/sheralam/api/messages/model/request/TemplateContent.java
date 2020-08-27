package io.github.sheralam.api.messages.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TemplateContent {
    private String name;
    private String content;

    public TemplateContent(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
