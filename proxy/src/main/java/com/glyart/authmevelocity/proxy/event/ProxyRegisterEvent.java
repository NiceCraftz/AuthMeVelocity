package com.glyart.authmevelocity.proxy.event;

import com.velocitypowered.api.proxy.Player;

import org.jetbrains.annotations.NotNull;

public final class ProxyRegisterEvent {
    private final Player player;

    public ProxyRegisterEvent(@NotNull Player player){
        this.player = player;
    }

    public @NotNull Player getPlayer(){
        return this.player;
    }
}
