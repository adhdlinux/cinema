package com.utils.Getlink.Resolver.premium.services;

import com.movie.data.api.alldebrid.AllDebridModule;
import com.movie.data.model.realdebrid.MagnetObject;
import com.original.tase.Logger;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.alldebrid.AllDebridUserApi;
import com.original.tase.model.debrid.alldebrid.ADResponceLink;
import com.original.tase.model.debrid.alldebrid.Torrent.ADTorrentInstant;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Iterator;

public class AllDebrid extends BaseService {
    public void a(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (mediaSource.isTorrent()) {
            b(mediaSource, observableEmitter);
        } else {
            e(mediaSource, observableEmitter);
        }
    }

    /* access modifiers changed from: protected */
    public void b(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (AllDebridCredentialsHelper.b().isValid() && AllDebridUserApi.d().b()) {
            try {
                ArrayList<MagnetObject> magnetObjects = mediaSource.getMagnetObjects();
                ArrayList arrayList = new ArrayList();
                Iterator<MagnetObject> it2 = magnetObjects.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Regex.a(it2.next().getMagnet(), "magnet:\\?xt=urn:btih:([^&.]+)", 1).toLowerCase());
                }
                ADTorrentInstant body = AllDebridModule.b().getAllDebridInstance(arrayList).execute().body();
                for (ADTorrentInstant.DataBean.MagnetsBean next : body.getData().getMagnets()) {
                    MagnetObject c2 = c(next.getHash(), magnetObjects);
                    if (next.isInstant() && body.getStatus().contains("success")) {
                        MediaSource cloneDeeply = mediaSource.cloneDeeply();
                        cloneDeeply.setOriginalLink(next.getMagnet());
                        cloneDeeply.setHostName(c2.getHostName());
                        cloneDeeply.setStreamLink(c2.getMagnet());
                        cloneDeeply.setQuality(c2.getQuality());
                        cloneDeeply.setAlldebrid(true);
                        cloneDeeply.setProviderName(c2.getProvider());
                        cloneDeeply.setFilename(c2.getFileName());
                        observableEmitter.onNext(cloneDeeply);
                    }
                }
            } catch (Throwable th) {
                Logger.b("ALLDEBIRD", th.getMessage());
            }
        }
    }

    public MagnetObject c(String str, ArrayList<MagnetObject> arrayList) {
        Iterator<MagnetObject> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            MagnetObject next = it2.next();
            if (next.getMagnet().contains(str)) {
                return next;
            }
        }
        return null;
    }

    public void d(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (mediaSource.isTorrent()) {
            e(mediaSource, observableEmitter);
        } else if (!mediaSource.isResolved()) {
            e(mediaSource, observableEmitter);
        } else {
            observableEmitter.onNext(mediaSource);
        }
    }

    /* access modifiers changed from: protected */
    public void e(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        try {
            ADResponceLink body = AllDebridModule.b().getdownloadlink(mediaSource.getStreamLink()).execute().body();
            if (body != null && body.getStatus().contains("success")) {
                String link = body.getData().getLink();
                if (!link.endsWith(".rar") && !link.endsWith(".7z") && !link.endsWith(".zip") && !link.endsWith(".iso") && !link.endsWith(".avi") && !link.endsWith(".flv") && !link.endsWith(".sub") && !link.endsWith(".pdf") && !link.endsWith(".mp3")) {
                    Logger.b("ALLDEBRIDRESOLVED", link);
                    mediaSource.setStreamLink(link);
                    mediaSource.setAlldebrid(true);
                    mediaSource.setFileSize(body.getData().getFilesize());
                    mediaSource.setResolved(true);
                    mediaSource.setFilename(body.getData().getFilename());
                    observableEmitter.onNext(mediaSource);
                }
            }
        } catch (Throwable th) {
            Logger.b("ALLDEBRIDRESOLVED", th.getMessage());
        }
    }
}
