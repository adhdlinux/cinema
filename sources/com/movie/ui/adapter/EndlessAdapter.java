package com.movie.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yoku.marumovie.R;
import java.util.List;
import rx.functions.Action1;

public abstract class EndlessAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Action1<List<T>> {

    /* renamed from: n  reason: collision with root package name */
    protected final LayoutInflater f33059n;

    /* renamed from: o  reason: collision with root package name */
    protected List<T> f33060o;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f33061p = false;

    /* renamed from: q  reason: collision with root package name */
    private Context f33062q;

    /* renamed from: r  reason: collision with root package name */
    private int f33063r = 6;

    /* renamed from: s  reason: collision with root package name */
    private boolean f33064s = false;

    public EndlessAdapter(Context context, List<T> list) {
        this.f33059n = LayoutInflater.from(context);
        this.f33060o = list;
        this.f33062q = context;
        this.f33063r = 6;
    }

    public void c(T t2) {
        int size = this.f33060o.size();
        this.f33060o.add(t2);
        notifyItemRangeInserted(size, 1);
    }

    public void d() {
        this.f33063r = 6;
        if (!this.f33060o.isEmpty()) {
            this.f33060o.clear();
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public int e() {
        return this.f33061p ? 1 : 0;
    }

    public T f(int i2) {
        if (!i(i2)) {
            return this.f33060o.get(i2);
        }
        return null;
    }

    public List<T> g() {
        return this.f33060o;
    }

    public int getItemCount() {
        return this.f33060o.size() + e();
    }

    public int getItemViewType(int i2) {
        return i(i2) ? 1 : 2;
    }

    public boolean h() {
        return this.f33061p;
    }

    public boolean i(int i2) {
        return this.f33061p && i2 == getItemCount() - 1;
    }

    /* access modifiers changed from: protected */
    public abstract RecyclerView.ViewHolder j(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract RecyclerView.ViewHolder k(ViewGroup viewGroup);

    public void l(List<T> list) {
        this.f33060o = list;
        notifyDataSetChanged();
    }

    public void m(boolean z2) {
        boolean z3 = this.f33061p;
        if (z3 == z2) {
            return;
        }
        if (z3) {
            notifyItemRemoved(getItemCount());
            this.f33061p = false;
            return;
        }
        notifyItemInserted(getItemCount());
        this.f33061p = true;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 2) {
            return k(viewGroup);
        }
        if (i2 != 3) {
            return new RecyclerView.ViewHolder(this.f33059n.inflate(R.layout.item_load_more, viewGroup, false)) {
            };
        }
        return j(viewGroup);
    }
}
