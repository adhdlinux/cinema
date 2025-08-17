package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class WebvttSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<WebvttCueInfo> f9148b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f9149c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f9150d;

    public WebvttSubtitle(List<WebvttCueInfo> list) {
        this.f9148b = Collections.unmodifiableList(new ArrayList(list));
        this.f9149c = new long[(list.size() * 2)];
        for (int i2 = 0; i2 < list.size(); i2++) {
            WebvttCueInfo webvttCueInfo = list.get(i2);
            int i3 = i2 * 2;
            long[] jArr = this.f9149c;
            jArr[i3] = webvttCueInfo.f9119b;
            jArr[i3 + 1] = webvttCueInfo.f9120c;
        }
        long[] jArr2 = this.f9149c;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f9150d = copyOf;
        Arrays.sort(copyOf);
    }

    public int a(long j2) {
        int d2 = Util.d(this.f9150d, j2, false, false);
        if (d2 < this.f9150d.length) {
            return d2;
        }
        return -1;
    }

    public List<Cue> b(long j2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < this.f9148b.size(); i2++) {
            long[] jArr = this.f9149c;
            int i3 = i2 * 2;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                WebvttCueInfo webvttCueInfo = this.f9148b.get(i2);
                Cue cue = webvttCueInfo.f9118a;
                if (cue.f4562e == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, new b());
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            arrayList.add(((WebvttCueInfo) arrayList2.get(i4)).f9118a.a().h((float) (-1 - i4), 1).a());
        }
        return arrayList;
    }

    public long c(int i2) {
        boolean z2;
        boolean z3 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (i2 >= this.f9150d.length) {
            z3 = false;
        }
        Assertions.a(z3);
        return this.f9150d[i2];
    }

    public int d() {
        return this.f9150d.length;
    }
}
