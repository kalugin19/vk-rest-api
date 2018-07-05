package ru.kalugin19.vkmessenger.android.pub.v1.ui.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Класс для работы со временем
 *
 * @author Gusev Andrey
 */
public class SimpleDateFormatter {

    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static final String SHORT_TIME_FORMAT = "HH:mm";

    /**
     * Форматирование даты по формату dd.MM.yyyy
     *
     * @param calendar - дата которую нужно отформатировать
     * @return отформатированная дата или пустая строка, емли преобразование не удалось
     */
    public static String formatByDatePattern(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        return sdf.format(calendar.getTime());
    }

    /**
     * Форматирование даты по формату HH:mm
     *
     * @param calendar - дата которую нужно отформатировать
     * @return отформатированная дата или пустая строка, емли преобразование не удалось
     */
    public static String formatByShortTimePattern(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(SHORT_TIME_FORMAT, Locale.getDefault());
        return sdf.format(calendar.getTime());
    }
}
