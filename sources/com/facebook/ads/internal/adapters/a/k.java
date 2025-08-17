package com.facebook.ads.internal.adapters.a;

import android.text.TextUtils;
import com.facebook.ads.internal.adapters.a.b;
import com.facebook.ads.internal.adapters.a.c;
import com.facebook.ads.internal.adapters.a.i;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class k implements Serializable {
    private static final long serialVersionUID = -5352540727250859603L;

    /* renamed from: a  reason: collision with root package name */
    private final i f19741a;

    /* renamed from: b  reason: collision with root package name */
    private final c f19742b;

    /* renamed from: c  reason: collision with root package name */
    private final e f19743c;

    /* renamed from: d  reason: collision with root package name */
    private final a f19744d;

    /* renamed from: e  reason: collision with root package name */
    private final b f19745e;

    /* renamed from: f  reason: collision with root package name */
    private final f f19746f;

    /* renamed from: g  reason: collision with root package name */
    private final String f19747g;

    /* renamed from: h  reason: collision with root package name */
    private int f19748h = 200;

    private k(i iVar, c cVar, e eVar, a aVar, b bVar, f fVar, String str) {
        this.f19741a = iVar;
        this.f19742b = cVar;
        this.f19743c = eVar;
        this.f19744d = aVar;
        this.f19745e = bVar;
        this.f19746f = fVar;
        this.f19747g = str;
    }

    public static k a(JSONObject jSONObject) {
        String str = "";
        i a2 = new i.a().a(jSONObject.optString("advertiser_name")).b(jSONObject.optJSONObject("icon") != null ? jSONObject.optJSONObject("icon").optString(ImagesContract.URL) : str).c(jSONObject.optString("ad_choices_link_url")).d(b(jSONObject)).a();
        c a3 = new c.a().a(jSONObject.optString("title")).b(jSONObject.optString(MediaTrack.ROLE_SUBTITLE)).c(jSONObject.optString("body")).a();
        e eVar = new e(jSONObject.optString("fbad_command"), jSONObject.optString("call_to_action"));
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        j jVar = null;
        a aVar = new a(d.a(optJSONObject != null ? optJSONObject.optJSONObject("portrait") : null), d.a(optJSONObject != null ? optJSONObject.optJSONObject("landscape") : null));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("playable_data");
        if (optJSONObject2 != null) {
            jVar = new j(optJSONObject2.optString("uri"), jSONObject.optInt("skippable_seconds", 0), c(optJSONObject2));
        }
        b.a a4 = new b.a().a(jSONObject.optString("video_url"));
        if (jSONObject.optJSONObject("image") != null) {
            str = jSONObject.optJSONObject("image").optString(ImagesContract.URL);
        }
        return new k(a2, a3, eVar, aVar, a4.b(str).a(jSONObject.optInt("skippable_seconds")).b(jSONObject.optInt("video_duration_sec")).a(jVar).a(), new f(com.facebook.ads.internal.j.c.a(jSONObject.optString("end_card_markup")), jSONObject.optString("activation_command"), a(jSONObject.optJSONArray("end_card_images"))), jSONObject.optString("ct"));
    }

    private static List<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    private static String b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("generic_text");
        return optJSONObject == null ? "Sponsored" : optJSONObject.optString("sponsored", "Sponsored");
    }

    private static String c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("generic_text");
        return optJSONObject == null ? "Rewarded Play" : optJSONObject.optString("rewarded_play_text", "Rewarded Play");
    }

    public i a() {
        return this.f19741a;
    }

    public void a(int i2) {
        this.f19748h = i2;
    }

    public void a(String str) {
        this.f19746f.a(str);
    }

    public c b() {
        return this.f19742b;
    }

    public void b(String str) {
        this.f19745e.a(str);
    }

    public e c() {
        return this.f19743c;
    }

    public a d() {
        return this.f19744d;
    }

    public b e() {
        return this.f19745e;
    }

    public f f() {
        return this.f19746f;
    }

    public String g() {
        return this.f19747g;
    }

    public int h() {
        return this.f19748h;
    }
}
