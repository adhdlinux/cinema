package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public final class Minutes extends BaseSingleFieldPeriod {
    public static final Minutes MAX_VALUE = new Minutes(Integer.MAX_VALUE);
    public static final Minutes MIN_VALUE = new Minutes(Integer.MIN_VALUE);
    public static final Minutes ONE = new Minutes(1);
    private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.minutes());
    public static final Minutes THREE = new Minutes(3);
    public static final Minutes TWO = new Minutes(2);
    public static final Minutes ZERO = new Minutes(0);
    private static final long serialVersionUID = 87525275727380863L;

    private Minutes(int i2) {
        super(i2);
    }

    public static Minutes minutes(int i2) {
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
            return new Minutes(i2);
        }
        return THREE;
    }

    public static Minutes minutesBetween(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        return minutes(BaseSingleFieldPeriod.between(readableInstant, readableInstant2, DurationFieldType.minutes()));
    }

    public static Minutes minutesIn(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            return ZERO;
        }
        return minutes(BaseSingleFieldPeriod.between((ReadableInstant) readableInterval.getStart(), (ReadableInstant) readableInterval.getEnd(), DurationFieldType.minutes()));
    }

    @FromString
    public static Minutes parseMinutes(String str) {
        if (str == null) {
            return ZERO;
        }
        return minutes(PARSER.parsePeriod(str).getMinutes());
    }

    private Object readResolve() {
        return minutes(getValue());
    }

    public static Minutes standardMinutesIn(ReadablePeriod readablePeriod) {
        return minutes(BaseSingleFieldPeriod.standardPeriodIn(readablePeriod, 60000));
    }

    public Minutes dividedBy(int i2) {
        return i2 == 1 ? this : minutes(getValue() / i2);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.minutes();
    }

    public int getMinutes() {
        return getValue();
    }

    public PeriodType getPeriodType() {
        return PeriodType.minutes();
    }

    public boolean isGreaterThan(Minutes minutes) {
        if (minutes == null) {
            if (getValue() > 0) {
                return true;
            }
            return false;
        } else if (getValue() > minutes.getValue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLessThan(Minutes minutes) {
        if (minutes == null) {
            if (getValue() < 0) {
                return true;
            }
            return false;
        } else if (getValue() < minutes.getValue()) {
            return true;
        } else {
            return false;
        }
    }

    public Minutes minus(int i2) {
        return plus(FieldUtils.safeNegate(i2));
    }

    public Minutes multipliedBy(int i2) {
        return minutes(FieldUtils.safeMultiply(getValue(), i2));
    }

    public Minutes negated() {
        return minutes(FieldUtils.safeNegate(getValue()));
    }

    public Minutes plus(int i2) {
        return i2 == 0 ? this : minutes(FieldUtils.safeAdd(getValue(), i2));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / DateTimeConstants.MINUTES_PER_DAY);
    }

    public Duration toStandardDuration() {
        return new Duration(((long) getValue()) * 60000);
    }

    public Hours toStandardHours() {
        return Hours.hours(getValue() / 60);
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(FieldUtils.safeMultiply(getValue(), 60));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / DateTimeConstants.MINUTES_PER_WEEK);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "M";
    }

    public Minutes minus(Minutes minutes) {
        return minutes == null ? this : minus(minutes.getValue());
    }

    public Minutes plus(Minutes minutes) {
        return minutes == null ? this : plus(minutes.getValue());
    }

    public static Minutes minutesBetween(ReadablePartial readablePartial, ReadablePartial readablePartial2) {
        if (!(readablePartial instanceof LocalTime) || !(readablePartial2 instanceof LocalTime)) {
            return minutes(BaseSingleFieldPeriod.between(readablePartial, readablePartial2, (ReadablePeriod) ZERO));
        }
        return minutes(DateTimeUtils.getChronology(readablePartial.getChronology()).minutes().getDifference(((LocalTime) readablePartial2).getLocalMillis(), ((LocalTime) readablePartial).getLocalMillis()));
    }
}
