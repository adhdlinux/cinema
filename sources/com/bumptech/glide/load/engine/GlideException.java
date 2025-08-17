package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {

    /* renamed from: h  reason: collision with root package name */
    private static final StackTraceElement[] f16533h = new StackTraceElement[0];

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f16534b;

    /* renamed from: c  reason: collision with root package name */
    private Key f16535c;

    /* renamed from: d  reason: collision with root package name */
    private DataSource f16536d;

    /* renamed from: e  reason: collision with root package name */
    private Class<?> f16537e;

    /* renamed from: f  reason: collision with root package name */
    private String f16538f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f16539g;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable a2 : ((GlideException) th).e()) {
                a(a2, list);
            }
            return;
        }
        list.add(th);
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i2 = i3;
        }
    }

    private static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new IndentedAppendable(appendable));
    }

    public List<Throwable> e() {
        return this.f16534b;
    }

    public List<Throwable> f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List<Throwable> f2 = f();
        int size = f2.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), f2.get(i2));
            i2 = i3;
        }
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f16538f);
        String str3 = "";
        if (this.f16537e != null) {
            str = ", " + this.f16537e;
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.f16536d != null) {
            str2 = ", " + this.f16536d;
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (this.f16535c != null) {
            str3 = ", " + this.f16535c;
        }
        sb.append(str3);
        List<Throwable> f2 = f();
        if (f2.isEmpty()) {
            return sb.toString();
        }
        if (f2.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(f2.size());
            sb.append(" causes:");
        }
        for (Throwable next : f2) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append('(');
            sb.append(next.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void i(Key key, DataSource dataSource) {
        j(key, dataSource, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void j(Key key, DataSource dataSource, Class<?> cls) {
        this.f16535c = key;
        this.f16536d = dataSource;
        this.f16537e = cls;
    }

    public void k(Exception exc) {
        this.f16539g = exc;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.f16538f = str;
        setStackTrace(f16533h);
        this.f16534b = list;
    }

    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    private static final class IndentedAppendable implements Appendable {

        /* renamed from: b  reason: collision with root package name */
        private final Appendable f16540b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16541c = true;

        IndentedAppendable(Appendable appendable) {
            this.f16540b = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c2) throws IOException {
            boolean z2 = false;
            if (this.f16541c) {
                this.f16541c = false;
                this.f16540b.append("  ");
            }
            if (c2 == 10) {
                z2 = true;
            }
            this.f16541c = z2;
            this.f16540b.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        public Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence a2 = a(charSequence);
            boolean z2 = false;
            if (this.f16541c) {
                this.f16541c = false;
                this.f16540b.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i3 - 1) == 10) {
                z2 = true;
            }
            this.f16541c = z2;
            this.f16540b.append(a2, i2, i3);
            return this;
        }
    }
}
