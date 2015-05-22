/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.event;

import java.time.LocalDateTime;

/**
 *
 * Class to represent generic Event
 */
public class Event {

    private long eventId;
    private EventType eventType;
    private String description;
    private LocalDateTime createTimeStamp;

    public Event(long eventId, EventType eventType, String description) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.description = description;
    }

    public long getEventId() {
        return eventId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreateTimeStamp() {
        return createTimeStamp;
    }
    
    
}
