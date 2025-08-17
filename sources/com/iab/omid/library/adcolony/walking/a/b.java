package com.iab.omid.library.adcolony.walking.a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask<Object, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    private a f31451a;

    /* renamed from: b  reason: collision with root package name */
    protected final C0044b f31452b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.adcolony.walking.a.b$b  reason: collision with other inner class name */
    public interface C0044b {
        void a(JSONObject jSONObject);

        JSONObject b();
    }

    public b(C0044b bVar) {
        this.f31452b = bVar;
    }

    public void a(a aVar) {
        this.f31451a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        a aVar = this.f31451a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void c(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
