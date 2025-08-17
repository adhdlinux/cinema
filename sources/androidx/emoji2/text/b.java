package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f3137b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f3138c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f3139d;

    public /* synthetic */ b(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f3137b = backgroundDefaultLoader;
        this.f3138c = metadataRepoLoaderCallback;
        this.f3139d = threadPoolExecutor;
    }

    public final void run() {
        this.f3137b.d(this.f3138c, this.f3139d);
    }
}
