package com.utils.Getlink.Resolver.premium.services;

import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.hermes.intl.Constants;
import com.movie.data.api.premiumize.PremiumizeApi;
import com.movie.data.api.premiumize.PremiumizeModule;
import com.movie.data.model.realdebrid.MagnetObject;
import com.original.tase.Logger;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeUserApi;
import com.original.tase.model.debrid.premiumize.PremiumizeCacheCheckResponse;
import com.original.tase.model.debrid.premiumize.PremiumizeDirectDL;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

public class Premiumzie extends BaseService {
    public void a(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (mediaSource.isTorrent()) {
            b(mediaSource, observableEmitter);
        } else if (PremiumizeCredentialsHelper.b().isValid()) {
            try {
                PremiumizeApi b2 = PremiumizeModule.b();
                String encode = URLEncoder.encode(mediaSource.getStreamLink(), AudienceNetworkActivity.WEBVIEW_ENCODING);
                int i2 = 0;
                PremiumizeCacheCheckResponse body = b2.getPremiumizeCacheCheckResponse(PremiumizeCredentialsHelper.b().getAccessToken(), new String[]{encode}).execute().body();
                if (body != null && body.status.contains("success")) {
                    while (true) {
                        String[] strArr = body.response;
                        if (i2 < strArr.length) {
                            String str = strArr[i2];
                            String str2 = body.transcoded[i2];
                            String str3 = body.filename[i2];
                            String str4 = body.filesize[i2];
                            if (str2 != null && !str2.isEmpty() && !str2.equals(Constants.CASEFIRST_FALSE) && str != null && !str.isEmpty() && !str.equals(Constants.CASEFIRST_FALSE) && !str3.isEmpty() && !str4.isEmpty() && !str4.equals("0") && !str3.endsWith(".rar") && !str3.endsWith(".7z") && !str3.endsWith(".zip") && !str3.endsWith(".iso") && !str3.endsWith(".avi") && !str3.endsWith(".flv") && !str3.endsWith(".sub") && !str3.endsWith(".pdf") && !str3.endsWith(".mp3")) {
                                MediaSource cloneDeeply = mediaSource.cloneDeeply();
                                cloneDeeply.setFileSize(Long.parseLong(str4));
                                cloneDeeply.setPremiumize(true);
                                cloneDeeply.setFilename(str3);
                                observableEmitter.onNext(cloneDeeply);
                            }
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.b("PREMIUMIZE", th.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (PremiumizeCredentialsHelper.b().isValid() && PremiumizeUserApi.c().b()) {
            try {
                ArrayList<MagnetObject> magnetObjects = mediaSource.getMagnetObjects();
                magnetObjects.iterator();
                ArrayList arrayList = new ArrayList();
                Iterator<MagnetObject> it2 = magnetObjects.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Regex.a(it2.next().getMagnet(), "magnet:\\?xt=urn:btih:([^&.]+)", 1).toLowerCase());
                }
                int i2 = 0;
                PremiumizeCacheCheckResponse body = PremiumizeModule.b().getPremiumizeCacheCheckResponse(PremiumizeCredentialsHelper.b().getAccessToken(), (String[]) arrayList.toArray(new String[0])).execute().body();
                if (body != null && body.status.contains("success")) {
                    while (true) {
                        String[] strArr = body.response;
                        if (i2 < strArr.length) {
                            String str = strArr[i2];
                            String str2 = body.transcoded[i2];
                            String str3 = body.filename[i2];
                            String str4 = body.filesize[i2];
                            MagnetObject magnetObject = magnetObjects.get(i2);
                            if (str != null && !str.isEmpty() && !str.equals(Constants.CASEFIRST_FALSE) && str3 != null && !str3.isEmpty() && !str4.isEmpty() && !str4.equals("0") && !str3.endsWith(".rar") && !str3.endsWith(".7z") && !str3.endsWith(".zip") && !str3.endsWith(".iso") && !str3.endsWith(".avi") && !str3.endsWith(".flv") && !str3.endsWith(".sub") && !str3.endsWith(".pdf") && !str3.endsWith(".mp3")) {
                                MediaSource cloneDeeply = mediaSource.cloneDeeply();
                                cloneDeeply.setOriginalLink(magnetObject.getMagnet());
                                cloneDeeply.setStreamLink(magnetObject.getMagnet());
                                cloneDeeply.setFileSize(Long.parseLong(str4));
                                cloneDeeply.setQuality(magnetObject.getQuality());
                                cloneDeeply.setHostName(magnetObject.getHostName());
                                cloneDeeply.setPremiumize(true);
                                cloneDeeply.setProviderName(magnetObject.getProvider());
                                cloneDeeply.setFilename(magnetObject.getFileName());
                                observableEmitter.onNext(cloneDeeply);
                            }
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.b("PREMIUMIZE", th.getMessage());
            }
        }
    }

    public void c(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        MediaSource cloneDeeply = mediaSource.cloneDeeply();
        if (cloneDeeply.isTorrent()) {
            d(cloneDeeply, observableEmitter);
        }
    }

    /* access modifiers changed from: protected */
    public void d(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (mediaSource.isTorrent()) {
            try {
                PremiumizeDirectDL body = PremiumizeModule.b().getPremiumizeDirectDL(PremiumizeCredentialsHelper.b().getAccessToken(), mediaSource.getStreamLink()).execute().body();
                if (body != null && body.getStatus().contains("success")) {
                    for (PremiumizeDirectDL.ContentBean next : body.getContent()) {
                        if (next.getStream_link() != null && !next.getStream_link().isEmpty() && next.getSize() > 20971520) {
                            MediaSource cloneDeeply = mediaSource.cloneDeeply();
                            cloneDeeply.setStreamLink(next.getStream_link());
                            cloneDeeply.setPremiumize(true);
                            cloneDeeply.setResolved(true);
                            observableEmitter.onNext(cloneDeeply);
                        }
                    }
                }
            } catch (IOException e2) {
                Logger.b("PREMIUMIZE", e2.getMessage());
            }
        }
    }
}
