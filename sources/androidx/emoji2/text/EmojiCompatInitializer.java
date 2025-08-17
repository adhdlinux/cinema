package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.a;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements Initializer<Boolean> {

    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            b(1);
        }
    }

    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f3081a;

        BackgroundDefaultLoader(Context context) {
            this.f3081a = context.getApplicationContext();
        }

        public void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor b2 = ConcurrencyHelpers.b("EmojiCompatInitializer");
            b2.execute(new b(this, metadataRepoLoaderCallback, b2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void d(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, final ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig a2 = DefaultEmojiCompatConfig.a(this.f3081a);
                if (a2 != null) {
                    a2.c(threadPoolExecutor);
                    a2.a().a(new EmojiCompat.MetadataRepoLoaderCallback() {
                        public void a(Throwable th) {
                            try {
                                metadataRepoLoaderCallback.a(th);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }

                        public void b(MetadataRepo metadataRepo) {
                            try {
                                metadataRepoLoaderCallback.b(metadataRepo);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }
                    });
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th) {
                metadataRepoLoaderCallback.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        public void run() {
            try {
                TraceCompat.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.h()) {
                    EmojiCompat.b().k();
                }
            } finally {
                TraceCompat.b();
            }
        }
    }

    /* renamed from: a */
    public Boolean create(Context context) {
        EmojiCompat.g(new BackgroundDefaultConfig(context));
        b(context);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new DefaultLifecycleObserver() {
            public /* synthetic */ void a(LifecycleOwner lifecycleOwner) {
                a.a(this, lifecycleOwner);
            }

            public void b(LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.c();
                lifecycle.c(this);
            }

            public /* synthetic */ void c(LifecycleOwner lifecycleOwner) {
                a.c(this, lifecycleOwner);
            }

            public /* synthetic */ void d(LifecycleOwner lifecycleOwner) {
                a.e(this, lifecycleOwner);
            }

            public /* synthetic */ void e(LifecycleOwner lifecycleOwner) {
                a.b(this, lifecycleOwner);
            }

            public /* synthetic */ void f(LifecycleOwner lifecycleOwner) {
                a.d(this, lifecycleOwner);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void c() {
        ConcurrencyHelpers.d().postDelayed(new LoadEmojiCompatRunnable(), 500);
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
