package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.internal.n.g;
import com.facebook.ads.internal.n.l;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class x extends b {

    /* renamed from: c  reason: collision with root package name */
    private final y f19999c;

    /* renamed from: d  reason: collision with root package name */
    private l f20000d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20001e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20002f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20003g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20004h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20005i;

    /* renamed from: j  reason: collision with root package name */
    private View f20006j;

    /* renamed from: k  reason: collision with root package name */
    private g f20007k;

    /* renamed from: l  reason: collision with root package name */
    private List<View> f20008l;

    /* renamed from: m  reason: collision with root package name */
    private a f20009m = a.ALL;

    public enum a {
        ALL("all"),
        NONE("none"),
        MANUAL("manual");
        

        /* renamed from: d  reason: collision with root package name */
        private final String f20014d;

        private a(String str) {
            this.f20014d = str;
        }

        public String toString() {
            return this.f20014d;
        }
    }

    public x(Context context, c cVar, com.facebook.ads.internal.r.a aVar, y yVar) {
        super(context, cVar, aVar);
        this.f19999c = yVar;
    }

    private String b(View view) {
        try {
            return c(view).toString();
        } catch (JSONException unused) {
            return "Json exception";
        }
    }

    private JSONObject c(View view) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        boolean z2 = true;
        jSONObject.putOpt("origin", String.format("{x:%d, y:%d}", new Object[]{Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())}));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        List<View> list = this.f20008l;
        if (list == null || !list.contains(view)) {
            z2 = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z2));
        jSONObject.putOpt("type", view instanceof Button ? "button" : view instanceof TextView ? "text" : view instanceof ImageView ? "image" : view instanceof MediaView ? "mediaview" : view instanceof ViewGroup ? "viewgroup" : "unknown");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                jSONArray.put(c(viewGroup.getChildAt(i2)));
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    private String d(View view) {
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
                view.draw(new Canvas(createBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.JPEG, this.f19999c.h(), byteArrayOutputStream);
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public void a(View view) {
        this.f20006j = view;
    }

    public void a(a aVar) {
        this.f20009m = aVar;
    }

    public void a(g gVar) {
        this.f20007k = gVar;
    }

    public void a(l lVar) {
        this.f20000d = lVar;
    }

    public void a(List<View> list) {
        this.f20008l = list;
    }

    /* access modifiers changed from: protected */
    public void a(Map<String, String> map) {
        if (this.f19999c != null) {
            l lVar = this.f20000d;
            if (lVar != null) {
                map.put("nti", String.valueOf(lVar.c()));
            }
            if (this.f20001e) {
                map.put("nhs", Boolean.TRUE.toString());
            }
            if (this.f20002f) {
                map.put("nmv", Boolean.TRUE.toString());
            }
            if (this.f20003g) {
                map.put("nmvap", Boolean.TRUE.toString());
            }
            if (this.f20006j != null && this.f19999c.e()) {
                map.put("view", b(this.f20006j));
            }
            if (this.f20006j != null && this.f19999c.d()) {
                map.put("snapshot", d(this.f20006j));
            }
            if (this.f20004h) {
                map.put("niv", Boolean.TRUE.toString());
            }
            a aVar = this.f20009m;
            if (aVar != null) {
                map.put("precache_media", aVar.toString());
            }
            if (this.f20005i) {
                map.put("ucvr", Boolean.TRUE.toString());
            }
            g gVar = this.f20007k;
            if (gVar != null) {
                float f2 = com.facebook.ads.internal.q.a.x.f20694b;
                map.put("namw", String.valueOf((int) (((float) gVar.getWidth()) / f2)));
                map.put("namh", String.valueOf((int) (((float) this.f20007k.getHeight()) / f2)));
            }
            this.f19999c.a(map);
        }
    }

    public void a(boolean z2) {
        this.f20001e = z2;
    }

    public void b(boolean z2) {
        this.f20002f = z2;
    }

    public void c(boolean z2) {
        this.f20003g = z2;
    }

    public void d(boolean z2) {
        this.f20004h = z2;
    }

    public void e(boolean z2) {
        this.f20005i = z2;
    }
}
