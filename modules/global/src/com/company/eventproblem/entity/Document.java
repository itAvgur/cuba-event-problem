package com.company.eventproblem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|id")
@Table(name = "EVENTPROBLEM_DOCUMENT")
@Entity(name = "eventproblem$Document")
public class Document extends StandardEntity {
    private static final long serialVersionUID = 3692613399530624888L;

    @Column(name = "SOME_TEXT")
    protected String someText;

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public String getSomeText() {
        return someText;
    }


}