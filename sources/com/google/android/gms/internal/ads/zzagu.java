package com.google.android.gms.internal.ads;

final class zzagu {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    /* JADX WARNING: Unknown top exception splitter block from list: {B:224:0x02a1=Splitter:B:224:0x02a1, B:137:0x0192=Splitter:B:137:0x0192} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzby zza(com.google.android.gms.internal.ads.zzfa r12) {
        /*
            int r0 = r12.zzc()
            int r1 = r12.zze()
            int r0 = r0 + r1
            int r1 = r12.zze()
            int r2 = r1 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 169(0xa9, float:2.37E-43)
            java.lang.String r4 = "TCON"
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r6 = 1684108385(0x64617461, float:1.6635614E22)
            java.lang.String r7 = "MetadataUtil"
            r8 = 0
            if (r2 == r3) goto L_0x01ea
            r3 = 253(0xfd, float:3.55E-43)
            if (r2 != r3) goto L_0x0026
            goto L_0x01ea
        L_0x0026:
            r2 = 1735291493(0x676e7265, float:1.1260334E24)
            r3 = -1
            if (r1 != r2) goto L_0x0053
            int r1 = zzb(r12)     // Catch:{ all -> 0x021f }
            if (r1 <= 0) goto L_0x003c
            r2 = 192(0xc0, float:2.69E-43)
            if (r1 > r2) goto L_0x003c
            java.lang.String[] r2 = zza     // Catch:{ all -> 0x021f }
            int r1 = r1 + r3
            r1 = r2[r1]     // Catch:{ all -> 0x021f }
            goto L_0x003d
        L_0x003c:
            r1 = r8
        L_0x003d:
            if (r1 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzaev r2 = new com.google.android.gms.internal.ads.zzaev     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzfsc r1 = com.google.android.gms.internal.ads.zzfsc.zzm(r1)     // Catch:{ all -> 0x021f }
            r2.<init>(r4, r8, r1)     // Catch:{ all -> 0x021f }
            r8 = r2
            goto L_0x004f
        L_0x004a:
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.gms.internal.ads.zzer.zzf(r7, r1)     // Catch:{ all -> 0x021f }
        L_0x004f:
            r12.zzF(r0)
            return r8
        L_0x0053:
            r2 = 1684632427(0x6469736b, float:1.7225632E22)
            if (r1 != r2) goto L_0x0062
            java.lang.String r1 = "TPOS"
            com.google.android.gms.internal.ads.zzaev r1 = zzd(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0062:
            r2 = 1953655662(0x74726b6e, float:7.6825853E31)
            if (r1 != r2) goto L_0x0071
            java.lang.String r1 = "TRCK"
            com.google.android.gms.internal.ads.zzaev r1 = zzd(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0071:
            r2 = 1953329263(0x746d706f, float:7.5247484E31)
            r4 = 1
            r9 = 0
            if (r1 != r2) goto L_0x0082
            java.lang.String r1 = "TBPM"
            com.google.android.gms.internal.ads.zzaen r1 = zzc(r2, r1, r12, r4, r9)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0082:
            r2 = 1668311404(0x6370696c, float:4.434815E21)
            if (r1 != r2) goto L_0x0091
            java.lang.String r1 = "TCMP"
            com.google.android.gms.internal.ads.zzaen r1 = zzc(r2, r1, r12, r4, r4)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0091:
            r2 = 1668249202(0x636f7672, float:4.4173067E21)
            if (r1 != r2) goto L_0x00ea
            int r1 = r12.zze()     // Catch:{ all -> 0x021f }
            int r2 = r12.zze()     // Catch:{ all -> 0x021f }
            if (r2 != r6) goto L_0x00e1
            int r2 = r12.zze()     // Catch:{ all -> 0x021f }
            r2 = r2 & r5
            r3 = 13
            if (r2 != r3) goto L_0x00ac
            java.lang.String r3 = "image/jpeg"
            goto L_0x00b7
        L_0x00ac:
            r3 = 14
            if (r2 != r3) goto L_0x00b6
            java.lang.String r2 = "image/png"
            r3 = r2
            r2 = 14
            goto L_0x00b7
        L_0x00b6:
            r3 = r8
        L_0x00b7:
            if (r3 != 0) goto L_0x00ce
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021f }
            r1.<init>()     // Catch:{ all -> 0x021f }
            java.lang.String r3 = "Unrecognized cover art flags: "
            r1.append(r3)     // Catch:{ all -> 0x021f }
            r1.append(r2)     // Catch:{ all -> 0x021f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzer.zzf(r7, r1)     // Catch:{ all -> 0x021f }
            goto L_0x00e6
        L_0x00ce:
            r2 = 4
            r12.zzG(r2)     // Catch:{ all -> 0x021f }
            int r1 = r1 + -16
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x021f }
            r12.zzB(r2, r9, r1)     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzady r1 = new com.google.android.gms.internal.ads.zzady     // Catch:{ all -> 0x021f }
            r4 = 3
            r1.<init>(r3, r8, r4, r2)     // Catch:{ all -> 0x021f }
            r8 = r1
            goto L_0x00e6
        L_0x00e1:
            java.lang.String r1 = "Failed to parse cover art attribute"
            com.google.android.gms.internal.ads.zzer.zzf(r7, r1)     // Catch:{ all -> 0x021f }
        L_0x00e6:
            r12.zzF(r0)
            return r8
        L_0x00ea:
            r2 = 1631670868(0x61415254, float:2.2288462E20)
            if (r1 != r2) goto L_0x00f9
            java.lang.String r1 = "TPE2"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x00f9:
            r2 = 1936682605(0x736f6e6d, float:1.8969706E31)
            if (r1 != r2) goto L_0x0108
            java.lang.String r1 = "TSOT"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0108:
            r2 = 1936679276(0x736f616c, float:1.8965681E31)
            if (r1 != r2) goto L_0x0117
            java.lang.String r1 = "TSO2"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0117:
            r2 = 1936679282(0x736f6172, float:1.8965689E31)
            if (r1 != r2) goto L_0x0126
            java.lang.String r1 = "TSOA"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0126:
            r2 = 1936679265(0x736f6161, float:1.8965668E31)
            if (r1 != r2) goto L_0x0135
            java.lang.String r1 = "TSOP"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0135:
            r2 = 1936679791(0x736f636f, float:1.8966304E31)
            if (r1 != r2) goto L_0x0144
            java.lang.String r1 = "TSOC"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0144:
            r2 = 1920233063(0x72746e67, float:4.84146E30)
            if (r1 != r2) goto L_0x0153
            java.lang.String r1 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzaen r1 = zzc(r2, r1, r12, r9, r9)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0153:
            r2 = 1885823344(0x70676170, float:2.8643533E29)
            if (r1 != r2) goto L_0x0165
            java.lang.String r1 = "ITUNESGAPLESS"
            r2 = 1885823344(0x70676170, float:2.8643533E29)
            com.google.android.gms.internal.ads.zzaen r1 = zzc(r2, r1, r12, r9, r4)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0165:
            r2 = 1936683886(0x736f736e, float:1.8971255E31)
            if (r1 != r2) goto L_0x0177
            java.lang.String r1 = "TVSHOWSORT"
            r2 = 1936683886(0x736f736e, float:1.8971255E31)
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0177:
            r2 = 1953919848(0x74767368, float:7.810338E31)
            if (r1 != r2) goto L_0x0189
            java.lang.String r1 = "TVSHOW"
            r2 = 1953919848(0x74767368, float:7.810338E31)
            com.google.android.gms.internal.ads.zzaev r1 = zze(r2, r1, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0189:
            r2 = 757935405(0x2d2d2d2d, float:9.8439425E-12)
            if (r1 != r2) goto L_0x02a1
            r1 = r8
            r2 = r1
            r4 = -1
            r5 = -1
        L_0x0192:
            int r7 = r12.zzc()     // Catch:{ all -> 0x021f }
            if (r7 >= r0) goto L_0x01cc
            int r7 = r12.zzc()     // Catch:{ all -> 0x021f }
            int r9 = r12.zze()     // Catch:{ all -> 0x021f }
            int r10 = r12.zze()     // Catch:{ all -> 0x021f }
            r11 = 4
            r12.zzG(r11)     // Catch:{ all -> 0x021f }
            r11 = 1835360622(0x6d65616e, float:4.4368658E27)
            if (r10 != r11) goto L_0x01b4
            int r9 = r9 + -12
            java.lang.String r1 = r12.zzw(r9)     // Catch:{ all -> 0x021f }
            goto L_0x0192
        L_0x01b4:
            r11 = 1851878757(0x6e616d65, float:1.7441594E28)
            if (r10 != r11) goto L_0x01c0
            int r9 = r9 + -12
            java.lang.String r2 = r12.zzw(r9)     // Catch:{ all -> 0x021f }
            goto L_0x0192
        L_0x01c0:
            if (r10 != r6) goto L_0x01c3
            r5 = r9
        L_0x01c3:
            if (r10 != r6) goto L_0x01c6
            r4 = r7
        L_0x01c6:
            int r9 = r9 + -12
            r12.zzG(r9)     // Catch:{ all -> 0x021f }
            goto L_0x0192
        L_0x01cc:
            if (r1 == 0) goto L_0x01e6
            if (r2 == 0) goto L_0x01e6
            if (r4 != r3) goto L_0x01d3
            goto L_0x01e6
        L_0x01d3:
            r12.zzF(r4)     // Catch:{ all -> 0x021f }
            r3 = 16
            r12.zzG(r3)     // Catch:{ all -> 0x021f }
            int r5 = r5 + -16
            java.lang.String r3 = r12.zzw(r5)     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzaep r8 = new com.google.android.gms.internal.ads.zzaep     // Catch:{ all -> 0x021f }
            r8.<init>(r1, r2, r3)     // Catch:{ all -> 0x021f }
        L_0x01e6:
            r12.zzF(r0)
            return r8
        L_0x01ea:
            r2 = r1 & r5
            r3 = 6516084(0x636d74, float:9.130979E-39)
            if (r2 != r3) goto L_0x0222
            int r2 = r12.zze()     // Catch:{ all -> 0x021f }
            int r3 = r12.zze()     // Catch:{ all -> 0x021f }
            if (r3 != r6) goto L_0x020e
            r1 = 8
            r12.zzG(r1)     // Catch:{ all -> 0x021f }
            int r2 = r2 + -16
            java.lang.String r1 = r12.zzw(r2)     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzaeg r8 = new com.google.android.gms.internal.ads.zzaeg     // Catch:{ all -> 0x021f }
            java.lang.String r2 = "und"
            r8.<init>(r2, r1, r1)     // Catch:{ all -> 0x021f }
            goto L_0x021b
        L_0x020e:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzage.zzf(r1)     // Catch:{ all -> 0x021f }
            java.lang.String r2 = "Failed to parse comment attribute: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzer.zzf(r7, r1)     // Catch:{ all -> 0x021f }
        L_0x021b:
            r12.zzF(r0)
            return r8
        L_0x021f:
            r1 = move-exception
            goto L_0x02d1
        L_0x0222:
            r3 = 7233901(0x6e616d, float:1.0136854E-38)
            if (r2 == r3) goto L_0x02c7
            r3 = 7631467(0x74726b, float:1.0693963E-38)
            if (r2 != r3) goto L_0x022e
            goto L_0x02c7
        L_0x022e:
            r3 = 6516589(0x636f6d, float:9.131686E-39)
            if (r2 == r3) goto L_0x02bd
            r3 = 7828084(0x777274, float:1.0969482E-38)
            if (r2 != r3) goto L_0x023a
            goto L_0x02bd
        L_0x023a:
            r3 = 6578553(0x646179, float:9.218516E-39)
            if (r2 != r3) goto L_0x0249
            java.lang.String r2 = "TDRC"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0249:
            r3 = 4280916(0x415254, float:5.998841E-39)
            if (r2 != r3) goto L_0x0258
            java.lang.String r2 = "TPE1"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0258:
            r3 = 7630703(0x746f6f, float:1.0692892E-38)
            if (r2 != r3) goto L_0x0267
            java.lang.String r2 = "TSSE"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0267:
            r3 = 6384738(0x616c62, float:8.946924E-39)
            if (r2 != r3) goto L_0x0276
            java.lang.String r2 = "TALB"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0276:
            r3 = 7108978(0x6c7972, float:9.9618E-39)
            if (r2 != r3) goto L_0x0285
            java.lang.String r2 = "USLT"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0285:
            r3 = 6776174(0x67656e, float:9.495442E-39)
            if (r2 != r3) goto L_0x0292
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r4, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x0292:
            r3 = 6779504(0x677270, float:9.500109E-39)
            if (r2 != r3) goto L_0x02a1
            java.lang.String r2 = "TIT1"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x02a1:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzage.zzf(r1)     // Catch:{ all -> 0x021f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x021f }
            r2.<init>()     // Catch:{ all -> 0x021f }
            java.lang.String r3 = "Skipped unknown metadata entry: "
            r2.append(r3)     // Catch:{ all -> 0x021f }
            r2.append(r1)     // Catch:{ all -> 0x021f }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzer.zzb(r7, r1)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r8
        L_0x02bd:
            java.lang.String r2 = "TCOM"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x02c7:
            java.lang.String r2 = "TIT2"
            com.google.android.gms.internal.ads.zzaev r1 = zze(r1, r2, r12)     // Catch:{ all -> 0x021f }
            r12.zzF(r0)
            return r1
        L_0x02d1:
            r12.zzF(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagu.zza(com.google.android.gms.internal.ads.zzfa):com.google.android.gms.internal.ads.zzby");
    }

    private static int zzb(zzfa zzfa) {
        zzfa.zzG(4);
        if (zzfa.zze() == 1684108385) {
            zzfa.zzG(8);
            return zzfa.zzk();
        }
        zzer.zzf("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzaen zzc(int i2, String str, zzfa zzfa, boolean z2, boolean z3) {
        int zzb2 = zzb(zzfa);
        if (z3) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            zzer.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzage.zzf(i2)));
            return null;
        } else if (z2) {
            return new zzaev(str, (String) null, zzfsc.zzm(Integer.toString(zzb2)));
        } else {
            return new zzaeg("und", str, Integer.toString(zzb2));
        }
    }

    private static zzaev zzd(int i2, String str, zzfa zzfa) {
        int zze = zzfa.zze();
        if (zzfa.zze() == 1684108385 && zze >= 22) {
            zzfa.zzG(10);
            int zzo = zzfa.zzo();
            if (zzo > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzo);
                String sb2 = sb.toString();
                int zzo2 = zzfa.zzo();
                if (zzo2 > 0) {
                    sb2 = sb2 + "/" + zzo2;
                }
                return new zzaev(str, (String) null, zzfsc.zzm(sb2));
            }
        }
        zzer.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzage.zzf(i2)));
        return null;
    }

    private static zzaev zze(int i2, String str, zzfa zzfa) {
        int zze = zzfa.zze();
        if (zzfa.zze() == 1684108385) {
            zzfa.zzG(8);
            return new zzaev(str, (String) null, zzfsc.zzm(zzfa.zzw(zze - 16)));
        }
        zzer.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzage.zzf(i2)));
        return null;
    }
}
