package com.applovin.impl.mediation.a;

import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends a {
    protected e(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, g gVar, m mVar) {
        super(map, jSONObject, jSONObject2, gVar, mVar);
    }

    public int C() {
        MaxAdFormat format = getFormat();
        b bVar = format == MaxAdFormat.BANNER ? b.bJ : format == MaxAdFormat.MREC ? b.bL : format == MaxAdFormat.LEADER ? b.bN : format == MaxAdFormat.NATIVE ? b.bP : null;
        if (bVar != null) {
            return b("viewability_min_width", ((Integer) this.f14230b.a(bVar)).intValue());
        }
        return 0;
    }

    public int D() {
        MaxAdFormat format = getFormat();
        b bVar = format == MaxAdFormat.BANNER ? b.bK : format == MaxAdFormat.MREC ? b.bM : format == MaxAdFormat.LEADER ? b.bO : format == MaxAdFormat.NATIVE ? b.bQ : null;
        if (bVar != null) {
            return b("viewability_min_height", ((Integer) this.f14230b.a(bVar)).intValue());
        }
        return 0;
    }

    public float E() {
        return a("viewability_min_alpha", ((Float) this.f14230b.a(b.bR)).floatValue() / 100.0f);
    }

    public int F() {
        return b("viewability_min_pixels", -1);
    }

    public boolean G() {
        return F() >= 0;
    }

    public long H() {
        return b("viewability_timer_min_visible_ms", ((Long) this.f14230b.a(b.bS)).longValue());
    }
}
