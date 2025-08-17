package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        /* renamed from: a */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        /* renamed from: b */
        public TextInformationFrame[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f8340c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public final String f8341d;

    /* renamed from: e  reason: collision with root package name */
    public final ImmutableList<String> f8342e;

    private static List<Integer> b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(androidx.media3.common.MediaMetadata.Builder r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.f8328b
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            r7 = -1
            switch(r1) {
                case 82815: goto L_0x0133;
                case 82878: goto L_0x0128;
                case 82897: goto L_0x011d;
                case 83253: goto L_0x0112;
                case 83254: goto L_0x0107;
                case 83255: goto L_0x00fc;
                case 83341: goto L_0x00f1;
                case 83378: goto L_0x00e6;
                case 83536: goto L_0x00d8;
                case 83552: goto L_0x00ca;
                case 2567331: goto L_0x00bc;
                case 2569357: goto L_0x00ae;
                case 2569358: goto L_0x00a0;
                case 2569891: goto L_0x0092;
                case 2570401: goto L_0x0084;
                case 2570410: goto L_0x0076;
                case 2571565: goto L_0x0068;
                case 2575251: goto L_0x005a;
                case 2581512: goto L_0x004c;
                case 2581513: goto L_0x003e;
                case 2581514: goto L_0x0030;
                case 2583398: goto L_0x0022;
                case 2590194: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x013d
        L_0x0014:
            java.lang.String r1 = "TYER"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001e
            goto L_0x013d
        L_0x001e:
            r7 = 22
            goto L_0x013d
        L_0x0022:
            java.lang.String r1 = "TRCK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002c
            goto L_0x013d
        L_0x002c:
            r7 = 21
            goto L_0x013d
        L_0x0030:
            java.lang.String r1 = "TPE3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003a
            goto L_0x013d
        L_0x003a:
            r7 = 20
            goto L_0x013d
        L_0x003e:
            java.lang.String r1 = "TPE2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0048
            goto L_0x013d
        L_0x0048:
            r7 = 19
            goto L_0x013d
        L_0x004c:
            java.lang.String r1 = "TPE1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0056
            goto L_0x013d
        L_0x0056:
            r7 = 18
            goto L_0x013d
        L_0x005a:
            java.lang.String r1 = "TIT2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0064
            goto L_0x013d
        L_0x0064:
            r7 = 17
            goto L_0x013d
        L_0x0068:
            java.lang.String r1 = "TEXT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0072
            goto L_0x013d
        L_0x0072:
            r7 = 16
            goto L_0x013d
        L_0x0076:
            java.lang.String r1 = "TDRL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0080
            goto L_0x013d
        L_0x0080:
            r7 = 15
            goto L_0x013d
        L_0x0084:
            java.lang.String r1 = "TDRC"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008e
            goto L_0x013d
        L_0x008e:
            r7 = 14
            goto L_0x013d
        L_0x0092:
            java.lang.String r1 = "TDAT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009c
            goto L_0x013d
        L_0x009c:
            r7 = 13
            goto L_0x013d
        L_0x00a0:
            java.lang.String r1 = "TCON"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00aa
            goto L_0x013d
        L_0x00aa:
            r7 = 12
            goto L_0x013d
        L_0x00ae:
            java.lang.String r1 = "TCOM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b8
            goto L_0x013d
        L_0x00b8:
            r7 = 11
            goto L_0x013d
        L_0x00bc:
            java.lang.String r1 = "TALB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c6
            goto L_0x013d
        L_0x00c6:
            r7 = 10
            goto L_0x013d
        L_0x00ca:
            java.lang.String r1 = "TYE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d4
            goto L_0x013d
        L_0x00d4:
            r7 = 9
            goto L_0x013d
        L_0x00d8:
            java.lang.String r1 = "TXT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00e2
            goto L_0x013d
        L_0x00e2:
            r7 = 8
            goto L_0x013d
        L_0x00e6:
            java.lang.String r1 = "TT2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ef
            goto L_0x013d
        L_0x00ef:
            r7 = 7
            goto L_0x013d
        L_0x00f1:
            java.lang.String r1 = "TRK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00fa
            goto L_0x013d
        L_0x00fa:
            r7 = 6
            goto L_0x013d
        L_0x00fc:
            java.lang.String r1 = "TP3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0105
            goto L_0x013d
        L_0x0105:
            r7 = 5
            goto L_0x013d
        L_0x0107:
            java.lang.String r1 = "TP2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0110
            goto L_0x013d
        L_0x0110:
            r7 = 4
            goto L_0x013d
        L_0x0112:
            java.lang.String r1 = "TP1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011b
            goto L_0x013d
        L_0x011b:
            r7 = 3
            goto L_0x013d
        L_0x011d:
            java.lang.String r1 = "TDA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0126
            goto L_0x013d
        L_0x0126:
            r7 = 2
            goto L_0x013d
        L_0x0128:
            java.lang.String r1 = "TCM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0131
            goto L_0x013d
        L_0x0131:
            r7 = 1
            goto L_0x013d
        L_0x0133:
            java.lang.String r1 = "TAL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x013c
            goto L_0x013d
        L_0x013c:
            r7 = 0
        L_0x013d:
            switch(r7) {
                case 0: goto L_0x028c;
                case 1: goto L_0x0280;
                case 2: goto L_0x0258;
                case 3: goto L_0x024c;
                case 4: goto L_0x0240;
                case 5: goto L_0x0234;
                case 6: goto L_0x0205;
                case 7: goto L_0x01f8;
                case 8: goto L_0x01eb;
                case 9: goto L_0x01d6;
                case 10: goto L_0x028c;
                case 11: goto L_0x0280;
                case 12: goto L_0x01ac;
                case 13: goto L_0x0258;
                case 14: goto L_0x0177;
                case 15: goto L_0x0142;
                case 16: goto L_0x01eb;
                case 17: goto L_0x01f8;
                case 18: goto L_0x024c;
                case 19: goto L_0x0240;
                case 20: goto L_0x0234;
                case 21: goto L_0x0205;
                case 22: goto L_0x01d6;
                default: goto L_0x0140;
            }
        L_0x0140:
            goto L_0x0297
        L_0x0142:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = b(r0)
            int r1 = r0.size()
            if (r1 == r5) goto L_0x016c
            if (r1 == r4) goto L_0x0163
            if (r1 == r3) goto L_0x015a
            goto L_0x0297
        L_0x015a:
            java.lang.Object r1 = r0.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.j0(r1)
        L_0x0163:
            java.lang.Object r1 = r0.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.k0(r1)
        L_0x016c:
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.l0(r0)
            goto L_0x0297
        L_0x0177:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = b(r0)
            int r1 = r0.size()
            if (r1 == r5) goto L_0x01a1
            if (r1 == r4) goto L_0x0198
            if (r1 == r3) goto L_0x018f
            goto L_0x0297
        L_0x018f:
            java.lang.Object r1 = r0.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.g0(r1)
        L_0x0198:
            java.lang.Object r1 = r0.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.h0(r1)
        L_0x01a1:
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.i0(r0)
            goto L_0x0297
        L_0x01ac:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Integer r0 = com.google.common.primitives.Ints.o(r0)
            if (r0 != 0) goto L_0x01c7
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.b0(r0)
            goto L_0x0297
        L_0x01c7:
            int r0 = r0.intValue()
            java.lang.String r0 = androidx.media3.extractor.metadata.id3.Id3Util.a(r0)
            if (r0 == 0) goto L_0x0297
            r9.b0(r0)
            goto L_0x0297
        L_0x01d6:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e     // Catch:{  }
            java.lang.Object r0 = r0.get(r6)     // Catch:{  }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            r9.i0(r0)     // Catch:{  }
            goto L_0x0297
        L_0x01eb:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.t0(r0)
            goto L_0x0297
        L_0x01f8:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.o0(r0)
            goto L_0x0297
        L_0x0205:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "/"
            java.lang.String[] r0 = androidx.media3.common.util.Util.k1(r0, r1)
            r1 = r0[r6]     // Catch:{  }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{  }
            int r2 = r0.length     // Catch:{  }
            if (r2 <= r5) goto L_0x0227
            r0 = r0[r5]     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            goto L_0x0228
        L_0x0227:
            r0 = 0
        L_0x0228:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{  }
            androidx.media3.common.MediaMetadata$Builder r9 = r9.r0(r1)     // Catch:{  }
            r9.q0(r0)     // Catch:{  }
            goto L_0x0297
        L_0x0234:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.U(r0)
            goto L_0x0297
        L_0x0240:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.N(r0)
            goto L_0x0297
        L_0x024c:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.P(r0)
            goto L_0x0297
        L_0x0258:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e     // Catch:{ NumberFormatException -> 0x0297 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ NumberFormatException -> 0x0297 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x0297 }
            java.lang.String r1 = r0.substring(r4, r2)     // Catch:{ NumberFormatException -> 0x0297 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0297 }
            java.lang.String r0 = r0.substring(r6, r4)     // Catch:{ NumberFormatException -> 0x0297 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0297 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0297 }
            androidx.media3.common.MediaMetadata$Builder r9 = r9.h0(r1)     // Catch:{ NumberFormatException -> 0x0297 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0297 }
            r9.g0(r0)     // Catch:{ NumberFormatException -> 0x0297 }
            goto L_0x0297
        L_0x0280:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.T(r0)
            goto L_0x0297
        L_0x028c:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f8342e
            java.lang.Object r0 = r0.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.O(r0)
        L_0x0297:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.TextInformationFrame.H(androidx.media3.common.MediaMetadata$Builder):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (!Util.c(this.f8328b, textInformationFrame.f8328b) || !Util.c(this.f8340c, textInformationFrame.f8340c) || !this.f8342e.equals(textInformationFrame.f8342e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = (527 + this.f8328b.hashCode()) * 31;
        String str = this.f8340c;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return ((hashCode + i2) * 31) + this.f8342e.hashCode();
    }

    public String toString() {
        return this.f8328b + ": description=" + this.f8340c + ": values=" + this.f8342e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8328b);
        parcel.writeString(this.f8340c);
        parcel.writeStringArray((String[]) this.f8342e.toArray(new String[0]));
    }

    public TextInformationFrame(String str, String str2, List<String> list) {
        super(str);
        Assertions.a(!list.isEmpty());
        this.f8340c = str2;
        ImmutableList<String> n2 = ImmutableList.n(list);
        this.f8342e = n2;
        this.f8341d = n2.get(0);
    }

    private TextInformationFrame(Parcel parcel) {
        this((String) Assertions.f(parcel.readString()), parcel.readString(), ImmutableList.o((String[]) Assertions.f(parcel.createStringArray())));
    }
}
