package org.joda.time.base;

import com.facebook.common.time.Clock;
import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;

public abstract class BaseDateTime extends AbstractDateTime implements Serializable {
    private static final long serialVersionUID = -6728882245981L;
    private volatile Chronology iChronology;
    private volatile long iMillis;

    public BaseDateTime() {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) ISOChronology.getInstance());
    }

    private void adjustForMinMax() {
        if (this.iMillis == Long.MIN_VALUE || this.iMillis == Clock.MAX_TIME) {
            this.iChronology = this.iChronology.withUTC();
        }
    }

    /* access modifiers changed from: protected */
    public Chronology checkChronology(Chronology chronology) {
        return DateTimeUtils.getChronology(chronology);
    }

    /* access modifiers changed from: protected */
    public long checkInstant(long j2, Chronology chronology) {
        return j2;
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public long getMillis() {
        return this.iMillis;
    }

    /* access modifiers changed from: protected */
    public void setChronology(Chronology chronology) {
        this.iChronology = checkChronology(chronology);
    }

    /* access modifiers changed from: protected */
    public void setMillis(long j2) {
        this.iMillis = checkInstant(j2, this.iChronology);
    }

    public BaseDateTime(DateTimeZone dateTimeZone) {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(Chronology chronology) {
        this(DateTimeUtils.currentTimeMillis(), chronology);
    }

    public BaseDateTime(long j2) {
        this(j2, (Chronology) ISOChronology.getInstance());
    }

    public BaseDateTime(long j2, DateTimeZone dateTimeZone) {
        this(j2, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(long j2, Chronology chronology) {
        this.iChronology = checkChronology(chronology);
        this.iMillis = checkInstant(j2, this.iChronology);
        adjustForMinMax();
    }

    public BaseDateTime(Object obj, DateTimeZone dateTimeZone) {
        InstantConverter instantConverter = ConverterManager.getInstance().getInstantConverter(obj);
        Chronology checkChronology = checkChronology(instantConverter.getChronology(obj, dateTimeZone));
        this.iChronology = checkChronology;
        this.iMillis = checkInstant(instantConverter.getInstantMillis(obj, checkChronology), checkChronology);
        adjustForMinMax();
    }

    public BaseDateTime(Object obj, Chronology chronology) {
        InstantConverter instantConverter = ConverterManager.getInstance().getInstantConverter(obj);
        this.iChronology = checkChronology(instantConverter.getChronology(obj, chronology));
        this.iMillis = checkInstant(instantConverter.getInstantMillis(obj, chronology), this.iChronology);
        adjustForMinMax();
    }

    public BaseDateTime(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this(i2, i3, i4, i5, i6, i7, i8, (Chronology) ISOChronology.getInstance());
    }

    public BaseDateTime(int i2, int i3, int i4, int i5, int i6, int i7, int i8, DateTimeZone dateTimeZone) {
        this(i2, i3, i4, i5, i6, i7, i8, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(int i2, int i3, int i4, int i5, int i6, int i7, int i8, Chronology chronology) {
        this.iChronology = checkChronology(chronology);
        this.iMillis = checkInstant(this.iChronology.getDateTimeMillis(i2, i3, i4, i5, i6, i7, i8), this.iChronology);
        adjustForMinMax();
    }
}
