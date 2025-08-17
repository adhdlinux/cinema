package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

final class ListChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final ImmutableList<AviChunk> f8182a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8183b;

    private ListChunk(int i2, ImmutableList<AviChunk> immutableList) {
        this.f8183b = i2;
        this.f8182a = immutableList;
    }

    private static AviChunk a(int i2, int i3, ParsableByteArray parsableByteArray) {
        switch (i2) {
            case 1718776947:
                return StreamFormatChunk.d(i3, parsableByteArray);
            case 1751742049:
                return AviMainHeaderChunk.b(parsableByteArray);
            case 1752331379:
                return AviStreamHeaderChunk.c(parsableByteArray);
            case 1852994675:
                return StreamNameChunk.a(parsableByteArray);
            default:
                return null;
        }
    }

    public static ListChunk c(int i2, ParsableByteArray parsableByteArray) {
        AviChunk aviChunk;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int g2 = parsableByteArray.g();
        int i3 = -2;
        while (parsableByteArray.a() > 8) {
            int u2 = parsableByteArray.u();
            int f2 = parsableByteArray.f() + parsableByteArray.u();
            parsableByteArray.T(f2);
            if (u2 == 1414744396) {
                aviChunk = c(parsableByteArray.u(), parsableByteArray);
            } else {
                aviChunk = a(u2, i3, parsableByteArray);
            }
            if (aviChunk != null) {
                if (aviChunk.getType() == 1752331379) {
                    i3 = ((AviStreamHeaderChunk) aviChunk).b();
                }
                builder.d(aviChunk);
            }
            parsableByteArray.U(f2);
            parsableByteArray.T(g2);
        }
        return new ListChunk(i2, builder.k());
    }

    public <T extends AviChunk> T b(Class<T> cls) {
        UnmodifiableIterator<AviChunk> h2 = this.f8182a.iterator();
        while (h2.hasNext()) {
            T t2 = (AviChunk) h2.next();
            if (t2.getClass() == cls) {
                return t2;
            }
        }
        return null;
    }

    public int getType() {
        return this.f8183b;
    }
}
