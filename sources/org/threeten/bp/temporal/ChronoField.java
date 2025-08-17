package org.threeten.bp.temporal;

import com.facebook.common.time.Clock;
import com.facebook.hermes.intl.Constants;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public enum ChronoField implements TemporalField {
    NANO_OF_SECOND("NanoOfSecond", r12, r20, ValueRange.of(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", r12, r3, ValueRange.of(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", r25, r18, ValueRange.of(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", r25, r26, ValueRange.of(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", r25, r18, ValueRange.of(0, 999)),
    MILLI_OF_DAY("MilliOfDay", r25, r26, ValueRange.of(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", r17, r12, ValueRange.of(0, 59)),
    SECOND_OF_DAY("SecondOfDay", r17, r3, ValueRange.of(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", r25, r29, ValueRange.of(0, 59)),
    MINUTE_OF_DAY("MinuteOfDay", r25, r26, ValueRange.of(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", r17, r18, ValueRange.of(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", r17, r18, ValueRange.of(1, 12)),
    HOUR_OF_DAY("HourOfDay", r25, r26, ValueRange.of(0, 23)),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", r25, r26, ValueRange.of(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", r30, r26, ValueRange.of(0, 1)),
    DAY_OF_WEEK("DayOfWeek", r25, r26, ValueRange.of(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", r25, r26, ValueRange.of(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", r25, r26, ValueRange.of(1, 7)),
    DAY_OF_MONTH("DayOfMonth", r25, r14, ValueRange.of(1, 28, 31)),
    DAY_OF_YEAR("DayOfYear", r25, r15, ValueRange.of(1, 365, 366)),
    EPOCH_DAY("EpochDay", r25, r46, ValueRange.of(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", r39, r14, ValueRange.of(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", r39, r40, ValueRange.of(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", r39, r40, ValueRange.of(1, 12)),
    PROLEPTIC_MONTH("ProlepticMonth", r39, r40, ValueRange.of(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", r39, r40, ValueRange.of(1, 999999999, 1000000000)),
    YEAR("Year", r39, r40, ValueRange.of(-999999999, 999999999)),
    ERA("Era", ChronoUnit.ERAS, r40, ValueRange.of(0, 1)),
    INSTANT_SECONDS("InstantSeconds", r17, r18, ValueRange.of(Long.MIN_VALUE, Clock.MAX_TIME)),
    OFFSET_SECONDS("OffsetSeconds", r17, r18, ValueRange.of(-64800, 64800));
    
    private final TemporalUnit baseUnit;
    private final String name;
    private final ValueRange range;
    private final TemporalUnit rangeUnit;

    private ChronoField(String str, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
        this.name = str;
        this.baseUnit = temporalUnit;
        this.rangeUnit = temporalUnit2;
        this.range = valueRange;
    }

    public <R extends Temporal> R adjustInto(R r2, long j2) {
        return r2.with(this, j2);
    }

    public int checkValidIntValue(long j2) {
        return range().checkValidIntValue(j2, this);
    }

    public long checkValidValue(long j2) {
        return range().checkValidValue(j2, this);
    }

    public TemporalUnit getBaseUnit() {
        return this.baseUnit;
    }

    public String getDisplayName(Locale locale) {
        Jdk8Methods.requireNonNull(locale, Constants.LOCALE);
        return toString();
    }

    public long getFrom(TemporalAccessor temporalAccessor) {
        return temporalAccessor.getLong(this);
    }

    public TemporalUnit getRangeUnit() {
        return this.rangeUnit;
    }

    public boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
        return temporalAccessor.isSupported(this);
    }

    public boolean isTimeBased() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    public ValueRange range() {
        return this.range;
    }

    public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
        return temporalAccessor.range(this);
    }

    public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
        return null;
    }

    public String toString() {
        return this.name;
    }
}
