package org.joda.time.chrono;

import com.vungle.ads.internal.signals.SignalManager;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;

public final class GregorianChronology extends BasicGJChronology {
    private static final int DAYS_0000_TO_1970 = 719527;
    private static final GregorianChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    private static final int MAX_YEAR = 292278993;
    private static final long MILLIS_PER_MONTH = 2629746000L;
    private static final long MILLIS_PER_YEAR = 31556952000L;
    private static final int MIN_YEAR = -292275054;
    private static final ConcurrentHashMap<DateTimeZone, GregorianChronology[]> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -861407383323710522L;

    private GregorianChronology(Chronology chronology, Object obj, int i2) {
        super(chronology, obj, i2);
    }

    public static GregorianChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static GregorianChronology getInstanceUTC() {
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
        }
    }

    /* access modifiers changed from: package-private */
    public long calculateFirstDayOfYearMillis(int i2) {
        int i3;
        int i4 = i2 / 100;
        if (i2 < 0) {
            i3 = ((((i2 + 3) >> 2) - i4) + ((i4 + 3) >> 2)) - 1;
        } else {
            i3 = ((i2 >> 2) - i4) + (i4 >> 2);
            if (isLeapYear(i2)) {
                i3--;
            }
        }
        return ((((long) i2) * 365) + ((long) (i3 - DAYS_0000_TO_1970))) * SignalManager.TWENTY_FOUR_HOURS_MILLIS;
    }

    /* access modifiers changed from: package-private */
    public long getApproxMillisAtEpochDividedByTwo() {
        return 31083597720000L;
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
        return 15778476000L;
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
        return (i2 & 3) == 0 && (i2 % 100 != 0 || i2 % 400 == 0);
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

    public static GregorianChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r1 = new org.joda.time.chrono.GregorianChronology[7];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.chrono.GregorianChronology getInstance(org.joda.time.DateTimeZone r5, int r6) {
        /*
            if (r5 != 0) goto L_0x0006
            org.joda.time.DateTimeZone r5 = org.joda.time.DateTimeZone.getDefault()
        L_0x0006:
            java.util.concurrent.ConcurrentHashMap<org.joda.time.DateTimeZone, org.joda.time.chrono.GregorianChronology[]> r0 = cCache
            java.lang.Object r1 = r0.get(r5)
            org.joda.time.chrono.GregorianChronology[] r1 = (org.joda.time.chrono.GregorianChronology[]) r1
            if (r1 != 0) goto L_0x001c
            r1 = 7
            org.joda.time.chrono.GregorianChronology[] r1 = new org.joda.time.chrono.GregorianChronology[r1]
            java.lang.Object r0 = r0.putIfAbsent(r5, r1)
            org.joda.time.chrono.GregorianChronology[] r0 = (org.joda.time.chrono.GregorianChronology[]) r0
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
            org.joda.time.chrono.GregorianChronology r5 = new org.joda.time.chrono.GregorianChronology     // Catch:{ all -> 0x0045 }
            r5.<init>(r3, r3, r6)     // Catch:{ all -> 0x0045 }
            goto L_0x0040
        L_0x0032:
            org.joda.time.chrono.GregorianChronology r2 = getInstance(r2, r6)     // Catch:{ all -> 0x0045 }
            org.joda.time.chrono.GregorianChronology r4 = new org.joda.time.chrono.GregorianChronology     // Catch:{ all -> 0x0045 }
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
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.GregorianChronology.getInstance(org.joda.time.DateTimeZone, int):org.joda.time.chrono.GregorianChronology");
    }
}
