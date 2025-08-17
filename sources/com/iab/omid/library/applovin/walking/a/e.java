package com.iab.omid.library.applovin.walking.a;

import com.iab.omid.library.applovin.b.a;
import com.iab.omid.library.applovin.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public class e extends a {
    public e(b.C0047b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    private void b(String str) {
        a a2 = a.a();
        if (a2 != null) {
            for (com.iab.omid.library.applovin.adsession.a next : a2.b()) {
                if (this.f31565a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().b(str, this.f31567c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f31566b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}
