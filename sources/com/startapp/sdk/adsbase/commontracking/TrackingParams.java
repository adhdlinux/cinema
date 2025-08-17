package com.startapp.sdk.adsbase.commontracking;

import com.startapp.hb;
import com.startapp.lb;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.io.Serializable;

public class TrackingParams implements Serializable {
    private static final long serialVersionUID = 1;
    private String adTag;
    private String clientSessionId;
    private String nonImpressionReason;
    private int offset;
    private String profileId;

    public TrackingParams() {
        this((String) null);
    }

    public String a() {
        return this.adTag;
    }

    public int b() {
        return this.offset;
    }

    public String c() {
        if (this.offset <= 0) {
            return "";
        }
        return "&offset=" + this.offset;
    }

    public String d() {
        return this.profileId;
    }

    public String e() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = this.adTag;
        String str5 = "";
        if (str4 == null || str4.equals(str5)) {
            str = str5;
        } else {
            int i2 = 200;
            if (this.adTag.length() < 200) {
                i2 = this.adTag.length();
            }
            str = "&adTag=" + lb.b(this.adTag.substring(0, i2));
        }
        sb.append(str);
        if (this.clientSessionId != null) {
            str2 = "&clientSessionId=" + lb.b(this.clientSessionId);
        } else {
            str2 = str5;
        }
        sb.append(str2);
        if (this.profileId != null) {
            str3 = "&profileId=" + lb.b(this.profileId);
        } else {
            str3 = str5;
        }
        sb.append(str3);
        sb.append(c());
        String str6 = this.nonImpressionReason;
        if (str6 != null && !str6.equals(str5)) {
            str5 = "&isShown=false&reason=" + lb.b(this.nonImpressionReason);
        }
        sb.append(str5);
        return sb.toString();
    }

    public TrackingParams(String str) {
        this.adTag = str;
        this.clientSessionId = hb.f34639a.a();
        this.profileId = MetaData.r().z();
        this.offset = 0;
    }

    public TrackingParams a(int i2) {
        this.offset = i2;
        return this;
    }

    public TrackingParams a(String str) {
        this.nonImpressionReason = str;
        return this;
    }
}
