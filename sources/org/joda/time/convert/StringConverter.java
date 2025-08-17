package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.ReadWritableInterval;
import org.joda.time.ReadWritablePeriod;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

class StringConverter extends AbstractConverter implements InstantConverter, PartialConverter, DurationConverter, PeriodConverter, IntervalConverter {
    static final StringConverter INSTANCE = new StringConverter();

    protected StringConverter() {
    }

    public long getDurationMillis(Object obj) {
        long j2;
        long j3;
        long j4;
        String str = (String) obj;
        int length = str.length();
        if (length >= 4 && ((str.charAt(0) == 'P' || str.charAt(0) == 'p') && (str.charAt(1) == 'T' || str.charAt(1) == 't'))) {
            int i2 = length - 1;
            if (str.charAt(i2) == 'S' || str.charAt(i2) == 's') {
                String substring = str.substring(2, i2);
                int i3 = 0;
                int i4 = -1;
                for (int i5 = 0; i5 < substring.length(); i5++) {
                    if (substring.charAt(i5) < '0' || substring.charAt(i5) > '9') {
                        if (i5 == 0 && substring.charAt(0) == '-') {
                            i3 = 1;
                        } else if (i5 > i3 && substring.charAt(i5) == '.' && i4 == -1) {
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
                        }
                    }
                }
                if (i4 > 0) {
                    j2 = Long.parseLong(substring.substring(i3, i4));
                    String substring2 = substring.substring(i4 + 1);
                    if (substring2.length() != 3) {
                        substring2 = (substring2 + "000").substring(0, 3);
                    }
                    j3 = (long) Integer.parseInt(substring2);
                } else {
                    if (i3 != 0) {
                        j4 = Long.parseLong(substring.substring(i3, substring.length()));
                    } else {
                        j4 = Long.parseLong(substring);
                    }
                    j3 = 0;
                    j2 = j4;
                }
                if (i3 != 0) {
                    return FieldUtils.safeAdd(FieldUtils.safeMultiply(-j2, 1000), -j3);
                }
                return FieldUtils.safeAdd(FieldUtils.safeMultiply(j2, 1000), j3);
            }
        }
        throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
    }

    public long getInstantMillis(Object obj, Chronology chronology) {
        return ISODateTimeFormat.dateTimeParser().withChronology(chronology).parseMillis((String) obj);
    }

    public int[] getPartialValues(ReadablePartial readablePartial, Object obj, Chronology chronology, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter.getZone() != null) {
            chronology = chronology.withZone(dateTimeFormatter.getZone());
        }
        return chronology.get(readablePartial, dateTimeFormatter.withChronology(chronology).parseMillis((String) obj));
    }

    public Class<?> getSupportedType() {
        return String.class;
    }

    public void setInto(ReadWritablePeriod readWritablePeriod, Object obj, Chronology chronology) {
        String str = (String) obj;
        PeriodFormatter standard = ISOPeriodFormat.standard();
        readWritablePeriod.clear();
        int parseInto = standard.parseInto(readWritablePeriod, str, 0);
        if (parseInto < str.length()) {
            if (parseInto < 0) {
                standard.withParseType(readWritablePeriod.getPeriodType()).parseMutablePeriod(str);
            }
            throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
        }
    }

    public void setInto(ReadWritableInterval readWritableInterval, Object obj, Chronology chronology) {
        long j2;
        Period period;
        long j3;
        ReadWritableInterval readWritableInterval2 = readWritableInterval;
        Chronology chronology2 = chronology;
        String str = (String) obj;
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            if (substring.length() > 0) {
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    DateTimeFormatter withChronology = ISODateTimeFormat.dateTimeParser().withChronology(chronology2);
                    PeriodFormatter standard = ISOPeriodFormat.standard();
                    char charAt = substring.charAt(0);
                    Chronology chronology3 = null;
                    if (charAt == 'P' || charAt == 'p') {
                        period = standard.withParseType(getPeriodType(substring)).parsePeriod(substring);
                        j2 = 0;
                    } else {
                        DateTime parseDateTime = withChronology.parseDateTime(substring);
                        j2 = parseDateTime.getMillis();
                        chronology3 = parseDateTime.getChronology();
                        period = null;
                    }
                    char charAt2 = substring2.charAt(0);
                    if (charAt2 != 'P' && charAt2 != 'p') {
                        DateTime parseDateTime2 = withChronology.parseDateTime(substring2);
                        j3 = parseDateTime2.getMillis();
                        if (chronology3 == null) {
                            chronology3 = parseDateTime2.getChronology();
                        }
                        if (chronology2 != null) {
                            chronology3 = chronology2;
                        }
                        if (period != null) {
                            j2 = chronology3.add((ReadablePeriod) period, j3, -1);
                        }
                    } else if (period == null) {
                        Period parsePeriod = standard.withParseType(getPeriodType(substring2)).parsePeriod(substring2);
                        if (chronology2 != null) {
                            chronology3 = chronology2;
                        }
                        j3 = chronology3.add((ReadablePeriod) parsePeriod, j2, 1);
                    } else {
                        throw new IllegalArgumentException("Interval composed of two durations: " + str);
                    }
                    readWritableInterval2.setInterval(j2, j3);
                    readWritableInterval2.setChronology(chronology3);
                    return;
                }
                throw new IllegalArgumentException("Format invalid: " + str);
            }
            throw new IllegalArgumentException("Format invalid: " + str);
        }
        throw new IllegalArgumentException("Format requires a '/' separator: " + str);
    }
}
