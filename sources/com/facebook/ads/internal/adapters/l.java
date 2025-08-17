package com.facebook.ads.internal.adapters;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.a.c;
import com.facebook.ads.internal.adapters.k;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.t;
import com.facebook.ads.internal.view.f.c.a;
import com.facebook.ads.internal.view.f.c.d;
import com.facebook.ads.internal.view.f.c.g;
import com.facebook.ads.internal.view.f.c.j;
import com.facebook.ads.internal.view.f.c.n;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.internal.ImagesContract;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.core.device.MimeTypes;
import java.util.HashMap;
import org.json.JSONObject;

public class l extends j implements View.OnTouchListener, a {

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ boolean f19878i = true;

    /* renamed from: j  reason: collision with root package name */
    private static final String f19879j = "l";
    private int A = -12286980;
    private boolean B = false;
    private com.facebook.ads.internal.view.f.a.a C;

    /* renamed from: f  reason: collision with root package name */
    final int f19880f = 64;

    /* renamed from: g  reason: collision with root package name */
    final int f19881g = 64;

    /* renamed from: h  reason: collision with root package name */
    final int f19882h = 16;

    /* renamed from: k  reason: collision with root package name */
    private a.C0037a f19883k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Activity f19884l;

    /* renamed from: m  reason: collision with root package name */
    private AudienceNetworkActivity.BackButtonInterceptor f19885m = new AudienceNetworkActivity.BackButtonInterceptor() {
        public boolean interceptBackButton() {
            com.facebook.ads.internal.view.f.a aVar;
            if (l.this.f19896x == null) {
                return false;
            }
            if (!l.this.f19896x.a()) {
                return true;
            }
            if (!(l.this.f19896x.getSkipSeconds() == 0 || (aVar = l.this.f19834b) == null)) {
                aVar.e();
            }
            com.facebook.ads.internal.view.f.a aVar2 = l.this.f19834b;
            if (aVar2 != null) {
                aVar2.f();
            }
            return false;
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private final View.OnTouchListener f19886n = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.facebook.ads.internal.view.f.a aVar;
            if (motionEvent.getAction() != 1) {
                return true;
            }
            if (l.this.f19896x != null) {
                if (!l.this.f19896x.a()) {
                    return true;
                }
                if (!(l.this.f19896x.getSkipSeconds() == 0 || (aVar = l.this.f19834b) == null)) {
                    aVar.e();
                }
                com.facebook.ads.internal.view.f.a aVar2 = l.this.f19834b;
                if (aVar2 != null) {
                    aVar2.f();
                }
            }
            l.this.f19884l.finish();
            return true;
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private k.a f19887o = k.a.UNSPECIFIED;

    /* renamed from: p  reason: collision with root package name */
    private com.facebook.ads.internal.view.c.a f19888p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f19889q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f19890r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f19891s;

    /* renamed from: t  reason: collision with root package name */
    private a.C0041a f19892t;

    /* renamed from: u  reason: collision with root package name */
    private n f19893u;

    /* renamed from: v  reason: collision with root package name */
    private ViewGroup f19894v;

    /* renamed from: w  reason: collision with root package name */
    private d f19895w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public j f19896x;

    /* renamed from: y  reason: collision with root package name */
    private int f19897y = -1;

    /* renamed from: z  reason: collision with root package name */
    private int f19898z = -10525069;

    /* JADX WARNING: Removed duplicated region for block: B:118:0x05a3  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            float r2 = com.facebook.ads.internal.q.a.x.f20694b
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r4 = 1113587712(0x42600000, float:56.0)
            float r4 = r4 * r2
            int r4 = (int) r4
            r3.<init>(r4, r4)
            r5 = 10
            r3.addRule(r5)
            r6 = 11
            r3.addRule(r6)
            r7 = 1098907648(0x41800000, float:16.0)
            float r7 = r7 * r2
            int r7 = (int) r7
            com.facebook.ads.internal.view.f.c.j r8 = r0.f19896x
            r8.setPadding(r7, r7, r7, r7)
            com.facebook.ads.internal.view.f.c.j r8 = r0.f19896x
            r8.setLayoutParams(r3)
            boolean r3 = r19.h()
            if (r3 == 0) goto L_0x0032
            com.facebook.ads.internal.view.f.c.d$a r3 = com.facebook.ads.internal.view.f.c.d.a.FADE_OUT_ON_PLAY
            goto L_0x0034
        L_0x0032:
            com.facebook.ads.internal.view.f.c.d$a r3 = com.facebook.ads.internal.view.f.c.d.a.VISIBLE
        L_0x0034:
            com.facebook.ads.internal.view.f.a r8 = r0.f19834b
            int r8 = r8.getId()
            r11 = 0
            r12 = 2
            r15 = 16
            r6 = 1
            r9 = -2
            r14 = 12
            r13 = -1
            r10 = 0
            if (r1 != r6) goto L_0x01bd
            boolean r16 = r19.m()
            if (r16 != 0) goto L_0x0052
            boolean r16 = r19.n()
            if (r16 == 0) goto L_0x01bd
        L_0x0052:
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r4 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            int[] r8 = new int[r12]
            r8 = {0, -15658735} // fill-array
            r1.<init>(r4, r8)
            r1.setCornerRadius(r11)
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r4.<init>(r13, r9)
            r4.addRule(r5)
            com.facebook.ads.internal.view.f.a r5 = r0.f19834b
            r5.setLayoutParams(r4)
            com.facebook.ads.internal.view.f.a r4 = r0.f19834b
            r0.a((android.view.View) r4)
            com.facebook.ads.internal.view.f.c.j r4 = r0.f19896x
            r0.a((android.view.View) r4)
            com.facebook.ads.internal.view.f.c.a$a r4 = r0.f19892t
            if (r4 == 0) goto L_0x007f
            r0.a((android.view.View) r4)
        L_0x007f:
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            com.facebook.ads.internal.view.c.a r5 = r0.f19888p
            r8 = 64
            if (r5 == 0) goto L_0x008a
            r5 = 64
            goto L_0x008b
        L_0x008a:
            r5 = 0
        L_0x008b:
            int r5 = r5 + 60
            int r5 = r5 + r15
            int r5 = r5 + r15
            int r5 = r5 + r15
            float r5 = (float) r5
            float r5 = r5 * r2
            int r5 = (int) r5
            r4.<init>(r13, r5)
            r4.addRule(r14)
            android.widget.RelativeLayout r5 = new android.widget.RelativeLayout
            android.content.Context r11 = r0.f19836d
            r5.<init>(r11)
            com.facebook.ads.internal.q.a.x.a((android.view.View) r5, (android.graphics.drawable.Drawable) r1)
            r5.setLayoutParams(r4)
            com.facebook.ads.internal.view.c.a r1 = r0.f19888p
            if (r1 == 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r8 = 0
        L_0x00ad:
            int r8 = r8 + r15
            int r8 = r8 + r15
            float r1 = (float) r8
            float r1 = r1 * r2
            int r1 = (int) r1
            r5.setPadding(r7, r10, r7, r1)
            r0.f19894v = r5
            boolean r1 = r0.B
            if (r1 != 0) goto L_0x00c1
            com.facebook.ads.internal.view.f.c.d r1 = r0.f19895w
            r1.a((android.view.View) r5, (com.facebook.ads.internal.view.f.c.d.a) r3)
        L_0x00c1:
            r0.a((android.view.View) r5)
            com.facebook.ads.internal.view.f.c.n r1 = r0.f19893u
            if (r1 == 0) goto L_0x00e6
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1086324736(0x40c00000, float:6.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.<init>(r13, r3)
            r1.addRule(r14)
            r3 = -1061158912(0xffffffffc0c00000, float:-6.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.topMargin = r3
            com.facebook.ads.internal.view.f.c.n r3 = r0.f19893u
            r3.setLayoutParams(r1)
            com.facebook.ads.internal.view.f.c.n r1 = r0.f19893u
            r0.a((android.view.View) r1)
        L_0x00e6:
            com.facebook.ads.internal.view.c.a r1 = r0.f19888p
            if (r1 == 0) goto L_0x010a
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1115684864(0x42800000, float:64.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.<init>(r13, r3)
            r1.bottomMargin = r7
            r1.leftMargin = r7
            r1.rightMargin = r7
            r1.addRule(r6)
            r1.addRule(r14)
            com.facebook.ads.internal.view.c.a r3 = r0.f19888p
            r3.setLayoutParams(r1)
            com.facebook.ads.internal.view.c.a r1 = r0.f19888p
            r0.a((android.view.View) r1)
        L_0x010a:
            android.widget.ImageView r1 = r0.f19891s
            if (r1 == 0) goto L_0x012a
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1114636288(0x42700000, float:60.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.<init>(r3, r3)
            r1.addRule(r14)
            r3 = 9
            r1.addRule(r3)
            android.widget.ImageView r3 = r0.f19891s
            r3.setLayoutParams(r1)
            android.widget.ImageView r1 = r0.f19891s
            r0.a(r5, r1)
        L_0x012a:
            android.widget.TextView r1 = r0.f19889q
            if (r1 == 0) goto L_0x0176
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r13, r9)
            r3 = 1108344832(0x42100000, float:36.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.bottomMargin = r3
            r1.addRule(r14)
            r3 = 9
            r1.addRule(r3)
            android.widget.TextView r3 = r0.f19889q
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.END
            r3.setEllipsize(r4)
            android.widget.TextView r3 = r0.f19889q
            r4 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r4)
            android.widget.TextView r3 = r0.f19889q
            r3.setLayoutParams(r1)
            android.widget.TextView r1 = r0.f19889q
            r1.setMaxLines(r6)
            android.widget.TextView r1 = r0.f19889q
            r3 = 1116733440(0x42900000, float:72.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.setPadding(r3, r10, r10, r10)
            android.widget.TextView r1 = r0.f19889q
            r1.setTextColor(r13)
            android.widget.TextView r1 = r0.f19889q
            r3 = 1099956224(0x41900000, float:18.0)
            r1.setTextSize(r3)
            android.widget.TextView r1 = r0.f19889q
            r0.a(r5, r1)
        L_0x0176:
            android.widget.TextView r1 = r0.f19890r
            if (r1 == 0) goto L_0x058e
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r13, r9)
            r1.addRule(r14)
            r3 = 9
            r1.addRule(r3)
            r3 = 1082130432(0x40800000, float:4.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.bottomMargin = r3
            android.widget.TextView r3 = r0.f19890r
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.END
            r3.setEllipsize(r4)
            android.widget.TextView r3 = r0.f19890r
            r4 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r4)
            android.widget.TextView r3 = r0.f19890r
            r3.setLayoutParams(r1)
            android.widget.TextView r1 = r0.f19890r
            r1.setMaxLines(r6)
            android.widget.TextView r1 = r0.f19890r
            r3 = 1116733440(0x42900000, float:72.0)
            float r2 = r2 * r3
            int r2 = (int) r2
            r1.setPadding(r2, r10, r10, r10)
            android.widget.TextView r1 = r0.f19890r
            r1.setTextColor(r13)
            android.widget.TextView r1 = r0.f19890r
            r0.a(r5, r1)
            goto L_0x058e
        L_0x01bd:
            r15 = 112(0x70, float:1.57E-43)
            r11 = 3
            r17 = 1090519040(0x41000000, float:8.0)
            r10 = 1073741824(0x40000000, float:2.0)
            r18 = 1117782016(0x42a00000, float:80.0)
            r12 = 17
            if (r1 != r6) goto L_0x02ef
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r13, r9)
            r1.addRule(r5)
            com.facebook.ads.internal.view.f.a r3 = r0.f19834b
            r3.setLayoutParams(r1)
            com.facebook.ads.internal.view.f.a r1 = r0.f19834b
            r0.a((android.view.View) r1)
            com.facebook.ads.internal.view.f.c.j r1 = r0.f19896x
            r0.a((android.view.View) r1)
            com.facebook.ads.internal.view.f.c.a$a r1 = r0.f19892t
            if (r1 == 0) goto L_0x01e8
            r0.a((android.view.View) r1)
        L_0x01e8:
            android.widget.LinearLayout r1 = new android.widget.LinearLayout
            android.content.Context r3 = r0.f19836d
            r1.<init>(r3)
            r0.f19894v = r1
            r1.setGravity(r15)
            r1.setOrientation(r6)
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r3.<init>(r13, r13)
            r4 = 1107558400(0x42040000, float:33.0)
            float r4 = r4 * r2
            int r4 = (int) r4
            r3.leftMargin = r4
            r3.rightMargin = r4
            float r5 = r2 * r17
            int r5 = (int) r5
            r3.topMargin = r5
            com.facebook.ads.internal.view.c.a r5 = r0.f19888p
            if (r5 != 0) goto L_0x0211
            r3.bottomMargin = r7
            goto L_0x0216
        L_0x0211:
            float r5 = r2 * r18
            int r5 = (int) r5
            r3.bottomMargin = r5
        L_0x0216:
            r3.addRule(r11, r8)
            r1.setLayoutParams(r3)
            r0.a((android.view.View) r1)
            com.facebook.ads.internal.view.c.a r3 = r0.f19888p
            if (r3 == 0) goto L_0x0243
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r5 = 1115684864(0x42800000, float:64.0)
            float r15 = r2 * r5
            int r5 = (int) r15
            r3.<init>(r13, r5)
            r3.bottomMargin = r7
            r3.leftMargin = r4
            r3.rightMargin = r4
            r3.addRule(r6)
            r3.addRule(r14)
            com.facebook.ads.internal.view.c.a r4 = r0.f19888p
            r4.setLayoutParams(r3)
            com.facebook.ads.internal.view.c.a r3 = r0.f19888p
            r0.a((android.view.View) r3)
        L_0x0243:
            android.widget.TextView r3 = r0.f19889q
            if (r3 == 0) goto L_0x0280
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r3.<init>(r9, r9)
            r3.weight = r10
            r3.gravity = r12
            android.widget.TextView r4 = r0.f19889q
            android.text.TextUtils$TruncateAt r5 = android.text.TextUtils.TruncateAt.END
            r4.setEllipsize(r5)
            android.widget.TextView r4 = r0.f19889q
            r4.setGravity(r12)
            android.widget.TextView r4 = r0.f19889q
            r4.setLayoutParams(r3)
            android.widget.TextView r3 = r0.f19889q
            r4 = 2
            r3.setMaxLines(r4)
            android.widget.TextView r3 = r0.f19889q
            r4 = 0
            r3.setPadding(r4, r4, r4, r4)
            android.widget.TextView r3 = r0.f19889q
            int r4 = r0.f19898z
            r3.setTextColor(r4)
            android.widget.TextView r3 = r0.f19889q
            r4 = 1103101952(0x41c00000, float:24.0)
            r3.setTextSize(r4)
            android.widget.TextView r3 = r0.f19889q
            r0.a(r1, r3)
        L_0x0280:
            android.widget.ImageView r3 = r0.f19891s
            if (r3 == 0) goto L_0x029d
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r4 = 1115684864(0x42800000, float:64.0)
            float r4 = r4 * r2
            int r4 = (int) r4
            r3.<init>(r4, r4)
            r4 = 0
            r3.weight = r4
            r3.gravity = r12
            android.widget.ImageView r4 = r0.f19891s
            r4.setLayoutParams(r3)
            android.widget.ImageView r3 = r0.f19891s
            r0.a(r1, r3)
        L_0x029d:
            android.widget.TextView r3 = r0.f19890r
            if (r3 == 0) goto L_0x02d5
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r3.<init>(r13, r9)
            r3.weight = r10
            r4 = 16
            r3.gravity = r4
            android.widget.TextView r5 = r0.f19890r
            android.text.TextUtils$TruncateAt r6 = android.text.TextUtils.TruncateAt.END
            r5.setEllipsize(r6)
            android.widget.TextView r5 = r0.f19890r
            r5.setGravity(r4)
            android.widget.TextView r4 = r0.f19890r
            r4.setLayoutParams(r3)
            android.widget.TextView r3 = r0.f19890r
            r4 = 2
            r3.setMaxLines(r4)
            android.widget.TextView r3 = r0.f19890r
            r4 = 0
            r3.setPadding(r4, r4, r4, r4)
            android.widget.TextView r3 = r0.f19890r
            int r4 = r0.f19898z
            r3.setTextColor(r4)
            android.widget.TextView r3 = r0.f19890r
            r0.a(r1, r3)
        L_0x02d5:
            com.facebook.ads.internal.view.f.c.n r1 = r0.f19893u
            if (r1 == 0) goto L_0x0427
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1086324736(0x40c00000, float:6.0)
            float r2 = r2 * r3
            int r2 = (int) r2
            r1.<init>(r13, r2)
            r1.addRule(r11, r8)
            com.facebook.ads.internal.view.f.c.n r2 = r0.f19893u
            r2.setLayoutParams(r1)
            com.facebook.ads.internal.view.f.c.n r1 = r0.f19893u
            goto L_0x0424
        L_0x02ef:
            boolean r1 = r19.o()
            if (r1 == 0) goto L_0x0433
            boolean r1 = r19.n()
            if (r1 != 0) goto L_0x0433
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r9, r13)
            r3 = 9
            r1.addRule(r3)
            com.facebook.ads.internal.view.f.a r3 = r0.f19834b
            r3.setLayoutParams(r1)
            com.facebook.ads.internal.view.f.a r1 = r0.f19834b
            r0.a((android.view.View) r1)
            com.facebook.ads.internal.view.f.c.j r1 = r0.f19896x
            r0.a((android.view.View) r1)
            com.facebook.ads.internal.view.f.c.a$a r1 = r0.f19892t
            if (r1 == 0) goto L_0x031b
            r0.a((android.view.View) r1)
        L_0x031b:
            android.widget.LinearLayout r1 = new android.widget.LinearLayout
            android.content.Context r3 = r0.f19836d
            r1.<init>(r3)
            r0.f19894v = r1
            r1.setGravity(r15)
            r1.setOrientation(r6)
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r3.<init>(r13, r13)
            r3.leftMargin = r7
            r3.rightMargin = r7
            float r4 = r2 * r17
            int r4 = (int) r4
            r3.topMargin = r4
            float r4 = r2 * r18
            int r4 = (int) r4
            r3.bottomMargin = r4
            r3.addRule(r6, r8)
            r1.setLayoutParams(r3)
            r0.a((android.view.View) r1)
            com.facebook.ads.internal.view.f.c.n r3 = r0.f19893u
            if (r3 == 0) goto L_0x0370
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r4 = 1086324736(0x40c00000, float:6.0)
            float r4 = r4 * r2
            int r4 = (int) r4
            r3.<init>(r13, r4)
            r4 = 5
            r3.addRule(r4, r8)
            r4 = 7
            r3.addRule(r4, r8)
            r3.addRule(r11, r8)
            r4 = -1061158912(0xffffffffc0c00000, float:-6.0)
            float r4 = r4 * r2
            int r4 = (int) r4
            r3.topMargin = r4
            com.facebook.ads.internal.view.f.c.n r4 = r0.f19893u
            r4.setLayoutParams(r3)
            com.facebook.ads.internal.view.f.c.n r3 = r0.f19893u
            r0.a((android.view.View) r3)
        L_0x0370:
            android.widget.TextView r3 = r0.f19889q
            if (r3 == 0) goto L_0x03ac
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r3.<init>(r9, r9)
            r3.weight = r10
            r3.gravity = r12
            android.widget.TextView r4 = r0.f19889q
            android.text.TextUtils$TruncateAt r11 = android.text.TextUtils.TruncateAt.END
            r4.setEllipsize(r11)
            android.widget.TextView r4 = r0.f19889q
            r4.setGravity(r12)
            android.widget.TextView r4 = r0.f19889q
            r4.setLayoutParams(r3)
            android.widget.TextView r3 = r0.f19889q
            r3.setMaxLines(r5)
            android.widget.TextView r3 = r0.f19889q
            r4 = 0
            r3.setPadding(r4, r4, r4, r4)
            android.widget.TextView r3 = r0.f19889q
            int r4 = r0.f19898z
            r3.setTextColor(r4)
            android.widget.TextView r3 = r0.f19889q
            r4 = 1103101952(0x41c00000, float:24.0)
            r3.setTextSize(r4)
            android.widget.TextView r3 = r0.f19889q
            r0.a(r1, r3)
        L_0x03ac:
            android.widget.ImageView r3 = r0.f19891s
            if (r3 == 0) goto L_0x03c9
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r4 = 1115684864(0x42800000, float:64.0)
            float r11 = r2 * r4
            int r4 = (int) r11
            r3.<init>(r4, r4)
            r4 = 0
            r3.weight = r4
            r3.gravity = r12
            android.widget.ImageView r4 = r0.f19891s
            r4.setLayoutParams(r3)
            android.widget.ImageView r3 = r0.f19891s
            r0.a(r1, r3)
        L_0x03c9:
            android.widget.TextView r3 = r0.f19890r
            if (r3 == 0) goto L_0x0400
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r3.<init>(r13, r9)
            r3.weight = r10
            r4 = 16
            r3.gravity = r4
            android.widget.TextView r4 = r0.f19890r
            android.text.TextUtils$TruncateAt r9 = android.text.TextUtils.TruncateAt.END
            r4.setEllipsize(r9)
            android.widget.TextView r4 = r0.f19890r
            r4.setGravity(r12)
            android.widget.TextView r4 = r0.f19890r
            r4.setLayoutParams(r3)
            android.widget.TextView r3 = r0.f19890r
            r3.setMaxLines(r5)
            android.widget.TextView r3 = r0.f19890r
            r4 = 0
            r3.setPadding(r4, r4, r4, r4)
            android.widget.TextView r3 = r0.f19890r
            int r4 = r0.f19898z
            r3.setTextColor(r4)
            android.widget.TextView r3 = r0.f19890r
            r0.a(r1, r3)
        L_0x0400:
            com.facebook.ads.internal.view.c.a r1 = r0.f19888p
            if (r1 == 0) goto L_0x0427
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1115684864(0x42800000, float:64.0)
            float r2 = r2 * r3
            int r2 = (int) r2
            r1.<init>(r13, r2)
            r1.bottomMargin = r7
            r1.leftMargin = r7
            r1.rightMargin = r7
            r1.addRule(r6)
            r1.addRule(r14)
            r1.addRule(r6, r8)
            com.facebook.ads.internal.view.c.a r2 = r0.f19888p
            r2.setLayoutParams(r1)
            com.facebook.ads.internal.view.c.a r1 = r0.f19888p
        L_0x0424:
            r0.a((android.view.View) r1)
        L_0x0427:
            com.facebook.ads.internal.view.f.a r1 = r0.f19834b
            android.view.ViewParent r1 = r1.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.f19897y
            goto L_0x0598
        L_0x0433:
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r5 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r8 = 2
            int[] r10 = new int[r8]
            r10 = {0, -15658735} // fill-array
            r1.<init>(r5, r10)
            r5 = 0
            r1.setCornerRadius(r5)
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r5.<init>(r13, r13)
            com.facebook.ads.internal.view.f.a r8 = r0.f19834b
            r8.setLayoutParams(r5)
            com.facebook.ads.internal.view.f.a r5 = r0.f19834b
            r0.a((android.view.View) r5)
            com.facebook.ads.internal.view.f.c.j r5 = r0.f19896x
            r0.a((android.view.View) r5)
            com.facebook.ads.internal.view.f.c.a$a r5 = r0.f19892t
            if (r5 == 0) goto L_0x045f
            r0.a((android.view.View) r5)
        L_0x045f:
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r8 = 1123549184(0x42f80000, float:124.0)
            float r8 = r8 * r2
            int r8 = (int) r8
            r5.<init>(r13, r8)
            r5.addRule(r14)
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout
            android.content.Context r10 = r0.f19836d
            r8.<init>(r10)
            com.facebook.ads.internal.q.a.x.a((android.view.View) r8, (android.graphics.drawable.Drawable) r1)
            r8.setLayoutParams(r5)
            r1 = 0
            r8.setPadding(r7, r1, r7, r7)
            r0.f19894v = r8
            boolean r1 = r0.B
            if (r1 != 0) goto L_0x0488
            com.facebook.ads.internal.view.f.c.d r1 = r0.f19895w
            r1.a((android.view.View) r8, (com.facebook.ads.internal.view.f.c.d.a) r3)
        L_0x0488:
            r0.a((android.view.View) r8)
            com.facebook.ads.internal.view.c.a r1 = r0.f19888p
            if (r1 == 0) goto L_0x04af
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1121714176(0x42dc0000, float:110.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.<init>(r3, r4)
            r1.rightMargin = r7
            r1.bottomMargin = r7
            r1.addRule(r14)
            r3 = 11
            r1.addRule(r3)
            com.facebook.ads.internal.view.c.a r3 = r0.f19888p
            r3.setLayoutParams(r1)
            com.facebook.ads.internal.view.c.a r1 = r0.f19888p
            r0.a((android.view.View) r1)
        L_0x04af:
            android.widget.ImageView r1 = r0.f19891s
            if (r1 == 0) goto L_0x04d4
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1115684864(0x42800000, float:64.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.<init>(r3, r3)
            r1.addRule(r14)
            r3 = 9
            r1.addRule(r3)
            float r3 = r2 * r17
            int r3 = (int) r3
            r1.bottomMargin = r3
            android.widget.ImageView r3 = r0.f19891s
            r3.setLayoutParams(r1)
            android.widget.ImageView r1 = r0.f19891s
            r0.a(r8, r1)
        L_0x04d4:
            android.widget.TextView r1 = r0.f19889q
            if (r1 == 0) goto L_0x052a
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r13, r9)
            r3 = 1111490560(0x42400000, float:48.0)
            float r3 = r3 * r2
            int r3 = (int) r3
            r1.bottomMargin = r3
            r1.addRule(r14)
            r3 = 9
            r1.addRule(r3)
            android.widget.TextView r3 = r0.f19889q
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.END
            r3.setEllipsize(r4)
            android.widget.TextView r3 = r0.f19889q
            r4 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r4)
            android.widget.TextView r3 = r0.f19889q
            r3.setLayoutParams(r1)
            android.widget.TextView r1 = r0.f19889q
            r1.setMaxLines(r6)
            android.widget.TextView r1 = r0.f19889q
            float r3 = r2 * r18
            int r3 = (int) r3
            com.facebook.ads.internal.view.c.a r4 = r0.f19888p
            if (r4 == 0) goto L_0x0514
            r4 = 1123811328(0x42fc0000, float:126.0)
            float r4 = r4 * r2
            int r4 = (int) r4
            goto L_0x0515
        L_0x0514:
            r4 = 0
        L_0x0515:
            r5 = 0
            r1.setPadding(r3, r5, r4, r5)
            android.widget.TextView r1 = r0.f19889q
            r1.setTextColor(r13)
            android.widget.TextView r1 = r0.f19889q
            r3 = 1103101952(0x41c00000, float:24.0)
            r1.setTextSize(r3)
            android.widget.TextView r1 = r0.f19889q
            r0.a(r8, r1)
        L_0x052a:
            android.widget.TextView r1 = r0.f19890r
            if (r1 == 0) goto L_0x0573
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r13, r9)
            r1.addRule(r14)
            r3 = 9
            r1.addRule(r3)
            android.widget.TextView r3 = r0.f19890r
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.END
            r3.setEllipsize(r4)
            android.widget.TextView r3 = r0.f19890r
            r4 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r4)
            android.widget.TextView r3 = r0.f19890r
            r3.setLayoutParams(r1)
            android.widget.TextView r1 = r0.f19890r
            r3 = 2
            r1.setMaxLines(r3)
            android.widget.TextView r1 = r0.f19890r
            r1.setTextColor(r13)
            android.widget.TextView r1 = r0.f19890r
            float r3 = r2 * r18
            int r3 = (int) r3
            com.facebook.ads.internal.view.c.a r4 = r0.f19888p
            if (r4 == 0) goto L_0x0569
            r4 = 1123811328(0x42fc0000, float:126.0)
            float r4 = r4 * r2
            int r4 = (int) r4
            goto L_0x056a
        L_0x0569:
            r4 = 0
        L_0x056a:
            r5 = 0
            r1.setPadding(r3, r5, r4, r5)
            android.widget.TextView r1 = r0.f19890r
            r0.a(r8, r1)
        L_0x0573:
            com.facebook.ads.internal.view.f.c.n r1 = r0.f19893u
            if (r1 == 0) goto L_0x058e
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = 1086324736(0x40c00000, float:6.0)
            float r2 = r2 * r3
            int r2 = (int) r2
            r1.<init>(r13, r2)
            r1.addRule(r14)
            com.facebook.ads.internal.view.f.c.n r2 = r0.f19893u
            r2.setLayoutParams(r1)
            com.facebook.ads.internal.view.f.c.n r1 = r0.f19893u
            r0.a((android.view.View) r1)
        L_0x058e:
            com.facebook.ads.internal.view.f.a r1 = r0.f19834b
            android.view.ViewParent r1 = r1.getParent()
            android.view.View r1 = (android.view.View) r1
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x0598:
            com.facebook.ads.internal.q.a.x.a((android.view.View) r1, (int) r2)
            com.facebook.ads.internal.view.f.a r1 = r0.f19834b
            android.view.View r1 = r1.getRootView()
            if (r1 == 0) goto L_0x05a6
            r1.setOnTouchListener(r0)
        L_0x05a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.l.a(int):void");
    }

    private void a(View view) {
        a.C0037a aVar = this.f19883k;
        if (aVar != null) {
            aVar.a(view);
        }
    }

    private void a(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    private void b(View view) {
        ViewGroup viewGroup;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(view);
        }
    }

    private boolean m() {
        return ((double) (this.f19834b.getVideoHeight() > 0 ? ((float) this.f19834b.getVideoWidth()) / ((float) this.f19834b.getVideoHeight()) : -1.0f)) <= 0.9d;
    }

    private boolean n() {
        if (this.f19834b.getVideoHeight() <= 0) {
            return false;
        }
        Rect rect = new Rect();
        this.f19884l.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.width() > rect.height()) {
            return ((float) (rect.width() - ((rect.height() * this.f19834b.getVideoWidth()) / this.f19834b.getVideoHeight()))) - (x.f20694b * 192.0f) < 0.0f;
        }
        int height = rect.height();
        float f2 = x.f20694b;
        return ((((float) (height - ((rect.width() * this.f19834b.getVideoHeight()) / this.f19834b.getVideoWidth()))) - (f2 * 64.0f)) - (64.0f * f2)) - (f2 * 40.0f) < 0.0f;
    }

    private boolean o() {
        double videoWidth = (double) (this.f19834b.getVideoHeight() > 0 ? ((float) this.f19834b.getVideoWidth()) / ((float) this.f19834b.getVideoHeight()) : -1.0f);
        return videoWidth > 0.9d && videoWidth < 1.1d;
    }

    private void p() {
        b((View) this.f19834b);
        b((View) this.f19888p);
        b((View) this.f19889q);
        b((View) this.f19890r);
        b((View) this.f19891s);
        b((View) this.f19893u);
        b((View) this.f19894v);
        b((View) this.f19896x);
        a.C0041a aVar = this.f19892t;
        if (aVar != null) {
            b((View) aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        JSONObject jSONObject = this.f19835c;
        if (jSONObject == null) {
            Log.e(f19879j, "Unable to add UI without a valid ad response.");
            return;
        }
        String string = jSONObject.getString("ct");
        String optString = this.f19835c.getJSONObject("context").optString(AdUnitActivity.EXTRA_ORIENTATION);
        if (!optString.isEmpty()) {
            this.f19887o = k.a.a(Integer.parseInt(optString));
        }
        if (this.f19835c.has("layout") && !this.f19835c.isNull("layout")) {
            JSONObject jSONObject2 = this.f19835c.getJSONObject("layout");
            this.f19897y = (int) jSONObject2.optLong("bgColor", (long) this.f19897y);
            this.f19898z = (int) jSONObject2.optLong("textColor", (long) this.f19898z);
            this.A = (int) jSONObject2.optLong("accentColor", (long) this.A);
            this.B = jSONObject2.optBoolean("persistentAdDetails", this.B);
        }
        JSONObject jSONObject3 = this.f19835c.getJSONObject("text");
        this.f19834b.setId(View.generateViewId());
        int c2 = c();
        Context context = this.f19836d;
        if (c2 < 0) {
            c2 = 0;
        }
        j jVar = new j(context, c2, this.A);
        this.f19896x = jVar;
        jVar.setOnTouchListener(this.f19886n);
        this.f19834b.a((b) this.f19896x);
        if (this.f19835c.has("cta") && !this.f19835c.isNull("cta")) {
            JSONObject jSONObject4 = this.f19835c.getJSONObject("cta");
            this.f19888p = new com.facebook.ads.internal.view.c.a(this.f19836d, jSONObject4.getString(ImagesContract.URL), jSONObject4.getString("text"), this.A, this.f19834b, this.f19833a, string);
            c.a(this.f19836d, this.f19833a, string, Uri.parse(jSONObject4.getString(ImagesContract.URL)), new HashMap());
        }
        if (this.f19835c.has("icon") && !this.f19835c.isNull("icon")) {
            JSONObject jSONObject5 = this.f19835c.getJSONObject("icon");
            this.f19891s = new ImageView(this.f19836d);
            com.facebook.ads.internal.view.b.d dVar = new com.facebook.ads.internal.view.b.d(this.f19891s);
            float f2 = x.f20694b;
            dVar.a((int) (f2 * 64.0f), (int) (f2 * 64.0f)).a(jSONObject5.getString(ImagesContract.URL));
        }
        if (this.f19835c.has("image") && !this.f19835c.isNull("image")) {
            JSONObject jSONObject6 = this.f19835c.getJSONObject("image");
            g gVar = new g(this.f19836d);
            this.f19834b.a((b) gVar);
            gVar.setImage(jSONObject6.getString(ImagesContract.URL));
        }
        String optString2 = jSONObject3.optString("title");
        if (!optString2.isEmpty()) {
            TextView textView = new TextView(this.f19836d);
            this.f19889q = textView;
            textView.setText(optString2);
            this.f19889q.setTypeface(Typeface.defaultFromStyle(1));
        }
        String optString3 = jSONObject3.optString(MediaTrack.ROLE_SUBTITLE);
        if (!optString3.isEmpty()) {
            TextView textView2 = new TextView(this.f19836d);
            this.f19890r = textView2;
            textView2.setText(optString3);
            this.f19890r.setTextSize(16.0f);
        }
        n nVar = new n(this.f19836d);
        this.f19893u = nVar;
        this.f19834b.a((b) nVar);
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            this.f19892t = new a.C0041a(this.f19836d, "AdChoices", d2, new float[]{0.0f, 0.0f, 8.0f, 0.0f}, string);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            this.f19892t.setLayoutParams(layoutParams);
        }
        this.f19834b.a((b) new com.facebook.ads.internal.view.f.c.k(this.f19836d));
        com.facebook.ads.internal.view.f.c.l lVar = new com.facebook.ads.internal.view.f.c.l(this.f19836d);
        this.f19834b.a((b) lVar);
        d.a aVar = h() ? d.a.FADE_OUT_ON_PLAY : d.a.VISIBLE;
        this.f19834b.a((b) new d(lVar, aVar));
        d dVar2 = new d(new RelativeLayout(this.f19836d), aVar);
        this.f19895w = dVar2;
        this.f19834b.a((b) dVar2);
    }

    @TargetApi(17)
    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        this.f19884l = audienceNetworkActivity;
        if (f19878i || this.f19883k != null) {
            audienceNetworkActivity.addBackButtonInterceptor(this.f19885m);
            p();
            a(this.f19884l.getResources().getConfiguration().orientation);
            if (h()) {
                e();
            } else {
                f();
            }
        } else {
            throw new AssertionError();
        }
    }

    public void a(Configuration configuration) {
        p();
        a(configuration.orientation);
    }

    public void a(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        if (f19878i || this.f19835c != null) {
            try {
                return this.f19835c.getJSONObject(MimeTypes.BASE_TYPE_VIDEO).getBoolean(AudienceNetworkActivity.AUTOPLAY);
            } catch (Exception e2) {
                Log.w(String.valueOf(l.class), "Invalid JSON", e2);
                return true;
            }
        } else {
            throw new AssertionError();
        }
    }

    public void i() {
        com.facebook.ads.internal.view.f.a aVar = this.f19834b;
        if (aVar != null && aVar.getState() == com.facebook.ads.internal.view.f.d.d.STARTED) {
            this.C = this.f19834b.getVideoStartReason();
            this.f19834b.a(false);
        }
    }

    public void j() {
        com.facebook.ads.internal.view.f.a.a aVar;
        com.facebook.ads.internal.view.f.a aVar2 = this.f19834b;
        if (aVar2 != null && (aVar = this.C) != null) {
            aVar2.a(aVar);
        }
    }

    public k.a k() {
        return this.f19887o;
    }

    public void l() {
        Activity activity = this.f19884l;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onDestroy() {
        JSONObject jSONObject = this.f19835c;
        if (!(jSONObject == null || this.f19833a == null)) {
            String optString = jSONObject.optString("ct");
            if (!TextUtils.isEmpty(optString)) {
                this.f19833a.i(optString, new HashMap());
            }
        }
        com.facebook.ads.internal.view.f.a aVar = this.f19834b;
        if (aVar != null) {
            aVar.f();
        }
        k.a((com.facebook.ads.internal.view.a) this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.facebook.ads.internal.view.f.a aVar = this.f19834b;
        if (aVar == null) {
            return true;
        }
        aVar.getEventBus().a(new t(view, motionEvent));
        return true;
    }

    public void setListener(a.C0037a aVar) {
        this.f19883k = aVar;
    }
}
