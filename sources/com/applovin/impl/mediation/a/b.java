package com.applovin.impl.mediation.a;

import android.view.View;
import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

public class b extends e {
    private b(b bVar, g gVar) {
        super(bVar.T(), bVar.J(), bVar.I(), gVar, bVar.f14230b);
    }

    public b(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        super(map, jSONObject, jSONObject2, (g) null, mVar);
    }

    public boolean A() {
        return b("proe", (Boolean) this.f14230b.a(a.J)).booleanValue();
    }

    public long B() {
        return Utils.parseColor(b("bg_color", (String) null));
    }

    public a a(g gVar) {
        return new b(this, gVar);
    }

    public int u() {
        int b2 = b("ad_view_width", -2);
        if (b2 != -2) {
            return b2;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public int v() {
        int b2 = b("ad_view_height", -2);
        if (b2 != -2) {
            return b2;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public View w() {
        g gVar;
        if (!e() || (gVar = this.f14220a) == null) {
            return null;
        }
        return gVar.a();
    }

    public long x() {
        return b("viewability_imp_delay_ms", ((Long) this.f14230b.a(com.applovin.impl.sdk.c.b.bI)).longValue());
    }

    public boolean y() {
        return z() >= 0;
    }

    public long z() {
        long b2 = b("ad_refresh_ms", -1);
        return b2 >= 0 ? b2 : a("ad_refresh_ms", ((Long) this.f14230b.a(a.f15191m)).longValue());
    }
}
