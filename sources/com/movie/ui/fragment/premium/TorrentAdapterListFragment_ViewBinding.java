package com.movie.ui.fragment.premium;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class TorrentAdapterListFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private TorrentAdapterListFragment f33526a;

    public TorrentAdapterListFragment_ViewBinding(TorrentAdapterListFragment torrentAdapterListFragment, View view) {
        this.f33526a = torrentAdapterListFragment;
        torrentAdapterListFragment.rv_magnetfiles = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_magnetfiles, "field 'rv_magnetfiles'", RecyclerView.class);
        torrentAdapterListFragment.viewEmpty = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_empty, "field 'viewEmpty'", AnimatorStateView.class);
    }

    public void unbind() {
        TorrentAdapterListFragment torrentAdapterListFragment = this.f33526a;
        if (torrentAdapterListFragment != null) {
            this.f33526a = null;
            torrentAdapterListFragment.rv_magnetfiles = null;
            torrentAdapterListFragment.viewEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
