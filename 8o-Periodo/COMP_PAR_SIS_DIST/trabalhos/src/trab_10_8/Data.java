package trab_10_8;

import java.util.Calendar;
import java.util.Date;

public class Data {

    Date date;

    public Data(Object date) {
        this.date = this.castDate(date);
    }

    private Date castDate(Object rawDate) {
        Date fallbackDate = new Date("01/01/0001");

        if (rawDate instanceof String) {
            return new Date((String) rawDate);
        }

        if (rawDate instanceof Long) {
            return new Date((Long) rawDate);
        }

        if (rawDate instanceof Date) return (Date) rawDate;

        return fallbackDate;
    }

    public Date get() {return this.date;}

    public int compare(Data otherDate) {
        return get().compareTo(otherDate.get());
    }

    public int getDia() {
        return get().getDay();
    }

    public int getMes() {
        return get().getMonth();
    }

    

}
