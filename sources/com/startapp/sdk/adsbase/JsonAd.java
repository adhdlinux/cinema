package com.startapp.sdk.adsbase;

import android.content.Context;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class JsonAd extends Ad {
    private static final long serialVersionUID = 1;
    private List<AdDetails> adsDetails = null;

    public JsonAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
    }

    public void a(List<AdDetails> list) {
        boolean z2;
        this.adsDetails = list;
        Long l2 = null;
        for (AdDetails next : list) {
            if (!(next == null || next.x() == null)) {
                if (l2 == null || next.x().longValue() < l2.longValue()) {
                    l2 = next.x();
                }
            }
        }
        if (l2 != null) {
            this.adCacheTtl = Long.valueOf(TimeUnit.SECONDS.toMillis(l2.longValue()));
        }
        Iterator<AdDetails> it2 = this.adsDetails.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (!it2.next().n()) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        this.belowMinCPM = z2;
    }

    public List<AdDetails> g() {
        return this.adsDetails;
    }

    public String getAdId() {
        List<AdDetails> list = this.adsDetails;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.adsDetails.get(0).a();
    }

    public String getBidToken() {
        List<AdDetails> list = this.adsDetails;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.adsDetails.get(0).d();
    }
}
