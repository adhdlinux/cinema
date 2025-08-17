package com.iab.omid.library.vungle.walking.async;

import com.iab.omid.library.vungle.adsession.a;
import com.iab.omid.library.vungle.internal.c;
import com.iab.omid.library.vungle.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

public class e extends a {
    public e(b.C0051b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    private void e(String str) {
        c e2 = c.e();
        if (e2 != null) {
            for (a next : e2.c()) {
                if (this.f31785c.contains(next.l())) {
                    next.m().g(str, this.f31787e);
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
        return this.f31786d.toString();
    }
}
