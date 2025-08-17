package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
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
    private final DataSource f6283a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6284b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f6285c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f6286d;

    public Aes128DataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.f6283a = dataSource;
        this.f6284b = bArr;
        this.f6285c = bArr2;
    }

    public final Uri b() {
        return this.f6283a.b();
    }

    public void close() throws IOException {
        if (this.f6286d != null) {
            this.f6286d = null;
            this.f6283a.close();
        }
    }

    public final Map<String, List<String>> d() {
        return this.f6283a.d();
    }

    public final long i(DataSpec dataSpec) throws IOException {
        try {
            Cipher o2 = o();
            try {
                o2.init(2, new SecretKeySpec(this.f6284b, "AES"), new IvParameterSpec(this.f6285c));
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f6283a, dataSpec);
                this.f6286d = new CipherInputStream(dataSourceInputStream, o2);
                dataSourceInputStream.f();
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        this.f6283a.n(transferListener);
    }

    /* access modifiers changed from: protected */
    public Cipher o() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        Assertions.f(this.f6286d);
        int read = this.f6286d.read(bArr, i2, i3);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
