package com.movie.ui.widget;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.Unbinder;

public final class RatingView extends ConstraintLayout {
    @BindView(2131362271)
    ImageView imgIcon;
    @BindView(2131362857)
    TextView tvMaxRating;
    @BindView(2131362058)
    TextView tvRating;
    @BindView(2131362871)
    TextView tvVotes;

    /* renamed from: v  reason: collision with root package name */
    private Unbinder f33654v;

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f33654v.unbind();
        super.onDetachedFromWindow();
    }
}
