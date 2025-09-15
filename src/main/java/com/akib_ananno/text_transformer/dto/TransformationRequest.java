package com.akib_ananno.text_transformer.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data // Lombok annotation to generate getters, setters, toString, etc.
public class TransformationRequest {

    @NotEmpty(message = "Text cannot be empty")
    private String text;

    @NotEmpty(message = "Transformations list cannot be empty")
    private List<String> transformations;
}