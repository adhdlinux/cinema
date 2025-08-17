package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzgpg {
    private static final Logger zza = Logger.getLogger(zzgot.class.getName());
    private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzgpg() {
    }

    static zzgoy zzb(Class cls) {
        String str;
        Class<zzgpg> cls2 = zzgpg.class;
        ClassLoader classLoader = cls2.getClassLoader();
        if (cls.equals(zzgoy.class)) {
            str = zzb;
        } else if (cls.getPackage().equals(cls2.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzgoy) cls.cast(((zzgpg) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException(e2);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(e4);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException(e5);
        } catch (ClassNotFoundException unused) {
            Iterator<S> it2 = ServiceLoader.load(cls2, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it2.hasNext()) {
                try {
                    arrayList.add((zzgoy) cls.cast(((zzgpg) it2.next()).zza()));
                } catch (ServiceConfigurationError e6) {
                    zza.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), e6);
                }
            }
            if (arrayList.size() == 1) {
                return (zzgoy) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzgoy) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract zzgoy zza();
}
