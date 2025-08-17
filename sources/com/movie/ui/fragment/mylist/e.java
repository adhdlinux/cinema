package com.movie.ui.fragment.mylist;

import com.database.entitys.UserListEntity;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class e implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyListFragment f33427a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserListEntity f33428b;

    public /* synthetic */ e(MyListFragment myListFragment, UserListEntity userListEntity) {
        this.f33427a = myListFragment;
        this.f33428b = userListEntity;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        this.f33427a.d0(this.f33428b, observableEmitter);
    }
}
