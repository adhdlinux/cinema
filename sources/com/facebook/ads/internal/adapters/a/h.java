package com.facebook.ads.internal.adapters.a;

import com.facebook.ads.internal.adapters.a.b;
import com.facebook.ads.internal.adapters.a.c;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.Serializable;
import org.json.JSONObject;

public class h implements Serializable {
    private static final long serialVersionUID = 85021702336014823L;

    /* renamed from: a  reason: collision with root package name */
    private final c f19727a;

    /* renamed from: b  reason: collision with root package name */
    private final e f19728b;

    /* renamed from: c  reason: collision with root package name */
    private final b f19729c;

    private h(c cVar, e eVar, b bVar) {
        this.f19727a = cVar;
        this.f19728b = eVar;
        this.f19729c = bVar;
    }

    static h a(JSONObject jSONObject) {
        c a2 = new c.a().a(jSONObject.optString("title")).b(jSONObject.optString(MediaTrack.ROLE_SUBTITLE)).c(jSONObject.optString("body")).a();
        e eVar = new e(jSONObject.optString("fbad_command"), jSONObject.optString("call_to_action"));
        boolean optBoolean = jSONObject.optBoolean("video_autoplay_enabled");
        b.a b2 = new b.a().a(jSONObject.optString("video_url")).a(optBoolean).b(jSONObject.optBoolean("video_autoplay_with_sound"));
        int i2 = 0;
        if (optBoolean) {
            i2 = jSONObject.optInt("unskippable_seconds", 0);
        }
        b.a a3 = b2.a(i2);
        JSONObject optJSONObject = jSONObject.optJSONObject("image");
        if (optJSONObject != null) {
            a3.b(optJSONObject.optString(ImagesContract.URL)).c(optJSONObject.optInt("width")).d(optJSONObject.optInt("height"));
        }
        return new h(a2, eVar, a3.a());
    }

    public c a() {
        return this.f19727a;
    }

    public e b() {
        return this.f19728b;
    }

    public b c() {
        return this.f19729c;
    }
}
