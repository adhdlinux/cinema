package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.media3.common.text.Cue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SubtitleView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private List<Cue> f10144b = Collections.emptyList();

    /* renamed from: c  reason: collision with root package name */
    private CaptionStyleCompat f10145c = CaptionStyleCompat.f9766g;

    /* renamed from: d  reason: collision with root package name */
    private int f10146d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f10147e = 0.0533f;

    /* renamed from: f  reason: collision with root package name */
    private float f10148f = 0.08f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10149g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10150h = true;

    /* renamed from: i  reason: collision with root package name */
    private int f10151i;

    /* renamed from: j  reason: collision with root package name */
    private Output f10152j;

    /* renamed from: k  reason: collision with root package name */
    private View f10153k;

    interface Output {
        void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.f10152j = canvasSubtitleOutput;
        this.f10153k = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.f10151i = 1;
    }

    private Cue a(Cue cue) {
        Cue.Builder a2 = cue.a();
        if (!this.f10149g) {
            SubtitleViewUtils.e(a2);
        } else if (!this.f10150h) {
            SubtitleViewUtils.f(a2);
        }
        return a2.a();
    }

    private void d(int i2, float f2) {
        this.f10146d = i2;
        this.f10147e = f2;
        g();
    }

    private void g() {
        this.f10152j.a(getCuesWithStylingPreferencesApplied(), this.f10145c, this.f10147e, this.f10146d, this.f10148f);
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f10149g && this.f10150h) {
            return this.f10144b;
        }
        ArrayList arrayList = new ArrayList(this.f10144b.size());
        for (int i2 = 0; i2 < this.f10144b.size(); i2++) {
            arrayList.add(a(this.f10144b.get(i2)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (!isInEditMode() && (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            return captioningManager.getFontScale();
        }
        return 1.0f;
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        if (isInEditMode()) {
            return CaptionStyleCompat.f9766g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return CaptionStyleCompat.f9766g;
        }
        return CaptionStyleCompat.a(captioningManager.getUserStyle());
    }

    private <T extends View & Output> void setView(T t2) {
        removeView(this.f10153k);
        View view = this.f10153k;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).g();
        }
        this.f10153k = t2;
        this.f10152j = (Output) t2;
        addView(t2);
    }

    public void b(int i2, float f2) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        d(2, TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }

    public void c(float f2, boolean z2) {
        d(z2 ? 1 : 0, f2);
    }

    public void e() {
        setStyle(getUserCaptionStyle());
    }

    public void f() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.f10150h = z2;
        g();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.f10149g = z2;
        g();
    }

    public void setBottomPaddingFraction(float f2) {
        this.f10148f = f2;
        g();
    }

    public void setCues(List<Cue> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f10144b = list;
        g();
    }

    public void setFractionalTextSize(float f2) {
        c(f2, false);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.f10145c = captionStyleCompat;
        g();
    }

    public void setViewType(int i2) {
        if (this.f10151i != i2) {
            if (i2 == 1) {
                setView(new CanvasSubtitleOutput(getContext()));
            } else if (i2 == 2) {
                setView(new WebViewSubtitleOutput(getContext()));
            } else {
                throw new IllegalArgumentException();
            }
            this.f10151i = i2;
        }
    }
}
