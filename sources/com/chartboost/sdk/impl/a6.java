package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.pa;
import com.chartboost.sdk.privacy.model.CCPA;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.chartboost.sdk.privacy.model.GDPR;
import com.chartboost.sdk.privacy.model.LGPD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class a6 {

    /* renamed from: a  reason: collision with root package name */
    public final n9 f17206a;

    public a6(n9 n9Var) {
        this.f17206a = n9Var;
    }

    public List a(pa.b bVar) {
        HashMap a2 = this.f17206a.a();
        List<DataUseConsent> a3 = a(a2);
        ArrayList arrayList = new ArrayList();
        HashSet b2 = b(bVar);
        if (b2 != null) {
            for (DataUseConsent dataUseConsent : a3) {
                if (a(b2, dataUseConsent)) {
                    arrayList.add(dataUseConsent);
                }
            }
        } else {
            if (a2.containsKey(CCPA.CCPA_STANDARD)) {
                arrayList.add((DataUseConsent) a2.get(CCPA.CCPA_STANDARD));
            }
            if (a2.containsKey(COPPA.COPPA_STANDARD)) {
                arrayList.add((DataUseConsent) a2.get(COPPA.COPPA_STANDARD));
            }
            if (a2.containsKey(LGPD.LGPD_STANDARD)) {
                arrayList.add((DataUseConsent) a2.get(LGPD.LGPD_STANDARD));
            }
        }
        return arrayList;
    }

    public final HashSet b(pa.b bVar) {
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public final boolean a(HashSet hashSet, DataUseConsent dataUseConsent) {
        if (hashSet.contains(dataUseConsent.getPrivacyStandard())) {
            return true;
        }
        w7.e("Chartboost", "DataUseConsent " + dataUseConsent.getPrivacyStandard() + " is not whitelisted.");
        return false;
    }

    public final List a(HashMap hashMap) {
        HashMap hashMap2 = new HashMap(hashMap);
        hashMap2.remove(GDPR.GDPR_STANDARD);
        return new ArrayList(hashMap2.values());
    }
}
