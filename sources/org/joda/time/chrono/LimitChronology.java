package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DecoratedDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LimitChronology extends AssembledChronology {
    private static final long serialVersionUID = 7670866536893052522L;
    final DateTime iLowerLimit;
    final DateTime iUpperLimit;
    private transient LimitChronology iWithUTC;

    private class LimitException extends IllegalArgumentException {
        private static final long serialVersionUID = -5924689995607498581L;
        private final boolean iIsLow;

        LimitException(String str, boolean z2) {
            super(str);
            this.iIsLow = z2;
        }

        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(' ');
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            DateTimeFormatter withChronology = ISODateTimeFormat.dateTime().withChronology(LimitChronology.this.getBase());
            if (this.iIsLow) {
                stringBuffer.append("below the supported minimum of ");
                withChronology.printTo(stringBuffer, LimitChronology.this.getLowerLimit().getMillis());
            } else {
                stringBuffer.append("above the supported maximum of ");
                withChronology.printTo(stringBuffer, LimitChronology.this.getUpperLimit().getMillis());
            }
            stringBuffer.append(" (");
            stringBuffer.append(LimitChronology.this.getBase());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        public String toString() {
            return "IllegalArgumentException: " + getMessage();
        }
    }

    private LimitChronology(Chronology chronology, DateTime dateTime, DateTime dateTime2) {
        super(chronology, (Object) null);
        this.iLowerLimit = dateTime;
        this.iUpperLimit = dateTime2;
    }

    private DurationField convertField(DurationField durationField, HashMap<Object, Object> hashMap) {
        if (durationField == null || !durationField.isSupported()) {
            return durationField;
        }
        if (hashMap.containsKey(durationField)) {
            return (DurationField) hashMap.get(durationField);
        }
        LimitDurationField limitDurationField = new LimitDurationField(durationField);
        hashMap.put(durationField, limitDurationField);
        return limitDurationField;
    }

    public static LimitChronology getInstance(Chronology chronology, ReadableDateTime readableDateTime, ReadableDateTime readableDateTime2) {
        DateTime dateTime;
        if (chronology != null) {
            DateTime dateTime2 = null;
            if (readableDateTime == null) {
                dateTime = null;
            } else {
                dateTime = readableDateTime.toDateTime();
            }
            if (readableDateTime2 != null) {
                dateTime2 = readableDateTime2.toDateTime();
            }
            if (dateTime == null || dateTime2 == null || dateTime.isBefore(dateTime2)) {
                return new LimitChronology(chronology, dateTime, dateTime2);
            }
            throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
        }
        throw new IllegalArgumentException("Must supply a chronology");
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        HashMap hashMap = new HashMap();
        fields.eras = convertField(fields.eras, (HashMap<Object, Object>) hashMap);
        fields.centuries = convertField(fields.centuries, (HashMap<Object, Object>) hashMap);
        fields.years = convertField(fields.years, (HashMap<Object, Object>) hashMap);
        fields.months = convertField(fields.months, (HashMap<Object, Object>) hashMap);
        fields.weekyears = convertField(fields.weekyears, (HashMap<Object, Object>) hashMap);
        fields.weeks = convertField(fields.weeks, (HashMap<Object, Object>) hashMap);
        fields.days = convertField(fields.days, (HashMap<Object, Object>) hashMap);
        fields.halfdays = convertField(fields.halfdays, (HashMap<Object, Object>) hashMap);
        fields.hours = convertField(fields.hours, (HashMap<Object, Object>) hashMap);
        fields.minutes = convertField(fields.minutes, (HashMap<Object, Object>) hashMap);
        fields.seconds = convertField(fields.seconds, (HashMap<Object, Object>) hashMap);
        fields.millis = convertField(fields.millis, (HashMap<Object, Object>) hashMap);
        fields.year = convertField(fields.year, (HashMap<Object, Object>) hashMap);
        fields.yearOfEra = convertField(fields.yearOfEra, (HashMap<Object, Object>) hashMap);
        fields.yearOfCentury = convertField(fields.yearOfCentury, (HashMap<Object, Object>) hashMap);
        fields.centuryOfEra = convertField(fields.centuryOfEra, (HashMap<Object, Object>) hashMap);
        fields.era = convertField(fields.era, (HashMap<Object, Object>) hashMap);
        fields.dayOfWeek = convertField(fields.dayOfWeek, (HashMap<Object, Object>) hashMap);
        fields.dayOfMonth = convertField(fields.dayOfMonth, (HashMap<Object, Object>) hashMap);
        fields.dayOfYear = convertField(fields.dayOfYear, (HashMap<Object, Object>) hashMap);
        fields.monthOfYear = convertField(fields.monthOfYear, (HashMap<Object, Object>) hashMap);
        fields.weekOfWeekyear = convertField(fields.weekOfWeekyear, (HashMap<Object, Object>) hashMap);
        fields.weekyear = convertField(fields.weekyear, (HashMap<Object, Object>) hashMap);
        fields.weekyearOfCentury = convertField(fields.weekyearOfCentury, (HashMap<Object, Object>) hashMap);
        fields.millisOfSecond = convertField(fields.millisOfSecond, (HashMap<Object, Object>) hashMap);
        fields.millisOfDay = convertField(fields.millisOfDay, (HashMap<Object, Object>) hashMap);
        fields.secondOfMinute = convertField(fields.secondOfMinute, (HashMap<Object, Object>) hashMap);
        fields.secondOfDay = convertField(fields.secondOfDay, (HashMap<Object, Object>) hashMap);
        fields.minuteOfHour = convertField(fields.minuteOfHour, (HashMap<Object, Object>) hashMap);
        fields.minuteOfDay = convertField(fields.minuteOfDay, (HashMap<Object, Object>) hashMap);
        fields.hourOfDay = convertField(fields.hourOfDay, (HashMap<Object, Object>) hashMap);
        fields.hourOfHalfday = convertField(fields.hourOfHalfday, (HashMap<Object, Object>) hashMap);
        fields.clockhourOfDay = convertField(fields.clockhourOfDay, (HashMap<Object, Object>) hashMap);
        fields.clockhourOfHalfday = convertField(fields.clockhourOfHalfday, (HashMap<Object, Object>) hashMap);
        fields.halfdayOfDay = convertField(fields.halfdayOfDay, (HashMap<Object, Object>) hashMap);
    }

    /* access modifiers changed from: package-private */
    public void checkLimits(long j2, String str) {
        DateTime dateTime = this.iLowerLimit;
        if (dateTime == null || j2 >= dateTime.getMillis()) {
            DateTime dateTime2 = this.iUpperLimit;
            if (dateTime2 != null && j2 >= dateTime2.getMillis()) {
                throw new LimitException(str, false);
            }
            return;
        }
        throw new LimitException(str, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitChronology)) {
            return false;
        }
        LimitChronology limitChronology = (LimitChronology) obj;
        if (!getBase().equals(limitChronology.getBase()) || !FieldUtils.equals(getLowerLimit(), limitChronology.getLowerLimit()) || !FieldUtils.equals(getUpperLimit(), limitChronology.getUpperLimit())) {
            return false;
        }
        return true;
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i2, i3, i4, i5);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public DateTime getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTime getUpperLimit() {
        return this.iUpperLimit;
    }

    public int hashCode() {
        int i2;
        int i3 = 0;
        if (getLowerLimit() != null) {
            i2 = getLowerLimit().hashCode();
        } else {
            i2 = 0;
        }
        int i4 = i2 + 317351877;
        if (getUpperLimit() != null) {
            i3 = getUpperLimit().hashCode();
        }
        return i4 + i3 + (getBase().hashCode() * 7);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LimitChronology[");
        sb.append(getBase().toString());
        sb.append(", ");
        String str = "NoLimit";
        sb.append(getLowerLimit() == null ? str : getLowerLimit().toString());
        sb.append(", ");
        if (getUpperLimit() != null) {
            str = getUpperLimit().toString();
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    public Chronology withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        LimitChronology limitChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (dateTimeZone == dateTimeZone2 && (limitChronology = this.iWithUTC) != null) {
            return limitChronology;
        }
        DateTime dateTime = this.iLowerLimit;
        if (dateTime != null) {
            MutableDateTime mutableDateTime = dateTime.toMutableDateTime();
            mutableDateTime.setZoneRetainFields(dateTimeZone);
            dateTime = mutableDateTime.toDateTime();
        }
        DateTime dateTime2 = this.iUpperLimit;
        if (dateTime2 != null) {
            MutableDateTime mutableDateTime2 = dateTime2.toMutableDateTime();
            mutableDateTime2.setZoneRetainFields(dateTimeZone);
            dateTime2 = mutableDateTime2.toDateTime();
        }
        LimitChronology instance = getInstance(getBase().withZone(dateTimeZone), dateTime, dateTime2);
        if (dateTimeZone == dateTimeZone2) {
            this.iWithUTC = instance;
        }
        return instance;
    }

    private class LimitDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 8049297699408782284L;

        LimitDurationField(DurationField durationField) {
            super(durationField, durationField.getType());
        }

        public long add(long j2, int i2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long add = getWrappedField().add(j2, i2);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public int getDifference(long j2, long j3) {
            LimitChronology.this.checkLimits(j2, "minuend");
            LimitChronology.this.checkLimits(j3, "subtrahend");
            return getWrappedField().getDifference(j2, j3);
        }

        public long getDifferenceAsLong(long j2, long j3) {
            LimitChronology.this.checkLimits(j2, "minuend");
            LimitChronology.this.checkLimits(j3, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j2, j3);
        }

        public long getMillis(int i2, long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getMillis(i2, j2);
        }

        public int getValue(long j2, long j3) {
            LimitChronology.this.checkLimits(j3, (String) null);
            return getWrappedField().getValue(j2, j3);
        }

        public long getValueAsLong(long j2, long j3) {
            LimitChronology.this.checkLimits(j3, (String) null);
            return getWrappedField().getValueAsLong(j2, j3);
        }

        public long getMillis(long j2, long j3) {
            LimitChronology.this.checkLimits(j3, (String) null);
            return getWrappedField().getMillis(j2, j3);
        }

        public long add(long j2, long j3) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long add = getWrappedField().add(j2, j3);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }
    }

    private class LimitDateTimeField extends DecoratedDateTimeField {
        private static final long serialVersionUID = -2435306746995699312L;
        private final DurationField iDurationField;
        private final DurationField iLeapDurationField;
        private final DurationField iRangeDurationField;

        LimitDateTimeField(DateTimeField dateTimeField, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField, dateTimeField.getType());
            this.iDurationField = durationField;
            this.iRangeDurationField = durationField2;
            this.iLeapDurationField = durationField3;
        }

        public long add(long j2, int i2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long add = getWrappedField().add(j2, i2);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public long addWrapField(long j2, int i2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long addWrapField = getWrappedField().addWrapField(j2, i2);
            LimitChronology.this.checkLimits(addWrapField, "resulting");
            return addWrapField;
        }

        public int get(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().get(j2);
        }

        public String getAsShortText(long j2, Locale locale) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getAsShortText(j2, locale);
        }

        public String getAsText(long j2, Locale locale) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getAsText(j2, locale);
        }

        public int getDifference(long j2, long j3) {
            LimitChronology.this.checkLimits(j2, "minuend");
            LimitChronology.this.checkLimits(j3, "subtrahend");
            return getWrappedField().getDifference(j2, j3);
        }

        public long getDifferenceAsLong(long j2, long j3) {
            LimitChronology.this.checkLimits(j2, "minuend");
            LimitChronology.this.checkLimits(j3, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j2, j3);
        }

        public final DurationField getDurationField() {
            return this.iDurationField;
        }

        public int getLeapAmount(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getLeapAmount(j2);
        }

        public final DurationField getLeapDurationField() {
            return this.iLeapDurationField;
        }

        public int getMaximumShortTextLength(Locale locale) {
            return getWrappedField().getMaximumShortTextLength(locale);
        }

        public int getMaximumTextLength(Locale locale) {
            return getWrappedField().getMaximumTextLength(locale);
        }

        public int getMaximumValue(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getMaximumValue(j2);
        }

        public int getMinimumValue(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getMinimumValue(j2);
        }

        public final DurationField getRangeDurationField() {
            return this.iRangeDurationField;
        }

        public boolean isLeap(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().isLeap(j2);
        }

        public long remainder(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long remainder = getWrappedField().remainder(j2);
            LimitChronology.this.checkLimits(remainder, "resulting");
            return remainder;
        }

        public long roundCeiling(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long roundCeiling = getWrappedField().roundCeiling(j2);
            LimitChronology.this.checkLimits(roundCeiling, "resulting");
            return roundCeiling;
        }

        public long roundFloor(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long roundFloor = getWrappedField().roundFloor(j2);
            LimitChronology.this.checkLimits(roundFloor, "resulting");
            return roundFloor;
        }

        public long roundHalfCeiling(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long roundHalfCeiling = getWrappedField().roundHalfCeiling(j2);
            LimitChronology.this.checkLimits(roundHalfCeiling, "resulting");
            return roundHalfCeiling;
        }

        public long roundHalfEven(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long roundHalfEven = getWrappedField().roundHalfEven(j2);
            LimitChronology.this.checkLimits(roundHalfEven, "resulting");
            return roundHalfEven;
        }

        public long roundHalfFloor(long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long roundHalfFloor = getWrappedField().roundHalfFloor(j2);
            LimitChronology.this.checkLimits(roundHalfFloor, "resulting");
            return roundHalfFloor;
        }

        public long set(long j2, int i2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long j3 = getWrappedField().set(j2, i2);
            LimitChronology.this.checkLimits(j3, "resulting");
            return j3;
        }

        public long add(long j2, long j3) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long add = getWrappedField().add(j2, j3);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public long set(long j2, String str, Locale locale) {
            LimitChronology.this.checkLimits(j2, (String) null);
            long j3 = getWrappedField().set(j2, str, locale);
            LimitChronology.this.checkLimits(j3, "resulting");
            return j3;
        }
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i2, i3, i4, i5, i6, i7, i8);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public long getDateTimeMillis(long j2, int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        checkLimits(j2, (String) null);
        long dateTimeMillis = getBase().getDateTimeMillis(j2, i2, i3, i4, i5);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    private DateTimeField convertField(DateTimeField dateTimeField, HashMap<Object, Object> hashMap) {
        if (dateTimeField == null || !dateTimeField.isSupported()) {
            return dateTimeField;
        }
        if (hashMap.containsKey(dateTimeField)) {
            return (DateTimeField) hashMap.get(dateTimeField);
        }
        LimitDateTimeField limitDateTimeField = new LimitDateTimeField(dateTimeField, convertField(dateTimeField.getDurationField(), hashMap), convertField(dateTimeField.getRangeDurationField(), hashMap), convertField(dateTimeField.getLeapDurationField(), hashMap));
        hashMap.put(dateTimeField, limitDateTimeField);
        return limitDateTimeField;
    }
}
