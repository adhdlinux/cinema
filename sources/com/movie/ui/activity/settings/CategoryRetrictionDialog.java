package com.movie.ui.activity.settings;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.database.entitys.CategoryEntity;
import com.google.android.material.tabs.TabLayout;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.disposables.CompositeDisposable;

public class CategoryRetrictionDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f32524b;
    @BindView(2131361949)
    Button btnDone;

    /* renamed from: c  reason: collision with root package name */
    private CompositeDisposable f32525c;
    @BindView(2131362742)
    TabLayout tabLayout;
    @BindView(2131362537)
    ViewPager viewPager;

    public static class ShowPageAdapter extends FragmentStatePagerAdapter {
        public ShowPageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment a(int i2) {
            if (i2 == 0) {
                return CategoryListFragment.P(CategoryEntity.Type.Movie);
            }
            if (i2 == 1) {
                return CategoryListFragment.P(CategoryEntity.Type.Show);
            }
            if (i2 != 2) {
                return null;
            }
            return CategoryListFragment.P(CategoryEntity.Type.MIX);
        }

        public int getCount() {
            return 3;
        }
    }

    public static CategoryRetrictionDialog F() {
        CategoryRetrictionDialog categoryRetrictionDialog = new CategoryRetrictionDialog();
        categoryRetrictionDialog.setArguments(new Bundle());
        return categoryRetrictionDialog;
    }

    /* access modifiers changed from: package-private */
    public void G() {
        this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void c(int i2) {
                CategoryRetrictionDialog.this.tabLayout.v(i2).i();
            }
        });
        this.viewPager.setAdapter(new ShowPageAdapter(getChildFragmentManager()));
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.c(tabLayout2.w().o("Movies"));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.c(tabLayout3.w().o("Shows"));
        TabLayout tabLayout4 = this.tabLayout;
        tabLayout4.c(tabLayout4.w().o("Lists"));
        this.tabLayout.b(new TabLayout.BaseOnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
                CategoryRetrictionDialog.this.viewPager.setCurrentItem(tab.e());
            }

            public void b(TabLayout.Tab tab) {
            }

            public void c(TabLayout.Tab tab) {
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getDialog().getWindow().getAttributes().windowAnimations = 2131951627;
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (Utils.X(getActivity()) == 1) {
            getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.7d));
        } else {
            int i2 = getResources().getDisplayMetrics().heightPixels;
            getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.7d), i2);
        }
        setHasOptionsMenu(true);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361949})
    public void onBtnDoneClick() {
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.category_retriction, viewGroup, false);
        this.f32524b = ButterKnife.bind((Object) this, inflate);
        this.f32525c = new CompositeDisposable();
        return inflate;
    }

    public void onDestroy() {
        this.f32524b.unbind();
        this.f32525c.dispose();
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        G();
    }
}
