package com.movie.ui.fragment.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.database.entitys.MovieEntity;
import com.google.android.material.tabs.TabLayout;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.ui.activity.MovieDetailsActivity;
import com.movie.ui.activity.shows.ShowActivity;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.MoviesFragment;
import com.original.tase.RxBus;
import com.original.tase.event.trakt.TraktSyncSuccess;
import com.yoku.marumovie.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class HistoryPageFragment extends BaseFragment implements MoviesFragment.Listener {

    /* renamed from: d  reason: collision with root package name */
    CompositeDisposable f33356d;
    @BindView(2131362752)
    TabLayout tabLayout;
    @BindView(2131362919)
    ViewPager viewPager;

    public static class ShowPagerAdapter extends FragmentStatePagerAdapter {

        /* renamed from: j  reason: collision with root package name */
        HistoryFragment f33360j;

        /* renamed from: k  reason: collision with root package name */
        HistoryFragment f33361k;

        /* renamed from: l  reason: collision with root package name */
        HistoryFragment f33362l;

        /* renamed from: m  reason: collision with root package name */
        CompositeDisposable f33363m = this.f33363m;

        public ShowPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment a(int i2) {
            return b(i2);
        }

        public Fragment b(int i2) {
            if (i2 == 0) {
                if (this.f33360j == null) {
                    this.f33360j = HistoryFragment.a0(0);
                }
                return this.f33360j;
            } else if (i2 != 1) {
                if (this.f33362l == null) {
                    this.f33362l = HistoryFragment.a0(2);
                }
                return this.f33362l;
            } else {
                if (this.f33361k == null) {
                    this.f33361k = HistoryFragment.a0(1);
                }
                return this.f33361k;
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            if (i2 == 0) {
                HistoryFragment historyFragment = this.f33360j;
                if (historyFragment != null) {
                    historyFragment.c0();
                }
            } else if (i2 != 1) {
                HistoryFragment historyFragment2 = this.f33362l;
                if (historyFragment2 != null) {
                    historyFragment2.c0();
                }
            } else {
                HistoryFragment historyFragment3 = this.f33361k;
                if (historyFragment3 != null) {
                    historyFragment3.c0();
                }
            }
        }

        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int i2) {
            return "OBJECT " + (i2 + 1);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void I(Throwable th) throws Exception {
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().k(this);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setVisibility(8);
        }
        String string = FreeMoviesApp.p().getString("pref_limit_history_size", "Unlimited");
        if (string.equals("Unlimited")) {
            toolbar.setTitle((CharSequence) "History");
            return;
        }
        toolbar.setTitle((CharSequence) "History (Showing " + string + " items)");
    }

    public void m(MovieEntity movieEntity, View view) {
        if (movieEntity.getTV().booleanValue()) {
            Intent intent = new Intent(getActivity(), ShowActivity.class);
            intent.putExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE", movieEntity);
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(getActivity(), MovieDetailsActivity.class);
        intent2.putExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE", movieEntity);
        startActivity(intent2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_history_page, viewGroup, false);
    }

    public void onDestroy() {
        this.f33356d.dispose();
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        J();
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.c(tabLayout2.w().o("Tv/Shows"));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.c(tabLayout3.w().o("Movies"));
        TabLayout tabLayout4 = this.tabLayout;
        tabLayout4.c(tabLayout4.w().o("All"));
        this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void c(int i2) {
                HistoryPageFragment.this.tabLayout.v(i2).i();
            }
        });
        this.tabLayout.b(new TabLayout.BaseOnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
                HistoryPageFragment.this.viewPager.setCurrentItem(tab.e());
                ((ShowPagerAdapter) HistoryPageFragment.this.viewPager.getAdapter()).c(tab.e());
                FreeMoviesApp.p().edit().putInt("is_last_tv_seen", tab.e()).apply();
            }

            public void b(TabLayout.Tab tab) {
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        this.viewPager.setAdapter(new ShowPagerAdapter(getChildFragmentManager()));
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f33356d = compositeDisposable;
        compositeDisposable.b(RxBus.a().c().subscribe(new Consumer<Object>() {
            public void accept(Object obj) throws Exception {
                if (obj instanceof TraktSyncSuccess) {
                    ((ShowPagerAdapter) HistoryPageFragment.this.viewPager.getAdapter()).c(HistoryPageFragment.this.viewPager.getCurrentItem());
                }
            }
        }, new e()));
        this.tabLayout.v(FreeMoviesApp.p().getInt("is_last_tv_seen", 0)).i();
    }
}
