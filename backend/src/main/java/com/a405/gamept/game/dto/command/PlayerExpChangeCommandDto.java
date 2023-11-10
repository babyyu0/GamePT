package com.a405.gamept.game.dto.command;

import com.a405.gamept.play.entity.Player;

public record PlayerExpChangeCommandDto(
        Player player,
        String prompt
) {
    public PlayerExpChangeCommandDto of(Player player, String prompt){
        return new PlayerExpChangeCommandDto(player, prompt);
    }
}
