package com.akib_ananno.text_transformer.service.transformer;

/**
 * An abstract base class for creating {@link Transformer} decorators.
 * <p>
 * This class provides the foundational structure for the Decorator pattern
 * by holding a reference to a wrapped {@code Transformer} instance. Concrete
 * decorators should extend this class to avoid boilerplate code for the wrapping logic.
 */
public abstract class BaseTransformerDecorator implements Transformer {

    /**
     * The next Transformer object in the decoration chain.
     */
    protected final Transformer wrapped;

    /**
     * Constructs a decorator that will wrap another {@code Transformer}.
     *
     * @param wrapped The {@code Transformer} instance to be decorated.
     */
    public BaseTransformerDecorator(Transformer wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * Delegates the transformation task to the wrapped {@code Transformer} instance.
     * <p>
     * Concrete decorators should override this method to add their own functionality,
     * typically after calling {@code super.transform(text)} to get the result from
     * the rest of the chain.
     *
     * @param text The input string to be transformed.
     * @return The result from the wrapped transformer.
     */
    @Override
    public String transform(String text) {
        return wrapped.transform(text);
    }
}