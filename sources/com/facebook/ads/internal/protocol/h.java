package com.facebook.ads.internal.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.q.d.b;
import com.vungle.ads.internal.model.AdPayload;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final a f20584a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f20585b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20586c;

    /* renamed from: d  reason: collision with root package name */
    private final String f20587d;

    /* renamed from: com.facebook.ads.internal.protocol.h$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20588a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.ads.internal.protocol.h$a[] r0 = com.facebook.ads.internal.protocol.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20588a = r0
                com.facebook.ads.internal.protocol.h$a r1 = com.facebook.ads.internal.protocol.h.a.ID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20588a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.protocol.h$a r1 = com.facebook.ads.internal.protocol.h.a.CREATIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.protocol.h.AnonymousClass1.<clinit>():void");
        }
    }

    private enum a {
        ID,
        CREATIVE,
        NONE
    }

    public h(Context context, String str, String str2, f fVar) {
        if (TextUtils.isEmpty(str)) {
            this.f20584a = a.NONE;
            this.f20585b = null;
            this.f20587d = null;
            this.f20586c = null;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = AnonymousClass1.f20588a[a.valueOf(jSONObject.getString("type").toUpperCase()).ordinal()];
            if (i2 == 1) {
                this.f20584a = a.ID;
                this.f20585b = Long.valueOf(jSONObject.getString("bid_id"));
                this.f20587d = jSONObject.getString("device_id");
                this.f20586c = null;
            } else if (i2 == 2) {
                this.f20584a = a.CREATIVE;
                this.f20585b = Long.valueOf(jSONObject.getString("bid_id"));
                this.f20587d = jSONObject.getString("device_id");
                this.f20586c = new JSONObject(jSONObject.getString("payload")).toString();
            } else {
                AdErrorType adErrorType = AdErrorType.BID_PAYLOAD_ERROR;
                throw new b(adErrorType, "Unsupported BidPayload type " + jSONObject.getString("type"));
            }
            if (!jSONObject.getString("sdk_version").equals("4.99.1")) {
                throw new b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for SDK version %s being used on SDK version %s", new Object[]{this.f20585b, jSONObject.getString("sdk_version"), "4.99.1"}));
            } else if (!jSONObject.getString("resolved_placement_id").equals(str2)) {
                throw new b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for placement %s being used on placement %s", new Object[]{this.f20585b, jSONObject.getString("resolved_placement_id"), str2}));
            } else if (jSONObject.getInt(AdPayload.KEY_TEMPLATE) != fVar.a()) {
                throw new b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for template %s being used on template %s", new Object[]{this.f20585b, Integer.valueOf(jSONObject.getInt(AdPayload.KEY_TEMPLATE)), fVar}));
            }
        } catch (JSONException e2) {
            com.facebook.ads.internal.q.d.a.a(context, "api", b.f20744d, (Exception) e2);
            throw new b(AdErrorType.BID_PAYLOAD_ERROR, "Invalid BidPayload", e2);
        }
    }

    public void a(String str) {
        if (!this.f20587d.equals(str)) {
            throw new b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for IDFA %s being used on IDFA %s", new Object[]{this.f20585b, this.f20587d, str}));
        }
    }

    public boolean a() {
        return this.f20584a == a.CREATIVE;
    }

    public String b() {
        return this.f20586c;
    }

    public boolean c() {
        return this.f20584a != a.NONE;
    }

    public String d() {
        Long l2 = this.f20585b;
        if (l2 == null) {
            return null;
        }
        return l2.toString();
    }
}
