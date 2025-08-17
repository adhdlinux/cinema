package com.movie.ui.fragment.history;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.yoku.marumovie.R;

public class HistoryPageFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private HistoryPageFragment f33364a;

    public HistoryPageFragment_ViewBinding(HistoryPageFragment historyPageFragment, View view) {
        this.f33364a = historyPageFragment;
        historyPageFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tabLayout'", TabLayout.class);
        historyPageFragment.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpage, "field 'viewPager'", ViewPager.class);
    }

    public void unbind() {
        HistoryPageFragment historyPageFragment = this.f33364a;
        if (historyPageFragment != null) {
            this.f33364a = null;
            historyPageFragment.tabLayout = null;
            historyPageFragment.viewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
