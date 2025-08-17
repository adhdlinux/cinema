package com.github.amlcurran.showcaseview;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.github.amlcurran.showcaseview.targets.Target;

public class ShowcaseView extends RelativeLayout implements View.OnTouchListener {

    /* renamed from: o  reason: collision with root package name */
    private static final int f22069o = Color.parseColor("#33B5E5");

    /* renamed from: b  reason: collision with root package name */
    private Button f22070b;

    /* renamed from: c  reason: collision with root package name */
    private int f22071c;

    /* renamed from: d  reason: collision with root package name */
    private int f22072d;

    /* renamed from: e  reason: collision with root package name */
    private float f22073e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22074f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22075g;

    /* renamed from: h  reason: collision with root package name */
    private OnShowcaseEventListener f22076h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22077i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22078j;

    /* renamed from: k  reason: collision with root package name */
    private int f22079k;

    /* renamed from: l  reason: collision with root package name */
    private int f22080l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22081m;

    /* renamed from: n  reason: collision with root package name */
    private View.OnClickListener f22082n;

    private void d(TypedArray typedArray, boolean z2) {
        this.f22079k = typedArray.getColor(R$styleable.f22063c, Color.argb(128, 80, 80, 80));
        this.f22080l = typedArray.getColor(R$styleable.f22066f, f22069o);
        if (TextUtils.isEmpty(typedArray.getString(R$styleable.f22064d))) {
            getResources().getString(17039370);
        }
        typedArray.getBoolean(R$styleable.f22067g, true);
        typedArray.getResourceId(R$styleable.f22068h, R$style.TextAppearance_ShowcaseView_Title);
        typedArray.getResourceId(R$styleable.f22065e, R$style.TextAppearance_ShowcaseView_Detail);
        typedArray.recycle();
        throw null;
    }

    private void setBlockAllTouches(boolean z2) {
        this.f22081m = z2;
    }

    private void setContentTextPaint(TextPaint textPaint) {
        throw null;
    }

    private void setContentTitlePaint(TextPaint textPaint) {
        throw null;
    }

    private void setEndButton(Button button) {
        this.f22070b.setOnClickListener((View.OnClickListener) null);
        removeView(this.f22070b);
        this.f22070b = button;
        button.setOnClickListener(this.f22082n);
        button.setLayoutParams((RelativeLayout.LayoutParams) this.f22070b.getLayoutParams());
        addView(button);
    }

    private void setScaleMultiplier(float f2) {
        this.f22073e = f2;
    }

    private void setShowcaseDrawer(ShowcaseDrawer showcaseDrawer) {
        throw null;
    }

    private void setSingleShot(long j2) {
        throw null;
    }

    public void b(Target target, boolean z2) {
        postDelayed(new Runnable(target, z2) {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f22083b;

            {
                this.f22083b = r3;
            }

            public void run() {
                ShotStateStore unused = ShowcaseView.this.getClass();
                throw null;
            }
        }, 100);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, int i3) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f22071c < 0 || this.f22072d < 0) {
            super.dispatchDraw(canvas);
            return;
        }
        throw null;
    }

    public int getShowcaseX() {
        return this.f22071c;
    }

    public int getShowcaseY() {
        return this.f22072d;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f22081m) {
            return true;
        }
        motionEvent.getRawX();
        motionEvent.getRawY();
        if (1 == motionEvent.getAction() && this.f22075g) {
            throw null;
        } else if (!this.f22074f) {
            return false;
        } else {
            throw null;
        }
    }

    public void setBlocksTouches(boolean z2) {
        this.f22074f = z2;
    }

    public void setButtonPosition(RelativeLayout.LayoutParams layoutParams) {
        this.f22070b.setLayoutParams(layoutParams);
    }

    public void setButtonText(CharSequence charSequence) {
        Button button = this.f22070b;
        if (button != null) {
            button.setText(charSequence);
        }
    }

    public void setContentText(CharSequence charSequence) {
        throw null;
    }

    public void setContentTitle(CharSequence charSequence) {
        throw null;
    }

    public void setDetailTextAlignment(Layout.Alignment alignment) {
        throw null;
    }

    public void setHideOnTouchOutside(boolean z2) {
        this.f22075g = z2;
    }

    public void setOnShowcaseEventListener(OnShowcaseEventListener onShowcaseEventListener) {
        if (onShowcaseEventListener != null) {
            this.f22076h = onShowcaseEventListener;
        } else {
            this.f22076h = OnShowcaseEventListener.f22060a;
        }
    }

    public void setShouldCentreText(boolean z2) {
        this.f22078j = z2;
        this.f22077i = true;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setShowcasePosition(Point point) {
        c(point.x, point.y);
    }

    public void setShowcaseX(int i2) {
        c(i2, this.f22072d);
    }

    public void setShowcaseY(int i2) {
        c(this.f22071c, i2);
    }

    public void setStyle(int i2) {
        d(getContext().obtainStyledAttributes(i2, R$styleable.f22062b), true);
    }

    public void setTarget(Target target) {
        b(target, false);
    }

    public void setTitleTextAlignment(Layout.Alignment alignment) {
        throw null;
    }
}
