package org.threeten.bp.chrono;

import com.google.android.gms.ads.RequestConfiguration;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseChronology extends Chronology implements Serializable {
    private static final Map<String, String[]> ERA_FULL_NAMES;
    private static final Map<String, String[]> ERA_NARROW_NAMES;
    private static final Map<String, String[]> ERA_SHORT_NAMES;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();
    static final Locale LOCALE = new Locale(TARGET_LANGUAGE, "JP", "JP");
    private static final String TARGET_LANGUAGE = "ja";
    private static final long serialVersionUID = 459996390165777884L;

    /* renamed from: org.threeten.bp.chrono.JapaneseChronology$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x006c }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_DAY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x009c }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.NANO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00e4 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00f0 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00fc }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0108 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0114 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.JapaneseChronology.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        ERA_NARROW_NAMES = hashMap;
        HashMap hashMap2 = new HashMap();
        ERA_SHORT_NAMES = hashMap2;
        HashMap hashMap3 = new HashMap();
        ERA_FULL_NAMES = hashMap3;
        hashMap.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "K", "M", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "S", "H"});
        hashMap.put(TARGET_LANGUAGE, new String[]{"Unknown", "K", "M", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "S", "H"});
        hashMap2.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "K", "M", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "S", "H"});
        hashMap2.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        hashMap3.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        hashMap3.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private JapaneseDate resolveEYD(Map<TemporalField, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i2) {
        if (resolverStyle == ResolverStyle.LENIENT) {
            return dateYearDay((japaneseEra.startDate().getYear() + i2) - 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(ChronoField.DAY_OF_YEAR).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.DAY_OF_YEAR;
        return dateYearDay((Era) japaneseEra, i2, range(chronoField).checkValidIntValue(map.remove(chronoField).longValue(), chronoField));
    }

    private JapaneseDate resolveEYMD(Map<TemporalField, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i2) {
        if (resolverStyle == ResolverStyle.LENIENT) {
            long safeSubtract = Jdk8Methods.safeSubtract(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
            return date((japaneseEra.startDate().getYear() + i2) - 1, 1, 1).plus(safeSubtract, (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(ChronoField.DAY_OF_MONTH).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(map.remove(chronoField).longValue(), chronoField);
        ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(map.remove(chronoField2).longValue(), chronoField2);
        if (resolverStyle != ResolverStyle.SMART) {
            return date((Era) japaneseEra, i2, checkValidIntValue, checkValidIntValue2);
        }
        if (i2 >= 1) {
            int year = (japaneseEra.startDate().getYear() + i2) - 1;
            if (checkValidIntValue2 > 28) {
                checkValidIntValue2 = Math.min(checkValidIntValue2, date(year, checkValidIntValue, 1).lengthOfMonth());
            }
            JapaneseDate date = date(year, checkValidIntValue, checkValidIntValue2);
            if (date.getEra() != japaneseEra) {
                if (Math.abs(date.getEra().getValue() - japaneseEra.getValue()) > 1) {
                    throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + " " + i2);
                } else if (!(date.get(ChronoField.YEAR_OF_ERA) == 1 || i2 == 1)) {
                    throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + " " + i2);
                }
            }
            return date;
        }
        throw new DateTimeException("Invalid YearOfEra: " + i2);
    }

    public List<Era> eras() {
        return Arrays.asList(JapaneseEra.values());
    }

    public String getCalendarType() {
        return "japanese";
    }

    public String getId() {
        return "Japanese";
    }

    public boolean isLeapYear(long j2) {
        return IsoChronology.INSTANCE.isLeapYear(j2);
    }

    public ChronoLocalDateTime<JapaneseDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    public int prolepticYear(Era era, int i2) {
        if (era instanceof JapaneseEra) {
            JapaneseEra japaneseEra = (JapaneseEra) era;
            int year = (japaneseEra.startDate().getYear() + i2) - 1;
            ValueRange.of(1, (long) ((japaneseEra.endDate().getYear() - japaneseEra.startDate().getYear()) + 1)).checkValidValue((long) i2, ChronoField.YEAR_OF_ERA);
            return year;
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public ValueRange range(ChronoField chronoField) {
        int[] iArr = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField;
        switch (iArr[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return chronoField.range();
            default:
                Calendar instance = Calendar.getInstance(LOCALE);
                int i2 = 0;
                switch (iArr[chronoField.ordinal()]) {
                    case 19:
                        JapaneseEra[] values = JapaneseEra.values();
                        return ValueRange.of((long) values[0].getValue(), (long) values[values.length - 1].getValue());
                    case 20:
                        JapaneseEra[] values2 = JapaneseEra.values();
                        return ValueRange.of((long) JapaneseDate.MIN_DATE.getYear(), (long) values2[values2.length - 1].endDate().getYear());
                    case 21:
                        JapaneseEra[] values3 = JapaneseEra.values();
                        int year = (values3[values3.length - 1].endDate().getYear() - values3[values3.length - 1].startDate().getYear()) + 1;
                        int i3 = Integer.MAX_VALUE;
                        while (i2 < values3.length) {
                            i3 = Math.min(i3, (values3[i2].endDate().getYear() - values3[i2].startDate().getYear()) + 1);
                            i2++;
                        }
                        return ValueRange.of(1, 6, (long) i3, (long) year);
                    case 22:
                        return ValueRange.of((long) (instance.getMinimum(2) + 1), (long) (instance.getGreatestMinimum(2) + 1), (long) (instance.getLeastMaximum(2) + 1), (long) (instance.getMaximum(2) + 1));
                    case 23:
                        JapaneseEra[] values4 = JapaneseEra.values();
                        int i4 = 366;
                        while (i2 < values4.length) {
                            i4 = Math.min(i4, (values4[i2].startDate().lengthOfYear() - values4[i2].startDate().getDayOfYear()) + 1);
                            i2++;
                        }
                        return ValueRange.of(1, (long) i4, 366);
                    default:
                        throw new UnsupportedOperationException("Unimplementable field: " + chronoField);
                }
        }
    }

    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    public JapaneseDate dateEpochDay(long j2) {
        return new JapaneseDate(LocalDate.ofEpochDay(j2));
    }

    public JapaneseEra eraOf(int i2) {
        return JapaneseEra.of(i2);
    }

    public JapaneseDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return dateEpochDay(map.remove(chronoField).longValue());
        }
        ChronoField chronoField2 = ChronoField.PROLEPTIC_MONTH;
        Long remove = map.remove(chronoField2);
        if (remove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField2.checkValidValue(remove.longValue());
            }
            updateResolveMap(map, ChronoField.MONTH_OF_YEAR, (long) (Jdk8Methods.floorMod(remove.longValue(), 12) + 1));
            updateResolveMap(map, ChronoField.YEAR, Jdk8Methods.floorDiv(remove.longValue(), 12));
        }
        ChronoField chronoField3 = ChronoField.ERA;
        Long l2 = map.get(chronoField3);
        JapaneseEra eraOf = l2 != null ? eraOf(range(chronoField3).checkValidIntValue(l2.longValue(), chronoField3)) : null;
        ChronoField chronoField4 = ChronoField.YEAR_OF_ERA;
        Long l3 = map.get(chronoField4);
        if (l3 != null) {
            int checkValidIntValue = range(chronoField4).checkValidIntValue(l3.longValue(), chronoField4);
            if (eraOf == null && resolverStyle != ResolverStyle.STRICT && !map.containsKey(ChronoField.YEAR)) {
                List<Era> eras = eras();
                eraOf = (JapaneseEra) eras.get(eras.size() - 1);
            }
            if (eraOf != null && map.containsKey(ChronoField.MONTH_OF_YEAR) && map.containsKey(ChronoField.DAY_OF_MONTH)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return resolveEYMD(map, resolverStyle, eraOf, checkValidIntValue);
            } else if (eraOf != null && map.containsKey(ChronoField.DAY_OF_YEAR)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return resolveEYD(map, resolverStyle, eraOf, checkValidIntValue);
            }
        }
        ChronoField chronoField5 = ChronoField.YEAR;
        if (map.containsKey(chronoField5)) {
            ChronoField chronoField6 = ChronoField.MONTH_OF_YEAR;
            if (map.containsKey(chronoField6)) {
                ChronoField chronoField7 = ChronoField.DAY_OF_MONTH;
                if (map.containsKey(chronoField7)) {
                    int checkValidIntValue2 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue2, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField6).longValue(), 1)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1));
                    }
                    int checkValidIntValue3 = range(chronoField6).checkValidIntValue(map.remove(chronoField6).longValue(), chronoField6);
                    int checkValidIntValue4 = range(chronoField7).checkValidIntValue(map.remove(chronoField7).longValue(), chronoField7);
                    if (resolverStyle == ResolverStyle.SMART && checkValidIntValue4 > 28) {
                        checkValidIntValue4 = Math.min(checkValidIntValue4, date(checkValidIntValue2, checkValidIntValue3, 1).lengthOfMonth());
                    }
                    return date(checkValidIntValue2, checkValidIntValue3, checkValidIntValue4);
                }
                ChronoField chronoField8 = ChronoField.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(chronoField8)) {
                    ChronoField chronoField9 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(chronoField9)) {
                        int checkValidIntValue5 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            long safeSubtract = Jdk8Methods.safeSubtract(map.remove(chronoField6).longValue(), 1);
                            return date(checkValidIntValue5, 1, 1).plus(safeSubtract, (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField8).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
                        }
                        int checkValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        JapaneseDate plus = date(checkValidIntValue5, checkValidIntValue6, 1).plus((long) (((chronoField8.checkValidIntValue(map.remove(chronoField8).longValue()) - 1) * 7) + (chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1)), (TemporalUnit) ChronoUnit.DAYS);
                        if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField6) == checkValidIntValue6) {
                            return plus;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                    ChronoField chronoField10 = ChronoField.DAY_OF_WEEK;
                    if (map.containsKey(chronoField10)) {
                        int checkValidIntValue7 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            long safeSubtract2 = Jdk8Methods.safeSubtract(map.remove(chronoField6).longValue(), 1);
                            return date(checkValidIntValue7, 1, 1).plus(safeSubtract2, (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField8).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField10).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
                        }
                        int checkValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        JapaneseDate with = date(checkValidIntValue7, checkValidIntValue8, 1).plus((long) (chronoField8.checkValidIntValue(map.remove(chronoField8).longValue()) - 1), (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()))));
                        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField6) == checkValidIntValue8) {
                            return with;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                }
            }
            ChronoField chronoField11 = ChronoField.DAY_OF_YEAR;
            if (map.containsKey(chronoField11)) {
                int checkValidIntValue9 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                if (resolverStyle != ResolverStyle.LENIENT) {
                    return dateYearDay(checkValidIntValue9, chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()));
                }
                return dateYearDay(checkValidIntValue9, 1).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField11).longValue(), 1));
            }
            ChronoField chronoField12 = ChronoField.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(chronoField12)) {
                ChronoField chronoField13 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(chronoField13)) {
                    int checkValidIntValue10 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue10, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    JapaneseDate plusDays = date(checkValidIntValue10, 1, 1).plusDays((long) (((chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()) - 1) * 7) + (chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1)));
                    if (resolverStyle != ResolverStyle.STRICT || plusDays.get(chronoField5) == checkValidIntValue10) {
                        return plusDays;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                ChronoField chronoField14 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField14)) {
                    int checkValidIntValue11 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue11, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField14).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    JapaneseDate with2 = date(checkValidIntValue11, 1, 1).plus((long) (chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()) - 1), (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField5) == checkValidIntValue11) {
                        return with2;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        return null;
    }

    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    public JapaneseDate dateYearDay(Era era, int i2, int i3) {
        if (era instanceof JapaneseEra) {
            return JapaneseDate.ofYearDay((JapaneseEra) era, i2, i3);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public JapaneseDate date(Era era, int i2, int i3, int i4) {
        if (era instanceof JapaneseEra) {
            return JapaneseDate.of((JapaneseEra) era, i2, i3, i4);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public JapaneseDate dateNow() {
        return (JapaneseDate) super.dateNow();
    }

    public JapaneseDate dateNow(ZoneId zoneId) {
        return (JapaneseDate) super.dateNow(zoneId);
    }

    public JapaneseDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return (JapaneseDate) super.dateNow(clock);
    }

    public JapaneseDate dateYearDay(int i2, int i3) {
        LocalDate ofYearDay = LocalDate.ofYearDay(i2, i3);
        return date(i2, ofYearDay.getMonthValue(), ofYearDay.getDayOfMonth());
    }

    public JapaneseDate date(int i2, int i3, int i4) {
        return new JapaneseDate(LocalDate.of(i2, i3, i4));
    }

    public JapaneseDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof JapaneseDate) {
            return (JapaneseDate) temporalAccessor;
        }
        return new JapaneseDate(LocalDate.from(temporalAccessor));
    }
}
