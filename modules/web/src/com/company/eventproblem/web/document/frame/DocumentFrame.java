package com.company.eventproblem.web.document.frame;

import com.company.eventproblem.entity.Document;
import com.company.eventproblem.web.entity.CifraUiEvent;
import com.haulmont.cuba.gui.components.AbstractFrame;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.events.UiEvent;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;
import java.util.UUID;

public class DocumentFrame extends AbstractFrame implements UiEvent {

    @Inject
    protected CollectionDatasource<Document, UUID> documentDs;

    @EventListener
    public void onCifraUiEvent(CifraUiEvent event) {

        showNotification("Event captured ! ", NotificationType.HUMANIZED);
        documentDs.refresh();

    }

}
