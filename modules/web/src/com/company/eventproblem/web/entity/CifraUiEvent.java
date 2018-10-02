package com.company.eventproblem.web.entity;

import com.haulmont.cuba.gui.events.UiEvent;
import org.springframework.context.ApplicationEvent;

public class CifraUiEvent extends ApplicationEvent implements UiEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CifraUiEvent(Object source) {
        super(source);
    }

}
