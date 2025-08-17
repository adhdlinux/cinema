package com.nononsenseapps.filepicker;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.FileObserver;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.SortedList;
import androidx.recyclerview.widget.SortedListAdapterCallback;
import com.nononsenseapps.filepicker.AbstractFilePickerFragment;
import java.io.File;

public class FilePickerFragment extends AbstractFilePickerFragment<File> {

    /* renamed from: u  reason: collision with root package name */
    protected boolean f33727u = false;

    /* renamed from: v  reason: collision with root package name */
    private File f33728v = null;

    public void E(String str) {
        File file = new File((File) this.f33694e, str);
        if (file.mkdir()) {
            a0(file);
        } else {
            Toast.makeText(getActivity(), R$string.nnf_create_folder_error, 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public int f0(File file, File file2) {
        if (file.isDirectory() && !file2.isDirectory()) {
            return -1;
        }
        if (!file2.isDirectory() || file.isDirectory()) {
            return file.getName().compareToIgnoreCase(file2.getName());
        }
        return 1;
    }

    /* renamed from: g0 */
    public String f(File file) {
        return file.getPath();
    }

    /* renamed from: h0 */
    public String e(File file) {
        return file.getName();
    }

    /* renamed from: i0 */
    public File w(File file) {
        if (!file.getPath().equals(getRoot().getPath()) && file.getParentFile() != null) {
            return file.getParentFile();
        }
        return file;
    }

    public Loader<SortedList<File>> j() {
        return new AsyncTaskLoader<SortedList<File>>(getActivity()) {

            /* renamed from: a  reason: collision with root package name */
            FileObserver f33729a;

            /* renamed from: a */
            public SortedList<File> loadInBackground() {
                int i2;
                File[] listFiles = ((File) FilePickerFragment.this.f33694e).listFiles();
                if (listFiles == null) {
                    i2 = 0;
                } else {
                    i2 = listFiles.length;
                }
                SortedList<File> sortedList = new SortedList<>(File.class, new SortedListAdapterCallback<File>(FilePickerFragment.this.H()) {
                    /* renamed from: i */
                    public boolean e(File file, File file2) {
                        return file.getAbsolutePath().equals(file2.getAbsolutePath()) && file.isFile() == file2.isFile();
                    }

                    /* renamed from: j */
                    public boolean f(File file, File file2) {
                        return e(file, file2);
                    }

                    /* renamed from: k */
                    public int compare(File file, File file2) {
                        return FilePickerFragment.this.f0(file, file2);
                    }
                }, i2);
                sortedList.d();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (FilePickerFragment.this.o0(file)) {
                            sortedList.a(file);
                        }
                    }
                }
                sortedList.e();
                return sortedList;
            }

            /* access modifiers changed from: protected */
            public void onReset() {
                super.onReset();
                FileObserver fileObserver = this.f33729a;
                if (fileObserver != null) {
                    fileObserver.stopWatching();
                    this.f33729a = null;
                }
            }

            /* access modifiers changed from: protected */
            public void onStartLoading() {
                super.onStartLoading();
                T t2 = FilePickerFragment.this.f33694e;
                if (t2 == null || !((File) t2).isDirectory()) {
                    FilePickerFragment filePickerFragment = FilePickerFragment.this;
                    filePickerFragment.f33694e = filePickerFragment.getRoot();
                }
                AnonymousClass2 r02 = new FileObserver(((File) FilePickerFragment.this.f33694e).getPath(), 960) {
                    public void onEvent(int i2, String str) {
                        AnonymousClass1.this.onContentChanged();
                    }
                };
                this.f33729a = r02;
                r02.startWatching();
                forceLoad();
            }
        };
    }

    /* renamed from: j0 */
    public File v(String str) {
        return new File(str);
    }

    /* renamed from: k0 */
    public File getRoot() {
        return new File("/");
    }

    /* access modifiers changed from: protected */
    /* renamed from: l0 */
    public void M(File file) {
        this.f33728v = file;
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m0 */
    public boolean N(File file) {
        if (Build.VERSION.SDK_INT < 30 && ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: n0 */
    public boolean t(File file) {
        return file.isDirectory();
    }

    /* access modifiers changed from: protected */
    public boolean o0(File file) {
        if (this.f33727u || !file.isHidden()) {
            return super.Q(file);
        }
        return false;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (strArr.length == 0) {
            AbstractFilePickerFragment.OnFilePickedListener onFilePickedListener = this.f33699j;
            if (onFilePickedListener != null) {
                onFilePickedListener.k();
            }
        } else if (iArr[0] == 0) {
            File file = this.f33728v;
            if (file != null) {
                a0(file);
            }
        } else {
            Toast.makeText(getContext(), R$string.nnf_permission_external_write_denied, 0).show();
            AbstractFilePickerFragment.OnFilePickedListener onFilePickedListener2 = this.f33699j;
            if (onFilePickedListener2 != null) {
                onFilePickedListener2.k();
            }
        }
    }

    /* renamed from: p0 */
    public Uri d(File file) {
        Context context = getContext();
        return FileProvider.f(context, getContext().getApplicationContext().getPackageName() + ".provider", file);
    }
}
