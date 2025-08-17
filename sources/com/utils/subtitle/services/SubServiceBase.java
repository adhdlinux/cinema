package com.utils.subtitle.services;

import com.google.common.io.Files;
import com.movie.FreeMoviesApp;
import com.movie.data.model.MovieInfo;
import com.movie.ui.activity.settings.subfragment.SubtitleFragment;
import com.original.tase.helper.player.BasePlayer;
import com.utils.Utils;
import com.utils.cast.CastSubtitlesWebServer;
import com.utils.cast.WebServerManager;
import com.utils.subtitle.SubtitleInfo;
import com.utils.subtitle.SubtitlesConverter;
import com.utils.subtitle.converter.FormatTTML;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.utils.subtitle.services.opensubtitlesIo.opensubtitlesIO;
import com.utils.subtitle.services.subdl.SubDL;
import com.utils.subtitle.services.subtitlecat.SubtitleCat;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import l1.b;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class SubServiceBase {

    /* renamed from: b  reason: collision with root package name */
    private static OpenSubtitleV1Api f37754b;

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f37755c = Pattern.compile(".*\\.(srt|sub|ssa|ass|stl|ttml|vtt|mpsub|asc|scc|xml)$", 2);

    /* renamed from: a  reason: collision with root package name */
    public String f37756a;

    public static String c(String str, boolean z2) throws Exception {
        File d2 = d(str);
        if (d2.getName().endsWith(".zip")) {
            d2 = l(d2, d2.getParentFile()).get(0);
        }
        String a2 = Files.a(d2.getName());
        String encode = URLEncoder.encode(d2.getName().toLowerCase(), "UTF-8");
        if (!z2) {
            return m(encode, d2);
        }
        a2.hashCode();
        if (a2.equals("ass") || a2.equals("srt")) {
            return m(encode, SubtitlesConverter.a(d2.getAbsolutePath(), new FormatTTML()));
        }
        return str;
    }

    private static File d(String str) throws IOException {
        String str2;
        FileOutputStream fileOutputStream;
        Response execute = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
        try {
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                if (body != null) {
                    String header = execute.header("Content-Disposition");
                    if (header != null) {
                        str2 = e(header);
                    } else {
                        str2 = execute.request().url().pathSegments().get(execute.request().url().pathSegments().size() - 1);
                    }
                    File a02 = Utils.a0(str2);
                    File parentFile = a02.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    InputStream byteStream = body.byteStream();
                    try {
                        fileOutputStream = new FileOutputStream(a02);
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = byteStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.close();
                                byteStream.close();
                                execute.close();
                                return a02;
                            }
                        }
                    } catch (Throwable th) {
                        if (byteStream != null) {
                            byteStream.close();
                        }
                        throw th;
                    }
                } else {
                    throw new IOException("Response body is null");
                }
            } else {
                throw new IOException("Failed to download file: " + execute);
            }
            throw th;
        } catch (Throwable th2) {
            if (execute != null) {
                try {
                    execute.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public static String e(String str) {
        Matcher matcher = Pattern.compile("filename=\"?([^\"]+)\"?").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static SubServiceBase f(String str, BasePlayer basePlayer) {
        if (str.contains("OpenSubtitleIO")) {
            return new opensubtitlesIO();
        }
        if (str.contains("OpenSubtitleRest")) {
            return new OpenSubtitleRest();
        }
        if (str.contains("OpenSubtitleApi")) {
            return new OpenSubtitleApi(f37754b);
        }
        if (str.contains("SubtitleCat")) {
            return new SubtitleCat();
        }
        if (str.contains("SubDL")) {
            return new SubDL();
        }
        return null;
    }

    public static Observable<ArrayList<SubtitleInfo>> g(MovieInfo movieInfo, OpenSubtitleV1Api openSubtitleV1Api, BasePlayer basePlayer) {
        f37754b = openSubtitleV1Api;
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_sub_enable_providers", SubtitleFragment.defaultSubtitleProviders);
        ArrayList arrayList = new ArrayList();
        for (String next : stringSet) {
            SubServiceBase f2 = f(next, basePlayer);
            if (f2 != null) {
                f2.f37756a = next;
                if (!arrayList.contains(f2)) {
                    arrayList.add(f2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Observable.just(new ArrayList());
        }
        return Observable.fromIterable(arrayList).flatMap(new b(movieInfo));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean h(ArrayList arrayList) throws Exception {
        return !arrayList.isEmpty();
    }

    public static List<File> l(File file, File file2) throws IOException {
        File file3;
        FileOutputStream fileOutputStream;
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    File file4 = new File(file2, nextEntry.getName());
                    if (nextEntry.isDirectory()) {
                        file3 = file4;
                    } else {
                        file3 = file4.getParentFile();
                    }
                    if (!file3.isDirectory()) {
                        if (!file3.mkdirs()) {
                            throw new FileNotFoundException("Failed to ensure directory: " + file3.getAbsolutePath());
                        }
                    }
                    if (!nextEntry.isDirectory()) {
                        if (Pattern.matches(".*\\.(vtt|srt|txt|ass|ttml|sbv|dfxp)$", nextEntry.getName())) {
                            arrayList.add(file4);
                            fileOutputStream = new FileOutputStream(file4);
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                        }
                    }
                } else {
                    zipInputStream.close();
                    return arrayList;
                }
            }
        } catch (Throwable unused) {
            zipInputStream.close();
            return arrayList;
        }
    }

    private static String m(String str, Object obj) {
        if (WebServerManager.a().b() == null) {
            WebServerManager.a().d(new CastSubtitlesWebServer(32507));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str.toLowerCase(), obj);
        WebServerManager.a().c(hashMap);
        String O = Utils.O();
        if (O.isEmpty()) {
            O = "127.0.0.1";
        }
        String str2 = "http://" + O + ":" + 32507 + "/" + str;
        if (!hashMap.isEmpty()) {
            WebServerManager.a().e();
        }
        return str2;
    }

    public abstract void j(MovieInfo movieInfo, ObservableEmitter<? super ArrayList<SubtitleInfo>> observableEmitter);

    public Observable<ArrayList<SubtitleInfo>> k(final MovieInfo movieInfo) {
        return Observable.create(new ObservableOnSubscribe<ArrayList<SubtitleInfo>>() {
            public void subscribe(ObservableEmitter<ArrayList<SubtitleInfo>> observableEmitter) throws Exception {
                SubServiceBase.this.j(movieInfo, observableEmitter);
                observableEmitter.onComplete();
            }
        });
    }
}
