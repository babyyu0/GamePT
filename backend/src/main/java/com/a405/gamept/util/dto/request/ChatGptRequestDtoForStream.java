package com.a405.gamept.util.dto.request;

public record ChatGptRequestDtoForStream(
        String model,
        ChatGptMessage[] messages,
        int temperature,
        int max_tokens,
        boolean stream
) {
}
