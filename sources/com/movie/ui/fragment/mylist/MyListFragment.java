package com.movie.ui.fragment.mylist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.database.MvDatabase;
import com.database.entitys.CategoryEntity;
import com.database.entitys.MovieEntity;
import com.database.entitys.UserListEntity;
import com.google.android.material.tabs.TabLayout;
import com.movie.AppComponent;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.activity.MovieDetailsActivity;
import com.movie.ui.activity.settings.SettingsActivity;
import com.movie.ui.activity.settings.subfragment.PremiumAccountFragment;
import com.movie.ui.activity.shows.ShowActivity;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.BrowseMoviesFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.MoviesFragment;
import com.movie.ui.fragment.mylist.UserListAdapter;
import com.movie.ui.widget.AnimatorStateView;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import timber.log.Timber;

public class MyListFragment extends BaseFragment implements MoviesFragment.Listener, UserListAdapter.Listener {
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MvDatabase f33379d;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    TraktRepositoryImpl f33380e;
    @BindView(2131362909)
    AnimatorStateView emptyView;

    /* renamed from: f  reason: collision with root package name */
    CompositeDisposable f33381f = new CompositeDisposable();

    /* renamed from: g  reason: collision with root package name */
    String f33382g = "added";

    /* renamed from: h  reason: collision with root package name */
    List<UserListEntity> f33383h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    Map<String, BrowseMoviesFragment> f33384i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    List<UserListEntity> f33385j = new ArrayList();
    @BindView(2131362752)
    TabLayout tabLayout;

    /* access modifiers changed from: private */
    public BrowseMoviesFragment a0(UserListEntity userListEntity, String str) {
        int i2;
        if (this.f33384i.containsKey(userListEntity.f19321c)) {
            return this.f33384i.get(userListEntity.f19321c);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("userName", userListEntity.f19322d);
        hashMap.put("sort_by", str);
        try {
            i2 = Integer.parseInt(userListEntity.f19321c);
        } catch (Exception unused) {
            hashMap.put("listSlug", userListEntity.f19321c);
            i2 = 0;
        }
        CategoryEntity categoryEntity = new CategoryEntity(CategoryEntity.Source.TRAKT, CategoryEntity.Type.MIX, Integer.valueOf(i2), CategoryEntity.SourceType.UserList, userListEntity.f19320b);
        categoryEntity.extras = hashMap;
        BrowseMoviesFragment e02 = BrowseMoviesFragment.e0(categoryEntity);
        this.f33384i.put(userListEntity.f19321c, e02);
        return e02;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(List list) throws Exception {
        this.tabLayout.z();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            UserListEntity userListEntity = (UserListEntity) it2.next();
            final TabLayout.Tab w2 = this.tabLayout.w();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, (ViewGroup) null);
            ((TextView) linearLayout.findViewById(R.id.listName)).setText(userListEntity.f19320b);
            ((TextView) linearLayout.findViewById(R.id.txtOwner)).setText(userListEntity.f19322d);
            w2.l(linearLayout);
            registerForContextMenu(linearLayout);
            linearLayout.setTag(userListEntity);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w2.i();
                }
            });
            linearLayout.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return false;
                }
            });
            this.tabLayout.c(w2);
        }
        this.f33383h = list;
        if (list.isEmpty()) {
            this.emptyView.setVisibility(0);
        } else {
            this.emptyView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(Throwable th) throws Exception {
        if (this.f33383h.isEmpty()) {
            this.emptyView.setVisibility(0);
            this.emptyView.setMessageText(th.getMessage());
            return;
        }
        this.emptyView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(UserListEntity userListEntity, ObservableEmitter observableEmitter) throws Exception {
        this.f33379d.F().e(userListEntity);
        observableEmitter.onComplete();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(Object obj) throws Exception {
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.v(tabLayout2.getTabCount() - 1).i();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(Throwable th) throws Exception {
        Toast.makeText(getContext(), th.getMessage(), 0).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(MenuItem menuItem, ObservableEmitter observableEmitter) throws Exception {
        UserListEntity userListEntity = this.f33379d.F().get(Integer.valueOf(menuItem.getItemId()).toString());
        if (userListEntity == null) {
            observableEmitter.onComplete();
            return;
        }
        this.f33380e.f(userListEntity.f19322d, userListEntity.f19321c);
        this.f33379d.F().b(String.valueOf(menuItem.getItemId()));
        observableEmitter.onComplete();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h0(Object obj) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Throwable th) throws Exception {
        Toast.makeText(getContext(), th.getMessage(), 0).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(MenuItem menuItem, DialogInterface dialogInterface, int i2) {
        this.f33381f.b(Observable.create(new q(this, menuItem)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new r(), new b(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(List list) throws Exception {
        w0(getActivity(), list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m0(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(List list) throws Exception {
        this.f33379d.F().f((UserListEntity[]) list.toArray(new UserListEntity[0]));
        Timber.b("List: %s", list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void p0(Void voidR) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void q0(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(final SelecetUserListAdapter selecetUserListAdapter, final Context context, DialogInterface dialogInterface, int i2) {
        this.f33381f.b(Observable.create(new ObservableOnSubscribe<Void>() {
            public void subscribe(ObservableEmitter<Void> observableEmitter) throws Exception {
                List<UserListEntity> d2 = selecetUserListAdapter.d();
                MyListFragment.this.f33379d.F().a();
                MyListFragment.this.f33379d.F().f((UserListEntity[]) d2.toArray(new UserListEntity[0]));
                Toast.makeText(context, "Changes saved", 0).show();
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new h(), new i()));
        dialogInterface.dismiss();
    }

    private void t0() {
        this.f33381f.b(this.f33379d.F().g().p(Schedulers.c()).f(AndroidSchedulers.a()).l(new o(this), new p(this)));
    }

    public static void v0(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.g(str2);
        builder.l("Confirm", onClickListener);
        builder.i("Cancel", onClickListener2);
        builder.create().show();
    }

    public void D(UserListEntity userListEntity) {
        for (UserListEntity userListEntity2 : this.f33385j) {
            if (userListEntity2.f19321c.equals(userListEntity.f19321c)) {
                Toast.makeText(getContext(), "List already exists", 0).show();
                return;
            }
        }
        this.f33381f.b(Observable.create(new e(this, userListEntity)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new f(this), new g(this)));
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().d(this);
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

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (!menuItem.getTitle().equals("Delete")) {
            return true;
        }
        v0(getContext(), "Delete", "If this list is yours, they will also be deleted from local and Trakt.\nAre you sure you want to delete this list?", new a(this, menuItem), new j());
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        try {
            contextMenu.add(0, Integer.parseInt(((UserListEntity) view.getTag()).f19321c), 0, "Delete");
        } catch (Exception e2) {
            Toast.makeText(getContext(), e2.getMessage(), 0).show();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.menu_mylist, menu);
        MenuItem findItem = menu.findItem(R.id.flow_user);
        MenuItem findItem2 = menu.findItem(R.id.setting);
        boolean isValid = TraktCredentialsHelper.b().isValid();
        findItem.setVisible(isValid);
        findItem2.setVisible(!isValid);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_mylist, viewGroup, false);
    }

    public void onDestroy() {
        this.f33381f.dispose();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.flow_user:
                UserListSelectionDialog N = UserListSelectionDialog.N(this);
                N.show(getActivity().getSupportFragmentManager(), N.getTag());
                break;
            case R.id.setting:
                Intent intent = new Intent(getContext(), SettingsActivity.class);
                intent.putExtra("goto", PremiumAccountFragment.class.getName());
                startActivity(intent);
                break;
            case R.id.show_lists:
                this.f33381f.b(Observable.create(new ObservableOnSubscribe<List<UserListEntity>>() {
                    public void subscribe(ObservableEmitter<List<UserListEntity>> observableEmitter) throws Exception {
                        observableEmitter.onNext(MyListFragment.this.f33379d.F().h());
                        observableEmitter.onComplete();
                    }
                }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new m(this), new n()));
                break;
            case R.id.sort_by_added:
                this.f33382g = "added";
                TabLayout tabLayout2 = this.tabLayout;
                View c2 = tabLayout2.v(tabLayout2.getSelectedTabPosition()).c();
                Objects.requireNonNull(c2);
                UserListEntity userListEntity = (UserListEntity) c2.getTag();
                this.f33384i.remove(userListEntity.f19321c);
                getChildFragmentManager().n().p(R.id.container, a0(userListEntity, this.f33382g)).h();
                break;
            case R.id.sort_by_rank:
                this.f33382g = "rank";
                TabLayout tabLayout3 = this.tabLayout;
                View c3 = tabLayout3.v(tabLayout3.getSelectedTabPosition()).c();
                Objects.requireNonNull(c3);
                UserListEntity userListEntity2 = (UserListEntity) c3.getTag();
                this.f33384i.remove(userListEntity2.f19321c);
                getChildFragmentManager().n().p(R.id.container, a0(userListEntity2, this.f33382g)).h();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        super.onResume();
        this.f33381f.b(this.f33380e.n("me").subscribeOn(Schedulers.c()).observeOn(Schedulers.c()).subscribe(new k(this), new l()));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        u0();
        this.tabLayout.b(new TabLayout.BaseOnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
                View c2 = tab.c();
                Objects.requireNonNull(c2);
                FragmentTransaction n2 = MyListFragment.this.getChildFragmentManager().n();
                MyListFragment myListFragment = MyListFragment.this;
                n2.p(R.id.container, myListFragment.a0((UserListEntity) c2.getTag(), myListFragment.f33382g)).h();
            }

            public void b(TabLayout.Tab tab) {
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        t0();
    }

    /* access modifiers changed from: package-private */
    public void u0() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setVisibility(8);
        }
        toolbar.setTitle((CharSequence) "My Lists");
    }

    public void w0(Context context, List<UserListEntity> list) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.userlist_dialog, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        SelecetUserListAdapter selecetUserListAdapter = new SelecetUserListAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(selecetUserListAdapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(inflate).setTitle("Trakt List").l("OK", new c(this, selecetUserListAdapter, context)).i("Cancel", new d());
        builder.create().show();
    }
}
