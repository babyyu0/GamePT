package com.a405.gamept.game.dto.command;

import com.a405.gamept.play.entity.Prompt;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record PromptCommandDto(
        @NotBlank(message = "프롬프트의 role이 존재하지 않습니다.")
        String role,
        @NotBlank(message = "프롬프트의 content가 존재하지 않습니다.")
        String content
) {
    public static PromptCommandDto of(Prompt prompt) {
        return PromptCommandDto.builder()
                .role(prompt.getRole())
                .content(prompt.getContent())
                .build();
    }
}
