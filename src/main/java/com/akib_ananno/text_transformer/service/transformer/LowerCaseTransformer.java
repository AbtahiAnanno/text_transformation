package com.akib_ananno.text_transformer.service.transformer;

import org.springframework.stereotype.Component;

@Component
public class LowerCaseTransformer implements Transformer {

    @Override
    public String transform(String text) {
        return text.toLowerCase();
    }

    @Override
    public String getName() {
        return "lower";
    }
}