package com.movie.ui.fragment.mylist;

import android.view.MenuItem;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class q implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyListFragment f33435a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuItem f33436b;

    public /* synthetic */ q(MyListFragment myListFragment, MenuItem menuItem) {
        this.f33435a = myListFragment;
        this.f33436b = menuItem;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        this.f33435a.g0(this.f33436b, observableEmitter);
    }
}
