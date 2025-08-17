package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class PagerSnapHelper extends SnapHelper {

    /* renamed from: d  reason: collision with root package name */
    private OrientationHelper f11214d;

    /* renamed from: e  reason: collision with root package name */
    private OrientationHelper f11215e;

    private int l(View view, OrientationHelper orientationHelper) {
        return (orientationHelper.g(view) + (orientationHelper.e(view) / 2)) - (orientationHelper.m() + (orientationHelper.n() / 2));
    }

    private View m(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int m2 = orientationHelper.m() + (orientationHelper.n() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int abs = Math.abs((orientationHelper.g(childAt) + (orientationHelper.e(childAt) / 2)) - m2);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    private OrientationHelper n(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f11215e;
        if (orientationHelper == null || orientationHelper.f11211a != layoutManager) {
            this.f11215e = OrientationHelper.a(layoutManager);
        }
        return this.f11215e;
    }

    private OrientationHelper o(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return p(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return n(layoutManager);
        }
        return null;
    }

    private OrientationHelper p(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f11214d;
        if (orientationHelper == null || orientationHelper.f11211a != layoutManager) {
            this.f11214d = OrientationHelper.c(layoutManager);
        }
        return this.f11214d;
    }

    private boolean q(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        return layoutManager.canScrollHorizontally() ? i2 > 0 : i3 > 0;
    }

    private boolean r(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        if (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f) {
            return true;
        }
        return false;
    }

    public int[] c(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = l(view, n(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = l(view, p(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.SmoothScroller d(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.f11302a.getContext()) {
            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public int calculateTimeForScrolling(int i2) {
                return Math.min(100, super.calculateTimeForScrolling(i2));
            }

            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] c2 = pagerSnapHelper.c(pagerSnapHelper.f11302a.getLayoutManager(), view);
                int i2 = c2[0];
                int i3 = c2[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                if (calculateTimeForDeceleration > 0) {
                    action.d(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    @SuppressLint({"UnknownNullness"})
    public View g(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return m(layoutManager, p(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return m(layoutManager, n(layoutManager));
        }
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public int h(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        OrientationHelper o2;
        int i4;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (o2 = o(layoutManager)) == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = layoutManager.getChildAt(i7);
            if (childAt != null) {
                int l2 = l(childAt, o2);
                if (l2 <= 0 && l2 > i5) {
                    view2 = childAt;
                    i5 = l2;
                }
                if (l2 >= 0 && l2 < i6) {
                    view = childAt;
                    i6 = l2;
                }
            }
        }
        boolean q2 = q(layoutManager, i2, i3);
        if (q2 && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!q2 && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (q2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view);
        if (r(layoutManager) == q2) {
            i4 = -1;
        } else {
            i4 = 1;
        }
        int i8 = position + i4;
        if (i8 < 0 || i8 >= itemCount) {
            return -1;
        }
        return i8;
    }
}
