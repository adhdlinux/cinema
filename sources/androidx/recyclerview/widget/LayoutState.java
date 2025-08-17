package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class LayoutState {

    /* renamed from: a  reason: collision with root package name */
    boolean f11173a = true;

    /* renamed from: b  reason: collision with root package name */
    int f11174b;

    /* renamed from: c  reason: collision with root package name */
    int f11175c;

    /* renamed from: d  reason: collision with root package name */
    int f11176d;

    /* renamed from: e  reason: collision with root package name */
    int f11177e;

    /* renamed from: f  reason: collision with root package name */
    int f11178f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f11179g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f11180h;

    /* renamed from: i  reason: collision with root package name */
    boolean f11181i;

    LayoutState() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        int i2 = this.f11175c;
        return i2 >= 0 && i2 < state.b();
    }

    /* access modifiers changed from: package-private */
    public View b(RecyclerView.Recycler recycler) {
        View o2 = recycler.o(this.f11175c);
        this.f11175c += this.f11176d;
        return o2;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f11174b + ", mCurrentPosition=" + this.f11175c + ", mItemDirection=" + this.f11176d + ", mLayoutDirection=" + this.f11177e + ", mStartLine=" + this.f11178f + ", mEndLine=" + this.f11179g + '}';
    }
}
