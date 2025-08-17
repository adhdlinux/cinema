package com.movie.ui.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public final class RatingView_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RatingView f33655a;

    public RatingView_ViewBinding(RatingView ratingView, View view) {
        this.f33655a = ratingView;
        ratingView.imgIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.imgIcon, "field 'imgIcon'", ImageView.class);
        Class cls = TextView.class;
        ratingView.tvRating = (TextView) Utils.findRequiredViewAsType(view, R.id.ctRating, "field 'tvRating'", cls);
        ratingView.tvVotes = (TextView) Utils.findRequiredViewAsType(view, R.id.tvVotes, "field 'tvVotes'", cls);
        ratingView.tvMaxRating = (TextView) Utils.findRequiredViewAsType(view, R.id.tvMaxRating, "field 'tvMaxRating'", cls);
    }

    public void unbind() {
        RatingView ratingView = this.f33655a;
        if (ratingView != null) {
            this.f33655a = null;
            ratingView.imgIcon = null;
            ratingView.tvRating = null;
            ratingView.tvVotes = null;
            ratingView.tvMaxRating = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
