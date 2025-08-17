package org.joda.time.chrono;

import com.vungle.ads.internal.signals.SignalManager;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.SkipDateTimeField;

public final class EthiopicChronology extends BasicFixedMonthChronology {
    public static final int EE = 1;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("EE");
    private static final EthiopicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    private static final int MAX_YEAR = 292272984;
    private static final int MIN_YEAR = -292269337;
    private static final ConcurrentHashMap<DateTimeZone, EthiopicChronology[]> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -5972804258688333942L;

    EthiopicChronology(Chronology chronology, Object obj, int i2) {
        super(chronology, obj, i2);
    }

    public static EthiopicChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static EthiopicChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        DateTimeZone dateTimeZone;
        Chronology base = getBase();
        if (base == null) {
            dateTimeZone = DateTimeZone.UTC;
        } else {
            dateTimeZone = base.getZone();
        }
        return getInstance(dateTimeZone, getMinimumDaysInFirstWeek());
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        if (getBase() == null) {
            super.assemble(fields);
            fields.year = new SkipDateTimeField(this, fields.year);
            fields.weekyear = new SkipDateTimeField(this, fields.weekyear);
            fields.era = ERA_FIELD;
            BasicMonthOfYearDateTimeField basicMonthOfYearDateTimeField = new BasicMonthOfYearDateTimeField(this, 13);
            fields.monthOfYear = basicMonthOfYearDateTimeField;
            fields.months = basicMonthOfYearDateTimeField.getDurationField();
        }
    }

    /* access modifiers changed from: package-private */
    public long calculateFirstDayOfYearMillis(int i2) {
        int i3;
        int i4 = i2 - 1963;
        if (i4 <= 0) {
            i3 = (i4 + 3) >> 2;
        } else {
            int i5 = i4 >> 2;
            i3 = !isLeapYear(i2) ? i5 + 1 : i5;
        }
        return (((((long) i4) * 365) + ((long) i3)) * SignalManager.TWENTY_FOUR_HOURS_MILLIS) + 21859200000L;
    }

    /* access modifiers changed from: package-private */
    public long getApproxMillisAtEpochDividedByTwo() {
        return 30962844000000L;
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
    public boolean isLeapDay(long j2) {
        return dayOfMonth().get(j2) == 6 && monthOfYear().isLeap(j2);
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

    public static EthiopicChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r1 = new org.joda.time.chrono.EthiopicChronology[7];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.chrono.EthiopicChronology getInstance(org.joda.time.DateTimeZone r13, int r14) {
        /*
            if (r13 != 0) goto L_0x0006
            org.joda.time.DateTimeZone r13 = org.joda.time.DateTimeZone.getDefault()
        L_0x0006:
            java.util.concurrent.ConcurrentHashMap<org.joda.time.DateTimeZone, org.joda.time.chrono.EthiopicChronology[]> r0 = cCache
            java.lang.Object r1 = r0.get(r13)
            org.joda.time.chrono.EthiopicChronology[] r1 = (org.joda.time.chrono.EthiopicChronology[]) r1
            if (r1 != 0) goto L_0x001c
            r1 = 7
            org.joda.time.chrono.EthiopicChronology[] r1 = new org.joda.time.chrono.EthiopicChronology[r1]
            java.lang.Object r0 = r0.putIfAbsent(r13, r1)
            org.joda.time.chrono.EthiopicChronology[] r0 = (org.joda.time.chrono.EthiopicChronology[]) r0
            if (r0 == 0) goto L_0x001c
            r1 = r0
        L_0x001c:
            int r0 = r14 + -1
            r2 = r1[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x005f }
            if (r2 != 0) goto L_0x005e
            monitor-enter(r1)
            r2 = r1[r0]     // Catch:{ all -> 0x005b }
            if (r2 != 0) goto L_0x0059
            org.joda.time.DateTimeZone r2 = org.joda.time.DateTimeZone.UTC     // Catch:{ all -> 0x005b }
            r3 = 0
            if (r13 != r2) goto L_0x0049
            org.joda.time.chrono.EthiopicChronology r13 = new org.joda.time.chrono.EthiopicChronology     // Catch:{ all -> 0x005b }
            r13.<init>(r3, r3, r14)     // Catch:{ all -> 0x005b }
            org.joda.time.DateTime r2 = new org.joda.time.DateTime     // Catch:{ all -> 0x005b }
            r5 = 1
            r6 = 1
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r2
            r12 = r13
            r4.<init>((int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (int) r10, (int) r11, (org.joda.time.Chronology) r12)     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.EthiopicChronology r4 = new org.joda.time.chrono.EthiopicChronology     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.LimitChronology r13 = org.joda.time.chrono.LimitChronology.getInstance(r13, r2, r3)     // Catch:{ all -> 0x005b }
            r4.<init>(r13, r3, r14)     // Catch:{ all -> 0x005b }
            goto L_0x0056
        L_0x0049:
            org.joda.time.chrono.EthiopicChronology r2 = getInstance(r2, r14)     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.EthiopicChronology r4 = new org.joda.time.chrono.EthiopicChronology     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.ZonedChronology r13 = org.joda.time.chrono.ZonedChronology.getInstance(r2, r13)     // Catch:{ all -> 0x005b }
            r4.<init>(r13, r3, r14)     // Catch:{ all -> 0x005b }
        L_0x0056:
            r1[r0] = r4     // Catch:{ all -> 0x005b }
            r2 = r4
        L_0x0059:
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            goto L_0x005e
        L_0x005b:
            r13 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            throw r13
        L_0x005e:
            return r2
        L_0x005f:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid min days in first week: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.EthiopicChronology.getInstance(org.joda.time.DateTimeZone, int):org.joda.time.chrono.EthiopicChronology");
    }
}
