package com.movie.ui.activity;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class CalendarActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private CalendarActivity f32022b;

    public CalendarActivity_ViewBinding(CalendarActivity calendarActivity, View view) {
        super(calendarActivity, view);
        this.f32022b = calendarActivity;
        calendarActivity.ad_view = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.adView, "field 'ad_view'", FrameLayout.class);
        calendarActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.calendar_recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        calendarActivity.view_empty = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_empty, "field 'view_empty'", AnimatorStateView.class);
    }

    public void unbind() {
        CalendarActivity calendarActivity = this.f32022b;
        if (calendarActivity != null) {
            this.f32022b = null;
            calendarActivity.ad_view = null;
            calendarActivity.mRecyclerView = null;
            calendarActivity.view_empty = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
