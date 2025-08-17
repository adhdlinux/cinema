package androidx.media3.common.util;

import java.util.Arrays;

public abstract class LibraryLoader {

    /* renamed from: a  reason: collision with root package name */
    private String[] f4653a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4654b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4655c;

    public LibraryLoader(String... strArr) {
        this.f4653a = strArr;
    }

    public synchronized boolean a() {
        if (this.f4654b) {
            return this.f4655c;
        }
        this.f4654b = true;
        try {
            for (String b2 : this.f4653a) {
                b(b2);
            }
            this.f4655c = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.h("LibraryLoader", "Failed to load " + Arrays.toString(this.f4653a));
        }
        return this.f4655c;
    }

    /* access modifiers changed from: protected */
    public abstract void b(String str);
}
