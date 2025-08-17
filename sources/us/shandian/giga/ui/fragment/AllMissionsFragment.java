package us.shandian.giga.ui.fragment;

import us.shandian.giga.get.DownloadManager;
import us.shandian.giga.service.DownloadManagerService;

public class AllMissionsFragment extends MissionsFragment {
    /* access modifiers changed from: protected */
    public DownloadManager L(DownloadManagerService.DMBinder dMBinder) {
        return dMBinder.a();
    }
}
