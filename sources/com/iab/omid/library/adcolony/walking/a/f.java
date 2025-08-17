package com.iab.omid.library.adcolony.walking.a;

import android.text.TextUtils;
import com.iab.omid.library.adcolony.b.a;
import com.iab.omid.library.adcolony.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public class f extends a {
    public f(b.C0044b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    private void e(String str) {
        a a2 = a.a();
        if (a2 != null) {
            for (com.iab.omid.library.adcolony.adsession.a next : a2.c()) {
                if (this.f31448c.contains(next.e())) {
                    next.v().k(str, this.f31450e);
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
        if (com.iab.omid.library.adcolony.d.b.m(this.f31449d, this.f31452b.b())) {
            return null;
        }
        this.f31452b.a(this.f31449d);
        return this.f31449d.toString();
    }
}
