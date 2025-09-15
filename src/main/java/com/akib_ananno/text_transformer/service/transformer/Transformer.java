package com.akib_ananno.text_transformer.service.transformer;

public interface Transformer {
    String transform(String text);
    String getName(); // A unique name for each transformer, e.g., "upper", "lower"
}