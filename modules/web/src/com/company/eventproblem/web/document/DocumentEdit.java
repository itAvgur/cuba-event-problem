package com.company.eventproblem.web.document;

import com.company.eventproblem.entity.Document;
import com.company.eventproblem.web.entity.CifraUiEvent;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;

public class DocumentEdit extends AbstractEditor<Document> {

    /**
     * Action on Ok button (commit and close screen)
     *
     * @param ignore
     */
    public void onOkBtnClick(Component ignore) {
        AppBeans.get(Events.class).publish(new CifraUiEvent("documentCommitted"));
        showNotification("Event sent",NotificationType.TRAY);
        commitAndClose();
    }

}