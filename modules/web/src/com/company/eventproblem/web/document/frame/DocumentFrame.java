package com.company.eventproblem.web.document.frame;

import com.company.eventproblem.entity.Document;
import com.company.eventproblem.web.entity.CifraUiEvent;
import com.haulmont.cuba.gui.components.AbstractFrame;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.RefreshAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.events.UiEvent;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DocumentFrame extends AbstractFrame implements UiEvent {

    @Inject
    protected CollectionDatasource<Document, UUID> documentDs;

    @EventListener
    public void onCifraUiEvent(CifraUiEvent event) {

        showNotification("Event captured ! ", NotificationType.HUMANIZED);
        documentDs.refresh();

    }


    @Inject
    private Table<Document> documentsTable;
    @Inject
    private ComponentsFactory componentsFactory;
    @Inject
    protected ButtonsPanel buttonsPanel;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);


        EditAction editAction = new EditAction(documentsTable) {
            @Override
            public String getWindowId() {
                return "eventproblem$Document.edit";
            }

            @Override
            public Map<String, Object> getWindowParams() {
                return super.getWindowParams();
            }

            @Override
            public boolean isPermitted() {
                if (super.isPermitted()) {
                    Set<Document> documents = documentsTable.getSelected();
                    return !CollectionUtils.isEmpty(documents) && documents.size() == 1;
                }
                return false;
            }
        };
        Button editButton = componentsFactory.createComponent(Button.class);
        editButton.setAction(editAction);

        RefreshAction refreshAction = new RefreshAction(documentsTable);
        Button refreshButton = componentsFactory.createComponent(Button.class);
        refreshButton.setAction(refreshAction);

        documentsTable.addAction(editAction);
        documentsTable.addAction(refreshAction);
        buttonsPanel.add(editButton);
        buttonsPanel.add(refreshButton);

    }


}
