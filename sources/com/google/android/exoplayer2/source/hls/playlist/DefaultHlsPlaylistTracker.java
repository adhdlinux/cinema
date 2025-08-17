package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p0.a;

public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {

    /* renamed from: q  reason: collision with root package name */
    public static final HlsPlaylistTracker.Factory f26552q = new a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final HlsDataSourceFactory f26553b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final HlsPlaylistParserFactory f26554c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final LoadErrorHandlingPolicy f26555d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Uri, MediaPlaylistBundle> f26556e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.PlaylistEventListener> f26557f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final double f26558g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public MediaSourceEventListener.EventDispatcher f26559h;

    /* renamed from: i  reason: collision with root package name */
    private Loader f26560i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Handler f26561j;

    /* renamed from: k  reason: collision with root package name */
    private HlsPlaylistTracker.PrimaryPlaylistListener f26562k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public HlsMultivariantPlaylist f26563l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Uri f26564m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public HlsMediaPlaylist f26565n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f26566o;

    /* renamed from: p  reason: collision with root package name */
    private long f26567p;

    private class FirstPrimaryMediaPlaylistListener implements HlsPlaylistTracker.PlaylistEventListener {
        private FirstPrimaryMediaPlaylistListener() {
        }

        public void a() {
            DefaultHlsPlaylistTracker.this.f26557f.remove(this);
        }

        public boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
            MediaPlaylistBundle mediaPlaylistBundle;
            if (DefaultHlsPlaylistTracker.this.f26565n == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<HlsMultivariantPlaylist.Variant> list = ((HlsMultivariantPlaylist) Util.j(DefaultHlsPlaylistTracker.this.f26563l)).f26626e;
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.f26556e.get(list.get(i3).f26639a);
                    if (mediaPlaylistBundle2 != null && elapsedRealtime < mediaPlaylistBundle2.f26576i) {
                        i2++;
                    }
                }
                LoadErrorHandlingPolicy.FallbackSelection d2 = DefaultHlsPlaylistTracker.this.f26555d.d(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, DefaultHlsPlaylistTracker.this.f26563l.f26626e.size(), i2), loadErrorInfo);
                if (!(d2 == null || d2.f28456a != 2 || (mediaPlaylistBundle = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.f26556e.get(uri)) == null)) {
                    boolean unused = mediaPlaylistBundle.h(d2.f28457b);
                }
            }
            return false;
        }
    }

    private final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Uri f26569b;

        /* renamed from: c  reason: collision with root package name */
        private final Loader f26570c = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: d  reason: collision with root package name */
        private final DataSource f26571d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public HlsMediaPlaylist f26572e;

        /* renamed from: f  reason: collision with root package name */
        private long f26573f;

        /* renamed from: g  reason: collision with root package name */
        private long f26574g;

        /* renamed from: h  reason: collision with root package name */
        private long f26575h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public long f26576i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f26577j;

        /* renamed from: k  reason: collision with root package name */
        private IOException f26578k;

        public MediaPlaylistBundle(Uri uri) {
            this.f26569b = uri;
            this.f26571d = DefaultHlsPlaylistTracker.this.f26553b.a(4);
        }

        /* access modifiers changed from: private */
        public boolean h(long j2) {
            this.f26576i = SystemClock.elapsedRealtime() + j2;
            if (!this.f26569b.equals(DefaultHlsPlaylistTracker.this.f26564m) || DefaultHlsPlaylistTracker.this.K()) {
                return false;
            }
            return true;
        }

        private Uri i() {
            String str;
            HlsMediaPlaylist hlsMediaPlaylist = this.f26572e;
            if (hlsMediaPlaylist != null) {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.f26600v;
                if (serverControl.f26619a != -9223372036854775807L || serverControl.f26623e) {
                    Uri.Builder buildUpon = this.f26569b.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.f26572e;
                    if (hlsMediaPlaylist2.f26600v.f26623e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hlsMediaPlaylist2.f26589k + ((long) hlsMediaPlaylist2.f26596r.size())));
                        HlsMediaPlaylist hlsMediaPlaylist3 = this.f26572e;
                        if (hlsMediaPlaylist3.f26592n != -9223372036854775807L) {
                            List<HlsMediaPlaylist.Part> list = hlsMediaPlaylist3.f26597s;
                            int size = list.size();
                            if (!list.isEmpty() && ((HlsMediaPlaylist.Part) Iterables.d(list)).f26602n) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    HlsMediaPlaylist.ServerControl serverControl2 = this.f26572e.f26600v;
                    if (serverControl2.f26619a != -9223372036854775807L) {
                        if (serverControl2.f26620b) {
                            str = "v2";
                        } else {
                            str = "YES";
                        }
                        buildUpon.appendQueryParameter("_HLS_skip", str);
                    }
                    return buildUpon.build();
                }
            }
            return this.f26569b;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(Uri uri) {
            this.f26577j = false;
            n(uri);
        }

        private void n(Uri uri) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.f26571d, uri, 4, DefaultHlsPlaylistTracker.this.f26554c.b(DefaultHlsPlaylistTracker.this.f26563l, this.f26572e));
            DefaultHlsPlaylistTracker.this.f26559h.z(new LoadEventInfo(parsingLoadable.f28482a, parsingLoadable.f28483b, this.f26570c.n(parsingLoadable, this, DefaultHlsPlaylistTracker.this.f26555d.a(parsingLoadable.f28484c))), parsingLoadable.f28484c);
        }

        /* access modifiers changed from: private */
        public void o(Uri uri) {
            this.f26576i = 0;
            if (!this.f26577j && !this.f26570c.j() && !this.f26570c.i()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.f26575h) {
                    this.f26577j = true;
                    DefaultHlsPlaylistTracker.this.f26561j.postDelayed(new a(this, uri), this.f26575h - elapsedRealtime);
                    return;
                }
                n(uri);
            }
        }

        /* access modifiers changed from: private */
        public void w(HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
            long j2;
            boolean z2;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.f26572e;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f26573f = elapsedRealtime;
            HlsMediaPlaylist r2 = DefaultHlsPlaylistTracker.this.F(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.f26572e = r2;
            boolean z3 = false;
            IOException iOException = null;
            if (r2 != hlsMediaPlaylist2) {
                this.f26578k = null;
                this.f26574g = elapsedRealtime;
                DefaultHlsPlaylistTracker.this.Q(this.f26569b, r2);
            } else if (!r2.f26593o) {
                HlsMediaPlaylist hlsMediaPlaylist3 = this.f26572e;
                if (hlsMediaPlaylist.f26589k + ((long) hlsMediaPlaylist.f26596r.size()) < hlsMediaPlaylist3.f26589k) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.f26569b);
                    z2 = true;
                } else {
                    if (((double) (elapsedRealtime - this.f26574g)) > ((double) Util.i1(hlsMediaPlaylist3.f26591m)) * DefaultHlsPlaylistTracker.this.f26558g) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.f26569b);
                    }
                    z2 = false;
                }
                if (iOException != null) {
                    this.f26578k = iOException;
                    boolean unused = DefaultHlsPlaylistTracker.this.M(this.f26569b, new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(4), iOException, 1), z2);
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist4 = this.f26572e;
            if (hlsMediaPlaylist4.f26600v.f26623e) {
                j2 = 0;
            } else if (hlsMediaPlaylist4 != hlsMediaPlaylist2) {
                j2 = hlsMediaPlaylist4.f26591m;
            } else {
                j2 = hlsMediaPlaylist4.f26591m / 2;
            }
            this.f26575h = elapsedRealtime + Util.i1(j2);
            if (this.f26572e.f26592n != -9223372036854775807L || this.f26569b.equals(DefaultHlsPlaylistTracker.this.f26564m)) {
                z3 = true;
            }
            if (z3 && !this.f26572e.f26593o) {
                o(i());
            }
        }

        public HlsMediaPlaylist j() {
            return this.f26572e;
        }

        public boolean k() {
            int i2;
            if (this.f26572e == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, Util.i1(this.f26572e.f26599u));
            HlsMediaPlaylist hlsMediaPlaylist = this.f26572e;
            if (hlsMediaPlaylist.f26593o || (i2 = hlsMediaPlaylist.f26582d) == 2 || i2 == 1 || this.f26573f + max > elapsedRealtime) {
                return true;
            }
            return false;
        }

        public void m() {
            o(this.f26569b);
        }

        public void r() throws IOException {
            this.f26570c.a();
            IOException iOException = this.f26578k;
            if (iOException != null) {
                throw iOException;
            }
        }

        /* renamed from: s */
        public void p(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z2) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
            DefaultHlsPlaylistTracker.this.f26555d.b(parsingLoadable2.f28482a);
            DefaultHlsPlaylistTracker.this.f26559h.q(loadEventInfo, 4);
        }

        /* renamed from: u */
        public void q(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            HlsPlaylist e2 = parsingLoadable.e();
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
            if (e2 instanceof HlsMediaPlaylist) {
                w((HlsMediaPlaylist) e2, loadEventInfo);
                DefaultHlsPlaylistTracker.this.f26559h.t(loadEventInfo, 4);
            } else {
                this.f26578k = ParserException.c("Loaded playlist has unexpected type.", (Throwable) null);
                DefaultHlsPlaylistTracker.this.f26559h.x(loadEventInfo, 4, this.f26578k, true);
            }
            DefaultHlsPlaylistTracker.this.f26555d.b(parsingLoadable2.f28482a);
        }

        /* renamed from: v */
        public Loader.LoadErrorAction t(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            boolean z2;
            Loader.LoadErrorAction loadErrorAction;
            int i3;
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            IOException iOException2 = iOException;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
            if (parsingLoadable.f().getQueryParameter("_HLS_msn") != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = iOException2 instanceof HlsPlaylistParser.DeltaUpdateException;
            if (z2 || z3) {
                if (iOException2 instanceof HttpDataSource$InvalidResponseCodeException) {
                    i3 = ((HttpDataSource$InvalidResponseCodeException) iOException2).f28444e;
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                if (z3 || i3 == 400 || i3 == 503) {
                    this.f26575h = SystemClock.elapsedRealtime();
                    m();
                    ((MediaSourceEventListener.EventDispatcher) Util.j(DefaultHlsPlaylistTracker.this.f26559h)).x(loadEventInfo, parsingLoadable2.f28484c, iOException2, true);
                    return Loader.f28464f;
                }
            }
            LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f28484c), iOException2, i2);
            if (DefaultHlsPlaylistTracker.this.M(this.f26569b, loadErrorInfo, false)) {
                long c2 = DefaultHlsPlaylistTracker.this.f26555d.c(loadErrorInfo);
                if (c2 != -9223372036854775807L) {
                    loadErrorAction = Loader.h(false, c2);
                } else {
                    loadErrorAction = Loader.f28465g;
                }
            } else {
                loadErrorAction = Loader.f28464f;
            }
            boolean c3 = true ^ loadErrorAction.c();
            DefaultHlsPlaylistTracker.this.f26559h.x(loadEventInfo, parsingLoadable2.f28484c, iOException2, c3);
            if (c3) {
                DefaultHlsPlaylistTracker.this.f26555d.b(parsingLoadable2.f28482a);
            }
            return loadErrorAction;
        }

        public void x() {
            this.f26570c.l();
        }
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5d);
    }

    private void D(List<Uri> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Uri uri = list.get(i2);
            this.f26556e.put(uri, new MediaPlaylistBundle(uri));
        }
    }

    private static HlsMediaPlaylist.Segment E(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i2 = (int) (hlsMediaPlaylist2.f26589k - hlsMediaPlaylist.f26589k);
        List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.f26596r;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public HlsMediaPlaylist F(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.f(hlsMediaPlaylist)) {
            return hlsMediaPlaylist2.c(H(hlsMediaPlaylist, hlsMediaPlaylist2), G(hlsMediaPlaylist, hlsMediaPlaylist2));
        }
        if (hlsMediaPlaylist2.f26593o) {
            return hlsMediaPlaylist.d();
        }
        return hlsMediaPlaylist;
    }

    private int G(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i2;
        HlsMediaPlaylist.Segment E;
        if (hlsMediaPlaylist2.f26587i) {
            return hlsMediaPlaylist2.f26588j;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f26565n;
        if (hlsMediaPlaylist3 != null) {
            i2 = hlsMediaPlaylist3.f26588j;
        } else {
            i2 = 0;
        }
        if (hlsMediaPlaylist == null || (E = E(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) {
            return i2;
        }
        return (hlsMediaPlaylist.f26588j + E.f26611e) - hlsMediaPlaylist2.f26596r.get(0).f26611e;
    }

    private long H(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        long j2;
        if (hlsMediaPlaylist2.f26594p) {
            return hlsMediaPlaylist2.f26586h;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f26565n;
        if (hlsMediaPlaylist3 != null) {
            j2 = hlsMediaPlaylist3.f26586h;
        } else {
            j2 = 0;
        }
        if (hlsMediaPlaylist == null) {
            return j2;
        }
        int size = hlsMediaPlaylist.f26596r.size();
        HlsMediaPlaylist.Segment E = E(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (E != null) {
            return hlsMediaPlaylist.f26586h + E.f26612f;
        }
        if (((long) size) == hlsMediaPlaylist2.f26589k - hlsMediaPlaylist.f26589k) {
            return hlsMediaPlaylist.e();
        }
        return j2;
    }

    private Uri I(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.f26565n;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.f26600v.f26623e || (renditionReport = hlsMediaPlaylist.f26598t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.f26604b));
        int i2 = renditionReport.f26605c;
        if (i2 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i2));
        }
        return buildUpon.build();
    }

    private boolean J(Uri uri) {
        List<HlsMultivariantPlaylist.Variant> list = this.f26563l.f26626e;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (uri.equals(list.get(i2).f26639a)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean K() {
        List<HlsMultivariantPlaylist.Variant> list = this.f26563l.f26626e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) Assertions.e(this.f26556e.get(list.get(i2).f26639a));
            if (elapsedRealtime > mediaPlaylistBundle.f26576i) {
                Uri e2 = mediaPlaylistBundle.f26569b;
                this.f26564m = e2;
                mediaPlaylistBundle.o(I(e2));
                return true;
            }
        }
        return false;
    }

    private void L(Uri uri) {
        if (!uri.equals(this.f26564m) && J(uri)) {
            HlsMediaPlaylist hlsMediaPlaylist = this.f26565n;
            if (hlsMediaPlaylist == null || !hlsMediaPlaylist.f26593o) {
                this.f26564m = uri;
                MediaPlaylistBundle mediaPlaylistBundle = this.f26556e.get(uri);
                HlsMediaPlaylist g2 = mediaPlaylistBundle.f26572e;
                if (g2 == null || !g2.f26593o) {
                    mediaPlaylistBundle.o(I(uri));
                    return;
                }
                this.f26565n = g2;
                this.f26562k.h(g2);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean M(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it2 = this.f26557f.iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            z3 |= !it2.next().d(uri, loadErrorInfo, z2);
        }
        return z3;
    }

    /* access modifiers changed from: private */
    public void Q(Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.f26564m)) {
            if (this.f26565n == null) {
                this.f26566o = !hlsMediaPlaylist.f26593o;
                this.f26567p = hlsMediaPlaylist.f26586h;
            }
            this.f26565n = hlsMediaPlaylist;
            this.f26562k.h(hlsMediaPlaylist);
        }
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it2 = this.f26557f.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: N */
    public void p(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z2) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f26555d.b(parsingLoadable2.f28482a);
        this.f26559h.q(loadEventInfo, 4);
    }

    /* renamed from: O */
    public void q(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
        HlsMultivariantPlaylist hlsMultivariantPlaylist;
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        HlsPlaylist e2 = parsingLoadable.e();
        boolean z2 = e2 instanceof HlsMediaPlaylist;
        if (z2) {
            hlsMultivariantPlaylist = HlsMultivariantPlaylist.e(e2.f26645a);
        } else {
            hlsMultivariantPlaylist = (HlsMultivariantPlaylist) e2;
        }
        this.f26563l = hlsMultivariantPlaylist;
        this.f26564m = hlsMultivariantPlaylist.f26626e.get(0).f26639a;
        this.f26557f.add(new FirstPrimaryMediaPlaylistListener());
        D(hlsMultivariantPlaylist.f26625d);
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        MediaPlaylistBundle mediaPlaylistBundle = this.f26556e.get(this.f26564m);
        if (z2) {
            mediaPlaylistBundle.w((HlsMediaPlaylist) e2, loadEventInfo);
        } else {
            mediaPlaylistBundle.m();
        }
        this.f26555d.b(parsingLoadable2.f28482a);
        this.f26559h.t(loadEventInfo, 4);
    }

    /* renamed from: P */
    public Loader.LoadErrorAction t(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        long c2 = this.f26555d.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f28484c), iOException2, i2));
        if (c2 == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f26559h.x(loadEventInfo, parsingLoadable2.f28484c, iOException2, z2);
        if (z2) {
            this.f26555d.b(parsingLoadable2.f28482a);
        }
        if (z2) {
            return Loader.f28465g;
        }
        return Loader.h(false, c2);
    }

    public void a(Uri uri) throws IOException {
        this.f26556e.get(uri).r();
    }

    public long b() {
        return this.f26567p;
    }

    public HlsMultivariantPlaylist c() {
        return this.f26563l;
    }

    public void d(Uri uri) {
        this.f26556e.get(uri).m();
    }

    public boolean e(Uri uri) {
        return this.f26556e.get(uri).k();
    }

    public boolean f(Uri uri, long j2) {
        MediaPlaylistBundle mediaPlaylistBundle = this.f26556e.get(uri);
        if (mediaPlaylistBundle != null) {
            return !mediaPlaylistBundle.h(j2);
        }
        return false;
    }

    public void g() throws IOException {
        Loader loader = this.f26560i;
        if (loader != null) {
            loader.a();
        }
        Uri uri = this.f26564m;
        if (uri != null) {
            a(uri);
        }
    }

    public HlsMediaPlaylist h(Uri uri, boolean z2) {
        HlsMediaPlaylist j2 = this.f26556e.get(uri).j();
        if (j2 != null && z2) {
            L(uri);
        }
        return j2;
    }

    public void i(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.f26557f.remove(playlistEventListener);
    }

    public boolean isLive() {
        return this.f26566o;
    }

    public void j(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        Assertions.e(playlistEventListener);
        this.f26557f.add(playlistEventListener);
    }

    public void k(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        boolean z2;
        this.f26561j = Util.w();
        this.f26559h = eventDispatcher;
        this.f26562k = primaryPlaylistListener;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f26553b.a(4), uri, 4, this.f26554c.a());
        if (this.f26560i == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f26560i = loader;
        eventDispatcher.z(new LoadEventInfo(parsingLoadable.f28482a, parsingLoadable.f28483b, loader.n(parsingLoadable, this, this.f26555d.a(parsingLoadable.f28484c))), parsingLoadable.f28484c);
    }

    public void stop() {
        this.f26564m = null;
        this.f26565n = null;
        this.f26563l = null;
        this.f26567p = -9223372036854775807L;
        this.f26560i.l();
        this.f26560i = null;
        for (MediaPlaylistBundle x2 : this.f26556e.values()) {
            x2.x();
        }
        this.f26561j.removeCallbacksAndMessages((Object) null);
        this.f26561j = null;
        this.f26556e.clear();
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d2) {
        this.f26553b = hlsDataSourceFactory;
        this.f26554c = hlsPlaylistParserFactory;
        this.f26555d = loadErrorHandlingPolicy;
        this.f26558g = d2;
        this.f26557f = new CopyOnWriteArrayList<>();
        this.f26556e = new HashMap<>();
        this.f26567p = -9223372036854775807L;
    }
}
