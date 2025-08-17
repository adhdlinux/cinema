package com.movie.ui.fragment.mylist;

import android.content.DialogInterface;
import android.view.MenuItem;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyListFragment f33421b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f33422c;

    public /* synthetic */ a(MyListFragment myListFragment, MenuItem menuItem) {
        this.f33421b = myListFragment;
        this.f33422c = menuItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f33421b.j0(this.f33422c, dialogInterface, i2);
    }
}
