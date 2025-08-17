package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.b.b;
import com.facebook.ads.internal.q.c.g;
import com.facebook.ads.internal.view.f.a.c;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final C0041a f21324a;

    /* renamed from: com.facebook.ads.internal.view.f.c.a$a  reason: collision with other inner class name */
    public static class C0041a extends RelativeLayout {

        /* renamed from: a  reason: collision with root package name */
        private final String f21325a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f21326b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final String f21327c;

        /* renamed from: d  reason: collision with root package name */
        private final DisplayMetrics f21328d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f21329e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public TextView f21330f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f21331g = false;

        public C0041a(Context context, String str, String str2, float[] fArr, String str3) {
            super(context);
            this.f21325a = str;
            this.f21326b = str2;
            this.f21327c = str3;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.f21328d = displayMetrics;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setAlpha(178);
            float f2 = fArr[0];
            float f3 = displayMetrics.density;
            float f4 = fArr[1];
            float f5 = fArr[2];
            float f6 = fArr[3];
            gradientDrawable.setCornerRadii(new float[]{f2 * f3, fArr[0] * f3, f4 * f3, f4 * f3, f5 * f3, f5 * f3, f6 * f3, f6 * f3});
            x.a((View) this, (Drawable) gradientDrawable);
            a();
            b();
            c();
            setMinimumWidth(Math.round(displayMetrics.density * 20.0f));
            setMinimumHeight(Math.round(displayMetrics.density * 18.0f));
        }

        private void a() {
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    if (!C0041a.this.f21331g) {
                        C0041a.this.d();
                        return true;
                    } else if (TextUtils.isEmpty(C0041a.this.f21326b)) {
                        return true;
                    } else {
                        g.a(new g(), C0041a.this.getContext(), Uri.parse(C0041a.this.f21326b), C0041a.this.f21327c);
                        return true;
                    }
                }
            });
        }

        private void b() {
            ImageView imageView = new ImageView(getContext());
            this.f21329e = imageView;
            imageView.setImageBitmap(com.facebook.ads.internal.q.b.c.a(b.IC_AD_CHOICES));
            addView(this.f21329e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(this.f21328d.density * 16.0f), Math.round(this.f21328d.density * 16.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            layoutParams.setMargins(Math.round(this.f21328d.density * 4.0f), Math.round(this.f21328d.density * 2.0f), Math.round(this.f21328d.density * 2.0f), Math.round(this.f21328d.density * 2.0f));
            this.f21329e.setLayoutParams(layoutParams);
        }

        private void c() {
            TextView textView = new TextView(getContext());
            this.f21330f = textView;
            addView(textView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = 0;
            layoutParams.leftMargin = (int) (this.f21328d.density * 20.0f);
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            this.f21330f.setLayoutParams(layoutParams);
            this.f21330f.setSingleLine();
            this.f21330f.setText(this.f21325a);
            this.f21330f.setTextSize(10.0f);
            this.f21330f.setTextColor(-4341303);
        }

        /* access modifiers changed from: private */
        public void d() {
            Paint paint = new Paint();
            paint.setTextSize(this.f21330f.getTextSize());
            int round = Math.round(paint.measureText(this.f21325a) + (this.f21328d.density * 4.0f));
            final int width = getWidth();
            final int i2 = round + width;
            this.f21331g = true;
            AnonymousClass2 r3 = new Animation() {
                /* access modifiers changed from: protected */
                public void applyTransformation(float f2, Transformation transformation) {
                    int i2 = width;
                    int i3 = (int) (((float) i2) + (((float) (i2 - i2)) * f2));
                    C0041a.this.getLayoutParams().width = i3;
                    C0041a.this.requestLayout();
                    C0041a.this.f21330f.getLayoutParams().width = i3 - width;
                    C0041a.this.f21330f.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            r3.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (C0041a.this.f21331g) {
                                C0041a.this.e();
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
        public void e() {
            Paint paint = new Paint();
            paint.setTextSize(this.f21330f.getTextSize());
            int round = Math.round(paint.measureText(this.f21325a) + (this.f21328d.density * 4.0f));
            final int width = getWidth();
            final int i2 = width - round;
            AnonymousClass4 r2 = new Animation() {
                /* access modifiers changed from: protected */
                public void applyTransformation(float f2, Transformation transformation) {
                    int i2 = width;
                    int i3 = (int) (((float) i2) + (((float) (i2 - i2)) * f2));
                    C0041a.this.getLayoutParams().width = i3;
                    C0041a.this.requestLayout();
                    C0041a.this.f21330f.getLayoutParams().width = i3 - i2;
                    C0041a.this.f21330f.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            r2.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    boolean unused = C0041a.this.f21331g = false;
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

    public a(Context context, String str, String str2, float[] fArr) {
        super(context);
        C0041a aVar = new C0041a(context, "AdChoices", str, fArr, str2);
        this.f21324a = aVar;
        addView(aVar);
    }
}
