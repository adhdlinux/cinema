package com.startapp;

import android.text.TextUtils;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import com.startapp.ig;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public class mg extends hg {
    public mg(ig.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    public void a(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = g.f34545a) != null) {
            for (T t2 : Collections.unmodifiableCollection(gVar.f34546b)) {
                if (this.f34671c.contains(t2.f36853i)) {
                    AdSessionStatePublisher adSessionStatePublisher = t2.f36850f;
                    if (this.f34673e >= adSessionStatePublisher.f31613e) {
                        adSessionStatePublisher.f31612d = AdSessionStatePublisher.a.AD_STATE_VISIBLE;
                        l.f34848a.a(adSessionStatePublisher.c(), "setNativeViewHierarchy", str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    public Object doInBackground(Object[] objArr) {
        if (fg.c(this.f34672d, ((gg) this.f34711b).f34602a)) {
            return null;
        }
        ig.b bVar = this.f34711b;
        JSONObject jSONObject = this.f34672d;
        ((gg) bVar).f34602a = jSONObject;
        return jSONObject.toString();
    }
}
