package com.a405.gamept.game.service;

import com.a405.gamept.game.dto.command.PrevPromptResultsGetCommandDto;
import com.a405.gamept.game.dto.command.PromptResultForStreamGetCommandDto;
import com.a405.gamept.game.dto.command.PromptResultGetCommandDto;
import com.a405.gamept.game.dto.request.PromptResultGetRequestDto;
import com.a405.gamept.game.dto.response.PromptResultGetResponseDto;
import com.a405.gamept.game.util.exception.GameException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

public interface PromptService {

    PromptResultGetResponseDto getPromptResult(PromptResultGetCommandDto promptResultGetCommandDto);
    Flux<String> getPromptResultForStream(PromptResultForStreamGetCommandDto promptResultForStreamGetCommandDto) throws JsonProcessingException;
    SseEmitter getPromptResultForSse(PromptResultForStreamGetCommandDto promptResultForStreamGetCommandDto) throws JsonProcessingException;
    PrevPromptResultsGetCommandDto getPrevPromptResults(String gameCode) throws GameException;
}
