package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MultiInstanceInvalidationClient {

    /* renamed from: a  reason: collision with root package name */
    final Context f11425a;

    /* renamed from: b  reason: collision with root package name */
    final String f11426b;

    /* renamed from: c  reason: collision with root package name */
    int f11427c;

    /* renamed from: d  reason: collision with root package name */
    final InvalidationTracker f11428d;

    /* renamed from: e  reason: collision with root package name */
    final InvalidationTracker.Observer f11429e;

    /* renamed from: f  reason: collision with root package name */
    IMultiInstanceInvalidationService f11430f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f11431g;

    /* renamed from: h  reason: collision with root package name */
    final IMultiInstanceInvalidationCallback f11432h = new IMultiInstanceInvalidationCallback.Stub() {
        public void c(final String[] strArr) {
            MultiInstanceInvalidationClient.this.f11431g.execute(new Runnable() {
                public void run() {
                    MultiInstanceInvalidationClient.this.f11428d.e(strArr);
                }
            });
        }
    };

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f11433i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    final ServiceConnection f11434j;

    /* renamed from: k  reason: collision with root package name */
    final Runnable f11435k;

    /* renamed from: l  reason: collision with root package name */
    final Runnable f11436l;

    /* renamed from: m  reason: collision with root package name */
    private final Runnable f11437m;

    MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        AnonymousClass2 r02 = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MultiInstanceInvalidationClient.this.f11430f = IMultiInstanceInvalidationService.Stub.G(iBinder);
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f11431g.execute(multiInstanceInvalidationClient.f11435k);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f11431g.execute(multiInstanceInvalidationClient.f11436l);
                MultiInstanceInvalidationClient.this.f11430f = null;
            }
        };
        this.f11434j = r02;
        this.f11435k = new Runnable() {
            public void run() {
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f11430f;
                    if (iMultiInstanceInvalidationService != null) {
                        multiInstanceInvalidationClient.f11427c = iMultiInstanceInvalidationService.s(multiInstanceInvalidationClient.f11432h, multiInstanceInvalidationClient.f11426b);
                        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                        multiInstanceInvalidationClient2.f11428d.a(multiInstanceInvalidationClient2.f11429e);
                    }
                } catch (RemoteException e2) {
                    Log.w("ROOM", "Cannot register multi-instance invalidation callback", e2);
                }
            }
        };
        this.f11436l = new Runnable() {
            public void run() {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f11428d.g(multiInstanceInvalidationClient.f11429e);
            }
        };
        this.f11437m = new Runnable() {
            public void run() {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f11428d.g(multiInstanceInvalidationClient.f11429e);
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient2.f11430f;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.E(multiInstanceInvalidationClient2.f11432h, multiInstanceInvalidationClient2.f11427c);
                    }
                } catch (RemoteException e2) {
                    Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e2);
                }
                MultiInstanceInvalidationClient multiInstanceInvalidationClient3 = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient3.f11425a.unbindService(multiInstanceInvalidationClient3.f11434j);
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.f11425a = applicationContext;
        this.f11426b = str;
        this.f11428d = invalidationTracker;
        this.f11431g = executor;
        this.f11429e = new InvalidationTracker.Observer((String[]) invalidationTracker.f11402a.keySet().toArray(new String[0])) {
            /* access modifiers changed from: package-private */
            public boolean a() {
                return true;
            }

            public void b(Set<String> set) {
                if (!MultiInstanceInvalidationClient.this.f11433i.get()) {
                    try {
                        MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                        IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f11430f;
                        if (iMultiInstanceInvalidationService != null) {
                            iMultiInstanceInvalidationService.n(multiInstanceInvalidationClient.f11427c, (String[]) set.toArray(new String[0]));
                        }
                    } catch (RemoteException e2) {
                        Log.w("ROOM", "Cannot broadcast invalidation", e2);
                    }
                }
            }
        };
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), r02, 1);
    }
}
