package com.movie.ui.activity.shows;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.internal.Utils;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.movie.ui.activity.BaseActivity_ViewBinding;
import com.yoku.marumovie.R;

public class ShowActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private ShowActivity f32684b;

    public ShowActivity_ViewBinding(ShowActivity showActivity, View view) {
        super(showActivity, view);
        this.f32684b = showActivity;
        showActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        showActivity.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tabLayout'", TabLayout.class);
        showActivity.collapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.collapsing_toolbar, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
        showActivity.imageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.toolbar_image, "field 'imageView'", ImageView.class);
        showActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpage, "field 'viewPager'", ViewPager.class);
        showActivity.root_view = (CoordinatorLayout) Utils.findRequiredViewAsType(view, R.id.root_view, "field 'root_view'", CoordinatorLayout.class);
    }

    public void unbind() {
        ShowActivity showActivity = this.f32684b;
        if (showActivity != null) {
            this.f32684b = null;
            showActivity.toolbar = null;
            showActivity.tabLayout = null;
            showActivity.collapsingToolbarLayout = null;
            showActivity.imageView = null;
            showActivity.viewPager = null;
            showActivity.root_view = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
