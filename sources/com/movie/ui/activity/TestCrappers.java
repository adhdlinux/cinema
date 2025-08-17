package com.movie.ui.activity;

import android.os.Bundle;
import android.widget.ListView;
import butterknife.BindView;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public class TestCrappers extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    CompositeDisposable f32172b = new CompositeDisposable();
    @Inject

    /* renamed from: c  reason: collision with root package name */
    IMDBApi f32173c;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    TMDBApi f32174d;
    @BindView(2131362356)
    ListView lvSources;

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean F(MediaSource mediaSource) throws Exception {
        return mediaSource.getFileSize() > 0 || mediaSource.isHLS();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_crappers);
        ((FreeMoviesApp) getApplication()).getReactNativeHost();
        MovieInfo movieInfo = new MovieInfo("Thor: Ragnarok", "2017", "", "", "");
        for (BaseProvider baseProvider : BaseProvider.f37247c) {
            if (baseProvider != null) {
                this.f32172b.b(baseProvider.F(movieInfo).throttleFirst(0, TimeUnit.MICROSECONDS).flatMap(new k0()).map(new Function<MediaSource, MediaSource>() {
                    /* renamed from: a */
                    public MediaSource apply(MediaSource mediaSource) throws Exception {
                        return b(mediaSource);
                    }

                    public MediaSource b(MediaSource mediaSource) {
                        String str;
                        String str2;
                        try {
                            String lowerCase = mediaSource.getStreamLink().trim().toLowerCase();
                            HashMap<String, String> hashMap = new HashMap<>();
                            String str3 = "";
                            if (!Regex.a(lowerCase, "//[^/]*(ntcdn|micetop)\\.[^/]{2,8}/", 1).isEmpty()) {
                                HashMap<String, String> playHeader = mediaSource.getPlayHeader();
                                if (playHeader != null) {
                                    hashMap = playHeader;
                                }
                                if (hashMap.containsKey("Referer")) {
                                    str2 = hashMap.get("Referer");
                                } else if (hashMap.containsKey("referer")) {
                                    str2 = hashMap.get("referer");
                                } else {
                                    str2 = str3;
                                }
                                if (str2 != null) {
                                    str3 = str2.toLowerCase();
                                }
                                if (lowerCase.contains("vidcdn_pro/") && !str3.contains("vidnode.net")) {
                                    hashMap.put("Referer", "https://vidnode.net/");
                                } else if (lowerCase.contains("s7_ntcdn_us/") && !str3.contains("m4ufree.info")) {
                                    hashMap.put("Referer", "http://m4ufree.info/");
                                }
                                if (!hashMap.containsKey("User-Agent") && !hashMap.containsKey("user-agent")) {
                                    hashMap.put("User-Agent", Constants.C);
                                }
                                mediaSource.setPlayHeader(hashMap);
                            } else if (Regex.a(lowerCase, "//[^/]*(vidcdn)\\.pro/stream/", 1).isEmpty() || lowerCase.contains(".m3u8")) {
                                if (mediaSource.getPlayHeader() == null) {
                                    mediaSource.setPlayHeader(new HashMap());
                                }
                                if (!mediaSource.getPlayHeader().containsKey("User-Agent")) {
                                    mediaSource.getPlayHeader().put("User-Agent", Constants.C);
                                }
                            } else {
                                HashMap<String, String> playHeader2 = mediaSource.getPlayHeader();
                                if (playHeader2.containsKey("Referer")) {
                                    str = playHeader2.get("Referer");
                                } else if (playHeader2.containsKey("referer")) {
                                    str = playHeader2.get("referer");
                                } else {
                                    str = str3;
                                }
                                if (str != null) {
                                    str3 = str.toLowerCase();
                                }
                                if (!str3.contains("vidnode.net")) {
                                    playHeader2.put("Referer", "https://vidnode.net/");
                                }
                                if (!playHeader2.containsKey("User-Agent") && !playHeader2.containsKey("user-agent")) {
                                    playHeader2.put("User-Agent", Constants.C);
                                }
                                mediaSource.setPlayHeader(playHeader2);
                            }
                        } catch (Throwable th) {
                            Logger.d(th, new boolean[0]);
                        }
                        return mediaSource;
                    }
                }).filter(new l0()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new m0(), new n0()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32172b.dispose();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().m(this);
    }
}
