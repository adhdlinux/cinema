package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private String f13801a;

    /* renamed from: b  reason: collision with root package name */
    private String f13802b;

    /* renamed from: c  reason: collision with root package name */
    private String f13803c;

    /* renamed from: d  reason: collision with root package name */
    private long f13804d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f13805e = -1;

    private j() {
    }

    private static int a(String str, e eVar) {
        if (ViewProps.START.equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (eVar != null) {
            return eVar.h();
        }
        return 95;
    }

    public static j a(r rVar, e eVar, m mVar) {
        List<String> explode;
        int size;
        TimeUnit timeUnit;
        long seconds;
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                String c2 = rVar.c();
                if (StringUtils.isValidString(c2)) {
                    j jVar = new j();
                    jVar.f13803c = c2;
                    jVar.f13801a = rVar.b().get("id");
                    jVar.f13802b = rVar.b().get("event");
                    jVar.f13805e = a(jVar.a(), eVar);
                    String str = rVar.b().get("offset");
                    if (StringUtils.isValidString(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            jVar.f13805e = StringUtils.parseInt(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(":") && (size = explode.size()) > 0) {
                            int i2 = size - 1;
                            long j2 = 0;
                            for (int i3 = i2; i3 >= 0; i3--) {
                                String str2 = (explode = CollectionUtils.explode(trim, ":")).get(i3);
                                if (StringUtils.isNumeric(str2)) {
                                    int parseInt = Integer.parseInt(str2);
                                    if (i3 == i2) {
                                        seconds = (long) parseInt;
                                    } else {
                                        if (i3 == size - 2) {
                                            timeUnit = TimeUnit.MINUTES;
                                        } else if (i3 == size - 3) {
                                            timeUnit = TimeUnit.HOURS;
                                        }
                                        seconds = timeUnit.toSeconds((long) parseInt);
                                    }
                                    j2 += seconds;
                                }
                            }
                            jVar.f13804d = j2;
                            jVar.f13805e = -1;
                        }
                    }
                    return jVar;
                } else if (!v.a()) {
                    return null;
                } else {
                    mVar.A().e("VastTracker", "Unable to create tracker. Could not find URL.");
                    return null;
                }
            } catch (Throwable th) {
                if (!v.a()) {
                    return null;
                }
                mVar.A().b("VastTracker", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public String a() {
        return this.f13802b;
    }

    public boolean a(long j2, int i2) {
        long j3 = this.f13804d;
        boolean z2 = j3 >= 0;
        boolean z3 = j2 >= j3;
        int i3 = this.f13805e;
        boolean z4 = i3 >= 0;
        boolean z5 = i2 >= i3;
        if (!z2 || !z3) {
            return z4 && z5;
        }
        return true;
    }

    public String b() {
        return this.f13803c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f13804d != jVar.f13804d || this.f13805e != jVar.f13805e) {
            return false;
        }
        String str = this.f13801a;
        if (str == null ? jVar.f13801a != null : !str.equals(jVar.f13801a)) {
            return false;
        }
        String str2 = this.f13802b;
        if (str2 == null ? jVar.f13802b == null : str2.equals(jVar.f13802b)) {
            return this.f13803c.equals(jVar.f13803c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f13801a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f13802b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        long j2 = this.f13804d;
        return ((((((hashCode + i2) * 31) + this.f13803c.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f13805e;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f13801a + '\'' + ", event='" + this.f13802b + '\'' + ", uriString='" + this.f13803c + '\'' + ", offsetSeconds=" + this.f13804d + ", offsetPercent=" + this.f13805e + '}';
    }
}
