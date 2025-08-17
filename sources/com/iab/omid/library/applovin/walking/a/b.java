package com.iab.omid.library.applovin.walking.a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask<Object, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    private a f31568a;

    /* renamed from: d  reason: collision with root package name */
    protected final C0047b f31569d;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.applovin.walking.a.b$b  reason: collision with other inner class name */
    public interface C0047b {
        void a(JSONObject jSONObject);

        JSONObject b();
    }

    public b(C0047b bVar) {
        this.f31569d = bVar;
    }

    public void a(a aVar) {
        this.f31568a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.f31568a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
