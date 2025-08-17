package com.movie.ui.activity.sources;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.internal.Utils;
import com.movie.ui.activity.BaseActivity_ViewBinding;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class SourceActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private SourceActivity f32891b;

    public SourceActivity_ViewBinding(SourceActivity sourceActivity, View view) {
        super(sourceActivity, view);
        this.f32891b = sourceActivity;
        sourceActivity.progressbar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pbSource, "field 'progressbar'", ProgressBar.class);
        sourceActivity.lvSources = (ListView) Utils.findRequiredViewAsType(view, R.id.lvSources, "field 'lvSources'", ListView.class);
        sourceActivity.adViewFrameLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.adView, "field 'adViewFrameLayout'", FrameLayout.class);
        sourceActivity.mViewAnimator = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_empty, "field 'mViewAnimator'", AnimatorStateView.class);
    }

    public void unbind() {
        SourceActivity sourceActivity = this.f32891b;
        if (sourceActivity != null) {
            this.f32891b = null;
            sourceActivity.progressbar = null;
            sourceActivity.lvSources = null;
            sourceActivity.adViewFrameLayout = null;
            sourceActivity.mViewAnimator = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
