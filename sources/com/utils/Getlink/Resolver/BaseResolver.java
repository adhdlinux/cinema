package com.utils.Getlink.Resolver;

import com.facebook.common.util.UriUtil;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.original.tase.Logger;
import com.original.tase.helper.TitleHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.Getlink.Resolver.premium.AlfaFile;
import com.utils.Getlink.Resolver.premium.ClicknUpload;
import com.utils.Getlink.Resolver.premium.DDLTO;
import com.utils.Getlink.Resolver.premium.Dailymotion;
import com.utils.Getlink.Resolver.premium.Dailyuploads;
import com.utils.Getlink.Resolver.premium.Down4files;
import com.utils.Getlink.Resolver.premium.Earn4files;
import com.utils.Getlink.Resolver.premium.FileFactory;
import com.utils.Getlink.Resolver.premium.FileUp;
import com.utils.Getlink.Resolver.premium.FlashX;
import com.utils.Getlink.Resolver.premium.KatFile;
import com.utils.Getlink.Resolver.premium.Mediafire;
import com.utils.Getlink.Resolver.premium.MegaZN;
import com.utils.Getlink.Resolver.premium.NitroFlare;
import com.utils.Getlink.Resolver.premium.Oboom;
import com.utils.Getlink.Resolver.premium.OneFichier;
import com.utils.Getlink.Resolver.premium.RapidGator;
import com.utils.Getlink.Resolver.premium.RockFile;
import com.utils.Getlink.Resolver.premium.TurboBit;
import com.utils.Getlink.Resolver.premium.Uploaded;
import com.utils.Getlink.Resolver.premium.Uploadgig;
import com.utils.Getlink.Resolver.premium.VK;
import com.utils.Getlink.Resolver.premium.ZTONet;
import com.utils.Getlink.Resolver.premium.torrent.Torrent;
import com.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseResolver {

    /* renamed from: a  reason: collision with root package name */
    protected static boolean f37516a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f37517b = {"[\"']?\\s*(?:url|src|backup|link)\\s*[\"']?\\s*[:=]\\s*[\"']?((?:https:|http:|//)[^\\s\"']*(?:hls|m3u8|mp4|mkv)[^\\s\"']*)[\"']?[0-9a-zA-Z-,\"':/. ]+(?:res|label|height)[:=]?['\"]?(\\d{3,4})['\"]?", "[\"']?\\s*(?:file)\\s*[\"']?\\s*[:=]\\s*[\"']([^\"']+)[\"']?[0-9a-zA-Z-,\"':/. ]+(?:res|label|height)[:=]['\"]?(\\d{3,4})['\"]?", "[\"']?((?:https:|http:|//)[^\\s\"']*(?:hls|m3u8|mp4|mkv)[^\\s\"']*)[\"']?"};

    /* renamed from: c  reason: collision with root package name */
    private static String[] f37518c;

    /* renamed from: d  reason: collision with root package name */
    private static String[] f37519d;

    public static MediaSource a(MediaSource mediaSource, ResolveResult resolveResult) {
        MediaSource cloneDeeply = mediaSource.cloneDeeply();
        if (resolveResult.getFilesize() > 0) {
            cloneDeeply.setFileSize(resolveResult.getFilesize());
        }
        cloneDeeply.setStreamLink(resolveResult.getResolvedLink());
        cloneDeeply.setQuality(resolveResult.getResolvedQuality());
        if (cloneDeeply.getQuality() == null || cloneDeeply.getQuality().isEmpty()) {
            cloneDeeply.setQuality(mediaSource.getQuality());
        }
        cloneDeeply.setPlayHeader(resolveResult.getPlayHeader());
        cloneDeeply.setHostName(resolveResult.getResolverName());
        cloneDeeply.setRealdebrid(resolveResult.isRealdebrid());
        cloneDeeply.setAlldebrid(resolveResult.isAlldebrid());
        cloneDeeply.setPremiumize(resolveResult.isPremiumize());
        return cloneDeeply;
    }

    public static String d() {
        return "RealDebird,AllDebird,PREMIUMIZE,GoogleVideo,Amazone,ok.ru,RapidVideo,HLS,Streamango,openload,CDN-FastServer,FastPlay,UpToBox,DaClips,GorillaVid,HD SlowServer,Vidzi,VidToDo,EnterVideo,MovPod,VcStream,FB-CDN";
    }

    public static String[] e() {
        String[] strArr = f37519d;
        if (strArr == null || strArr.length == 0) {
            f37519d = GlobalVariable.c().b().getRd_config().getList().split(",");
        }
        return f37519d;
    }

    public static String[] f() {
        return g(FreeMoviesApp.p().getBoolean("pref_show_hd_sources_only", false));
    }

    private static String[] g(boolean z2) {
        String[] strArr = f37518c;
        if (strArr == null || strArr.length == 0) {
            f37518c = GlobalVariable.c().b().getReslover().getList().split(",");
        }
        return f37518c;
    }

    public static HashMap<String, String> i(String str, String str2) {
        String str3;
        HashMap<String, String> hashMap = new HashMap<>();
        if (str2 == null || str2.isEmpty()) {
            str3 = "(?s)<form[^>]*>(.*?)</form>";
        } else {
            str3 = "(?s)<form [^>]*(?:id|name)\\s*=\\s*['\"]?" + str2 + "['\"]?[^>]*>(.*?)</form>";
        }
        Iterator it2 = Regex.e(str, str3, 1, 34).get(0).iterator();
        while (it2.hasNext()) {
            Iterator it3 = Regex.d((String) it2.next(), "<input[^>]*type=['\"]?hidden['\"]?[^>]*>", 0).get(0).iterator();
            while (it3.hasNext()) {
                String str4 = (String) it3.next();
                String a2 = Regex.a(str4, "name\\s*=\\s*['\"]([^'\"]+)", 1);
                String a3 = Regex.a(str4, "value\\s*=\\s*['\"]([^'\"]*)", 1);
                if (!a2.isEmpty() && !a3.isEmpty()) {
                    hashMap.put(a2, a3);
                }
            }
        }
        return hashMap;
    }

    public static Observable<MediaSource> m(MediaSource mediaSource) {
        boolean z2;
        MediaSource cloneDeeply = mediaSource.cloneDeeply();
        String streamLink = cloneDeeply.getStreamLink();
        if (cloneDeeply.isResolved()) {
            return Observable.just(cloneDeeply);
        }
        if (streamLink.endsWith("rar") || streamLink.contains(".part")) {
            Logger.b("Resolvelink rar ", cloneDeeply.toStringAllObjs());
            return Observable.empty();
        }
        if (BaseProvider.v() && Utils.f37611d) {
            String[] e2 = e();
            int length = e2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                String str = e2[i2];
                if (TitleHelper.f(streamLink).contains(TitleHelper.f(str)) || TitleHelper.f(str).contains(TitleHelper.f(streamLink))) {
                    z2 = true;
                } else {
                    i2++;
                }
            }
            z2 = true;
            if (!z2) {
                return new NonResolver().b(cloneDeeply);
            }
        }
        f37516a = FreeMoviesApp.p().getBoolean("pref_off_premium_resolve5", false);
        if (BaseProvider.v()) {
            if (streamLink.contains("magnet:") || streamLink.contains(".torrent")) {
                return new Torrent().b(cloneDeeply);
            }
            if (streamLink.contains("rapidgator")) {
                return new RapidGator().b(cloneDeeply);
            }
            if (streamLink.contains("alfafile")) {
                return new AlfaFile().b(cloneDeeply);
            }
            if (streamLink.contains("clicknupload")) {
                return new ClicknUpload().b(cloneDeeply);
            }
            if (streamLink.contains("flashx")) {
                return new FlashX().b(cloneDeeply);
            }
            if (streamLink.contains("nitroflare") || streamLink.contains("nitro.")) {
                return new NitroFlare().b(cloneDeeply);
            }
            if (streamLink.contains("1fichier")) {
                return new OneFichier().b(cloneDeeply);
            }
            if (streamLink.contains("oboom")) {
                return new Oboom().b(cloneDeeply);
            }
            if (streamLink.contains("oneFichier")) {
                return new OneFichier().b(cloneDeeply);
            }
            if (streamLink.contains("rockfile")) {
                return new RockFile().b(cloneDeeply);
            }
            if (streamLink.contains("ddl.to")) {
                return new DDLTO().b(cloneDeeply);
            }
            if (streamLink.contains("turbobit")) {
                return new TurboBit().b(cloneDeeply);
            }
            if (streamLink.contains("uploaded") || streamLink.contains("ul.to")) {
                return new Uploaded().b(cloneDeeply);
            }
            if (streamLink.contains("uploadrocket")) {
                return new RapidGator().b(cloneDeeply);
            }
            if (streamLink.contains("katfile")) {
                return new KatFile().b(cloneDeeply);
            }
            if (streamLink.contains("filefactory")) {
                return new FileFactory().b(cloneDeeply);
            }
            if (streamLink.contains("real-debrid")) {
                return new DebCached().b(cloneDeeply);
            }
            if (streamLink.contains("ulozto")) {
                return new ZTONet().b(cloneDeeply);
            }
            if (streamLink.contains("mega.nz")) {
                return new MegaZN().b(cloneDeeply);
            }
            if (streamLink.contains("mediafire")) {
                return new Mediafire().b(cloneDeeply);
            }
            if (streamLink.contains("earn4files.")) {
                return new Earn4files().b(cloneDeeply);
            }
            if (streamLink.contains("file-up.")) {
                return new FileUp().b(cloneDeeply);
            }
            if (streamLink.contains("dailymotion.")) {
                return new Dailymotion().b(cloneDeeply);
            }
            if (streamLink.contains("dailyuploads.")) {
                return new Dailyuploads().b(cloneDeeply);
            }
            if (streamLink.contains("uploadgig.")) {
                return new Uploadgig().b(cloneDeeply);
            }
            if (streamLink.contains("4downfiles.")) {
                return new Down4files().b(cloneDeeply);
            }
        }
        if (Utils.f37611d) {
            return Observable.empty();
        }
        String replace = streamLink.replace("\r", "").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "");
        if (replace.contains(".m3u8")) {
            return Observable.just(cloneDeeply);
        }
        if (replace.contains("filegram.")) {
            return new Filegram().b(cloneDeeply);
        }
        if (replace.contains("swiftload.")) {
            return new Swiftload().b(cloneDeeply);
        }
        if (replace.contains("oneupload.") || replace.contains("tipfly.")) {
            return new Oneupload().b(cloneDeeply);
        }
        if (replace.contains("closeload.")) {
            return new Closeload().b(cloneDeeply);
        }
        if (replace.contains("ridoo.")) {
            return new Ridoo().b(cloneDeeply);
        }
        if (replace.contains("streamx.live") || replace.contains("stream365.live")) {
            return new HydraX().b(cloneDeeply);
        }
        if (replace.contains("schoolbalebale2") || replace.contains("streamloverx") || replace.contains(".voxzer")) {
            return new ClubPlay().b(cloneDeeply);
        }
        if (replace.contains("hydrax")) {
            return new T3Play().b(cloneDeeply);
        }
        if (replace.contains("hihihaha")) {
            return new Abyss().b(cloneDeeply);
        }
        if (replace.contains("vidhidevip") || replace.contains("vidhidepre") || replace.contains("vidhide")) {
            return new Vidhidevip().b(cloneDeeply);
        }
        if (replace.contains("mixdrop.") || replace.contains("mixdrp.") || replace.contains("mdfx9dc8n.") || replace.contains("mdbekjwqa.")) {
            return new MixDrop().b(cloneDeeply);
        }
        if (replace.contains("uptobox") || replace.contains("uptostream")) {
            return new UpToBox().b(cloneDeeply);
        }
        if (replace.contains("vixtodo") || replace.contains("vidtodo") || replace.contains("vidstodo") || replace.contains("vidtoup")) {
            return new VidTodo().b(cloneDeeply);
        }
        if (replace.contains("powvideo")) {
            return new PowerVideo().b(cloneDeeply);
        }
        if (replace.contains("vidoza") || replace.contains("videzz")) {
            return new Vidoza().b(cloneDeeply);
        }
        if (replace.contains("them4ufree")) {
            return new Them4uFree().b(cloneDeeply);
        }
        if (replace.contains("ok.ru") || replace.contains("odnoklassniki")) {
            return new Okru().b(cloneDeeply);
        }
        if (replace.contains("vidsrc.me") || replace.contains("vidsrc.net") || replace.contains("vidsrc.xyz")) {
            return new VidStream().b(cloneDeeply);
        }
        if (replace.contains("mp4upload")) {
            return new Mp4Upload().b(cloneDeeply);
        }
        if (replace.contains("cloudvideo") || replace.contains("media.")) {
            return new CloudVideo().b(cloneDeeply);
        }
        if (replace.contains("amazon")) {
            return new AmazonDrive().b(cloneDeeply);
        }
        if (replace.contains("vidmoly")) {
            return new VidMoly().b(cloneDeeply);
        }
        if (replace.contains("gounlimited")) {
            return new Gounlimited().b(cloneDeeply);
        }
        if (replace.contains("sblona.") || replace.contains("sbanh.") || replace.contains("sbnet.") || replace.contains("sbvideo.") || replace.contains("sbembed.") || replace.contains("watchsb.") || replace.contains("sblongvu.") || replace.contains("sblanh.") || replace.contains("vidmovie.") || replace.contains("streamsss.") || replace.contains("sbplay")) {
            return new Sbvideo().b(cloneDeeply);
        }
        if (replace.contains("streamlare.") || replace.contains("sltube.") || replace.contains("slmaxed.")) {
            return new StreamHD().b(cloneDeeply);
        }
        if (replace.contains("embedsito.") || replace.contains("moviepl.") || replace.contains("streamm4u.") || replace.contains("fembed.") || replace.contains("24hd.") || replace.contains("gcloud.") || replace.contains("mediashore.") || replace.contains("feurl") || replace.contains("bmoviesfree") || replace.contains("mediashore") || replace.contains("vanfem.")) {
            return new Fembed().b(cloneDeeply);
        }
        if (replace.contains("mcloud.") || replace.contains("vidplay.") || replace.contains("megaf.") || !Regex.a(replace, "(vid\\d+\\w+|vid\\w+\\d+)", 1).isEmpty()) {
            return new VidPlayStream().b(cloneDeeply);
        }
        if (replace.contains("idtbox")) {
            return new Idtbox().b(cloneDeeply);
        }
        if (replace.contains("xstreamcdn")) {
            return new Xstreamcdn().b(cloneDeeply);
        }
        if (replace.contains("viduplayer")) {
            return new ViduPlayer().b(cloneDeeply);
        }
        if (replace.contains("vcdn.io")) {
            return new VCDN().b(cloneDeeply);
        }
        if (replace.contains("jetload")) {
            return new JetLoad().b(cloneDeeply);
        }
        if (replace.contains("verystream")) {
            return new VeryStream().b(cloneDeeply);
        }
        if (replace.contains("ostream")) {
            return new OStream().b(cloneDeeply);
        }
        if (replace.contains("streamhub.")) {
            return new Streamhub().b(cloneDeeply);
        }
        if (replace.contains("gamovideo")) {
            return new GamoVideo().b(cloneDeeply);
        }
        if (replace.contains("sendit.") || replace.contains("send.")) {
            return new SenditCloud().b(cloneDeeply);
        }
        if (replace.contains("vk.")) {
            return new VK().b(cloneDeeply);
        }
        if (replace.contains("hqq.") || replace.contains("vido.") || replace.contains("waaw.") || replace.contains("netu.")) {
            return new HdTv().b(cloneDeeply);
        }
        if (replace.contains("gdriveplayer")) {
            return new Gdriver().b(cloneDeeply);
        }
        if (replace.contains("upstream")) {
            return new UpStream().b(cloneDeeply);
        }
        if (replace.contains("abcvideo")) {
            return new ABCvideo().b(cloneDeeply);
        }
        if (replace.contains("supervideo")) {
            return new Supervideo().b(cloneDeeply);
        }
        if (replace.contains("drop.d")) {
            return new DropBox().b(cloneDeeply);
        }
        if (replace.contains("dropapk") || replace.contains("drop.")) {
            return new DropApk().b(cloneDeeply);
        }
        if (replace.contains("api.hdv.fun") || replace.contains("ffull.pw")) {
            return new P2PCDN().b(cloneDeeply);
        }
        if (replace.contains("letsupload")) {
            return new Letsupload().b(cloneDeeply);
        }
        if (replace.contains("eplayvid.")) {
            return new EPlayvid().b(cloneDeeply);
        }
        if (replace.contains("luluvdo.")) {
            return new Luluvdo().b(cloneDeeply);
        }
        if (replace.contains("streamwish.") || replace.contains("cdnwish.") || replace.contains("swdyu.")) {
            return new Streamwish().b(cloneDeeply);
        }
        if (replace.contains("movcloud.")) {
            return new Movcloud().b(cloneDeeply);
        }
        if (replace.contains("streamtape.") || replace.contains("strtape") || replace.contains("adblockeronstreamtape") || replace.contains("streamta.")) {
            return new Streamtape().b(cloneDeeply);
        }
        if (replace.contains("aparat.")) {
            return new Aparat().b(cloneDeeply);
        }
        if (replace.contains("mstream.")) {
            return new MstreamTo().b(cloneDeeply);
        }
        if (replace.contains("ronemo.") || replace.toLowerCase().contains("vidlink.")) {
            return new Ronemo().b(cloneDeeply);
        }
        if (replace.contains("dood.") || replace.contains("doodstream.") || replace.contains("doods.") || !Regex.a(replace, "(?:\\/|\\.)(d\\d+d.)", 1).isEmpty()) {
            return new DoodPlay().b(cloneDeeply);
        }
        if (replace.contains("userload.")) {
            return new Userload().b(cloneDeeply);
        }
        if (replace.contains("ninjastream.") || replace.contains("highstream.") || replace.contains("hdvid.") || replace.contains("wolfstream") || replace.contains("playtube") || replace.contains("evoload") || replace.contains("anonfiles") || replace.contains("vupload")) {
            return new EZStream().b(cloneDeeply);
        }
        if (replace.contains("voe.") || replace.contains("cyamidpulverulence")) {
            return new VSXStream().b(cloneDeeply);
        }
        if (replace.contains("vidcloudpng.")) {
            return new Vidcloudpng().b(cloneDeeply);
        }
        if (replace.contains("youdbox.")) {
            return new Yourbox().b(cloneDeeply);
        }
        if (replace.contains("streamvid.")) {
            return new Streamvid().b(cloneDeeply);
        }
        if (replace.contains("gomo.") || replace.contains("gomoplayer.")) {
            return new Gomo().b(cloneDeeply);
        }
        if (replace.contains("dokicloud.") || replace.contains("rabbitstream.") || replace.contains("mzzcloud.") || replace.contains("megacloud.")) {
            return new RabitStream().b(cloneDeeply);
        }
        if (replace.contains("filerio.")) {
            return new FileRio().b(cloneDeeply);
        }
        if (replace.contains("hexupload.")) {
            return new HexUpload().b(cloneDeeply);
        }
        if (replace.contains("mixloads.")) {
            return new MixLoads().b(cloneDeeply);
        }
        if (replace.contains("yodbox.")) {
            return new YoudBox().b(cloneDeeply);
        }
        if (replace.contains("zplayer.")) {
            return new ZPlayer().b(cloneDeeply);
        }
        if (replace.contains("filemoon.") || replace.contains("kerapoxy.") || replace.contains("hellnaw.")) {
            return new Filemoon().b(cloneDeeply);
        }
        if (replace.contains("embedwish.")) {
            return new Embedwish().b(cloneDeeply);
        }
        if (replace.contains("furher.")) {
            return new Furher().b(cloneDeeply);
        }
        if (replace.contains("emturbovid.")) {
            return new Emturbovid().b(cloneDeeply);
        }
        if (replace.contains("filelions.") || replace.contains("vidhidepro.")) {
            return new Filelions().b(cloneDeeply);
        }
        if (replace.contains("dropload.")) {
            return new Dropload().b(cloneDeeply);
        }
        if (replace.contains("uqload.")) {
            return new UploadSrc().b(cloneDeeply);
        }
        if (replace.contains("moflix-stream.")) {
            return new MoflixStream().b(cloneDeeply);
        }
        if (replace.contains("hollymoviehd.")) {
            return new Hollymoviehd().b(cloneDeeply);
        }
        if (replace.contains("vtube.") || replace.contains("vtbe.")) {
            return new Vtube().b(cloneDeeply);
        }
        return new NonResolver().b(cloneDeeply);
    }

    public Observable<MediaSource> b(final MediaSource mediaSource) {
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                try {
                    BaseResolver.this.l(mediaSource, observableEmitter);
                } catch (Exception e2) {
                    Logger.b("BaseResolver", e2.getMessage());
                }
                observableEmitter.onComplete();
            }
        });
    }

    public abstract String c();

    public ArrayList h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("240");
        arrayList.add("144");
        arrayList.add("240p");
        arrayList.add("144p");
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public ArrayList<ResolveResult> j(String str, String str2, boolean z2, HashMap<String, String> hashMap, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        return k(str, arrayList, z2, hashMap, str3);
    }

    /* access modifiers changed from: protected */
    public ArrayList<ResolveResult> k(String str, ArrayList<String> arrayList, boolean z2, HashMap<String, String> hashMap, String str2) {
        String str3;
        String str4;
        HashMap<String, String> hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        if (hashMap2 != null && !hashMap.isEmpty()) {
            hashMap3.putAll(hashMap2);
        }
        ArrayList<ResolveResult> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            for (String str5 : f37517b) {
                if (str5 != null && !str5.isEmpty()) {
                    Matcher matcher = Pattern.compile(str5, 32).matcher(arrayList.toString());
                    while (matcher.find()) {
                        String str6 = "HQ";
                        if (str2 != null) {
                            str3 = str2;
                        } else {
                            str3 = str6;
                        }
                        try {
                            if (matcher.groupCount() == 1) {
                                str4 = matcher.group(1);
                            } else if (matcher.groupCount() == 2) {
                                str4 = matcher.group(1);
                                try {
                                    str3 = matcher.group(2);
                                } catch (Throwable unused) {
                                    if (str2 != null) {
                                        str3 = str2;
                                    } else {
                                        str3 = str6;
                                    }
                                }
                            } else {
                                str4 = "";
                            }
                            if (str4 != null) {
                                if (!str4.isEmpty() && !str4.matches("(\\.jpg|\\.jpeg|\\.gif|\\.png|\\.js|\\.css|\\.htm|\\.html|\\.php|\\.xml|\\.swf|googletagmanager|\\.rar|\\.part|\\.zip)")) {
                                    if (str4.endsWith("\\")) {
                                        str4 = str4.substring(0, str4.length() - 1);
                                    }
                                    String replace = str4.replace("\\/", "/").replace("\\\\", "").replace("&amp;", "&");
                                    if (replace.startsWith("//")) {
                                        replace = "https:" + replace;
                                    }
                                    if (replace.startsWith(":")) {
                                        replace = UriUtil.HTTPS_SCHEME + replace;
                                    }
                                    if (replace.startsWith(UriUtil.HTTP_SCHEME) && !arrayList3.contains(replace)) {
                                        Logger.b("FINDRESULT", replace);
                                        arrayList3.add(replace);
                                        String replace2 = replace.replace(" ", "%20");
                                        String c2 = c();
                                        if (str3 != null) {
                                            str6 = str3;
                                        }
                                        ResolveResult resolveResult = new ResolveResult(c2, replace2, str6);
                                        if (z2) {
                                            resolveResult.setPlayHeader(hashMap2);
                                        }
                                        arrayList2.add(resolveResult);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            Logger.d(th, new boolean[0]);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: protected */
    public abstract void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter);
}
