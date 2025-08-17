package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class x9 extends v9 {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ga f36927a;

        public a(ga gaVar) {
            this.f36927a = gaVar;
        }

        public void run() {
            JSONArray jSONArray;
            ga gaVar = this.f36927a;
            gaVar.f34582c.unregisterListener(gaVar.f34585f);
            xb xbVar = x9.this.f36735b;
            ga gaVar2 = this.f36927a;
            gaVar2.getClass();
            try {
                jSONArray = gaVar2.f34581b.a();
            } catch (Exception unused) {
                jSONArray = null;
            }
            xbVar.a(jSONArray);
        }
    }

    public x9(Context context, xb xbVar) {
        super(context, xbVar);
    }

    public void a() {
        try {
            long millis = TimeUnit.SECONDS.toMillis((long) MetaData.f36379h.C().k());
            ga gaVar = new ga(this.f36734a, this.f36735b);
            this.f36736c.postDelayed(new a(gaVar), millis);
            gaVar.b();
        } catch (Throwable th) {
            y8.a(this.f36734a, th);
            this.f36735b.a((Object) null);
        }
    }
}
