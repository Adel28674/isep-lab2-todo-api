package org.isep.cleancode;

import java.time.LocalDate;
import java.util.Date;

public class Todo {

    // this Todo class should be completed to achieve Step 1

    private String name;

    private Date dueDate;

    public Todo(String name) {
        this.name = name;
        this.dueDate = null;
    }

    public Todo(String name, Date dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
