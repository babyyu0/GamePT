package com.a405.gamept.game.dto.response;

import com.a405.gamept.game.dto.command.ActCommandDto;
import com.a405.gamept.game.entity.Event;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.List;

@Builder
public record EventGetResponseDto(
        @NotBlank(message = "이벤트 코드가 입력되지 않았습니다.") String eventCode,
        @NotBlank(message = "이벤트 이름이 입력되지 않았습니다.") String eventName,
        @NotBlank(message = "이벤트에 대한 행동이 입력되지 않았습니다.") List<ActGetResponseDto> acts,
        MonsterGetResponseDto monster
) {
    public static EventGetResponseDto of(Event event, List<ActGetResponseDto> acts) {
        return EventGetResponseDto.builder()
                .eventCode(event.getCode())
                .eventName(event.getName())
                .acts(acts)
                .build();
    }
}
