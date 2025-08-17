package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SubtitleView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private List<Cue> f28251b = Collections.emptyList();

    /* renamed from: c  reason: collision with root package name */
    private CaptionStyleCompat f28252c = CaptionStyleCompat.f27844g;

    /* renamed from: d  reason: collision with root package name */
    private int f28253d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f28254e = 0.0533f;

    /* renamed from: f  reason: collision with root package name */
    private float f28255f = 0.08f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28256g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f28257h = true;

    /* renamed from: i  reason: collision with root package name */
    private int f28258i;

    /* renamed from: j  reason: collision with root package name */
    private Output f28259j;

    /* renamed from: k  reason: collision with root package name */
    private View f28260k;

    interface Output {
        void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.f28259j = canvasSubtitleOutput;
        this.f28260k = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.f28258i = 1;
    }

    private Cue a(Cue cue) {
        Cue.Builder b2 = cue.b();
        if (!this.f28256g) {
            SubtitleViewUtils.e(b2);
        } else if (!this.f28257h) {
            SubtitleViewUtils.f(b2);
        }
        return b2.a();
    }

    private void c(int i2, float f2) {
        this.f28253d = i2;
        this.f28254e = f2;
        f();
    }

    private void f() {
        this.f28259j.a(getCuesWithStylingPreferencesApplied(), this.f28252c, this.f28254e, this.f28253d, this.f28255f);
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f28256g && this.f28257h) {
            return this.f28251b;
        }
        ArrayList arrayList = new ArrayList(this.f28251b.size());
        for (int i2 = 0; i2 < this.f28251b.size(); i2++) {
            arrayList.add(a(this.f28251b.get(i2)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (Util.f28808a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        if (Util.f28808a < 19 || isInEditMode()) {
            return CaptionStyleCompat.f27844g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return CaptionStyleCompat.f27844g;
        }
        return CaptionStyleCompat.a(captioningManager.getUserStyle());
    }

    private <T extends View & Output> void setView(T t2) {
        removeView(this.f28260k);
        View view = this.f28260k;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).g();
        }
        this.f28260k = t2;
        this.f28259j = (Output) t2;
        addView(t2);
    }

    public void b(float f2, boolean z2) {
        c(z2 ? 1 : 0, f2);
    }

    public void d() {
        setStyle(getUserCaptionStyle());
    }

    public void e() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.f28257h = z2;
        f();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.f28256g = z2;
        f();
    }

    public void setBottomPaddingFraction(float f2) {
        this.f28255f = f2;
        f();
    }

    public void setCues(List<Cue> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f28251b = list;
        f();
    }

    public void setFractionalTextSize(float f2) {
        b(f2, false);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.f28252c = captionStyleCompat;
        f();
    }

    public void setViewType(int i2) {
        if (this.f28258i != i2) {
            if (i2 == 1) {
                setView(new CanvasSubtitleOutput(getContext()));
            } else if (i2 == 2) {
                setView(new WebViewSubtitleOutput(getContext()));
            } else {
                throw new IllegalArgumentException();
            }
            this.f28258i = i2;
        }
    }
}
