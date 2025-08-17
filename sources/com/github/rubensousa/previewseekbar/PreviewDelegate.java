package com.github.rubensousa.previewseekbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.github.rubensousa.previewseekbar.PreviewBar;
import com.github.rubensousa.previewseekbar.animator.PreviewAnimator;
import com.github.rubensousa.previewseekbar.animator.PreviewMorphAnimator;
import java.util.ArrayList;
import java.util.List;

public class PreviewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f22191a;

    /* renamed from: b  reason: collision with root package name */
    private PreviewAnimator f22192b;

    /* renamed from: c  reason: collision with root package name */
    private PreviewBar f22193c;

    /* renamed from: d  reason: collision with root package name */
    private List<PreviewBar.OnScrubListener> f22194d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<PreviewBar.OnPreviewVisibilityListener> f22195e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f22196f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22197g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22198h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22199i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22200j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22201k;

    public PreviewDelegate(PreviewBar previewBar) {
        this.f22193c = previewBar;
        this.f22199i = true;
        this.f22200j = true;
        this.f22192b = new PreviewMorphAnimator();
    }

    public static FrameLayout b(ViewGroup viewGroup, int i2) {
        if (i2 == -1) {
            return null;
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getId() == i2 && (childAt instanceof FrameLayout)) {
                return (FrameLayout) childAt;
            }
        }
        return null;
    }

    private int p(int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        ViewGroup viewGroup = (ViewGroup) this.f22191a.getParent();
        float f2 = ((float) i2) / ((float) i3);
        int left = this.f22191a.getLeft();
        int width = (viewGroup.getWidth() - viewGroup.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) this.f22191a.getLayoutParams()).rightMargin;
        float thumbOffset = (float) this.f22193c.getThumbOffset();
        float left2 = ((float) ((View) this.f22193c).getLeft()) + thumbOffset;
        float right = (left2 + (((((float) ((View) this.f22193c).getRight()) - thumbOffset) - left2) * f2)) - (((float) this.f22191a.getWidth()) / 2.0f);
        float width2 = ((float) this.f22191a.getWidth()) + right;
        float f3 = (float) left;
        if (right >= f3 && width2 <= ((float) width)) {
            return (int) right;
        }
        if (right < f3) {
            return left;
        }
        return width - this.f22191a.getWidth();
    }

    public void a(FrameLayout frameLayout) {
        this.f22191a = frameLayout;
        frameLayout.setVisibility(4);
        this.f22197g = true;
    }

    public void c() {
        if (this.f22196f && this.f22197g) {
            if (this.f22199i) {
                this.f22192b.a(this.f22191a, this.f22193c);
            } else {
                this.f22192b.b(this.f22191a, this.f22193c);
                this.f22191a.setVisibility(4);
            }
            this.f22196f = false;
            for (PreviewBar.OnPreviewVisibilityListener a2 : this.f22195e) {
                a2.a(this.f22193c, false);
            }
        }
    }

    public boolean d() {
        return this.f22197g;
    }

    public boolean e() {
        return this.f22196f;
    }

    public boolean f() {
        return this.f22201k;
    }

    public void g(int i2, boolean z2) {
        if (this.f22197g) {
            this.f22191a.setX((float) p(i2, this.f22193c.getMax()));
            if (this.f22199i) {
                this.f22192b.c(this.f22191a, this.f22193c);
            }
            if (!this.f22201k && z2 && this.f22198h) {
                this.f22201k = true;
                o();
            }
            for (PreviewBar.OnScrubListener c2 : this.f22194d) {
                c2.c(this.f22193c, i2, z2);
            }
        }
    }

    public void h() {
        for (PreviewBar.OnScrubListener b2 : this.f22194d) {
            b2.b(this.f22193c);
        }
    }

    public void i() {
        this.f22201k = false;
        if (this.f22200j) {
            c();
        }
        for (PreviewBar.OnScrubListener a2 : this.f22194d) {
            a2.a(this.f22193c);
        }
    }

    public void j(boolean z2) {
        this.f22199i = z2;
    }

    public void k(PreviewAnimator previewAnimator) {
        this.f22192b = previewAnimator;
    }

    public void l(boolean z2) {
        this.f22200j = z2;
    }

    public void m(boolean z2) {
        this.f22198h = z2;
    }

    public void n(PreviewLoader previewLoader) {
    }

    public void o() {
        if (!this.f22196f && this.f22197g && this.f22198h) {
            if (this.f22199i) {
                this.f22192b.d(this.f22191a, this.f22193c);
            } else {
                this.f22192b.b(this.f22191a, this.f22193c);
                this.f22191a.setVisibility(0);
            }
            this.f22196f = true;
            for (PreviewBar.OnPreviewVisibilityListener a2 : this.f22195e) {
                a2.a(this.f22193c, true);
            }
        }
    }

    public void q(int i2, int i3) {
        if (e() && !f()) {
            g(i2, false);
        }
    }
}
