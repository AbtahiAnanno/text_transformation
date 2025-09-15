package com.akib_ananno.text_transformer.service.transformer;

import org.springframework.stereotype.Component;

@Component // This annotation tells Spring to manage this class as a bean
public class UpperCaseTransformer implements Transformer {

    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }

    @Override
    public String getName() {
        return "upper";
    }
}