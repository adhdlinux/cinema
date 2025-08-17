package com.movie.ui.fragment.premium.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: j  reason: collision with root package name */
    private int f33581j;

    public BaseViewHolder(View view) {
        super(view);
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    public void c(int i2) {
        this.f33581j = i2;
        b();
    }
}
