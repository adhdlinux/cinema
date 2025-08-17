package com.original.tase.helper;

import com.original.tase.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;

public class DateTimeHelper {
    public static boolean a(String str) {
        return !f(j(str, "MMM dd, yyyy HH:mm:ss a"));
    }

    public static String b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        try {
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat2.format(parse);
        } catch (ParseException unused) {
            return str;
        }
    }

    public static String c(long j2) {
        try {
            Calendar instance = Calendar.getInstance();
            TimeZone timeZone = TimeZone.getDefault();
            instance.setTimeInMillis(1000 * j2);
            instance.add(14, timeZone.getOffset(instance.getTimeInMillis()));
            Date time = instance.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat.format(time);
        } catch (Throwable unused) {
            return "" + j2;
        }
    }

    public static String d(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            Calendar instance = Calendar.getInstance();
            TimeZone timeZone = TimeZone.getDefault();
            instance.setTimeInMillis(valueOf.longValue() * 1000);
            instance.add(14, timeZone.getOffset(instance.getTimeInMillis()));
            Date time = instance.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat.format(time);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static long e() {
        try {
            return new Date().getTime();
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return 0;
        }
    }

    public static boolean f(DateTime dateTime) {
        if (dateTime == null) {
            return true;
        }
        DateTime dateTime2 = DateTime.now().toDateTime(DateTimeZone.forID("UTC"));
        if (dateTime.isBefore((ReadableInstant) dateTime2) || dateTime.isEqual((ReadableInstant) dateTime2)) {
            return true;
        }
        return false;
    }

    public static String g() {
        try {
            return String.valueOf(new Date().getTime());
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return "";
        }
    }

    public static String h(DateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toString(DateTimeFormat.forPattern("yyyy-MM-dd"));
    }

    public static DateTime i(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(str);
    }

    public static DateTime j(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return DateTimeFormat.forPattern(str2).parseDateTime(str);
    }
}
