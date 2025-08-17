package com.startapp.sdk.insight;

import com.vungle.ads.internal.signals.SignalManager;
import java.io.Serializable;

public class NetworkTestsMetaData implements Serializable {
    private static final long serialVersionUID = 1;
    private String connectivityTestCdnconfigUrl = "https://d2to8y50b3n6dq.cloudfront.net/truststores/[PROJECTID]/cdnconfig.zip";
    private boolean connectivityTestEnabled = true;
    private String connectivityTestFilename = "/favicon.ico";
    private String connectivityTestHostname = "d2to8y50b3n6dq.cloudfront.net";
    private boolean ctCollectCellinfoEnabled = true;
    private long ctltIntervalMilli = 900000;
    private boolean enabled = false;
    private boolean enabledCachedProcess;
    private String geoipUrl = "https://geoip.api.p3insight.de/geoip/";
    private long guardDiffMilli = 120000;
    private String hostCt;
    private String hostLt;
    private String hostNir;
    private double iep = 0.0d;
    private boolean nirCollectCellinfoEnabled = true;
    private int numberOfRecordsMax = 10000;
    private int numberOfRecordsMin = 5000;
    private String projectId = "20050";
    private long sendIntervalMilli = 7200000;
    private long ttl = SignalManager.TWENTY_FOUR_HOURS_MILLIS;

    public String a() {
        return this.connectivityTestCdnconfigUrl;
    }

    public String b() {
        return this.connectivityTestFilename;
    }

    public String c() {
        return this.connectivityTestHostname;
    }

    public long d() {
        return this.ctltIntervalMilli;
    }

    public String e() {
        return this.geoipUrl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NetworkTestsMetaData.class != obj.getClass()) {
            return false;
        }
        NetworkTestsMetaData networkTestsMetaData = (NetworkTestsMetaData) obj;
        if (this.numberOfRecordsMin != networkTestsMetaData.numberOfRecordsMin || this.numberOfRecordsMax != networkTestsMetaData.numberOfRecordsMax || this.enabled != networkTestsMetaData.enabled || this.enabledCachedProcess != networkTestsMetaData.enabledCachedProcess || this.connectivityTestEnabled != networkTestsMetaData.connectivityTestEnabled || this.nirCollectCellinfoEnabled != networkTestsMetaData.nirCollectCellinfoEnabled || this.ctCollectCellinfoEnabled != networkTestsMetaData.ctCollectCellinfoEnabled || this.ctltIntervalMilli != networkTestsMetaData.ctltIntervalMilli || this.sendIntervalMilli != networkTestsMetaData.sendIntervalMilli || this.ttl != networkTestsMetaData.ttl) {
            return false;
        }
        String str = this.hostCt;
        if (str == null ? networkTestsMetaData.hostCt != null : !str.equals(networkTestsMetaData.hostCt)) {
            return false;
        }
        String str2 = this.hostLt;
        if (str2 == null ? networkTestsMetaData.hostLt != null : !str2.equals(networkTestsMetaData.hostLt)) {
            return false;
        }
        String str3 = this.hostNir;
        if (str3 == null ? networkTestsMetaData.hostNir != null : !str3.equals(networkTestsMetaData.hostNir)) {
            return false;
        }
        String str4 = this.projectId;
        if (str4 == null ? networkTestsMetaData.projectId != null : !str4.equals(networkTestsMetaData.projectId)) {
            return false;
        }
        String str5 = this.connectivityTestHostname;
        if (str5 == null ? networkTestsMetaData.connectivityTestHostname != null : !str5.equals(networkTestsMetaData.connectivityTestHostname)) {
            return false;
        }
        String str6 = this.connectivityTestFilename;
        if (str6 == null ? networkTestsMetaData.connectivityTestFilename != null : !str6.equals(networkTestsMetaData.connectivityTestFilename)) {
            return false;
        }
        String str7 = this.connectivityTestCdnconfigUrl;
        if (str7 == null ? networkTestsMetaData.connectivityTestCdnconfigUrl != null : !str7.equals(networkTestsMetaData.connectivityTestCdnconfigUrl)) {
            return false;
        }
        String str8 = this.geoipUrl;
        String str9 = networkTestsMetaData.geoipUrl;
        if (str8 != null) {
            return str8.equals(str9);
        }
        if (str9 == null) {
            return true;
        }
        return false;
    }

    public long f() {
        return this.guardDiffMilli;
    }

    public String g() {
        return this.hostCt;
    }

    public String h() {
        return this.hostLt;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String str = this.hostCt;
        int i9 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i10 = i2 * 31;
        String str2 = this.hostLt;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i11 = (i10 + i3) * 31;
        String str3 = this.hostNir;
        if (str3 != null) {
            i4 = str3.hashCode();
        } else {
            i4 = 0;
        }
        int i12 = (((((((((i11 + i4) * 31) + this.numberOfRecordsMin) * 31) + this.numberOfRecordsMax) * 31) + (this.enabled ? 1 : 0)) * 31) + (this.enabledCachedProcess ? 1 : 0)) * 31;
        String str4 = this.projectId;
        if (str4 != null) {
            i5 = str4.hashCode();
        } else {
            i5 = 0;
        }
        int i13 = (i12 + i5) * 31;
        String str5 = this.connectivityTestHostname;
        if (str5 != null) {
            i6 = str5.hashCode();
        } else {
            i6 = 0;
        }
        int i14 = (i13 + i6) * 31;
        String str6 = this.connectivityTestFilename;
        if (str6 != null) {
            i7 = str6.hashCode();
        } else {
            i7 = 0;
        }
        int i15 = (((((((i14 + i7) * 31) + (this.connectivityTestEnabled ? 1 : 0)) * 31) + (this.nirCollectCellinfoEnabled ? 1 : 0)) * 31) + (this.ctCollectCellinfoEnabled ? 1 : 0)) * 31;
        String str7 = this.connectivityTestCdnconfigUrl;
        if (str7 != null) {
            i8 = str7.hashCode();
        } else {
            i8 = 0;
        }
        int i16 = (i15 + i8) * 31;
        String str8 = this.geoipUrl;
        if (str8 != null) {
            i9 = str8.hashCode();
        }
        long j2 = this.ctltIntervalMilli;
        long j3 = this.sendIntervalMilli;
        long j4 = this.ttl;
        return ((((((i16 + i9) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public String i() {
        return this.hostNir;
    }

    public double j() {
        return this.iep;
    }

    public String k() {
        return this.projectId;
    }

    public boolean l() {
        return this.connectivityTestEnabled;
    }

    public boolean m() {
        return this.ctCollectCellinfoEnabled;
    }

    public boolean n() {
        return this.enabled;
    }

    public boolean o() {
        return this.enabledCachedProcess;
    }

    public boolean p() {
        return this.nirCollectCellinfoEnabled;
    }
}
