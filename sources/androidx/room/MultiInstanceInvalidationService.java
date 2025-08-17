package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: b  reason: collision with root package name */
    int f11446b = 0;

    /* renamed from: c  reason: collision with root package name */
    final HashMap<Integer, String> f11447c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> f11448d = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() {
        /* renamed from: a */
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.f11447c.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final IMultiInstanceInvalidationService.Stub f11449e = new IMultiInstanceInvalidationService.Stub() {
        public void E(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i2) {
            synchronized (MultiInstanceInvalidationService.this.f11448d) {
                MultiInstanceInvalidationService.this.f11448d.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.f11447c.remove(Integer.valueOf(i2));
            }
        }

        public void n(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f11448d) {
                String str = MultiInstanceInvalidationService.this.f11447c.get(Integer.valueOf(i2));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f11448d.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f11448d.getBroadcastCookie(i3)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f11447c.get(Integer.valueOf(intValue));
                        if (i2 != intValue && str.equals(str2)) {
                            MultiInstanceInvalidationService.this.f11448d.getBroadcastItem(i3).c(strArr);
                        }
                    } catch (RemoteException e2) {
                        Log.w("ROOM", "Error invoking a remote callback", e2);
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.f11448d.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.f11448d.finishBroadcast();
            }
        }

        public int s(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f11448d) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.f11446b + 1;
                multiInstanceInvalidationService.f11446b = i2;
                if (multiInstanceInvalidationService.f11448d.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.f11447c.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f11446b--;
                return 0;
            }
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f11449e;
    }
}
