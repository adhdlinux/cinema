package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

public class FontsContractCompat {

    public static class FontFamilyResult {

        /* renamed from: a  reason: collision with root package name */
        private final int f2661a;

        /* renamed from: b  reason: collision with root package name */
        private final FontInfo[] f2662b;

        @Deprecated
        public FontFamilyResult(int i2, FontInfo[] fontInfoArr) {
            this.f2661a = i2;
            this.f2662b = fontInfoArr;
        }

        static FontFamilyResult a(int i2, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i2, fontInfoArr);
        }

        public FontInfo[] b() {
            return this.f2662b;
        }

        public int c() {
            return this.f2661a;
        }
    }

    public static class FontInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2663a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2664b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2665c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2666d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2667e;

        @Deprecated
        public FontInfo(Uri uri, int i2, int i3, boolean z2, int i4) {
            this.f2663a = (Uri) Preconditions.g(uri);
            this.f2664b = i2;
            this.f2665c = i3;
            this.f2666d = z2;
            this.f2667e = i4;
        }

        static FontInfo a(Uri uri, int i2, int i3, boolean z2, int i4) {
            return new FontInfo(uri, i2, i3, z2, i4);
        }

        public int b() {
            return this.f2667e;
        }

        public int c() {
            return this.f2664b;
        }

        public Uri d() {
            return this.f2663a;
        }

        public int e() {
            return this.f2665c;
        }

        public boolean f() {
            return this.f2666d;
        }
    }

    public static class FontRequestCallback {
        public void a(int i2) {
        }

        public void b(Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.b(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult b(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.e(context, fontRequest, cancellationSignal);
    }

    public static Typeface c(Context context, FontRequest fontRequest, int i2, boolean z2, int i3, Handler handler, FontRequestCallback fontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback, handler);
        if (z2) {
            return FontRequestWorker.e(context, fontRequest, callbackWithHandler, i2, i3);
        }
        return FontRequestWorker.d(context, fontRequest, i2, (Executor) null, callbackWithHandler);
    }
}
