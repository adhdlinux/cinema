package com.startapp;

import android.content.Context;
import android.os.Bundle;
import com.startapp.be;
import com.startapp.networkTest.startapp.NetworkTester;

public final class yd extends be {

    public class a implements NetworkTester.b {
        public a() {
        }

        public void a(boolean z2) {
            yd.this.callback.a(yd.this, z2);
        }
    }

    public yd(Context context, be.a aVar, Bundle bundle) {
        super(context, aVar, bundle);
    }

    public void run() {
        NetworkTester.runTests(this.context, new a());
    }
}
