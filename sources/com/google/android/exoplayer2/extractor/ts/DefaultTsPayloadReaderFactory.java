package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final int f24837a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Format> f24838b;

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
            return this.f24838b;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.f25123d);
        List<Format> list2 = this.f24838b;
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
                    list2.add(new Format.Builder().g0(str).X(E).H(i2).V(list).G());
                }
            }
            parsableByteArray.U(f2);
        }
        return list2;
    }

    private boolean f(int i2) {
        return (i2 & this.f24837a) != 0;
    }

    public SparseArray<TsPayloadReader> a() {
        return new SparseArray<>();
    }

    public TsPayloadReader b(int i2, TsPayloadReader.EsInfo esInfo) {
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                return new PesReader(new MpegAudioReader(esInfo.f25121b));
            }
            if (i2 == 21) {
                return new PesReader(new Id3Reader());
            }
            if (i2 != 27) {
                if (i2 == 36) {
                    return new PesReader(new H265Reader(c(esInfo)));
                }
                if (i2 == 89) {
                    return new PesReader(new DvbSubtitleReader(esInfo.f25122c));
                }
                if (i2 != 138) {
                    if (i2 == 172) {
                        return new PesReader(new Ac4Reader(esInfo.f25121b));
                    }
                    if (i2 == 257) {
                        return new SectionReader(new PassthroughSectionPayloadReader("application/vnd.dvb.ait"));
                    }
                    if (i2 != 134) {
                        if (i2 != 135) {
                            switch (i2) {
                                case 15:
                                    if (f(2)) {
                                        return null;
                                    }
                                    return new PesReader(new AdtsReader(false, esInfo.f25121b));
                                case 16:
                                    return new PesReader(new H263Reader(d(esInfo)));
                                case 17:
                                    if (f(2)) {
                                        return null;
                                    }
                                    return new PesReader(new LatmReader(esInfo.f25121b));
                                default:
                                    switch (i2) {
                                        case 128:
                                            break;
                                        case EMPTY_TPAT_ERROR_VALUE:
                                            break;
                                        case MRAID_DOWNLOAD_JS_ERROR_VALUE:
                                            if (!f(64)) {
                                                return null;
                                            }
                                            break;
                                        default:
                                            return null;
                                    }
                            }
                        }
                        return new PesReader(new Ac3Reader(esInfo.f25121b));
                    } else if (f(16)) {
                        return null;
                    } else {
                        return new SectionReader(new PassthroughSectionPayloadReader("application/x-scte35"));
                    }
                }
                return new PesReader(new DtsReader(esInfo.f25121b));
            } else if (f(4)) {
                return null;
            } else {
                return new PesReader(new H264Reader(c(esInfo), f(1), f(8)));
            }
        }
        return new PesReader(new H262Reader(d(esInfo)));
    }

    public DefaultTsPayloadReaderFactory(int i2) {
        this(i2, ImmutableList.r());
    }

    public DefaultTsPayloadReaderFactory(int i2, List<Format> list) {
        this.f24837a = i2;
        this.f24838b = list;
    }
}
