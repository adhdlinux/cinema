package androidx.media3.extractor.mp4;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.google.common.base.Splitter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class SefReader {

    /* renamed from: d  reason: collision with root package name */
    private static final Splitter f8651d = Splitter.d(':');

    /* renamed from: e  reason: collision with root package name */
    private static final Splitter f8652e = Splitter.d('*');

    /* renamed from: a  reason: collision with root package name */
    private final List<DataReference> f8653a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f8654b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f8655c;

    private static final class DataReference {

        /* renamed from: a  reason: collision with root package name */
        public final int f8656a;

        /* renamed from: b  reason: collision with root package name */
        public final long f8657b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8658c;

        public DataReference(int i2, long j2, int i3) {
            this.f8656a = i2;
            this.f8657b = j2;
            this.f8658c = i3;
        }
    }

    private void a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        extractorInput.readFully(parsableByteArray.e(), 0, 8);
        this.f8655c = parsableByteArray.u() + 8;
        if (parsableByteArray.q() != 1397048916) {
            positionHolder.f8069a = 0;
            return;
        }
        positionHolder.f8069a = extractorInput.getPosition() - ((long) (this.f8655c - 12));
        this.f8654b = 2;
    }

    private static int b(String str) throws ParserException {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1711564334:
                if (str.equals("SlowMotion_Data")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1332107749:
                if (str.equals("Super_SlowMotion_Edit_Data")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals("Super_SlowMotion_Data")) {
                    c2 = 2;
                    break;
                }
                break;
            case -830665521:
                if (str.equals("Super_SlowMotion_Deflickering_On")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals("Super_SlowMotion_BGM")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2192;
            case 1:
                return 2819;
            case 2:
                return 2816;
            case 3:
                return 2820;
            case 4:
                return 2817;
            default:
                throw ParserException.a("Invalid SEF name", (Throwable) null);
        }
    }

    private void d(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        long length = extractorInput.getLength();
        int i2 = (this.f8655c - 12) - 8;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        extractorInput.readFully(parsableByteArray.e(), 0, i2);
        for (int i3 = 0; i3 < i2 / 12; i3++) {
            parsableByteArray.V(2);
            short w2 = parsableByteArray.w();
            if (w2 == 2192 || w2 == 2816 || w2 == 2817 || w2 == 2819 || w2 == 2820) {
                this.f8653a.add(new DataReference(w2, (length - ((long) this.f8655c)) - ((long) parsableByteArray.u()), parsableByteArray.u()));
            } else {
                parsableByteArray.V(8);
            }
        }
        if (this.f8653a.isEmpty()) {
            positionHolder.f8069a = 0;
            return;
        }
        this.f8654b = 3;
        positionHolder.f8069a = this.f8653a.get(0).f8657b;
    }

    private void e(ExtractorInput extractorInput, List<Metadata.Entry> list) throws IOException {
        long position = extractorInput.getPosition();
        int length = (int) ((extractorInput.getLength() - extractorInput.getPosition()) - ((long) this.f8655c));
        ParsableByteArray parsableByteArray = new ParsableByteArray(length);
        extractorInput.readFully(parsableByteArray.e(), 0, length);
        for (int i2 = 0; i2 < this.f8653a.size(); i2++) {
            DataReference dataReference = this.f8653a.get(i2);
            parsableByteArray.U((int) (dataReference.f8657b - position));
            parsableByteArray.V(4);
            int u2 = parsableByteArray.u();
            int b2 = b(parsableByteArray.E(u2));
            int i3 = dataReference.f8658c - (u2 + 8);
            if (b2 == 2192) {
                list.add(f(parsableByteArray, i3));
            } else if (!(b2 == 2816 || b2 == 2817 || b2 == 2819 || b2 == 2820)) {
                throw new IllegalStateException();
            }
        }
    }

    private static SlowMotionData f(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> f2 = f8652e.f(parsableByteArray.E(i2));
        int i3 = 0;
        while (i3 < f2.size()) {
            List<String> f3 = f8651d.f(f2.get(i3));
            if (f3.size() == 3) {
                try {
                    arrayList.add(new SlowMotionData.Segment(Long.parseLong(f3.get(0)), Long.parseLong(f3.get(1)), 1 << (Integer.parseInt(f3.get(2)) - 1)));
                    i3++;
                } catch (NumberFormatException e2) {
                    throw ParserException.a((String) null, e2);
                }
            } else {
                throw ParserException.a((String) null, (Throwable) null);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public int c(ExtractorInput extractorInput, PositionHolder positionHolder, List<Metadata.Entry> list) throws IOException {
        int i2 = this.f8654b;
        long j2 = 0;
        if (i2 == 0) {
            long length = extractorInput.getLength();
            if (length != -1 && length >= 8) {
                j2 = length - 8;
            }
            positionHolder.f8069a = j2;
            this.f8654b = 1;
        } else if (i2 == 1) {
            a(extractorInput, positionHolder);
        } else if (i2 == 2) {
            d(extractorInput, positionHolder);
        } else if (i2 == 3) {
            e(extractorInput, list);
            positionHolder.f8069a = 0;
        } else {
            throw new IllegalStateException();
        }
        return 1;
    }

    public void g() {
        this.f8653a.clear();
        this.f8654b = 0;
    }
}
