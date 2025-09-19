package com.akib_ananno.text_transformer.service.transformer;

import org.springframework.stereotype.Component;

@Component
public class RemoveRepetitiveWordsTransformer implements Transformer {

    @Override
    public String transform(String text) {
        if (text == null) {
            return null;
        }
        // This regex finds any word (\w+) that is repeated one or more times
        // immediately after itself, separated by whitespace (\s+).
        // It's case-insensitive due to (?i).
        // It replaces the entire sequence (e.g., "word word word") with just one "word".
        String regex = "(?i)\\b(\\w+)(?:\\s+\\1)+\\b";
        return text.replaceAll(regex, "$1");
    }

    @Override
    public String getName() {
        return "remove-repetitive";
    }
}