package com.iab.omid.library.vungle.walking.async;

import android.text.TextUtils;
import com.iab.omid.library.vungle.adsession.a;
import com.iab.omid.library.vungle.internal.c;
import com.iab.omid.library.vungle.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

public class f extends a {
    public f(b.C0051b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    private void e(String str) {
        c e2 = c.e();
        if (e2 != null) {
            for (a next : e2.c()) {
                if (this.f31785c.contains(next.l())) {
                    next.m().k(str, this.f31787e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String doInBackground(Object... objArr) {
        if (com.iab.omid.library.vungle.utils.c.v(this.f31786d, this.f31789b.a())) {
            return null;
        }
        this.f31789b.a(this.f31786d);
        return this.f31786d.toString();
    }
}
