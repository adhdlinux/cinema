package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.Id3Util;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.facebook.imageutils.JfifUtil;
import com.google.common.collect.ImmutableList;

final class MetadataUtil {
    private MetadataUtil() {
    }

    private static CommentFrame a(int i2, ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.V(8);
            String C = parsableByteArray.C(q2 - 16);
            return new CommentFrame("und", C, C);
        }
        Log.h("MetadataUtil", "Failed to parse comment attribute: " + Atom.a(i2));
        return null;
    }

    private static ApicFrame b(ParsableByteArray parsableByteArray) {
        String str;
        int q2 = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            int b2 = Atom.b(parsableByteArray.q());
            if (b2 == 13) {
                str = "image/jpeg";
            } else if (b2 == 14) {
                str = "image/png";
            } else {
                str = null;
            }
            if (str == null) {
                Log.h("MetadataUtil", "Unrecognized cover art flags: " + b2);
                return null;
            }
            parsableByteArray.V(4);
            int i2 = q2 - 16;
            byte[] bArr = new byte[i2];
            parsableByteArray.l(bArr, 0, i2);
            return new ApicFrame(str, (String) null, 3, bArr);
        }
        Log.h("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    public static Metadata.Entry c(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f() + parsableByteArray.q();
        int q2 = parsableByteArray.q();
        int i2 = (q2 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
        if (i2 == 169 || i2 == 253) {
            int i3 = 16777215 & q2;
            if (i3 == 6516084) {
                CommentFrame a2 = a(q2, parsableByteArray);
                parsableByteArray.U(f2);
                return a2;
            } else if (i3 == 7233901 || i3 == 7631467) {
                TextInformationFrame j2 = j(q2, "TIT2", parsableByteArray);
                parsableByteArray.U(f2);
                return j2;
            } else if (i3 == 6516589 || i3 == 7828084) {
                TextInformationFrame j3 = j(q2, "TCOM", parsableByteArray);
                parsableByteArray.U(f2);
                return j3;
            } else if (i3 == 6578553) {
                TextInformationFrame j4 = j(q2, "TDRC", parsableByteArray);
                parsableByteArray.U(f2);
                return j4;
            } else if (i3 == 4280916) {
                TextInformationFrame j5 = j(q2, "TPE1", parsableByteArray);
                parsableByteArray.U(f2);
                return j5;
            } else if (i3 == 7630703) {
                TextInformationFrame j6 = j(q2, "TSSE", parsableByteArray);
                parsableByteArray.U(f2);
                return j6;
            } else if (i3 == 6384738) {
                TextInformationFrame j7 = j(q2, "TALB", parsableByteArray);
                parsableByteArray.U(f2);
                return j7;
            } else if (i3 == 7108978) {
                TextInformationFrame j8 = j(q2, "USLT", parsableByteArray);
                parsableByteArray.U(f2);
                return j8;
            } else if (i3 == 6776174) {
                TextInformationFrame j9 = j(q2, "TCON", parsableByteArray);
                parsableByteArray.U(f2);
                return j9;
            } else if (i3 == 6779504) {
                TextInformationFrame j10 = j(q2, "TIT1", parsableByteArray);
                parsableByteArray.U(f2);
                return j10;
            }
        } else if (q2 == 1735291493) {
            try {
                return i(parsableByteArray);
            } finally {
                parsableByteArray.U(f2);
            }
        } else if (q2 == 1684632427) {
            TextInformationFrame d2 = d(q2, "TPOS", parsableByteArray);
            parsableByteArray.U(f2);
            return d2;
        } else if (q2 == 1953655662) {
            TextInformationFrame d3 = d(q2, "TRCK", parsableByteArray);
            parsableByteArray.U(f2);
            return d3;
        } else if (q2 == 1953329263) {
            Id3Frame f3 = f(q2, "TBPM", parsableByteArray, true, false);
            parsableByteArray.U(f2);
            return f3;
        } else if (q2 == 1668311404) {
            Id3Frame f4 = f(q2, "TCMP", parsableByteArray, true, true);
            parsableByteArray.U(f2);
            return f4;
        } else if (q2 == 1668249202) {
            ApicFrame b2 = b(parsableByteArray);
            parsableByteArray.U(f2);
            return b2;
        } else if (q2 == 1631670868) {
            TextInformationFrame j11 = j(q2, "TPE2", parsableByteArray);
            parsableByteArray.U(f2);
            return j11;
        } else if (q2 == 1936682605) {
            TextInformationFrame j12 = j(q2, "TSOT", parsableByteArray);
            parsableByteArray.U(f2);
            return j12;
        } else if (q2 == 1936679276) {
            TextInformationFrame j13 = j(q2, "TSOA", parsableByteArray);
            parsableByteArray.U(f2);
            return j13;
        } else if (q2 == 1936679282) {
            TextInformationFrame j14 = j(q2, "TSOP", parsableByteArray);
            parsableByteArray.U(f2);
            return j14;
        } else if (q2 == 1936679265) {
            TextInformationFrame j15 = j(q2, "TSO2", parsableByteArray);
            parsableByteArray.U(f2);
            return j15;
        } else if (q2 == 1936679791) {
            TextInformationFrame j16 = j(q2, "TSOC", parsableByteArray);
            parsableByteArray.U(f2);
            return j16;
        } else if (q2 == 1920233063) {
            Id3Frame f5 = f(q2, "ITUNESADVISORY", parsableByteArray, false, false);
            parsableByteArray.U(f2);
            return f5;
        } else if (q2 == 1885823344) {
            Id3Frame f6 = f(q2, "ITUNESGAPLESS", parsableByteArray, false, true);
            parsableByteArray.U(f2);
            return f6;
        } else if (q2 == 1936683886) {
            TextInformationFrame j17 = j(q2, "TVSHOWSORT", parsableByteArray);
            parsableByteArray.U(f2);
            return j17;
        } else if (q2 == 1953919848) {
            TextInformationFrame j18 = j(q2, "TVSHOW", parsableByteArray);
            parsableByteArray.U(f2);
            return j18;
        } else if (q2 == 757935405) {
            Id3Frame g2 = g(parsableByteArray, f2);
            parsableByteArray.U(f2);
            return g2;
        }
        Log.b("MetadataUtil", "Skipped unknown metadata entry: " + Atom.a(q2));
        parsableByteArray.U(f2);
        return null;
    }

    private static TextInformationFrame d(int i2, String str, ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385 && q2 >= 22) {
            parsableByteArray.V(10);
            int N = parsableByteArray.N();
            if (N > 0) {
                String str2 = "" + N;
                int N2 = parsableByteArray.N();
                if (N2 > 0) {
                    str2 = str2 + "/" + N2;
                }
                return new TextInformationFrame(str, (String) null, ImmutableList.s(str2));
            }
        }
        Log.h("MetadataUtil", "Failed to parse index/count attribute: " + Atom.a(i2));
        return null;
    }

    private static int e(ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.V(8);
            int i2 = q2 - 16;
            if (i2 == 1) {
                return parsableByteArray.H();
            }
            if (i2 == 2) {
                return parsableByteArray.N();
            }
            if (i2 == 3) {
                return parsableByteArray.K();
            }
            if (i2 == 4 && (parsableByteArray.j() & 128) == 0) {
                return parsableByteArray.L();
            }
        }
        Log.h("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static Id3Frame f(int i2, String str, ParsableByteArray parsableByteArray, boolean z2, boolean z3) {
        int e2 = e(parsableByteArray);
        if (z3) {
            e2 = Math.min(1, e2);
        }
        if (e2 < 0) {
            Log.h("MetadataUtil", "Failed to parse uint8 attribute: " + Atom.a(i2));
            return null;
        } else if (z2) {
            return new TextInformationFrame(str, (String) null, ImmutableList.s(Integer.toString(e2)));
        } else {
            return new CommentFrame("und", str, Integer.toString(e2));
        }
    }

    private static Id3Frame g(ParsableByteArray parsableByteArray, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (parsableByteArray.f() < i2) {
            int f2 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            parsableByteArray.V(4);
            if (q3 == 1835360622) {
                str = parsableByteArray.C(q2 - 12);
            } else if (q3 == 1851878757) {
                str2 = parsableByteArray.C(q2 - 12);
            } else {
                if (q3 == 1684108385) {
                    i3 = f2;
                    i4 = q2;
                }
                parsableByteArray.V(q2 - 12);
            }
        }
        if (str == null || str2 == null || i3 == -1) {
            return null;
        }
        parsableByteArray.U(i3);
        parsableByteArray.V(16);
        return new InternalFrame(str, str2, parsableByteArray.C(i4 - 16));
    }

    public static MdtaMetadataEntry h(ParsableByteArray parsableByteArray, int i2, String str) {
        while (true) {
            int f2 = parsableByteArray.f();
            if (f2 >= i2) {
                return null;
            }
            int q2 = parsableByteArray.q();
            if (parsableByteArray.q() == 1684108385) {
                int q3 = parsableByteArray.q();
                int q4 = parsableByteArray.q();
                int i3 = q2 - 16;
                byte[] bArr = new byte[i3];
                parsableByteArray.l(bArr, 0, i3);
                return new MdtaMetadataEntry(str, bArr, q4, q3);
            }
            parsableByteArray.U(f2 + q2);
        }
    }

    private static TextInformationFrame i(ParsableByteArray parsableByteArray) {
        String a2 = Id3Util.a(e(parsableByteArray) - 1);
        if (a2 != null) {
            return new TextInformationFrame("TCON", (String) null, ImmutableList.s(a2));
        }
        Log.h("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static TextInformationFrame j(int i2, String str, ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.V(8);
            return new TextInformationFrame(str, (String) null, ImmutableList.s(parsableByteArray.C(q2 - 16)));
        }
        Log.h("MetadataUtil", "Failed to parse text attribute: " + Atom.a(i2));
        return null;
    }

    public static void k(int i2, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i2 == 1 && gaplessInfoHolder.a()) {
            builder.V(gaplessInfoHolder.f8036a).W(gaplessInfoHolder.f8037b);
        }
    }

    public static void l(int i2, Metadata metadata, Format.Builder builder, Metadata... metadataArr) {
        Metadata metadata2 = new Metadata(new Metadata.Entry[0]);
        if (metadata != null) {
            for (int i3 = 0; i3 < metadata.f(); i3++) {
                Metadata.Entry e2 = metadata.e(i3);
                if (e2 instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) e2;
                    if (!mdtaMetadataEntry.f4738b.equals("com.android.capture.fps")) {
                        metadata2 = metadata2.b(mdtaMetadataEntry);
                    } else if (i2 == 2) {
                        metadata2 = metadata2.b(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata c2 : metadataArr) {
            metadata2 = metadata2.c(c2);
        }
        if (metadata2.f() > 0) {
            builder.h0(metadata2);
        }
    }
}
