package com.a405.gamept.game.dto.request;

import com.a405.gamept.game.util.RegexPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ChatRequestDto(
        @NotBlank(message = "플레이어가 존재하지 않습니다.")
        @Pattern(regexp = RegexPatterns.PLAYER, message = "플레이어가 올바르지 않습니다.")
        String playerCode,
        @NotBlank(message = "메시지 내용이 존재하지 않습니다.")
        String message
) { }
