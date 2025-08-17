package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

public abstract class CustomTabsServiceConnection implements ServiceConnection {
    private Context mApplicationContext;

    /* access modifiers changed from: package-private */
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.mApplicationContext != null) {
            onCustomTabsServiceConnected(componentName, new CustomTabsClient(ICustomTabsService.Stub.G(iBinder), componentName, this.mApplicationContext) {
            });
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }

    /* access modifiers changed from: package-private */
    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}
