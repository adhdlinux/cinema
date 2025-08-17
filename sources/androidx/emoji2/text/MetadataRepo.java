package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MetadataRepo {

    /* renamed from: a  reason: collision with root package name */
    private final MetadataList f3123a;

    /* renamed from: b  reason: collision with root package name */
    private final char[] f3124b;

    /* renamed from: c  reason: collision with root package name */
    private final Node f3125c = new Node(1024);

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f3126d;

    static class Node {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Node> f3127a;

        /* renamed from: b  reason: collision with root package name */
        private EmojiMetadata f3128b;

        private Node() {
            this(1);
        }

        /* access modifiers changed from: package-private */
        public Node a(int i2) {
            SparseArray<Node> sparseArray = this.f3127a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i2);
        }

        /* access modifiers changed from: package-private */
        public final EmojiMetadata b() {
            return this.f3128b;
        }

        /* access modifiers changed from: package-private */
        public void c(EmojiMetadata emojiMetadata, int i2, int i3) {
            Node a2 = a(emojiMetadata.b(i2));
            if (a2 == null) {
                a2 = new Node();
                this.f3127a.put(emojiMetadata.b(i2), a2);
            }
            if (i3 > i2) {
                a2.c(emojiMetadata, i2 + 1, i3);
            } else {
                a2.f3128b = emojiMetadata;
            }
        }

        Node(int i2) {
            this.f3127a = new SparseArray<>(i2);
        }
    }

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        this.f3126d = typeface;
        this.f3123a = metadataList;
        this.f3124b = new char[(metadataList.k() * 2)];
        a(metadataList);
    }

    private void a(MetadataList metadataList) {
        int k2 = metadataList.k();
        for (int i2 = 0; i2 < k2; i2++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i2);
            Character.toChars(emojiMetadata.f(), this.f3124b, i2 * 2);
            h(emojiMetadata);
        }
    }

    public static MetadataRepo b(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.a("EmojiCompat.MetadataRepo.create");
            return new MetadataRepo(typeface, MetadataListReader.b(byteBuffer));
        } finally {
            TraceCompat.b();
        }
    }

    public char[] c() {
        return this.f3124b;
    }

    public MetadataList d() {
        return this.f3123a;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f3123a.l();
    }

    /* access modifiers changed from: package-private */
    public Node f() {
        return this.f3125c;
    }

    /* access modifiers changed from: package-private */
    public Typeface g() {
        return this.f3126d;
    }

    /* access modifiers changed from: package-private */
    public void h(EmojiMetadata emojiMetadata) {
        boolean z2;
        Preconditions.h(emojiMetadata, "emoji metadata cannot be null");
        if (emojiMetadata.c() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.b(z2, "invalid metadata codepoint length");
        this.f3125c.c(emojiMetadata, 0, emojiMetadata.c() - 1);
    }
}
