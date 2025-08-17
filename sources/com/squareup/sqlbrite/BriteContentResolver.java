package com.squareup.sqlbrite;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.squareup.sqlbrite.SqlBrite;
import java.util.Arrays;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class BriteContentResolver {
    /* access modifiers changed from: private */
    public final Handler contentObserverHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ContentResolver contentResolver;
    private final SqlBrite.Logger logger;
    /* access modifiers changed from: private */
    public volatile boolean logging;

    BriteContentResolver(ContentResolver contentResolver2, SqlBrite.Logger logger2) {
        this.contentResolver = contentResolver2;
        this.logger = logger2;
    }

    /* access modifiers changed from: private */
    public void log(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        this.logger.log(str);
    }

    public Observable<SqlBrite.Query> createQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2, boolean z2) {
        final Uri uri2 = uri;
        final String[] strArr3 = strArr;
        final String str3 = str;
        final String[] strArr4 = strArr2;
        final String str4 = str2;
        AnonymousClass1 r02 = new SqlBrite.Query() {
            public Cursor run() {
                return BriteContentResolver.this.contentResolver.query(uri2, strArr3, str3, strArr4, str4);
            }
        };
        final boolean z3 = z2;
        final AnonymousClass1 r8 = r02;
        return Observable.c(new Observable.OnSubscribe<SqlBrite.Query>() {
            public void call(final Subscriber<? super SqlBrite.Query> subscriber) {
                final AnonymousClass1 r02 = new ContentObserver(BriteContentResolver.this.contentObserverHandler) {
                    public void onChange(boolean z2) {
                        if (BriteContentResolver.this.logging) {
                            AnonymousClass2 r5 = AnonymousClass2.this;
                            BriteContentResolver briteContentResolver = BriteContentResolver.this;
                            AnonymousClass2 r52 = AnonymousClass2.this;
                            AnonymousClass2 r53 = AnonymousClass2.this;
                            briteContentResolver.log("QUERY\n  uri: %s\n  projection: %s\n  selection: %s\n  selectionArgs: %s\n  sortOrder: %s\n  notifyForDescendents: %s", uri2, Arrays.toString(strArr3), str3, Arrays.toString(strArr4), str4, Boolean.valueOf(z3));
                        }
                        subscriber.onNext(r8);
                    }
                };
                BriteContentResolver.this.contentResolver.registerContentObserver(uri2, z3, r02);
                subscriber.add(Subscriptions.a(new Action0() {
                    public void call() {
                        BriteContentResolver.this.contentResolver.unregisterContentObserver(r02);
                    }
                }));
            }
        }).j(r02).h(BackpressureBufferLastOperator.instance());
    }

    public void setLoggingEnabled(boolean z2) {
        this.logging = z2;
    }
}
