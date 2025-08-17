package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class PreferenceViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: j  reason: collision with root package name */
    private final SparseArray<View> f10883j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10884k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10885l;

    PreferenceViewHolder(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.f10883j = sparseArray;
        sparseArray.put(16908310, view.findViewById(16908310));
        sparseArray.put(16908304, view.findViewById(16908304));
        sparseArray.put(16908294, view.findViewById(16908294));
        int i2 = R$id.icon_frame;
        sparseArray.put(i2, view.findViewById(i2));
        sparseArray.put(16908350, view.findViewById(16908350));
    }

    public View a(int i2) {
        View view = this.f10883j.get(i2);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i2);
        if (findViewById != null) {
            this.f10883j.put(i2, findViewById);
        }
        return findViewById;
    }

    public boolean b() {
        return this.f10884k;
    }

    public boolean c() {
        return this.f10885l;
    }

    public void d(boolean z2) {
        this.f10884k = z2;
    }

    public void e(boolean z2) {
        this.f10885l = z2;
    }
}
