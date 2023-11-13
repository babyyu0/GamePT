package com.a405.gamept.game.service;

import com.a405.gamept.game.dto.command.*;
import com.a405.gamept.game.dto.response.*;
import com.a405.gamept.game.util.exception.GameException;

import java.util.List;

public interface PlayerService {
    /**
     * (완료)
     * 스토리 별 종족 리스트를 조회한다
     * @param raceGetCommandDto: 플레이어가 속한 게임방 정보
     * @return  : 스토리 별 종족 리스트
     * @author  : 유영
     */
    List<RaceGetResponseDto> getRaceList(RaceGetCommandDto raceGetCommandDto) throws GameException;

    /**
     * (완료)
     * 스토리 별 직업 리스트를 조회한다
     * @param jobGetCommandDto : 플레이어가 속한 게임방 정보
     * @return  : 스토리 별 직업 리스트
     * @author  : 유영
     */
    List<JobGetResponseDto> getJobList(JobGetCommandDto jobGetCommandDto) throws GameException;

    /**
     * (완료)
     * 해당 게임 방의 플레이어를 삽입한다.
     * @param playerSetCommandDto : 플레이어를 삽입할 게임방 정보
     * @return  : 플레이어의 이름
     * @author  : 유영
     */
    PlayerSetResponseDto setPlayer(PlayerSetCommandDto playerSetCommandDto) throws GameException;

    /**
     * (완료)
     * 해당 게임 방의 플레이어를 조회한다.
     * @param playerGetCommandDto : 조회할 플레이어 정보
     * @return  : 플레이어 정보
     * @author  : 유영
     */
    PlayerGetResponseDto getPlayer(PlayerGetCommandDto playerGetCommandDto) throws GameException;

    /**
     * 해당 플레이어의 스탯을 조회한다.
     * @param playStatGetCommandDto
     * @return  : 플레이어 스탯
     * @author  : 우석
     */
    PlayerStatGetResponseDto getPlayerStat(PlayerStatGetCommandDto playStatGetCommandDto) throws GameException;

    /**
     *
     * @return
     */
    PlayerStatGetResponseDto addPlayerStat(PlayerStatUpdateCommandDto playerStatUpdateCommandDto) throws GameException;
}