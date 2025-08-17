package com.startapp;

import android.os.AsyncTask;

public abstract class ig extends AsyncTask<Object, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public a f34710a;

    /* renamed from: b  reason: collision with root package name */
    public final b f34711b;

    public interface a {
    }

    public interface b {
    }

    public ig(b bVar) {
        this.f34711b = bVar;
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.f34710a;
        if (aVar != null) {
            jg jgVar = (jg) aVar;
            jgVar.f34788c = null;
            ig poll = jgVar.f34787b.poll();
            jgVar.f34788c = poll;
            if (poll != null) {
                poll.executeOnExecutor(jgVar.f34786a, new Object[0]);
            }
        }
    }
}
