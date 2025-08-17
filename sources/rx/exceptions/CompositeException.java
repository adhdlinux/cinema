package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f42068b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42069c;

    /* renamed from: d  reason: collision with root package name */
    private Throwable f42070d = null;

    static final class CompositeExceptionCausalChain extends RuntimeException {

        /* renamed from: b  reason: collision with root package name */
        static String f42071b = "Chain of Causes for CompositeException In Order Received =>";

        CompositeExceptionCausalChain() {
        }

        public String getMessage() {
            return f42071b;
        }
    }

    private static abstract class PrintStreamOrWriter {
        private PrintStreamOrWriter() {
        }

        /* access modifiers changed from: package-private */
        public abstract Object a();

        /* access modifiers changed from: package-private */
        public abstract void b(Object obj);
    }

    private static class WrappedPrintStream extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f42072a;

        WrappedPrintStream(PrintStream printStream) {
            super();
            this.f42072a = printStream;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.f42072a;
        }

        /* access modifiers changed from: package-private */
        public void b(Object obj) {
            this.f42072a.println(obj);
        }
    }

    private static class WrappedPrintWriter extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f42073a;

        WrappedPrintWriter(PrintWriter printWriter) {
            super();
            this.f42073a = printWriter;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.f42073a;
        }

        /* access modifiers changed from: package-private */
        public void b(Object obj) {
            this.f42073a.println(obj);
        }
    }

    public CompositeException(String str, Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (Throwable th : collection) {
            if (th instanceof CompositeException) {
                linkedHashSet.addAll(((CompositeException) th).b());
            } else {
                linkedHashSet.add(th);
            }
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f42068b = unmodifiableList;
        this.f42069c = unmodifiableList.size() + " exceptions occurred. ";
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private final List<Throwable> c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause == null) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            if (cause.getCause() == null) {
                return arrayList;
            }
            cause = cause.getCause();
        }
    }

    private void d(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        int i2 = 1;
        for (Throwable a2 : this.f42068b) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :");
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            a(sb, a2, "\t");
            i2++;
        }
        synchronized (printStreamOrWriter.a()) {
            printStreamOrWriter.b(sb.toString());
        }
    }

    public List<Throwable> b() {
        return this.f42068b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|(4:13|(2:15|33)(2:16|34)|32|11)|17|18|19|20|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Throwable r0 = r8.f42070d     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x005c
            rx.exceptions.CompositeException$CompositeExceptionCausalChain r0 = new rx.exceptions.CompositeException$CompositeExceptionCausalChain     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Throwable> r2 = r8.f42068b     // Catch:{ all -> 0x0060 }
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
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ all -> 0x0060 }
            goto L_0x0016
        L_0x005a:
            r8.f42070d = r0     // Catch:{ all -> 0x0060 }
        L_0x005c:
            java.lang.Throwable r0 = r8.f42070d     // Catch:{ all -> 0x0060 }
            monitor-exit(r8)
            return r0
        L_0x0060:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public String getMessage() {
        return this.f42069c;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        d(new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        d(new WrappedPrintWriter(printWriter));
    }
}
