package com.akib_ananno.text_transformer.service;

import com.akib_ananno.text_transformer.dto.TransformationRequest;
import com.akib_ananno.text_transformer.service.transformer.Transformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TransformationService {

    // A map to hold all our transformers, keyed by their name (e.g., "upper")
    private final Map<String, Transformer> transformerMap;

    /**
     * Spring will automatically inject a list of all classes that implement the
     * Transformer interface and are marked as @Component. This is a powerful
     * feature that makes our system easily extensible.
     */
    public TransformationService(List<Transformer> transformers) {
        this.transformerMap = transformers.stream()
                .collect(Collectors.toMap(Transformer::getName, Function.identity()));
    }

    public String applyTransformations(TransformationRequest request) {
        String currentText = request.getText();

        // Loop through the list of transformation names from the request
        for (String transformationName : request.getTransformations()) {
            // Find the corresponding transformer in our map
            Transformer transformer = transformerMap.get(transformationName.toLowerCase());

            // If a transformer is not found, throw an error
            if (transformer == null) {
                throw new IllegalArgumentException("Unknown transformation requested: '" + transformationName + "'");
            }

            // Apply the transformation
            currentText = transformer.transform(currentText);
        }

        return currentText;
    }
}