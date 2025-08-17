package org.joda.time;

import java.io.Serializable;
import org.joda.convert.FromString;
import org.joda.time.base.AbstractInstant;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class Instant extends AbstractInstant implements Serializable {
    private static final long serialVersionUID = 3299096530934209741L;
    private final long iMillis;

    public Instant() {
        this.iMillis = DateTimeUtils.currentTimeMillis();
    }

    public static Instant now() {
        return new Instant();
    }

    @FromString
    public static Instant parse(String str) {
        return parse(str, ISODateTimeFormat.dateTimeParser());
    }

    public Chronology getChronology() {
        return ISOChronology.getInstanceUTC();
    }

    public long getMillis() {
        return this.iMillis;
    }

    public Instant minus(long j2) {
        return withDurationAdded(j2, -1);
    }

    public Instant plus(long j2) {
        return withDurationAdded(j2, 1);
    }

    public DateTime toDateTime() {
        return new DateTime(getMillis(), (Chronology) ISOChronology.getInstance());
    }

    @Deprecated
    public DateTime toDateTimeISO() {
        return toDateTime();
    }

    public Instant toInstant() {
        return this;
    }

    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), (Chronology) ISOChronology.getInstance());
    }

    @Deprecated
    public MutableDateTime toMutableDateTimeISO() {
        return toMutableDateTime();
    }

    public Instant withDurationAdded(long j2, int i2) {
        return (j2 == 0 || i2 == 0) ? this : withMillis(getChronology().add(getMillis(), j2, i2));
    }

    public Instant withMillis(long j2) {
        return j2 == this.iMillis ? this : new Instant(j2);
    }

    public static Instant parse(String str, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.parseDateTime(str).toInstant();
    }

    public Instant minus(ReadableDuration readableDuration) {
        return withDurationAdded(readableDuration, -1);
    }

    public Instant plus(ReadableDuration readableDuration) {
        return withDurationAdded(readableDuration, 1);
    }

    public Instant(long j2) {
        this.iMillis = j2;
    }

    public Instant withDurationAdded(ReadableDuration readableDuration, int i2) {
        return (readableDuration == null || i2 == 0) ? this : withDurationAdded(readableDuration.getMillis(), i2);
    }

    public Instant(Object obj) {
        this.iMillis = ConverterManager.getInstance().getInstantConverter(obj).getInstantMillis(obj, ISOChronology.getInstanceUTC());
    }
}
