package com.utils.download;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.Setting;
import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.FilenameUtils;
import com.utils.Utils;
import com.yoku.marumovie.R;
import us.shandian.giga.service.DownloadManagerService;

public class DownloadDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    protected MediaSource f37649b;

    /* renamed from: c  reason: collision with root package name */
    protected MovieInfo f37650c;

    /* renamed from: d  reason: collision with root package name */
    long f37651d;

    /* renamed from: e  reason: collision with root package name */
    private EditText f37652e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f37653f;

    /* renamed from: g  reason: collision with root package name */
    private SeekBar f37654g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f37655h;

    /* renamed from: i  reason: collision with root package name */
    private Button f37656i;

    /* access modifiers changed from: private */
    public void H() {
        String streamLink = this.f37649b.getStreamLink();
        String absolutePath = Setting.a(getContext()).getAbsolutePath();
        String trim = this.f37652e.getText().toString().trim();
        if (trim.isEmpty()) {
            trim = FilenameUtils.a(getContext(), this.f37649b.getMovieName());
        }
        DownloadManagerService.k(getContext(), streamLink, absolutePath, (trim + Utils.L(streamLink)).replace(" ", "_"), false, this.f37654g.getProgress() + 1, this.f37649b.getPlayHeader(), this.f37651d + "_" + this.f37650c.getYear() + "_" + this.f37650c.getSession() + "_" + this.f37650c.getEps() + "_" + this.f37650c.tmdbID + "_" + this.f37650c.imdbIDStr);
        getDialog().dismiss();
        startActivity(new Intent(getActivity(), DownloadActivity.class));
    }

    public static DownloadDialog I(MediaSource mediaSource, MovieInfo movieInfo, long j2) {
        DownloadDialog downloadDialog = new DownloadDialog();
        downloadDialog.J(mediaSource);
        downloadDialog.K(movieInfo, j2);
        return downloadDialog;
    }

    private void J(MediaSource mediaSource) {
        this.f37649b = mediaSource;
    }

    private void K(MovieInfo movieInfo, long j2) {
        this.f37650c = movieInfo;
        this.f37651d = j2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.findItem(R.id.okay);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.download_dialog, viewGroup);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(-2, -2);
        window.setGravity(17);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f37652e = (EditText) view.findViewById(R.id.file_name);
        String movieName = this.f37649b.getMovieName();
        String str = this.f37650c.session;
        if (str != null && !str.isEmpty()) {
            movieName = this.f37650c.getName() + " " + this.f37650c.session + "x" + this.f37650c.getEps() + " (" + this.f37650c.getYear() + ")";
        }
        this.f37652e.setText(FilenameUtils.a(getContext(), movieName));
        this.f37653f = (TextView) view.findViewById(R.id.threads_count);
        this.f37654g = (SeekBar) view.findViewById(R.id.threads);
        TextView textView = (TextView) view.findViewById(R.id.file_name_text_view);
        this.f37655h = textView;
        textView.setText(String.format(getContext().getString(R.string.msg_name), new Object[]{this.f37649b.getFileSizeString()}));
        Button button = (Button) view.findViewById(R.id.download_start);
        this.f37656i = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DownloadDialog.this.H();
            }
        });
        this.f37653f.setText(String.valueOf(3));
        this.f37654g.setProgress(2);
        this.f37654g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
                DownloadDialog.this.f37653f.setText(String.valueOf(i2 + 1));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
