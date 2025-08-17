package kotlin.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

public final class TextStreamsKt {
    public static final long a(Reader reader, Writer writer, int i2) {
        Intrinsics.f(reader, "<this>");
        Intrinsics.f(writer, "out");
        char[] cArr = new char[i2];
        int read = reader.read(cArr);
        long j2 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j2 += (long) read;
            read = reader.read(cArr);
        }
        return j2;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return a(reader, writer, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        kotlin.io.CloseableKt.a(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void c(java.io.Reader r2, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            boolean r0 = r2 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r2, r1)
            r2 = r0
        L_0x0019:
            kotlin.sequences.Sequence r0 = d(r2)     // Catch:{ all -> 0x0036 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0036 }
        L_0x0021:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0036 }
            r3.invoke(r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0021
        L_0x002f:
            kotlin.Unit r3 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0036 }
            r3 = 0
            kotlin.io.CloseableKt.a(r2, r3)
            return
        L_0x0036:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.c(java.io.Reader, kotlin.jvm.functions.Function1):void");
    }

    public static final Sequence<String> d(BufferedReader bufferedReader) {
        Intrinsics.f(bufferedReader, "<this>");
        return SequencesKt__SequencesKt.d(new LinesSequence(bufferedReader));
    }

    public static final String e(Reader reader) {
        Intrinsics.f(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.e(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }
}
