package com.akib_ananno.text_transformer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor // Lombok annotation for a constructor with all arguments
@NoArgsConstructor // Lombok annotation for a no-argument constructor
public class TransformationResponse {

    private String originalText;
    private String transformedText;
    private List<String> transformationsApplied;
}