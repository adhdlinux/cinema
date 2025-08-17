package us.shandian.giga.get;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import us.shandian.giga.get.DownloadMission;
import us.shandian.giga.util.Utility;

public class DownloadManagerImpl implements DownloadManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f42182c = "DownloadManagerImpl";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final DownloadDataSource f42183a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<DownloadMission> f42184b = new ArrayList<>();

    private class Initializer extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private DownloadMission f42186b;

        public Initializer(DownloadMission downloadMission) {
            this.f42186b = downloadMission;
        }

        public void run() {
            try {
                URL url = new URL(this.f42186b.f42191c);
                this.f42186b.f42194f = (long) ((HttpURLConnection) url.openConnection()).getContentLength();
                DownloadMission downloadMission = this.f42186b;
                if (downloadMission.f42194f <= 0) {
                    downloadMission.f42205q = Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE;
                    return;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Range", "bytes=" + (this.f42186b.f42194f - 10) + "-" + this.f42186b.f42194f);
                if (httpURLConnection.getResponseCode() != 206) {
                    this.f42186b.f42204p = true;
                }
                DownloadMission downloadMission2 = this.f42186b;
                long j2 = downloadMission2.f42194f;
                long j3 = j2 / PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                downloadMission2.f42193e = j3;
                if (((long) downloadMission2.f42198j) > j3) {
                    downloadMission2.f42198j = (int) j3;
                }
                if (downloadMission2.f42198j <= 0) {
                    downloadMission2.f42198j = 1;
                }
                if (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED * j3 < j2) {
                    downloadMission2.f42193e = j3 + 1;
                }
                new File(this.f42186b.f42192d).mkdirs();
                new File(this.f42186b.f42192d + "/" + this.f42186b.f42190b).createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f42186b.f42192d + "/" + this.f42186b.f42190b, "rw");
                randomAccessFile.setLength(this.f42186b.f42194f);
                randomAccessFile.close();
                this.f42186b.t();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class MissionListener implements DownloadMission.MissionListener {

        /* renamed from: b  reason: collision with root package name */
        private final DownloadMission f42188b;

        public void a(DownloadMission downloadMission) {
            DownloadManagerImpl.this.f42183a.b(this.f42188b);
        }

        public void b(DownloadMission downloadMission, int i2) {
        }

        public void c(DownloadMission downloadMission, long j2, long j3) {
        }

        private MissionListener(DownloadMission downloadMission) {
            if (downloadMission != null) {
                this.f42188b = downloadMission;
                return;
            }
            throw new NullPointerException("mission is null");
        }
    }

    public DownloadManagerImpl(Collection<String> collection, DownloadDataSource downloadDataSource) {
        this.f42183a = downloadDataSource;
        k(collection);
    }

    private static String g(String str, String str2) {
        String str3;
        if (str == null) {
            throw new NullPointerException("location is null");
        } else if (str2 != null) {
            File file = new File(str);
            if (file.isDirectory()) {
                final String[] n2 = n(str2);
                String[] list = file.list(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return str.startsWith(n2[0]);
                    }
                });
                Arrays.sort(list);
                int i2 = 0;
                do {
                    str3 = n2[0] + " (" + i2 + ")." + n2[1];
                    i2++;
                    if (i2 == 1000) {
                        throw new RuntimeException("Too many existing files");
                    }
                } while (Arrays.binarySearch(list, str3) >= 0);
                return str3;
            }
            throw new IllegalArgumentException("location is not a directory: " + str);
        } else {
            throw new NullPointerException("name is null");
        }
    }

    private DownloadMission h(String str, String str2) {
        Iterator<DownloadMission> it2 = this.f42184b.iterator();
        while (it2.hasNext()) {
            DownloadMission next = it2.next();
            if (str.equals(next.f42192d) && str2.equals(next.f42190b)) {
                return next;
            }
        }
        return null;
    }

    private int i(DownloadMission downloadMission) {
        int i2;
        if (this.f42184b.size() > 0) {
            i2 = -1;
            do {
                i2++;
                if (this.f42184b.get(i2).f42206r <= downloadMission.f42206r) {
                    break;
                }
            } while (i2 >= this.f42184b.size() - 1);
        } else {
            i2 = 0;
        }
        this.f42184b.add(i2, downloadMission);
        return i2;
    }

    private void j() {
        List<DownloadMission> c2 = this.f42183a.c();
        if (c2 == null) {
            c2 = new ArrayList<>();
        }
        m(c2);
        ArrayList<DownloadMission> arrayList = this.f42184b;
        arrayList.ensureCapacity(arrayList.size() + c2.size());
        for (DownloadMission downloadMission : c2) {
            File h2 = downloadMission.h();
            if (!h2.isFile()) {
                this.f42183a.a(downloadMission);
            } else {
                downloadMission.f42194f = h2.length();
                downloadMission.f42203o = true;
                downloadMission.f42202n = false;
                this.f42184b.add(downloadMission);
            }
        }
    }

    private void k(Iterable<String> iterable) {
        this.f42184b.clear();
        j();
        for (String l2 : iterable) {
            l(l2);
        }
    }

    private void l(String str) {
        DownloadMission downloadMission;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.e(f42182c, "listFiles() returned null");
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().endsWith(".giga") && (downloadMission = (DownloadMission) Utility.i(file2.getAbsolutePath())) != null) {
                    if (!downloadMission.f42203o) {
                        downloadMission.f42202n = false;
                        downloadMission.f42207s = true;
                        i(downloadMission);
                    } else if (!file2.delete()) {
                        Log.w(f42182c, "Unable to delete .giga file: " + file2.getPath());
                    }
                }
            }
        }
    }

    static void m(List<DownloadMission> list) {
        Collections.sort(list, new Comparator<DownloadMission>() {
            /* renamed from: a */
            public int compare(DownloadMission downloadMission, DownloadMission downloadMission2) {
                return Long.valueOf(downloadMission.f42206r).compareTo(Long.valueOf(downloadMission2.f42206r));
            }
        });
    }

    private static String[] n(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str.length() - 1) {
            return new String[]{str, ""};
        }
        return new String[]{str.substring(0, lastIndexOf), str.substring(lastIndexOf + 1)};
    }

    public void a(int i2) {
        DownloadMission e2 = e(i2);
        if (e2.f42202n) {
            e2.p();
        }
    }

    public void b(int i2) {
        DownloadMission e2 = e(i2);
        if (!e2.f42202n && e2.f42205q == -1) {
            e2.t();
        }
    }

    public void c(int i2) {
        DownloadMission e2 = e(i2);
        if (e2.f42203o) {
            this.f42183a.a(e2);
        }
        e2.e();
        this.f42184b.remove(i2);
    }

    public int d(String str, String str2, String str3, boolean z2, int i2, HashMap<String, String> hashMap, String str4) {
        DownloadMission h2 = h(str2, str3);
        if (h2 != null) {
            if (h2.f42203o) {
                c(this.f42184b.indexOf(h2));
            } else {
                try {
                    str3 = g(str2, str3);
                } catch (Exception e2) {
                    Log.e(f42182c, "Unable to generate unique name", e2);
                    str3 = System.currentTimeMillis() + str3;
                    Log.i(f42182c, "Using " + str3);
                }
            }
        }
        DownloadMission downloadMission = new DownloadMission(str3, str, str2, hashMap);
        downloadMission.f42206r = System.currentTimeMillis();
        downloadMission.f42198j = i2;
        downloadMission.f42196h = str4;
        downloadMission.c(new MissionListener(downloadMission));
        new Initializer(downloadMission).start();
        return i(downloadMission);
    }

    public DownloadMission e(int i2) {
        return this.f42184b.get(i2);
    }

    public int getCount() {
        return this.f42184b.size();
    }
}
