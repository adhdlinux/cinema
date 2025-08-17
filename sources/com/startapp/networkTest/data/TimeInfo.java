package com.startapp.networkTest.data;

import com.startapp.i3;
import com.startapp.networkTest.enums.TimeSources;
import com.startapp.w2;
import java.io.Serializable;
import java.util.TimeZone;

public class TimeInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = 3793653153982296400L;
    public long DeviceDriftMillis;
    public boolean IsSynced;
    public long MillisSinceLastSync;
    public TimeSources TimeSource = TimeSources.Unknown;
    public String TimestampDateTime = "";
    public long TimestampMillis;
    public double TimestampOffset;
    public String TimestampTableau = "";
    public transient int day;
    public transient int hour;
    public transient int millisecond;
    public transient int minute;
    public transient int month;
    public transient int second;
    public transient int year;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setMillis(long j2) {
        this.TimestampTableau = w2.b(j2);
        this.TimestampDateTime = w2.a(j2);
        this.TimestampOffset = (double) (((((float) TimeZone.getDefault().getOffset(j2)) / 1000.0f) / 60.0f) / 60.0f);
        this.TimestampMillis = j2;
        i3 c2 = w2.c(j2);
        this.year = c2.f34678a;
        this.month = c2.f34679b;
        this.day = c2.f34680c;
        this.hour = c2.f34681d;
        this.minute = c2.f34682e;
        this.second = c2.f34683f;
        this.millisecond = c2.f34684g;
    }
}
