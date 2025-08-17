package com.movie.ui.activity.shows.seasons;

import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class SeasonFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SeasonFragment f32801a;

    public SeasonFragment_ViewBinding(SeasonFragment seasonFragment, View view) {
        this.f32801a = seasonFragment;
        seasonFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loadingbar, "field 'progressBar'", ProgressBar.class);
        seasonFragment.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list, "field 'recyclerView'", RecyclerView.class);
        seasonFragment.viewEmty = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_empty, "field 'viewEmty'", AnimatorStateView.class);
    }

    public void unbind() {
        SeasonFragment seasonFragment = this.f32801a;
        if (seasonFragment != null) {
            this.f32801a = null;
            seasonFragment.progressBar = null;
            seasonFragment.recyclerView = null;
            seasonFragment.viewEmty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
