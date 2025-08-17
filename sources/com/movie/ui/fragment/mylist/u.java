package com.movie.ui.fragment.mylist;

import android.content.DialogInterface;
import com.movie.ui.fragment.mylist.SelecetUserListAdapter;

public final /* synthetic */ class u implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelecetUserListAdapter.UserViewHolder f33441b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f33442c;

    public /* synthetic */ u(SelecetUserListAdapter.UserViewHolder userViewHolder, int i2) {
        this.f33441b = userViewHolder;
        this.f33442c = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f33441b.g(this.f33442c, dialogInterface, i2);
    }
}
