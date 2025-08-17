package com.utils.Getlink.Resolver.premium;

import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Resolver.BaseResolver;
import com.utils.Getlink.Resolver.premium.services.AllDebrid;
import com.utils.Getlink.Resolver.premium.services.Premiumzie;
import com.utils.Getlink.Resolver.premium.services.Realdebrid;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public abstract class PremiumResolver extends BaseResolver {

    /* renamed from: e  reason: collision with root package name */
    private static Realdebrid f37555e = new Realdebrid();

    /* renamed from: f  reason: collision with root package name */
    private static Premiumzie f37556f = new Premiumzie();

    /* renamed from: g  reason: collision with root package name */
    private static AllDebrid f37557g = new AllDebrid();

    protected static void n(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter, boolean z2, boolean z3, boolean z4) {
        MediaSource cloneDeeply = mediaSource.cloneDeeply();
        cloneDeeply.setResolved(false);
        if (z2) {
            try {
                if (RealDebridCredentialsHelper.d().isValid()) {
                    f37555e.a(cloneDeeply, observableEmitter);
                }
            } catch (Exception e2) {
                Timber.d(e2);
            }
        }
        if (z4) {
            try {
                if (PremiumizeCredentialsHelper.b().isValid()) {
                    f37556f.a(cloneDeeply, observableEmitter);
                }
            } catch (Exception e3) {
                Timber.d(e3);
            }
        }
        if (z3) {
            try {
                if (AllDebridCredentialsHelper.b().isValid()) {
                    f37557g.a(cloneDeeply, observableEmitter);
                }
            } catch (Exception e4) {
                Timber.d(e4);
            }
        }
    }

    protected static void o(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter, boolean z2, boolean z3, boolean z4) {
        MediaSource cloneDeeply = mediaSource.cloneDeeply();
        if (z2) {
            try {
                if (RealDebridCredentialsHelper.d().isValid()) {
                    f37555e.e(cloneDeeply, observableEmitter);
                }
            } catch (Exception e2) {
                Timber.d(e2);
            }
        }
        if (z3) {
            try {
                if (AllDebridCredentialsHelper.b().isValid()) {
                    f37557g.d(cloneDeeply, observableEmitter);
                }
            } catch (Exception e3) {
                Timber.d(e3);
            }
        }
        if (z4) {
            try {
                if (PremiumizeCredentialsHelper.b().isValid()) {
                    f37556f.c(cloneDeeply, observableEmitter);
                }
            } catch (Exception e4) {
                Timber.d(e4);
            }
        }
    }

    public static Observable<MediaSource> p(final MediaSource mediaSource) {
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                if (MediaSource.this.isResolved()) {
                    observableEmitter.onNext(MediaSource.this);
                } else {
                    MediaSource mediaSource = MediaSource.this;
                    PremiumResolver.o(mediaSource, observableEmitter, mediaSource.isRealdebrid(), MediaSource.this.isAlldebrid(), MediaSource.this.isPremiumize());
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c());
    }

    public String c() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        mediaSource.setHostName(c());
        if (BaseResolver.f37516a || mediaSource.isTorrent()) {
            n(mediaSource, observableEmitter, true, true, true);
        } else {
            o(mediaSource, observableEmitter, true, true, true);
        }
    }
}
