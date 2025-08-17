package com.movie.ui.activity.sources.episodesPack;

import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
import com.movie.ui.activity.BaseActivity_ViewBinding;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class EpisodesActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private EpisodesActivity f32948b;

    public EpisodesActivity_ViewBinding(EpisodesActivity episodesActivity, View view) {
        super(episodesActivity, view);
        this.f32948b = episodesActivity;
        episodesActivity.rv_magnetfiles = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_magnetfiles, "field 'rv_magnetfiles'", RecyclerView.class);
        episodesActivity.viewEmpty = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_empty, "field 'viewEmpty'", AnimatorStateView.class);
        episodesActivity.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'loading'", ProgressBar.class);
    }

    public void unbind() {
        EpisodesActivity episodesActivity = this.f32948b;
        if (episodesActivity != null) {
            this.f32948b = null;
            episodesActivity.rv_magnetfiles = null;
            episodesActivity.viewEmpty = null;
            episodesActivity.loading = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
