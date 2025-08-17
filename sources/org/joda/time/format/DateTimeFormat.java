package org.joda.time.format;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;
import p1.a;

public class DateTimeFormat {
    static final int DATE = 0;
    static final int DATETIME = 2;
    static final int FULL = 0;
    static final int LONG = 1;
    static final int MEDIUM = 2;
    static final int NONE = 4;
    private static final int PATTERN_CACHE_SIZE = 500;
    static final int SHORT = 3;
    static final int TIME = 1;
    private static final ConcurrentHashMap<String, DateTimeFormatter> cPatternCache = new ConcurrentHashMap<>();
    private static final AtomicReferenceArray<DateTimeFormatter> cStyleCache = new AtomicReferenceArray<>(25);

    static class StyleFormatterCacheKey {
        private final int combinedTypeAndStyle;
        private final Locale locale;

        public StyleFormatterCacheKey(int i2, int i3, int i4, Locale locale2) {
            this.locale = locale2;
            this.combinedTypeAndStyle = i2 + (i3 << 4) + (i4 << 8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof StyleFormatterCacheKey)) {
                return false;
            }
            StyleFormatterCacheKey styleFormatterCacheKey = (StyleFormatterCacheKey) obj;
            if (this.combinedTypeAndStyle != styleFormatterCacheKey.combinedTypeAndStyle) {
                return false;
            }
            Locale locale2 = this.locale;
            if (locale2 == null) {
                if (styleFormatterCacheKey.locale != null) {
                    return false;
                }
            } else if (!locale2.equals(styleFormatterCacheKey.locale)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3 = (this.combinedTypeAndStyle + 31) * 31;
            Locale locale2 = this.locale;
            if (locale2 == null) {
                i2 = 0;
            } else {
                i2 = locale2.hashCode();
            }
            return i3 + i2;
        }
    }

    protected DateTimeFormat() {
    }

    static void appendPatternTo(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        parsePatternTo(dateTimeFormatterBuilder, str);
    }

    private static DateTimeFormatter createDateTimeFormatter(int i2, int i3) {
        int i4;
        if (i2 == 4) {
            i4 = 1;
        } else if (i3 == 4) {
            i4 = 0;
        } else {
            i4 = 2;
        }
        StyleFormatter styleFormatter = new StyleFormatter(i2, i3, i4);
        return new DateTimeFormatter((InternalPrinter) styleFormatter, (InternalParser) styleFormatter);
    }

    private static DateTimeFormatter createFormatterForPattern(String str) {
        DateTimeFormatter putIfAbsent;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        ConcurrentHashMap<String, DateTimeFormatter> concurrentHashMap = cPatternCache;
        DateTimeFormatter dateTimeFormatter = concurrentHashMap.get(str);
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        parsePatternTo(dateTimeFormatterBuilder, str);
        DateTimeFormatter formatter = dateTimeFormatterBuilder.toFormatter();
        if (concurrentHashMap.size() >= 500 || (putIfAbsent = concurrentHashMap.putIfAbsent(str, formatter)) == null) {
            return formatter;
        }
        return putIfAbsent;
    }

    private static DateTimeFormatter createFormatterForStyle(String str) {
        if (str == null || str.length() != 2) {
            throw new IllegalArgumentException("Invalid style specification: " + str);
        }
        int selectStyle = selectStyle(str.charAt(0));
        int selectStyle2 = selectStyle(str.charAt(1));
        if (selectStyle != 4 || selectStyle2 != 4) {
            return createFormatterForStyleIndex(selectStyle, selectStyle2);
        }
        throw new IllegalArgumentException("Style '--' is invalid");
    }

    private static DateTimeFormatter createFormatterForStyleIndex(int i2, int i3) {
        int i4 = (i2 << 2) + i2 + i3;
        AtomicReferenceArray<DateTimeFormatter> atomicReferenceArray = cStyleCache;
        if (i4 >= atomicReferenceArray.length()) {
            return createDateTimeFormatter(i2, i3);
        }
        DateTimeFormatter dateTimeFormatter = atomicReferenceArray.get(i4);
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatter createDateTimeFormatter = createDateTimeFormatter(i2, i3);
        if (!a.a(atomicReferenceArray, i4, (Object) null, createDateTimeFormatter)) {
            return atomicReferenceArray.get(i4);
        }
        return createDateTimeFormatter;
    }

    public static DateTimeFormatter forPattern(String str) {
        return createFormatterForPattern(str);
    }

    public static DateTimeFormatter forStyle(String str) {
        return createFormatterForStyle(str);
    }

    public static DateTimeFormatter fullDate() {
        return createFormatterForStyleIndex(0, 4);
    }

    public static DateTimeFormatter fullDateTime() {
        return createFormatterForStyleIndex(0, 0);
    }

    public static DateTimeFormatter fullTime() {
        return createFormatterForStyleIndex(4, 0);
    }

    private static boolean isNumericToken(String str) {
        int length = str.length();
        if (length > 0) {
            switch (str.charAt(0)) {
                case 'C':
                case 'D':
                case 'F':
                case 'H':
                case 'K':
                case 'S':
                case 'W':
                case 'Y':
                case 'c':
                case 'd':
                case 'e':
                case 'h':
                case 'k':
                case 'm':
                case 's':
                case 'w':
                case 'x':
                case 'y':
                    break;
                case 'M':
                    if (length <= 2) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public static DateTimeFormatter longDate() {
        return createFormatterForStyleIndex(1, 4);
    }

    public static DateTimeFormatter longDateTime() {
        return createFormatterForStyleIndex(1, 1);
    }

    public static DateTimeFormatter longTime() {
        return createFormatterForStyleIndex(4, 1);
    }

    public static DateTimeFormatter mediumDate() {
        return createFormatterForStyleIndex(2, 4);
    }

    public static DateTimeFormatter mediumDateTime() {
        return createFormatterForStyleIndex(2, 2);
    }

    public static DateTimeFormatter mediumTime() {
        return createFormatterForStyleIndex(4, 2);
    }

    private static void parsePatternTo(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        boolean z2;
        int length = str.length();
        int[] iArr = new int[1];
        int i2 = 0;
        while (i2 < length) {
            iArr[0] = i2;
            String parseToken = parseToken(str, iArr);
            int i3 = iArr[0];
            int length2 = parseToken.length();
            if (length2 != 0) {
                char charAt = parseToken.charAt(0);
                if (charAt == '\'') {
                    String substring = parseToken.substring(1);
                    if (substring.length() == 1) {
                        dateTimeFormatterBuilder.appendLiteral(substring.charAt(0));
                    } else {
                        dateTimeFormatterBuilder.appendLiteral(new String(substring));
                    }
                } else if (charAt == 'K') {
                    dateTimeFormatterBuilder.appendHourOfHalfday(length2);
                } else if (charAt != 'M') {
                    if (charAt == 'S') {
                        dateTimeFormatterBuilder.appendFractionOfSecond(length2, length2);
                    } else if (charAt == 'a') {
                        dateTimeFormatterBuilder.appendHalfdayOfDayText();
                    } else if (charAt == 'h') {
                        dateTimeFormatterBuilder.appendClockhourOfHalfday(length2);
                    } else if (charAt == 'k') {
                        dateTimeFormatterBuilder.appendClockhourOfDay(length2);
                    } else if (charAt == 'm') {
                        dateTimeFormatterBuilder.appendMinuteOfHour(length2);
                    } else if (charAt == 's') {
                        dateTimeFormatterBuilder.appendSecondOfMinute(length2);
                    } else if (charAt == 'G') {
                        dateTimeFormatterBuilder.appendEraText();
                    } else if (charAt != 'H') {
                        if (charAt != 'Y') {
                            if (charAt != 'Z') {
                                if (charAt == 'd') {
                                    dateTimeFormatterBuilder.appendDayOfMonth(length2);
                                } else if (charAt != 'e') {
                                    switch (charAt) {
                                        case 'C':
                                            dateTimeFormatterBuilder.appendCenturyOfEra(length2, length2);
                                            continue;
                                        case 'D':
                                            dateTimeFormatterBuilder.appendDayOfYear(length2);
                                            continue;
                                        case 'E':
                                            if (length2 < 4) {
                                                dateTimeFormatterBuilder.appendDayOfWeekShortText();
                                                break;
                                            } else {
                                                dateTimeFormatterBuilder.appendDayOfWeekText();
                                                continue;
                                            }
                                        default:
                                            switch (charAt) {
                                                case 'w':
                                                    dateTimeFormatterBuilder.appendWeekOfWeekyear(length2);
                                                    continue;
                                                case 'x':
                                                case 'y':
                                                    break;
                                                case 'z':
                                                    if (length2 < 4) {
                                                        dateTimeFormatterBuilder.appendTimeZoneShortName((Map<String, DateTimeZone>) null);
                                                        break;
                                                    } else {
                                                        dateTimeFormatterBuilder.appendTimeZoneName();
                                                        continue;
                                                        continue;
                                                    }
                                                default:
                                                    throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                                            }
                                    }
                                } else {
                                    dateTimeFormatterBuilder.appendDayOfWeek(length2);
                                }
                            } else if (length2 == 1) {
                                dateTimeFormatterBuilder.appendTimeZoneOffset((String) null, "Z", false, 2, 2);
                            } else if (length2 == 2) {
                                dateTimeFormatterBuilder.appendTimeZoneOffset((String) null, "Z", true, 2, 2);
                            } else {
                                dateTimeFormatterBuilder.appendTimeZoneId();
                            }
                        }
                        if (length2 == 2) {
                            if (i3 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                z2 = !isNumericToken(parseToken(str, iArr));
                                iArr[0] = iArr[0] - 1;
                            } else {
                                z2 = true;
                            }
                            if (charAt != 'x') {
                                dateTimeFormatterBuilder.appendTwoDigitYear(new DateTime().getYear() - 30, z2);
                            } else {
                                dateTimeFormatterBuilder.appendTwoDigitWeekyear(new DateTime().getWeekyear() - 30, z2);
                            }
                        } else {
                            int i4 = 9;
                            if (i3 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                if (isNumericToken(parseToken(str, iArr))) {
                                    i4 = length2;
                                }
                                iArr[0] = iArr[0] - 1;
                            }
                            if (charAt == 'Y') {
                                dateTimeFormatterBuilder.appendYearOfEra(length2, i4);
                            } else if (charAt == 'x') {
                                dateTimeFormatterBuilder.appendWeekyear(length2, i4);
                            } else if (charAt == 'y') {
                                dateTimeFormatterBuilder.appendYear(length2, i4);
                            }
                        }
                    } else {
                        dateTimeFormatterBuilder.appendHourOfDay(length2);
                    }
                } else if (length2 < 3) {
                    dateTimeFormatterBuilder.appendMonthOfYear(length2);
                } else if (length2 >= 4) {
                    dateTimeFormatterBuilder.appendMonthOfYearText();
                } else {
                    dateTimeFormatterBuilder.appendMonthOfYearShortText();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private static String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i2);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= length || str.charAt(i3) != charAt) {
                    break;
                }
                sb.append(charAt);
                i2 = i3;
            }
        } else {
            sb.append('\'');
            boolean z2 = false;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                char charAt2 = str.charAt(i2);
                if (charAt2 == '\'') {
                    int i4 = i2 + 1;
                    if (i4 >= length || str.charAt(i4) != '\'') {
                        z2 = !z2;
                    } else {
                        sb.append(charAt2);
                        i2 = i4;
                    }
                } else if (z2 || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt2);
                }
                i2++;
            }
            i2--;
        }
        iArr[0] = i2;
        return sb.toString();
    }

    public static String patternForStyle(String str, Locale locale) {
        DateTimeFormatter createFormatterForStyle = createFormatterForStyle(str);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return ((StyleFormatter) createFormatterForStyle.getPrinter0()).getPattern(locale);
    }

    private static int selectStyle(char c2) {
        if (c2 == '-') {
            return 4;
        }
        if (c2 == 'F') {
            return 0;
        }
        if (c2 == 'S') {
            return 3;
        }
        if (c2 == 'L') {
            return 1;
        }
        if (c2 == 'M') {
            return 2;
        }
        throw new IllegalArgumentException("Invalid style character: " + c2);
    }

    public static DateTimeFormatter shortDate() {
        return createFormatterForStyleIndex(3, 4);
    }

    public static DateTimeFormatter shortDateTime() {
        return createFormatterForStyleIndex(3, 3);
    }

    public static DateTimeFormatter shortTime() {
        return createFormatterForStyleIndex(4, 3);
    }

    static class StyleFormatter implements InternalPrinter, InternalParser {
        private static final ConcurrentHashMap<StyleFormatterCacheKey, DateTimeFormatter> cCache = new ConcurrentHashMap<>();
        private final int iDateStyle;
        private final int iTimeStyle;
        private final int iType;

        StyleFormatter(int i2, int i3, int i4) {
            this.iDateStyle = i2;
            this.iTimeStyle = i3;
            this.iType = i4;
        }

        private DateTimeFormatter getFormatter(Locale locale) {
            if (locale == null) {
                locale = Locale.getDefault();
            }
            StyleFormatterCacheKey styleFormatterCacheKey = new StyleFormatterCacheKey(this.iType, this.iDateStyle, this.iTimeStyle, locale);
            ConcurrentHashMap<StyleFormatterCacheKey, DateTimeFormatter> concurrentHashMap = cCache;
            DateTimeFormatter dateTimeFormatter = concurrentHashMap.get(styleFormatterCacheKey);
            if (dateTimeFormatter != null) {
                return dateTimeFormatter;
            }
            DateTimeFormatter forPattern = DateTimeFormat.forPattern(getPattern(locale));
            DateTimeFormatter putIfAbsent = concurrentHashMap.putIfAbsent(styleFormatterCacheKey, forPattern);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return forPattern;
        }

        public int estimateParsedLength() {
            return 40;
        }

        public int estimatePrintedLength() {
            return 40;
        }

        /* access modifiers changed from: package-private */
        public String getPattern(Locale locale) {
            DateFormat dateFormat;
            int i2 = this.iType;
            if (i2 == 0) {
                dateFormat = DateFormat.getDateInstance(this.iDateStyle, locale);
            } else if (i2 == 1) {
                dateFormat = DateFormat.getTimeInstance(this.iTimeStyle, locale);
            } else if (i2 != 2) {
                dateFormat = null;
            } else {
                dateFormat = DateFormat.getDateTimeInstance(this.iDateStyle, this.iTimeStyle, locale);
            }
            if (dateFormat instanceof SimpleDateFormat) {
                return ((SimpleDateFormat) dateFormat).toPattern();
            }
            throw new IllegalArgumentException("No datetime pattern for locale: " + locale);
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            return getFormatter(dateTimeParserBucket.getLocale()).getParser0().parseInto(dateTimeParserBucket, charSequence, i2);
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            Locale locale2 = locale;
            getFormatter(locale2).getPrinter0().printTo(appendable, j2, chronology, i2, dateTimeZone, locale2);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            getFormatter(locale).getPrinter0().printTo(appendable, readablePartial, locale);
        }
    }
}
