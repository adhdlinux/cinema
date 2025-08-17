package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public final class Weeks extends BaseSingleFieldPeriod {
    public static final Weeks MAX_VALUE = new Weeks(Integer.MAX_VALUE);
    public static final Weeks MIN_VALUE = new Weeks(Integer.MIN_VALUE);
    public static final Weeks ONE = new Weeks(1);
    private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.weeks());
    public static final Weeks THREE = new Weeks(3);
    public static final Weeks TWO = new Weeks(2);
    public static final Weeks ZERO = new Weeks(0);
    private static final long serialVersionUID = 87525275727380866L;

    private Weeks(int i2) {
        super(i2);
    }

    @FromString
    public static Weeks parseWeeks(String str) {
        if (str == null) {
            return ZERO;
        }
        return weeks(PARSER.parsePeriod(str).getWeeks());
    }

    private Object readResolve() {
        return weeks(getValue());
    }

    public static Weeks standardWeeksIn(ReadablePeriod readablePeriod) {
        return weeks(BaseSingleFieldPeriod.standardPeriodIn(readablePeriod, 604800000));
    }

    public static Weeks weeks(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            return MIN_VALUE;
        }
        if (i2 == Integer.MAX_VALUE) {
            return MAX_VALUE;
        }
        if (i2 == 0) {
            return ZERO;
        }
        if (i2 == 1) {
            return ONE;
        }
        if (i2 == 2) {
            return TWO;
        }
        if (i2 != 3) {
            return new Weeks(i2);
        }
        return THREE;
    }

    public static Weeks weeksBetween(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        return weeks(BaseSingleFieldPeriod.between(readableInstant, readableInstant2, DurationFieldType.weeks()));
    }

    public static Weeks weeksIn(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            return ZERO;
        }
        return weeks(BaseSingleFieldPeriod.between((ReadableInstant) readableInterval.getStart(), (ReadableInstant) readableInterval.getEnd(), DurationFieldType.weeks()));
    }

    public Weeks dividedBy(int i2) {
        return i2 == 1 ? this : weeks(getValue() / i2);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.weeks();
    }

    public PeriodType getPeriodType() {
        return PeriodType.weeks();
    }

    public int getWeeks() {
        return getValue();
    }

    public boolean isGreaterThan(Weeks weeks) {
        if (weeks == null) {
            if (getValue() > 0) {
                return true;
            }
            return false;
        } else if (getValue() > weeks.getValue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLessThan(Weeks weeks) {
        if (weeks == null) {
            if (getValue() < 0) {
                return true;
            }
            return false;
        } else if (getValue() < weeks.getValue()) {
            return true;
        } else {
            return false;
        }
    }

    public Weeks minus(int i2) {
        return plus(FieldUtils.safeNegate(i2));
    }

    public Weeks multipliedBy(int i2) {
        return weeks(FieldUtils.safeMultiply(getValue(), i2));
    }

    public Weeks negated() {
        return weeks(FieldUtils.safeNegate(getValue()));
    }

    public Weeks plus(int i2) {
        return i2 == 0 ? this : weeks(FieldUtils.safeAdd(getValue(), i2));
    }

    public Days toStandardDays() {
        return Days.days(FieldUtils.safeMultiply(getValue(), 7));
    }

    public Duration toStandardDuration() {
        return new Duration(((long) getValue()) * 604800000);
    }

    public Hours toStandardHours() {
        return Hours.hours(FieldUtils.safeMultiply(getValue(), (int) DateTimeConstants.HOURS_PER_WEEK));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(FieldUtils.safeMultiply(getValue(), (int) DateTimeConstants.MINUTES_PER_WEEK));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(FieldUtils.safeMultiply(getValue(), (int) DateTimeConstants.SECONDS_PER_WEEK));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "W";
    }

    public Weeks minus(Weeks weeks) {
        return weeks == null ? this : minus(weeks.getValue());
    }

    public Weeks plus(Weeks weeks) {
        return weeks == null ? this : plus(weeks.getValue());
    }

    public static Weeks weeksBetween(ReadablePartial readablePartial, ReadablePartial readablePartial2) {
        if (!(readablePartial instanceof LocalDate) || !(readablePartial2 instanceof LocalDate)) {
            return weeks(BaseSingleFieldPeriod.between(readablePartial, readablePartial2, (ReadablePeriod) ZERO));
        }
        return weeks(DateTimeUtils.getChronology(readablePartial.getChronology()).weeks().getDifference(((LocalDate) readablePartial2).getLocalMillis(), ((LocalDate) readablePartial).getLocalMillis()));
    }
}
