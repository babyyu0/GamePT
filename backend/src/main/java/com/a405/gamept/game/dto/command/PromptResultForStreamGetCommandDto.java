package com.a405.gamept.game.dto.command;

import com.a405.gamept.game.dto.request.PromptResultGetRequestDto;
import com.a405.gamept.game.util.RegexPatterns;
import com.a405.gamept.play.entity.Game;
import com.a405.gamept.play.entity.Prompt;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.LinkedList;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record PromptResultForStreamGetCommandDto(
        @NotBlank(message = "게임이 존재하지 않습니다.")
        @Pattern(regexp = RegexPatterns.GAME, message = "게임이 올바르지 않습니다.")
        String gameCode,
        @NotBlank(message = "프롬프트가 존재하지 않습니다.")
        String prompt,
        @NotBlank(message = "이전 프롬프트 리스트가 존재하지 않습니다.")
        List<PromptCommandDto> promptList,
        @NotBlank(message = "메모리가 존재하지 않습니다.")
        String memory
) {
    public static PromptResultForStreamGetCommandDto of(Game game, String prompt) {
        return PromptResultForStreamGetCommandDto.builder()
                .gameCode(game.getCode())
                .prompt(prompt)
                .promptList(getPromptCommandDtoList(game.getPromptList()))
                .memory(game.getMemory())
                .build();
    }

    private static List<PromptCommandDto> getPromptCommandDtoList(List<Prompt> promptList) {
        LinkedList<PromptCommandDto> promptDtoList = new LinkedList<>();
        for (Prompt prompt : promptList) {
            promptDtoList.add(PromptCommandDto.of(prompt));
        }
        return promptDtoList;
    }
}
