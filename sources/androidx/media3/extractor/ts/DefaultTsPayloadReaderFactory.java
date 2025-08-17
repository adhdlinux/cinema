package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final int f9222a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Format> f9223b;

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    private SeiReader c(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(e(esInfo));
    }

    private UserDataReader d(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(e(esInfo));
    }

    private List<Format> e(TsPayloadReader.EsInfo esInfo) {
        boolean z2;
        String str;
        int i2;
        List<byte[]> list;
        if (f(32)) {
            return this.f9223b;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.f9547e);
        List<Format> list2 = this.f9223b;
        while (parsableByteArray.a() > 0) {
            int H = parsableByteArray.H();
            int f2 = parsableByteArray.f() + parsableByteArray.H();
            if (H == 134) {
                list2 = new ArrayList<>();
                int H2 = parsableByteArray.H() & 31;
                for (int i3 = 0; i3 < H2; i3++) {
                    String E = parsableByteArray.E(3);
                    int H3 = parsableByteArray.H();
                    boolean z3 = true;
                    if ((H3 & 128) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i2 = H3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte H4 = (byte) parsableByteArray.H();
                    parsableByteArray.V(1);
                    if (z2) {
                        if ((H4 & 64) == 0) {
                            z3 = false;
                        }
                        list = CodecSpecificDataUtil.b(z3);
                    } else {
                        list = null;
                    }
                    list2.add(new Format.Builder().o0(str).e0(E).L(i2).b0(list).K());
                }
            }
            parsableByteArray.U(f2);
        }
        return list2;
    }

    private boolean f(int i2) {
        return (i2 & this.f9222a) != 0;
    }

    public SparseArray<TsPayloadReader> a() {
        return new SparseArray<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
        return new androidx.media3.extractor.ts.PesReader(new androidx.media3.extractor.ts.Ac3Reader(r6.f9544b, r6.a()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.extractor.ts.TsPayloadReader b(int r5, androidx.media3.extractor.ts.TsPayloadReader.EsInfo r6) {
        /*
            r4 = this;
            r0 = 2
            if (r5 == r0) goto L_0x0150
            r1 = 3
            if (r5 == r1) goto L_0x013f
            r1 = 4
            if (r5 == r1) goto L_0x013f
            r2 = 21
            if (r5 == r2) goto L_0x0134
            r2 = 27
            r3 = 0
            if (r5 == r2) goto L_0x0113
            r1 = 36
            if (r5 == r1) goto L_0x0104
            r1 = 45
            if (r5 == r1) goto L_0x00f9
            r1 = 89
            if (r5 == r1) goto L_0x00ec
            r1 = 172(0xac, float:2.41E-43)
            if (r5 == r1) goto L_0x00db
            r1 = 257(0x101, float:3.6E-43)
            if (r5 == r1) goto L_0x00ce
            r1 = 138(0x8a, float:1.93E-43)
            if (r5 == r1) goto L_0x00bb
            r1 = 139(0x8b, float:1.95E-43)
            if (r5 == r1) goto L_0x00a8
            switch(r5) {
                case 15: goto L_0x008f;
                case 16: goto L_0x0080;
                case 17: goto L_0x0068;
                default: goto L_0x0031;
            }
        L_0x0031:
            switch(r5) {
                case 128: goto L_0x0150;
                case 129: goto L_0x0057;
                case 130: goto L_0x004e;
                default: goto L_0x0034;
            }
        L_0x0034:
            switch(r5) {
                case 134: goto L_0x0038;
                case 135: goto L_0x0057;
                case 136: goto L_0x00bb;
                default: goto L_0x0037;
            }
        L_0x0037:
            return r3
        L_0x0038:
            r5 = 16
            boolean r5 = r4.f(r5)
            if (r5 == 0) goto L_0x0041
            goto L_0x004d
        L_0x0041:
            androidx.media3.extractor.ts.SectionReader r3 = new androidx.media3.extractor.ts.SectionReader
            androidx.media3.extractor.ts.PassthroughSectionPayloadReader r5 = new androidx.media3.extractor.ts.PassthroughSectionPayloadReader
            java.lang.String r6 = "application/x-scte35"
            r5.<init>(r6)
            r3.<init>(r5)
        L_0x004d:
            return r3
        L_0x004e:
            r5 = 64
            boolean r5 = r4.f(r5)
            if (r5 != 0) goto L_0x00bb
            return r3
        L_0x0057:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.Ac3Reader r0 = new androidx.media3.extractor.ts.Ac3Reader
            java.lang.String r1 = r6.f9544b
            int r6 = r6.a()
            r0.<init>(r1, r6)
            r5.<init>(r0)
            return r5
        L_0x0068:
            boolean r5 = r4.f(r0)
            if (r5 == 0) goto L_0x006f
            goto L_0x007f
        L_0x006f:
            androidx.media3.extractor.ts.PesReader r3 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.LatmReader r5 = new androidx.media3.extractor.ts.LatmReader
            java.lang.String r0 = r6.f9544b
            int r6 = r6.a()
            r5.<init>(r0, r6)
            r3.<init>(r5)
        L_0x007f:
            return r3
        L_0x0080:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H263Reader r0 = new androidx.media3.extractor.ts.H263Reader
            androidx.media3.extractor.ts.UserDataReader r6 = r4.d(r6)
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        L_0x008f:
            boolean r5 = r4.f(r0)
            if (r5 == 0) goto L_0x0096
            goto L_0x00a7
        L_0x0096:
            androidx.media3.extractor.ts.PesReader r3 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.AdtsReader r5 = new androidx.media3.extractor.ts.AdtsReader
            java.lang.String r0 = r6.f9544b
            int r6 = r6.a()
            r1 = 0
            r5.<init>(r1, r0, r6)
            r3.<init>(r5)
        L_0x00a7:
            return r3
        L_0x00a8:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.DtsReader r0 = new androidx.media3.extractor.ts.DtsReader
            java.lang.String r1 = r6.f9544b
            int r6 = r6.a()
            r2 = 5408(0x1520, float:7.578E-42)
            r0.<init>(r1, r6, r2)
            r5.<init>(r0)
            return r5
        L_0x00bb:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.DtsReader r0 = new androidx.media3.extractor.ts.DtsReader
            java.lang.String r1 = r6.f9544b
            int r6 = r6.a()
            r2 = 4096(0x1000, float:5.74E-42)
            r0.<init>(r1, r6, r2)
            r5.<init>(r0)
            return r5
        L_0x00ce:
            androidx.media3.extractor.ts.SectionReader r5 = new androidx.media3.extractor.ts.SectionReader
            androidx.media3.extractor.ts.PassthroughSectionPayloadReader r6 = new androidx.media3.extractor.ts.PassthroughSectionPayloadReader
            java.lang.String r0 = "application/vnd.dvb.ait"
            r6.<init>(r0)
            r5.<init>(r6)
            return r5
        L_0x00db:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.Ac4Reader r0 = new androidx.media3.extractor.ts.Ac4Reader
            java.lang.String r1 = r6.f9544b
            int r6 = r6.a()
            r0.<init>(r1, r6)
            r5.<init>(r0)
            return r5
        L_0x00ec:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.DvbSubtitleReader r0 = new androidx.media3.extractor.ts.DvbSubtitleReader
            java.util.List<androidx.media3.extractor.ts.TsPayloadReader$DvbSubtitleInfo> r6 = r6.f9546d
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        L_0x00f9:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.MpeghReader r6 = new androidx.media3.extractor.ts.MpeghReader
            r6.<init>()
            r5.<init>(r6)
            return r5
        L_0x0104:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H265Reader r0 = new androidx.media3.extractor.ts.H265Reader
            androidx.media3.extractor.ts.SeiReader r6 = r4.c(r6)
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        L_0x0113:
            boolean r5 = r4.f(r1)
            if (r5 == 0) goto L_0x011a
            goto L_0x0133
        L_0x011a:
            androidx.media3.extractor.ts.PesReader r3 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H264Reader r5 = new androidx.media3.extractor.ts.H264Reader
            androidx.media3.extractor.ts.SeiReader r6 = r4.c(r6)
            r0 = 1
            boolean r0 = r4.f(r0)
            r1 = 8
            boolean r1 = r4.f(r1)
            r5.<init>(r6, r0, r1)
            r3.<init>(r5)
        L_0x0133:
            return r3
        L_0x0134:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.Id3Reader r6 = new androidx.media3.extractor.ts.Id3Reader
            r6.<init>()
            r5.<init>(r6)
            return r5
        L_0x013f:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.MpegAudioReader r0 = new androidx.media3.extractor.ts.MpegAudioReader
            java.lang.String r1 = r6.f9544b
            int r6 = r6.a()
            r0.<init>(r1, r6)
            r5.<init>(r0)
            return r5
        L_0x0150:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H262Reader r0 = new androidx.media3.extractor.ts.H262Reader
            androidx.media3.extractor.ts.UserDataReader r6 = r4.d(r6)
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory.b(int, androidx.media3.extractor.ts.TsPayloadReader$EsInfo):androidx.media3.extractor.ts.TsPayloadReader");
    }

    public DefaultTsPayloadReaderFactory(int i2) {
        this(i2, ImmutableList.r());
    }

    public DefaultTsPayloadReaderFactory(int i2, List<Format> list) {
        this.f9222a = i2;
        this.f9223b = list;
    }
}
