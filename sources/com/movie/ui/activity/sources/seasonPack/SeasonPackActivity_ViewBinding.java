package com.movie.ui.activity.sources.seasonPack;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
import com.movie.ui.activity.BaseActivity_ViewBinding;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class SeasonPackActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private SeasonPackActivity f33014b;

    public SeasonPackActivity_ViewBinding(SeasonPackActivity seasonPackActivity, View view) {
        super(seasonPackActivity, view);
        this.f33014b = seasonPackActivity;
        seasonPackActivity.progressbar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'progressbar'", ProgressBar.class);
        seasonPackActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_seasonpacks, "field 'recyclerView'", RecyclerView.class);
        seasonPackActivity.adViewFrameLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.adView, "field 'adViewFrameLayout'", FrameLayout.class);
        seasonPackActivity.mViewAnimator = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_empty, "field 'mViewAnimator'", AnimatorStateView.class);
    }

    public void unbind() {
        SeasonPackActivity seasonPackActivity = this.f33014b;
        if (seasonPackActivity != null) {
            this.f33014b = null;
            seasonPackActivity.progressbar = null;
            seasonPackActivity.recyclerView = null;
            seasonPackActivity.adViewFrameLayout = null;
            seasonPackActivity.mViewAnimator = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
