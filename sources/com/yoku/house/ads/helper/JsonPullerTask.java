package com.yoku.house.ads.helper;

import android.os.AsyncTask;
import android.util.Log;

public class JsonPullerTask extends AsyncTask<String, String, String> {

    /* renamed from: a  reason: collision with root package name */
    private final String f38017a;

    /* renamed from: b  reason: collision with root package name */
    private final JsonPullerListener f38018b;

    public interface JsonPullerListener {
        void a(String str);
    }

    public JsonPullerTask(String str, JsonPullerListener jsonPullerListener) {
        this.f38017a = str;
        this.f38018b = jsonPullerListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        return HouseAdsHelper.b(this.f38017a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        this.f38018b.a(str);
        Log.d("Response", str);
    }
}
