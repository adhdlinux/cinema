package com.movie.ui.activity.settings;

import android.view.View;
import android.widget.Button;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.yoku.marumovie.R;

public class CategoryRetrictionDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CategoryRetrictionDialog f32528a;

    /* renamed from: b  reason: collision with root package name */
    private View f32529b;

    public CategoryRetrictionDialog_ViewBinding(final CategoryRetrictionDialog categoryRetrictionDialog, View view) {
        this.f32528a = categoryRetrictionDialog;
        categoryRetrictionDialog.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tabLayout, "field 'tabLayout'", TabLayout.class);
        categoryRetrictionDialog.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pageView, "field 'viewPager'", ViewPager.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnDone, "field 'btnDone' and method 'onBtnDoneClick'");
        categoryRetrictionDialog.btnDone = (Button) Utils.castView(findRequiredView, R.id.btnDone, "field 'btnDone'", Button.class);
        this.f32529b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                categoryRetrictionDialog.onBtnDoneClick();
            }
        });
    }

    public void unbind() {
        CategoryRetrictionDialog categoryRetrictionDialog = this.f32528a;
        if (categoryRetrictionDialog != null) {
            this.f32528a = null;
            categoryRetrictionDialog.tabLayout = null;
            categoryRetrictionDialog.viewPager = null;
            categoryRetrictionDialog.btnDone = null;
            this.f32529b.setOnClickListener((View.OnClickListener) null);
            this.f32529b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
