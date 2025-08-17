package com.applovin.impl.a;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.r;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class e {

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f13764c = Arrays.asList(new String[]{"video/mp4", MimeTypes.VIDEO_WEBM, "video/3gpp", "video/x-matroska"});

    /* renamed from: a  reason: collision with root package name */
    protected List<r> f13765a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final m f13766b;

    /* renamed from: d  reason: collision with root package name */
    private final JSONObject f13767d;

    /* renamed from: e  reason: collision with root package name */
    private final JSONObject f13768e;

    /* renamed from: f  reason: collision with root package name */
    private final b f13769f;

    /* renamed from: g  reason: collision with root package name */
    private final long f13770g = System.currentTimeMillis();

    public e(JSONObject jSONObject, JSONObject jSONObject2, b bVar, m mVar) {
        this.f13766b = mVar;
        this.f13767d = jSONObject;
        this.f13768e = jSONObject2;
        this.f13769f = bVar;
    }

    public int a() {
        return this.f13765a.size();
    }

    public List<r> b() {
        return this.f13765a;
    }

    public JSONObject c() {
        return this.f13767d;
    }

    public JSONObject d() {
        return this.f13768e;
    }

    public b e() {
        return this.f13769f;
    }

    public long f() {
        return this.f13770g;
    }

    public List<String> g() {
        List<String> explode = CollectionUtils.explode(JsonUtils.getString(this.f13767d, "vast_preferred_video_types", (String) null));
        return !explode.isEmpty() ? explode : f13764c;
    }

    public int h() {
        return Utils.getVideoCompletionPercent(this.f13767d);
    }
}
