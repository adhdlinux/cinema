package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.k;
import com.applovin.impl.sdk.utils.o;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class n implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final m f15550a;

    /* renamed from: b  reason: collision with root package name */
    private Object f15551b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<View> f15552c = new WeakReference<>((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private i f15553d;

    /* renamed from: e  reason: collision with root package name */
    private o f15554e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f15555f;

    public n(m mVar) {
        this.f15550a = mVar;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [android.widget.ImageButton, android.widget.ImageView, android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(final android.app.Activity r6) {
        /*
            r5 = this;
            r0 = 40
            int r0 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r0)
            int r1 = r0 / 10
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 8388629(0x800015, float:1.1754973E-38)
            r2.<init>(r0, r0, r3)
            r2.setMargins(r1, r1, r1, r1)
            android.widget.ImageButton r0 = new android.widget.ImageButton     // Catch:{ all -> 0x0030 }
            r0.<init>(r6)     // Catch:{ all -> 0x0030 }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ all -> 0x0030 }
            int r4 = com.applovin.sdk.R.drawable.applovin_ic_white_small     // Catch:{ all -> 0x0030 }
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)     // Catch:{ all -> 0x0030 }
            r0.setImageDrawable(r3)     // Catch:{ all -> 0x0030 }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ all -> 0x0030 }
            r0.setScaleType(r3)     // Catch:{ all -> 0x0030 }
            int r3 = r1 * 2
            r0.setPadding(r1, r1, r1, r3)     // Catch:{ all -> 0x0030 }
            goto L_0x004b
        L_0x0030:
            android.widget.Button r0 = new android.widget.Button
            r0.<init>(r6)
            java.lang.String r1 = "ⓘ"
            r0.setText(r1)
            r1 = -1
            r0.setTextColor(r1)
            r1 = 0
            r0.setAllCaps(r1)
            r3 = 1101004800(0x41a00000, float:20.0)
            r4 = 2
            r0.setTextSize(r4, r3)
            r0.setPadding(r1, r1, r1, r1)
        L_0x004b:
            r0.setLayoutParams(r2)
            android.graphics.drawable.Drawable r1 = r5.e()
            r0.setBackground(r1)
            com.applovin.impl.sdk.n$4 r1 = new com.applovin.impl.sdk.n$4
            r1.<init>(r6)
            r0.setOnClickListener(r1)
            boolean r1 = com.applovin.impl.sdk.utils.g.d()
            if (r1 == 0) goto L_0x006c
            r1 = 5
            int r6 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r1)
            float r6 = (float) r6
            r0.setElevation(r6)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.n.a(android.app.Activity):android.view.View");
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        final String f2 = f();
        final WeakReference weakReference = new WeakReference(context);
        new AlertDialog.Builder(context).setTitle("Ad Info").setMessage(f2).setNegativeButton("Close", (DialogInterface.OnClickListener) null).setPositiveButton("Report", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                Context context = (Context) weakReference.get();
                if (context != null) {
                    n.this.a(context, f2);
                }
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str) {
        k kVar = new k();
        kVar.b("Describe your issue below:\n\n\n").a("Ad Info:").a(str).a("\nDebug Info:\n").a("Platform", "fireos".equals(this.f15550a.V().f()) ? "Fire OS" : "Android").a("AppLovin SDK Version", AppLovinSdk.VERSION).a("Plugin Version", this.f15550a.a(b.dz)).a("Ad Review Version", e.a()).a("App Package Name", context.getPackageName()).a("Device", Build.DEVICE).a("OS Version", Build.VERSION.RELEASE).a("AppLovin Random Token", this.f15550a.o()).a(g());
        Intent intent = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.SUBJECT", "MAX Ad Report").setPackage("com.google.android.gm");
        if (this.f15551b instanceof e) {
            intent.putExtra("android.intent.extra.SUBJECT", "AppLovin Ad Report");
            JSONObject originalFullResponse = ((e) this.f15551b).getOriginalFullResponse();
            Uri cacheTextWithFileName = AppLovinContentProviderUtils.cacheTextWithFileName(originalFullResponse.toString(), "ad_response.json");
            if (cacheTextWithFileName != null) {
                intent.putExtra("android.intent.extra.STREAM", cacheTextWithFileName);
            } else {
                kVar.a("\nAd Response:\n");
                kVar.a(originalFullResponse.toString());
            }
        }
        intent.putExtra("android.intent.extra.TEXT", kVar.toString());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setPackage((String) null);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f15550a.ae().b() && this.f15552c.get() == null) {
            Activity a2 = this.f15550a.af().a();
            if (a2 == null) {
                v A = this.f15550a.A();
                A.e("AppLovinSdk", "Failed to display creative debugger button for ad: " + this.f15551b);
                return;
            }
            View findViewById = a2.findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                if (v.a()) {
                    v A2 = this.f15550a.A();
                    A2.b("AppLovinSdk", "Displaying creative debugger button for ad: " + this.f15551b);
                }
                final FrameLayout frameLayout = (FrameLayout) findViewById;
                final View a3 = a(a2);
                frameLayout.addView(a3);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150);
                a3.startAnimation(alphaAnimation);
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (a3.getParent() == null) {
                            frameLayout.addView(a3);
                        }
                    }
                });
                this.f15552c = new WeakReference<>(a3);
            }
        }
    }

    private Drawable e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private String f() {
        k kVar = new k();
        Object obj = this.f15551b;
        if (obj instanceof e) {
            e eVar = (e) obj;
            kVar.a("Network", "APPLOVIN").a(eVar).b(eVar);
        } else if (obj instanceof a) {
            kVar.a((a) obj);
        }
        kVar.a(this.f15550a);
        kVar.a(g());
        return kVar.toString();
    }

    private Bundle g() {
        Bundle b2 = this.f15550a.B().b(Utils.getCurrentAdServeId(this.f15551b));
        if (b2 == null) {
            return null;
        }
        for (String next : b2.keySet()) {
            Object obj = b2.get(next);
            b2.remove(next);
            BundleUtils.put(StringUtils.toHumanReadableString(next), obj, b2);
        }
        return b2;
    }

    public void a() {
        i iVar = this.f15553d;
        if (iVar != null) {
            iVar.b();
        }
        this.f15551b = null;
        this.f15552c = new WeakReference<>((Object) null);
    }

    public void a(Object obj) {
        if (!c.b(obj)) {
            this.f15551b = obj;
            if (((Boolean) this.f15550a.a(b.bH)).booleanValue() && this.f15550a.p().isCreativeDebuggerEnabled()) {
                if (this.f15553d == null) {
                    this.f15553d = new i(this.f15550a, this);
                }
                this.f15553d.a();
            }
        }
    }

    public void b() {
        if (this.f15555f == 0) {
            this.f15554e = o.a(TimeUnit.SECONDS.toMillis(3), this.f15550a, new Runnable() {
                public void run() {
                    int unused = n.this.f15555f = 0;
                }
            });
        }
        int i2 = this.f15555f;
        if (i2 % 2 == 0) {
            this.f15555f = i2 + 1;
        }
    }

    public void c() {
        int i2 = this.f15555f;
        if (i2 % 2 == 1) {
            this.f15555f = i2 + 1;
        }
        if (this.f15555f / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    n.this.d();
                }
            });
            this.f15555f = 0;
            this.f15554e.d();
            this.f15553d.b();
        }
    }
}
