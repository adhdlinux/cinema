package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f38328b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38329c;

    /* renamed from: d  reason: collision with root package name */
    private Throwable f38330d;

    static final class CompositeExceptionCausalChain extends RuntimeException {
        CompositeExceptionCausalChain() {
        }

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    static abstract class PrintStreamOrWriter {
        PrintStreamOrWriter() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Object obj);
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f38331a;

        WrappedPrintStream(PrintStream printStream) {
            this.f38331a = printStream;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            this.f38331a.println(obj);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f38332a;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.f38332a = printWriter;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            this.f38332a.println(obj);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeException(Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private List<Throwable> c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    private void e(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i2 = 1;
        for (Throwable a2 : this.f38328b) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :\n");
            a(sb, a2, "\t");
            i2++;
        }
        printStreamOrWriter.a(sb.toString());
    }

    public List<Throwable> b() {
        return this.f38328b;
    }

    /* access modifiers changed from: package-private */
    public Throwable d(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || th == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                return cause;
            }
            cause = cause2;
        }
        return cause;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|(4:13|(2:15|33)(2:16|34)|32|11)|17|18|19|20|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Throwable r0 = r8.f38330d     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x005c
            io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain r0 = new io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Throwable> r2 = r8.f38328b     // Catch:{ all -> 0x0060 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0060 }
            r3 = r0
        L_0x0016:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0060 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0060 }
            boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            r1.add(r4)     // Catch:{ all -> 0x0060 }
            java.util.List r5 = r8.c(r4)     // Catch:{ all -> 0x0060 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x0052
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0060 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0060 }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x004e
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
            r4.<init>(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0034
        L_0x004e:
            r1.add(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0034
        L_0x0052:
            r3.initCause(r4)     // Catch:{ all -> 0x0055 }
        L_0x0055:
            java.lang.Throwable r3 = r8.d(r3)     // Catch:{ all -> 0x0060 }
            goto L_0x0016
        L_0x005a:
            r8.f38330d = r0     // Catch:{ all -> 0x0060 }
        L_0x005c:
            java.lang.Throwable r0 = r8.f38330d     // Catch:{ all -> 0x0060 }
            monitor-exit(r8)
            return r0
        L_0x0060:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public String getMessage() {
        return this.f38329c;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        e(new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        e(new WrappedPrintWriter(printWriter));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
            this.f38328b = unmodifiableList;
            this.f38329c = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
