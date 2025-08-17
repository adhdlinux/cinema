package org.joda.time.chrono;

import com.facebook.common.time.Clock;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.UnsupportedDurationField;

final class GJEraDateTimeField extends BaseDateTimeField {
    private static final long serialVersionUID = 4240986525305515528L;
    private final BasicChronology iChronology;

    GJEraDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.era());
        this.iChronology = basicChronology;
    }

    private Object readResolve() {
        return this.iChronology.era();
    }

    public int get(long j2) {
        return this.iChronology.getYear(j2) <= 0 ? 0 : 1;
    }

    public String getAsText(int i2, Locale locale) {
        return GJLocaleSymbols.forLocale(locale).eraValueToText(i2);
    }

    public DurationField getDurationField() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    public int getMaximumTextLength(Locale locale) {
        return GJLocaleSymbols.forLocale(locale).getEraMaxTextLength();
    }

    public int getMaximumValue() {
        return 1;
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLenient() {
        return false;
    }

    public long roundCeiling(long j2) {
        if (get(j2) == 0) {
            return this.iChronology.setYear(0, 1);
        }
        return Clock.MAX_TIME;
    }

    public long roundFloor(long j2) {
        if (get(j2) == 1) {
            return this.iChronology.setYear(0, 1);
        }
        return Long.MIN_VALUE;
    }

    public long roundHalfCeiling(long j2) {
        return roundFloor(j2);
    }

    public long roundHalfEven(long j2) {
        return roundFloor(j2);
    }

    public long roundHalfFloor(long j2) {
        return roundFloor(j2);
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, 0, 1);
        if (get(j2) == i2) {
            return j2;
        }
        return this.iChronology.setYear(j2, -this.iChronology.getYear(j2));
    }

    public long set(long j2, String str, Locale locale) {
        return set(j2, GJLocaleSymbols.forLocale(locale).eraTextToValue(str));
    }
}
