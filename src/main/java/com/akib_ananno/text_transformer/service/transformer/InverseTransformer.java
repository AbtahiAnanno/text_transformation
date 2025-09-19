package com.akib_ananno.text_transformer.service.transformer;

import org.springframework.stereotype.Component;

@Component
public class InverseTransformer implements Transformer {

    @Override
    public String transform(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        // First, simply reverse the sequence of characters
        String reversedText = new StringBuilder(text).reverse().toString();
        StringBuilder result = new StringBuilder(reversedText);

        // Now, iterate through the original text to match case positions
        for (int i = 0; i < text.length(); i++) {
            char originalChar = text.charAt(i);
            char reversedChar = result.charAt(i);

            // If the character in the original string was uppercase,
            // make the character at the same position in the new string uppercase.
            if (Character.isUpperCase(originalChar)) {
                result.setCharAt(i, Character.toUpperCase(reversedChar));
            } 
            // If it was lowercase, make the new one lowercase.
            else if (Character.isLowerCase(originalChar)) {
                result.setCharAt(i, Character.toLowerCase(reversedChar));
            }
            // This logic implicitly handles numbers and symbols, which are left as-is.
        }

        return result.toString();
    }

    @Override
    public String getName() {
        return "inverse";
    }
}