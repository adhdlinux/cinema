package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Set;

class NotificationCompatJellybean {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2437a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2438b = new Object();

    private NotificationCompatJellybean() {
    }

    static Bundle a(NotificationCompat.Action action) {
        int i2;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat d2 = action.d();
        if (d2 != null) {
            i2 = d2.i();
        } else {
            i2 = 0;
        }
        bundle2.putInt("icon", i2);
        bundle2.putCharSequence("title", action.h());
        bundle2.putParcelable("actionIntent", action.a());
        if (action.c() != null) {
            bundle = new Bundle(action.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", c(action.e()));
        bundle2.putBoolean("showsUserInterface", action.g());
        bundle2.putInt("semanticAction", action.f());
        return bundle2;
    }

    private static Bundle b(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.i());
        bundle.putCharSequence("label", remoteInput.h());
        bundle.putCharSequenceArray("choices", remoteInput.e());
        bundle.putBoolean("allowFreeFormInput", remoteInput.c());
        bundle.putBundle("extras", remoteInput.g());
        Set<String> d2 = remoteInput.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList arrayList = new ArrayList(d2.size());
            for (String add : d2) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] c(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
            bundleArr[i2] = b(remoteInputArr[i2]);
        }
        return bundleArr;
    }
}
