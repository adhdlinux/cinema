package us.shandian.giga.get;

import android.support.v4.media.session.PlaybackStateCompat;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadRunnable implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final DownloadMission f42218b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42219c;

    public DownloadRunnable(DownloadMission downloadMission, int i2) {
        if (downloadMission != null) {
            this.f42218b = downloadMission;
            this.f42219c = i2;
            return;
        }
        throw new NullPointerException("mission is null");
    }

    private void a(int i2) {
        synchronized (this.f42218b) {
            this.f42218b.l(i2);
            this.f42218b.p();
        }
    }

    private void b() {
        synchronized (this.f42218b) {
            this.f42218b.m();
        }
    }

    private void c(long j2) {
        synchronized (this.f42218b) {
            this.f42218b.n(j2);
        }
    }

    public void run() {
        DownloadMission downloadMission = this.f42218b;
        boolean z2 = downloadMission.f42207s;
        long j2 = downloadMission.j(this.f42219c);
        while (true) {
            DownloadMission downloadMission2 = this.f42218b;
            int i2 = -1;
            if (downloadMission2.f42205q != -1 || !downloadMission2.f42202n || j2 >= downloadMission2.f42193e) {
                break;
            } else if (Thread.currentThread().isInterrupted()) {
                this.f42218b.p();
                return;
            } else {
                while (!z2) {
                    DownloadMission downloadMission3 = this.f42218b;
                    if (j2 >= downloadMission3.f42193e || !downloadMission3.k(j2)) {
                        break;
                    }
                    j2++;
                }
                DownloadMission downloadMission4 = this.f42218b;
                if (j2 >= downloadMission4.f42193e) {
                    break;
                }
                downloadMission4.q(j2);
                this.f42218b.s(this.f42219c, j2);
                long j3 = j2 * PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                long j4 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED + j3) - 1;
                long j5 = this.f42218b.f42194f;
                if (j4 >= j5) {
                    j4 = j5 - 1;
                }
                int i3 = 0;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f42218b.f42191c).openConnection();
                    httpURLConnection.setRequestProperty("Range", "bytes=" + j3 + "-" + j4);
                    if (httpURLConnection.getResponseCode() != 206) {
                        this.f42218b.f42205q = Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE;
                        a(Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE);
                        break;
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.f42218b.f42192d + "/" + this.f42218b.f42190b, "rw");
                    randomAccessFile.seek(j3);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    byte[] bArr = new byte[65536];
                    int i4 = 0;
                    while (true) {
                        if (j3 >= j4) {
                            break;
                        }
                        try {
                            if (!this.f42218b.f42202n) {
                                break;
                            }
                            int read = inputStream.read(bArr, 0, 65536);
                            if (read == i2) {
                                break;
                            }
                            long j6 = (long) read;
                            j3 += j6;
                            i4 += read;
                            randomAccessFile.write(bArr, 0, read);
                            c(j6);
                            inputStream = inputStream;
                            i2 = -1;
                        } catch (Exception unused) {
                            i3 = i4;
                            c((long) (-i3));
                            z2 = true;
                        }
                    }
                    randomAccessFile.close();
                    inputStream.close();
                    z2 = false;
                } catch (Exception unused2) {
                    c((long) (-i3));
                    z2 = true;
                }
            }
        }
        DownloadMission downloadMission5 = this.f42218b;
        if (downloadMission5.f42205q == -1 && downloadMission5.f42202n) {
            b();
        }
    }
}
