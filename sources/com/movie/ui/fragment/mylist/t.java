package com.movie.ui.fragment.mylist;

import android.view.View;
import com.database.entitys.UserListEntity;
import com.movie.ui.fragment.mylist.SelecetUserListAdapter;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelecetUserListAdapter.UserViewHolder f33438b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserListEntity f33439c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f33440d;

    public /* synthetic */ t(SelecetUserListAdapter.UserViewHolder userViewHolder, UserListEntity userListEntity, int i2) {
        this.f33438b = userViewHolder;
        this.f33439c = userListEntity;
        this.f33440d = i2;
    }

    public final void onClick(View view) {
        this.f33438b.f(this.f33439c, this.f33440d, view);
    }
}
