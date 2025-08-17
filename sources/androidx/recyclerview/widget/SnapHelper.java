package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f11302a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f11303b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.OnScrollListener f11304c = new RecyclerView.OnScrollListener() {

        /* renamed from: o  reason: collision with root package name */
        boolean f11305o = false;

        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.f11305o) {
                this.f11305o = false;
                SnapHelper.this.k();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.f11305o = true;
            }
        }
    };

    private void f() {
        this.f11302a.removeOnScrollListener(this.f11304c);
        this.f11302a.setOnFlingListener((RecyclerView.OnFlingListener) null);
    }

    private void i() throws IllegalStateException {
        if (this.f11302a.getOnFlingListener() == null) {
            this.f11302a.addOnScrollListener(this.f11304c);
            this.f11302a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean j(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        RecyclerView.SmoothScroller d2;
        int h2;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (d2 = d(layoutManager)) == null || (h2 = h(layoutManager, i2, i3)) == -1) {
            return false;
        }
        d2.setTargetPosition(h2);
        layoutManager.startSmoothScroll(d2);
        return true;
    }

    public boolean a(int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = this.f11302a.getLayoutManager();
        if (layoutManager == null || this.f11302a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f11302a.getMinFlingVelocity();
        if ((Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && j(layoutManager, i2, i3)) {
            return true;
        }
        return false;
    }

    public void b(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f11302a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                f();
            }
            this.f11302a = recyclerView;
            if (recyclerView != null) {
                i();
                this.f11303b = new Scroller(this.f11302a.getContext(), new DecelerateInterpolator());
                k();
            }
        }
    }

    public abstract int[] c(RecyclerView.LayoutManager layoutManager, View view);

    /* access modifiers changed from: protected */
    public RecyclerView.SmoothScroller d(RecyclerView.LayoutManager layoutManager) {
        return e(layoutManager);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public LinearSmoothScroller e(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.f11302a.getContext()) {
            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                SnapHelper snapHelper = SnapHelper.this;
                RecyclerView recyclerView = snapHelper.f11302a;
                if (recyclerView != null) {
                    int[] c2 = snapHelper.c(recyclerView.getLayoutManager(), view);
                    int i2 = c2[0];
                    int i3 = c2[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                    if (calculateTimeForDeceleration > 0) {
                        action.d(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }
        };
    }

    @SuppressLint({"UnknownNullness"})
    public abstract View g(RecyclerView.LayoutManager layoutManager);

    @SuppressLint({"UnknownNullness"})
    public abstract int h(RecyclerView.LayoutManager layoutManager, int i2, int i3);

    /* access modifiers changed from: package-private */
    public void k() {
        RecyclerView.LayoutManager layoutManager;
        View g2;
        RecyclerView recyclerView = this.f11302a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (g2 = g(layoutManager)) != null) {
            int[] c2 = c(layoutManager, g2);
            int i2 = c2[0];
            if (i2 != 0 || c2[1] != 0) {
                this.f11302a.smoothScrollBy(i2, c2[1]);
            }
        }
    }
}
