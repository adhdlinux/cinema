package com.movie.ui.activity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.ads.videoreward.AdsBase;
import com.ads.videoreward.AdsManager;
import com.ads.videoreward.MyVungleAds;
import com.database.MvDatabase;
import com.database.entitys.CategoryEntity;
import com.database.entitys.CrawlCount;
import com.database.entitys.MovieEntity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.AppConfig;
import com.movie.data.model.cinema.CrawlBody;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.activity.settings.SettingsActivity;
import com.movie.ui.activity.shows.ShowActivity;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.BrowseMoviesFragment;
import com.movie.ui.fragment.MoviesFragment;
import com.movie.ui.fragment.TorrentManagerFragment;
import com.movie.ui.fragment.favored.FavoredPageFragment;
import com.movie.ui.fragment.history.HistoryPageFragment;
import com.movie.ui.fragment.mylist.MyListFragment;
import com.original.Constants;
import com.original.tase.api.TraktUserApi;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.original.tase.model.socket.UserPlayerPluginInfo;
import com.original.tase.socket.Client;
import com.original.tase.utils.DeviceUtils;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.ImdbSearchSuggestionModel;
import com.utils.NavIds;
import com.utils.PermissionHelper;
import com.utils.PrefUtils;
import com.utils.Utils;
import com.utils.download.DownloadActivity;
import com.yarolegovich.lovelydialog.LovelyCustomDialog;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements MoviesFragment.Listener, NavigationView.OnNavigationItemSelectedListener, SearchView.OnSuggestionListener {

    /* renamed from: b  reason: collision with root package name */
    protected CompositeDisposable f32032b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public SearchView f32033c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public NavigationView f32034d = null;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    TMDBRepositoryImpl f32035e;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    TraktRepositoryImpl f32036f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    volatile MvDatabase f32037g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    MoviesApi f32038h;
    @Inject
    @Named("MainActivity")

    /* renamed from: i  reason: collision with root package name */
    PlayerHelper f32039i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public CategoryEntity f32040j;

    /* renamed from: k  reason: collision with root package name */
    private int f32041k;

    /* renamed from: l  reason: collision with root package name */
    LovelyCustomDialog f32042l = null;

    /* renamed from: m  reason: collision with root package name */
    List<ImdbSearchSuggestionModel.DBean> f32043m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    CursorAdapter f32044n = null;

    public class CustomArrayAdapter extends ArrayAdapter<CategoryEntity> {

        /* renamed from: b  reason: collision with root package name */
        private final LayoutInflater f32077b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f32078c;

        /* renamed from: d  reason: collision with root package name */
        private final List<CategoryEntity> f32079d;

        /* renamed from: e  reason: collision with root package name */
        private final int f32080e;

        public CustomArrayAdapter(Context context, int i2, List<CategoryEntity> list) {
            super(context, i2, 0);
            this.f32078c = context;
            this.f32077b = LayoutInflater.from(context);
            this.f32080e = i2;
            this.f32079d = list;
        }

        private View a(int i2, View view, ViewGroup viewGroup) {
            View inflate = this.f32077b.inflate(this.f32080e, viewGroup, false);
            inflate.setTag(getItem(i2));
            ((TextView) inflate.findViewById(16908308)).setText(this.f32079d.get(i2).getName());
            return inflate;
        }

        /* renamed from: b */
        public CategoryEntity getItem(int i2) {
            return this.f32079d.get(i2);
        }

        public int getCount() {
            return this.f32079d.size();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            return a(i2, view, viewGroup);
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            return a(i2, view, viewGroup);
        }
    }

    public static class Sort implements Parcelable {
        public static final Parcelable.Creator<Sort> CREATOR = new Parcelable.Creator<Sort>() {
            /* renamed from: a */
            public Sort createFromParcel(Parcel parcel) {
                return new Sort(parcel);
            }

            /* renamed from: b */
            public Sort[] newArray(int i2) {
                return new Sort[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public String f32082b;

        /* renamed from: c  reason: collision with root package name */
        public String f32083c;

        protected Sort(Parcel parcel) {
            this.f32082b = parcel.readString();
            this.f32083c = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f32082b);
            parcel.writeString(this.f32083c);
        }
    }

    private boolean O() {
        AppConfig.UpdateBean update = GlobalVariable.c().b().getUpdate();
        if (update == null || update.getVersionCode() <= Utils.b0() || update.getPackagename().isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(update.getPackagename());
        if (!Utils.l0(arrayList)) {
            return false;
        }
        try {
            ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.HORIZONTAL).m(R.color.indigo)).r(R.color.darkDeepOrange).i(getPackageManager().getApplicationIcon(update.getPackagename()))).k("OUT OF UPDATE")).j("You already have The New Version, please uninstall this version")).u(17039370, new View.OnClickListener() {
                public void onClick(View view) {
                    MainActivity.this.startActivity(new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + Utils.getPackageName())));
                    MainActivity.this.finishAffinity();
                }
            }).o();
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private Observable<List<CategoryEntity>> R(CategoryEntity.Source source, CategoryEntity.Type type) {
        if (source == CategoryEntity.Source.TMDB) {
            return this.f32035e.F(type).subscribeOn(Schedulers.c());
        }
        return this.f32036f.g(type).subscribeOn(Schedulers.c());
    }

    private Observable<List<CategoryEntity>> S() {
        return Observable.create(new ObservableOnSubscribe<List<CategoryEntity>>() {
            public void subscribe(ObservableEmitter<List<CategoryEntity>> observableEmitter) throws Exception {
                observableEmitter.onNext(MainActivity.this.f32037g.w().c(MainActivity.this.f32040j.getSource().getValue(), MainActivity.this.f32040j.getType().getValue()));
            }
        }).subscribeOn(Schedulers.c());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void T(String str) throws Exception {
        if (!str.isEmpty()) {
            FreeMoviesApp.p().edit().putBoolean("use_player_plugin", true).apply();
            FreeMoviesApp.p().edit().putString("ip_player_plugin", str).apply();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void U(View view) {
        for (AdsBase adsBase : AdsManager.d().e()) {
            if (adsBase instanceof MyVungleAds) {
                AdsManager.d().r((FrameLayout) view.findViewById(R.id.ad_holder));
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void V(List list) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource X(List list) throws Exception {
        if (list.isEmpty()) {
            return R(this.f32040j.getSource(), this.f32040j.getType());
        }
        R(this.f32040j.getSource(), this.f32040j.getType()).subscribe();
        return Observable.just(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(Spinner spinner, List list) throws Exception {
        spinner.setAdapter(new CustomArrayAdapter(this.mToolbar.getContext(), 17367043, list));
        int i2 = 0;
        while (i2 < list.size()) {
            CategoryEntity categoryEntity = (CategoryEntity) list.get(i2);
            if (categoryEntity.getType() != this.f32040j.getType() || !categoryEntity.getId().equals(this.f32040j.getId())) {
                i2++;
            } else {
                spinner.setSelection(i2);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
        hideWaitingDialog();
    }

    @SuppressLint({"WrongConstant"})
    public static String a0(String str, String str2, int i2, boolean z2) {
        Matcher matcher;
        if (str != null && !str.isEmpty()) {
            if (z2) {
                matcher = Pattern.compile(str2, 32).matcher(str);
            } else {
                matcher = Pattern.compile(str2).matcher(str);
            }
            if (matcher.find()) {
                return matcher.group(i2);
            }
        }
        return "";
    }

    private boolean b0(int i2) {
        if (i2 == NavIds.NAV_TV_SHOW.b() || i2 == NavIds.NAV_MOVIE.b() || i2 == NavIds.NAV_LISTS.b()) {
            PrefUtils.q(this, i2);
            f0(i2);
        } else if (i2 == NavIds.NAV_FAVORITE.b()) {
            PrefUtils.q(this, i2);
            c0(new FavoredPageFragment());
        } else if (i2 == NavIds.NAV_MY_LIST.b()) {
            PrefUtils.q(this, i2);
            c0(new MyListFragment());
        } else if (i2 == NavIds.NAV_HISTORY.b()) {
            PrefUtils.q(this, i2);
            c0(new HistoryPageFragment());
        } else if (i2 == NavIds.NAV_DOWNLOAD.b()) {
            if (!PermissionHelper.a(this)) {
                ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.HORIZONTAL).m(R.color.darkDeepOrange)).r(R.color.darkDeepOrange).h(R.drawable.database_24px)).k("Warning")).j(getResources().getString(R.string.storage_permission_msg))).u(17039370, new View.OnClickListener() {
                    public void onClick(View view) {
                        PermissionHelper.b(MainActivity.this, 934839);
                    }
                }).s(R.string.quit, new View.OnClickListener() {
                    public void onClick(View view) {
                        MainActivity.this.finish();
                    }
                }).o();
                return false;
            }
            startActivity(new Intent(this, DownloadActivity.class));
        } else if (i2 == NavIds.NAV_SHARE.b()) {
            String share_url = GlobalVariable.c().b().getShare_url();
            if (share_url.isEmpty()) {
                share_url = GlobalVariable.c().b().getUpdate().getLink();
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "Cinema");
            intent.putExtra("android.intent.extra.TEXT", "Get the Latest movie/tvShow app at " + share_url);
            startActivity(Intent.createChooser(intent, share_url));
        } else if (i2 == NavIds.NAV_DONATE.b()) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(GlobalVariable.c().b().getDonate_url())));
        } else if (i2 == NavIds.NAV_RATE.b()) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + Utils.getPackageName()));
            intent2.addFlags(1208483840);
            try {
                startActivity(intent2);
            } catch (ActivityNotFoundException unused) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + Utils.getPackageName())));
            }
        } else if (i2 == NavIds.NAV_CHECK_LASTEST.b()) {
            if (!autoupdate.a(this, true)) {
                Snackbar.w(findViewById(R.id.container), getResources().getString(R.string.newest_version), -1).s();
            }
        } else if (i2 == NavIds.NAV_SETTING.b()) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (i2 == NavIds.NAV_CALENDAR.b()) {
            Intent intent3 = new Intent(this, CalendarActivity.class);
            intent3.addFlags(67108864);
            startActivity(intent3);
        } else if (i2 == NavIds.NAV_ACTIVATE.b()) {
            startActivity(new Intent(this, MemberActivationActivity.class));
        } else if (i2 == NavIds.NAV_TORRENT_MANAGER.b()) {
            c0(TorrentManagerFragment.H());
        }
        MenuItem findItem = this.f32034d.getMenu().findItem(NavIds.f37572c.a(PrefUtils.d(this)).b());
        if (findItem != null) {
            findItem.setChecked(true);
        }
        this.f32041k = i2;
        return true;
    }

    /* access modifiers changed from: private */
    public void c0(BaseFragment baseFragment) {
        getSupportFragmentManager().n().q(R.id.container, baseFragment, "fragment_movies").r(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).i();
    }

    private void e0(boolean z2) {
        this.f32033c.setOnSuggestionListener(this);
        if (z2) {
            this.f32033c.requestFocusFromTouch();
        }
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.search_suggestion, (Cursor) null, new String[]{"suggest_text_1"}, new int[]{16908308}, 0);
        this.f32044n = simpleCursorAdapter;
        this.f32033c.setSuggestionsAdapter(simpleCursorAdapter);
        this.f32033c.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            public boolean f(int i2) {
                return false;
            }

            public boolean i(int i2) {
                Cursor cursor = (Cursor) MainActivity.this.f32044n.getItem(i2);
                if (cursor != null) {
                    MainActivity.this.f32033c.b0(cursor.getString(1), true);
                }
                Bundle bundle = new Bundle();
                if (MainActivity.this.f32043m.size() <= i2) {
                    return false;
                }
                bundle.putParcelable("app_data", MainActivity.this.f32043m.get(i2));
                MainActivity.this.f32033c.setAppSearchData(bundle);
                return false;
            }
        });
        this.f32033c.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(String str) {
                if (str.isEmpty()) {
                    return false;
                }
                MainActivity.this.Q(str);
                return false;
            }

            public boolean b(String str) {
                return false;
            }
        });
    }

    public void M() {
        this.f32032b.b(Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                Client.getIntance().autoconnect(observableEmitter);
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new r()));
    }

    public void N(String str) {
        this.f32032b.b(Client.getIntance().createObservable(str).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new Consumer<Object>() {
            public void accept(Object obj) throws Exception {
                if ((obj instanceof UserPlayerPluginInfo) && !((UserPlayerPluginInfo) obj).iConnect) {
                    MainActivity.this.M();
                }
            }
        }));
    }

    public List<ImdbSearchSuggestionModel.DBean> P(String str) {
        String a02 = a0(str, "\\((.*)\\)", 1, true);
        ArrayList arrayList = new ArrayList();
        for (ImdbSearchSuggestionModel.DBean next : ((ImdbSearchSuggestionModel) new Gson().l(a02, ImdbSearchSuggestionModel.class)).getD()) {
            try {
                String l2 = next.getL();
                if (l2 != null && !l2.trim().isEmpty() && !arrayList.contains(l2)) {
                    arrayList.add(next);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public void Q(String str) {
        new OkHttpClient().newCall(new Request.Builder().url("https://v2.sg.media-imdb.com" + String.format("/suggests/%s/%s.json", new Object[]{Character.valueOf(str.charAt(0)), str.replaceAll("\\s+", "")})).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
            }

            public void onResponse(Call call, Response response) throws IOException {
                try {
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.f32043m = mainActivity.P(response.body().string());
                    final MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_id", "suggest_text_1", "suggest_intent_data"});
                    for (int i2 = 0; i2 < MainActivity.this.f32043m.size(); i2++) {
                        matrixCursor.addRow(new String[]{Integer.toString(i2), MainActivity.this.f32043m.get(i2).getL(), MainActivity.this.f32043m.get(i2).getL()});
                    }
                    MainActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            CursorAdapter cursorAdapter = MainActivity.this.f32044n;
                            if (cursorAdapter != null) {
                                cursorAdapter.a(matrixCursor);
                            }
                        }
                    });
                } catch (Throwable unused) {
                    MainActivity.this.f32043m.clear();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void d0(CategoryEntity categoryEntity) {
        PrefUtils.g(this).edit().putString("pref_last_category", new Gson().u(categoryEntity)).apply();
    }

    public boolean f(int i2) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f0(int i2) {
        NavIds navIds = NavIds.NAV_MOVIE;
        if (i2 == navIds.b() || i2 == NavIds.NAV_TV_SHOW.b() || i2 == R.id.nav_lists) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle((CharSequence) "");
            final Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner);
            if (spinner != null) {
                toolbar.setSubtitle((CharSequence) "");
                spinner.setVisibility(0);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                        final CategoryEntity categoryEntity = (CategoryEntity) spinner.getAdapter().getItem(i2);
                        if (categoryEntity != null) {
                            CategoryEntity unused = MainActivity.this.f32040j = categoryEntity;
                            final String string = FreeMoviesApp.p().getString("pref_restrict_password", "");
                            final EditText editText = new EditText(MainActivity.this);
                            if (string.isEmpty() || !categoryEntity.getRestricted().booleanValue()) {
                                MainActivity mainActivity = MainActivity.this;
                                mainActivity.c0(BrowseMoviesFragment.e0(mainActivity.f32040j));
                                MainActivity mainActivity2 = MainActivity.this;
                                mainActivity2.d0(mainActivity2.f32040j);
                                return;
                            }
                            MainActivity mainActivity3 = MainActivity.this;
                            Utils.z0(mainActivity3, "Enter password to access " + categoryEntity.getName() + " category", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    if (editText.getText().toString().equals(string)) {
                                        MainActivity.this.c0(BrowseMoviesFragment.e0(categoryEntity));
                                        MainActivity mainActivity = MainActivity.this;
                                        mainActivity.d0(mainActivity.f32040j);
                                        return;
                                    }
                                    Utils.i0(MainActivity.this, "password is wrong");
                                }
                            }, editText, (DialogInterface.OnDismissListener) null);
                            return;
                        }
                        MainActivity mainActivity4 = MainActivity.this;
                        Utils.i0(mainActivity4, mainActivity4.getResources().getString(R.string.error_category_null));
                    }

                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
                if (i2 == NavIds.NAV_TV_SHOW.b()) {
                    this.f32040j.setType(CategoryEntity.Type.Show);
                } else if (i2 == navIds.b()) {
                    this.f32040j.setType(CategoryEntity.Type.Movie);
                } else if (i2 == R.id.nav_lists) {
                    this.f32040j.setType(CategoryEntity.Type.MIX);
                }
                this.f32032b.b(S().flatMap(new m(this)).observeOn(AndroidSchedulers.a()).subscribe(new n(this, spinner), new o(this)));
            }
        }
    }

    public boolean i(int i2) {
        if (i2 >= this.f32043m.size()) {
            return false;
        }
        this.f32033c.b0(this.f32043m.get(i2).getL(), true);
        Bundle bundle = new Bundle();
        bundle.putParcelable("app_data", this.f32043m.get(i2));
        this.f32033c.setAppSearchData(bundle);
        return false;
    }

    public void m(MovieEntity movieEntity, View view) {
        if (movieEntity.getTV().booleanValue()) {
            Intent intent = new Intent(this, ShowActivity.class);
            intent.putExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE", movieEntity);
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, MovieDetailsActivity.class);
        intent2.putExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE", movieEntity);
        startActivity(intent2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 444) {
            finish();
        }
        for (Fragment onActivityResult : getSupportFragmentManager().t0()) {
            onActivityResult.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawerLayout.isDrawerOpen(8388611)) {
                drawerLayout.closeDrawer(8388611);
                return;
            }
            if (this.f32042l == null) {
                this.f32042l = ((LovelyCustomDialog) ((LovelyCustomDialog) new LovelyCustomDialog(this).t(R.layout.dialog_exit_container).m(R.color.material_orange800)).n("EXIT APP !!")).q(new l()).r(R.id.btn_yes, new View.OnClickListener() {
                    public void onClick(View view) {
                        MainActivity.this.f32042l.c();
                        GlobalVariable.c();
                        GlobalVariable.a();
                        Utils.saveOpenCout(PrefUtils.e(MainActivity.this));
                        AdsManager.d().c();
                        Utils.D0(MainActivity.this);
                        MainActivity.this.finish();
                    }
                }).r(R.id.btn_no, new View.OnClickListener() {
                    public void onClick(View view) {
                        MainActivity.this.f32042l.c();
                    }
                });
            }
            this.f32042l.o();
            return;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        boolean z2;
        boolean z3;
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.f32039i.H(this);
        this.f32032b = new CompositeDisposable();
        String string = PrefUtils.g(this).getString("pref_last_category", (String) null);
        if (string != null) {
            this.f32040j = (CategoryEntity) new Gson().l(string, CategoryEntity.class);
        }
        if (this.f32040j == null) {
            this.f32040j = new CategoryEntity(CategoryEntity.Source.TMDB, CategoryEntity.Type.Show, Integer.valueOf(CategoryEntity.Generic.Popular.getValue()), CategoryEntity.SourceType.Generic, "Popular");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().u(false);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        AnonymousClass1 r2 = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                MainActivity.this.f32034d.clearFocus();
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                MainActivity.this.f32034d.requestFocus();
            }
        };
        drawerLayout.addDrawerListener(r2);
        r2.e();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.f32034d = navigationView;
        navigationView.bringToFront();
        this.f32034d.setNavigationItemSelectedListener(this);
        this.f32034d.getMenu().findItem(R.id.nav_rate).setVisible(false);
        MenuItem findItem = this.f32034d.getMenu().findItem(R.id.nav_torrent_manager);
        if (RealDebridCredentialsHelper.d().isValid() || AllDebridCredentialsHelper.b().isValid() || PremiumizeCredentialsHelper.b().isValid()) {
            z2 = true;
        } else {
            z2 = false;
        }
        findItem.setVisible(z2);
        int intExtra = getIntent().getIntExtra("GotNavID", -1);
        if (intExtra > -1) {
            b0(intExtra);
        }
        int b02 = Utils.b0();
        int versionCode = GlobalVariable.c().b().getUpdate().getVersionCode();
        String link = GlobalVariable.c().b().getUpdate().getLink();
        if (versionCode <= b02 || link == null || link.equals("")) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            SpannableString spannableString = new SpannableString("New Update available !!!");
            spannableString.setSpan(new ForegroundColorSpan(-16711936), 0, spannableString.length(), 0);
            this.f32034d.getMenu().findItem(R.id.nav_checkLastest).setTitle(spannableString);
        }
        ((TextView) this.f32034d.c(0).findViewById(R.id.header_version)).setText(String.format("%s (%s)", new Object[]{getResources().getString(R.string.app_name), Utils.c0()}));
        if (!O()) {
            FreeMoviesApp.p().getBoolean("pref_show_choose_sub_lang", false);
            SharedPreferences p2 = FreeMoviesApp.p();
            if (!p2.getBoolean("pref_show_changlog_v2" + Utils.c0(), false)) {
                new SpannableStringBuilder("Change Logs").setSpan(new ForegroundColorSpan(-256), 0, 11, 33);
                new AlertDialog.Builder(this).setTitle("Change Logs").setView(getLayoutInflater().inflate(R.layout.dialog_changelog, (ViewGroup) null)).l("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                    }
                }).create().show();
                SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                edit.putBoolean("pref_show_changlog_v2" + Utils.c0(), true).apply();
            }
            final AppConfig.NotificationBean notification = GlobalVariable.c().b().getNotification();
            if (notification != null) {
                SharedPreferences p3 = FreeMoviesApp.p();
                if (p3.getBoolean("notifycation_" + notification.getId(), true) && !notification.getMsg().isEmpty()) {
                    new AlertDialog.Builder(this).setTitle(notification.getTitle()).g(notification.getMsg()).l("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                        }
                    }).i("Don't show again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                            edit.putBoolean("notifycation_" + notification.getId(), false).apply();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                        }
                    }).create().show();
                }
            }
            SharedPreferences p4 = FreeMoviesApp.p();
            if (!p4.getBoolean("pref_show_disclaimer" + Utils.getPackageName(), false)) {
                new AlertDialog.Builder(this).setTitle("DISCLAIMER").d(R.drawable.warning_36x36).f(R.string.disclaimer).l("ACCEPT", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                        edit.putBoolean("pref_show_disclaimer" + Utils.getPackageName(), true).apply();
                    }
                }).i("DECLINE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        MainActivity.this.finish();
                    }
                }).create().show();
            }
            autoupdate.a(this, false);
            this.f32032b.b(Observable.create(new ObservableOnSubscribe<List<CrawlCount>>() {
                public void subscribe(ObservableEmitter<List<CrawlCount>> observableEmitter) throws Exception {
                    List<CrawlCount> all = MainActivity.this.f32037g.x().getAll();
                    if (all != null) {
                        observableEmitter.onNext(all);
                    }
                    new CrawlBody().setList(all);
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new p(), new q()));
        }
        Utils.u();
        if (!DeviceUtils.b() && !DeviceUtils.a()) {
            AdsManager.d().o((ViewGroup) findViewById(R.id.adView));
        }
        String user_agent = GlobalVariable.c().b().getUser_agent();
        if (user_agent != null && !user_agent.isEmpty()) {
            Constants.C = user_agent;
        }
        String github_js = GlobalVariable.c().b().getGithub_js();
        if (github_js != null && !github_js.isEmpty()) {
            Constants.E = github_js;
        }
        if (FreeMoviesApp.p().getBoolean("use_player_plugin", false)) {
            N(FreeMoviesApp.p().getString("ip_player_plugin", ""));
        }
        if (TraktCredentialsHelper.b().isValid() && FreeMoviesApp.p().getBoolean("pref_trakt_sync_from_startup", false)) {
            TraktUserApi.M().k0(this.f32032b, this, this.f32037g);
        }
        BaseProvider.H();
        BaseProvider.s();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem findItem = menu.findItem(R.id.action_search);
        MenuItem findItem2 = menu.findItem(R.id.active_source);
        if (this.f32040j.getSource() == CategoryEntity.Source.TMDB) {
            findItem2.setIcon(R.drawable.ic_tmdb_icon);
        } else if (this.f32040j.getSource() == CategoryEntity.Source.TRAKT) {
            findItem2.setIcon(R.drawable.trakt_icon);
        }
        SearchManager searchManager = (SearchManager) getSystemService("search");
        if (findItem != null) {
            this.f32033c = (SearchView) findItem.getActionView();
            MenuItemCompat.h(findItem, new MenuItemCompat.OnActionExpandListener() {
                public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.c0(BrowseMoviesFragment.e0(mainActivity.f32040j));
                    return true;
                }

                public boolean onMenuItemActionExpand(MenuItem menuItem) {
                    return true;
                }
            });
        }
        SearchView searchView = this.f32033c;
        if (searchView == null) {
            return true;
        }
        try {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        for (String file : Utils.M()) {
            File file2 = new File(file);
            if (file2.exists()) {
                file2.delete();
            }
        }
        PrefUtils.p("file_to_delete", new ArrayList());
        this.f32032b.dispose();
        this.f32039i.z();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if ("android.intent.action.SEARCH".equals(intent.getAction())) {
            intent.getBundleExtra("app_data");
            final String stringExtra = intent.getStringExtra("query");
            if (stringExtra != null && !stringExtra.isEmpty()) {
                this.f32033c.b0(stringExtra, false);
                final String string = FreeMoviesApp.p().getString("pref_restrict_password", "");
                boolean z2 = FreeMoviesApp.p().getBoolean("pref_restrict_search", true);
                if (string.isEmpty() || !z2) {
                    ImdbSearchSuggestionModel.DBean dBean = new ImdbSearchSuggestionModel.DBean();
                    dBean.setL(stringExtra);
                    dBean.setQ("");
                    c0(BrowseMoviesFragment.e0(new CategoryEntity(this.f32040j.getSource(), this.f32040j.getType(), -1, CategoryEntity.SourceType.Search, stringExtra)));
                    PrefUtils.r(this, stringExtra);
                    return;
                }
                final EditText editText = new EditText(this);
                Utils.z0(this, "Enter password", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        if (string.equals(editText.getText().toString())) {
                            ImdbSearchSuggestionModel.DBean dBean = new ImdbSearchSuggestionModel.DBean();
                            dBean.setL(stringExtra);
                            dBean.setQ("");
                            MainActivity.this.c0(BrowseMoviesFragment.e0(new CategoryEntity(MainActivity.this.f32040j.getSource(), MainActivity.this.f32040j.getType(), -1, CategoryEntity.SourceType.Search, stringExtra)));
                            PrefUtils.r(MainActivity.this, stringExtra);
                            return;
                        }
                        Utils.i0(MainActivity.this, "Password is worng");
                    }
                }, editText, (DialogInterface.OnDismissListener) null);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_search) {
            e0(false);
            return true;
        }
        if (itemId == R.id.active_source) {
            CategoryEntity.Source source = this.f32040j.getSource();
            CategoryEntity.Source source2 = CategoryEntity.Source.TMDB;
            if (source == source2) {
                this.f32040j.setSource(CategoryEntity.Source.TRAKT);
                menuItem.setIcon(R.drawable.trakt_icon);
            } else {
                this.f32040j.setSource(source2);
                menuItem.setIcon(R.drawable.ic_tmdb_icon);
            }
            f0(this.f32041k);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getRootView().getWindowToken(), 0);
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 934839) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Permission denied", 0).show();
                finish();
                return;
            }
            b0(R.id.nav_download);
        } else if (i2 != 934834) {
        } else {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Permission denied", 0).show();
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        PrefUtils.h(this);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public boolean q(MenuItem menuItem) {
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer(8388611);
        return b0(menuItem.getItemId());
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().k(this);
    }
}
