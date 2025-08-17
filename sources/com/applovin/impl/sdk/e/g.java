package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import com.applovin.impl.adview.d;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f15357a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final AppLovinPostbackListener f15358c;

    /* renamed from: d  reason: collision with root package name */
    private final o.a f15359d;

    public g(i iVar, o.a aVar, m mVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", mVar);
        if (iVar != null) {
            this.f15357a = iVar;
            this.f15358c = appLovinPostbackListener;
            this.f15359d = aVar;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    public void a() {
        AnonymousClass2 r02 = new u<Object>(this.f15357a, d()) {

            /* renamed from: a  reason: collision with root package name */
            final String f15361a;

            {
                this.f15361a = g.this.f15357a.a();
            }

            public void a(int i2, String str, Object obj) {
                if (v.a()) {
                    d("Failed to dispatch postback. Error code: " + i2 + " URL: " + this.f15361a);
                }
                if (g.this.f15358c != null) {
                    g.this.f15358c.onPostbackFailure(this.f15361a, i2);
                }
                if (g.this.f15357a.p()) {
                    this.f15333b.ag().a(g.this.f15357a.q(), this.f15361a, i2, obj, str, false);
                }
            }

            public void a(Object obj, int i2) {
                if (obj instanceof String) {
                    for (String next : this.f15333b.b(b.aO)) {
                        if (next.startsWith(next)) {
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    h.d(jSONObject, this.f15333b);
                                    h.c(jSONObject, this.f15333b);
                                    h.e(jSONObject, this.f15333b);
                                    break;
                                } catch (JSONException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                if (g.this.f15358c != null) {
                    g.this.f15358c.onPostbackSuccess(this.f15361a);
                }
                if (g.this.f15357a.p()) {
                    this.f15333b.ag().a(g.this.f15357a.q(), this.f15361a, i2, obj, (String) null, true);
                }
            }
        };
        r02.a(this.f15359d);
        d().S().a((a) r02);
    }

    public void run() {
        if (!StringUtils.isValidString(this.f15357a.a())) {
            if (v.a()) {
                b("Requested URL is not valid; nothing to do...");
            }
            AppLovinPostbackListener appLovinPostbackListener = this.f15358c;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(this.f15357a.a(), AppLovinErrorCodes.INVALID_URL);
            }
        } else if (this.f15357a.r()) {
            d.a(this.f15357a, d(), new AppLovinPostbackListener() {
                public void onPostbackFailure(String str, int i2) {
                    g.this.a();
                }

                public void onPostbackSuccess(String str) {
                    if (g.this.f15358c != null) {
                        g.this.f15358c.onPostbackSuccess(g.this.f15357a.a());
                    }
                }
            });
        } else {
            a();
        }
    }
}
