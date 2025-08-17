package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class MetadataBackendRegistry implements BackendRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final BackendFactoryProvider f22556a;

    /* renamed from: b  reason: collision with root package name */
    private final CreationContextFactory f22557b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, TransportBackend> f22558c;

    static class BackendFactoryProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Context f22559a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f22560b = null;

        BackendFactoryProvider(Context context) {
            this.f22559a = context;
        }

        private Map<String, String> a(Context context) {
            Bundle d2 = d(context);
            if (d2 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String next : d2.keySet()) {
                Object obj = d2.get(next);
                if ((obj instanceof String) && next.startsWith("backend:")) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, next.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map<String, String> c() {
            if (this.f22560b == null) {
                this.f22560b = a(this.f22559a);
            }
            return this.f22560b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public BackendFactory b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[]{str2}), e2);
                return null;
            } catch (IllegalAccessException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e3);
                return null;
            } catch (InstantiationException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e4);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e6);
                return null;
            }
        }
    }

    @Inject
    MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        this(new BackendFactoryProvider(context), creationContextFactory);
    }

    public synchronized TransportBackend get(String str) {
        if (this.f22558c.containsKey(str)) {
            return this.f22558c.get(str);
        }
        BackendFactory b2 = this.f22556a.b(str);
        if (b2 == null) {
            return null;
        }
        TransportBackend create = b2.create(this.f22557b.a(str));
        this.f22558c.put(str, create);
        return create;
    }

    MetadataBackendRegistry(BackendFactoryProvider backendFactoryProvider, CreationContextFactory creationContextFactory) {
        this.f22558c = new HashMap();
        this.f22556a = backendFactoryProvider;
        this.f22557b = creationContextFactory;
    }
}
