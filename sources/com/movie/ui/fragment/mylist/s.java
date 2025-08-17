package com.movie.ui.fragment.mylist;

import android.widget.CompoundButton;
import com.database.entitys.UserListEntity;

public final /* synthetic */ class s implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserListEntity f33437a;

    public /* synthetic */ s(UserListEntity userListEntity) {
        this.f33437a = userListEntity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        this.f33437a.f19324f = z2;
    }
}
