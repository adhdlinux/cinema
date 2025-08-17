package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.sequence.HebrewModel;
import org.mozilla.universalchardet.prober.sequence.Ibm855Model;
import org.mozilla.universalchardet.prober.sequence.Ibm866Model;
import org.mozilla.universalchardet.prober.sequence.Koi8rModel;
import org.mozilla.universalchardet.prober.sequence.Latin5BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Latin5Model;
import org.mozilla.universalchardet.prober.sequence.Latin7Model;
import org.mozilla.universalchardet.prober.sequence.MacCyrillicModel;
import org.mozilla.universalchardet.prober.sequence.ThaiModel;
import org.mozilla.universalchardet.prober.sequence.Win1251BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Win1251Model;
import org.mozilla.universalchardet.prober.sequence.Win1253Model;

public class SBCSGroupProber extends CharsetProber {

    /* renamed from: b  reason: collision with root package name */
    private CharsetProber.ProbingState f41937b;

    /* renamed from: c  reason: collision with root package name */
    private List<CharsetProber> f41938c;

    /* renamed from: d  reason: collision with root package name */
    private CharsetProber f41939d;

    /* renamed from: e  reason: collision with root package name */
    private int f41940e;

    public SBCSGroupProber() {
        ArrayList arrayList = new ArrayList();
        this.f41938c = arrayList;
        arrayList.add(new SingleByteCharsetProber(new Win1251Model()));
        this.f41938c.add(new SingleByteCharsetProber(new Koi8rModel()));
        this.f41938c.add(new SingleByteCharsetProber(new Latin5Model()));
        this.f41938c.add(new SingleByteCharsetProber(new MacCyrillicModel()));
        this.f41938c.add(new SingleByteCharsetProber(new Ibm866Model()));
        this.f41938c.add(new SingleByteCharsetProber(new Ibm855Model()));
        this.f41938c.add(new SingleByteCharsetProber(new Latin7Model()));
        this.f41938c.add(new SingleByteCharsetProber(new Win1253Model()));
        this.f41938c.add(new SingleByteCharsetProber(new Latin5BulgarianModel()));
        this.f41938c.add(new SingleByteCharsetProber(new Win1251BulgarianModel()));
        this.f41938c.add(new SingleByteCharsetProber(new ThaiModel()));
        HebrewModel hebrewModel = new HebrewModel();
        HebrewProber hebrewProber = new HebrewProber();
        SingleByteCharsetProber singleByteCharsetProber = new SingleByteCharsetProber(hebrewModel, false, hebrewProber);
        SingleByteCharsetProber singleByteCharsetProber2 = new SingleByteCharsetProber(hebrewModel, true, hebrewProber);
        hebrewProber.n(singleByteCharsetProber, singleByteCharsetProber2);
        this.f41938c.add(hebrewProber);
        this.f41938c.add(singleByteCharsetProber);
        this.f41938c.add(singleByteCharsetProber2);
        j();
    }

    public String c() {
        if (this.f41939d == null) {
            d();
            if (this.f41939d == null) {
                this.f41939d = this.f41938c.get(0);
            }
        }
        return this.f41939d.c();
    }

    public float d() {
        CharsetProber.ProbingState probingState = this.f41937b;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f2 = 0.0f;
        for (CharsetProber next : this.f41938c) {
            if (next.g()) {
                float d2 = next.d();
                if (f2 < d2) {
                    this.f41939d = next;
                    f2 = d2;
                }
            }
        }
        return f2;
    }

    public CharsetProber.ProbingState e() {
        return this.f41937b;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        ByteBuffer b2 = b(bArr, i2, i3);
        if (b2.position() != 0) {
            Iterator<CharsetProber> it2 = this.f41938c.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                CharsetProber next = it2.next();
                if (next.g()) {
                    CharsetProber.ProbingState f2 = next.f(b2.array(), 0, b2.position());
                    CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                    if (f2 == probingState) {
                        this.f41939d = next;
                        this.f41937b = probingState;
                        break;
                    }
                    CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                    if (f2 == probingState2) {
                        next.k(false);
                        int i4 = this.f41940e - 1;
                        this.f41940e = i4;
                        if (i4 <= 0) {
                            this.f41937b = probingState2;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return this.f41937b;
    }

    public final void j() {
        this.f41940e = 0;
        for (CharsetProber next : this.f41938c) {
            next.j();
            next.k(true);
            this.f41940e++;
        }
        this.f41939d = null;
        this.f41937b = CharsetProber.ProbingState.DETECTING;
    }
}
