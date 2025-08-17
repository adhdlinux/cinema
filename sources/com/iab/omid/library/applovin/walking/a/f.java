package com.iab.omid.library.applovin.walking.a;

import android.text.TextUtils;
import com.iab.omid.library.applovin.b.a;
import com.iab.omid.library.applovin.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public class f extends a {
    public f(b.C0047b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    private void b(String str) {
        a a2 = a.a();
        if (a2 != null) {
            for (com.iab.omid.library.applovin.adsession.a next : a2.b()) {
                if (this.f31565a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().a(str, this.f31567c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (com.iab.omid.library.applovin.d.b.b(this.f31566b, this.f31569d.b())) {
            return null;
        }
        this.f31569d.a(this.f31566b);
        return this.f31566b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        super.onPostExecute(str);
    }
}
