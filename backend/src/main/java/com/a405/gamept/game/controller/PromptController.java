package com.a405.gamept.game.controller;

import com.a405.gamept.game.dto.command.PrevPromptResultsGetCommandDto;
import com.a405.gamept.game.dto.command.PromptResultForStreamGetCommandDto;
import com.a405.gamept.game.dto.command.PromptResultGetCommandDto;
import com.a405.gamept.game.dto.request.PromptResultGetRequestDto;
import com.a405.gamept.game.dto.response.PromptResultGetResponseDto;
import com.a405.gamept.game.service.GameService;
import com.a405.gamept.game.service.PromptService;
import com.a405.gamept.play.entity.Game;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PromptController {

    private final PromptService promptService;
    private final GameService gameService;

    private final SimpMessagingTemplate webSocket;

//    @PostMapping
//    public ResponseEntity<PromptResultGetResponseDto> getPromptResult(@Valid @RequestBody PromptResultGetRequestDto promptResultGetRequestDto) {
//        return ResponseEntity.ok(promptService.getPrmoptResult(PromptResultGetCommandDto.from(promptResultGetRequestDto)));
//    }

    @MessageMapping("/prompt/{gameCode}")
    @Deprecated
    public void getPromptResult(@Valid @Payload PromptResultGetRequestDto promptResultGetRequestDto, @Valid @DestinationVariable String gameCode) {
        PromptResultGetCommandDto promptResultGetCommandDto = PromptResultGetCommandDto.from(promptResultGetRequestDto, gameCode);
        PromptResultGetResponseDto promptResultGetResponseDto = promptService.getPromptResult(promptResultGetCommandDto);
        webSocket.convertAndSend("/topic/prompt/" + gameCode, promptResultGetResponseDto);
    }

    @PostMapping(value = "/prompt-stream/{gameCode}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getPromptResultForStream(@Valid @RequestBody PromptResultGetRequestDto promptResultGetRequestDto, @Valid @PathVariable String gameCode) {
        PrevPromptResultsGetCommandDto prevPromptResultsGetCommandDto = promptService.getPrevPromptResults(gameCode);
        PromptResultForStreamGetCommandDto promptResultForStreamGetCommandDto = PromptResultForStreamGetCommandDto.from(gameCode, promptResultGetRequestDto, prevPromptResultsGetCommandDto);

        try {
            return promptService.getPromptResultForStream(promptResultForStreamGetCommandDto);
        } catch (JsonProcessingException je) {
            log.error(je.getMessage());
            return Flux.empty();
        }
    }

    @PostMapping(value = "/prompt-sse/{gameCode}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getPromptResultForSse(@Valid @RequestBody PromptResultGetRequestDto promptResultGetRequestDto, @Valid @PathVariable String gameCode) {
        PrevPromptResultsGetCommandDto prevPromptResultsGetCommandDto = promptService.getPrevPromptResults(gameCode);
        PromptResultForStreamGetCommandDto promptResultForStreamGetCommandDto = PromptResultForStreamGetCommandDto.from(gameCode, promptResultGetRequestDto, prevPromptResultsGetCommandDto);

        try {
            SseEmitter sseEmitter = promptService.getPromptResultForSse(promptResultForStreamGetCommandDto);
//            return promptService.getPromptResultForSse(promptResultForStreamGetCommandDto);
            return sseEmitter;
        } catch (JsonProcessingException je) {
            log.error(je.getMessage());
            return null;
        }
    }

}
