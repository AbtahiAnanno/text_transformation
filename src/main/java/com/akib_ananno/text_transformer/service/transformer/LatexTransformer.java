package com.akib_ananno.text_transformer.service.transformer;

import org.springframework.stereotype.Component;

@Component
public class LatexTransformer implements Transformer {

    @Override
    public String transform(String text) {
        if (text == null) {
            return null;
        }
        // Chain replacements for each special character
        return text.replace("&", "\\&")
                   .replace("$", "\\$");
    }

    @Override
    public String getName() {
        return "latex";
    }
}