package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;

public class EmojiMetadata {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<MetadataItem> f3085d = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final int f3086a;

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f3087b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f3088c = 0;

    EmojiMetadata(MetadataRepo metadataRepo, int i2) {
        this.f3087b = metadataRepo;
        this.f3086a = i2;
    }

    private MetadataItem g() {
        ThreadLocal<MetadataItem> threadLocal = f3085d;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.f3087b.d().j(metadataItem, this.f3086a);
        return metadataItem;
    }

    public void a(Canvas canvas, float f2, float f3, Paint paint) {
        Typeface g2 = this.f3087b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g2);
        Canvas canvas2 = canvas;
        canvas2.drawText(this.f3087b.c(), this.f3086a * 2, 2, f2, f3, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i2) {
        return g().h(i2);
    }

    public int c() {
        return g().i();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int d() {
        return this.f3088c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void k(boolean z2) {
        this.f3088c = z2 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int c2 = c();
        for (int i2 = 0; i2 < c2; i2++) {
            sb.append(Integer.toHexString(b(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
