package us.shandian.giga.ui.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.database.entitys.MovieEntity;
import com.database.entitys.TvWatchedEpisode;
import com.movie.data.model.MovieInfo;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.subtitle.SubtitleInfo;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import s1.a;
import s1.b;
import s1.c;
import s1.d;
import us.shandian.giga.get.DownloadManager;
import us.shandian.giga.get.DownloadMission;
import us.shandian.giga.service.DownloadManagerService;
import us.shandian.giga.ui.common.ProgressDrawable;
import us.shandian.giga.util.Utility;

public class MissionAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static final Map<Integer, String> f42242v;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Activity f42243n;

    /* renamed from: o  reason: collision with root package name */
    private LayoutInflater f42244o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public DownloadManager f42245p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public DownloadManagerService.DMBinder f42246q;

    /* renamed from: r  reason: collision with root package name */
    private int f42247r;

    /* renamed from: s  reason: collision with root package name */
    MoviesHelper f42248s;

    /* renamed from: t  reason: collision with root package name */
    PlayerHelper f42249t;

    /* renamed from: u  reason: collision with root package name */
    CompositeDisposable f42250u = null;

    private static class ChecksumTask extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        ProgressDialog f42257a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<Activity> f42258b;

        ChecksumTask(Activity activity) {
            this.f42258b = new WeakReference<>(activity);
        }

        private Activity b() {
            Activity activity = this.f42258b.get();
            if (activity == null || !activity.isFinishing()) {
                return activity;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return Utility.a(strArr[0], strArr[1]);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ProgressDialog progressDialog = this.f42257a;
            if (progressDialog != null) {
                Utility.b(progressDialog.getContext(), str);
                if (b() != null) {
                    this.f42257a.dismiss();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            Activity b2 = b();
            if (b2 != null) {
                ProgressDialog progressDialog = new ProgressDialog(b2);
                this.f42257a = progressDialog;
                progressDialog.setCancelable(false);
                this.f42257a.setMessage(b2.getString(R.string.msg_wait));
                this.f42257a.show();
            }
        }
    }

    static class MissionObserver implements DownloadMission.MissionListener {

        /* renamed from: b  reason: collision with root package name */
        private MissionAdapter f42259b;

        /* renamed from: c  reason: collision with root package name */
        private ViewHolder f42260c;

        public MissionObserver(MissionAdapter missionAdapter, ViewHolder viewHolder) {
            this.f42259b = missionAdapter;
            this.f42260c = viewHolder;
        }

        public void a(DownloadMission downloadMission) {
            ViewHolder viewHolder = this.f42260c;
            DownloadMission downloadMission2 = viewHolder.f42261j;
            if (downloadMission2 != null) {
                viewHolder.f42266o.setText(Utility.c(downloadMission2.f42194f));
                this.f42259b.B(this.f42260c, true);
            }
        }

        public void b(DownloadMission downloadMission, int i2) {
            this.f42259b.A(this.f42260c);
        }

        public void c(DownloadMission downloadMission, long j2, long j3) {
            this.f42259b.A(this.f42260c);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        public DownloadMission f42261j;

        /* renamed from: k  reason: collision with root package name */
        public int f42262k;

        /* renamed from: l  reason: collision with root package name */
        public TextView f42263l;

        /* renamed from: m  reason: collision with root package name */
        public ImageView f42264m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f42265n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f42266o;

        /* renamed from: p  reason: collision with root package name */
        public View f42267p;

        /* renamed from: q  reason: collision with root package name */
        public ImageView f42268q;

        /* renamed from: r  reason: collision with root package name */
        public ProgressDrawable f42269r;

        /* renamed from: s  reason: collision with root package name */
        public MissionObserver f42270s;

        /* renamed from: t  reason: collision with root package name */
        public long f42271t = -1;

        /* renamed from: u  reason: collision with root package name */
        public long f42272u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f42273v;

        /* renamed from: w  reason: collision with root package name */
        public String f42274w;

        public ViewHolder(View view) {
            super(view);
            this.f42263l = (TextView) view.findViewById(R.id.item_status);
            this.f42264m = (ImageView) view.findViewById(R.id.item_icon);
            this.f42265n = (TextView) view.findViewById(R.id.item_name);
            this.f42266o = (TextView) view.findViewById(R.id.item_size);
            this.f42267p = view.findViewById(R.id.item_bkg);
            this.f42268q = (ImageView) view.findViewById(R.id.item_more);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f42242v = hashMap;
        hashMap.put(Integer.valueOf(R.id.md5), "MD5");
        hashMap.put(Integer.valueOf(R.id.sha1), "SHA1");
    }

    public MissionAdapter(Activity activity, DownloadManagerService.DMBinder dMBinder, DownloadManager downloadManager, boolean z2, MoviesHelper moviesHelper, PlayerHelper playerHelper) {
        int i2;
        this.f42243n = activity;
        this.f42245p = downloadManager;
        this.f42246q = dMBinder;
        this.f42244o = (LayoutInflater) activity.getSystemService("layout_inflater");
        if (z2) {
            i2 = R.layout.mission_item_linear;
        } else {
            i2 = R.layout.mission_item;
        }
        this.f42247r = i2;
        this.f42250u = new CompositeDisposable();
        this.f42248s = moviesHelper;
        this.f42249t = playerHelper;
    }

    /* access modifiers changed from: private */
    public void A(ViewHolder viewHolder) {
        B(viewHolder, false);
    }

    /* access modifiers changed from: private */
    public void B(ViewHolder viewHolder, boolean z2) {
        ViewHolder viewHolder2 = viewHolder;
        if (viewHolder2.f42261j != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (viewHolder2.f42271t == -1) {
                viewHolder2.f42271t = currentTimeMillis;
            }
            if (viewHolder2.f42272u == -1) {
                viewHolder2.f42272u = viewHolder2.f42261j.f42197i;
            }
            long j2 = currentTimeMillis - viewHolder2.f42271t;
            DownloadMission downloadMission = viewHolder2.f42261j;
            long j3 = downloadMission.f42197i;
            long j4 = j3 - viewHolder2.f42272u;
            if (j2 == 0 || j2 > 1000 || z2) {
                if (downloadMission.f42205q > 0) {
                    viewHolder2.f42263l.setText(R.string.msg_error);
                } else {
                    float f2 = ((float) j3) / ((float) downloadMission.f42194f);
                    viewHolder2.f42263l.setText(String.format(Locale.US, "%.2f%%", new Object[]{Float.valueOf(100.0f * f2)}));
                    viewHolder2.f42269r.a(f2);
                }
            }
            if (j2 > 1000 && j4 > 0) {
                String d2 = Utility.d((((float) j4) / ((float) j2)) * 1000.0f);
                String c2 = Utility.c(viewHolder2.f42261j.f42194f);
                TextView textView = viewHolder2.f42266o;
                textView.setText(c2 + " " + d2);
                viewHolder2.f42271t = currentTimeMillis;
                viewHolder2.f42272u = viewHolder2.f42261j.f42197i;
            }
        }
    }

    /* access modifiers changed from: private */
    public void C(String str, String str2, File file, String str3) {
        this.f42243n.getApplicationContext().getPackageName();
        String[] split = str2.split("_");
        if (split.length > 4) {
            x(str, split[1], Long.parseLong(split[0]), split[2], split[3], split[4], split[5], file.toString());
            return;
        }
        x(str, split[1], Long.parseLong(split[0]), split[2], split[3], "0", "0", file.toString());
    }

    /* access modifiers changed from: private */
    public void o(final ViewHolder viewHolder) {
        PopupMenu popupMenu = new PopupMenu(this.f42243n, viewHolder.f42268q);
        popupMenu.inflate(R.menu.mission);
        Menu menu = popupMenu.getMenu();
        MenuItem findItem = menu.findItem(R.id.start);
        MenuItem findItem2 = menu.findItem(R.id.pause);
        MenuItem findItem3 = menu.findItem(R.id.view);
        MenuItem findItem4 = menu.findItem(R.id.delete);
        MenuItem findItem5 = menu.findItem(R.id.checksum);
        findItem.setVisible(false);
        findItem2.setVisible(false);
        findItem3.setVisible(false);
        findItem4.setVisible(false);
        findItem5.setVisible(false);
        DownloadMission downloadMission = viewHolder.f42261j;
        if (downloadMission.f42203o) {
            findItem3.setVisible(true);
            findItem4.setVisible(true);
            findItem5.setVisible(true);
        } else if (!downloadMission.f42202n) {
            if (downloadMission.f42205q == -1) {
                findItem.setVisible(true);
            }
            findItem4.setVisible(true);
        } else {
            findItem2.setVisible(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.delete:
                        MissionAdapter.this.f42245p.c(viewHolder.f42262k);
                        MissionAdapter.this.notifyDataSetChanged();
                        return true;
                    case R.id.md5:
                    case R.id.sha1:
                        DownloadMission e2 = MissionAdapter.this.f42245p.e(viewHolder.f42262k);
                        ChecksumTask checksumTask = new ChecksumTask(MissionAdapter.this.f42243n);
                        checksumTask.execute(new String[]{e2.f42192d + "/" + e2.f42190b, (String) MissionAdapter.f42242v.get(Integer.valueOf(itemId))});
                        return true;
                    case R.id.pause:
                        MissionAdapter.this.f42245p.a(viewHolder.f42262k);
                        MissionAdapter.this.f42246q.c(MissionAdapter.this.f42245p.e(viewHolder.f42262k));
                        ViewHolder viewHolder = viewHolder;
                        viewHolder.f42271t = -1;
                        viewHolder.f42272u = -1;
                        return true;
                    case R.id.start:
                        MissionAdapter.this.f42245p.b(viewHolder.f42262k);
                        MissionAdapter.this.f42246q.b(MissionAdapter.this.f42245p.e(viewHolder.f42262k));
                        return true;
                    case R.id.view:
                        DownloadMission downloadMission = viewHolder.f42261j;
                        File file = new File(downloadMission.f42192d, downloadMission.f42190b);
                        if (file.exists()) {
                            MissionAdapter.this.C(viewHolder.f42265n.getText().toString(), viewHolder.f42274w, file, "");
                        } else {
                            Log.w("MissionAdapter", "File doesn't exist");
                        }
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void p(String str) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void q(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void r(String str) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void s(Throwable th) throws Exception {
    }

    public int getItemCount() {
        return this.f42245p.getCount();
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    /* renamed from: t */
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        DownloadMission e2 = this.f42245p.e(i2);
        viewHolder.f42261j = e2;
        viewHolder.f42262k = i2;
        viewHolder.f42274w = e2.f42196h;
        Utility.FileType f2 = Utility.f(e2.f42190b);
        viewHolder.f42264m.setImageResource(Utility.h(f2));
        viewHolder.f42265n.setText(e2.f42190b);
        viewHolder.f42266o.setText(Utility.c(e2.f42194f));
        ProgressDrawable progressDrawable = new ProgressDrawable(this.f42243n, Utility.e(f2), Utility.g(f2));
        viewHolder.f42269r = progressDrawable;
        ViewCompat.v0(viewHolder.f42267p, progressDrawable);
        MissionObserver missionObserver = new MissionObserver(this, viewHolder);
        viewHolder.f42270s = missionObserver;
        e2.c(missionObserver);
        A(viewHolder);
    }

    /* renamed from: u */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        final ViewHolder viewHolder = new ViewHolder(this.f42244o.inflate(this.f42247r, viewGroup, false));
        viewHolder.f42268q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MissionAdapter.this.o(viewHolder);
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (viewHolder.f42261j.f42203o) {
                    DownloadMission downloadMission = viewHolder.f42261j;
                    File file = new File(downloadMission.f42192d, downloadMission.f42190b);
                    if (file.exists()) {
                        MissionAdapter.this.C(viewHolder.f42265n.getText().toString(), viewHolder.f42274w, file, "");
                    } else {
                        Log.w("MissionAdapter", "File doesn't exist");
                    }
                }
            }
        });
        return viewHolder;
    }

    /* renamed from: v */
    public void onViewDetachedFromWindow(ViewHolder viewHolder) {
        this.f42250u.dispose();
        super.onViewDetachedFromWindow(viewHolder);
    }

    /* renamed from: w */
    public void onViewRecycled(ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        viewHolder.f42261j.r(viewHolder.f42270s);
        viewHolder.f42261j = null;
        viewHolder.f42270s = null;
        viewHolder.f42269r = null;
        viewHolder.f42262k = -1;
        viewHolder.f42271t = -1;
        viewHolder.f42272u = -1;
        viewHolder.f42273v = 0;
    }

    public void x(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7) {
        MovieInfo movieInfo = new MovieInfo(str, str2, str3, str4, str2);
        movieInfo.tmdbID = Long.valueOf(str5).longValue();
        movieInfo.imdbIDStr = str6;
        movieInfo.tempStreamLink = str7;
        y(movieInfo, false);
        z(movieInfo, true);
    }

    public void y(MovieInfo movieInfo, boolean z2) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(movieInfo.name);
        movieEntity.setRealeaseDate(movieInfo.year);
        ArrayList arrayList = new ArrayList();
        MediaSource mediaSource = new MediaSource("Local", "downloaded", false);
        mediaSource.setStreamLink(movieInfo.tempStreamLink);
        arrayList.add(mediaSource);
        if (z2) {
            movieEntity.setPosition(0);
        }
        this.f42249t.A(new PlayerHelper.PlayData(movieEntity, mediaSource, arrayList, (List<? extends SubtitleInfo>) null, movieInfo));
    }

    public void z(MovieInfo movieInfo, boolean z2) {
        boolean z3;
        TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
        tvWatchedEpisode.m(movieInfo.getEps().intValue());
        tvWatchedEpisode.q(movieInfo.getSession().intValue());
        tvWatchedEpisode.s(movieInfo.tmdbID);
        tvWatchedEpisode.o(movieInfo.imdbIDStr);
        tvWatchedEpisode.u(movieInfo.tvdbID);
        tvWatchedEpisode.t(movieInfo.traktID);
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImdbIDStr(movieInfo.imdbIDStr);
        movieEntity.setTmdbID(movieInfo.tmdbID);
        movieEntity.setTraktID(movieInfo.traktID);
        movieEntity.setTvdbID(movieInfo.tvdbID);
        movieEntity.setName(movieInfo.getName());
        String str = movieInfo.session;
        if (str == null || str.isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        movieEntity.setTV(Boolean.valueOf(z3));
        movieEntity.setGenres(movieInfo.genres);
        movieEntity.setRealeaseDate("1970-1-1");
        movieEntity.setWatched_at(OffsetDateTime.now((ZoneId) ZoneOffset.UTC));
        if (movieEntity.getTV().booleanValue()) {
            this.f42250u.b(this.f42248s.l(movieEntity, tvWatchedEpisode, z2, false).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(), new b()));
        } else {
            this.f42250u.b(this.f42248s.k(movieEntity, false).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c(), new d()));
        }
    }
}
