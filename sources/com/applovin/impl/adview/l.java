package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.i;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdkUtils;
import okhttp3.internal.http2.Http2Connection;

class l extends Dialog implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f14081a;

    /* renamed from: b  reason: collision with root package name */
    private final m f14082b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final v f14083c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final d f14084d;

    /* renamed from: e  reason: collision with root package name */
    private final a f14085e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f14086f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public i f14087g;

    l(a aVar, d dVar, Activity activity, m mVar) {
        super(activity, 16973840);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (dVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.f14082b = mVar;
            this.f14083c = mVar.A();
            this.f14081a = activity;
            this.f14084d = dVar;
            this.f14085e = aVar;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    private int a(int i2) {
        return AppLovinSdkUtils.dpToPx(this.f14081a, i2);
    }

    private void a(i.a aVar) {
        if (this.f14087g == null) {
            i a2 = i.a(aVar, this.f14081a);
            this.f14087g = a2;
            a2.setVisibility(8);
            this.f14087g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.d();
                }
            });
            this.f14087g.setClickable(false);
            int a3 = a(((Integer) this.f14082b.a(b.bU)).intValue());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
            layoutParams.addRule(10);
            m mVar = this.f14082b;
            b bVar = b.bX;
            int i2 = 9;
            layoutParams.addRule(((Boolean) mVar.a(bVar)).booleanValue() ? 9 : 11);
            this.f14087g.a(a3);
            int a4 = a(((Integer) this.f14082b.a(b.bW)).intValue());
            int a5 = a(((Integer) this.f14082b.a(b.bV)).intValue());
            layoutParams.setMargins(a5, a4, a5, 0);
            this.f14086f.addView(this.f14087g, layoutParams);
            this.f14087g.bringToFront();
            int a6 = a(((Integer) this.f14082b.a(b.bY)).intValue());
            View view = new View(this.f14081a);
            view.setBackgroundColor(0);
            int i3 = a3 + a6;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i3);
            layoutParams2.addRule(10);
            if (!((Boolean) this.f14082b.a(bVar)).booleanValue()) {
                i2 = 11;
            }
            layoutParams2.addRule(i2);
            layoutParams2.setMargins(a5 - a(5), a4 - a(5), a5 - a(5), 0);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (l.this.f14087g.isClickable()) {
                        l.this.f14087g.performClick();
                    }
                }
            });
            this.f14086f.addView(view, layoutParams2);
            view.bringToFront();
        } else if (v.a()) {
            this.f14083c.d("ExpandedAdDialog", "Attempting to create duplicate close button");
        }
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f14084d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f14081a);
        this.f14086f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f14086f.setBackgroundColor(-1157627904);
        this.f14086f.addView(this.f14084d);
        if (!this.f14085e.m()) {
            a(this.f14085e.n());
            e();
        }
        setContentView(this.f14086f);
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f14084d.a("javascript:al_onCloseTapped();", (Runnable) new Runnable() {
            public void run() {
                l.this.dismiss();
            }
        });
    }

    private void e() {
        this.f14081a.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (l.this.f14087g == null) {
                        l.this.d();
                    }
                    l.this.f14087g.setVisibility(0);
                    l.this.f14087g.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(300);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            l.this.f14087g.setClickable(true);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    l.this.f14087g.startAnimation(alphaAnimation);
                } catch (Throwable th) {
                    if (v.a()) {
                        l.this.f14083c.b("ExpandedAdDialog", "Unable to fade in close button", th);
                    }
                    l.this.d();
                }
            }
        });
    }

    public a a() {
        return this.f14085e;
    }

    public d b() {
        return this.f14084d;
    }

    public void dismiss() {
        d statsManagerHelper = this.f14084d.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.e();
        }
        this.f14081a.runOnUiThread(new Runnable() {
            public void run() {
                l.this.f14086f.removeView(l.this.f14084d);
                l.super.dismiss();
            }
        });
    }

    public void onBackPressed() {
        this.f14084d.a("javascript:al_onBackPressed();", (Runnable) new Runnable() {
            public void run() {
                l.this.dismiss();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f14081a.getWindow().getAttributes().flags, this.f14081a.getWindow().getAttributes().flags);
                window.addFlags(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            } else if (v.a()) {
                this.f14083c.e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th) {
            if (v.a()) {
                this.f14083c.b("ExpandedAdDialog", "Setting window flags failed.", th);
            }
        }
    }
}
