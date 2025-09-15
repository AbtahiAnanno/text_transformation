package com.akib_ananno.text_transformer.controller;

import com.akib_ananno.text_transformer.dto.TransformationRequest;
import com.akib_ananno.text_transformer.dto.TransformationResponse;
import com.akib_ananno.text_transformer.service.TransformationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transform")
public class TransformationController {

    private final TransformationService transformationService;

    // Dependency injection via constructor
    public TransformationController(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    @PostMapping
    public ResponseEntity<TransformationResponse> transformText(@Valid @RequestBody TransformationRequest request) {
        String transformedText = transformationService.applyTransformations(request);
        
        TransformationResponse response = new TransformationResponse(
            request.getText(),
            transformedText,
            request.getTransformations()
        );

        return ResponseEntity.ok(response);
    }
}