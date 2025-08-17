package com.movie.ui.fragment.mylist;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class MyListFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MyListFragment f33394a;

    public MyListFragment_ViewBinding(MyListFragment myListFragment, View view) {
        this.f33394a = myListFragment;
        myListFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tabLayout'", TabLayout.class);
        myListFragment.emptyView = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_empty, "field 'emptyView'", AnimatorStateView.class);
    }

    public void unbind() {
        MyListFragment myListFragment = this.f33394a;
        if (myListFragment != null) {
            this.f33394a = null;
            myListFragment.tabLayout = null;
            myListFragment.emptyView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
