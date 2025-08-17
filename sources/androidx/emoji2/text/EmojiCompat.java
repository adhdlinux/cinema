package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EmojiCompat {

    /* renamed from: n  reason: collision with root package name */
    private static final Object f3047n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private static final Object f3048o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private static volatile EmojiCompat f3049p;

    /* renamed from: a  reason: collision with root package name */
    private final ReadWriteLock f3050a = new ReentrantReadWriteLock();

    /* renamed from: b  reason: collision with root package name */
    private final Set<InitCallback> f3051b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f3052c = 3;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f3053d;

    /* renamed from: e  reason: collision with root package name */
    private final CompatInternal f3054e;

    /* renamed from: f  reason: collision with root package name */
    final MetadataRepoLoader f3055f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f3056g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f3057h;

    /* renamed from: i  reason: collision with root package name */
    final int[] f3058i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f3059j;

    /* renamed from: k  reason: collision with root package name */
    private final int f3060k;

    /* renamed from: l  reason: collision with root package name */
    private final int f3061l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final GlyphChecker f3062m;

    private static class CompatInternal {

        /* renamed from: a  reason: collision with root package name */
        final EmojiCompat f3063a;

        CompatInternal(EmojiCompat emojiCompat) {
            this.f3063a = emojiCompat;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z2) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void c(EditorInfo editorInfo) {
            throw null;
        }
    }

    private static final class CompatInternal19 extends CompatInternal {

        /* renamed from: b  reason: collision with root package name */
        private volatile EmojiProcessor f3064b;

        /* renamed from: c  reason: collision with root package name */
        private volatile MetadataRepo f3065c;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                this.f3063a.f3055f.a(new MetadataRepoLoaderCallback() {
                    public void a(Throwable th) {
                        CompatInternal19.this.f3063a.m(th);
                    }

                    public void b(MetadataRepo metadataRepo) {
                        CompatInternal19.this.d(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.f3063a.m(th);
            }
        }

        /* access modifiers changed from: package-private */
        public CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z2) {
            return this.f3064b.h(charSequence, i2, i3, i4, z2);
        }

        /* access modifiers changed from: package-private */
        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f3065c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f3063a.f3056g);
        }

        /* access modifiers changed from: package-private */
        public void d(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f3063a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f3065c = metadataRepo;
            MetadataRepo metadataRepo2 = this.f3065c;
            SpanFactory spanFactory = new SpanFactory();
            GlyphChecker a2 = this.f3063a.f3062m;
            EmojiCompat emojiCompat = this.f3063a;
            this.f3064b = new EmojiProcessor(metadataRepo2, spanFactory, a2, emojiCompat.f3057h, emojiCompat.f3058i);
            this.f3063a.n();
        }
    }

    public static abstract class Config {

        /* renamed from: a  reason: collision with root package name */
        final MetadataRepoLoader f3067a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3068b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3069c;

        /* renamed from: d  reason: collision with root package name */
        int[] f3070d;

        /* renamed from: e  reason: collision with root package name */
        Set<InitCallback> f3071e;

        /* renamed from: f  reason: collision with root package name */
        boolean f3072f;

        /* renamed from: g  reason: collision with root package name */
        int f3073g = -16711936;

        /* renamed from: h  reason: collision with root package name */
        int f3074h = 0;

        /* renamed from: i  reason: collision with root package name */
        GlyphChecker f3075i = new DefaultGlyphChecker();

        protected Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.h(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f3067a = metadataRepoLoader;
        }

        /* access modifiers changed from: protected */
        public final MetadataRepoLoader a() {
            return this.f3067a;
        }

        public Config b(int i2) {
            this.f3074h = i2;
            return this;
        }
    }

    public interface GlyphChecker {
        boolean a(CharSequence charSequence, int i2, int i3, int i4);
    }

    public static abstract class InitCallback {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    private static class ListenerDispatcher implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final List<InitCallback> f3076b;

        /* renamed from: c  reason: collision with root package name */
        private final Throwable f3077c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3078d;

        ListenerDispatcher(InitCallback initCallback, int i2) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.h(initCallback, "initCallback cannot be null")}), i2, (Throwable) null);
        }

        public void run() {
            int size = this.f3076b.size();
            int i2 = 0;
            if (this.f3078d != 1) {
                while (i2 < size) {
                    this.f3076b.get(i2).a(this.f3077c);
                    i2++;
                }
                return;
            }
            while (i2 < size) {
                this.f3076b.get(i2).b();
                i2++;
            }
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i2) {
            this(collection, i2, (Throwable) null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i2, Throwable th) {
            Preconditions.h(collection, "initCallbacks cannot be null");
            this.f3076b = new ArrayList(collection);
            this.f3078d = i2;
            this.f3077c = th;
        }
    }

    public interface MetadataRepoLoader {
        void a(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void a(Throwable th);

        public abstract void b(MetadataRepo metadataRepo);
    }

    static class SpanFactory {
        SpanFactory() {
        }

        /* access modifiers changed from: package-private */
        public EmojiSpan a(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    private EmojiCompat(Config config) {
        this.f3056g = config.f3068b;
        this.f3057h = config.f3069c;
        this.f3058i = config.f3070d;
        this.f3059j = config.f3072f;
        this.f3060k = config.f3073g;
        this.f3055f = config.f3067a;
        this.f3061l = config.f3074h;
        this.f3062m = config.f3075i;
        this.f3053d = new Handler(Looper.getMainLooper());
        ArraySet arraySet = new ArraySet();
        this.f3051b = arraySet;
        Set<InitCallback> set = config.f3071e;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.f3071e);
        }
        this.f3054e = new CompatInternal19(this);
        l();
    }

    public static EmojiCompat b() {
        EmojiCompat emojiCompat;
        boolean z2;
        synchronized (f3047n) {
            emojiCompat = f3049p;
            if (emojiCompat != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.i(z2, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
        return EmojiProcessor.c(inputConnection, editable, i2, i3, z2);
    }

    public static boolean f(Editable editable, int i2, KeyEvent keyEvent) {
        return EmojiProcessor.d(editable, i2, keyEvent);
    }

    public static EmojiCompat g(Config config) {
        EmojiCompat emojiCompat = f3049p;
        if (emojiCompat == null) {
            synchronized (f3047n) {
                emojiCompat = f3049p;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    f3049p = emojiCompat;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean h() {
        return f3049p != null;
    }

    private boolean j() {
        return d() == 1;
    }

    /* JADX INFO: finally extract failed */
    private void l() {
        this.f3050a.writeLock().lock();
        try {
            if (this.f3061l == 0) {
                this.f3052c = 0;
            }
            this.f3050a.writeLock().unlock();
            if (d() == 0) {
                this.f3054e.a();
            }
        } catch (Throwable th) {
            this.f3050a.writeLock().unlock();
            throw th;
        }
    }

    public int c() {
        return this.f3060k;
    }

    public int d() {
        this.f3050a.readLock().lock();
        try {
            return this.f3052c;
        } finally {
            this.f3050a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f3059j;
    }

    public void k() {
        boolean z2 = true;
        if (this.f3061l != 1) {
            z2 = false;
        }
        Preconditions.i(z2, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!j()) {
            this.f3050a.writeLock().lock();
            try {
                if (this.f3052c != 0) {
                    this.f3052c = 0;
                    this.f3050a.writeLock().unlock();
                    this.f3054e.a();
                }
            } finally {
                this.f3050a.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f3050a.writeLock().lock();
        try {
            this.f3052c = 2;
            arrayList.addAll(this.f3051b);
            this.f3051b.clear();
            this.f3050a.writeLock().unlock();
            this.f3053d.post(new ListenerDispatcher(arrayList, this.f3052c, th));
        } catch (Throwable th2) {
            this.f3050a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void n() {
        ArrayList arrayList = new ArrayList();
        this.f3050a.writeLock().lock();
        try {
            this.f3052c = 1;
            arrayList.addAll(this.f3051b);
            this.f3051b.clear();
            this.f3050a.writeLock().unlock();
            this.f3053d.post(new ListenerDispatcher((Collection<InitCallback>) arrayList, this.f3052c));
        } catch (Throwable th) {
            this.f3050a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        int i2;
        if (charSequence == null) {
            i2 = 0;
        } else {
            i2 = charSequence.length();
        }
        return p(charSequence, 0, i2);
    }

    public CharSequence p(CharSequence charSequence, int i2, int i3) {
        return q(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i2, int i3, int i4) {
        return r(charSequence, i2, i3, i4, 0);
    }

    public CharSequence r(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Preconditions.i(j(), "Not initialized yet");
        Preconditions.e(i2, "start cannot be negative");
        Preconditions.e(i3, "end cannot be negative");
        Preconditions.e(i4, "maxEmojiCount cannot be negative");
        if (i2 <= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.b(z2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        if (i2 <= charSequence.length()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.b(z3, "start should be < than charSequence length");
        if (i3 <= charSequence.length()) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.b(z4, "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        if (i5 == 1) {
            z5 = true;
        } else if (i5 != 2) {
            z5 = this.f3056g;
        } else {
            z5 = false;
        }
        return this.f3054e.b(charSequence, i2, i3, i4, z5);
    }

    public void s(InitCallback initCallback) {
        Preconditions.h(initCallback, "initCallback cannot be null");
        this.f3050a.writeLock().lock();
        try {
            if (this.f3052c != 1) {
                if (this.f3052c != 2) {
                    this.f3051b.add(initCallback);
                }
            }
            this.f3053d.post(new ListenerDispatcher(initCallback, this.f3052c));
        } finally {
            this.f3050a.writeLock().unlock();
        }
    }

    public void t(InitCallback initCallback) {
        Preconditions.h(initCallback, "initCallback cannot be null");
        this.f3050a.writeLock().lock();
        try {
            this.f3051b.remove(initCallback);
        } finally {
            this.f3050a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (j() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f3054e.c(editorInfo);
        }
    }
}
