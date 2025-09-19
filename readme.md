
# Text Transformer API

[![Java CI with Maven](https://github.com/<YOUR_GITHUB_USERNAME>/<YOUR_REPOSITORY_NAME>/actions/workflows/ci.yml/badge.svg)](https://github.com/<YOUR_GITHUB_USERNAME>/<YOUR_REPOSITORY_NAME>/actions)

A simple and extensible RESTful API built with Spring Boot for performing sequential text transformations.

## Features

-   Invoke a sequence of text transformations via a single REST API call.
-   **Case Transformations:** Convert text to `UPPERCASE`, `lowercase`, or `Capitalized Case`.
-   **Inverse:** Reverse the sequence of characters while preserving the original positions of upper and lower case letters.
-   **LaTeX Conversion:** Escape special LaTeX characters like `&` and `$`.
-   **Remove Repetitive Words:** Condense adjacent, repeated words into a single instance (e.g., "hello hello" -> "hello").

## Prerequisites

-   Java (JDK) 24
-   Apache Maven 3.8+

## How to Build and Run

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/AbtahiAnanno/text_transformation.git
    cd text-transformer
    ```

2.  **Build the application:**
    This command will compile the code, run tests, and package it into an executable JAR file in the `target/` directory.
    ```sh
    mvn clean package
    ```

3.  **Run the application:**
    ```sh
    java -jar target/text-transformer-1.0.2.jar
    ```
    The application will start on `http://localhost:8080`.

## API Usage

### Endpoint

-   **URL:** `/api/v1/transform`
-   **Method:** `POST`
-   **Content-Type:** `application/json`

### Request Body

```json
{
  "text": "your input text here",
  "transformations": ["name_of_transform_1", "name_of_transform_2"]
}
```

### Example Request

Here is an example using `curl` to chain multiple transformations:

```bash
curl -X POST 'http://localhost:8080/api/v1/transform' \
-H 'Content-Type: application/json' \
-d '{
  "text": "send send me $100 & some text",
  "transformations": [
    "remove-repetitive",
    "capitalize",
    "latex"
  ]
}'
```

### Success Response

```json
{
    "originalText": "send send me $100 & some text",
    "transformedText": "Send Me \\$100 \\& Some Text",
    "transformationsApplied": [
        "remove-repetitive",
        "capitalize",
        "latex"
    ]
}
```

## Available Transformations

| Name | Description |
| :--- | :--- |
| `upper` | Converts all letters to uppercase. |
| `lower` | Converts all letters to lowercase. |
| `capitalize` | Capitalizes the first letter of each word. |
| `inverse` | Reverses characters, preserving case positions. |
| `latex` | Escapes special characters for LaTeX (`&`, `$`). |
| `remove-repetitive` | Removes adjacent duplicate words. |

---
