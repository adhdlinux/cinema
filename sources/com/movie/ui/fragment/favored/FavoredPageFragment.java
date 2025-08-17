package com.movie.ui.fragment.favored;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
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
import com.yoku.marumovie.R;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FavoredPageFragment extends BaseFragment implements MoviesFragment.Listener {

    /* renamed from: d  reason: collision with root package name */
    Map<String, FavoredMoviesFragment> f33339d = new HashMap();
    @BindView(2131362752)
    TabLayout tabLayout;

    /* access modifiers changed from: private */
    public FavoredMoviesFragment I(String str) {
        FreeMoviesApp.p().edit().putString("pref_latest_favored_category", str).apply();
        if (this.f33339d.containsKey(str)) {
            return this.f33339d.get(str);
        }
        str.hashCode();
        if (str.equals("Movies")) {
            FavoredMoviesFragment Z = FavoredMoviesFragment.Z(1);
            this.f33339d.put(str, Z);
            return Z;
        } else if (!str.equals("Tv/Shows")) {
            FavoredMoviesFragment Z2 = FavoredMoviesFragment.Z(0);
            this.f33339d.put(str, Z2);
            return Z2;
        } else {
            FavoredMoviesFragment Z3 = FavoredMoviesFragment.Z(2);
            this.f33339d.put(str, Z3);
            return Z3;
        }
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().f(this);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setVisibility(8);
        }
        toolbar.setTitle((CharSequence) "Favorites");
        toolbar.setNextFocusDownId(R.id.tablayout);
        this.tabLayout.setNextFocusUpId(R.id.toolbar);
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
        return layoutInflater.inflate(R.layout.fragment_favored_page, viewGroup, false);
    }

    public void onDestroy() {
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
        this.tabLayout.b(new TabLayout.BaseOnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
                FavoredPageFragment.this.getChildFragmentManager().n().p(R.id.container, FavoredPageFragment.this.I(tab.f().toString())).h();
            }

            public void b(TabLayout.Tab tab) {
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        String string = FreeMoviesApp.p().getString("pref_latest_favored_category", "All");
        if (string.equals("All")) {
            TabLayout.Tab v2 = this.tabLayout.v(2);
            Objects.requireNonNull(v2);
            v2.i();
        }
        if (string.equals("Tv/Shows")) {
            TabLayout.Tab v3 = this.tabLayout.v(0);
            Objects.requireNonNull(v3);
            v3.i();
        }
        if (string.equals("Movies")) {
            TabLayout.Tab v4 = this.tabLayout.v(1);
            Objects.requireNonNull(v4);
            v4.i();
        }
        getChildFragmentManager().n().p(R.id.container, I(string)).h();
    }
}
