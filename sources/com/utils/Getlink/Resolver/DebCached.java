package com.utils.Getlink.Resolver;

import com.original.tase.Logger;
import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import io.reactivex.ObservableEmitter;

public class DebCached extends PremiumResolver {
    public String c() {
        return "Deb-Cached";
    }

    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        mediaSource.setHostName(c());
        try {
            if (!BaseResolver.f37516a) {
                if (!mediaSource.isTorrent()) {
                    PremiumResolver.o(mediaSource, observableEmitter, true, false, false);
                    return;
                }
            }
            PremiumResolver.n(mediaSource, observableEmitter, true, false, false);
        } catch (Exception e2) {
            Logger.a(e2.getMessage());
        }
    }
}
