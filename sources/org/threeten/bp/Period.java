package org.threeten.bp;

import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.common.time.Clock;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

public final class Period extends ChronoPeriod implements Serializable {
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    public static final Period ZERO = new Period(0, 0, 0);
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;

    private Period(int i2, int i3, int i4) {
        this.years = i2;
        this.months = i3;
        this.days = i4;
    }

    public static Period between(LocalDate localDate, LocalDate localDate2) {
        return localDate.until((ChronoLocalDate) localDate2);
    }

    private static Period create(int i2, int i3, int i4) {
        if ((i2 | i3 | i4) == 0) {
            return ZERO;
        }
        return new Period(i2, i3, i4);
    }

    public static Period from(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return (Period) temporalAmount;
        }
        if (!(temporalAmount instanceof ChronoPeriod) || IsoChronology.INSTANCE.equals(((ChronoPeriod) temporalAmount).getChronology())) {
            Jdk8Methods.requireNonNull(temporalAmount, AppLovinEventParameters.REVENUE_AMOUNT);
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (TemporalUnit next : temporalAmount.getUnits()) {
                long j2 = temporalAmount.get(next);
                if (next == ChronoUnit.YEARS) {
                    i2 = Jdk8Methods.safeToInt(j2);
                } else if (next == ChronoUnit.MONTHS) {
                    i3 = Jdk8Methods.safeToInt(j2);
                } else if (next == ChronoUnit.DAYS) {
                    i4 = Jdk8Methods.safeToInt(j2);
                } else {
                    throw new DateTimeException("Unit must be Years, Months or Days, but was " + next);
                }
            }
            return create(i2, i3, i4);
        }
        throw new DateTimeException("Period requires ISO chronology: " + temporalAmount);
    }

    public static Period of(int i2, int i3, int i4) {
        return create(i2, i3, i4);
    }

    public static Period ofDays(int i2) {
        return create(0, 0, i2);
    }

    public static Period ofMonths(int i2) {
        return create(0, i2, 0);
    }

    public static Period ofWeeks(int i2) {
        return create(0, 0, Jdk8Methods.safeMultiply(i2, 7));
    }

    public static Period ofYears(int i2) {
        return create(i2, 0, 0);
    }

    public static Period parse(CharSequence charSequence) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            int i2 = 1;
            if ("-".equals(matcher.group(1))) {
                i2 = -1;
            }
            String group = matcher.group(2);
            String group2 = matcher.group(3);
            String group3 = matcher.group(4);
            String group4 = matcher.group(5);
            if (!(group == null && group2 == null && group3 == null && group4 == null)) {
                try {
                    return create(parseNumber(charSequence, group, i2), parseNumber(charSequence, group2, i2), Jdk8Methods.safeAdd(parseNumber(charSequence, group4, i2), Jdk8Methods.safeMultiply(parseNumber(charSequence, group3, i2), 7)));
                } catch (NumberFormatException e2) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e2));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0);
    }

    private static int parseNumber(CharSequence charSequence, String str, int i2) {
        if (str == null) {
            return 0;
        }
        try {
            return Jdk8Methods.safeMultiply(Integer.parseInt(str), i2);
        } catch (ArithmeticException e2) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e2));
        }
    }

    private Object readResolve() {
        if ((this.years | this.months | this.days) == 0) {
            return ZERO;
        }
        return this;
    }

    public Temporal addTo(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        int i2 = this.years;
        if (i2 == 0) {
            int i3 = this.months;
            if (i3 != 0) {
                temporal = temporal.plus((long) i3, ChronoUnit.MONTHS);
            }
        } else if (this.months != 0) {
            temporal = temporal.plus(toTotalMonths(), ChronoUnit.MONTHS);
        } else {
            temporal = temporal.plus((long) i2, ChronoUnit.YEARS);
        }
        int i4 = this.days;
        if (i4 != 0) {
            return temporal.plus((long) i4, ChronoUnit.DAYS);
        }
        return temporal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        if (this.years == period.years && this.months == period.months && this.days == period.days) {
            return true;
        }
        return false;
    }

    public long get(TemporalUnit temporalUnit) {
        int i2;
        if (temporalUnit == ChronoUnit.YEARS) {
            i2 = this.years;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i2 = this.months;
        } else if (temporalUnit == ChronoUnit.DAYS) {
            i2 = this.days;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return (long) i2;
    }

    public Chronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int getYears() {
        return this.years;
    }

    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    public boolean isZero() {
        return this == ZERO;
    }

    public Period minusDays(long j2) {
        return j2 == Long.MIN_VALUE ? plusDays(Clock.MAX_TIME).plusDays(1) : plusDays(-j2);
    }

    public Period minusMonths(long j2) {
        return j2 == Long.MIN_VALUE ? plusMonths(Clock.MAX_TIME).plusMonths(1) : plusMonths(-j2);
    }

    public Period minusYears(long j2) {
        return j2 == Long.MIN_VALUE ? plusYears(Clock.MAX_TIME).plusYears(1) : plusYears(-j2);
    }

    public Period plusDays(long j2) {
        return j2 == 0 ? this : create(this.years, this.months, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd((long) this.days, j2)));
    }

    public Period plusMonths(long j2) {
        return j2 == 0 ? this : create(this.years, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd((long) this.months, j2)), this.days);
    }

    public Period plusYears(long j2) {
        return j2 == 0 ? this : create(Jdk8Methods.safeToInt(Jdk8Methods.safeAdd((long) this.years, j2)), this.months, this.days);
    }

    public Temporal subtractFrom(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        int i2 = this.years;
        if (i2 == 0) {
            int i3 = this.months;
            if (i3 != 0) {
                temporal = temporal.minus((long) i3, ChronoUnit.MONTHS);
            }
        } else if (this.months != 0) {
            temporal = temporal.minus(toTotalMonths(), ChronoUnit.MONTHS);
        } else {
            temporal = temporal.minus((long) i2, ChronoUnit.YEARS);
        }
        int i4 = this.days;
        if (i4 != 0) {
            return temporal.minus((long) i4, ChronoUnit.DAYS);
        }
        return temporal;
    }

    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i2 = this.years;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('Y');
        }
        int i3 = this.months;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.days;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }

    public long toTotalMonths() {
        return (((long) this.years) * 12) + ((long) this.months);
    }

    public Period withDays(int i2) {
        if (i2 == this.days) {
            return this;
        }
        return create(this.years, this.months, i2);
    }

    public Period withMonths(int i2) {
        if (i2 == this.months) {
            return this;
        }
        return create(this.years, i2, this.days);
    }

    public Period withYears(int i2) {
        if (i2 == this.years) {
            return this;
        }
        return create(i2, this.months, this.days);
    }

    public Period minus(TemporalAmount temporalAmount) {
        Period from = from(temporalAmount);
        return create(Jdk8Methods.safeSubtract(this.years, from.years), Jdk8Methods.safeSubtract(this.months, from.months), Jdk8Methods.safeSubtract(this.days, from.days));
    }

    public Period multipliedBy(int i2) {
        return (this == ZERO || i2 == 1) ? this : create(Jdk8Methods.safeMultiply(this.years, i2), Jdk8Methods.safeMultiply(this.months, i2), Jdk8Methods.safeMultiply(this.days, i2));
    }

    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalized() {
        long totalMonths = toTotalMonths();
        long j2 = totalMonths / 12;
        int i2 = (int) (totalMonths % 12);
        if (j2 == ((long) this.years) && i2 == this.months) {
            return this;
        }
        return create(Jdk8Methods.safeToInt(j2), i2, this.days);
    }

    public Period plus(TemporalAmount temporalAmount) {
        Period from = from(temporalAmount);
        return create(Jdk8Methods.safeAdd(this.years, from.years), Jdk8Methods.safeAdd(this.months, from.months), Jdk8Methods.safeAdd(this.days, from.days));
    }
}
