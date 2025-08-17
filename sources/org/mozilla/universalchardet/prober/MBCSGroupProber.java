package org.mozilla.universalchardet.prober;

import com.startapp.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.universalchardet.prober.CharsetProber;

public class MBCSGroupProber extends CharsetProber {

    /* renamed from: b  reason: collision with root package name */
    private CharsetProber.ProbingState f41933b;

    /* renamed from: c  reason: collision with root package name */
    private List<CharsetProber> f41934c;

    /* renamed from: d  reason: collision with root package name */
    private CharsetProber f41935d;

    /* renamed from: e  reason: collision with root package name */
    private int f41936e;

    public MBCSGroupProber() {
        ArrayList arrayList = new ArrayList();
        this.f41934c = arrayList;
        arrayList.add(new UTF8Prober());
        this.f41934c.add(new SJISProber());
        this.f41934c.add(new EUCJPProber());
        this.f41934c.add(new GB18030Prober());
        this.f41934c.add(new EUCKRProber());
        this.f41934c.add(new Big5Prober());
        this.f41934c.add(new EUCTWProber());
        j();
    }

    public String c() {
        if (this.f41935d == null) {
            d();
            if (this.f41935d == null) {
                this.f41935d = this.f41934c.get(0);
            }
        }
        return this.f41935d.c();
    }

    public float d() {
        CharsetProber.ProbingState probingState = this.f41933b;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f2 = 0.0f;
        for (CharsetProber next : this.f41934c) {
            if (next.g()) {
                float d2 = next.d();
                if (f2 < d2) {
                    this.f41935d = next;
                    f2 = d2;
                }
            }
        }
        return f2;
    }

    public CharsetProber.ProbingState e() {
        return this.f41933b;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        int i4 = i3 + i2;
        boolean z2 = true;
        int i5 = 0;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if ((b2 & y1.f36938c) != 0) {
                bArr2[i5] = b2;
                i5++;
                z2 = true;
            } else if (z2) {
                bArr2[i5] = b2;
                i5++;
                z2 = false;
            }
            i2++;
        }
        Iterator<CharsetProber> it2 = this.f41934c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            CharsetProber next = it2.next();
            if (next.g()) {
                CharsetProber.ProbingState f2 = next.f(bArr2, 0, i5);
                CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                if (f2 == probingState) {
                    this.f41935d = next;
                    this.f41933b = probingState;
                    break;
                }
                CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                if (f2 == probingState2) {
                    next.k(false);
                    int i6 = this.f41936e - 1;
                    this.f41936e = i6;
                    if (i6 <= 0) {
                        this.f41933b = probingState2;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return this.f41933b;
    }

    public final void j() {
        this.f41936e = 0;
        for (CharsetProber next : this.f41934c) {
            next.j();
            next.k(true);
            this.f41936e++;
        }
        this.f41935d = null;
        this.f41933b = CharsetProber.ProbingState.DETECTING;
    }
}
