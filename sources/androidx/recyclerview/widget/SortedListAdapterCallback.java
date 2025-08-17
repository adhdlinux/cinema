package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {

    /* renamed from: b  reason: collision with root package name */
    final RecyclerView.Adapter<?> f11318b;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter<?> adapter) {
        this.f11318b = adapter;
    }

    public void a(int i2, int i3) {
        this.f11318b.notifyItemRangeInserted(i2, i3);
    }

    public void b(int i2, int i3) {
        this.f11318b.notifyItemRangeRemoved(i2, i3);
    }

    @SuppressLint({"UnknownNullness"})
    public void c(int i2, int i3, Object obj) {
        this.f11318b.notifyItemRangeChanged(i2, i3, obj);
    }

    public void d(int i2, int i3) {
        this.f11318b.notifyItemMoved(i2, i3);
    }

    public void h(int i2, int i3) {
        this.f11318b.notifyItemRangeChanged(i2, i3);
    }
}
