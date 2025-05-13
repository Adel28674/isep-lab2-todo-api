package org.isep.cleancode.Util;

import org.eclipse.jetty.util.StringUtil;
import org.isep.cleancode.Model.Todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVSerializer {
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static Todo createTodoFromCsvLine(String[] fields) {
        String name = fields[0].trim();
        Date dueDate = null;

        if (fields.length > 1) {
            String date = fields[1].trim();
            if (!date.isEmpty()) {
                try {
                    dueDate = formatter.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException("Erreur lors du parsing de la date : " + date, e);
                }
            }
        }

        return new Todo(name, dueDate);
    }
}
