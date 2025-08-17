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

public final class Year extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {
    public static final TemporalQuery<Year> FROM = new TemporalQuery<Year>() {
        public Year queryFrom(TemporalAccessor temporalAccessor) {
            return Year.from(temporalAccessor);
        }
    };
    public static final int MAX_VALUE = 999999999;
    public static final int MIN_VALUE = -999999999;
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    /* renamed from: org.threeten.bp.Year$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0059 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                org.threeten.bp.temporal.ChronoField[] r3 = org.threeten.bp.temporal.ChronoField.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r3
                org.threeten.bp.temporal.ChronoField r4 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x004f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0059 }
                org.threeten.bp.temporal.ChronoField r3 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0063 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Year.AnonymousClass2.<clinit>():void");
        }
    }

    private Year(int i2) {
        this.year = i2;
    }

    public static Year from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Year) {
            return (Year) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static boolean isLeap(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }

    public static Year now() {
        return now(Clock.systemDefaultZone());
    }

    public static Year of(int i2) {
        ChronoField.YEAR.checkValidValue((long) i2);
        return new Year(i2);
    }

    public static Year parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    static Year readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.YEAR, (long) this.year);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int i2) {
        return LocalDate.ofYearDay(this.year, i2);
    }

    public YearMonth atMonth(Month month) {
        return YearMonth.of(this.year, month);
    }

    public LocalDate atMonthDay(MonthDay monthDay) {
        return monthDay.atYear(this.year);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Year) || this.year != ((Year) obj).year) {
            return false;
        }
        return true;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            int i4 = this.year;
            if (i4 < 1) {
                i4 = 1 - i4;
            }
            return (long) i4;
        } else if (i2 == 2) {
            return (long) this.year;
        } else {
            if (i2 == 3) {
                if (this.year < 1) {
                    i3 = 0;
                }
                return (long) i3;
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public int getValue() {
        return this.year;
    }

    public int hashCode() {
        return this.year;
    }

    public boolean isAfter(Year year2) {
        return this.year > year2.year;
    }

    public boolean isBefore(Year year2) {
        return this.year < year2.year;
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.YEAR || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidMonthDay(MonthDay monthDay) {
        return monthDay != null && monthDay.isValidYear(this.year);
    }

    public int length() {
        return isLeap() ? 366 : 365;
    }

    public Year minusYears(long j2) {
        return j2 == Long.MIN_VALUE ? plusYears(Clock.MAX_TIME).plusYears(1) : plusYears(-j2);
    }

    public Year plusYears(long j2) {
        return j2 == 0 ? this : of(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j2));
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.YEARS;
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
        if (this.year <= 0) {
            j2 = 1000000000;
        } else {
            j2 = 999999999;
        }
        return ValueRange.of(1, j2);
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Year from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long j2 = ((long) from.year) - ((long) this.year);
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
        if (i2 == 1) {
            return j2;
        }
        if (i2 == 2) {
            return j2 / 10;
        }
        if (i2 == 3) {
            return j2 / 100;
        }
        if (i2 == 4) {
            return j2 / 1000;
        }
        if (i2 == 5) {
            ChronoField chronoField = ChronoField.ERA;
            return from.getLong(chronoField) - getLong(chronoField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
    }

    public static Year now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static Year parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (Year) dateTimeFormatter.parse(charSequence, FROM);
    }

    public YearMonth atMonth(int i2) {
        return YearMonth.of(this.year, i2);
    }

    public int compareTo(Year year2) {
        return this.year - year2.year;
    }

    public boolean isLeap() {
        return isLeap((long) this.year);
    }

    public static Year now(Clock clock) {
        return of(LocalDate.now(clock).getYear());
    }

    public Year minus(TemporalAmount temporalAmount) {
        return (Year) temporalAmount.subtractFrom(this);
    }

    public Year plus(TemporalAmount temporalAmount) {
        return (Year) temporalAmount.addTo(this);
    }

    public Year with(TemporalAdjuster temporalAdjuster) {
        return (Year) temporalAdjuster.adjustInto(this);
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit == ChronoUnit.YEARS || temporalUnit == ChronoUnit.DECADES || temporalUnit == ChronoUnit.CENTURIES || temporalUnit == ChronoUnit.MILLENNIA || temporalUnit == ChronoUnit.ERAS) {
                return true;
            }
            return false;
        } else if (temporalUnit == null || !temporalUnit.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public Year minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus((long) Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }

    public Year plus(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Year) temporalUnit.addTo(this, j2);
        }
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
        if (i2 == 1) {
            return plusYears(j2);
        }
        if (i2 == 2) {
            return plusYears(Jdk8Methods.safeMultiply(j2, 10));
        }
        if (i2 == 3) {
            return plusYears(Jdk8Methods.safeMultiply(j2, 100));
        }
        if (i2 == 4) {
            return plusYears(Jdk8Methods.safeMultiply(j2, 1000));
        }
        if (i2 == 5) {
            ChronoField chronoField = ChronoField.ERA;
            return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j2));
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public Year with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (Year) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j2);
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i2 == 1) {
            if (this.year < 1) {
                j2 = 1 - j2;
            }
            return of((int) j2);
        } else if (i2 == 2) {
            return of((int) j2);
        } else {
            if (i2 == 3) {
                return getLong(ChronoField.ERA) == j2 ? this : of(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }
}
