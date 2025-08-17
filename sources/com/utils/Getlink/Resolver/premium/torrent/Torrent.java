package com.utils.Getlink.Resolver.premium.torrent;

import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import io.reactivex.ObservableEmitter;

public class Torrent extends PremiumResolver {
    public String c() {
        return "Cached Torrent";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        super.l(mediaSource, observableEmitter);
    }
}
