package com.a405.gamept.game.dto.command;

import com.a405.gamept.play.entity.Game;
import com.a405.gamept.play.entity.Prompt;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.LinkedList;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record PrevPromptResultsGetCommandDto(
        @NotBlank(message = "프롬프트 메모리가 존재하지 않습니다.")
        String memory,
        @NotBlank(message = "이전 프롬프트 리스트가 존재하지 않습니다.")
        List<PromptCommandDto> promptList
) {
    public static PrevPromptResultsGetCommandDto of(Game game) {
        return PrevPromptResultsGetCommandDto.builder()
                .memory(game.getMemory())
                .promptList(getPromptCommandDtoList(game.getPromptList()))
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
