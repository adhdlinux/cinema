package com.movie.ui.fragment.mylist;

import android.content.Context;
import android.content.DialogInterface;

public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyListFragment f33424b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SelecetUserListAdapter f33425c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f33426d;

    public /* synthetic */ c(MyListFragment myListFragment, SelecetUserListAdapter selecetUserListAdapter, Context context) {
        this.f33424b = myListFragment;
        this.f33425c = selecetUserListAdapter;
        this.f33426d = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f33424b.r0(this.f33425c, this.f33426d, dialogInterface, i2);
    }
}
