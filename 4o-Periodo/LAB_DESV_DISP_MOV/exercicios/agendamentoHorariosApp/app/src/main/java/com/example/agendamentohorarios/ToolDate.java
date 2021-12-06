package com.example.agendamentohorarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author italo
 */

public class ToolDate {

    public static final String DATA = "dd/MM/yyyy";
    public static final String HORA = "HH:MM";
    public static final String DATA_COMPLETA = "dd/MM/yyyy HH:MM";
    public static final String DATA_STRING_FORMAT = "%02d/%02d/%04d";
    public static final String HOUR_STRING_FORMAT = "%02d:%02d";

    public static String makeDateString(int year, int month, int day) {
        return String.format(Locale.getDefault(), DATA_STRING_FORMAT, day, month, year);
    }

    public static String makeHourString(int hour, int minutes) {
        return String.format(Locale.getDefault(), HOUR_STRING_FORMAT, hour, minutes);
    }

    public static String[] splitDate(String date) {
        return date.split("/");
    }

    public static String[] splitHours(String hours) {
        return hours.split(":");
    }

    public static Calendar strDateToCalendar(String date) {
        String[] att = splitDate(date);

        int dia = Integer.parseInt(att[0]);
        int mes = Integer.parseInt(att[1]) - 1;
        int ano = Integer.parseInt(att[2]);

        Calendar c = Calendar.getInstance();
        c.set(ano, mes, dia);

        return c;
    }

    public static Date strToDateComplete(String data, String hours) {
        String[] att = splitHours(hours);

        int hora = Integer.parseInt(att[0]);
        int min = Integer.parseInt(att[1]);

        Calendar c = strDateToCalendar(data);
        c.set(Calendar.HOUR_OF_DAY, hora);
        c.set(Calendar.MINUTE, min);

        return c.getTime();
    }

    public static String dateToStr(Date dt, String pattern) {
        return new SimpleDateFormat(pattern).format(dt);
    }
}
