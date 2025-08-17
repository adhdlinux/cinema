package org.threeten.bp;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    private static final DayOfWeek[] ENUMS = null;
    public static final TemporalQuery<DayOfWeek> FROM = null;

    static {
        FROM = new TemporalQuery<DayOfWeek>() {
            public DayOfWeek queryFrom(TemporalAccessor temporalAccessor) {
                return DayOfWeek.from(temporalAccessor);
            }
        };
        ENUMS = values();
    }

    public static DayOfWeek from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof DayOfWeek) {
            return (DayOfWeek) temporalAccessor;
        }
        try {
            return of(temporalAccessor.get(ChronoField.DAY_OF_WEEK));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e2);
        }
    }

    public static DayOfWeek of(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return ENUMS[i2 - 1];
        }
        throw new DateTimeException("Invalid value for DayOfWeek: " + i2);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_WEEK, (long) getValue());
    }

    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return getValue();
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText((TemporalField) ChronoField.DAY_OF_WEEK, textStyle).toFormatter(locale).format(this);
    }

    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.DAY_OF_WEEK) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public DayOfWeek minus(long j2) {
        return plus(-(j2 % 7));
    }

    public DayOfWeek plus(long j2) {
        return ENUMS[(ordinal() + (((int) (j2 % 7)) + 7)) % 7];
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }
}
