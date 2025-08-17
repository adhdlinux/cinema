package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LocalTime extends BaseLocal implements Serializable {
    private static final int HOUR_OF_DAY = 0;
    public static final LocalTime MIDNIGHT = new LocalTime(0, 0, 0, 0);
    private static final int MILLIS_OF_SECOND = 3;
    private static final int MINUTE_OF_HOUR = 1;
    private static final int SECOND_OF_MINUTE = 2;
    private static final Set<DurationFieldType> TIME_DURATION_TYPES;
    private static final long serialVersionUID = -12873158713873L;
    private final Chronology iChronology;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -325842547277223L;
        private transient DateTimeField iField;
        private transient LocalTime iInstant;

        Property(LocalTime localTime, DateTimeField dateTimeField) {
            this.iInstant = localTime;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (LocalTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public LocalTime addCopy(int i2) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.add(localTime.getLocalMillis(), i2));
        }

        public LocalTime addNoWrapToCopy(int i2) {
            long add = this.iField.add(this.iInstant.getLocalMillis(), i2);
            if (((long) this.iInstant.getChronology().millisOfDay().get(add)) == add) {
                return this.iInstant.withLocalMillis(add);
            }
            throw new IllegalArgumentException("The addition exceeded the boundaries of LocalTime");
        }

        public LocalTime addWrapFieldToCopy(int i2) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.addWrapField(localTime.getLocalMillis(), i2));
        }

        /* access modifiers changed from: protected */
        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public LocalTime getLocalTime() {
            return this.iInstant;
        }

        /* access modifiers changed from: protected */
        public long getMillis() {
            return this.iInstant.getLocalMillis();
        }

        public LocalTime roundCeilingCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundFloorCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundFloor(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfCeilingCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfEvenCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfEven(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfFloorCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfFloor(localTime.getLocalMillis()));
        }

        public LocalTime setCopy(int i2) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.set(localTime.getLocalMillis(), i2));
        }

        public LocalTime withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalTime withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalTime addCopy(long j2) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.add(localTime.getLocalMillis(), j2));
        }

        public LocalTime setCopy(String str, Locale locale) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.set(localTime.getLocalMillis(), str, locale));
        }

        public LocalTime setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        TIME_DURATION_TYPES = hashSet;
        hashSet.add(DurationFieldType.millis());
        hashSet.add(DurationFieldType.seconds());
        hashSet.add(DurationFieldType.minutes());
        hashSet.add(DurationFieldType.hours());
    }

    public LocalTime() {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) ISOChronology.getInstance());
    }

    public static LocalTime fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new LocalTime(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalTime fromDateFields(Date date) {
        if (date != null) {
            return new LocalTime(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static LocalTime fromMillisOfDay(long j2) {
        return fromMillisOfDay(j2, (Chronology) null);
    }

    public static LocalTime now() {
        return new LocalTime();
    }

    @FromString
    public static LocalTime parse(String str) {
        return parse(str, ISODateTimeFormat.localTimeParser());
    }

    private Object readResolve() {
        Chronology chronology = this.iChronology;
        if (chronology == null) {
            return new LocalTime(this.iLocalMillis, (Chronology) ISOChronology.getInstanceUTC());
        }
        if (!DateTimeZone.UTC.equals(chronology.getZone())) {
            return new LocalTime(this.iLocalMillis, this.iChronology.withUTC());
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.iChronology.equals(localTime.iChronology)) {
                if (this.iLocalMillis == localTime.iLocalMillis) {
                    return true;
                }
                return false;
            }
        }
        return super.equals(obj);
    }

    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return dateTimeFieldType.getField(getChronology()).get(getLocalMillis());
        } else {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    /* access modifiers changed from: protected */
    public DateTimeField getField(int i2, Chronology chronology) {
        if (i2 == 0) {
            return chronology.hourOfDay();
        }
        if (i2 == 1) {
            return chronology.minuteOfHour();
        }
        if (i2 == 2) {
            return chronology.secondOfMinute();
        }
        if (i2 == 3) {
            return chronology.millisOfSecond();
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i2);
    }

    public int getHourOfDay() {
        return getChronology().hourOfDay().get(getLocalMillis());
    }

    /* access modifiers changed from: protected */
    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public int getMillisOfDay() {
        return getChronology().millisOfDay().get(getLocalMillis());
    }

    public int getMillisOfSecond() {
        return getChronology().millisOfSecond().get(getLocalMillis());
    }

    public int getMinuteOfHour() {
        return getChronology().minuteOfHour().get(getLocalMillis());
    }

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getLocalMillis());
    }

    public int getValue(int i2) {
        if (i2 == 0) {
            return getChronology().hourOfDay().get(getLocalMillis());
        }
        if (i2 == 1) {
            return getChronology().minuteOfHour().get(getLocalMillis());
        }
        if (i2 == 2) {
            return getChronology().secondOfMinute().get(getLocalMillis());
        }
        if (i2 == 3) {
            return getChronology().millisOfSecond().get(getLocalMillis());
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i2);
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null || !isSupported(dateTimeFieldType.getDurationType())) {
            return false;
        }
        DurationFieldType rangeDurationType = dateTimeFieldType.getRangeDurationType();
        if (isSupported(rangeDurationType) || rangeDurationType == DurationFieldType.days()) {
            return true;
        }
        return false;
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public LocalTime minus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, -1);
    }

    public LocalTime minusHours(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().subtract(getLocalMillis(), i2));
    }

    public LocalTime minusMillis(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().subtract(getLocalMillis(), i2));
    }

    public LocalTime minusMinutes(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().subtract(getLocalMillis(), i2));
    }

    public LocalTime minusSeconds(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().subtract(getLocalMillis(), i2));
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public LocalTime plus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, 1);
    }

    public LocalTime plusHours(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().add(getLocalMillis(), i2));
    }

    public LocalTime plusMillis(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().add(getLocalMillis(), i2));
    }

    public LocalTime plusMinutes(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().add(getLocalMillis(), i2));
    }

    public LocalTime plusSeconds(int i2) {
        if (i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().add(getLocalMillis(), i2));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return new Property(this, dateTimeFieldType.getField(getChronology()));
        } else {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
    }

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    public int size() {
        return 4;
    }

    public DateTime toDateTimeToday() {
        return toDateTimeToday((DateTimeZone) null);
    }

    @ToString
    public String toString() {
        return ISODateTimeFormat.time().print((ReadablePartial) this);
    }

    public LocalTime withField(DateTimeFieldType dateTimeFieldType, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i2));
        } else {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
    }

    public LocalTime withFieldAdded(DurationFieldType durationFieldType, int i2) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (!isSupported(durationFieldType)) {
            throw new IllegalArgumentException("Field '" + durationFieldType + "' is not supported");
        } else if (i2 == 0) {
            return this;
        } else {
            return withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i2));
        }
    }

    public LocalTime withFields(ReadablePartial readablePartial) {
        return readablePartial == null ? this : withLocalMillis(getChronology().set(readablePartial, getLocalMillis()));
    }

    public LocalTime withHourOfDay(int i2) {
        return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), i2));
    }

    /* access modifiers changed from: package-private */
    public LocalTime withLocalMillis(long j2) {
        return j2 == getLocalMillis() ? this : new LocalTime(j2, getChronology());
    }

    public LocalTime withMillisOfDay(int i2) {
        return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), i2));
    }

    public LocalTime withMillisOfSecond(int i2) {
        return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), i2));
    }

    public LocalTime withMinuteOfHour(int i2) {
        return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), i2));
    }

    public LocalTime withPeriodAdded(ReadablePeriod readablePeriod, int i2) {
        if (readablePeriod == null || i2 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().add(readablePeriod, getLocalMillis(), i2));
    }

    public LocalTime withSecondOfMinute(int i2) {
        return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), i2));
    }

    public LocalTime(DateTimeZone dateTimeZone) {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static LocalTime fromMillisOfDay(long j2, Chronology chronology) {
        return new LocalTime(j2, DateTimeUtils.getChronology(chronology).withUTC());
    }

    public static LocalTime now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new LocalTime(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    public static LocalTime parse(String str, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.parseLocalTime(str);
    }

    public int compareTo(ReadablePartial readablePartial) {
        if (this == readablePartial) {
            return 0;
        }
        if (readablePartial instanceof LocalTime) {
            LocalTime localTime = (LocalTime) readablePartial;
            if (this.iChronology.equals(localTime.iChronology)) {
                long j2 = this.iLocalMillis;
                long j3 = localTime.iLocalMillis;
                if (j2 < j3) {
                    return -1;
                }
                if (j2 == j3) {
                    return 0;
                }
                return 1;
            }
        }
        return super.compareTo(readablePartial);
    }

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, DateTimeUtils.currentTimeMillis()), withZone);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).print((ReadablePartial) this);
    }

    public LocalTime(Chronology chronology) {
        this(DateTimeUtils.currentTimeMillis(), chronology);
    }

    public LocalTime(long j2) {
        this(j2, (Chronology) ISOChronology.getInstance());
    }

    public static LocalTime now(Chronology chronology) {
        if (chronology != null) {
            return new LocalTime(chronology);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        DurationField field = durationFieldType.getField(getChronology());
        if (TIME_DURATION_TYPES.contains(durationFieldType) || field.getUnitMillis() < getChronology().days().getUnitMillis()) {
            return field.isSupported();
        }
        return false;
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).withLocale(locale).print((ReadablePartial) this);
    }

    public LocalTime(long j2, DateTimeZone dateTimeZone) {
        this(j2, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public LocalTime(long j2, Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        long millisKeepLocal = chronology2.getZone().getMillisKeepLocal(DateTimeZone.UTC, j2);
        Chronology withUTC = chronology2.withUTC();
        this.iLocalMillis = (long) withUTC.millisOfDay().get(millisKeepLocal);
        this.iChronology = withUTC;
    }

    public LocalTime(Object obj) {
        this(obj, (Chronology) null);
    }

    public LocalTime(Object obj, DateTimeZone dateTimeZone) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology = DateTimeUtils.getChronology(partialConverter.getChronology(obj, dateTimeZone));
        Chronology withUTC = chronology.withUTC();
        this.iChronology = withUTC;
        int[] partialValues = partialConverter.getPartialValues(this, obj, chronology, ISODateTimeFormat.localTimeParser());
        this.iLocalMillis = withUTC.getDateTimeMillis(0, partialValues[0], partialValues[1], partialValues[2], partialValues[3]);
    }

    public LocalTime(Object obj, Chronology chronology) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology2 = DateTimeUtils.getChronology(partialConverter.getChronology(obj, chronology));
        Chronology withUTC = chronology2.withUTC();
        this.iChronology = withUTC;
        int[] partialValues = partialConverter.getPartialValues(this, obj, chronology2, ISODateTimeFormat.localTimeParser());
        this.iLocalMillis = withUTC.getDateTimeMillis(0, partialValues[0], partialValues[1], partialValues[2], partialValues[3]);
    }

    public LocalTime(int i2, int i3) {
        this(i2, i3, 0, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i2, int i3, int i4) {
        this(i2, i3, i4, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i2, int i3, int i4, int i5, Chronology chronology) {
        Chronology withUTC = DateTimeUtils.getChronology(chronology).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(0, i2, i3, i4, i5);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }
}
