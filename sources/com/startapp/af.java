package com.startapp;

import android.content.Context;
import android.os.Bundle;
import com.startapp.be;
import com.startapp.sdk.components.ComponentLocator;

public class af extends be {
    public af(Context context, be.a aVar, Bundle bundle) {
        super(context, aVar, bundle);
    }

    public void run() {
        bf b2 = ComponentLocator.a(this.context).f36440n.b();
        be.a aVar = this.callback;
        if (aVar != null) {
            b2.f34267d.post(new cf(b2, aVar, this));
        } else {
            b2.f34267d.post(b2.f34271h);
        }
    }
}
