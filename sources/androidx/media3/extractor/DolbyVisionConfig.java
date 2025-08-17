package androidx.media3.extractor;

import androidx.media3.common.util.ParsableByteArray;

public final class DolbyVisionConfig {

    /* renamed from: a  reason: collision with root package name */
    public final int f7995a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7996b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7997c;

    private DolbyVisionConfig(int i2, int i3, String str) {
        this.f7995a = i2;
        this.f7996b = i3;
        this.f7997c = str;
    }

    public static DolbyVisionConfig a(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.V(2);
        int H = parsableByteArray.H();
        int i2 = H >> 1;
        int H2 = ((parsableByteArray.H() >> 3) & 31) | ((H & 1) << 5);
        if (i2 == 4 || i2 == 5 || i2 == 7) {
            str = "dvhe";
        } else if (i2 == 8) {
            str = "hev1";
        } else if (i2 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = ".0";
        sb.append(str2);
        sb.append(i2);
        if (H2 >= 10) {
            str2 = ".";
        }
        sb.append(str2);
        sb.append(H2);
        return new DolbyVisionConfig(i2, H2, sb.toString());
    }
}
