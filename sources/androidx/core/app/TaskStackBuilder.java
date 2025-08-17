package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Intent> f2472b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Context f2473c;

    static class Api16Impl {
        private Api16Impl() {
        }

        static PendingIntent a(Context context, int i2, Intent[] intentArr, int i3, Bundle bundle) {
            return PendingIntent.getActivities(context, i2, intentArr, i3, bundle);
        }
    }

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context context) {
        this.f2473c = context;
    }

    public static TaskStackBuilder e(Context context) {
        return new TaskStackBuilder(context);
    }

    public TaskStackBuilder a(Intent intent) {
        this.f2472b.add(intent);
        return this;
    }

    public TaskStackBuilder b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f2473c.getPackageManager());
        }
        if (component != null) {
            d(component);
        }
        a(intent);
        return this;
    }

    public TaskStackBuilder c(Activity activity) {
        Intent intent;
        if (activity instanceof SupportParentable) {
            intent = ((SupportParentable) activity).getSupportParentActivityIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = NavUtils.a(activity);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f2473c.getPackageManager());
            }
            d(component);
            a(intent);
        }
        return this;
    }

    public TaskStackBuilder d(ComponentName componentName) {
        int size = this.f2472b.size();
        try {
            Intent b2 = NavUtils.b(this.f2473c, componentName);
            while (b2 != null) {
                this.f2472b.add(size, b2);
                b2 = NavUtils.b(this.f2473c, b2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public PendingIntent g(int i2, int i3) {
        return h(i2, i3, (Bundle) null);
    }

    public PendingIntent h(int i2, int i3, Bundle bundle) {
        if (!this.f2472b.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f2472b.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return Api16Impl.a(this.f2473c, i2, intentArr, i3, bundle);
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public void i() {
        j((Bundle) null);
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2472b.iterator();
    }

    public void j(Bundle bundle) {
        if (!this.f2472b.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f2472b.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!ContextCompat.startActivities(this.f2473c, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f2473c.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
