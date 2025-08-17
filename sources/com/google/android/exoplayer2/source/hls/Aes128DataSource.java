package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Aes128DataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f26379a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f26380b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f26381c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f26382d;

    public Aes128DataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.f26379a = dataSource;
        this.f26380b = bArr;
        this.f26381c = bArr2;
    }

    public final Uri b() {
        return this.f26379a.b();
    }

    public void close() throws IOException {
        if (this.f26382d != null) {
            this.f26382d = null;
            this.f26379a.close();
        }
    }

    public final Map<String, List<String>> d() {
        return this.f26379a.d();
    }

    public final long i(DataSpec dataSpec) throws IOException {
        try {
            Cipher q2 = q();
            try {
                q2.init(2, new SecretKeySpec(this.f26380b, "AES"), new IvParameterSpec(this.f26381c));
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f26379a, dataSpec);
                this.f26382d = new CipherInputStream(dataSourceInputStream, q2);
                dataSourceInputStream.f();
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f26379a.p(transferListener);
    }

    /* access modifiers changed from: protected */
    public Cipher q() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        Assertions.e(this.f26382d);
        int read = this.f26382d.read(bArr, i2, i3);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
