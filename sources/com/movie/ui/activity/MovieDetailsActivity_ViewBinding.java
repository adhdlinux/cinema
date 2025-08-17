package com.movie.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.yoku.marumovie.R;

public final class MovieDetailsActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private MovieDetailsActivity f32142b;

    public MovieDetailsActivity_ViewBinding(MovieDetailsActivity movieDetailsActivity, View view) {
        super(movieDetailsActivity, view);
        this.f32142b = movieDetailsActivity;
        movieDetailsActivity.toolbar_image = (ImageView) Utils.findRequiredViewAsType(view, R.id.toolbar_image, "field 'toolbar_image'", ImageView.class);
        movieDetailsActivity.tv_genres_duration = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_genres_duration, "field 'tv_genres_duration'", TextView.class);
        movieDetailsActivity.collapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.collapsing_toolbar, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
        movieDetailsActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.appbar, "field 'appBarLayout'", AppBarLayout.class);
    }

    public void unbind() {
        MovieDetailsActivity movieDetailsActivity = this.f32142b;
        if (movieDetailsActivity != null) {
            this.f32142b = null;
            movieDetailsActivity.toolbar_image = null;
            movieDetailsActivity.tv_genres_duration = null;
            movieDetailsActivity.collapsingToolbarLayout = null;
            movieDetailsActivity.appBarLayout = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
