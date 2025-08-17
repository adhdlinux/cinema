package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
@TargetApi(19)
@DoNotStrip
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    private final FlexByteArrayPool mFlexByteArrayPool;

    @DoNotStrip
    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.mFlexByteArrayPool = flexByteArrayPool;
    }

    private static void putEOI(byte[] bArr, int i2) {
        bArr[i2] = -1;
        bArr[i2 + 1] = -39;
    }

    /* access modifiers changed from: protected */
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBuffer = closeableReference.get();
        int size = pooledByteBuffer.size();
        CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(size);
        try {
            byte[] bArr = closeableReference2.get();
            pooledByteBuffer.read(0, bArr, 0, size);
            return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, BitmapFactory.Options options) {
        byte[] bArr;
        boolean z2;
        if (DalvikPurgeableDecoder.endsWithEOI(closeableReference, i2)) {
            bArr = null;
        } else {
            bArr = DalvikPurgeableDecoder.EOI;
        }
        PooledByteBuffer pooledByteBuffer = closeableReference.get();
        if (i2 <= pooledByteBuffer.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        int i3 = i2 + 2;
        CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(i3);
        try {
            byte[] bArr2 = closeableReference2.get();
            pooledByteBuffer.read(0, bArr2, 0, i2);
            if (bArr != null) {
                putEOI(bArr2, i2);
                i2 = i3;
            }
            return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i2, options), "BitmapFactory returned null");
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
        }
    }
}
