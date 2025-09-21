package com.akib_ananno.text_transformer.service.transformer;

/**
 * A concrete implementation of a Transformer that performs no operation.
 * It simply returns the input text as is. This class serves as the foundational
 * base case for building a chain of decorators. It should NOT be managed by Spring
 * as a component, as it is not an API-selectable transformation.
 */
public class IdentityTransformer implements Transformer {

    @Override
    public String transform(String text) {
        return text;
    }

    @Override
    public String getName() {
        // This name is for internal consistency and will not be exposed in the API.
        return "identity";
    }
}