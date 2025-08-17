package com.movie.ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public final class MovieFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MovieFragment f33289a;

    /* renamed from: b  reason: collision with root package name */
    private View f33290b;

    public MovieFragment_ViewBinding(final MovieFragment movieFragment, View view) {
        this.f33289a = movieFragment;
        Class cls = Button.class;
        movieFragment.mTrailerBtn = (Button) Utils.findRequiredViewAsType(view, R.id.trailer_button, "field 'mTrailerBtn'", cls);
        movieFragment.mViewAds = (Button) Utils.findRequiredViewAsType(view, R.id.get_more_view, "field 'mViewAds'", cls);
        movieFragment.mPosterImage = (ImageView) Utils.findOptionalViewAsType(view, R.id.movie_poster, "field 'mPosterImage'", ImageView.class);
        Class cls2 = TextView.class;
        movieFragment.mReleaseDate = (TextView) Utils.findRequiredViewAsType(view, R.id.movie_release_date, "field 'mReleaseDate'", cls2);
        movieFragment.mRating = (TextView) Utils.findRequiredViewAsType(view, R.id.movie_average_rating, "field 'mRating'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.movie_overview, "field 'mOverview' and method 'onOverviewClick'");
        movieFragment.mOverview = (TextView) Utils.castView(findRequiredView, R.id.movie_overview, "field 'mOverview'", cls2);
        this.f33290b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                movieFragment.onOverviewClick();
            }
        });
        movieFragment.movie_videos_header = (TextView) Utils.findRequiredViewAsType(view, R.id.movie_videos_header, "field 'movie_videos_header'", cls2);
        movieFragment.mNativeAdHolder = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_adplaceholder2, "field 'mNativeAdHolder'", FrameLayout.class);
        movieFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pbSource, "field 'progressBar'", ProgressBar.class);
        movieFragment.addWatchedListbtn = (Button) Utils.findRequiredViewAsType(view, R.id.add_watched_list, "field 'addWatchedListbtn'", cls);
        movieFragment.lvSources = (ListView) Utils.findRequiredViewAsType(view, R.id.lvSources, "field 'lvSources'", ListView.class);
        Context context = view.getContext();
        movieFragment.mColorThemePrimary = ContextCompat.getColor(context, R.color.theme_primary);
        movieFragment.mColorTextWhite = ContextCompat.getColor(context, R.color.body_text_white);
    }

    public void unbind() {
        MovieFragment movieFragment = this.f33289a;
        if (movieFragment != null) {
            this.f33289a = null;
            movieFragment.mTrailerBtn = null;
            movieFragment.mViewAds = null;
            movieFragment.mPosterImage = null;
            movieFragment.mReleaseDate = null;
            movieFragment.mRating = null;
            movieFragment.mOverview = null;
            movieFragment.movie_videos_header = null;
            movieFragment.mNativeAdHolder = null;
            movieFragment.progressBar = null;
            movieFragment.addWatchedListbtn = null;
            movieFragment.lvSources = null;
            this.f33290b.setOnClickListener((View.OnClickListener) null);
            this.f33290b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
