package com.movie.ui.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.movie.ui.widget.AnimatorStateView;
import com.movie.ui.widget.BetterViewAnimator;
import com.movie.ui.widget.MultiSwipeRefreshLayout;
import com.yoku.marumovie.R;

public class MoviesFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MoviesFragment f33312a;

    public MoviesFragment_ViewBinding(MoviesFragment moviesFragment, View view) {
        this.f33312a = moviesFragment;
        moviesFragment.mSwipeRefreshLayout = (MultiSwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.multi_swipe_refresh_layout, "field 'mSwipeRefreshLayout'", MultiSwipeRefreshLayout.class);
        moviesFragment.mViewAnimator = (BetterViewAnimator) Utils.findRequiredViewAsType(view, R.id.movies_animator, "field 'mViewAnimator'", BetterViewAnimator.class);
        moviesFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.movies_recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        moviesFragment.mViewError = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_error, "field 'mViewError'", AnimatorStateView.class);
    }

    public void unbind() {
        MoviesFragment moviesFragment = this.f33312a;
        if (moviesFragment != null) {
            this.f33312a = null;
            moviesFragment.mSwipeRefreshLayout = null;
            moviesFragment.mViewAnimator = null;
            moviesFragment.mRecyclerView = null;
            moviesFragment.mViewError = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
