package com.facebook.ads.internal.view.e;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class c extends RecyclerView.Adapter<e> {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f21194a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21195b;

    c(List<String> list, int i2) {
        this.f21194a = list;
        this.f21195b = i2;
    }

    /* renamed from: a */
    public e onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new e(new d(viewGroup.getContext()));
    }

    /* renamed from: a */
    public void onBindViewHolder(e eVar, int i2) {
        String str = this.f21194a.get(i2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i3 = this.f21195b;
        if (i2 == 0) {
            i3 *= 4;
        }
        marginLayoutParams.setMargins(i3, 0, i2 >= getItemCount() + -1 ? this.f21195b * 4 : this.f21195b, 0);
        eVar.a().setLayoutParams(marginLayoutParams);
        eVar.a().a(str);
    }

    public int getItemCount() {
        return this.f21194a.size();
    }
}
