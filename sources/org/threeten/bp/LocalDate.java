package org.threeten.bp;

import com.facebook.common.time.Clock;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

public final class LocalDate extends ChronoLocalDate implements Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    public static final TemporalQuery<LocalDate> FROM = new TemporalQuery<LocalDate>() {
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            return LocalDate.from(temporalAccessor);
        }
    };
    public static final LocalDate MAX = of((int) Year.MAX_VALUE, 12, 31);
    public static final LocalDate MIN = of((int) Year.MIN_VALUE, 1, 1);
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;

    /* renamed from: org.threeten.bp.LocalDate$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00cf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e7 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r7 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r8 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoUnit r9 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                org.threeten.bp.temporal.ChronoField[] r8 = org.threeten.bp.temporal.ChronoField.values()
                int r8 = r8.length
                int[] r8 = new int[r8]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r8
                org.threeten.bp.temporal.ChronoField r9 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r8[r9] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x007b }
                org.threeten.bp.temporal.ChronoField r8 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x007b }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r8] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0085 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x008f }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0099 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00a3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00ad }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00b7 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00c3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00cf }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00cf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cf }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cf }
            L_0x00cf:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00db }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x00db }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00e7 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x00e7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e7 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e7 }
            L_0x00e7:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00f3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDate.AnonymousClass2.<clinit>():void");
        }
    }

    private LocalDate(int i2, int i3, int i4) {
        this.year = i2;
        this.month = (short) i3;
        this.day = (short) i4;
    }

    private static LocalDate create(int i2, Month month2, int i3) {
        if (i3 <= 28 || i3 <= month2.length(IsoChronology.INSTANCE.isLeapYear((long) i2))) {
            return new LocalDate(i2, month2.getValue(), i3);
        }
        if (i3 == 29) {
            throw new DateTimeException("Invalid date 'February 29' as '" + i2 + "' is not a leap year");
        }
        throw new DateTimeException("Invalid date '" + month2.name() + " " + i3 + "'");
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i2 = this.year;
                if (i2 >= 1) {
                    return i2;
                }
                return 1 - i2;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 12:
                return this.year;
            case 13:
                if (this.year >= 1) {
                    return 1;
                }
                return 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    private long monthsUntil(LocalDate localDate) {
        return (((localDate.getProlepticMonth() * 32) + ((long) localDate.getDayOfMonth())) - ((getProlepticMonth() * 32) + ((long) getDayOfMonth()))) / 32;
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate of(int i2, Month month2, int i3) {
        ChronoField.YEAR.checkValidValue((long) i2);
        Jdk8Methods.requireNonNull(month2, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i3);
        return create(i2, month2, i3);
    }

    public static LocalDate ofEpochDay(long j2) {
        long j3;
        long j4 = j2;
        ChronoField.EPOCH_DAY.checkValidValue(j4);
        long j5 = (j4 + DAYS_0000_TO_1970) - 60;
        if (j5 < 0) {
            long j6 = ((j5 + 1) / 146097) - 1;
            j3 = j6 * 400;
            j5 += (-j6) * 146097;
        } else {
            j3 = 0;
        }
        long j7 = ((j5 * 400) + 591) / 146097;
        long j8 = j5 - ((((j7 * 365) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        if (j8 < 0) {
            j7--;
            j8 = j5 - ((((365 * j7) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        }
        int i2 = (int) j8;
        int i3 = ((i2 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j7 + j3 + ((long) (i3 / 10))), ((i3 + 2) % 12) + 1, (i2 - (((i3 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int i2, int i3) {
        long j2 = (long) i2;
        ChronoField.YEAR.checkValidValue(j2);
        ChronoField.DAY_OF_YEAR.checkValidValue((long) i3);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j2);
        if (i3 != 366 || isLeapYear) {
            Month of = Month.of(((i3 - 1) / 31) + 1);
            if (i3 > (of.firstDayOfYear(isLeapYear) + of.length(isLeapYear)) - 1) {
                of = of.plus(1);
            }
            return create(i2, of, (i3 - of.firstDayOfYear(isLeapYear)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
    }

    public static LocalDate parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    static LocalDate readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int i2, int i3, int i4) {
        int i5;
        if (i3 == 2) {
            if (IsoChronology.INSTANCE.isLeapYear((long) i2)) {
                i5 = 29;
            } else {
                i5 = 28;
            }
            i4 = Math.min(i4, i5);
        } else if (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) {
            i4 = Math.min(i4, 30);
        }
        return of(i2, i3, i4);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    /* access modifiers changed from: package-private */
    public int compareTo0(LocalDate localDate) {
        int i2 = this.year - localDate.year;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.month - localDate.month;
        if (i3 == 0) {
            return this.day - localDate.day;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public long daysUntil(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDate) || compareTo0((LocalDate) obj) != 0) {
            return false;
        }
        return true;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return get0(temporalField);
        }
        return super.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(Jdk8Methods.floorMod(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    public Era getEra() {
        return super.getEra();
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        if (temporalField == ChronoField.EPOCH_DAY) {
            return toEpochDay();
        }
        if (temporalField == ChronoField.PROLEPTIC_MONTH) {
            return getProlepticMonth();
        }
        return (long) get0(temporalField);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int hashCode() {
        int i2 = this.year;
        return (((i2 << 11) + (this.month << 6)) + this.day) ^ (i2 & -2048);
    }

    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        if (!(chronoLocalDate instanceof LocalDate)) {
            return super.isAfter(chronoLocalDate);
        }
        if (compareTo0((LocalDate) chronoLocalDate) > 0) {
            return true;
        }
        return false;
    }

    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        if (!(chronoLocalDate instanceof LocalDate)) {
            return super.isBefore(chronoLocalDate);
        }
        if (compareTo0((LocalDate) chronoLocalDate) < 0) {
            return true;
        }
        return false;
    }

    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        if (!(chronoLocalDate instanceof LocalDate)) {
            return super.isEqual(chronoLocalDate);
        }
        if (compareTo0((LocalDate) chronoLocalDate) == 0) {
            return true;
        }
        return false;
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear((long) this.year);
    }

    public boolean isSupported(TemporalField temporalField) {
        return super.isSupported(temporalField);
    }

    public int lengthOfMonth() {
        short s2 = this.month;
        if (s2 != 2) {
            if (s2 == 4 || s2 == 6 || s2 == 9 || s2 == 11) {
                return 30;
            }
            return 31;
        } else if (isLeapYear()) {
            return 29;
        } else {
            return 28;
        }
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public LocalDate minusDays(long j2) {
        return j2 == Long.MIN_VALUE ? plusDays(Clock.MAX_TIME).plusDays(1) : plusDays(-j2);
    }

    public LocalDate minusMonths(long j2) {
        return j2 == Long.MIN_VALUE ? plusMonths(Clock.MAX_TIME).plusMonths(1) : plusMonths(-j2);
    }

    public LocalDate minusWeeks(long j2) {
        return j2 == Long.MIN_VALUE ? plusWeeks(Clock.MAX_TIME).plusWeeks(1) : plusWeeks(-j2);
    }

    public LocalDate minusYears(long j2) {
        return j2 == Long.MIN_VALUE ? plusYears(Clock.MAX_TIME).plusYears(1) : plusYears(-j2);
    }

    public LocalDate plusDays(long j2) {
        if (j2 == 0) {
            return this;
        }
        return ofEpochDay(Jdk8Methods.safeAdd(toEpochDay(), j2));
    }

    public LocalDate plusMonths(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.year) * 12) + ((long) (this.month - 1)) + j2;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(j3, 12)), Jdk8Methods.floorMod(j3, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long j2) {
        return plusDays(Jdk8Methods.safeMultiply(j2, 7));
    }

    public LocalDate plusYears(long j2) {
        if (j2 == 0) {
            return this;
        }
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j2), this.month, this.day);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.localDate()) {
            return this;
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        long j2;
        long j3;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (chronoField.isDateBased()) {
            int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i2 == 1) {
                return ValueRange.of(1, (long) lengthOfMonth());
            }
            if (i2 == 2) {
                return ValueRange.of(1, (long) lengthOfYear());
            }
            if (i2 == 3) {
                if (getMonth() != Month.FEBRUARY || isLeapYear()) {
                    j2 = 5;
                } else {
                    j2 = 4;
                }
                return ValueRange.of(1, j2);
            } else if (i2 != 4) {
                return temporalField.range();
            } else {
                if (getYear() <= 0) {
                    j3 = 1000000000;
                } else {
                    j3 = 999999999;
                }
                return ValueRange.of(1, j3);
            }
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public long toEpochDay() {
        long j2;
        long j3 = (long) this.year;
        long j4 = (long) this.month;
        long j5 = (365 * j3) + 0;
        if (j3 >= 0) {
            j2 = j5 + (((3 + j3) / 4) - ((99 + j3) / 100)) + ((j3 + 399) / 400);
        } else {
            j2 = j5 - (((j3 / -4) - (j3 / -100)) + (j3 / -400));
        }
        long j6 = j2 + (((367 * j4) - 362) / 12) + ((long) (this.day - 1));
        if (j4 > 2) {
            j6--;
            if (!isLeapYear()) {
                j6--;
            }
        }
        return j6 - DAYS_0000_TO_1970;
    }

    public String toString() {
        String str;
        int i2 = this.year;
        short s2 = this.month;
        short s3 = this.day;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        } else if (i2 < 0) {
            sb.append(i2 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i2 + 10000);
            sb.deleteCharAt(0);
        }
        String str2 = "-0";
        if (s2 < 10) {
            str = str2;
        } else {
            str = "-";
        }
        sb.append(str);
        sb.append(s2);
        if (s3 >= 10) {
            str2 = "-";
        }
        sb.append(str2);
        sb.append(s3);
        return sb.toString();
    }

    public LocalDate withDayOfMonth(int i2) {
        if (this.day == i2) {
            return this;
        }
        return of(this.year, (int) this.month, i2);
    }

    public LocalDate withDayOfYear(int i2) {
        if (getDayOfYear() == i2) {
            return this;
        }
        return ofYearDay(this.year, i2);
    }

    public LocalDate withMonth(int i2) {
        if (this.month == i2) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i2);
        return resolvePreviousValid(this.year, i2, this.day);
    }

    public LocalDate withYear(int i2) {
        if (this.year == i2) {
            return this;
        }
        ChronoField.YEAR.checkValidValue((long) i2);
        return resolvePreviousValid(i2, this.month, this.day);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public static LocalDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, FROM);
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        ZoneOffsetTransition transition;
        Jdk8Methods.requireNonNull(zoneId, "zone");
        LocalDateTime atTime = atTime(LocalTime.MIDNIGHT);
        if (!(zoneId instanceof ZoneOffset) && (transition = zoneId.getRules().getTransition(atTime)) != null && transition.isGap()) {
            atTime = transition.getDateTimeAfter();
        }
        return ZonedDateTime.of(atTime, zoneId);
    }

    public LocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    public int compareTo(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate);
        }
        return super.compareTo(chronoLocalDate);
    }

    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return daysUntil(from);
            case 2:
                return daysUntil(from) / 7;
            case 3:
                return monthsUntil(from);
            case 4:
                return monthsUntil(from) / 12;
            case 5:
                return monthsUntil(from) / 120;
            case 6:
                return monthsUntil(from) / 1200;
            case 7:
                return monthsUntil(from) / 12000;
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public static LocalDate now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        return ofEpochDay(Jdk8Methods.floorDiv(instant.getEpochSecond() + ((long) clock.getZone().getRules().getOffset(instant).getTotalSeconds()), 86400));
    }

    public LocalDateTime atTime(int i2, int i3) {
        return atTime(LocalTime.of(i2, i3));
    }

    public LocalDateTime atTime(int i2, int i3, int i4) {
        return atTime(LocalTime.of(i2, i3, i4));
    }

    public static LocalDate of(int i2, int i3, int i4) {
        ChronoField.YEAR.checkValidValue((long) i2);
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i3);
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i4);
        return create(i2, Month.of(i3), i4);
    }

    public LocalDateTime atTime(int i2, int i3, int i4, int i5) {
        return atTime(LocalTime.of(i2, i3, i4, i5));
    }

    public LocalDate minus(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.subtractFrom(this);
    }

    public LocalDate plus(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.addTo(this);
    }

    public LocalDate with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return (LocalDate) temporalAdjuster;
        }
        return (LocalDate) temporalAdjuster.adjustInto(this);
    }

    public OffsetDateTime atTime(OffsetTime offsetTime) {
        return OffsetDateTime.of(LocalDateTime.of(this, offsetTime.toLocalTime()), offsetTime.getOffset());
    }

    public LocalDate minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus((long) Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }

    public LocalDate plus(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.addTo(this, j2);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusDays(j2);
            case 2:
                return plusWeeks(j2);
            case 3:
                return plusMonths(j2);
            case 4:
                return plusYears(j2);
            case 5:
                return plusYears(Jdk8Methods.safeMultiply(j2, 10));
            case 6:
                return plusYears(Jdk8Methods.safeMultiply(j2, 100));
            case 7:
                return plusYears(Jdk8Methods.safeMultiply(j2, 1000));
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j2));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalDate with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDate) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j2);
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()]) {
            case 1:
                return withDayOfMonth((int) j2);
            case 2:
                return withDayOfYear((int) j2);
            case 3:
                return plusWeeks(j2 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.year < 1) {
                    j2 = 1 - j2;
                }
                return withYear((int) j2);
            case 5:
                return plusDays(j2 - ((long) getDayOfWeek().getValue()));
            case 6:
                return plusDays(j2 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return plusDays(j2 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return ofEpochDay(j2);
            case 9:
                return plusWeeks(j2 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
            case 10:
                return withMonth((int) j2);
            case 11:
                return plusMonths(j2 - getLong(ChronoField.PROLEPTIC_MONTH));
            case 12:
                return withYear((int) j2);
            case 13:
                return getLong(ChronoField.ERA) == j2 ? this : withYear(1 - this.year);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public Period until(ChronoLocalDate chronoLocalDate) {
        LocalDate from = from(chronoLocalDate);
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        int i2 = from.day - this.day;
        int i3 = (prolepticMonth > 0 ? 1 : (prolepticMonth == 0 ? 0 : -1));
        if (i3 > 0 && i2 < 0) {
            prolepticMonth--;
            i2 = (int) (from.toEpochDay() - plusMonths(prolepticMonth).toEpochDay());
        } else if (i3 < 0 && i2 > 0) {
            prolepticMonth++;
            i2 -= from.lengthOfMonth();
        }
        return Period.of(Jdk8Methods.safeToInt(prolepticMonth / 12), (int) (prolepticMonth % 12), i2);
    }
}
