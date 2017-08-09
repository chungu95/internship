package project_management.api;

import java.sql.Date;
import java.util.Calendar;

public class DateApi {
    public static Date getCurrentDate(){
        java.util.Date date = Calendar.getInstance().getTime();
        return new Date(date.getTime());
    }
}
