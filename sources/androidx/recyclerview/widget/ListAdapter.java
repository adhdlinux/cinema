package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: n  reason: collision with root package name */
    final AsyncListDiffer<T> f11207n;

    /* renamed from: o  reason: collision with root package name */
    private final AsyncListDiffer.ListListener<T> f11208o;

    protected ListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        AnonymousClass1 r02 = new AsyncListDiffer.ListListener<T>() {
            public void a(List<T> list, List<T> list2) {
                ListAdapter.this.d(list, list2);
            }
        };
        this.f11208o = r02;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).a());
        this.f11207n = asyncListDiffer;
        asyncListDiffer.a(r02);
    }

    /* access modifiers changed from: protected */
    public T c(int i2) {
        return this.f11207n.b().get(i2);
    }

    public void d(List<T> list, List<T> list2) {
    }

    public void e(List<T> list) {
        this.f11207n.e(list);
    }

    public int getItemCount() {
        return this.f11207n.b().size();
    }
}
