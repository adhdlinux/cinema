package com.iab.omid.library.adcolony.walking.a;

import com.iab.omid.library.adcolony.b.a;
import com.iab.omid.library.adcolony.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public class e extends a {
    public e(b.C0044b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    private void e(String str) {
        a a2 = a.a();
        if (a2 != null) {
            for (com.iab.omid.library.adcolony.adsession.a next : a2.c()) {
                if (this.f31448c.contains(next.e())) {
                    next.v().p(str, this.f31450e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        e(str);
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String doInBackground(Object... objArr) {
        return this.f31449d.toString();
    }
}
