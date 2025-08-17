package org.joda.time.chrono;

import com.vungle.ads.internal.signals.SignalManager;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.SkipDateTimeField;

public final class JulianChronology extends BasicGJChronology {
    private static final JulianChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    private static final int MAX_YEAR = 292272992;
    private static final long MILLIS_PER_MONTH = 2629800000L;
    private static final long MILLIS_PER_YEAR = 31557600000L;
    private static final int MIN_YEAR = -292269054;
    private static final ConcurrentHashMap<DateTimeZone, JulianChronology[]> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -8731039522547897247L;

    JulianChronology(Chronology chronology, Object obj, int i2) {
        super(chronology, obj, i2);
    }

    static int adjustYearForSet(int i2) {
        if (i2 > 0) {
            return i2;
        }
        if (i2 != 0) {
            return i2 + 1;
        }
        throw new IllegalFieldValueException(DateTimeFieldType.year(), (Number) Integer.valueOf(i2), (Number) null, (Number) null);
    }

    public static JulianChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static JulianChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        DateTimeZone dateTimeZone;
        Chronology base = getBase();
        int minimumDaysInFirstWeek = getMinimumDaysInFirstWeek();
        if (minimumDaysInFirstWeek == 0) {
            minimumDaysInFirstWeek = 4;
        }
        if (base == null) {
            dateTimeZone = DateTimeZone.UTC;
        } else {
            dateTimeZone = base.getZone();
        }
        return getInstance(dateTimeZone, minimumDaysInFirstWeek);
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        if (getBase() == null) {
            super.assemble(fields);
            fields.year = new SkipDateTimeField(this, fields.year);
            fields.weekyear = new SkipDateTimeField(this, fields.weekyear);
        }
    }

    /* access modifiers changed from: package-private */
    public long calculateFirstDayOfYearMillis(int i2) {
        int i3;
        int i4 = i2 - 1968;
        if (i4 <= 0) {
            i3 = (i4 + 3) >> 2;
        } else {
            int i5 = i4 >> 2;
            i3 = !isLeapYear(i2) ? i5 + 1 : i5;
        }
        return (((((long) i4) * 365) + ((long) i3)) * SignalManager.TWENTY_FOUR_HOURS_MILLIS) - 62035200000L;
    }

    /* access modifiers changed from: package-private */
    public long getApproxMillisAtEpochDividedByTwo() {
        return 31083663600000L;
    }

    /* access modifiers changed from: package-private */
    public long getAverageMillisPerMonth() {
        return MILLIS_PER_MONTH;
    }

    /* access modifiers changed from: package-private */
    public long getAverageMillisPerYear() {
        return MILLIS_PER_YEAR;
    }

    /* access modifiers changed from: package-private */
    public long getAverageMillisPerYearDividedByTwo() {
        return 15778800000L;
    }

    /* access modifiers changed from: package-private */
    public long getDateMidnightMillis(int i2, int i3, int i4) throws IllegalArgumentException {
        return super.getDateMidnightMillis(adjustYearForSet(i2), i3, i4);
    }

    /* access modifiers changed from: package-private */
    public int getMaxYear() {
        return MAX_YEAR;
    }

    /* access modifiers changed from: package-private */
    public int getMinYear() {
        return MIN_YEAR;
    }

    /* access modifiers changed from: package-private */
    public boolean isLeapYear(int i2) {
        return (i2 & 3) == 0;
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(dateTimeZone);
    }

    public static JulianChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r1 = new org.joda.time.chrono.JulianChronology[7];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.chrono.JulianChronology getInstance(org.joda.time.DateTimeZone r5, int r6) {
        /*
            if (r5 != 0) goto L_0x0006
            org.joda.time.DateTimeZone r5 = org.joda.time.DateTimeZone.getDefault()
        L_0x0006:
            java.util.concurrent.ConcurrentHashMap<org.joda.time.DateTimeZone, org.joda.time.chrono.JulianChronology[]> r0 = cCache
            java.lang.Object r1 = r0.get(r5)
            org.joda.time.chrono.JulianChronology[] r1 = (org.joda.time.chrono.JulianChronology[]) r1
            if (r1 != 0) goto L_0x001c
            r1 = 7
            org.joda.time.chrono.JulianChronology[] r1 = new org.joda.time.chrono.JulianChronology[r1]
            java.lang.Object r0 = r0.putIfAbsent(r5, r1)
            org.joda.time.chrono.JulianChronology[] r0 = (org.joda.time.chrono.JulianChronology[]) r0
            if (r0 == 0) goto L_0x001c
            r1 = r0
        L_0x001c:
            int r0 = r6 + -1
            r2 = r1[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0049 }
            if (r2 != 0) goto L_0x0048
            monitor-enter(r1)
            r2 = r1[r0]     // Catch:{ all -> 0x0045 }
            if (r2 != 0) goto L_0x0043
            org.joda.time.DateTimeZone r2 = org.joda.time.DateTimeZone.UTC     // Catch:{ all -> 0x0045 }
            r3 = 0
            if (r5 != r2) goto L_0x0032
            org.joda.time.chrono.JulianChronology r5 = new org.joda.time.chrono.JulianChronology     // Catch:{ all -> 0x0045 }
            r5.<init>(r3, r3, r6)     // Catch:{ all -> 0x0045 }
            goto L_0x0040
        L_0x0032:
            org.joda.time.chrono.JulianChronology r2 = getInstance(r2, r6)     // Catch:{ all -> 0x0045 }
            org.joda.time.chrono.JulianChronology r4 = new org.joda.time.chrono.JulianChronology     // Catch:{ all -> 0x0045 }
            org.joda.time.chrono.ZonedChronology r5 = org.joda.time.chrono.ZonedChronology.getInstance(r2, r5)     // Catch:{ all -> 0x0045 }
            r4.<init>(r5, r3, r6)     // Catch:{ all -> 0x0045 }
            r5 = r4
        L_0x0040:
            r1[r0] = r5     // Catch:{ all -> 0x0045 }
            r2 = r5
        L_0x0043:
            monitor-exit(r1)     // Catch:{ all -> 0x0045 }
            goto L_0x0048
        L_0x0045:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0045 }
            throw r5
        L_0x0048:
            return r2
        L_0x0049:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid min days in first week: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.JulianChronology.getInstance(org.joda.time.DateTimeZone, int):org.joda.time.chrono.JulianChronology");
    }
}
