package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.exoplayer.hls.HlsDataSourceFactory;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.collect.Iterables;
import g.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {

    /* renamed from: q  reason: collision with root package name */
    public static final HlsPlaylistTracker.Factory f6468q = new a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final HlsDataSourceFactory f6469b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final HlsPlaylistParserFactory f6470c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final LoadErrorHandlingPolicy f6471d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Uri, MediaPlaylistBundle> f6472e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.PlaylistEventListener> f6473f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final double f6474g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public MediaSourceEventListener.EventDispatcher f6475h;

    /* renamed from: i  reason: collision with root package name */
    private Loader f6476i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Handler f6477j;

    /* renamed from: k  reason: collision with root package name */
    private HlsPlaylistTracker.PrimaryPlaylistListener f6478k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public HlsMultivariantPlaylist f6479l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Uri f6480m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public HlsMediaPlaylist f6481n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6482o;

    /* renamed from: p  reason: collision with root package name */
    private long f6483p;

    private class FirstPrimaryMediaPlaylistListener implements HlsPlaylistTracker.PlaylistEventListener {
        private FirstPrimaryMediaPlaylistListener() {
        }

        public void a() {
            DefaultHlsPlaylistTracker.this.f6473f.remove(this);
        }

        public boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
            MediaPlaylistBundle mediaPlaylistBundle;
            if (DefaultHlsPlaylistTracker.this.f6481n == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<HlsMultivariantPlaylist.Variant> list = ((HlsMultivariantPlaylist) Util.i(DefaultHlsPlaylistTracker.this.f6479l)).f6543e;
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.f6472e.get(list.get(i3).f6556a);
                    if (mediaPlaylistBundle2 != null && elapsedRealtime < mediaPlaylistBundle2.f6492i) {
                        i2++;
                    }
                }
                LoadErrorHandlingPolicy.FallbackSelection d2 = DefaultHlsPlaylistTracker.this.f6471d.d(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, DefaultHlsPlaylistTracker.this.f6479l.f6543e.size(), i2), loadErrorInfo);
                if (!(d2 == null || d2.f7526a != 2 || (mediaPlaylistBundle = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.f6472e.get(uri)) == null)) {
                    boolean unused = mediaPlaylistBundle.h(d2.f7527b);
                }
            }
            return false;
        }
    }

    private final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Uri f6485b;

        /* renamed from: c  reason: collision with root package name */
        private final Loader f6486c = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: d  reason: collision with root package name */
        private final DataSource f6487d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public HlsMediaPlaylist f6488e;

        /* renamed from: f  reason: collision with root package name */
        private long f6489f;

        /* renamed from: g  reason: collision with root package name */
        private long f6490g;

        /* renamed from: h  reason: collision with root package name */
        private long f6491h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public long f6492i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f6493j;

        /* renamed from: k  reason: collision with root package name */
        private IOException f6494k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f6495l;

        public MediaPlaylistBundle(Uri uri) {
            this.f6485b = uri;
            this.f6487d = DefaultHlsPlaylistTracker.this.f6469b.a(4);
        }

        /* access modifiers changed from: private */
        public boolean h(long j2) {
            this.f6492i = SystemClock.elapsedRealtime() + j2;
            if (!this.f6485b.equals(DefaultHlsPlaylistTracker.this.f6480m) || DefaultHlsPlaylistTracker.this.M()) {
                return false;
            }
            return true;
        }

        private Uri i() {
            String str;
            HlsMediaPlaylist hlsMediaPlaylist = this.f6488e;
            if (hlsMediaPlaylist != null) {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.f6517v;
                if (serverControl.f6536a != -9223372036854775807L || serverControl.f6540e) {
                    Uri.Builder buildUpon = this.f6485b.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.f6488e;
                    if (hlsMediaPlaylist2.f6517v.f6540e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hlsMediaPlaylist2.f6506k + ((long) hlsMediaPlaylist2.f6513r.size())));
                        HlsMediaPlaylist hlsMediaPlaylist3 = this.f6488e;
                        if (hlsMediaPlaylist3.f6509n != -9223372036854775807L) {
                            List<HlsMediaPlaylist.Part> list = hlsMediaPlaylist3.f6514s;
                            int size = list.size();
                            if (!list.isEmpty() && ((HlsMediaPlaylist.Part) Iterables.d(list)).f6519n) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    HlsMediaPlaylist.ServerControl serverControl2 = this.f6488e.f6517v;
                    if (serverControl2.f6536a != -9223372036854775807L) {
                        if (serverControl2.f6537b) {
                            str = "v2";
                        } else {
                            str = "YES";
                        }
                        buildUpon.appendQueryParameter("_HLS_skip", str);
                    }
                    return buildUpon.build();
                }
            }
            return this.f6485b;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(Uri uri) {
            this.f6493j = false;
            o(uri);
        }

        private void o(Uri uri) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.f6487d, uri, 4, DefaultHlsPlaylistTracker.this.f6470c.b(DefaultHlsPlaylistTracker.this.f6479l, this.f6488e));
            DefaultHlsPlaylistTracker.this.f6475h.y(new LoadEventInfo(parsingLoadable.f7552a, parsingLoadable.f7553b, this.f6486c.n(parsingLoadable, this, DefaultHlsPlaylistTracker.this.f6471d.a(parsingLoadable.f7554c))), parsingLoadable.f7554c);
        }

        /* access modifiers changed from: private */
        public void q(Uri uri) {
            this.f6492i = 0;
            if (!this.f6493j && !this.f6486c.j() && !this.f6486c.i()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.f6491h) {
                    this.f6493j = true;
                    DefaultHlsPlaylistTracker.this.f6477j.postDelayed(new a(this, uri), this.f6491h - elapsedRealtime);
                    return;
                }
                o(uri);
            }
        }

        /* access modifiers changed from: private */
        public void x(HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
            long j2;
            boolean z2;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.f6488e;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f6489f = elapsedRealtime;
            HlsMediaPlaylist r2 = DefaultHlsPlaylistTracker.this.G(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.f6488e = r2;
            IOException iOException = null;
            if (r2 != hlsMediaPlaylist2) {
                this.f6494k = null;
                this.f6490g = elapsedRealtime;
                DefaultHlsPlaylistTracker.this.S(this.f6485b, r2);
            } else if (!r2.f6510o) {
                HlsMediaPlaylist hlsMediaPlaylist3 = this.f6488e;
                if (hlsMediaPlaylist.f6506k + ((long) hlsMediaPlaylist.f6513r.size()) < hlsMediaPlaylist3.f6506k) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.f6485b);
                    z2 = true;
                } else {
                    z2 = false;
                    if (((double) (elapsedRealtime - this.f6490g)) > ((double) Util.t1(hlsMediaPlaylist3.f6508m)) * DefaultHlsPlaylistTracker.this.f6474g) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.f6485b);
                    }
                }
                if (iOException != null) {
                    this.f6494k = iOException;
                    boolean unused = DefaultHlsPlaylistTracker.this.O(this.f6485b, new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(4), iOException, 1), z2);
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist4 = this.f6488e;
            if (hlsMediaPlaylist4.f6517v.f6540e) {
                j2 = 0;
            } else if (hlsMediaPlaylist4 != hlsMediaPlaylist2) {
                j2 = hlsMediaPlaylist4.f6508m;
            } else {
                j2 = hlsMediaPlaylist4.f6508m / 2;
            }
            this.f6491h = (elapsedRealtime + Util.t1(j2)) - loadEventInfo.f6941f;
            if (this.f6488e.f6510o) {
                return;
            }
            if (this.f6485b.equals(DefaultHlsPlaylistTracker.this.f6480m) || this.f6495l) {
                q(i());
            }
        }

        public HlsMediaPlaylist j() {
            return this.f6488e;
        }

        public boolean k() {
            return this.f6495l;
        }

        public boolean l() {
            int i2;
            if (this.f6488e == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, Util.t1(this.f6488e.f6516u));
            HlsMediaPlaylist hlsMediaPlaylist = this.f6488e;
            if (hlsMediaPlaylist.f6510o || (i2 = hlsMediaPlaylist.f6499d) == 2 || i2 == 1 || this.f6489f + max > elapsedRealtime) {
                return true;
            }
            return false;
        }

        public void n(boolean z2) {
            q(z2 ? i() : this.f6485b);
        }

        public void r() throws IOException {
            this.f6486c.a();
            IOException iOException = this.f6494k;
            if (iOException != null) {
                throw iOException;
            }
        }

        /* renamed from: s */
        public void u(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z2) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
            DefaultHlsPlaylistTracker.this.f6471d.b(parsingLoadable2.f7552a);
            DefaultHlsPlaylistTracker.this.f6475h.p(loadEventInfo, 4);
        }

        /* renamed from: v */
        public void t(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            HlsPlaylist e2 = parsingLoadable.e();
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
            if (e2 instanceof HlsMediaPlaylist) {
                x((HlsMediaPlaylist) e2, loadEventInfo);
                DefaultHlsPlaylistTracker.this.f6475h.s(loadEventInfo, 4);
            } else {
                this.f6494k = ParserException.c("Loaded playlist has unexpected type.", (Throwable) null);
                DefaultHlsPlaylistTracker.this.f6475h.w(loadEventInfo, 4, this.f6494k, true);
            }
            DefaultHlsPlaylistTracker.this.f6471d.b(parsingLoadable2.f7552a);
        }

        /* renamed from: w */
        public Loader.LoadErrorAction p(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            boolean z2;
            Loader.LoadErrorAction loadErrorAction;
            int i3;
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            IOException iOException2 = iOException;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
            if (parsingLoadable.f().getQueryParameter("_HLS_msn") != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = iOException2 instanceof HlsPlaylistParser.DeltaUpdateException;
            if (z2 || z3) {
                if (iOException2 instanceof HttpDataSource$InvalidResponseCodeException) {
                    i3 = ((HttpDataSource$InvalidResponseCodeException) iOException2).f4892e;
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                if (z3 || i3 == 400 || i3 == 503) {
                    this.f6491h = SystemClock.elapsedRealtime();
                    n(false);
                    ((MediaSourceEventListener.EventDispatcher) Util.i(DefaultHlsPlaylistTracker.this.f6475h)).w(loadEventInfo, parsingLoadable2.f7554c, iOException2, true);
                    return Loader.f7534f;
                }
            }
            LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f7554c), iOException2, i2);
            if (DefaultHlsPlaylistTracker.this.O(this.f6485b, loadErrorInfo, false)) {
                long c2 = DefaultHlsPlaylistTracker.this.f6471d.c(loadErrorInfo);
                if (c2 != -9223372036854775807L) {
                    loadErrorAction = Loader.h(false, c2);
                } else {
                    loadErrorAction = Loader.f7535g;
                }
            } else {
                loadErrorAction = Loader.f7534f;
            }
            boolean c3 = true ^ loadErrorAction.c();
            DefaultHlsPlaylistTracker.this.f6475h.w(loadEventInfo, parsingLoadable2.f7554c, iOException2, c3);
            if (c3) {
                DefaultHlsPlaylistTracker.this.f6471d.b(parsingLoadable2.f7552a);
            }
            return loadErrorAction;
        }

        public void y() {
            this.f6486c.l();
        }

        public void z(boolean z2) {
            this.f6495l = z2;
        }
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5d);
    }

    private void E(List<Uri> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Uri uri = list.get(i2);
            this.f6472e.put(uri, new MediaPlaylistBundle(uri));
        }
    }

    private static HlsMediaPlaylist.Segment F(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i2 = (int) (hlsMediaPlaylist2.f6506k - hlsMediaPlaylist.f6506k);
        List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.f6513r;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public HlsMediaPlaylist G(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.f(hlsMediaPlaylist)) {
            return hlsMediaPlaylist2.c(I(hlsMediaPlaylist, hlsMediaPlaylist2), H(hlsMediaPlaylist, hlsMediaPlaylist2));
        }
        if (hlsMediaPlaylist2.f6510o) {
            return hlsMediaPlaylist.d();
        }
        return hlsMediaPlaylist;
    }

    private int H(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i2;
        HlsMediaPlaylist.Segment F;
        if (hlsMediaPlaylist2.f6504i) {
            return hlsMediaPlaylist2.f6505j;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f6481n;
        if (hlsMediaPlaylist3 != null) {
            i2 = hlsMediaPlaylist3.f6505j;
        } else {
            i2 = 0;
        }
        if (hlsMediaPlaylist == null || (F = F(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) {
            return i2;
        }
        return (hlsMediaPlaylist.f6505j + F.f6528e) - hlsMediaPlaylist2.f6513r.get(0).f6528e;
    }

    private long I(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        long j2;
        if (hlsMediaPlaylist2.f6511p) {
            return hlsMediaPlaylist2.f6503h;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f6481n;
        if (hlsMediaPlaylist3 != null) {
            j2 = hlsMediaPlaylist3.f6503h;
        } else {
            j2 = 0;
        }
        if (hlsMediaPlaylist == null) {
            return j2;
        }
        int size = hlsMediaPlaylist.f6513r.size();
        HlsMediaPlaylist.Segment F = F(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (F != null) {
            return hlsMediaPlaylist.f6503h + F.f6529f;
        }
        if (((long) size) == hlsMediaPlaylist2.f6506k - hlsMediaPlaylist.f6506k) {
            return hlsMediaPlaylist.e();
        }
        return j2;
    }

    private Uri J(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.f6481n;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.f6517v.f6540e || (renditionReport = hlsMediaPlaylist.f6515t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.f6521b));
        int i2 = renditionReport.f6522c;
        if (i2 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i2));
        }
        return buildUpon.build();
    }

    private boolean K(Uri uri) {
        List<HlsMultivariantPlaylist.Variant> list = this.f6479l.f6543e;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (uri.equals(list.get(i2).f6556a)) {
                return true;
            }
        }
        return false;
    }

    private void L(Uri uri) {
        MediaPlaylistBundle mediaPlaylistBundle = this.f6472e.get(uri);
        HlsMediaPlaylist j2 = mediaPlaylistBundle.j();
        if (!mediaPlaylistBundle.k()) {
            mediaPlaylistBundle.z(true);
            if (j2 != null && !j2.f6510o) {
                mediaPlaylistBundle.n(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean M() {
        List<HlsMultivariantPlaylist.Variant> list = this.f6479l.f6543e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) Assertions.f(this.f6472e.get(list.get(i2).f6556a));
            if (elapsedRealtime > mediaPlaylistBundle.f6492i) {
                Uri e2 = mediaPlaylistBundle.f6485b;
                this.f6480m = e2;
                mediaPlaylistBundle.q(J(e2));
                return true;
            }
        }
        return false;
    }

    private void N(Uri uri) {
        if (!uri.equals(this.f6480m) && K(uri)) {
            HlsMediaPlaylist hlsMediaPlaylist = this.f6481n;
            if (hlsMediaPlaylist == null || !hlsMediaPlaylist.f6510o) {
                this.f6480m = uri;
                MediaPlaylistBundle mediaPlaylistBundle = this.f6472e.get(uri);
                HlsMediaPlaylist g2 = mediaPlaylistBundle.f6488e;
                if (g2 == null || !g2.f6510o) {
                    mediaPlaylistBundle.q(J(uri));
                    return;
                }
                this.f6481n = g2;
                this.f6478k.h(g2);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean O(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it2 = this.f6473f.iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            z3 |= !it2.next().d(uri, loadErrorInfo, z2);
        }
        return z3;
    }

    /* access modifiers changed from: private */
    public void S(Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.f6480m)) {
            if (this.f6481n == null) {
                this.f6482o = !hlsMediaPlaylist.f6510o;
                this.f6483p = hlsMediaPlaylist.f6503h;
            }
            this.f6481n = hlsMediaPlaylist;
            this.f6478k.h(hlsMediaPlaylist);
        }
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it2 = this.f6473f.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: P */
    public void u(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z2) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f6471d.b(parsingLoadable2.f7552a);
        this.f6475h.p(loadEventInfo, 4);
    }

    /* renamed from: Q */
    public void t(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
        HlsMultivariantPlaylist hlsMultivariantPlaylist;
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        HlsPlaylist e2 = parsingLoadable.e();
        boolean z2 = e2 instanceof HlsMediaPlaylist;
        if (z2) {
            hlsMultivariantPlaylist = HlsMultivariantPlaylist.e(e2.f6562a);
        } else {
            hlsMultivariantPlaylist = (HlsMultivariantPlaylist) e2;
        }
        this.f6479l = hlsMultivariantPlaylist;
        this.f6480m = hlsMultivariantPlaylist.f6543e.get(0).f6556a;
        this.f6473f.add(new FirstPrimaryMediaPlaylistListener());
        E(hlsMultivariantPlaylist.f6542d);
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        MediaPlaylistBundle mediaPlaylistBundle = this.f6472e.get(this.f6480m);
        if (z2) {
            mediaPlaylistBundle.x((HlsMediaPlaylist) e2, loadEventInfo);
        } else {
            mediaPlaylistBundle.n(false);
        }
        this.f6471d.b(parsingLoadable2.f7552a);
        this.f6475h.s(loadEventInfo, 4);
    }

    /* renamed from: R */
    public Loader.LoadErrorAction p(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        long c2 = this.f6471d.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f7554c), iOException2, i2));
        if (c2 == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f6475h.w(loadEventInfo, parsingLoadable2.f7554c, iOException2, z2);
        if (z2) {
            this.f6471d.b(parsingLoadable2.f7552a);
        }
        if (z2) {
            return Loader.f7535g;
        }
        return Loader.h(false, c2);
    }

    public void a(Uri uri) throws IOException {
        this.f6472e.get(uri).r();
    }

    public long b() {
        return this.f6483p;
    }

    public HlsMultivariantPlaylist c() {
        return this.f6479l;
    }

    public void d(Uri uri) {
        this.f6472e.get(uri).n(true);
    }

    public boolean e(Uri uri) {
        return this.f6472e.get(uri).l();
    }

    public boolean f(Uri uri, long j2) {
        MediaPlaylistBundle mediaPlaylistBundle = this.f6472e.get(uri);
        if (mediaPlaylistBundle != null) {
            return !mediaPlaylistBundle.h(j2);
        }
        return false;
    }

    public void g() throws IOException {
        Loader loader = this.f6476i;
        if (loader != null) {
            loader.a();
        }
        Uri uri = this.f6480m;
        if (uri != null) {
            a(uri);
        }
    }

    public HlsMediaPlaylist h(Uri uri, boolean z2) {
        HlsMediaPlaylist j2 = this.f6472e.get(uri).j();
        if (j2 != null && z2) {
            N(uri);
            L(uri);
        }
        return j2;
    }

    public void i(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        boolean z2;
        this.f6477j = Util.A();
        this.f6475h = eventDispatcher;
        this.f6478k = primaryPlaylistListener;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f6469b.a(4), uri, 4, this.f6470c.a());
        if (this.f6476i == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f6476i = loader;
        eventDispatcher.y(new LoadEventInfo(parsingLoadable.f7552a, parsingLoadable.f7553b, loader.n(parsingLoadable, this, this.f6471d.a(parsingLoadable.f7554c))), parsingLoadable.f7554c);
    }

    public boolean isLive() {
        return this.f6482o;
    }

    public void j(Uri uri) {
        MediaPlaylistBundle mediaPlaylistBundle = this.f6472e.get(uri);
        if (mediaPlaylistBundle != null) {
            mediaPlaylistBundle.z(false);
        }
    }

    public void k(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.f6473f.remove(playlistEventListener);
    }

    public void l(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        Assertions.f(playlistEventListener);
        this.f6473f.add(playlistEventListener);
    }

    public void stop() {
        this.f6480m = null;
        this.f6481n = null;
        this.f6479l = null;
        this.f6483p = -9223372036854775807L;
        this.f6476i.l();
        this.f6476i = null;
        for (MediaPlaylistBundle y2 : this.f6472e.values()) {
            y2.y();
        }
        this.f6477j.removeCallbacksAndMessages((Object) null);
        this.f6477j = null;
        this.f6472e.clear();
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d2) {
        this.f6469b = hlsDataSourceFactory;
        this.f6470c = hlsPlaylistParserFactory;
        this.f6471d = loadErrorHandlingPolicy;
        this.f6474g = d2;
        this.f6473f = new CopyOnWriteArrayList<>();
        this.f6472e = new HashMap<>();
        this.f6483p = -9223372036854775807L;
    }
}
