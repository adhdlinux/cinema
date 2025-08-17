package com.google.android.exoplayer2.extractor.mp4;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Atom {

    /* renamed from: a  reason: collision with root package name */
    public final int f24531a;

    static final class ContainerAtom extends Atom {

        /* renamed from: b  reason: collision with root package name */
        public final long f24532b;

        /* renamed from: c  reason: collision with root package name */
        public final List<LeafAtom> f24533c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public final List<ContainerAtom> f24534d = new ArrayList();

        public ContainerAtom(int i2, long j2) {
            super(i2);
            this.f24532b = j2;
        }

        public void d(ContainerAtom containerAtom) {
            this.f24534d.add(containerAtom);
        }

        public void e(LeafAtom leafAtom) {
            this.f24533c.add(leafAtom);
        }

        public ContainerAtom f(int i2) {
            int size = this.f24534d.size();
            for (int i3 = 0; i3 < size; i3++) {
                ContainerAtom containerAtom = this.f24534d.get(i3);
                if (containerAtom.f24531a == i2) {
                    return containerAtom;
                }
            }
            return null;
        }

        public LeafAtom g(int i2) {
            int size = this.f24533c.size();
            for (int i3 = 0; i3 < size; i3++) {
                LeafAtom leafAtom = this.f24533c.get(i3);
                if (leafAtom.f24531a == i2) {
                    return leafAtom;
                }
            }
            return null;
        }

        public String toString() {
            return Atom.a(this.f24531a) + " leaves: " + Arrays.toString(this.f24533c.toArray()) + " containers: " + Arrays.toString(this.f24534d.toArray());
        }
    }

    static final class LeafAtom extends Atom {

        /* renamed from: b  reason: collision with root package name */
        public final ParsableByteArray f24535b;

        public LeafAtom(int i2, ParsableByteArray parsableByteArray) {
            super(i2);
            this.f24535b = parsableByteArray;
        }
    }

    public Atom(int i2) {
        this.f24531a = i2;
    }

    public static String a(int i2) {
        return "" + ((char) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE)) + ((char) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE)) + ((char) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE)) + ((char) (i2 & JfifUtil.MARKER_FIRST_BYTE));
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public static int c(int i2) {
        return (i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
    }

    public String toString() {
        return a(this.f24531a);
    }
}
