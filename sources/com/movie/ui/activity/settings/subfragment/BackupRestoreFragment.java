package com.movie.ui.activity.settings.subfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.database.MvDatabase;
import com.movie.FreeMoviesApp;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.nononsenseapps.filepicker.FilePickerActivity;
import com.original.tase.utils.DeviceUtils;
import com.utils.DbUtils;
import com.utils.DisplayNameAndSize;
import com.utils.PermissionHelper;
import com.utils.UriUtils;
import com.utils.Utils;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import org.joda.time.DateTime;

public class BackupRestoreFragment extends BaseSettingFragment {
    public static String BK_PATH_FOLDER_KEY = "pref_backup_folder";
    public static String BK_PREFIX = "backup_";
    /* access modifiers changed from: private */
    public int REQUEST_CHOOSE_FILE_RESTORE_CODE = 344;
    /* access modifiers changed from: private */
    public int REQUEST_CODE_CREATE_DOCUMENT = 346;
    private int REQUEST_CODE_OPEN_DOCUMENT_TREE = 345;
    /* access modifiers changed from: private */
    public int REQUEST_LEGACY_CHOOSE_FILE_RESTORE_CODE = 343;
    /* access modifiers changed from: private */
    public int REQUEST_LEGACY_CHOOSE_FOLDER_BACKUP_CODE = 342;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doExport$10() throws Exception {
        Utils.i0(getActivity(), "Backup successful");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doExport$3(String str) throws Exception {
        Preference findPreference = findPreference("pref_backup2");
        getSharedPreference().edit().putString("pref_backup2", str).apply();
        findPreference.setSummary((CharSequence) str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doExport$4(Throwable th) throws Exception {
        FragmentActivity activity = getActivity();
        Utils.i0(activity, "Backup failed : " + th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doExport$5() throws Exception {
        Utils.i0(getActivity(), "Backup successful");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doExport$8(DisplayNameAndSize displayNameAndSize) throws Exception {
        Preference findPreference = findPreference("pref_backup2");
        getSharedPreference().edit().putString("pref_backup2", displayNameAndSize.f37231a).apply();
        findPreference.setSummary((CharSequence) displayNameAndSize.f37231a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doExport$9(Throwable th) throws Exception {
        FragmentActivity activity = getActivity();
        Utils.i0(activity, "Backup failed : " + th.getMessage());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$doImport$0(Void voidR) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doImport$1(Throwable th) throws Exception {
        FragmentActivity activity = getActivity();
        Utils.i0(activity, "Restore failed : " + th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doImport$2() throws Exception {
        Utils.i0(getActivity(), "Restore successful.");
        Utils.q0(getActivity());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$doImport$6(Void voidR) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doImport$7(Throwable th) throws Exception {
        FragmentActivity activity = getActivity();
        Utils.i0(activity, "Restore failed : " + th.getMessage());
    }

    private void registerActvityResultLauncher() {
    }

    /* access modifiers changed from: private */
    public void showRestoreSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Restore successful");
        builder.b(false);
        builder.g("Restart app to apply changes");
        builder.l("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                Utils.q0(BackupRestoreFragment.this.getActivity());
            }
        });
        builder.create().show();
    }

    public void doExport(final String str) {
        if (str != null) {
            this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<String>() {
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    MvDatabase.v(BackupRestoreFragment.this.getActivity(), str);
                    observableEmitter.onNext(str);
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new i(this), new j(this), new k(this)));
        }
    }

    public void doImport(final String str) {
        if (str != null) {
            this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<Void>() {
                public void subscribe(ObservableEmitter<Void> observableEmitter) throws Exception {
                    Context context = BackupRestoreFragment.this.getContext();
                    Objects.requireNonNull(context);
                    MvDatabase.C(context, str);
                    SharedPreferences p2 = FreeMoviesApp.p();
                    boolean z2 = p2.getBoolean("pref_show_changlog_v2" + Utils.c0(), false);
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putBoolean("pref_show_changlog_v2" + Utils.c0(), z2).apply();
                    BackupRestoreFragment.this.getSharedPreference().edit().putString(BackupRestoreFragment.BK_PATH_FOLDER_KEY, str);
                    BackupRestoreFragment.this.getSharedPreference().edit().apply();
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new f(), new g(this), new h(this)));
        }
    }

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.REQUEST_LEGACY_CHOOSE_FILE_RESTORE_CODE) {
            if (i3 == -1) {
                doImport(com.nononsenseapps.filepicker.Utils.b(intent.getData()).toString());
            } else {
                Utils.h0(getActivity(), R.string.no_file_selected);
            }
        }
        if (i2 == this.REQUEST_CHOOSE_FILE_RESTORE_CODE) {
            if (i3 == -1) {
                doImport(intent.getData());
            } else {
                Utils.h0(getActivity(), R.string.no_file_selected);
            }
        }
        if (i2 == this.REQUEST_LEGACY_CHOOSE_FOLDER_BACKUP_CODE) {
            if (i3 == -1) {
                String path = com.nononsenseapps.filepicker.Utils.b(intent.getData()).getPath();
                Utils.v0(path);
                doExport(path + "/" + String.format("%s%s", new Object[]{BK_PREFIX, DateTime.now().toString("yyyy_MM_dd")}));
            } else {
                Utils.h0(getActivity(), R.string.no_file_selected);
            }
        }
        if (i2 != this.REQUEST_CODE_CREATE_DOCUMENT) {
            return;
        }
        if (i3 == -1) {
            doExport(intent.getData());
        } else {
            Utils.h0(getActivity(), R.string.no_file_selected);
        }
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_backup_restore, str);
        if (DeviceUtils.c() && !PermissionHelper.a(getActivity())) {
            ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) new LovelyStandardDialog(getActivity(), LovelyStandardDialog.ButtonLayout.HORIZONTAL).m(R.color.darkDeepOrange)).r(R.color.darkDeepOrange).h(R.drawable.egg_empty)).k("Warning")).j(getActivity().getResources().getString(R.string.storage_permission_msg))).u(17039370, new View.OnClickListener() {
                public void onClick(View view) {
                    PermissionHelper.b(BackupRestoreFragment.this.getActivity(), 934834);
                }
            }).o();
        }
        Preference findPreference = findPreference("pref_restore2");
        Preference findPreference2 = findPreference("pref_backup2");
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                if (DeviceUtils.c()) {
                    Intent intent = new Intent(BackupRestoreFragment.this.getActivity(), FilePickerActivity.class);
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                    intent.putExtra("nononsense.intent.ALLOW_CREATE_DIR", true);
                    intent.putExtra("nononsense.intent.MODE", 0);
                    intent.putExtra("nononsense.intent.START_PATH", Utils.w());
                    BackupRestoreFragment backupRestoreFragment = BackupRestoreFragment.this;
                    backupRestoreFragment.startActivityForResult(intent, backupRestoreFragment.REQUEST_LEGACY_CHOOSE_FILE_RESTORE_CODE);
                } else {
                    Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent2.setType("*/*");
                    intent2.addCategory("android.intent.category.OPENABLE");
                    BackupRestoreFragment backupRestoreFragment2 = BackupRestoreFragment.this;
                    backupRestoreFragment2.startActivityForResult(intent2, backupRestoreFragment2.REQUEST_CHOOSE_FILE_RESTORE_CODE);
                }
                return true;
            }
        });
        findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                if (DeviceUtils.c()) {
                    Intent intent = new Intent(BackupRestoreFragment.this.getActivity(), FilePickerActivity.class);
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                    intent.putExtra("nononsense.intent.ALLOW_CREATE_DIR", true);
                    intent.putExtra("nononsense.intent.MODE", 1);
                    intent.putExtra("nononsense.intent.START_PATH", Utils.w());
                    BackupRestoreFragment backupRestoreFragment = BackupRestoreFragment.this;
                    backupRestoreFragment.startActivityForResult(intent, backupRestoreFragment.REQUEST_LEGACY_CHOOSE_FOLDER_BACKUP_CODE);
                } else {
                    Intent intent2 = new Intent("android.intent.action.CREATE_DOCUMENT");
                    intent2.setType("application/octet-stream");
                    intent2.putExtra("android.intent.extra.TITLE", String.format("%s%s", new Object[]{BackupRestoreFragment.BK_PREFIX, DateTime.now().toString("yyyy_MM_dd")}));
                    BackupRestoreFragment backupRestoreFragment2 = BackupRestoreFragment.this;
                    backupRestoreFragment2.startActivityForResult(intent2, backupRestoreFragment2.REQUEST_CODE_CREATE_DOCUMENT);
                }
                return true;
            }
        });
        findPreference2.setSummary((CharSequence) getSharedPreference().getString("pref_backup2", "No backup found"));
    }

    public void doExport(final Uri uri) {
        if (uri != null) {
            DbUtils.a(getContext(), uri);
            this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<DisplayNameAndSize>() {
                public void subscribe(ObservableEmitter<DisplayNameAndSize> observableEmitter) throws Exception {
                    MvDatabase.u(BackupRestoreFragment.this.getActivity(), uri);
                    observableEmitter.onNext(UriUtils.a(BackupRestoreFragment.this.getContext(), uri));
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new l(this), new b(this), new c(this)));
        }
    }

    public void doImport(final Uri uri) {
        if (uri != null) {
            this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<Void>() {
                public void subscribe(ObservableEmitter<Void> observableEmitter) throws Exception {
                    MvDatabase.B(BackupRestoreFragment.this.getContext(), uri);
                    SharedPreferences p2 = FreeMoviesApp.p();
                    boolean z2 = p2.getBoolean("pref_show_changlog_v2" + Utils.c0(), false);
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putBoolean("pref_show_changlog_v2" + Utils.c0(), z2).apply();
                    BackupRestoreFragment.this.getSharedPreference().edit().putString(BackupRestoreFragment.BK_PATH_FOLDER_KEY, uri.getPath());
                    BackupRestoreFragment.this.getSharedPreference().edit().apply();
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(), new d(this), new e(this)));
        }
    }
}
