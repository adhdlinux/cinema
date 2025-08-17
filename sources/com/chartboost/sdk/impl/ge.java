package com.chartboost.sdk.impl;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class ge extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public a f17786a;

    /* renamed from: b  reason: collision with root package name */
    public final b f17787b;

    public interface a {
        void a(ge geVar);
    }

    public interface b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public ge(b bVar) {
        this.f17787b = bVar;
    }

    public void a(a aVar) {
        this.f17786a = aVar;
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.f17786a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
