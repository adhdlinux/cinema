package com.chartboost.sdk.impl;

import com.chartboost.sdk.privacy.model.DataUseConsent;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class z5 {
    public JSONObject a(List list) {
        JSONObject jSONObject = new JSONObject();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            DataUseConsent dataUseConsent = (DataUseConsent) it2.next();
            try {
                jSONObject.put(dataUseConsent.getPrivacyStandard(), dataUseConsent.getConsent());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
