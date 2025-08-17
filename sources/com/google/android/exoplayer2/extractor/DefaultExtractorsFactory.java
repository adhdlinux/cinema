package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.jpeg.JpegExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DefaultExtractorsFactory implements ExtractorsFactory {

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f24182o = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* renamed from: p  reason: collision with root package name */
    private static final ExtensionLoader f24183p = new ExtensionLoader(new b());

    /* renamed from: q  reason: collision with root package name */
    private static final ExtensionLoader f24184q = new ExtensionLoader(new c());

    /* renamed from: b  reason: collision with root package name */
    private boolean f24185b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24186c;

    /* renamed from: d  reason: collision with root package name */
    private int f24187d;

    /* renamed from: e  reason: collision with root package name */
    private int f24188e;

    /* renamed from: f  reason: collision with root package name */
    private int f24189f;

    /* renamed from: g  reason: collision with root package name */
    private int f24190g;

    /* renamed from: h  reason: collision with root package name */
    private int f24191h;

    /* renamed from: i  reason: collision with root package name */
    private int f24192i;

    /* renamed from: j  reason: collision with root package name */
    private int f24193j;

    /* renamed from: k  reason: collision with root package name */
    private int f24194k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f24195l;

    /* renamed from: m  reason: collision with root package name */
    private ImmutableList<Format> f24196m = ImmutableList.r();

    /* renamed from: n  reason: collision with root package name */
    private int f24197n = 112800;

    private static final class ExtensionLoader {

        /* renamed from: a  reason: collision with root package name */
        private final ConstructorSupplier f24198a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f24199b = new AtomicBoolean(false);

        /* renamed from: c  reason: collision with root package name */
        private Constructor<? extends Extractor> f24200c;

        public interface ConstructorSupplier {
            Constructor<? extends Extractor> a() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException;
        }

        public ExtensionLoader(ConstructorSupplier constructorSupplier) {
            this.f24198a = constructorSupplier;
        }

        private Constructor<? extends Extractor> b() {
            synchronized (this.f24199b) {
                if (this.f24199b.get()) {
                    Constructor<? extends Extractor> constructor = this.f24200c;
                    return constructor;
                }
                try {
                    Constructor<? extends Extractor> a2 = this.f24198a.a();
                    return a2;
                } catch (ClassNotFoundException unused) {
                    this.f24199b.set(true);
                    return this.f24200c;
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating extension", e2);
                }
            }
        }

        public Extractor a(Object... objArr) {
            Constructor<? extends Extractor> b2 = b();
            if (b2 == null) {
                return null;
            }
            try {
                return (Extractor) b2.newInstance(objArr);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating extractor", e2);
            }
        }
    }

    private void e(int i2, List<Extractor> list) {
        int i3 = 2;
        switch (i2) {
            case 0:
                list.add(new Ac3Extractor());
                return;
            case 1:
                list.add(new Ac4Extractor());
                return;
            case 2:
                boolean z2 = this.f24187d | this.f24185b;
                if (!this.f24186c) {
                    i3 = 0;
                }
                list.add(new AdtsExtractor(i3 | z2 ? 1 : 0));
                return;
            case 3:
                boolean z3 = this.f24188e | this.f24185b;
                if (!this.f24186c) {
                    i3 = 0;
                }
                list.add(new AmrExtractor(i3 | z3 ? 1 : 0));
                return;
            case 4:
                Extractor a2 = f24183p.a(Integer.valueOf(this.f24189f));
                if (a2 != null) {
                    list.add(a2);
                    return;
                } else {
                    list.add(new FlacExtractor(this.f24189f));
                    return;
                }
            case 5:
                list.add(new FlvExtractor());
                return;
            case 6:
                list.add(new MatroskaExtractor(this.f24190g));
                return;
            case 7:
                boolean z4 = this.f24193j | this.f24185b;
                if (!this.f24186c) {
                    i3 = 0;
                }
                list.add(new Mp3Extractor(i3 | z4 ? 1 : 0));
                return;
            case 8:
                list.add(new FragmentedMp4Extractor(this.f24192i));
                list.add(new Mp4Extractor(this.f24191h));
                return;
            case 9:
                list.add(new OggExtractor());
                return;
            case 10:
                list.add(new PsExtractor());
                return;
            case 11:
                list.add(new TsExtractor(this.f24194k, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(this.f24195l, this.f24196m), this.f24197n));
                return;
            case 12:
                list.add(new WavExtractor());
                return;
            case 14:
                list.add(new JpegExtractor());
                return;
            case 15:
                Extractor a3 = f24184q.a(new Object[0]);
                if (a3 != null) {
                    list.add(a3);
                    return;
                }
                return;
            case 16:
                list.add(new AviExtractor());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public static Constructor<? extends Extractor> f() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
            return null;
        }
        return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[]{Integer.TYPE});
    }

    /* access modifiers changed from: private */
    public static Constructor<? extends Extractor> g() throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
    }

    public synchronized Extractor[] b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr = f24182o;
        arrayList = new ArrayList(iArr.length);
        int b2 = FileTypes.b(map);
        if (b2 != -1) {
            e(b2, arrayList);
        }
        int c2 = FileTypes.c(uri);
        if (!(c2 == -1 || c2 == b2)) {
            e(c2, arrayList);
        }
        for (int i2 : iArr) {
            if (!(i2 == b2 || i2 == c2)) {
                e(i2, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    public synchronized Extractor[] c() {
        return b(Uri.EMPTY, new HashMap());
    }
}
