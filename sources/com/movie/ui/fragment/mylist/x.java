package com.movie.ui.fragment.mylist;

import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserListSelectionDialog f33446b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserListAdapter f33447c;

    public /* synthetic */ x(UserListSelectionDialog userListSelectionDialog, UserListAdapter userListAdapter) {
        this.f33446b = userListSelectionDialog;
        this.f33447c = userListAdapter;
    }

    public final void accept(Object obj) {
        this.f33446b.K(this.f33447c, (List) obj);
    }
}
