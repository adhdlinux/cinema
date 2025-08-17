package com.movie.ui.fragment;

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
import com.google.android.material.tabs.TabLayout;
import com.movie.AppComponent;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.model.TorrentObject;
import com.movie.ui.fragment.premium.TorrentAdapterListFragment;
import com.yoku.marumovie.R;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public class TorrentManagerFragment extends BaseFragment {
    @Inject

    /* renamed from: d  reason: collision with root package name */
    RealDebridApi f33313d;

    /* renamed from: e  reason: collision with root package name */
    CompositeDisposable f33314e;
    @BindView(2131362752)
    TabLayout tabLayout;
    @BindView(2131362919)
    ViewPager viewPager;

    public static class TorrentPagerAdapter extends FragmentStatePagerAdapter {

        /* renamed from: j  reason: collision with root package name */
        TorrentAdapterListFragment f33317j;

        /* renamed from: k  reason: collision with root package name */
        TorrentAdapterListFragment f33318k;

        /* renamed from: l  reason: collision with root package name */
        TorrentAdapterListFragment f33319l;

        public TorrentPagerAdapter(FragmentManager fragmentManager, CompositeDisposable compositeDisposable) {
            super(fragmentManager);
        }

        public Fragment a(int i2) {
            return b(i2);
        }

        public Fragment b(int i2) {
            if (i2 == 0) {
                if (this.f33317j == null) {
                    this.f33317j = TorrentAdapterListFragment.A0(TorrentObject.Type.RD);
                }
                return this.f33317j;
            } else if (i2 != 1) {
                if (this.f33319l == null) {
                    this.f33319l = TorrentAdapterListFragment.A0(TorrentObject.Type.PM);
                }
                return this.f33319l;
            } else {
                if (this.f33318k == null) {
                    this.f33318k = TorrentAdapterListFragment.A0(TorrentObject.Type.AD);
                }
                return this.f33318k;
            }
        }

        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int i2) {
            return "OBJECT " + (i2 + 1);
        }
    }

    public static TorrentManagerFragment H() {
        Bundle bundle = new Bundle();
        TorrentManagerFragment torrentManagerFragment = new TorrentManagerFragment();
        torrentManagerFragment.setArguments(bundle);
        return torrentManagerFragment;
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().g(this);
    }

    /* access modifiers changed from: package-private */
    public void I() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setVisibility(8);
        }
        toolbar.setTitle((CharSequence) "Torrent Manager");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.torrent_manager_fragment, viewGroup, false);
    }

    public void onDestroy() {
        this.f33314e.dispose();
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f33314e = new CompositeDisposable();
        I();
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.c(tabLayout2.w().o("REAL DEBRID"));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.c(tabLayout3.w().o("All DEBRID"));
        TabLayout tabLayout4 = this.tabLayout;
        tabLayout4.c(tabLayout4.w().o("PREMIUMZIE"));
        this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void c(int i2) {
                TorrentManagerFragment.this.tabLayout.v(i2).i();
            }
        });
        this.tabLayout.b(new TabLayout.BaseOnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
                TorrentManagerFragment.this.viewPager.setCurrentItem(tab.e());
            }

            public void b(TabLayout.Tab tab) {
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        this.viewPager.setAdapter(new TorrentPagerAdapter(getChildFragmentManager(), this.f33314e));
    }
}
