package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class WebvttSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<WebvttCueInfo> f27621b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f27622c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f27623d;

    public WebvttSubtitle(List<WebvttCueInfo> list) {
        this.f27621b = Collections.unmodifiableList(new ArrayList(list));
        this.f27622c = new long[(list.size() * 2)];
        for (int i2 = 0; i2 < list.size(); i2++) {
            WebvttCueInfo webvttCueInfo = list.get(i2);
            int i3 = i2 * 2;
            long[] jArr = this.f27622c;
            jArr[i3] = webvttCueInfo.f27592b;
            jArr[i3 + 1] = webvttCueInfo.f27593c;
        }
        long[] jArr2 = this.f27622c;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f27623d = copyOf;
        Arrays.sort(copyOf);
    }

    public int a(long j2) {
        int e2 = Util.e(this.f27623d, j2, false, false);
        if (e2 < this.f27623d.length) {
            return e2;
        }
        return -1;
    }

    public List<Cue> b(long j2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < this.f27621b.size(); i2++) {
            long[] jArr = this.f27622c;
            int i3 = i2 * 2;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                WebvttCueInfo webvttCueInfo = this.f27621b.get(i2);
                Cue cue = webvttCueInfo.f27591a;
                if (cue.f27206f == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, new b());
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            arrayList.add(((WebvttCueInfo) arrayList2.get(i4)).f27591a.b().h((float) (-1 - i4), 1).a());
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
        if (i2 >= this.f27623d.length) {
            z3 = false;
        }
        Assertions.a(z3);
        return this.f27623d[i2];
    }

    public int d() {
        return this.f27623d.length;
    }
}
