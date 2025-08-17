package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {

    /* renamed from: g  reason: collision with root package name */
    boolean f11301g = true;

    @SuppressLint({"UnknownNullness"})
    public final void A(RecyclerView.ViewHolder viewHolder) {
        I(viewHolder);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void B(RecyclerView.ViewHolder viewHolder) {
        J(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void C(RecyclerView.ViewHolder viewHolder, boolean z2) {
        K(viewHolder, z2);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void D(RecyclerView.ViewHolder viewHolder, boolean z2) {
        L(viewHolder, z2);
    }

    @SuppressLint({"UnknownNullness"})
    public final void E(RecyclerView.ViewHolder viewHolder) {
        M(viewHolder);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void F(RecyclerView.ViewHolder viewHolder) {
        N(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void G(RecyclerView.ViewHolder viewHolder) {
        O(viewHolder);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void H(RecyclerView.ViewHolder viewHolder) {
        P(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public void I(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void J(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void K(RecyclerView.ViewHolder viewHolder, boolean z2) {
    }

    @SuppressLint({"UnknownNullness"})
    public void L(RecyclerView.ViewHolder viewHolder, boolean z2) {
    }

    @SuppressLint({"UnknownNullness"})
    public void M(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void N(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void O(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void P(RecyclerView.ViewHolder viewHolder) {
    }

    public boolean a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2;
        int i3;
        if (itemHolderInfo == null || ((i2 = itemHolderInfo.f11233a) == (i3 = itemHolderInfo2.f11233a) && itemHolderInfo.f11234b == itemHolderInfo2.f11234b)) {
            return w(viewHolder);
        }
        return y(viewHolder, i2, itemHolderInfo.f11234b, i3, itemHolderInfo2.f11234b);
    }

    public boolean b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2;
        int i3;
        int i4 = itemHolderInfo.f11233a;
        int i5 = itemHolderInfo.f11234b;
        if (viewHolder2.shouldIgnore()) {
            int i6 = itemHolderInfo.f11233a;
            i2 = itemHolderInfo.f11234b;
            i3 = i6;
        } else {
            i3 = itemHolderInfo2.f11233a;
            i2 = itemHolderInfo2.f11234b;
        }
        return x(viewHolder, viewHolder2, i4, i5, i3, i2);
    }

    public boolean c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2;
        int i3;
        int i4 = itemHolderInfo.f11233a;
        int i5 = itemHolderInfo.f11234b;
        View view = viewHolder.itemView;
        if (itemHolderInfo2 == null) {
            i2 = view.getLeft();
        } else {
            i2 = itemHolderInfo2.f11233a;
        }
        int i6 = i2;
        if (itemHolderInfo2 == null) {
            i3 = view.getTop();
        } else {
            i3 = itemHolderInfo2.f11234b;
        }
        int i7 = i3;
        if (viewHolder.isRemoved() || (i4 == i6 && i5 == i7)) {
            return z(viewHolder);
        }
        view.layout(i6, i7, view.getWidth() + i6, view.getHeight() + i7);
        return y(viewHolder, i4, i5, i6, i7);
    }

    public boolean d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2 = itemHolderInfo.f11233a;
        int i3 = itemHolderInfo2.f11233a;
        if (i2 == i3 && itemHolderInfo.f11234b == itemHolderInfo2.f11234b) {
            E(viewHolder);
            return false;
        }
        return y(viewHolder, i2, itemHolderInfo.f11234b, i3, itemHolderInfo2.f11234b);
    }

    public boolean f(RecyclerView.ViewHolder viewHolder) {
        return !this.f11301g || viewHolder.isInvalid();
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean w(RecyclerView.ViewHolder viewHolder);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean x(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean y(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean z(RecyclerView.ViewHolder viewHolder);
}
