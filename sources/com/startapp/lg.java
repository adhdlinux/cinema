package com.startapp;

import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import com.startapp.ig;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public class lg extends hg {
    public lg(ig.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    public void a(String str) {
        AdSessionStatePublisher.a aVar;
        g gVar = g.f34545a;
        if (gVar != null) {
            for (T t2 : Collections.unmodifiableCollection(gVar.f34546b)) {
                if (this.f34671c.contains(t2.f36853i)) {
                    AdSessionStatePublisher adSessionStatePublisher = t2.f36850f;
                    if (this.f34673e >= adSessionStatePublisher.f31613e && adSessionStatePublisher.f31612d != (aVar = AdSessionStatePublisher.a.AD_STATE_NOTVISIBLE)) {
                        adSessionStatePublisher.f31612d = aVar;
                        l.f34848a.a(adSessionStatePublisher.c(), "setNativeViewHierarchy", str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    public Object doInBackground(Object[] objArr) {
        return this.f34672d.toString();
    }
}
