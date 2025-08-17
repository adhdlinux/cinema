package us.shandian.giga.ui.fragment;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.movie.AppComponent;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.yoku.marumovie.R;
import javax.inject.Inject;
import javax.inject.Named;
import us.shandian.giga.get.DownloadManager;
import us.shandian.giga.service.DownloadManagerService;
import us.shandian.giga.ui.adapter.MissionAdapter;

public abstract class MissionsFragment extends BaseFragment {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f42278d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public DownloadManagerService.DMBinder f42279e;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f42280f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f42281g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f42282h;

    /* renamed from: i  reason: collision with root package name */
    private MissionAdapter f42283i;

    /* renamed from: j  reason: collision with root package name */
    private GridLayoutManager f42284j;

    /* renamed from: k  reason: collision with root package name */
    private LinearLayoutManager f42285k;

    /* renamed from: l  reason: collision with root package name */
    private Activity f42286l;

    /* renamed from: m  reason: collision with root package name */
    private ServiceConnection f42287m = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DownloadManagerService.DMBinder unused = MissionsFragment.this.f42279e = (DownloadManagerService.DMBinder) iBinder;
            MissionsFragment missionsFragment = MissionsFragment.this;
            DownloadManager unused2 = missionsFragment.f42278d = missionsFragment.L(missionsFragment.f42279e);
            MissionsFragment.this.M();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    @Inject

    /* renamed from: n  reason: collision with root package name */
    MoviesHelper f42288n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    TMDBRepositoryImpl f42289o;
    @Inject
    @Named("MainActivity")

    /* renamed from: p  reason: collision with root package name */
    PlayerHelper f42290p;

    /* access modifiers changed from: private */
    public void M() {
        this.f42283i = new MissionAdapter(this.f42286l, this.f42279e, this.f42278d, this.f42281g, this.f42288n, this.f42290p);
        if (this.f42281g) {
            this.f42282h.setLayoutManager(this.f42285k);
        } else {
            this.f42282h.setLayoutManager(this.f42284j);
        }
        this.f42282h.setAdapter(this.f42283i);
        this.f42280f.edit().putBoolean("linear", this.f42281g).commit();
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().e(this);
    }

    /* access modifiers changed from: protected */
    public abstract DownloadManager L(DownloadManagerService.DMBinder dMBinder);

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f42286l = activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.missions, viewGroup, false);
        this.f42280f = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f42281g = true;
        Intent intent = new Intent();
        intent.setClass(getActivity(), DownloadManagerService.class);
        getActivity().bindService(intent, this.f42287m, 1);
        this.f42282h = (RecyclerView) inflate.findViewById(R.id.mission_recycler);
        this.f42284j = new GridLayoutManager(getActivity(), 2);
        this.f42285k = new LinearLayoutManager(getActivity());
        this.f42282h.setLayoutManager(this.f42284j);
        setHasOptionsMenu(true);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unbindService(this.f42287m);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
