package com.facebook.ads.internal.view.component;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.core.graphics.ColorUtils;
import com.facebook.ads.internal.a.b;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.adapters.a.e;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.a;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.Locale;
import java.util.Map;

public class a extends Button {

    /* renamed from: a  reason: collision with root package name */
    public static final int f21040a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21041b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f21042c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f21043d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21044e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f21045f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final com.facebook.ads.internal.r.a f21046g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final u f21047h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final c f21048i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final a.C0037a f21049j;

    static {
        float f2 = x.f20694b;
        f21041b = (int) (4.0f * f2);
        f21040a = (int) (f2 * 16.0f);
    }

    public a(Context context, boolean z2, boolean z3, String str, d dVar, c cVar, a.C0037a aVar, com.facebook.ads.internal.r.a aVar2, u uVar) {
        super(context);
        this.f21048i = cVar;
        this.f21049j = aVar;
        this.f21044e = z2;
        this.f21045f = str;
        this.f21046g = aVar2;
        this.f21047h = uVar;
        x.a(this, false, 16);
        setGravity(17);
        int i2 = f21040a;
        setPadding(i2, i2, i2, i2);
        setTextColor(dVar.f(z3));
        int e2 = dVar.e(z3);
        int d2 = ColorUtils.d(e2, -16777216, 0.1f);
        Paint paint = new Paint();
        this.f21042c = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(e2);
        if (!z2) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(d2));
            stateListDrawable.addState(new int[0], new ColorDrawable(e2));
            x.a((View) this, (Drawable) stateListDrawable);
        }
    }

    public void a(e eVar, String str, Map<String, String> map) {
        a(eVar.b(), eVar.a(), str, map);
    }

    public void a(String str, final String str2, final String str3, final Map<String, String> map) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.f21048i == null) {
            setVisibility(8);
            return;
        }
        setText(str.toUpperCase(Locale.US));
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                String str2;
                Class<a> cls = a.class;
                try {
                    Uri parse = Uri.parse(str2);
                    a.this.f21046g.a((Map<String, String>) map);
                    map.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(a.this.f21047h.e()));
                    b a2 = com.facebook.ads.internal.a.c.a(a.this.getContext(), a.this.f21048i, str3, parse, map);
                    if (a2 != null) {
                        a2.b();
                    }
                    if (a.this.f21049j != null) {
                        a.this.f21049j.a(a.this.f21045f);
                    }
                } catch (ActivityNotFoundException e2) {
                    e = e2;
                    str = String.valueOf(cls);
                    str2 = "Error while opening " + str2;
                    Log.e(str, str2, e);
                } catch (Exception e3) {
                    e = e3;
                    str = String.valueOf(cls);
                    str2 = "Error executing action";
                    Log.e(str, str2, e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f21044e) {
            this.f21043d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            RectF rectF = this.f21043d;
            int i2 = f21041b;
            canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.f21042c);
        }
        super.onDraw(canvas);
    }
}
