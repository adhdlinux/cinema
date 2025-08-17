package com.movie.ui.fragment.favored;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.yoku.marumovie.R;

public class FavoredPageFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private FavoredPageFragment f33341a;

    public FavoredPageFragment_ViewBinding(FavoredPageFragment favoredPageFragment, View view) {
        this.f33341a = favoredPageFragment;
        favoredPageFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tabLayout'", TabLayout.class);
    }

    public void unbind() {
        FavoredPageFragment favoredPageFragment = this.f33341a;
        if (favoredPageFragment != null) {
            this.f33341a = null;
            favoredPageFragment.tabLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
