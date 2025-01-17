package com.glyart.authmevelocity.spigot.listeners;

import com.glyart.authmevelocity.spigot.AuthMeVelocityPlugin;
import com.glyart.authmevelocity.spigot.MessageType;
import com.glyart.authmevelocity.spigot.events.PreSendLoginEvent;

import fr.xephi.authme.events.LoginEvent;
import fr.xephi.authme.events.LogoutEvent;
import fr.xephi.authme.events.RegisterEvent;
import fr.xephi.authme.events.UnregisterByAdminEvent;
import fr.xephi.authme.events.UnregisterByPlayerEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AuthMeListener implements Listener {
    private final AuthMeVelocityPlugin plugin;

    public AuthMeListener(AuthMeVelocityPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogin(LoginEvent event) {
        final Player player = event.getPlayer();
        PreSendLoginEvent preSendLoginEvent = new PreSendLoginEvent(player);
        if(preSendLoginEvent.callEvent()){
            plugin.sendMessageToProxy(player, MessageType.LOGIN, player.getName());
        }
    }

    @EventHandler
    public void onRegister(RegisterEvent event){
        plugin.sendMessageToProxy(event.getPlayer(), MessageType.REGISTER, event.getPlayer().getName());
    }

    @EventHandler
    public void onLogout(LogoutEvent event){
        plugin.sendMessageToProxy(event.getPlayer(), MessageType.LOGOUT, event.getPlayer().getName());
    }

    @EventHandler
    public void onUnRegister(UnregisterByPlayerEvent event){
        plugin.sendMessageToProxy(event.getPlayer(), MessageType.UNREGISTER, event.getPlayer().getName());
    }

    @EventHandler
    public void onAdminUnRegister(UnregisterByAdminEvent event){
        plugin.sendMessageToProxy(event.getPlayer(), MessageType.FORCE_UNREGISTER, event.getPlayerName());
    }
}
