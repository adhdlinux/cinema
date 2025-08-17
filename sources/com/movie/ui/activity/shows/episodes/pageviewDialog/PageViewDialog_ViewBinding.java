package com.movie.ui.activity.shows.episodes.pageviewDialog;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.movie.ui.widget.SlidingTabLayout;
import com.yoku.marumovie.R;

public class PageViewDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PageViewDialog f32756a;

    /* renamed from: b  reason: collision with root package name */
    private View f32757b;

    public PageViewDialog_ViewBinding(final PageViewDialog pageViewDialog, View view) {
        this.f32756a = pageViewDialog;
        pageViewDialog.tabLayout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tabLayout'", SlidingTabLayout.class);
        pageViewDialog.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpage, "field 'viewPager'", ViewPager.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ImgBtnrevertIndex, "field 'imgBtnrevertIndex' and method 'OnImgBtnrevertIndexClick'");
        pageViewDialog.imgBtnrevertIndex = (ImageButton) Utils.castView(findRequiredView, R.id.ImgBtnrevertIndex, "field 'imgBtnrevertIndex'", ImageButton.class);
        this.f32757b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                pageViewDialog.OnImgBtnrevertIndexClick();
            }
        });
        pageViewDialog.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
    }

    public void unbind() {
        PageViewDialog pageViewDialog = this.f32756a;
        if (pageViewDialog != null) {
            this.f32756a = null;
            pageViewDialog.tabLayout = null;
            pageViewDialog.viewPager = null;
            pageViewDialog.imgBtnrevertIndex = null;
            pageViewDialog.loading = null;
            this.f32757b.setOnClickListener((View.OnClickListener) null);
            this.f32757b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
