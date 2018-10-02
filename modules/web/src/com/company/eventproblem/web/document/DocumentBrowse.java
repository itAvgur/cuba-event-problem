package com.company.eventproblem.web.document;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TabSheet;

import javax.inject.Named;
import java.util.Map;

public class DocumentBrowse extends AbstractLookup {

    @Named("tabs")
    private TabSheet tabSheet;

    @Override
    public void init(Map<String, Object> params) {

        super.init(params);

        initTabSheets();
    }

    private void initTabSheets() {

        for (int i = 0; i < 2; i++) {

            TabSheet.Tab tab = tabSheet.addTab("Frame's tab", createTab());
            tab.setCaption("Name " + i);
        }
    }

    private Component createTab() {
        return openFrame(null, "Document.frame");
    }

}


