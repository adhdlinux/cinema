package com.movie.ui.activity.shows.episodes.bottomSheet;

import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class EpisodeBottomSheetFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private EpisodeBottomSheetFragment f32717a;

    public EpisodeBottomSheetFragment_ViewBinding(EpisodeBottomSheetFragment episodeBottomSheetFragment, View view) {
        this.f32717a = episodeBottomSheetFragment;
        episodeBottomSheetFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rvList, "field 'rvList'", RecyclerView.class);
        episodeBottomSheetFragment.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
    }

    public void unbind() {
        EpisodeBottomSheetFragment episodeBottomSheetFragment = this.f32717a;
        if (episodeBottomSheetFragment != null) {
            this.f32717a = null;
            episodeBottomSheetFragment.rvList = null;
            episodeBottomSheetFragment.loading = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
