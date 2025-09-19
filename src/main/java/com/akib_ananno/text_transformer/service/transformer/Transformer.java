package com.akib_ananno.text_transformer.service.transformer;

/**
 * Defines the contract for all text transformation operations.
 * <p>
 * Each implementation of this interface represents a single, atomic transformation
 * that can be applied to a string. Implementations are expected to be stateless
 * and thread-safe.
 *
 * @author Akib Ananno
 * @version 1.0.2
 * @since 2025-09-15
 */
public interface Transformer {

    /**
     * Applies a specific transformation to the input text.
     *
     * @param text The input string to be transformed. Cannot be null.
     * @return The transformed string.
     */
    String transform(String text);

    /**
     * Returns the unique, lowercase name of the transformer.
     * <p>
     * This name is used to identify and request the transformation in the API.
     * For example, "upper", "inverse", "latex".
     *
     * @return A non-null, unique string representing the transformer's name.
     */
    String getName();
}