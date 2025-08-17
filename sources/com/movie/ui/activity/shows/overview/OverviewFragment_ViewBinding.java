package com.movie.ui.activity.shows.overview;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class OverviewFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private OverviewFragment f32771a;

    public OverviewFragment_ViewBinding(OverviewFragment overviewFragment, View view) {
        this.f32771a = overviewFragment;
        Class cls = TextView.class;
        overviewFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvName, "field 'tvName'", cls);
        overviewFragment.tvtime = (TextView) Utils.findRequiredViewAsType(view, R.id.tvtime, "field 'tvtime'", cls);
        overviewFragment.tvOverview = (TextView) Utils.findRequiredViewAsType(view, R.id.tvOverview, "field 'tvOverview'", cls);
        overviewFragment.tvRating = (TextView) Utils.findRequiredViewAsType(view, R.id.ctRating, "field 'tvRating'", cls);
        overviewFragment.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        overviewFragment.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
        overviewFragment.adView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.adView, "field 'adView'", FrameLayout.class);
    }

    public void unbind() {
        OverviewFragment overviewFragment = this.f32771a;
        if (overviewFragment != null) {
            this.f32771a = null;
            overviewFragment.tvName = null;
            overviewFragment.tvtime = null;
            overviewFragment.tvOverview = null;
            overviewFragment.tvRating = null;
            overviewFragment.content = null;
            overviewFragment.loading = null;
            overviewFragment.adView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
