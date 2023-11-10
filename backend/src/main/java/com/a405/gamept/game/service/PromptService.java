package com.a405.gamept.game.service;

import com.a405.gamept.game.dto.command.PromptResultGetCommandDto;
import com.a405.gamept.game.dto.response.PromptResultGetResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Flux;

public interface PromptService {

    PromptResultGetResponseDto getPrmoptResult(PromptResultGetCommandDto promptResultGetCommandDto);
    Flux<String> getPromptResultForStream(PromptResultGetCommandDto promptResultGetCommandDto) throws JsonProcessingException;

}
