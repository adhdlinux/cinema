package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public final class CharStreams {
    private CharStreams() {
    }

    public static Writer a(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }

    public static long b(Readable readable, Appendable appendable) throws IOException {
        if (!(readable instanceof Reader)) {
            Preconditions.l(readable);
            Preconditions.l(appendable);
            CharBuffer e2 = e();
            long j2 = 0;
            while (readable.read(e2) != -1) {
                Java8Compatibility.b(e2);
                appendable.append(e2);
                j2 += (long) e2.remaining();
                Java8Compatibility.a(e2);
            }
            return j2;
        } else if (appendable instanceof StringBuilder) {
            return c((Reader) readable, (StringBuilder) appendable);
        } else {
            return d((Reader) readable, a(appendable));
        }
    }

    static long c(Reader reader, StringBuilder sb) throws IOException {
        Preconditions.l(reader);
        Preconditions.l(sb);
        char[] cArr = new char[2048];
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j2;
            }
            sb.append(cArr, 0, read);
            j2 += (long) read;
        }
    }

    static long d(Reader reader, Writer writer) throws IOException {
        Preconditions.l(reader);
        Preconditions.l(writer);
        char[] cArr = new char[2048];
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j2;
            }
            writer.write(cArr, 0, read);
            j2 += (long) read;
        }
    }

    static CharBuffer e() {
        return CharBuffer.allocate(2048);
    }

    public static <T> T f(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String b2;
        Preconditions.l(readable);
        Preconditions.l(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            b2 = lineReader.b();
            if (b2 == null || !lineProcessor.a(b2)) {
            }
            b2 = lineReader.b();
            break;
        } while (!lineProcessor.a(b2));
        return lineProcessor.getResult();
    }

    public static String g(Readable readable) throws IOException {
        return h(readable).toString();
    }

    private static StringBuilder h(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            c((Reader) readable, sb);
        } else {
            b(readable, sb);
        }
        return sb;
    }
}
