package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

public final class InputContentInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    private final InputContentInfoCompatImpl f2894a;

    private static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2896a;

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f2897b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f2898c;

        InputContentInfoCompatBaseImpl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2896a = uri;
            this.f2897b = clipDescription;
            this.f2898c = uri2;
        }

        public Uri a() {
            return this.f2896a;
        }

        public Object b() {
            return null;
        }

        public void c() {
        }

        public Uri d() {
            return this.f2898c;
        }

        public ClipDescription getDescription() {
            return this.f2897b;
        }
    }

    private interface InputContentInfoCompatImpl {
        Uri a();

        Object b();

        void c();

        Uri d();

        ClipDescription getDescription();
    }

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f2894a = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.f2894a = new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    public static InputContentInfoCompat f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f2894a.a();
    }

    public ClipDescription b() {
        return this.f2894a.getDescription();
    }

    public Uri c() {
        return this.f2894a.d();
    }

    public void d() {
        this.f2894a.c();
    }

    public Object e() {
        return this.f2894a.b();
    }

    private static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f2895a;

        InputContentInfoCompatApi25Impl(Object obj) {
            this.f2895a = (InputContentInfo) obj;
        }

        public Uri a() {
            return this.f2895a.getContentUri();
        }

        public Object b() {
            return this.f2895a;
        }

        public void c() {
            this.f2895a.requestPermission();
        }

        public Uri d() {
            return this.f2895a.getLinkUri();
        }

        public ClipDescription getDescription() {
            return this.f2895a.getDescription();
        }

        InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2895a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.f2894a = inputContentInfoCompatImpl;
    }
}
