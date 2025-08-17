package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {

    /* renamed from: j  reason: collision with root package name */
    private static final FontProviderHelper f3107j = new FontProviderHelper();

    public static class FontProviderHelper {
        public Typeface a(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.a(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public FontsContractCompat.FontFamilyResult b(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.b(context, (CancellationSignal) null, fontRequest);
        }

        public void c(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f3108a;

        /* renamed from: b  reason: collision with root package name */
        private final FontRequest f3109b;

        /* renamed from: c  reason: collision with root package name */
        private final FontProviderHelper f3110c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f3111d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private Handler f3112e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f3113f;

        /* renamed from: g  reason: collision with root package name */
        private ThreadPoolExecutor f3114g;

        /* renamed from: h  reason: collision with root package name */
        private RetryPolicy f3115h;

        /* renamed from: i  reason: collision with root package name */
        EmojiCompat.MetadataRepoLoaderCallback f3116i;

        /* renamed from: j  reason: collision with root package name */
        private ContentObserver f3117j;

        /* renamed from: k  reason: collision with root package name */
        private Runnable f3118k;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.h(context, "Context cannot be null");
            Preconditions.h(fontRequest, "FontRequest cannot be null");
            this.f3108a = context.getApplicationContext();
            this.f3109b = fontRequest;
            this.f3110c = fontProviderHelper;
        }

        private void b() {
            synchronized (this.f3111d) {
                this.f3116i = null;
                ContentObserver contentObserver = this.f3117j;
                if (contentObserver != null) {
                    this.f3110c.d(this.f3108a, contentObserver);
                    this.f3117j = null;
                }
                Handler handler = this.f3112e;
                if (handler != null) {
                    handler.removeCallbacks(this.f3118k);
                }
                this.f3112e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f3114g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f3113f = null;
                this.f3114g = null;
            }
        }

        private FontsContractCompat.FontInfo e() {
            try {
                FontsContractCompat.FontFamilyResult b2 = this.f3110c.b(this.f3108a, this.f3109b);
                if (b2.c() == 0) {
                    FontsContractCompat.FontInfo[] b3 = b2.b();
                    if (b3 != null && b3.length != 0) {
                        return b3[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b2.c() + ")");
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("provider not found", e2);
            }
        }

        private void f(Uri uri, long j2) {
            synchronized (this.f3111d) {
                Handler handler = this.f3112e;
                if (handler == null) {
                    handler = ConcurrencyHelpers.d();
                    this.f3112e = handler;
                }
                if (this.f3117j == null) {
                    AnonymousClass1 r2 = new ContentObserver(handler) {
                        public void onChange(boolean z2, Uri uri) {
                            FontRequestMetadataLoader.this.d();
                        }
                    };
                    this.f3117j = r2;
                    this.f3110c.c(this.f3108a, uri, r2);
                }
                if (this.f3118k == null) {
                    this.f3118k = new d(this);
                }
                handler.postDelayed(this.f3118k, j2);
            }
        }

        public void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.h(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.f3111d) {
                this.f3116i = metadataRepoLoaderCallback;
            }
            d();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            if (r1 != 2) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            r2 = r8.f3111d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r3 = r8.f3115h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
            if (r3 == null) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
            r3 = r3.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            if (r3 < 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
            f(r0.d(), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0034, code lost:
            if (r1 != 0) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            androidx.core.os.TraceCompat.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
            r1 = r8.f3110c.a(r8.f3108a, r0);
            r0 = androidx.core.graphics.TypefaceCompatUtil.f(r8.f3108a, (android.os.CancellationSignal) null, r0.d());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004e, code lost:
            if (r0 == null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
            if (r1 == null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.b(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            androidx.core.os.TraceCompat.b();
            r1 = r8.f3111d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r2 = r8.f3116i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
            if (r2 == null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0060, code lost:
            r2.b(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0072, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            androidx.core.os.TraceCompat.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0077, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0093, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0094, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0097, code lost:
            monitor-enter(r8.f3111d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r2 = r8.f3116i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x009a, code lost:
            if (r2 != null) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009c, code lost:
            r2.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a0, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r0 = e();
            r1 = r0.b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r8 = this;
                java.lang.Object r0 = r8.f3111d
                monitor-enter(r0)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r8.f3116i     // Catch:{ all -> 0x00a7 }
                if (r1 != 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                androidx.core.provider.FontsContractCompat$FontInfo r0 = r8.e()     // Catch:{ all -> 0x0094 }
                int r1 = r0.b()     // Catch:{ all -> 0x0094 }
                r2 = 2
                if (r1 != r2) goto L_0x0034
                java.lang.Object r2 = r8.f3111d     // Catch:{ all -> 0x0094 }
                monitor-enter(r2)     // Catch:{ all -> 0x0094 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r8.f3115h     // Catch:{ all -> 0x0031 }
                if (r3 == 0) goto L_0x002f
                long r3 = r3.a()     // Catch:{ all -> 0x0031 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 < 0) goto L_0x002f
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0031 }
                r8.f(r0, r3)     // Catch:{ all -> 0x0031 }
                monitor-exit(r2)     // Catch:{ all -> 0x0031 }
                return
            L_0x002f:
                monitor-exit(r2)     // Catch:{ all -> 0x0031 }
                goto L_0x0034
            L_0x0031:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0031 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x0034:
                if (r1 != 0) goto L_0x0078
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.TraceCompat.a(r1)     // Catch:{ all -> 0x0073 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r1 = r8.f3110c     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r8.f3108a     // Catch:{ all -> 0x0073 }
                android.graphics.Typeface r1 = r1.a(r2, r0)     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r8.f3108a     // Catch:{ all -> 0x0073 }
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0073 }
                r3 = 0
                java.nio.ByteBuffer r0 = androidx.core.graphics.TypefaceCompatUtil.f(r2, r3, r0)     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x006b
                if (r1 == 0) goto L_0x006b
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.b(r1, r0)     // Catch:{ all -> 0x0073 }
                androidx.core.os.TraceCompat.b()     // Catch:{ all -> 0x0094 }
                java.lang.Object r1 = r8.f3111d     // Catch:{ all -> 0x0094 }
                monitor-enter(r1)     // Catch:{ all -> 0x0094 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.f3116i     // Catch:{ all -> 0x0068 }
                if (r2 == 0) goto L_0x0063
                r2.b(r0)     // Catch:{ all -> 0x0068 }
            L_0x0063:
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                r8.b()     // Catch:{ all -> 0x0094 }
                goto L_0x00a3
            L_0x0068:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x006b:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0073 }
                throw r0     // Catch:{ all -> 0x0073 }
            L_0x0073:
                r0 = move-exception
                androidx.core.os.TraceCompat.b()     // Catch:{ all -> 0x0094 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x0078:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0094 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
                r2.<init>()     // Catch:{ all -> 0x0094 }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x0094 }
                r2.append(r1)     // Catch:{ all -> 0x0094 }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x0094 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0094 }
                r0.<init>(r1)     // Catch:{ all -> 0x0094 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x0094:
                r0 = move-exception
                java.lang.Object r1 = r8.f3111d
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.f3116i     // Catch:{ all -> 0x00a4 }
                if (r2 == 0) goto L_0x009f
                r2.a(r0)     // Catch:{ all -> 0x00a4 }
            L_0x009f:
                monitor-exit(r1)     // Catch:{ all -> 0x00a4 }
                r8.b()
            L_0x00a3:
                return
            L_0x00a4:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a4 }
                throw r0
            L_0x00a7:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.c():void");
        }

        /* access modifiers changed from: package-private */
        public void d() {
            synchronized (this.f3111d) {
                if (this.f3116i != null) {
                    if (this.f3113f == null) {
                        ThreadPoolExecutor b2 = ConcurrencyHelpers.b("emojiCompat");
                        this.f3114g = b2;
                        this.f3113f = b2;
                    }
                    this.f3113f.execute(new c(this));
                }
            }
        }

        public void g(Executor executor) {
            synchronized (this.f3111d) {
                this.f3113f = executor;
            }
        }
    }

    public static abstract class RetryPolicy {
        public abstract long a();
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, f3107j));
    }

    public FontRequestEmojiCompatConfig c(Executor executor) {
        ((FontRequestMetadataLoader) a()).g(executor);
        return this;
    }
}
