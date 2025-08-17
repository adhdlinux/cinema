package com.movie.ui.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.ads.videoreward.AdsManager;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.api.tvmaze.TVMazeApi;
import com.movie.data.model.CalendarItem;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.tmvdb.ExternalTV;
import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.data.model.tvmaze.MazeTVEpisodeItem;
import com.movie.ui.activity.sources.SourceActivity;
import com.movie.ui.adapter.CalendarAdapter;
import com.movie.ui.helper.MoviesHelper;
import com.movie.ui.widget.AnimatorStateView;
import com.original.tase.api.TraktUserApi;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.original.tase.utils.DeviceUtils;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.entities.CalendarShowEntry;
import com.uwetrottmann.trakt5.entities.Show;
import com.uwetrottmann.trakt5.entities.ShowIds;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.inject.Inject;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import timber.log.Timber;

public class CalendarActivity extends BaseActivity implements CalendarAdapter.OnCalendarClickListener {
    @BindView(2131361882)
    FrameLayout ad_view;

    /* renamed from: b  reason: collision with root package name */
    private ProgressDialog f31997b = null;

    /* renamed from: c  reason: collision with root package name */
    private CompositeDisposable f31998c;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    TVMazeApi f31999d;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    MvDatabase f32000e;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public TMDBApi f32001f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public IMDBApi f32002g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    public TheTvdb f32003h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    MoviesHelper f32004i;

    /* renamed from: j  reason: collision with root package name */
    protected GridLayoutManager f32005j;

    /* renamed from: k  reason: collision with root package name */
    private CalendarAdapter f32006k;

    /* renamed from: l  reason: collision with root package name */
    List<CalendarItem> f32007l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    String f32008m = DateTime.now().toString(DateTimeFormat.forPattern("yyyy-MM-dd"));
    @BindView(2131361987)
    RecyclerView mRecyclerView;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public CALENDAR_API f32009n = CALENDAR_API.MAZE;

    /* renamed from: o  reason: collision with root package name */
    private int f32010o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Toolbar f32011p;

    /* renamed from: q  reason: collision with root package name */
    String f32012q = "";
    @BindView(2131362909)
    AnimatorStateView view_empty;

    enum CALENDAR_API {
        TRAKT,
        MAZE
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            MazeTVEpisodeItem mazeTVEpisodeItem = (MazeTVEpisodeItem) it2.next();
            CalendarItem calendarItem = new CalendarItem();
            calendarItem.airTime = mazeTVEpisodeItem.getAirdate();
            calendarItem.episode = mazeTVEpisodeItem.getNumber();
            calendarItem.season = mazeTVEpisodeItem.getSeason();
            if (mazeTVEpisodeItem.getShow().getImage() != null) {
                calendarItem.backdrop = mazeTVEpisodeItem.getShow().getImage().getOriginal();
                calendarItem.poster = mazeTVEpisodeItem.getShow().getImage().getMedium();
            }
            calendarItem.showName = mazeTVEpisodeItem.getShow().getName();
            calendarItem.episodeName = mazeTVEpisodeItem.getName();
            calendarItem.imdbID = mazeTVEpisodeItem.getShow().getExternals().getImdb();
            calendarItem.tmdbID = -1;
            calendarItem.tvdnID = (long) mazeTVEpisodeItem.getShow().getExternals().getThetvdb();
            calendarItem.traktID = -1;
            calendarItem.isNotTmdb = true;
            arrayList.add(calendarItem);
        }
        Y(arrayList);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(Throwable th) throws Exception {
        this.view_empty.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(List list) throws Exception {
        ShowIds showIds;
        long j2;
        long j3;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CalendarShowEntry calendarShowEntry = (CalendarShowEntry) it2.next();
            try {
                Show show = calendarShowEntry.show;
                if (!(show == null || (showIds = show.ids) == null)) {
                    CalendarItem calendarItem = new CalendarItem();
                    OffsetDateTime offsetDateTime = calendarShowEntry.first_aired;
                    if (offsetDateTime != null) {
                        calendarItem.airTime = offsetDateTime.atZoneSameInstant(ZoneId.systemDefault()).toLocalTime().toString();
                    } else {
                        calendarItem.airTime = "unknow";
                    }
                    calendarItem.episode = calendarShowEntry.episode.number.intValue();
                    calendarItem.season = calendarShowEntry.episode.season.intValue();
                    calendarItem.showName = calendarShowEntry.show.title;
                    calendarItem.episodeName = calendarShowEntry.episode.title;
                    calendarItem.imdbID = showIds.imdb;
                    Integer num = showIds.tmdb;
                    long j4 = -1;
                    if (num != null) {
                        j2 = (long) num.intValue();
                    } else {
                        j2 = -1;
                    }
                    calendarItem.tmdbID = j2;
                    Integer num2 = showIds.trakt;
                    if (num2 != null) {
                        j3 = (long) num2.intValue();
                    } else {
                        j3 = -1;
                    }
                    calendarItem.traktID = j3;
                    Integer num3 = showIds.tvdb;
                    if (num3 != null) {
                        j4 = (long) num3.intValue();
                    }
                    calendarItem.tvdnID = j4;
                    arrayList.add(calendarItem);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        X(arrayList);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void R(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S() throws Exception {
        CalendarAdapter calendarAdapter = this.f32006k;
        if (calendarAdapter == null || calendarAdapter.g() == null || this.f32006k.g().size() == 0) {
            boolean z2 = true;
            if (!FreeMoviesApp.p().getBoolean("pre_show_my_calenda_shows_only", true) || !TraktCredentialsHelper.b().isValid()) {
                z2 = false;
            }
            if (z2) {
                AnimatorStateView animatorStateView = this.view_empty;
                animatorStateView.setMessageText("No my show avaialbe for " + this.f32008m + "\nTry turn off 'Show My Calendar Show only' to show all\nOr select another day");
            } else {
                AnimatorStateView animatorStateView2 = this.view_empty;
                animatorStateView2.setMessageText("No my show avaialbe for " + this.f32008m);
            }
            this.view_empty.setVisibility(0);
            return;
        }
        this.f32006k.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(CalendarItem calendarItem, Object obj) throws Exception {
        MovieEntity movieEntity;
        String str;
        String str2;
        if (obj instanceof ExternalTV) {
            movieEntity = ((ExternalTV) obj).getTv_results().get(0).convert();
        } else if (obj instanceof TvTMDB.ResultsBean) {
            movieEntity = ((TvTMDB.ResultsBean) obj).convert();
        } else {
            movieEntity = null;
        }
        Intent intent = new Intent(this, SourceActivity.class);
        intent.putExtra("Movie", movieEntity);
        if (movieEntity.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = movieEntity.getRealeaseDate().split("-")[0];
        }
        String name = movieEntity.getName();
        String str3 = "" + calendarItem.season;
        String str4 = "" + calendarItem.episode;
        String str5 = calendarItem.airTime;
        if (str5 == null) {
            str2 = "1970";
        } else {
            str2 = str5.split("-")[0];
        }
        MovieInfo movieInfo = new MovieInfo(name, str, str3, str4, str2, movieEntity.getGenres());
        movieInfo.imdbIDStr = movieEntity.getImdbIDStr();
        movieInfo.tmdbID = movieEntity.getTmdbID();
        movieInfo.setImdbIDStr(movieEntity.getImdbIDStr());
        movieInfo.epsCount = -1;
        intent.putExtra("MovieInfo", movieInfo);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(CalendarItem calendarItem, Throwable th) throws Exception {
        String str;
        Intent intent = new Intent(this, SourceActivity.class);
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(calendarItem.showName);
        movieEntity.setNumberSeason(calendarItem.season);
        movieEntity.setRealeaseDate(calendarItem.airTime);
        movieEntity.setTmdbID(calendarItem.tmdbID);
        movieEntity.setTraktID(calendarItem.traktID);
        movieEntity.setImdbIDStr(calendarItem.imdbID);
        movieEntity.setTvdbID(calendarItem.tvdnID);
        movieEntity.setTV(Boolean.TRUE);
        intent.putExtra("Movie", movieEntity);
        if (movieEntity.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = movieEntity.getRealeaseDate().split("-")[0];
        }
        String name = movieEntity.getName();
        String str2 = "" + calendarItem.season;
        String str3 = "" + calendarItem.episode;
        String str4 = calendarItem.airTime;
        if (str4 == null) {
            str4 = "1970";
        }
        MovieInfo movieInfo = new MovieInfo(name, str, str2, str3, str4, new ArrayList());
        movieInfo.imdbIDStr = movieEntity.getImdbIDStr();
        movieInfo.tmdbID = movieEntity.getTmdbID();
        movieInfo.setImdbIDStr(movieEntity.getImdbIDStr());
        movieInfo.epsCount = 10000;
        intent.putExtra("MovieInfo", movieInfo);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void V(String str) {
        this.f32010o = 0;
        CalendarAdapter calendarAdapter = this.f32006k;
        if (calendarAdapter != null) {
            calendarAdapter.d();
            this.f32007l.clear();
            this.f31998c.d();
        }
        this.f31998c.b(this.f31999d.getCalendar(str).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c(this), new d(this)));
    }

    /* access modifiers changed from: private */
    public void W(final String str) {
        this.f32010o = 0;
        CalendarAdapter calendarAdapter = this.f32006k;
        if (calendarAdapter != null) {
            calendarAdapter.d();
            this.f32007l.clear();
            this.f31998c.d();
        }
        this.f31998c.b(Observable.create(new ObservableOnSubscribe<List<CalendarShowEntry>>() {
            public void subscribe(ObservableEmitter<List<CalendarShowEntry>> observableEmitter) throws Exception {
                boolean z2 = FreeMoviesApp.p().getBoolean("pre_show_my_calenda_shows_only", true);
                if (!TraktCredentialsHelper.b().isValid() || !z2) {
                    List<CalendarShowEntry> B = TraktUserApi.M().B(str);
                    if (B != null) {
                        observableEmitter.onNext(B);
                    }
                    observableEmitter.onComplete();
                    return;
                }
                List<CalendarShowEntry> G = TraktUserApi.M().G(str);
                if (G != null) {
                    observableEmitter.onNext(G);
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(this), new f(), new g(this)));
    }

    private void X(List<CalendarItem> list) {
        int i2;
        if (this.f32005j == null) {
            CalendarAdapter calendarAdapter = new CalendarAdapter(this, this.f32007l);
            this.f32006k = calendarAdapter;
            calendarAdapter.p(this);
            if (getResources().getConfiguration().orientation == 2) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            this.f32005j = new GridLayoutManager(this, getResources().getInteger(R.integer.movies_columns));
            int X = Utils.X(this);
            if (X == 2 || X == 0) {
                this.f32005j.s(i2);
            } else {
                this.f32005j.s(1);
            }
            this.f32005j.setOrientation(1);
            this.mRecyclerView.setLayoutManager(this.f32005j);
            this.mRecyclerView.setAdapter(this.f32006k);
        }
        this.f32007l.addAll(list);
        int size = this.f32007l.size() / 20;
        int i3 = this.f32010o;
        if (size > i3) {
            this.f32010o = i3 + 1;
            this.f32006k.notifyDataSetChanged();
        }
    }

    private void Y(List<CalendarItem> list) {
        int i2;
        this.f32007l = list;
        CalendarAdapter calendarAdapter = new CalendarAdapter(this, list);
        this.f32006k = calendarAdapter;
        calendarAdapter.p(this);
        if (getResources().getConfiguration().orientation == 2) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        this.f32005j = new GridLayoutManager(this, getResources().getInteger(R.integer.movies_columns));
        int X = Utils.X(this);
        if (X == 2 || X == 0) {
            this.f32005j.s(i2);
        } else {
            this.f32005j.s(1);
        }
        this.f32005j.setOrientation(1);
        this.mRecyclerView.setLayoutManager(this.f32005j);
        this.mRecyclerView.setAdapter(this.f32006k);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.f32011p = toolbar;
        if (toolbar == null) {
            Timber.g("Didn't find a toolbar", new Object[0]);
            return;
        }
        ViewCompat.z0(toolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(this.f32011p);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.y(true);
            supportActionBar.A(this.f32008m);
        }
    }

    /* access modifiers changed from: package-private */
    public Observable<?> N(long j2, long j3, String str) {
        if (j2 > 0) {
            return this.f32001f.getTvDetails(j2);
        }
        if (str != null && !str.isEmpty()) {
            return this.f32001f.getTVDetails(str, "imdb_id");
        }
        if (j3 > 0) {
            return this.f32001f.getTVDetails(String.valueOf(j3), "tvdb_id");
        }
        return null;
    }

    public void Z(boolean z2) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.f32011p = toolbar;
        if (z2) {
            toolbar.setTitle((CharSequence) "TV Calendar (Trakt.tv)");
        } else {
            toolbar.setTitle((CharSequence) "TV Calendar (MazeTv)");
        }
    }

    public void hideWaitingDialog() {
        ProgressDialog progressDialog = this.f31997b;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void j(CalendarItem calendarItem, View view, int i2) {
        String str;
        if (calendarItem.isNotTmdb) {
            N(calendarItem.tmdbID, calendarItem.tvdnID, calendarItem.imdbID).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new h(this, calendarItem), new i(this, calendarItem));
            return;
        }
        Intent intent = new Intent(this, SourceActivity.class);
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(calendarItem.showName);
        movieEntity.setNumberSeason(calendarItem.season);
        movieEntity.setRealeaseDate(calendarItem.airTime);
        movieEntity.setTmdbID(calendarItem.tmdbID);
        movieEntity.setTraktID(calendarItem.traktID);
        movieEntity.setImdbIDStr(calendarItem.imdbID);
        movieEntity.setTvdbID(calendarItem.tvdnID);
        movieEntity.setTV(Boolean.TRUE);
        intent.putExtra("Movie", movieEntity);
        if (movieEntity.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = movieEntity.getRealeaseDate().split("-")[0];
        }
        String name = movieEntity.getName();
        String str2 = "" + calendarItem.season;
        String str3 = "" + calendarItem.episode;
        String str4 = calendarItem.airTime;
        if (str4 == null) {
            str4 = "1970";
        }
        MovieInfo movieInfo = new MovieInfo(name, str, str2, str3, str4, new ArrayList());
        movieInfo.imdbIDStr = movieEntity.getImdbIDStr();
        movieInfo.tmdbID = movieEntity.getTmdbID();
        movieInfo.epsCount = 10000;
        intent.putExtra("MovieInfo", movieInfo);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31998c = new CompositeDisposable();
        setContentView(R.layout.activity_calendar);
        if (!DeviceUtils.b()) {
            AdsManager.d().o(this.ad_view);
        }
        boolean z2 = FreeMoviesApp.p().getBoolean("pref_use_trakt_calendar2", true);
        if (z2) {
            this.f32009n = CALENDAR_API.TRAKT;
        } else {
            this.f32009n = CALENDAR_API.MAZE;
        }
        this.view_empty.setVisibility(4);
        setupToolbar();
        Z(z2);
        this.mRecyclerView.requestFocus();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
        boolean z2 = FreeMoviesApp.p().getBoolean("pref_use_trakt_calendar2", true);
        CheckBox checkBox = (CheckBox) menu.findItem(R.id.use_trakt).getActionView();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                FreeMoviesApp.p().edit().putBoolean("pref_use_trakt_calendar2", z2).apply();
                if (z2) {
                    CALENDAR_API unused = CalendarActivity.this.f32009n = CALENDAR_API.TRAKT;
                } else {
                    CALENDAR_API unused2 = CalendarActivity.this.f32009n = CALENDAR_API.MAZE;
                }
                CalendarActivity.this.Z(z2);
                if (CalendarActivity.this.f32009n == CALENDAR_API.MAZE) {
                    CalendarActivity calendarActivity = CalendarActivity.this;
                    calendarActivity.V(calendarActivity.f32008m);
                    return;
                }
                CalendarActivity calendarActivity2 = CalendarActivity.this;
                calendarActivity2.W(calendarActivity2.f32008m);
            }
        });
        if (checkBox.isChecked() == z2) {
            if (this.f32009n == CALENDAR_API.MAZE) {
                V(this.f32008m);
            } else {
                W(this.f32008m);
            }
        }
        checkBox.setChecked(z2);
        checkBox.setText("Use Trakt Calendars");
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f31998c.dispose();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        DateTime now = DateTime.now(DateTimeZone.forTimeZone(TimeZone.getDefault()));
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_pickdate) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (DatePickerDialog.OnDateSetListener) null, now.getYear(), now.getMonthOfYear() - 1, now.getDayOfMonth());
            datePickerDialog.getDatePicker().init(now.getYear(), now.getMonthOfYear() - 1, now.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
                public void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
                    CalendarActivity.this.f32012q = new LocalDate(i2, i3 + 1, i4).toString(DateTimeFormat.forPattern("yyyy-MM-dd"));
                }
            });
            datePickerDialog.setButton(-1, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (!CalendarActivity.this.f32012q.isEmpty()) {
                        CalendarActivity calendarActivity = CalendarActivity.this;
                        calendarActivity.f32008m = calendarActivity.f32012q;
                    }
                    CalendarActivity.this.view_empty.setVisibility(4);
                    if (CalendarActivity.this.f32009n == CALENDAR_API.MAZE) {
                        CalendarActivity calendarActivity2 = CalendarActivity.this;
                        calendarActivity2.V(calendarActivity2.f32008m);
                    } else {
                        CalendarActivity calendarActivity3 = CalendarActivity.this;
                        calendarActivity3.W(calendarActivity3.f32008m);
                    }
                    CalendarActivity.this.Z(FreeMoviesApp.p().getBoolean("pref_use_trakt_calendar2", false));
                    CalendarActivity calendarActivity4 = CalendarActivity.this;
                    Toolbar unused = calendarActivity4.f32011p = (Toolbar) calendarActivity4.findViewById(R.id.toolbar);
                    if (CalendarActivity.this.f32011p != null) {
                        String print = DateTimeFormat.forPattern("EE").print((ReadableInstant) DateTimeHelper.i(CalendarActivity.this.f32008m));
                        Toolbar L = CalendarActivity.this.f32011p;
                        L.setSubtitle((CharSequence) CalendarActivity.this.f32008m + "(" + print + ")");
                    }
                }
            });
            datePickerDialog.setButton(-2, "Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    CalendarActivity.this.f32012q = "";
                }
            });
            datePickerDialog.show();
        } else if (itemId == R.id.use_trakt) {
            CheckBox checkBox = (CheckBox) menuItem.getActionView();
            checkBox.setChecked(!checkBox.isChecked());
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().a(this);
    }

    public void showWaitingDialog(String str) {
        if (this.f31997b == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f31997b = progressDialog;
            try {
                progressDialog.show();
            } catch (WindowManager.BadTokenException unused) {
            }
            this.f31997b.setCancelable(true);
            this.f31997b.getWindow().setBackgroundDrawableResource(R.color.transparent);
            this.f31997b.setContentView(R.layout.progressbar);
            TextView textView = (TextView) this.f31997b.findViewById(R.id.tv_title);
            if (!str.isEmpty()) {
                textView.setText(str);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        this.f31997b.show();
    }
}
