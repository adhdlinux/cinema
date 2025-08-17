package com.google.vr.dynamite.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import dalvik.system.DexClassLoader;

@UsedByNative
public final class DynamiteClient {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayMap f31144a = new ArrayMap();

    private DynamiteClient() {
    }

    @UsedByNative
    public static synchronized int checkVersion(Context context, String str, String str2, String str3) {
        synchronized (DynamiteClient.class) {
            f fVar = new f(str, str2);
            e remoteLibraryLoaderFromInfo = getRemoteLibraryLoaderFromInfo(fVar);
            try {
                INativeLibraryLoader newNativeLibraryLoader = remoteLibraryLoaderFromInfo.a(context).newNativeLibraryLoader(ObjectWrapper.G(remoteLibraryLoaderFromInfo.b(context)), ObjectWrapper.G(context));
                if (newNativeLibraryLoader == null) {
                    String obj = fVar.toString();
                    StringBuilder sb = new StringBuilder(obj.length() + 72);
                    sb.append("Failed to load native library ");
                    sb.append(obj);
                    sb.append(" from remote package: no loader available.");
                    Log.e("DynamiteClient", sb.toString());
                    return -1;
                }
                int checkVersion = newNativeLibraryLoader.checkVersion(str3);
                return checkVersion;
            } catch (RemoteException | d | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e2) {
                String obj2 = fVar.toString();
                StringBuilder sb2 = new StringBuilder(obj2.length() + 54);
                sb2.append("Failed to load native library ");
                sb2.append(obj2);
                sb2.append(" from remote package:\n  ");
                Log.e("DynamiteClient", sb2.toString(), e2);
                return -1;
            }
        }
    }

    @UsedByNative
    public static synchronized ClassLoader getRemoteClassLoader(Context context, String str, String str2) {
        synchronized (DynamiteClient.class) {
            Context remoteContext = getRemoteContext(context, str, str2);
            if (remoteContext == null) {
                return null;
            }
            ClassLoader classLoader = remoteContext.getClassLoader();
            return classLoader;
        }
    }

    @UsedByNative
    public static synchronized Context getRemoteContext(Context context, String str, String str2) {
        Context b2;
        synchronized (DynamiteClient.class) {
            f fVar = new f(str, str2);
            try {
                b2 = getRemoteLibraryLoaderFromInfo(fVar).b(context);
            } catch (d e2) {
                String obj = fVar.toString();
                StringBuilder sb = new StringBuilder(obj.length() + 52);
                sb.append("Failed to get remote Context");
                sb.append(obj);
                sb.append(" from remote package:\n  ");
                Log.e("DynamiteClient", sb.toString(), e2);
                return null;
            }
        }
        return b2;
    }

    @UsedByNative
    public static synchronized ClassLoader getRemoteDexClassLoader(Context context, String str) {
        synchronized (DynamiteClient.class) {
            Context remoteContext = getRemoteContext(context, str, (String) null);
            if (remoteContext == null) {
                return null;
            }
            try {
                DexClassLoader dexClassLoader = new DexClassLoader(remoteContext.getPackageCodePath(), context.getCodeCacheDir().getAbsolutePath(), remoteContext.getApplicationInfo().nativeLibraryDir, context.getClassLoader());
                return dexClassLoader;
            } catch (RuntimeException e2) {
                Log.e("DynamiteClient", "Failed to create class loader for remote package\n ", e2);
                return null;
            }
        }
    }

    @UsedByNative
    private static synchronized e getRemoteLibraryLoaderFromInfo(f fVar) {
        synchronized (DynamiteClient.class) {
            ArrayMap arrayMap = f31144a;
            e eVar = (e) arrayMap.get(fVar);
            if (eVar != null) {
                return eVar;
            }
            e eVar2 = new e(fVar);
            arrayMap.put(fVar, eVar2);
            return eVar2;
        }
    }

    @UsedByNative
    public static synchronized long loadNativeRemoteLibrary(Context context, String str, String str2) {
        synchronized (DynamiteClient.class) {
            f fVar = new f(str, str2);
            e remoteLibraryLoaderFromInfo = getRemoteLibraryLoaderFromInfo(fVar);
            try {
                INativeLibraryLoader newNativeLibraryLoader = remoteLibraryLoaderFromInfo.a(context).newNativeLibraryLoader(ObjectWrapper.G(remoteLibraryLoaderFromInfo.b(context)), ObjectWrapper.G(context));
                if (newNativeLibraryLoader == null) {
                    String obj = fVar.toString();
                    StringBuilder sb = new StringBuilder(obj.length() + 72);
                    sb.append("Failed to load native library ");
                    sb.append(obj);
                    sb.append(" from remote package: no loader available.");
                    Log.e("DynamiteClient", sb.toString());
                    return 0;
                }
                long initializeAndLoadNativeLibrary = newNativeLibraryLoader.initializeAndLoadNativeLibrary(str2);
                return initializeAndLoadNativeLibrary;
            } catch (RemoteException | d | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e2) {
                String obj2 = fVar.toString();
                StringBuilder sb2 = new StringBuilder(obj2.length() + 54);
                sb2.append("Failed to load native library ");
                sb2.append(obj2);
                sb2.append(" from remote package:\n  ");
                Log.e("DynamiteClient", sb2.toString(), e2);
                return 0;
            }
        }
    }
}
