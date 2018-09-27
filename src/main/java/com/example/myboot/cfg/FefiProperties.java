package com.example.myboot.cfg;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Configuration
public class FefiProperties {
    @Value("${ai.fefi.title}")
    private String title;
    @Value("${ai.fefi.content}")
    private String content;
}
