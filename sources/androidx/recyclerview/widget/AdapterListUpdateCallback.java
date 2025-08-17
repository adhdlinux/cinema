package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* renamed from: b  reason: collision with root package name */
    private final RecyclerView.Adapter f10996b;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.f10996b = adapter;
    }

    public void a(int i2, int i3) {
        this.f10996b.notifyItemRangeInserted(i2, i3);
    }

    public void b(int i2, int i3) {
        this.f10996b.notifyItemRangeRemoved(i2, i3);
    }

    @SuppressLint({"UnknownNullness"})
    public void c(int i2, int i3, Object obj) {
        this.f10996b.notifyItemRangeChanged(i2, i3, obj);
    }

    public void d(int i2, int i3) {
        this.f10996b.notifyItemMoved(i2, i3);
    }
}
