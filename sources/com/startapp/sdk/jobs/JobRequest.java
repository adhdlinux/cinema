package com.startapp.sdk.jobs;

import com.startapp.be;
import com.startapp.ge;
import java.util.ArrayList;
import java.util.UUID;

public abstract class JobRequest {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f36512a;

    /* renamed from: b  reason: collision with root package name */
    public final UUID f36513b = UUID.randomUUID();

    /* renamed from: c  reason: collision with root package name */
    public final Network f36514c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f36515d;

    public enum Network {
        NONE,
        f36517b,
        UNMETERED
    }

    public static abstract class a<B extends a<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f36520a;

        /* renamed from: b  reason: collision with root package name */
        public Network f36521b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36522c;

        @SafeVarargs
        public a(Class<? extends be>... clsArr) {
            ArrayList arrayList = new ArrayList();
            for (Class<? extends be> name : clsArr) {
                arrayList.add(name.getName());
            }
            this.f36520a = (String[]) arrayList.toArray(new String[0]);
        }
    }

    public JobRequest(a<?> aVar) {
        this.f36512a = aVar.f36520a;
        this.f36514c = aVar.f36521b;
        this.f36515d = aVar.f36522c;
    }

    @SafeVarargs
    public static int a(Class<? extends be>... clsArr) {
        if (clsArr.length == 0) {
            return 0;
        }
        String[] strArr = new String[clsArr.length];
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            strArr[i2] = clsArr[i2].getName();
        }
        return a(strArr);
    }

    public abstract boolean a(ge geVar);

    public static int a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String append : strArr) {
            sb.append(append);
        }
        return sb.toString().hashCode();
    }
}
