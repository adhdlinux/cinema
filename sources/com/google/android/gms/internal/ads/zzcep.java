package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzcep extends zzfy implements zzhb {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzha zzf = new zzha();
    private zzgj zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzcep(String str, zzhg zzhg, int i2, int i3, long j2, long j3) {
        super(true);
        zzdy.zzc(str);
        this.zze = str;
        this.zzc = i2;
        this.zzd = i3;
        this.zzi = new ArrayDeque();
        this.zzr = j2;
        this.zzs = j3;
        if (zzhg != null) {
            zzf(zzhg);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e2) {
                zzbzr.zzh("Unexpected error while disconnecting", e2);
            }
        }
        this.zzh = null;
    }

    public final int zza(byte[] bArr, int i2, int i3) throws zzgx {
        int i4 = i3;
        if (i4 == 0) {
            return 0;
        }
        try {
            long j2 = this.zzm;
            long j3 = this.zzn;
            if (j2 - j3 == 0) {
                return -1;
            }
            long j4 = this.zzo + j3;
            long j5 = (long) i4;
            long j6 = this.zzs;
            long j7 = this.zzq;
            long j8 = j7 + 1;
            if (j4 + j5 + j6 > j8) {
                long j9 = this.zzp;
                if (j7 < j9) {
                    long min = Math.min(j9, Math.max(((this.zzr + j8) - j6) - 1, -1 + j8 + j5));
                    long j10 = j8;
                    long j11 = min;
                    zzk(j10, min, 2);
                    this.zzq = j11;
                    j7 = j11;
                }
            }
            int read = this.zzj.read(bArr, i2, (int) Math.min(j5, ((j7 + 1) - this.zzo) - this.zzn));
            if (read != -1) {
                this.zzn += (long) read;
                zzg(read);
                return read;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new zzgx(e2, this.zzg, 2000, 2);
        }
    }

    public final long zzb(zzgj zzgj) throws zzgx {
        long j2;
        this.zzg = zzgj;
        this.zzn = 0;
        long j3 = zzgj.zzf;
        long j4 = zzgj.zzg;
        if (j4 == -1) {
            j2 = this.zzr;
        } else {
            j2 = Math.min(this.zzr, j4);
        }
        this.zzo = j3;
        HttpURLConnection zzk2 = zzk(j3, (j2 + j3) - 1, 1);
        this.zzh = zzk2;
        String headerField = zzk2.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    matcher.group(1);
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j5 = zzgj.zzg;
                    if (j5 != -1) {
                        this.zzm = j5;
                        this.zzp = Math.max(parseLong, (this.zzo + j5) - 1);
                    } else {
                        this.zzm = parseLong2 - this.zzo;
                        this.zzp = parseLong2 - 1;
                    }
                    this.zzq = parseLong;
                    this.zzk = true;
                    zzj(zzgj);
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zzbzr.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcen(headerField, zzgj);
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzgx {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        } catch (IOException e2) {
            throw new zzgx(e2, this.zzg, 2000, 3);
        } catch (Throwable th) {
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final HttpURLConnection zzk(long j2, long j3, int i2) throws zzgx {
        String uri = this.zzg.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-" + j3);
            httpURLConnection.setRequestProperty("User-Agent", this.zze);
            httpURLConnection.setRequestProperty("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzi.add(httpURLConnection);
            String uri2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzceo(this.zzl, headerFields, this.zzg, i2);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzj != null) {
                        inputStream = new SequenceInputStream(this.zzj, inputStream);
                    }
                    this.zzj = inputStream;
                    return httpURLConnection;
                } catch (IOException e2) {
                    zzl();
                    throw new zzgx(e2, this.zzg, 2000, i2);
                }
            } catch (IOException e3) {
                zzl();
                String valueOf = String.valueOf(uri2);
                zzgj zzgj = this.zzg;
                throw new zzgx("Unable to connect to ".concat(valueOf), e3, zzgj, 2000, i2);
            }
        } catch (IOException e4) {
            IOException iOException = e4;
            String valueOf2 = String.valueOf(uri);
            throw new zzgx("Unable to connect to ".concat(valueOf2), iOException, this.zzg, 2000, i2);
        }
    }
}
