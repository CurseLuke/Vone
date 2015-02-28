package com.kieronwiltshire.vone.main.events;

import com.kieronwiltshire.vone.main.Session;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @name Vone
 * @version 1.0
 * @author Kieron Wiltshire
 * @contact kieron.wiltshire@outlook.com
 * @copyright (c) Kieron Wiltshire 2015
 *
 * @description
 *  Vone is a 1v1, 2v2, 3v3 and Free For All (FFA) modification/plugin/extension
 *  built on top of the Bukkit and Spigot API.
 */
public class SessionStartEvent extends Event {

    // Class variables
    private static final HandlerList handlers = new HandlerList();

    // Instance variables
    private Session session;

    /**
     * SessionStartEvent constructor
     *
     * @param session The Session that started
     */
    public SessionStartEvent(Session session) {
        this.session = session;
    }

    /**
     * Get the Session that ended
     *
     * @return Session object
     */
    public Session getSession() {
        return this.session;
    }

    /**
     * Get the HandlerList
     *
     * @return HandlerList object
     */
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Get the HandlerList
     *
     * @return HandlerList object
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
