package com.facebook.ads.internal.p.a;

import android.os.AsyncTask;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h extends AsyncTask<l, Void, n> implements c {

    /* renamed from: a  reason: collision with root package name */
    private static Executor f20460a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: b  reason: collision with root package name */
    private a f20461b;

    /* renamed from: c  reason: collision with root package name */
    private b f20462c;

    /* renamed from: d  reason: collision with root package name */
    private Exception f20463d;

    public h(a aVar, b bVar) {
        this.f20461b = aVar;
        this.f20462c = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public n doInBackground(l... lVarArr) {
        if (lVarArr != null) {
            try {
                if (lVarArr.length > 0) {
                    return this.f20461b.a(lVarArr[0]);
                }
            } catch (Exception e2) {
                this.f20463d = e2;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    public void a(l lVar) {
        super.executeOnExecutor(f20460a, new l[]{lVar});
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(n nVar) {
        this.f20462c.a(nVar);
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        this.f20462c.a(this.f20463d);
    }
}
