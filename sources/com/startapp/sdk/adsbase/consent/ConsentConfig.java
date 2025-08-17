package com.startapp.sdk.adsbase.consent;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public final class ConsentConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean allowCT;
    private String clickUrl;
    private Integer consentType;
    @j0(complex = true)
    private ConsentTypeInfoConfig consentTypeInfo;
    private String dParam;
    private boolean detectConsentCovering;
    private String impressionUrl;
    private String template;
    private Integer templateId;
    private Integer templateName;
    private long timeStamp = 0;

    public String a() {
        return this.clickUrl;
    }

    public Integer b() {
        return this.consentType;
    }

    public ConsentTypeInfoConfig c() {
        return this.consentTypeInfo;
    }

    public String d() {
        return this.dParam;
    }

    public String e() {
        return this.impressionUrl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ConsentConfig.class != obj.getClass()) {
            return false;
        }
        ConsentConfig consentConfig = (ConsentConfig) obj;
        if (this.allowCT != consentConfig.allowCT || this.detectConsentCovering != consentConfig.detectConsentCovering || this.timeStamp != consentConfig.timeStamp || !lb.a(this.template, consentConfig.template) || !lb.a(this.impressionUrl, consentConfig.impressionUrl) || !lb.a(this.clickUrl, consentConfig.clickUrl) || !lb.a(this.templateName, consentConfig.templateName) || !lb.a(this.templateId, consentConfig.templateId) || !lb.a(this.dParam, consentConfig.dParam) || !lb.a(this.consentTypeInfo, consentConfig.consentTypeInfo)) {
            return false;
        }
        return true;
    }

    public String f() {
        return this.template;
    }

    public Integer g() {
        return this.templateId;
    }

    public Integer h() {
        return this.templateName;
    }

    public int hashCode() {
        Object[] objArr = {Boolean.valueOf(this.allowCT), Boolean.valueOf(this.detectConsentCovering), this.template, Long.valueOf(this.timeStamp), this.impressionUrl, this.clickUrl, this.templateName, this.templateId, this.dParam, this.consentTypeInfo};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public long i() {
        return this.timeStamp;
    }

    public boolean j() {
        return this.detectConsentCovering;
    }

    public boolean k() {
        return this.allowCT;
    }
}
