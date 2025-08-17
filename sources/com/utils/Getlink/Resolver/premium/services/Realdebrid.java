package com.utils.Getlink.Resolver.premium.services;

import com.movie.FreeMoviesApp;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.model.realdebrid.AddMagnetResponse;
import com.movie.data.model.realdebrid.MagnetObject;
import com.movie.data.model.realdebrid.RealDebridTorrentInfoObject;
import com.movie.data.model.realdebrid.UnRestrictCheckObject;
import com.movie.data.model.realdebrid.UnRestrictObject;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.exception.NeedTimeAddToDeb;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Response;
import timber.log.Timber;

public class Realdebrid extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    static RealDebridApi f37559a;

    /* renamed from: b  reason: collision with root package name */
    public static List<RealDebridTorrentInfoObject> f37560b;

    public Realdebrid() {
        if (Utils.v() != null) {
            f37559a = FreeMoviesApp.m(Utils.v()).l().b();
        }
    }

    public static void d() {
        try {
            if (f37560b == null) {
                f37560b = f37559a.torrents((Integer) null, (Integer) null, (Integer) null, (String) null).execute().body();
            }
        } catch (Exception e2) {
            Timber.d(e2);
        }
    }

    public void a(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) throws Exception {
        PrintStream printStream = System.out;
        printStream.println("checkExist=" + mediaSource.toStringAllObjs());
        if (mediaSource.isTorrent()) {
            b(mediaSource, observableEmitter);
            return;
        }
        Response<UnRestrictCheckObject> execute = f37559a.unrestrictCheck(mediaSource.getStreamLink(), (String) null).execute();
        if (execute.isSuccessful() && execute.body() != null) {
            long filesize = execute.body().getFilesize();
            String link = execute.body().getLink();
            if (link != null && !link.isEmpty() && execute.body().getSupported() > 0) {
                mediaSource.setFileSize(filesize);
                mediaSource.setRealdebrid(true);
                mediaSource.setOriginalLink(link);
                mediaSource.setStreamLink(link);
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) throws Exception {
        d();
        ArrayList<MagnetObject> magnetObjects = mediaSource.getMagnetObjects();
        new ArrayList();
        List<RealDebridTorrentInfoObject> list = f37560b;
        if (list != null) {
            for (RealDebridTorrentInfoObject next : list) {
                Iterator<MagnetObject> it2 = magnetObjects.iterator();
                while (it2.hasNext()) {
                    MagnetObject next2 = it2.next();
                    if (next.getHash().equalsIgnoreCase(Regex.a(next2.getMagnet(), "magnet:\\?xt=urn:btih:([^&.]+)", 1).toLowerCase()) && next.getStatus().equals("downloaded")) {
                        for (String next3 : next.getLinks()) {
                            if (mediaSource.getExtra() == null || mediaSource.getExtra().isEmpty() || next.getFilename().toLowerCase().contains(mediaSource.getExtra().toLowerCase())) {
                                MediaSource cloneDeeply = mediaSource.cloneDeeply();
                                if (mediaSource.getQuality() == null || mediaSource.getQuality().isEmpty()) {
                                    cloneDeeply.setQuality("HD");
                                }
                                cloneDeeply.setStreamLink(next3);
                                cloneDeeply.setOriginalLink(next3);
                                cloneDeeply.setFileSize(next.getBytes());
                                cloneDeeply.setTorrent(false);
                                cloneDeeply.setRealdebrid(true);
                                cloneDeeply.setQuality(next2.getQuality());
                                cloneDeeply.setHostName(next2.getHostName());
                                cloneDeeply.setProviderName(next2.getProvider());
                                cloneDeeply.setFilename(next2.getFileName());
                                observableEmitter.onNext(cloneDeeply);
                            }
                        }
                        it2.remove();
                    }
                }
            }
        }
        Iterator<MagnetObject> it3 = magnetObjects.iterator();
        while (it3.hasNext()) {
            MagnetObject next4 = it3.next();
            MediaSource cloneDeeply2 = mediaSource.cloneDeeply();
            cloneDeeply2.setRealdebrid(true);
            cloneDeeply2.setTorrent(true);
            cloneDeeply2.setQuality(next4.getQuality());
            cloneDeeply2.setProviderName(next4.getProvider());
            cloneDeeply2.setHostName(next4.getHostName());
            cloneDeeply2.setOriginalLink(next4.getMagnet());
            cloneDeeply2.setStreamLink(next4.getMagnet());
            cloneDeeply2.setFilename(next4.getFileName());
            observableEmitter.onNext(cloneDeeply2);
        }
    }

    /* access modifiers changed from: package-private */
    public List<ResolveResult> c(String str, String str2) throws Exception {
        ArrayList arrayList = new ArrayList();
        Response<UnRestrictObject> execute = f37559a.unrestrictLink(str, "", 0).execute();
        if (execute.code() == 200) {
            UnRestrictObject body = execute.body();
            if (body != null) {
                String download = body.getDownload();
                if (!download.endsWith(".rar") && !download.endsWith(".7z") && !download.endsWith(".zip") && !download.endsWith(".iso") && !download.endsWith(".flv") && !download.endsWith(".sub") && !download.endsWith(".pdf") && !download.endsWith(".mp3")) {
                    ResolveResult resolveResult = new ResolveResult(str2, download, String.valueOf(body.getFilesize()));
                    resolveResult.setResolverFileName(body.getFilename());
                    resolveResult.setFilesize(body.getFilesize());
                    resolveResult.setResolvedQuality(body.getType());
                    arrayList.add(resolveResult);
                } else if (body.getAlternative() != null) {
                    for (UnRestrictObject.AlternativeBean next : body.getAlternative()) {
                        String download2 = next.getDownload();
                        if (!download2.endsWith(".rar") && !download2.endsWith(".7z") && !download2.endsWith(".zip") && !download2.endsWith(".iso") && !download2.endsWith(".flv") && !download2.endsWith(".sub") && !download2.endsWith(".pdf") && !download2.endsWith(".mp3")) {
                            ResolveResult resolveResult2 = new ResolveResult(str2, download2, (String) null);
                            resolveResult2.setResolverFileName(next.getFilename());
                            arrayList.add(resolveResult2);
                        }
                    }
                } else {
                    throw new Exception("Error file not support");
                }
            }
            return arrayList;
        }
        throw new Exception("Error code: " + execute.code() + "\nMessage: " + execute.message());
    }

    public void e(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) throws Exception {
        List<ResolveResult> c2;
        String V;
        if (mediaSource.isTorrent()) {
            f(mediaSource, observableEmitter);
        } else if (RealDebridCredentialsHelper.d().isValid() && (c2 = c(mediaSource.getStreamLink(), mediaSource.getHostName())) != null && !c2.isEmpty()) {
            for (ResolveResult next : c2) {
                mediaSource.setResolved(true);
                mediaSource.setFileSize(next.getFilesize());
                mediaSource.setStreamLink(next.getResolvedLink());
                mediaSource.setRealdebrid(true);
                mediaSource.setFilename(next.getResolverFileName());
                if ((mediaSource.getQuality() == null || mediaSource.getQuality().equals("HD")) && (V = Utils.V(mediaSource.getFilename())) != null && !V.isEmpty()) {
                    mediaSource.setQuality(V);
                }
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) throws Exception {
        int id;
        long bytes;
        if (mediaSource.isRealdebrid()) {
            Response<AddMagnetResponse> execute = f37559a.addMagnet(mediaSource.getStreamLink(), "").execute();
            if (execute.code() != 201 || execute.body() == null) {
                throw new Exception("responseAddmagnet Error : " + execute.code());
            }
            String id2 = execute.body().getId();
            if (id2 == null || id2.isEmpty()) {
                throw new Exception("Torrent ID not exist");
            }
            Response<RealDebridTorrentInfoObject> execute2 = f37559a.torrentInfos(id2).execute();
            if (execute2.code() == 200) {
                execute2.body().getFilename();
                long j2 = 0;
                int i2 = -1;
                for (RealDebridTorrentInfoObject.FilesBean next : execute2.body().getFiles()) {
                    if (mediaSource.getExtra() == null || mediaSource.getExtra().isEmpty()) {
                        id = next.getId();
                        bytes = next.getBytes();
                        if (bytes <= j2) {
                        }
                    } else if (next.getPath().toLowerCase().contains(mediaSource.getExtra().toLowerCase())) {
                        id = next.getId();
                        bytes = next.getBytes();
                        if (bytes <= j2) {
                        }
                    }
                    i2 = id;
                    j2 = bytes;
                }
                if (i2 != -1) {
                    RealDebridApi realDebridApi = f37559a;
                    Response<ResponseBody> execute3 = realDebridApi.selectFiles(id2, i2 + "").execute();
                    if (execute3.code() == 204) {
                        Response<RealDebridTorrentInfoObject> execute4 = f37559a.torrentInfos(id2).execute();
                        if (execute4.code() == 200) {
                            RealDebridTorrentInfoObject body = execute4.body();
                            if (body == null) {
                                throw new Exception("Error code: " + execute4.code() + "\nMessage: " + execute4.message());
                            } else if (body.getStatus().contains("downloaded")) {
                                for (String unrestrictLink : body.getLinks()) {
                                    Response<UnRestrictObject> execute5 = f37559a.unrestrictLink(unrestrictLink, "", 0).execute();
                                    if (execute5.code() == 200) {
                                        UnRestrictObject body2 = execute5.body();
                                        if (mediaSource.getQuality() == null || mediaSource.getQuality().isEmpty()) {
                                            mediaSource.setQuality("HD");
                                        }
                                        mediaSource.setStreamLink(body2.getDownload());
                                        mediaSource.setFileSize(body2.getFilesize());
                                        mediaSource.setRealdebrid(true);
                                        mediaSource.setResolved(true);
                                        mediaSource.setFilename(body2.getFilename());
                                        observableEmitter.onNext(mediaSource);
                                    } else {
                                        throw new Exception("unRestrictObjectResponse Error : " + execute5.code());
                                    }
                                }
                                observableEmitter.onComplete();
                            } else {
                                throw new NeedTimeAddToDeb("Real-Debrid is processing the torrent. Please try again later or choose another link.");
                            }
                        } else {
                            throw new Exception("realDebridTorrentInfoObjectResponse  Error : " + execute4.code());
                        }
                    } else {
                        throw new Exception("responseBodyResponseSelectFile Error : " + execute3.code());
                    }
                } else {
                    throw new Exception("responseBodyResponseSelectFile Error : index not found ");
                }
            } else {
                throw new Exception("realDebridTorrentInfoObjectResponse  Error : " + execute2.code());
            }
        }
    }
}
