package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.alldebrid.AllDebridUserApi;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeUserApi;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Resolver.BaseResolver;
import com.utils.PrefUtils;
import com.utils.Utils;
import com.uwetrottmann.trakt5.TraktV2;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public abstract class BaseProvider {

    /* renamed from: c  reason: collision with root package name */
    public static BaseProvider[] f37247c = {new SmashyWebview(), new Smashystream(), new ZeroTV(), new RemoteJS(), new Hd4movies(), new Hd3movies(), new Hd2movies(), new Afdah(), new Ridomovies(), new Kidomovies(), new M4UFree(), new SeeHD(), new XMovies8(), new Filmxy(), new PFTV(), new MyWS(), new Movie25V2(), new DayT(), new PLockerSK(), new WatchEpisodes(), new MiraDeTodo(), new PrimeWire(), new TV21(), new YesMovies(), new SolarMoviez(), new VexMovies(), new BobMovies(), new TheYM(), new Wawani(), new Pubfilm(), new AnimeShow(), new Cokepopcorn(), new FliXanityBased(), new dunia21(), new bioskopkeren(), new Fmovies(), new Hdpopcorns(), new OneMovie(), new NovaMovie(), new GoFilms4u(), new Hdmega(), new ReleaseBB(), new ScnSrc(), new TwoDDL(), new WrzCraft(), new DDLValley(), new YesGG(), new SpaceMov(), new GoGoAnime(), new TTMediatv(), new FmovieCloud(), new SeriesNine(), new Sezonlukdizi(), new GoGoMovies(), new DDLTV(), new WatchSeries(), new Vidics(), new AfdahTV(), new NTMovies(), new GoMovies(), new OnePutlocker(), new SwatchSeries(), new TwoPutlocker(), new Dizigold(), new OdbMovies(), new FFilms(), new Dizist(), new Dizilab(), new VioozGo(), new AZMovies(), new TopEuroPix(), new MovieFileHD(), new ClickMovies(), new DaxivMovies(), new Cinema(), new WatchMovieHD(), new BestFlix(), new LordMovies(), new CloudMovies(), new MovieGL(), new WorldUS(), new BestTvFix(), new BestFilms(), new CMovies(), new PHMovies(), new WatchFMovies(), new VidTv(), new KKMovies(), new OneLMovie(), new CDNRelease(), new MoviesDBZar(), new TYSee(), new AnimeTop(), new Cartoon(), new OneEMovie(), new Hd5movies(), new QQMovies(), new DLLLink(), new AllRelease(), new YSMovies(), new Vliver(), new ExtraWiki(), new FixOne(), new Crackle(), new SRLS(), new CBB(), new KRMovies(), new HD7Movies(), new T1337x(), new TTPB(), new Torrent4k(), new KickassTorrents(), new Eztv(), new Rarbg(), new Zooqle(), new Magnetdl(), new LIME(), new YTS(), new Torlock(), new Torrentdownload(), new Torrentgalaxy(), new BitTorrent(), new Kisscartoon()};

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<String, Integer> f37248d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    protected int f37249a = 10;

    /* renamed from: b  reason: collision with root package name */
    private String[] f37250b;

    public static HashMap<String, String> E(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Element r02 = Jsoup.b(str).r0("form[action]");
            String c2 = r02.c("action");
            if (c2.isEmpty()) {
                return hashMap;
            }
            if (c2.startsWith("/")) {
                c2 = str2 + c2;
            } else if (!c2.contains(UriUtil.HTTP_SCHEME)) {
                c2 = str2 + "/" + c2;
            }
            hashMap.put(ImagesContract.URL, c2);
            String str3 = "";
            Iterator it2 = r02.q0("input").iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                String c3 = element.c("type");
                String c4 = element.c(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String c5 = element.c("name");
                if (c3.equalsIgnoreCase(ViewProps.HIDDEN)) {
                    str3 = str3 + c5 + "=" + c4;
                }
                if (c3.equalsIgnoreCase("text") || c3.equalsIgnoreCase("search")) {
                    str3 = str3 + c5 + "=%s";
                }
                if (!c3.equalsIgnoreCase("submit")) {
                    if (it2.hasNext()) {
                        str3 = str3 + "&";
                    }
                }
            }
            if (str3.endsWith("&")) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            hashMap.put("body", str3);
            return hashMap;
        } catch (Throwable unused) {
        }
    }

    public static void G() {
        PrefUtils.n(Utils.v(), f37248d);
    }

    public static final void H() {
        Logger.a("setuppremium");
        RealDebridCredentialsHelper.d();
        AllDebridCredentialsHelper.b();
        RealDebridCredentialsHelper.a();
        PremiumizeCredentialsHelper.b().isValid();
        AllDebridUserApi.d().a();
        PremiumizeUserApi.c().a();
    }

    public static List<BaseProvider> I(List<BaseProvider> list) {
        Collections.sort(list, new a());
        return list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        return new java.lang.String(android.util.Base64.decode(r4, 0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        return r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x000d }
            byte[] r2 = android.util.Base64.decode(r4, r0)     // Catch:{ Exception -> 0x000d }
            java.lang.String r3 = "UTF-8"
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x000d }
            return r1
        L_0x000d:
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x0017 }
            byte[] r0 = android.util.Base64.decode(r4, r0)     // Catch:{ Exception -> 0x0017 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0017 }
            return r1
        L_0x0017:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.BaseProvider.d(java.lang.String):java.lang.String");
    }

    public static void e(String str) {
        if (f37248d.containsKey(str)) {
            f37248d.put(str, Integer.valueOf(f37248d.get(str).intValue() + 1));
        } else {
            f37248d.put(str, 1);
        }
    }

    public static String i(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String j(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + "://" + url.getHost();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String k(String str, String str2) {
        try {
            Element r02 = Jsoup.b(str).r0("form[action]");
            String c2 = r02.c("action");
            if (c2.isEmpty()) {
                return "";
            }
            if (c2.startsWith("/")) {
                c2 = str2 + c2;
            } else if (!c2.contains(UriUtil.HTTP_SCHEME)) {
                c2 = str2 + "/" + c2;
            }
            String str3 = c2 + "?";
            Iterator it2 = r02.q0("input").iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                String c3 = element.c("type");
                String c4 = element.c(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String c5 = element.c("name");
                if (c3.equalsIgnoreCase(ViewProps.HIDDEN)) {
                    str3 = str3 + c5 + "=" + c4;
                }
                if (c3.equalsIgnoreCase("text") || c3.equalsIgnoreCase("search")) {
                    str3 = str3 + c5 + "=%s";
                }
                if (!c3.equalsIgnoreCase("submit")) {
                    if (it2.hasNext()) {
                        str3 = str3 + "&";
                    }
                }
            }
            if (str3.endsWith("&")) {
                return str3.substring(0, str3.length() - 1);
            }
            return str3;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int r(BaseProvider baseProvider, BaseProvider baseProvider2) {
        boolean z2;
        int i2;
        int i3;
        if (RealDebridCredentialsHelper.d().isValid() || AllDebridCredentialsHelper.b().isValid() || PremiumizeCredentialsHelper.b().isValid()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i2 = baseProvider.m();
        } else {
            i2 = 0;
        }
        if (z2) {
            i3 = baseProvider2.m();
        } else {
            i3 = 0;
        }
        if (f37248d.containsKey(baseProvider.A())) {
            i2 = f37248d.get(baseProvider.A()).intValue();
        }
        if (f37248d.containsKey(baseProvider2.A())) {
            i3 = f37248d.get(baseProvider2.A()).intValue();
        }
        if (i2 == i3) {
            return 0;
        }
        if (i2 > i3) {
            return -1;
        }
        return 1;
    }

    public static void s() {
        f37248d = PrefUtils.k(Utils.v());
    }

    public static final boolean v() {
        if ((!RealDebridCredentialsHelper.d().isValid() || RealDebridCredentialsHelper.c()) && ((!AllDebridCredentialsHelper.b().isValid() || !AllDebridUserApi.d().b()) && (!PremiumizeCredentialsHelper.b().isValid() || !PremiumizeUserApi.c().b()))) {
            return false;
        }
        return true;
    }

    public abstract String A();

    /* access modifiers changed from: protected */
    public abstract void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException;

    public void C(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
    }

    /* access modifiers changed from: protected */
    public abstract void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException;

    public Observable<MediaSource> F(final MovieInfo movieInfo) {
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                try {
                    MovieInfo clone = movieInfo.clone();
                    if (clone.session.isEmpty()) {
                        BaseProvider.this.B(clone, observableEmitter);
                    } else {
                        BaseProvider.this.D(clone, observableEmitter);
                    }
                } catch (Exception e2) {
                    Logger.b("BaseProvider", e2.getMessage());
                }
                observableEmitter.onComplete();
            }
        });
    }

    public boolean f(List<String> list) {
        return list.contains("Animation");
    }

    public final boolean g(String str) {
        String[] strArr;
        try {
            str = new URL(str).getHost();
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
        try {
            if (str.isEmpty() || str.equals("thepiratebay.org") || str.equals("protected.to") || str.equals("thetvdb.com") || str.equals("extratorrent.cc") || str.equals("imdb.com")) {
                return false;
            }
            if (this.f37250b == null) {
                this.f37250b = BaseResolver.f();
                if (v()) {
                    this.f37250b = com.original.tase.utils.Utils.p(this.f37250b, BaseResolver.e());
                }
            }
            if (Utils.f37611d) {
                strArr = BaseResolver.e();
            } else {
                strArr = this.f37250b;
            }
            for (String str2 : strArr) {
                if (TitleHelper.f(str).contains(TitleHelper.f(str2)) || TitleHelper.f(str2).contains(TitleHelper.f(str))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0090, code lost:
        r4 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22, boolean... r23) {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r22
            r6 = r23
            boolean r7 = r20.isEmpty()     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x014c
            boolean r7 = r16.isDisposed()     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x014c
            java.lang.String r7 = "thepiratebay.org"
            boolean r7 = r4.equals(r7)     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x014c
            java.lang.String r7 = "protected.to"
            boolean r7 = r4.equals(r7)     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x014c
            java.lang.String r7 = "thetvdb.com"
            boolean r7 = r4.equals(r7)     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x014c
            java.lang.String r7 = "extratorrent.cc"
            boolean r7 = r4.equals(r7)     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x014c
            java.lang.String r7 = "imdb.com"
            boolean r7 = r4.equals(r7)     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x014c
            java.lang.String[] r7 = r0.f37250b     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x005d
            java.lang.String[] r7 = com.utils.Getlink.Resolver.BaseResolver.f()     // Catch:{ Exception -> 0x014c }
            r0.f37250b = r7     // Catch:{ Exception -> 0x014c }
            boolean r7 = v()     // Catch:{ Exception -> 0x014c }
            if (r7 == 0) goto L_0x005d
            java.lang.String[] r7 = r0.f37250b     // Catch:{ Exception -> 0x014c }
            java.lang.String[] r8 = com.utils.Getlink.Resolver.BaseResolver.e()     // Catch:{ Exception -> 0x014c }
            java.lang.String[] r7 = com.original.tase.utils.Utils.p(r7, r8)     // Catch:{ Exception -> 0x014c }
            r0.f37250b = r7     // Catch:{ Exception -> 0x014c }
        L_0x005d:
            boolean r7 = com.utils.Utils.f37611d     // Catch:{ Exception -> 0x014c }
            if (r7 == 0) goto L_0x0066
            java.lang.String[] r7 = com.utils.Getlink.Resolver.BaseResolver.e()     // Catch:{ Exception -> 0x014c }
            goto L_0x0068
        L_0x0066:
            java.lang.String[] r7 = r0.f37250b     // Catch:{ Exception -> 0x014c }
        L_0x0068:
            int r8 = r7.length     // Catch:{ Exception -> 0x014c }
            r9 = 0
            r10 = 0
        L_0x006b:
            r11 = 1
            if (r10 >= r8) goto L_0x0092
            r12 = r7[r10]     // Catch:{ Exception -> 0x014c }
            java.lang.String r13 = com.original.tase.helper.TitleHelper.f(r20)     // Catch:{ Exception -> 0x014c }
            java.lang.String r14 = com.original.tase.helper.TitleHelper.f(r12)     // Catch:{ Exception -> 0x014c }
            boolean r13 = r13.contains(r14)     // Catch:{ Exception -> 0x014c }
            if (r13 != 0) goto L_0x0090
            java.lang.String r12 = com.original.tase.helper.TitleHelper.f(r12)     // Catch:{ Exception -> 0x014c }
            java.lang.String r13 = com.original.tase.helper.TitleHelper.f(r20)     // Catch:{ Exception -> 0x014c }
            boolean r12 = r12.contains(r13)     // Catch:{ Exception -> 0x014c }
            if (r12 == 0) goto L_0x008d
            goto L_0x0090
        L_0x008d:
            int r10 = r10 + 1
            goto L_0x006b
        L_0x0090:
            r4 = 1
            goto L_0x0093
        L_0x0092:
            r4 = 0
        L_0x0093:
            boolean r7 = com.utils.Utils.f37609b     // Catch:{ Exception -> 0x014c }
            java.lang.String r8 = " "
            if (r7 == 0) goto L_0x00d4
            if (r4 == 0) goto L_0x00d4
            boolean r4 = r15.q(r2)     // Catch:{ Exception -> 0x014c }
            if (r4 == 0) goto L_0x00bc
            if (r21 != 0) goto L_0x00bc
            java.lang.String r4 = "pref_show_hd_only true: "
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r7.<init>()     // Catch:{ Exception -> 0x014c }
            r7.append(r2)     // Catch:{ Exception -> 0x014c }
            r7.append(r8)     // Catch:{ Exception -> 0x014c }
            r7.append(r3)     // Catch:{ Exception -> 0x014c }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x014c }
            com.original.tase.Logger.b(r4, r7)     // Catch:{ Exception -> 0x014c }
            r4 = 1
            goto L_0x00d4
        L_0x00bc:
            java.lang.String r4 = "pref_show_hd_only false: "
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r7.<init>()     // Catch:{ Exception -> 0x014c }
            r7.append(r2)     // Catch:{ Exception -> 0x014c }
            r7.append(r8)     // Catch:{ Exception -> 0x014c }
            r7.append(r3)     // Catch:{ Exception -> 0x014c }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x014c }
            com.original.tase.Logger.b(r4, r7)     // Catch:{ Exception -> 0x014c }
            r4 = 0
        L_0x00d4:
            if (r4 == 0) goto L_0x0131
            if (r2 == 0) goto L_0x00de
            boolean r4 = r18.isEmpty()     // Catch:{ Exception -> 0x014c }
            if (r4 == 0) goto L_0x00e0
        L_0x00de:
            java.lang.String r2 = ""
        L_0x00e0:
            if (r21 == 0) goto L_0x00f7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r3.<init>()     // Catch:{ Exception -> 0x014c }
            java.lang.String r4 = r15.A()     // Catch:{ Exception -> 0x014c }
            r3.append(r4)     // Catch:{ Exception -> 0x014c }
            java.lang.String r4 = " (CAM)"
            r3.append(r4)     // Catch:{ Exception -> 0x014c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x014c }
        L_0x00f7:
            com.original.tase.model.media.MediaSource r4 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x014c }
            r4.<init>(r3, r2, r11)     // Catch:{ Exception -> 0x014c }
            if (r6 == 0) goto L_0x0110
            int r3 = r6.length     // Catch:{ Exception -> 0x014c }
            if (r3 != r11) goto L_0x0107
            boolean r3 = r6[r9]     // Catch:{ Exception -> 0x014c }
            r4.setCachedLink(r3)     // Catch:{ Exception -> 0x014c }
            goto L_0x0110
        L_0x0107:
            int r3 = r6.length     // Catch:{ Exception -> 0x014c }
            r7 = 2
            if (r3 != r7) goto L_0x0110
            boolean r3 = r6[r11]     // Catch:{ Exception -> 0x014c }
            r4.setNeedToSync(r3)     // Catch:{ Exception -> 0x014c }
        L_0x0110:
            if (r5 == 0) goto L_0x0125
            boolean r3 = r22.isEmpty()     // Catch:{ Exception -> 0x014c }
            if (r3 != 0) goto L_0x0125
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x014c }
            r3.<init>()     // Catch:{ Exception -> 0x014c }
            java.lang.String r6 = "referer"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x014c }
            r4.setPlayHeader(r3)     // Catch:{ Exception -> 0x014c }
        L_0x0125:
            r4.setQuality((java.lang.String) r2)     // Catch:{ Exception -> 0x014c }
            r4.setStreamLink(r1)     // Catch:{ Exception -> 0x014c }
            r1 = r16
            r1.onNext(r4)     // Catch:{ Exception -> 0x014c }
            goto L_0x014c
        L_0x0131:
            java.lang.String r2 = "NEEDRESOLVER "
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r3.<init>()     // Catch:{ Exception -> 0x014c }
            r3.append(r1)     // Catch:{ Exception -> 0x014c }
            r3.append(r8)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = r15.A()     // Catch:{ Exception -> 0x014c }
            r3.append(r1)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x014c }
            com.original.tase.Logger.b(r2, r1)     // Catch:{ Exception -> 0x014c }
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.BaseProvider.h(io.reactivex.ObservableEmitter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, boolean[]):void");
    }

    public String l(String str, String str2) {
        if (str.contains("streamango")) {
            return "https://streamango.com/embed/" + str2;
        } else if (str.contains("gcloud")) {
            return "https://gcloud.live/v/" + str2;
        } else if (str.contains("rapidvideo")) {
            return "https://www.rapidvideo.com/e/" + str2;
        } else if (str.contains("estream")) {
            return "https://estream.to/embed-" + str2 + "html";
        } else if (str.contains("openload")) {
            return "https://openload.co/embed/" + str2;
        } else if (str.contains("verystream")) {
            return "https://verystream.com/e/" + str2;
        } else if (str.contains("uptostream")) {
            return "https://uptostream.com/iframe/" + str2;
        } else if (str.contains("vidoza")) {
            return "https://vidoza.net/embed-" + str2 + ".html";
        } else if (str.contains("doodstream")) {
            return "https://dood.pm/e/" + str2;
        } else if (str.contains("streamsb")) {
            return "https://sbembed.com/e/" + str2;
        } else if (str.contains("mixdrop")) {
            return "https://sbembed.com/e/" + str2;
        } else if (str.contains("voxzer")) {
            return "https://player.voxzer.org/view/" + str2;
        } else if (!str.contains("vidcloud")) {
            return "";
        } else {
            return "https://membed.net/streaming.php?id=" + str2;
        }
    }

    public int m() {
        return 0;
    }

    public ArrayList n(String str, String str2) {
        if (str.startsWith("//")) {
            str = "https:" + str;
        }
        String o2 = HttpHelper.i().o(str, str2 + "/");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = Jsoup.b(o2).q0("li.linkserver").iterator();
        while (it2.hasNext()) {
            String c2 = ((Element) it2.next()).c("data-video");
            if (!c2.isEmpty() && !c2.contains("load.php")) {
                if (str2.contains("api.")) {
                    String l2 = l(Regex.a(c2, "type=(\\w+)", 1), Regex.a(o2, "sid=(\\w+)", 1));
                    if (!l2.isEmpty()) {
                        arrayList.add(l2);
                    }
                } else {
                    arrayList.add(c2);
                }
            }
        }
        arrayList.addAll(w(o2));
        String a2 = Regex.a(o2, "window.urlVideo\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        if (!a2.isEmpty()) {
            arrayList.add(a2);
        }
        if (str.contains("vidcloud9")) {
            String a3 = Regex.a(str, "\\?id=?([0-9a-zA-Z]+)", 1);
            if (!a3.isEmpty()) {
                HashMap<String, String> c3 = Constants.c();
                c3.put("referer", j(str) + "/");
                Iterator it3 = Regex.f(HttpHelper.i().m("https://vidcloud9.com/ajax.php?id=" + a3, c3).replace("\\/", "/"), "file['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true).get(0).iterator();
                while (it3.hasNext()) {
                    arrayList.add((String) it3.next());
                }
            } else {
                String a4 = Regex.a(o2, "code['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1);
                if (!a4.isEmpty()) {
                    HashMap<String, String> c4 = Constants.c();
                    c4.put("origin", j(str));
                    c4.put("referer", str);
                    c4.put("accept", "application/json, text/javascript, */*; q=0.01");
                    c4.put("content-type", TraktV2.CONTENT_TYPE_JSON);
                    String q2 = HttpHelper.i().q(j(str) + "/data", String.format("{\"code\":\"%s\"}", new Object[]{a4}), false, c4);
                    if (!q2.isEmpty()) {
                        Iterator it4 = Regex.f(q2, "['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true).get(0).iterator();
                        while (it4.hasNext()) {
                            String d2 = d((String) it4.next());
                            if (d2.startsWith("/")) {
                                d2 = j(str) + d2;
                            }
                            arrayList.add(d2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean o(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("cam") || lowerCase.contains(HlsSegmentFormat.TS) || lowerCase.contains("hc")) {
            return true;
        }
        return false;
    }

    public boolean p(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("-cam-") || lowerCase.contains("-ts-") || lowerCase.contains("-tc-") || lowerCase.contains("_cam_") || lowerCase.contains("_ts_") || lowerCase.contains("_tc_")) {
            return true;
        }
        return false;
    }

    public boolean q(String str) {
        if (str.contains("HD") || str.contains("1080") || str.contains("720") || str.contains("4K") || str.contains("2K") || str.contains("1440")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final String t(String str) {
        return u(str, false);
    }

    /* access modifiers changed from: protected */
    public final String u(String str, boolean z2) {
        String A = A();
        if (z2) {
            A = "Torrent";
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.contains(CredentialsData.CREDENTIALS_TYPE_WEB)) {
            A = A + " (WEB-DL)";
        } else if (lowerCase.contains("hdtv")) {
            A = A + " (HDTV)";
        }
        if (lowerCase.contains("264")) {
            A = A + " (x264)";
        } else if (lowerCase.contains("265") || lowerCase.contains("hevc")) {
            A = A + " (x265)";
        }
        if (lowerCase.contains("5.1") || lowerCase.contains("6ch")) {
            A = A + " (5.1CH)";
        } else if (lowerCase.contains("7.1")) {
            A = A + " (7.1CH)";
        } else if (lowerCase.contains("8ch")) {
            A = A + " (8CH)";
        }
        if (lowerCase.contains("bluray")) {
            A = A + " (BluRay)";
        }
        if (lowerCase.contains("10bit")) {
            A = A + " (10Bit)";
        }
        if (lowerCase.contains("truehd")) {
            return A + " (TrueHD)";
        } else if (lowerCase.contains("atmos")) {
            return A + " (Atmos)";
        } else if (!lowerCase.contains("3d")) {
            return A;
        } else {
            return A + " (3D)";
        }
    }

    /* access modifiers changed from: protected */
    public final ArrayList<String> w(String str) {
        ArrayList arrayList = Regex.f(str, "['\"]?sources?['\"]?\\s*:\\s*\\[(.*?)\\]", 1, true).get(0);
        arrayList.addAll(Regex.f(str, "['\"]?sources?[\"']?\\s*:\\s*\\[(.*?)\\}\\s*,?\\s*\\]", 1, true).get(0));
        arrayList.addAll(Regex.f(str, "['\"]?sources?['\"]?\\s*:\\s*\\{(.*?)\\}", 1, true).get(0));
        arrayList.addAll(Regex.h(str, "['\"]?sources?[\"']?\\s*:\\s*[\\{\\[](\\s*)[\\}\\]]", true));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("");
        arrayList.removeAll(arrayList2);
        ArrayList l2 = com.original.tase.utils.Utils.l(arrayList);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (l2.isEmpty()) {
            arrayList4.addAll(Regex.f(str, "\\{\\s*['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true).get(0));
        } else {
            Iterator it2 = l2.iterator();
            while (it2.hasNext()) {
                arrayList4.addAll(Regex.f((String) it2.next(), "['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)", 1, true).get(0));
            }
        }
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((String) it3.next()).replace("\\/", "/").replace("\\\\", ""));
        }
        return com.original.tase.utils.Utils.l(arrayList3);
    }

    /* access modifiers changed from: protected */
    public final void x(ObservableEmitter<? super MediaSource> observableEmitter, String str, String str2, String str3, boolean... zArr) {
        String str4;
        String str5;
        String str6;
        String str7;
        try {
            URL url = new URL(str);
            String host = url.getHost();
            str5 = url.getProtocol() + "://" + url.getHost();
            str4 = host;
        } catch (Exception unused) {
            str5 = "";
            str4 = str;
        }
        if (str.contains("vidnode.") || str.contains("vidcloud.") || str.contains("vidstreaming.") || str.contains("vidcloud9.") || str.contains("/streaming.php")) {
            ArrayList n2 = n(str, str5 + "/");
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", Constants.C);
            Iterator it2 = n2.iterator();
            while (it2.hasNext()) {
                String obj = it2.next().toString();
                if (!obj.endsWith(".vtt")) {
                    boolean n3 = GoogleVideoHelper.n(obj);
                    String A = A();
                    if (n3) {
                        str6 = "GoogleVideo";
                    } else {
                        str6 = "CDN-FastServer";
                    }
                    MediaSource mediaSource = new MediaSource(A, str6, false);
                    mediaSource.setStreamLink(obj);
                    if (!n3) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("accept", "*/*");
                        hashMap2.put("origin", str5);
                        hashMap2.put("referer", str5 + "/");
                        hashMap2.put("User-Agent", Constants.C);
                        mediaSource.setPlayHeader(hashMap2);
                    } else {
                        mediaSource.setPlayHeader(hashMap);
                    }
                    if (n3) {
                        str7 = GoogleVideoHelper.h(obj);
                    } else {
                        str7 = str2;
                    }
                    mediaSource.setQuality(str7);
                    observableEmitter.onNext(mediaSource);
                }
            }
            return;
        }
        y(observableEmitter, str, str2, str3, str4, false, zArr);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r13 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14, boolean... r15) {
        /*
            r8 = this;
            boolean r0 = r13.isEmpty()     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0128
            boolean r0 = r9.isDisposed()     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0128
            java.lang.String r0 = "thepiratebay.org"
            boolean r0 = r13.equals(r0)     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0128
            java.lang.String r0 = "protected.to"
            boolean r0 = r13.equals(r0)     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0128
            java.lang.String r0 = "thetvdb.com"
            boolean r0 = r13.equals(r0)     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0128
            java.lang.String r0 = "extratorrent.cc"
            boolean r0 = r13.equals(r0)     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0128
            java.lang.String r0 = "imdb.com"
            boolean r0 = r13.equals(r0)     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0128
            java.lang.String[] r0 = r8.f37250b     // Catch:{ Exception -> 0x0128 }
            if (r0 != 0) goto L_0x0050
            java.lang.String[] r0 = com.utils.Getlink.Resolver.BaseResolver.f()     // Catch:{ Exception -> 0x0128 }
            r8.f37250b = r0     // Catch:{ Exception -> 0x0128 }
            boolean r0 = v()     // Catch:{ Exception -> 0x0128 }
            if (r0 == 0) goto L_0x0050
            java.lang.String[] r0 = r8.f37250b     // Catch:{ Exception -> 0x0128 }
            java.lang.String[] r1 = com.utils.Getlink.Resolver.BaseResolver.e()     // Catch:{ Exception -> 0x0128 }
            java.lang.String[] r0 = com.original.tase.utils.Utils.p(r0, r1)     // Catch:{ Exception -> 0x0128 }
            r8.f37250b = r0     // Catch:{ Exception -> 0x0128 }
        L_0x0050:
            boolean r0 = com.utils.Utils.f37611d     // Catch:{ Exception -> 0x0128 }
            if (r0 == 0) goto L_0x0059
            java.lang.String[] r0 = com.utils.Getlink.Resolver.BaseResolver.e()     // Catch:{ Exception -> 0x0128 }
            goto L_0x005b
        L_0x0059:
            java.lang.String[] r0 = r8.f37250b     // Catch:{ Exception -> 0x0128 }
        L_0x005b:
            int r1 = r0.length     // Catch:{ Exception -> 0x0128 }
            r2 = 0
            r3 = 0
        L_0x005e:
            r4 = 1
            if (r3 >= r1) goto L_0x0085
            r5 = r0[r3]     // Catch:{ Exception -> 0x0128 }
            java.lang.String r6 = com.original.tase.helper.TitleHelper.f(r13)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r7 = com.original.tase.helper.TitleHelper.f(r5)     // Catch:{ Exception -> 0x0128 }
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0128 }
            if (r6 != 0) goto L_0x0083
            java.lang.String r5 = com.original.tase.helper.TitleHelper.f(r5)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r6 = com.original.tase.helper.TitleHelper.f(r13)     // Catch:{ Exception -> 0x0128 }
            boolean r5 = r5.contains(r6)     // Catch:{ Exception -> 0x0128 }
            if (r5 == 0) goto L_0x0080
            goto L_0x0083
        L_0x0080:
            int r3 = r3 + 1
            goto L_0x005e
        L_0x0083:
            r13 = 1
            goto L_0x0086
        L_0x0085:
            r13 = 0
        L_0x0086:
            boolean r0 = com.utils.Utils.f37609b     // Catch:{ Exception -> 0x0128 }
            java.lang.String r1 = " "
            if (r0 == 0) goto L_0x00c7
            if (r13 == 0) goto L_0x00c7
            boolean r13 = r8.q(r11)     // Catch:{ Exception -> 0x0128 }
            if (r13 == 0) goto L_0x00af
            if (r14 != 0) goto L_0x00af
            java.lang.String r13 = "pref_show_hd_only true: "
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0128 }
            r0.<init>()     // Catch:{ Exception -> 0x0128 }
            r0.append(r11)     // Catch:{ Exception -> 0x0128 }
            r0.append(r1)     // Catch:{ Exception -> 0x0128 }
            r0.append(r12)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0128 }
            com.original.tase.Logger.b(r13, r0)     // Catch:{ Exception -> 0x0128 }
            r13 = 1
            goto L_0x00c7
        L_0x00af:
            java.lang.String r13 = "pref_show_hd_only false: "
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0128 }
            r0.<init>()     // Catch:{ Exception -> 0x0128 }
            r0.append(r11)     // Catch:{ Exception -> 0x0128 }
            r0.append(r1)     // Catch:{ Exception -> 0x0128 }
            r0.append(r12)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0128 }
            com.original.tase.Logger.b(r13, r0)     // Catch:{ Exception -> 0x0128 }
            r13 = 0
        L_0x00c7:
            if (r13 == 0) goto L_0x010d
            if (r11 == 0) goto L_0x00d1
            boolean r13 = r11.isEmpty()     // Catch:{ Exception -> 0x0128 }
            if (r13 == 0) goto L_0x00d3
        L_0x00d1:
            java.lang.String r11 = ""
        L_0x00d3:
            if (r14 == 0) goto L_0x00ea
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0128 }
            r12.<init>()     // Catch:{ Exception -> 0x0128 }
            java.lang.String r13 = r8.A()     // Catch:{ Exception -> 0x0128 }
            r12.append(r13)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r13 = " (CAM)"
            r12.append(r13)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0128 }
        L_0x00ea:
            com.original.tase.model.media.MediaSource r13 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0128 }
            r13.<init>(r12, r11, r4)     // Catch:{ Exception -> 0x0128 }
            if (r15 == 0) goto L_0x0103
            int r12 = r15.length     // Catch:{ Exception -> 0x0128 }
            if (r12 != r4) goto L_0x00fa
            boolean r12 = r15[r2]     // Catch:{ Exception -> 0x0128 }
            r13.setCachedLink(r12)     // Catch:{ Exception -> 0x0128 }
            goto L_0x0103
        L_0x00fa:
            int r12 = r15.length     // Catch:{ Exception -> 0x0128 }
            r14 = 2
            if (r12 != r14) goto L_0x0103
            boolean r12 = r15[r4]     // Catch:{ Exception -> 0x0128 }
            r13.setNeedToSync(r12)     // Catch:{ Exception -> 0x0128 }
        L_0x0103:
            r13.setQuality((java.lang.String) r11)     // Catch:{ Exception -> 0x0128 }
            r13.setStreamLink(r10)     // Catch:{ Exception -> 0x0128 }
            r9.onNext(r13)     // Catch:{ Exception -> 0x0128 }
            goto L_0x0128
        L_0x010d:
            java.lang.String r9 = "NEEDRESOLVER "
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0128 }
            r11.<init>()     // Catch:{ Exception -> 0x0128 }
            r11.append(r10)     // Catch:{ Exception -> 0x0128 }
            r11.append(r1)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r10 = r8.A()     // Catch:{ Exception -> 0x0128 }
            r11.append(r10)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x0128 }
            com.original.tase.Logger.b(r9, r10)     // Catch:{ Exception -> 0x0128 }
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.BaseProvider.y(io.reactivex.ObservableEmitter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean[]):void");
    }

    /* access modifiers changed from: protected */
    public final void z(ObservableEmitter<? super MediaSource> observableEmitter, String str, String str2, boolean... zArr) {
        boolean z2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = str;
        boolean[] zArr2 = zArr;
        if (zArr2 == null || zArr2.length <= 0 || !zArr2[0]) {
            z2 = false;
        } else {
            z2 = true;
        }
        try {
            URL url = new URL(str7);
            String host = url.getHost();
            str4 = url.getProtocol() + "://" + url.getHost();
            str3 = host;
        } catch (Exception unused) {
            str4 = "";
            str3 = str7;
        }
        if (str7.contains("membed.") || str7.contains("vidnode.") || str7.contains("vidcloud.") || str7.contains("vidstreaming.io") || str7.contains("vidcloud9.") || str7.contains("/streaming.php")) {
            ArrayList n2 = n(str7, str4 + "/");
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", Constants.C);
            hashMap.put("referer", str7);
            hashMap.put("accept", "*/*");
            Iterator it2 = n2.iterator();
            while (it2.hasNext()) {
                String obj = it2.next().toString();
                if (!obj.endsWith(".vtt")) {
                    if (obj.startsWith("//")) {
                        obj = "https:" + obj;
                    }
                    boolean n3 = GoogleVideoHelper.n(obj);
                    String A = A();
                    if (n3) {
                        str5 = "GoogleVideo";
                    } else {
                        str5 = "CDN-FastServer";
                    }
                    Iterator it3 = it2;
                    MediaSource mediaSource = new MediaSource(A, str5, zArr2[0]);
                    mediaSource.setStreamLink(obj);
                    if (!n3) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("accept", "*/*");
                        hashMap2.put("origin", str4);
                        hashMap2.put("referer", str4 + "/");
                        hashMap2.put("User-Agent", Constants.C);
                        mediaSource.setPlayHeader(hashMap2);
                    } else {
                        mediaSource.setPlayHeader(hashMap);
                    }
                    if (n3) {
                        str6 = GoogleVideoHelper.h(obj);
                    } else {
                        str6 = str2;
                    }
                    mediaSource.setQuality(str6);
                    observableEmitter.onNext(mediaSource);
                    it2 = it3;
                }
            }
            return;
        }
        y(observableEmitter, str, str2, A(), str3, z2, new boolean[0]);
    }
}
