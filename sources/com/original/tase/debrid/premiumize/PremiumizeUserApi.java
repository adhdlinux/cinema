package com.original.tase.debrid.premiumize;

import com.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class PremiumizeUserApi {

    /* renamed from: b  reason: collision with root package name */
    private static volatile PremiumizeUserApi f33794b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f33795c = "";

    /* renamed from: a  reason: collision with root package name */
    private boolean f33796a = false;

    public static PremiumizeUserApi c() {
        if (f33794b == null) {
            synchronized (PremiumizeUserApi.class) {
                if (f33794b == null) {
                    f33794b = new PremiumizeUserApi();
                }
            }
        }
        return f33794b;
    }

    public void a() {
        this.f33796a = Utils.l(Utils.RDTYPE.PREMIUMIZE);
    }

    public boolean b() {
        return this.f33796a;
    }

    public Observable<Boolean> d(String str) {
        f33795c = str;
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                observableEmitter.onNext(Boolean.TRUE);
                observableEmitter.onComplete();
            }
        });
    }
}
