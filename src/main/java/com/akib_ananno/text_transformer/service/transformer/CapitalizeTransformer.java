package com.akib_ananno.text_transformer.service.transformer;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CapitalizeTransformer implements Transformer {

    @Override
    public String transform(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return Arrays.stream(text.split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    @Override
    public String getName() {
        return "capitalize";
    }
}