package com.akib_ananno.text_transformer.service;

import com.akib_ananno.text_transformer.dto.TransformationRequest;
import org.springframework.stereotype.Service;

@Service
public class TransformationService {

    // We will inject all transformer implementations here later
    
    public String applyTransformations(TransformationRequest request) {
        String currentText = request.getText();

        // TODO: Add logic to loop through requested transformations
        // and apply them one by one.

        return currentText; // For now, it just returns the original text
    }
}