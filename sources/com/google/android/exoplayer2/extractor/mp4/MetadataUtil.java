package com.google.android.exoplayer2.extractor.mp4;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;

final class MetadataUtil {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f24616a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private MetadataUtil() {
    }

    private static CommentFrame a(int i2, ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.V(8);
            String C = parsableByteArray.C(q2 - 16);
            return new CommentFrame("und", C, C);
        }
        Log.i("MetadataUtil", "Failed to parse comment attribute: " + Atom.a(i2));
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
                Log.i("MetadataUtil", "Unrecognized cover art flags: " + b2);
                return null;
            }
            parsableByteArray.V(4);
            int i2 = q2 - 16;
            byte[] bArr = new byte[i2];
            parsableByteArray.l(bArr, 0, i2);
            return new ApicFrame(str, (String) null, 3, bArr);
        }
        Log.i("MetadataUtil", "Failed to parse cover art attribute");
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
                TextInformationFrame h2 = h(q2, "TIT2", parsableByteArray);
                parsableByteArray.U(f2);
                return h2;
            } else if (i3 == 6516589 || i3 == 7828084) {
                TextInformationFrame h3 = h(q2, "TCOM", parsableByteArray);
                parsableByteArray.U(f2);
                return h3;
            } else if (i3 == 6578553) {
                TextInformationFrame h4 = h(q2, "TDRC", parsableByteArray);
                parsableByteArray.U(f2);
                return h4;
            } else if (i3 == 4280916) {
                TextInformationFrame h5 = h(q2, "TPE1", parsableByteArray);
                parsableByteArray.U(f2);
                return h5;
            } else if (i3 == 7630703) {
                TextInformationFrame h6 = h(q2, "TSSE", parsableByteArray);
                parsableByteArray.U(f2);
                return h6;
            } else if (i3 == 6384738) {
                TextInformationFrame h7 = h(q2, "TALB", parsableByteArray);
                parsableByteArray.U(f2);
                return h7;
            } else if (i3 == 7108978) {
                TextInformationFrame h8 = h(q2, "USLT", parsableByteArray);
                parsableByteArray.U(f2);
                return h8;
            } else if (i3 == 6776174) {
                TextInformationFrame h9 = h(q2, "TCON", parsableByteArray);
                parsableByteArray.U(f2);
                return h9;
            } else if (i3 == 6779504) {
                TextInformationFrame h10 = h(q2, "TIT1", parsableByteArray);
                parsableByteArray.U(f2);
                return h10;
            }
        } else if (q2 == 1735291493) {
            try {
                return g(parsableByteArray);
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
            Id3Frame i4 = i(q2, "TBPM", parsableByteArray, true, false);
            parsableByteArray.U(f2);
            return i4;
        } else if (q2 == 1668311404) {
            Id3Frame i5 = i(q2, "TCMP", parsableByteArray, true, true);
            parsableByteArray.U(f2);
            return i5;
        } else if (q2 == 1668249202) {
            ApicFrame b2 = b(parsableByteArray);
            parsableByteArray.U(f2);
            return b2;
        } else if (q2 == 1631670868) {
            TextInformationFrame h11 = h(q2, "TPE2", parsableByteArray);
            parsableByteArray.U(f2);
            return h11;
        } else if (q2 == 1936682605) {
            TextInformationFrame h12 = h(q2, "TSOT", parsableByteArray);
            parsableByteArray.U(f2);
            return h12;
        } else if (q2 == 1936679276) {
            TextInformationFrame h13 = h(q2, "TSO2", parsableByteArray);
            parsableByteArray.U(f2);
            return h13;
        } else if (q2 == 1936679282) {
            TextInformationFrame h14 = h(q2, "TSOA", parsableByteArray);
            parsableByteArray.U(f2);
            return h14;
        } else if (q2 == 1936679265) {
            TextInformationFrame h15 = h(q2, "TSOP", parsableByteArray);
            parsableByteArray.U(f2);
            return h15;
        } else if (q2 == 1936679791) {
            TextInformationFrame h16 = h(q2, "TSOC", parsableByteArray);
            parsableByteArray.U(f2);
            return h16;
        } else if (q2 == 1920233063) {
            Id3Frame i6 = i(q2, "ITUNESADVISORY", parsableByteArray, false, false);
            parsableByteArray.U(f2);
            return i6;
        } else if (q2 == 1885823344) {
            Id3Frame i7 = i(q2, "ITUNESGAPLESS", parsableByteArray, false, true);
            parsableByteArray.U(f2);
            return i7;
        } else if (q2 == 1936683886) {
            TextInformationFrame h17 = h(q2, "TVSHOWSORT", parsableByteArray);
            parsableByteArray.U(f2);
            return h17;
        } else if (q2 == 1953919848) {
            TextInformationFrame h18 = h(q2, "TVSHOW", parsableByteArray);
            parsableByteArray.U(f2);
            return h18;
        } else if (q2 == 757935405) {
            Id3Frame e2 = e(parsableByteArray, f2);
            parsableByteArray.U(f2);
            return e2;
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
        Log.i("MetadataUtil", "Failed to parse index/count attribute: " + Atom.a(i2));
        return null;
    }

    private static Id3Frame e(ParsableByteArray parsableByteArray, int i2) {
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

    public static MdtaMetadataEntry f(ParsableByteArray parsableByteArray, int i2, String str) {
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

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame g(com.google.android.exoplayer2.util.ParsableByteArray r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = f24616a
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + -1
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x0020
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.s(r3)
            r1.<init>(r2, r0, r3)
            return r1
        L_0x0020:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.Log.i(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.g(com.google.android.exoplayer2.util.ParsableByteArray):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static TextInformationFrame h(int i2, String str, ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.V(8);
            return new TextInformationFrame(str, (String) null, ImmutableList.s(parsableByteArray.C(q2 - 16)));
        }
        Log.i("MetadataUtil", "Failed to parse text attribute: " + Atom.a(i2));
        return null;
    }

    private static Id3Frame i(int i2, String str, ParsableByteArray parsableByteArray, boolean z2, boolean z3) {
        int j2 = j(parsableByteArray);
        if (z3) {
            j2 = Math.min(1, j2);
        }
        if (j2 < 0) {
            Log.i("MetadataUtil", "Failed to parse uint8 attribute: " + Atom.a(i2));
            return null;
        } else if (z2) {
            return new TextInformationFrame(str, (String) null, ImmutableList.s(Integer.toString(j2)));
        } else {
            return new CommentFrame("und", str, Integer.toString(j2));
        }
    }

    private static int j(ParsableByteArray parsableByteArray) {
        parsableByteArray.V(4);
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.V(8);
            return parsableByteArray.H();
        }
        Log.i("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i2, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i2 == 1 && gaplessInfoHolder.a()) {
            builder.P(gaplessInfoHolder.f24224a).Q(gaplessInfoHolder.f24225b);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        if (r6 != null) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[LOOP:1: B:17:0x003e->B:18:0x0040, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void l(int r5, com.google.android.exoplayer2.metadata.Metadata r6, com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.Format.Builder r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r2)
            r2 = 1
            if (r5 != r2) goto L_0x000e
            if (r6 == 0) goto L_0x003c
            goto L_0x003d
        L_0x000e:
            r6 = 2
            if (r5 != r6) goto L_0x003c
            if (r7 == 0) goto L_0x003c
            r5 = 0
        L_0x0014:
            int r6 = r7.f()
            if (r5 >= r6) goto L_0x003c
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.e(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L_0x0039
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.f25444b
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0039
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r7)
            r6 = r5
            goto L_0x003d
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x003c:
            r6 = r0
        L_0x003d:
            int r5 = r9.length
        L_0x003e:
            if (r1 >= r5) goto L_0x0049
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.c(r7)
            int r1 = r1 + 1
            goto L_0x003e
        L_0x0049:
            int r5 = r6.f()
            if (r5 <= 0) goto L_0x0052
            r8.Z(r6)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.l(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.Format$Builder, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }
}
