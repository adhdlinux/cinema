package com.facebook.ads;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.h;
import com.facebook.ads.internal.q.a.j;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.c.g;

public class AdChoicesView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final NativeAdBase f19391a;

    /* renamed from: b  reason: collision with root package name */
    private final float f19392b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19393c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f19394d;

    /* renamed from: e  reason: collision with root package name */
    private String f19395e;

    public AdChoicesView(Context context, NativeAdBase nativeAdBase) {
        this(context, nativeAdBase, false);
    }

    public AdChoicesView(Context context, final NativeAdBase nativeAdBase, boolean z2) {
        super(context);
        boolean z3 = false;
        this.f19393c = false;
        this.f19391a = nativeAdBase;
        float f2 = x.f20694b;
        this.f19392b = f2;
        if (!nativeAdBase.isAdLoaded() || nativeAdBase.h().g()) {
            String adChoicesText = nativeAdBase.getAdChoicesText();
            this.f19395e = adChoicesText;
            if (TextUtils.isEmpty(adChoicesText)) {
                this.f19395e = "AdChoices";
            }
            h y2 = nativeAdBase.g().y();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    if (!AdChoicesView.this.f19393c) {
                        AdChoicesView.this.a();
                        return true;
                    } else if (TextUtils.isEmpty(AdChoicesView.this.f19391a.getAdChoicesLinkUrl())) {
                        return true;
                    } else {
                        g.a(new g(), AdChoicesView.this.getContext(), Uri.parse(AdChoicesView.this.f19391a.getAdChoicesLinkUrl()), nativeAdBase.i());
                        return true;
                    }
                }
            });
            TextView textView = new TextView(getContext());
            this.f19394d = textView;
            addView(textView);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (!z2 || y2 == null) {
                z3 = true;
            } else {
                layoutParams2.addRule(11, a(y2).getId());
                layoutParams2.width = 0;
                layoutParams.width = Math.round(((float) (y2.b() + 4)) * f2);
                layoutParams.height = Math.round(((float) (y2.c() + 2)) * f2);
            }
            this.f19393c = z3;
            setLayoutParams(layoutParams);
            layoutParams2.addRule(15, -1);
            this.f19394d.setLayoutParams(layoutParams2);
            this.f19394d.setSingleLine();
            this.f19394d.setText(this.f19395e);
            this.f19394d.setTextSize(10.0f);
            this.f19394d.setTextColor(-4341303);
            j jVar = j.INTERNAL_AD_CHOICES_ICON;
            j.a(this, jVar);
            j.a(this.f19394d, jVar);
            return;
        }
        setVisibility(8);
    }

    private ImageView a(h hVar) {
        ImageView imageView = new ImageView(getContext());
        addView(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(((float) hVar.b()) * this.f19392b), Math.round(((float) hVar.c()) * this.f19392b));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(this.f19392b * 4.0f), Math.round(this.f19392b * 2.0f), Math.round(this.f19392b * 2.0f), Math.round(this.f19392b * 2.0f));
        imageView.setLayoutParams(layoutParams);
        f.a(hVar, imageView);
        return imageView;
    }

    /* access modifiers changed from: private */
    public void a() {
        Paint paint = new Paint();
        paint.setTextSize(this.f19394d.getTextSize());
        int round = Math.round(paint.measureText(this.f19395e) + (this.f19392b * 4.0f));
        final int width = getWidth();
        final int i2 = round + width;
        this.f19393c = true;
        AnonymousClass2 r3 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f2, Transformation transformation) {
                int i2 = width;
                int i3 = (int) (((float) i2) + (((float) (i2 - i2)) * f2));
                AdChoicesView.this.getLayoutParams().width = i3;
                AdChoicesView.this.requestLayout();
                AdChoicesView.this.f19394d.getLayoutParams().width = i3 - width;
                AdChoicesView.this.f19394d.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        r3.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (AdChoicesView.this.f19393c) {
                            AdChoicesView.this.b();
                        }
                    }
                }, 3000);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        r3.setDuration(300);
        r3.setFillAfter(true);
        startAnimation(r3);
    }

    /* access modifiers changed from: private */
    public void b() {
        Paint paint = new Paint();
        paint.setTextSize(this.f19394d.getTextSize());
        int round = Math.round(paint.measureText(this.f19395e) + (this.f19392b * 4.0f));
        final int width = getWidth();
        final int i2 = width - round;
        AnonymousClass4 r2 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f2, Transformation transformation) {
                int i2 = width;
                int i3 = (int) (((float) i2) + (((float) (i2 - i2)) * f2));
                AdChoicesView.this.getLayoutParams().width = i3;
                AdChoicesView.this.requestLayout();
                AdChoicesView.this.f19394d.getLayoutParams().width = i3 - i2;
                AdChoicesView.this.f19394d.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        r2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                boolean unused = AdChoicesView.this.f19393c = false;
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        r2.setDuration(300);
        r2.setFillAfter(true);
        startAnimation(r2);
    }
}
