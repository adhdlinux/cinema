package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.common.FileTypes;
import androidx.media3.common.Format;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.amr.AmrExtractor;
import androidx.media3.extractor.avi.AviExtractor;
import androidx.media3.extractor.avif.AvifExtractor;
import androidx.media3.extractor.bmp.BmpExtractor;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.flv.FlvExtractor;
import androidx.media3.extractor.heif.HeifExtractor;
import androidx.media3.extractor.jpeg.JpegExtractor;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.ogg.OggExtractor;
import androidx.media3.extractor.png.PngExtractor;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractor;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.wav.WavExtractor;
import androidx.media3.extractor.webp.WebpExtractor;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DefaultExtractorsFactory implements ExtractorsFactory {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f7972r = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};

    /* renamed from: s  reason: collision with root package name */
    private static final ExtensionLoader f7973s = new ExtensionLoader(new b());

    /* renamed from: t  reason: collision with root package name */
    private static final ExtensionLoader f7974t = new ExtensionLoader(new c());

    /* renamed from: b  reason: collision with root package name */
    private boolean f7975b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7976c;

    /* renamed from: d  reason: collision with root package name */
    private int f7977d;

    /* renamed from: e  reason: collision with root package name */
    private int f7978e;

    /* renamed from: f  reason: collision with root package name */
    private int f7979f;

    /* renamed from: g  reason: collision with root package name */
    private int f7980g;

    /* renamed from: h  reason: collision with root package name */
    private int f7981h;

    /* renamed from: i  reason: collision with root package name */
    private int f7982i;

    /* renamed from: j  reason: collision with root package name */
    private int f7983j;

    /* renamed from: k  reason: collision with root package name */
    private int f7984k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f7985l;

    /* renamed from: m  reason: collision with root package name */
    private ImmutableList<Format> f7986m;

    /* renamed from: n  reason: collision with root package name */
    private int f7987n = 112800;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7988o = true;

    /* renamed from: p  reason: collision with root package name */
    private SubtitleParser.Factory f7989p = new DefaultSubtitleParserFactory();

    /* renamed from: q  reason: collision with root package name */
    private int f7990q;

    private static final class ExtensionLoader {

        /* renamed from: a  reason: collision with root package name */
        private final ConstructorSupplier f7991a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f7992b = new AtomicBoolean(false);

        /* renamed from: c  reason: collision with root package name */
        private Constructor<? extends Extractor> f7993c;

        public interface ConstructorSupplier {
            Constructor<? extends Extractor> a() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException;
        }

        public ExtensionLoader(ConstructorSupplier constructorSupplier) {
            this.f7991a = constructorSupplier;
        }

        private Constructor<? extends Extractor> b() {
            synchronized (this.f7992b) {
                if (this.f7992b.get()) {
                    Constructor<? extends Extractor> constructor = this.f7993c;
                    return constructor;
                }
                try {
                    Constructor<? extends Extractor> a2 = this.f7991a.a();
                    return a2;
                } catch (ClassNotFoundException unused) {
                    this.f7992b.set(true);
                    return this.f7993c;
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

    private void g(int i2, List<Extractor> list) {
        int i3;
        int i4 = 2;
        int i5 = 0;
        switch (i2) {
            case 0:
                list.add(new Ac3Extractor());
                return;
            case 1:
                list.add(new Ac4Extractor());
                return;
            case 2:
                boolean z2 = this.f7977d | this.f7975b;
                if (!this.f7976c) {
                    i4 = 0;
                }
                list.add(new AdtsExtractor(z2 | i4 ? 1 : 0));
                return;
            case 3:
                boolean z3 = this.f7978e | this.f7975b;
                if (!this.f7976c) {
                    i4 = 0;
                }
                list.add(new AmrExtractor(z3 | i4 ? 1 : 0));
                return;
            case 4:
                Extractor a2 = f7973s.a(Integer.valueOf(this.f7979f));
                if (a2 != null) {
                    list.add(a2);
                    return;
                } else {
                    list.add(new FlacExtractor(this.f7979f));
                    return;
                }
            case 5:
                list.add(new FlvExtractor());
                return;
            case 6:
                SubtitleParser.Factory factory = this.f7989p;
                int i6 = this.f7980g;
                if (this.f7988o) {
                    i4 = 0;
                }
                list.add(new MatroskaExtractor(factory, i4 | i6));
                return;
            case 7:
                boolean z4 = this.f7983j | this.f7975b;
                if (!this.f7976c) {
                    i4 = 0;
                }
                list.add(new Mp3Extractor(z4 | i4 ? 1 : 0));
                return;
            case 8:
                SubtitleParser.Factory factory2 = this.f7989p;
                int i7 = this.f7982i;
                if (this.f7988o) {
                    i3 = 0;
                } else {
                    i3 = 32;
                }
                list.add(new FragmentedMp4Extractor(factory2, i7 | i3));
                SubtitleParser.Factory factory3 = this.f7989p;
                int i8 = this.f7981h;
                if (!this.f7988o) {
                    i5 = 16;
                }
                list.add(new Mp4Extractor(factory3, i8 | i5));
                return;
            case 9:
                list.add(new OggExtractor());
                return;
            case 10:
                list.add(new PsExtractor());
                return;
            case 11:
                if (this.f7986m == null) {
                    this.f7986m = ImmutableList.r();
                }
                list.add(new TsExtractor(this.f7984k, !this.f7988o ? 1 : 0, this.f7989p, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(this.f7985l, this.f7986m), this.f7987n));
                return;
            case 12:
                list.add(new WavExtractor());
                return;
            case 14:
                list.add(new JpegExtractor(this.f7990q));
                return;
            case 15:
                Extractor a3 = f7974t.a(new Object[0]);
                if (a3 != null) {
                    list.add(a3);
                    return;
                }
                return;
            case 16:
                list.add(new AviExtractor(true ^ this.f7988o ? 1 : 0, this.f7989p));
                return;
            case 17:
                list.add(new PngExtractor());
                return;
            case 18:
                list.add(new WebpExtractor());
                return;
            case 19:
                list.add(new BmpExtractor());
                return;
            case 20:
                int i9 = this.f7981h;
                if ((i9 & 2) == 0 && (i9 & 4) == 0) {
                    list.add(new HeifExtractor());
                    return;
                }
                return;
            case 21:
                list.add(new AvifExtractor());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public static Constructor<? extends Extractor> i() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
            return null;
        }
        return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[]{Integer.TYPE});
    }

    /* access modifiers changed from: private */
    public static Constructor<? extends Extractor> j() throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
    }

    public synchronized Extractor[] b(Uri uri, Map<String, List<String>> map) {
        Extractor[] extractorArr;
        int[] iArr = f7972r;
        ArrayList arrayList = new ArrayList(iArr.length);
        int b2 = FileTypes.b(map);
        if (b2 != -1) {
            g(b2, arrayList);
        }
        int c2 = FileTypes.c(uri);
        if (!(c2 == -1 || c2 == b2)) {
            g(c2, arrayList);
        }
        for (int i2 : iArr) {
            if (!(i2 == b2 || i2 == c2)) {
                g(i2, arrayList);
            }
        }
        extractorArr = new Extractor[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Extractor extractor = (Extractor) arrayList.get(i3);
            if (this.f7988o && !(extractor.c() instanceof FragmentedMp4Extractor) && !(extractor.c() instanceof Mp4Extractor) && !(extractor.c() instanceof TsExtractor) && !(extractor.c() instanceof AviExtractor) && !(extractor.c() instanceof MatroskaExtractor)) {
                extractor = new SubtitleTranscodingExtractor(extractor, this.f7989p);
            }
            extractorArr[i3] = extractor;
        }
        return extractorArr;
    }

    public synchronized Extractor[] c() {
        return b(Uri.EMPTY, new HashMap());
    }

    @Deprecated
    /* renamed from: h */
    public synchronized DefaultExtractorsFactory d(boolean z2) {
        this.f7988o = z2;
        return this;
    }

    public synchronized DefaultExtractorsFactory k(int i2) {
        this.f7990q = i2;
        return this;
    }

    /* renamed from: l */
    public synchronized DefaultExtractorsFactory a(SubtitleParser.Factory factory) {
        this.f7989p = factory;
        return this;
    }
}
