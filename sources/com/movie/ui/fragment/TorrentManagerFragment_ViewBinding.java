package com.movie.ui.fragment;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.yoku.marumovie.R;

public class TorrentManagerFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private TorrentManagerFragment f33320a;

    public TorrentManagerFragment_ViewBinding(TorrentManagerFragment torrentManagerFragment, View view) {
        this.f33320a = torrentManagerFragment;
        torrentManagerFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tabLayout'", TabLayout.class);
        torrentManagerFragment.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpage, "field 'viewPager'", ViewPager.class);
    }

    public void unbind() {
        TorrentManagerFragment torrentManagerFragment = this.f33320a;
        if (torrentManagerFragment != null) {
            this.f33320a = null;
            torrentManagerFragment.tabLayout = null;
            torrentManagerFragment.viewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
