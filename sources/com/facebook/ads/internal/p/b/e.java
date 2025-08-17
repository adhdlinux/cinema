package com.facebook.ads.internal.p.b;

import android.text.TextUtils;
import com.facebook.ads.internal.p.b.a.b;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class e extends k {

    /* renamed from: a  reason: collision with root package name */
    private final h f20494a;

    /* renamed from: b  reason: collision with root package name */
    private final b f20495b;

    /* renamed from: c  reason: collision with root package name */
    private b f20496c;

    public e(h hVar, b bVar) {
        super(hVar, bVar);
        this.f20495b = bVar;
        this.f20494a = hVar;
    }

    private void a(OutputStream outputStream, long j2) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j2, 8192);
            if (a2 != -1) {
                outputStream.write(bArr, 0, a2);
                j2 += (long) a2;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private boolean a(d dVar) {
        int a2 = this.f20494a.a();
        return !(a2 > 0) || !dVar.f20493c || ((float) dVar.f20492b) <= ((float) this.f20495b.a()) + (((float) a2) * 0.2f);
    }

    private String b(d dVar) {
        String c2 = this.f20494a.c();
        boolean z2 = !TextUtils.isEmpty(c2);
        int a2 = this.f20495b.d() ? this.f20495b.a() : this.f20494a.a();
        boolean z3 = a2 >= 0;
        boolean z4 = dVar.f20493c;
        long j2 = (long) a2;
        if (z4) {
            j2 -= dVar.f20492b;
        }
        boolean z5 = z3 && z4;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f20493c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        String str = "";
        sb.append(z3 ? String.format("Content-Length: %d\n", new Object[]{Long.valueOf(j2)}) : str);
        sb.append(z5 ? String.format("Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(dVar.f20492b), Integer.valueOf(a2 - 1), Integer.valueOf(a2)}) : str);
        if (z2) {
            str = String.format("Content-Type: %s\n", new Object[]{c2});
        }
        sb.append(str);
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j2) {
        try {
            h hVar = new h(this.f20494a);
            hVar.a((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = hVar.a(bArr);
                if (a2 != -1) {
                    outputStream.write(bArr, 0, a2);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            this.f20494a.b();
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        b bVar = this.f20496c;
        if (bVar != null) {
            bVar.a(this.f20495b.f20479a, this.f20494a.f20523a, i2);
        }
    }

    public void a(b bVar) {
        this.f20496c = bVar;
    }

    public void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j2 = dVar.f20492b;
        if (a(dVar)) {
            a((OutputStream) bufferedOutputStream, j2);
        } else {
            b(bufferedOutputStream, j2);
        }
    }
}
