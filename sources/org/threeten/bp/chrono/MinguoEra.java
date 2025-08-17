package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public enum MinguoEra implements Era {
    BEFORE_ROC,
    ROC;

    public static MinguoEra of(int i2) {
        if (i2 == 0) {
            return BEFORE_ROC;
        }
        if (i2 == 1) {
            return ROC;
        }
        throw new DateTimeException("Invalid era: " + i2);
    }

    static MinguoEra readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readByte());
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.ERA, (long) getValue());
    }

    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return getValue();
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText((TemporalField) ChronoField.ERA, textStyle).toFormatter(locale).format(this);
    }

    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal();
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.ERA) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.ERAS;
        }
        if (temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(getValue());
    }
}
