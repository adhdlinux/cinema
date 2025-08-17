package org.threeten.bp;

import com.facebook.common.time.Clock;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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

public final class YearMonth extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {
    public static final TemporalQuery<YearMonth> FROM = new TemporalQuery<YearMonth>() {
        public YearMonth queryFrom(TemporalAccessor temporalAccessor) {
            return YearMonth.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.MONTH_OF_YEAR, 2).toFormatter();
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    /* renamed from: org.threeten.bp.YearMonth$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0078 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                org.threeten.bp.temporal.ChronoField[] r5 = org.threeten.bp.temporal.ChronoField.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r5
                org.threeten.bp.temporal.ChronoField r6 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0064 }
                org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x006e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0082 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.YearMonth.AnonymousClass2.<clinit>():void");
        }
    }

    private YearMonth(int i2, int i3) {
        this.year = i2;
        this.month = i3;
    }

    public static YearMonth from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof YearMonth) {
            return (YearMonth) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.YEAR), temporalAccessor.get(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    public static YearMonth now() {
        return now(Clock.systemDefaultZone());
    }

    public static YearMonth of(int i2, Month month2) {
        Jdk8Methods.requireNonNull(month2, "month");
        return of(i2, month2.getValue());
    }

    public static YearMonth parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    static YearMonth readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), (int) dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.PROLEPTIC_MONTH, getProlepticMonth());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int i2) {
        return LocalDate.of(this.year, this.month, i2);
    }

    public LocalDate atEndOfMonth() {
        return LocalDate.of(this.year, this.month, lengthOfMonth());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearMonth)) {
            return false;
        }
        YearMonth yearMonth = (YearMonth) obj;
        if (this.year == yearMonth.year && this.month == yearMonth.month) {
            return true;
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public long getLong(TemporalField temporalField) {
        int i2;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i3 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i2 = this.month;
        } else if (i3 == 2) {
            return getProlepticMonth();
        } else {
            if (i3 == 3) {
                int i5 = this.year;
                if (i5 < 1) {
                    i5 = 1 - i5;
                }
                return (long) i5;
            } else if (i3 == 4) {
                i2 = this.year;
            } else if (i3 == 5) {
                if (this.year < 1) {
                    i4 = 0;
                }
                return (long) i4;
            } else {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return (long) i2;
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
        return this.year ^ (this.month << 27);
    }

    public boolean isAfter(YearMonth yearMonth) {
        return compareTo(yearMonth) > 0;
    }

    public boolean isBefore(YearMonth yearMonth) {
        return compareTo(yearMonth) < 0;
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear((long) this.year);
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.YEAR || temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.PROLEPTIC_MONTH || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidDay(int i2) {
        return i2 >= 1 && i2 <= lengthOfMonth();
    }

    public int lengthOfMonth() {
        return getMonth().length(isLeapYear());
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public YearMonth minusMonths(long j2) {
        return j2 == Long.MIN_VALUE ? plusMonths(Clock.MAX_TIME).plusMonths(1) : plusMonths(-j2);
    }

    public YearMonth minusYears(long j2) {
        return j2 == Long.MIN_VALUE ? plusYears(Clock.MAX_TIME).plusYears(1) : plusYears(-j2);
    }

    public YearMonth plusMonths(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.year) * 12) + ((long) (this.month - 1)) + j2;
        return with(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(j3, 12)), Jdk8Methods.floorMod(j3, 12) + 1);
    }

    public YearMonth plusYears(long j2) {
        if (j2 == 0) {
            return this;
        }
        return with(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j2), this.month);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.MONTHS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        long j2;
        if (temporalField != ChronoField.YEAR_OF_ERA) {
            return super.range(temporalField);
        }
        if (getYear() <= 0) {
            j2 = 1000000000;
        } else {
            j2 = 999999999;
        }
        return ValueRange.of(1, j2);
    }

    public String toString() {
        String str;
        int abs = Math.abs(this.year);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i2 = this.year;
            if (i2 < 0) {
                sb.append(i2 - 10000);
                sb.deleteCharAt(1);
            } else {
                sb.append(i2 + 10000);
                sb.deleteCharAt(0);
            }
        } else {
            sb.append(this.year);
        }
        if (this.month < 10) {
            str = "-0";
        } else {
            str = "-";
        }
        sb.append(str);
        sb.append(this.month);
        return sb.toString();
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        YearMonth from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return prolepticMonth;
            case 2:
                return prolepticMonth / 12;
            case 3:
                return prolepticMonth / 120;
            case 4:
                return prolepticMonth / 1200;
            case 5:
                return prolepticMonth / 12000;
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public YearMonth withMonth(int i2) {
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i2);
        return with(this.year, i2);
    }

    public YearMonth withYear(int i2) {
        ChronoField.YEAR.checkValidValue((long) i2);
        return with(i2, this.month);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
    }

    public static YearMonth now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static YearMonth parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (YearMonth) dateTimeFormatter.parse(charSequence, FROM);
    }

    public int compareTo(YearMonth yearMonth) {
        int i2 = this.year - yearMonth.year;
        return i2 == 0 ? this.month - yearMonth.month : i2;
    }

    public static YearMonth now(Clock clock) {
        LocalDate now = LocalDate.now(clock);
        return of(now.getYear(), now.getMonth());
    }

    public static YearMonth of(int i2, int i3) {
        ChronoField.YEAR.checkValidValue((long) i2);
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i3);
        return new YearMonth(i2, i3);
    }

    private YearMonth with(int i2, int i3) {
        if (this.year == i2 && this.month == i3) {
            return this;
        }
        return new YearMonth(i2, i3);
    }

    public YearMonth minus(TemporalAmount temporalAmount) {
        return (YearMonth) temporalAmount.subtractFrom(this);
    }

    public YearMonth plus(TemporalAmount temporalAmount) {
        return (YearMonth) temporalAmount.addTo(this);
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit == ChronoUnit.MONTHS || temporalUnit == ChronoUnit.YEARS || temporalUnit == ChronoUnit.DECADES || temporalUnit == ChronoUnit.CENTURIES || temporalUnit == ChronoUnit.MILLENNIA || temporalUnit == ChronoUnit.ERAS) {
                return true;
            }
            return false;
        } else if (temporalUnit == null || !temporalUnit.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public YearMonth minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus((long) Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }

    public YearMonth plus(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (YearMonth) temporalUnit.addTo(this, j2);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusMonths(j2);
            case 2:
                return plusYears(j2);
            case 3:
                return plusYears(Jdk8Methods.safeMultiply(j2, 10));
            case 4:
                return plusYears(Jdk8Methods.safeMultiply(j2, 100));
            case 5:
                return plusYears(Jdk8Methods.safeMultiply(j2, 1000));
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j2));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public YearMonth with(TemporalAdjuster temporalAdjuster) {
        return (YearMonth) temporalAdjuster.adjustInto(this);
    }

    public YearMonth with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (YearMonth) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j2);
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i2 == 1) {
            return withMonth((int) j2);
        }
        if (i2 == 2) {
            return plusMonths(j2 - getLong(ChronoField.PROLEPTIC_MONTH));
        }
        if (i2 == 3) {
            if (this.year < 1) {
                j2 = 1 - j2;
            }
            return withYear((int) j2);
        } else if (i2 == 4) {
            return withYear((int) j2);
        } else {
            if (i2 == 5) {
                return getLong(ChronoField.ERA) == j2 ? this : withYear(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }
}
