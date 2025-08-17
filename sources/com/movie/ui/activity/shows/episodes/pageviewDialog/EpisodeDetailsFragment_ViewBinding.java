package com.movie.ui.activity.shows.episodes.pageviewDialog;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class EpisodeDetailsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private EpisodeDetailsFragment f32737a;

    public EpisodeDetailsFragment_ViewBinding(EpisodeDetailsFragment episodeDetailsFragment, View view) {
        this.f32737a = episodeDetailsFragment;
        Class cls = TextView.class;
        episodeDetailsFragment.textViewTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewEpisodeTitle, "field 'textViewTitle'", cls);
        episodeDetailsFragment.textViewEpisodeOverview = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewEpisodeOverview, "field 'textViewEpisodeOverview'", cls);
        episodeDetailsFragment.textViewReleaseTime = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewEpisodeReleaseTime, "field 'textViewReleaseTime'", cls);
        episodeDetailsFragment.textViewSource = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewSource, "field 'textViewSource'", cls);
        episodeDetailsFragment.content = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", ConstraintLayout.class);
        episodeDetailsFragment.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
        episodeDetailsFragment.mCoverImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.movie_cover, "field 'mCoverImage'", ImageView.class);
        episodeDetailsFragment.playbtn = (ImageButton) Utils.findRequiredViewAsType(view, R.id.imageButton, "field 'playbtn'", ImageButton.class);
        episodeDetailsFragment.checkBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cbWatched, "field 'checkBox'", CheckBox.class);
    }

    public void unbind() {
        EpisodeDetailsFragment episodeDetailsFragment = this.f32737a;
        if (episodeDetailsFragment != null) {
            this.f32737a = null;
            episodeDetailsFragment.textViewTitle = null;
            episodeDetailsFragment.textViewEpisodeOverview = null;
            episodeDetailsFragment.textViewReleaseTime = null;
            episodeDetailsFragment.textViewSource = null;
            episodeDetailsFragment.content = null;
            episodeDetailsFragment.loading = null;
            episodeDetailsFragment.mCoverImage = null;
            episodeDetailsFragment.playbtn = null;
            episodeDetailsFragment.checkBox = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
