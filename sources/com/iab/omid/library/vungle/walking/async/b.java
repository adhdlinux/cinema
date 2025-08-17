package com.iab.omid.library.vungle.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask<Object, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    private a f31788a;

    /* renamed from: b  reason: collision with root package name */
    protected final C0051b f31789b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.vungle.walking.async.b$b  reason: collision with other inner class name */
    public interface C0051b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(C0051b bVar) {
        this.f31789b = bVar;
    }

    public void a(a aVar) {
        this.f31788a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        a aVar = this.f31788a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void c(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
