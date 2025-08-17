package com.movie.ui.fragment.mylist;

import android.view.View;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserListSelectionDialog f33443b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserListAdapter f33444c;

    public /* synthetic */ v(UserListSelectionDialog userListSelectionDialog, UserListAdapter userListAdapter) {
        this.f33443b = userListSelectionDialog;
        this.f33444c = userListAdapter;
    }

    public final void onClick(View view) {
        this.f33443b.M(this.f33444c, view);
    }
}
