package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> {
    static final LocalDate MIN_DATE = LocalDate.of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    private transient JapaneseEra era;
    private final LocalDate isoDate;
    private transient int yearOfEra;

    /* renamed from: org.threeten.bp.chrono.JapaneseDate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.JapaneseDate.AnonymousClass1.<clinit>():void");
        }
    }

    JapaneseDate(LocalDate localDate) {
        if (!localDate.isBefore(MIN_DATE)) {
            JapaneseEra from = JapaneseEra.from(localDate);
            this.era = from;
            this.yearOfEra = localDate.getYear() - (from.startDate().getYear() - 1);
            this.isoDate = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    private ValueRange actualRange(int i2) {
        Calendar instance = Calendar.getInstance(JapaneseChronology.LOCALE);
        instance.set(0, this.era.getValue() + 2);
        instance.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return ValueRange.of((long) instance.getActualMinimum(i2), (long) instance.getActualMaximum(i2));
    }

    public static JapaneseDate from(TemporalAccessor temporalAccessor) {
        return JapaneseChronology.INSTANCE.date(temporalAccessor);
    }

    private long getDayOfYear() {
        int dayOfYear;
        if (this.yearOfEra == 1) {
            dayOfYear = (this.isoDate.getDayOfYear() - this.era.startDate().getDayOfYear()) + 1;
        } else {
            dayOfYear = this.isoDate.getDayOfYear();
        }
        return (long) dayOfYear;
    }

    public static JapaneseDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static JapaneseDate of(JapaneseEra japaneseEra, int i2, int i3, int i4) {
        Jdk8Methods.requireNonNull(japaneseEra, "era");
        if (i2 >= 1) {
            LocalDate startDate = japaneseEra.startDate();
            LocalDate endDate = japaneseEra.endDate();
            LocalDate of = LocalDate.of((startDate.getYear() - 1) + i2, i3, i4);
            if (!of.isBefore(startDate) && !of.isAfter(endDate)) {
                return new JapaneseDate(japaneseEra, i2, of);
            }
            throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
        }
        throw new DateTimeException("Invalid YearOfEra: " + i2);
    }

    static JapaneseDate ofYearDay(JapaneseEra japaneseEra, int i2, int i3) {
        Jdk8Methods.requireNonNull(japaneseEra, "era");
        if (i2 >= 1) {
            LocalDate startDate = japaneseEra.startDate();
            LocalDate endDate = japaneseEra.endDate();
            if (i2 != 1 || (i3 = i3 + (startDate.getDayOfYear() - 1)) <= startDate.lengthOfYear()) {
                LocalDate ofYearDay = LocalDate.ofYearDay((startDate.getYear() - 1) + i2, i3);
                if (!ofYearDay.isBefore(startDate) && !ofYearDay.isAfter(endDate)) {
                    return new JapaneseDate(japaneseEra, i2, ofYearDay);
                }
                throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
            }
            throw new DateTimeException("DayOfYear exceeds maximum allowed in the first year of era " + japaneseEra);
        }
        throw new DateTimeException("Invalid YearOfEra: " + i2);
    }

    static ChronoLocalDate readExternal(DataInput dataInput) throws IOException {
        return JapaneseChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        JapaneseEra from = JapaneseEra.from(this.isoDate);
        this.era = from;
        this.yearOfEra = this.isoDate.getYear() - (from.startDate().getYear() - 1);
    }

    private JapaneseDate withYear(JapaneseEra japaneseEra, int i2) {
        return with(this.isoDate.withYear(JapaneseChronology.INSTANCE.prolepticYear(japaneseEra, i2)));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public final ChronoLocalDateTime<JapaneseDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseDate) {
            return this.isoDate.equals(((JapaneseDate) obj).isoDate);
        }
        return false;
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        switch (AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return getDayOfYear();
            case 2:
                return (long) this.yearOfEra;
            case 3:
            case 4:
            case 5:
            case 6:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            case 7:
                return (long) this.era.getValue();
            default:
                return this.isoDate.getLong(temporalField);
        }
    }

    public int hashCode() {
        return getChronology().getId().hashCode() ^ this.isoDate.hashCode();
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || temporalField == ChronoField.ALIGNED_WEEK_OF_MONTH || temporalField == ChronoField.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.isSupported(temporalField);
    }

    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    public int lengthOfYear() {
        Calendar instance = Calendar.getInstance(JapaneseChronology.LOCALE);
        instance.set(0, this.era.getValue() + 2);
        instance.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return instance.getActualMaximum(6);
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i2 == 1) {
                return actualRange(6);
            }
            if (i2 != 2) {
                return getChronology().range(chronoField);
            }
            return actualRange(1);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static JapaneseDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public JapaneseChronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    public JapaneseEra getEra() {
        return this.era;
    }

    /* access modifiers changed from: package-private */
    public JapaneseDate plusDays(long j2) {
        return with(this.isoDate.plusDays(j2));
    }

    /* access modifiers changed from: package-private */
    public JapaneseDate plusMonths(long j2) {
        return with(this.isoDate.plusMonths(j2));
    }

    /* access modifiers changed from: package-private */
    public JapaneseDate plusYears(long j2) {
        return with(this.isoDate.plusYears(j2));
    }

    public ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        Period until = this.isoDate.until(chronoLocalDate);
        return getChronology().period(until.getYears(), until.getMonths(), until.getDays());
    }

    public static JapaneseDate now(Clock clock) {
        return new JapaneseDate(LocalDate.now(clock));
    }

    private JapaneseDate withYear(int i2) {
        return withYear(getEra(), i2);
    }

    public JapaneseDate minus(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.minus(temporalAmount);
    }

    public JapaneseDate with(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) super.with(temporalAdjuster);
    }

    public JapaneseDate minus(long j2, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.minus(j2, temporalUnit);
    }

    public JapaneseDate plus(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.plus(temporalAmount);
    }

    public JapaneseDate with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (JapaneseDate) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (getLong(chronoField) == j2) {
            return this;
        }
        int[] iArr = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField;
        int i2 = iArr[chronoField.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 7) {
            int checkValidIntValue = getChronology().range(chronoField).checkValidIntValue(j2, chronoField);
            int i3 = iArr[chronoField.ordinal()];
            if (i3 == 1) {
                return with(this.isoDate.plusDays(((long) checkValidIntValue) - getDayOfYear()));
            }
            if (i3 == 2) {
                return withYear(checkValidIntValue);
            }
            if (i3 == 7) {
                return withYear(JapaneseEra.of(checkValidIntValue), this.yearOfEra);
            }
        }
        return with(this.isoDate.with(temporalField, j2));
    }

    public JapaneseDate plus(long j2, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.plus(j2, temporalUnit);
    }

    JapaneseDate(JapaneseEra japaneseEra, int i2, LocalDate localDate) {
        if (!localDate.isBefore(MIN_DATE)) {
            this.era = japaneseEra;
            this.yearOfEra = i2;
            this.isoDate = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    public static JapaneseDate of(int i2, int i3, int i4) {
        return new JapaneseDate(LocalDate.of(i2, i3, i4));
    }

    private JapaneseDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new JapaneseDate(localDate);
    }
}
