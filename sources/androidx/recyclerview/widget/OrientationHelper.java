package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class OrientationHelper {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.LayoutManager f11211a;

    /* renamed from: b  reason: collision with root package name */
    private int f11212b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f11213c;

    public static OrientationHelper a(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public int d(View view) {
                return this.f11211a.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f11211a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f11211a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public int g(View view) {
                return this.f11211a.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int h() {
                return this.f11211a.getWidth();
            }

            public int i() {
                return this.f11211a.getWidth() - this.f11211a.getPaddingRight();
            }

            public int j() {
                return this.f11211a.getPaddingRight();
            }

            public int k() {
                return this.f11211a.getWidthMode();
            }

            public int l() {
                return this.f11211a.getHeightMode();
            }

            public int m() {
                return this.f11211a.getPaddingLeft();
            }

            public int n() {
                return (this.f11211a.getWidth() - this.f11211a.getPaddingLeft()) - this.f11211a.getPaddingRight();
            }

            public int p(View view) {
                this.f11211a.getTransformedBoundingBox(view, true, this.f11213c);
                return this.f11213c.right;
            }

            public int q(View view) {
                this.f11211a.getTransformedBoundingBox(view, true, this.f11213c);
                return this.f11213c.left;
            }

            public void r(int i2) {
                this.f11211a.offsetChildrenHorizontal(i2);
            }
        };
    }

    public static OrientationHelper b(RecyclerView.LayoutManager layoutManager, int i2) {
        if (i2 == 0) {
            return a(layoutManager);
        }
        if (i2 == 1) {
            return c(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public int d(View view) {
                return this.f11211a.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f11211a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f11211a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public int g(View view) {
                return this.f11211a.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int h() {
                return this.f11211a.getHeight();
            }

            public int i() {
                return this.f11211a.getHeight() - this.f11211a.getPaddingBottom();
            }

            public int j() {
                return this.f11211a.getPaddingBottom();
            }

            public int k() {
                return this.f11211a.getHeightMode();
            }

            public int l() {
                return this.f11211a.getWidthMode();
            }

            public int m() {
                return this.f11211a.getPaddingTop();
            }

            public int n() {
                return (this.f11211a.getHeight() - this.f11211a.getPaddingTop()) - this.f11211a.getPaddingBottom();
            }

            public int p(View view) {
                this.f11211a.getTransformedBoundingBox(view, true, this.f11213c);
                return this.f11213c.bottom;
            }

            public int q(View view) {
                this.f11211a.getTransformedBoundingBox(view, true, this.f11213c);
                return this.f11213c.top;
            }

            public void r(int i2) {
                this.f11211a.offsetChildrenVertical(i2);
            }
        };
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f11212b) {
            return 0;
        }
        return n() - this.f11212b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i2);

    public void s() {
        this.f11212b = n();
    }

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f11212b = Integer.MIN_VALUE;
        this.f11213c = new Rect();
        this.f11211a = layoutManager;
    }
}
