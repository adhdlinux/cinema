package com.movie.ui.activity.payment.keyManager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.movie.data.model.cinema.KeyResponse;
import com.original.tase.helper.DateTimeHelper;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.List;

public class DevicesApdater extends RecyclerView.Adapter<DeviceHolder> {

    /* renamed from: n  reason: collision with root package name */
    List<KeyResponse.DevicesBean> f32319n;

    /* renamed from: o  reason: collision with root package name */
    Context f32320o = null;

    /* renamed from: p  reason: collision with root package name */
    DeviceItemListener f32321p;

    static class DeviceHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        TextView f32324j;

        /* renamed from: k  reason: collision with root package name */
        TextView f32325k;

        /* renamed from: l  reason: collision with root package name */
        TextView f32326l;

        /* renamed from: m  reason: collision with root package name */
        Button f32327m;

        public DeviceHolder(View view) {
            super(view);
            this.f32324j = (TextView) view.findViewById(R.id.deviceName);
            this.f32325k = (TextView) view.findViewById(R.id.deviceID);
            this.f32326l = (TextView) view.findViewById(R.id.startTime);
            this.f32327m = (Button) view.findViewById(R.id.deleteBtn);
        }
    }

    interface DeviceItemListener {
        void r(KeyResponse.DevicesBean devicesBean);
    }

    public List<KeyResponse.DevicesBean> c() {
        return this.f32319n;
    }

    /* renamed from: d */
    public void onBindViewHolder(DeviceHolder deviceHolder, int i2) {
        final KeyResponse.DevicesBean devicesBean = this.f32319n.get(i2);
        TextView textView = deviceHolder.f32325k;
        textView.setText("Device ID      : " + devicesBean.getId());
        String b2 = DateTimeHelper.b(devicesBean.getStartTime());
        TextView textView2 = deviceHolder.f32326l;
        textView2.setText("Start Time    : " + b2);
        if (devicesBean.getId().equals(Utils.t())) {
            deviceHolder.f32327m.setVisibility(8);
            TextView textView3 = deviceHolder.f32324j;
            textView3.setText("[" + devicesBean.getName() + "]");
            return;
        }
        deviceHolder.f32324j.setText(devicesBean.getName());
        deviceHolder.f32327m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DeviceItemListener deviceItemListener = DevicesApdater.this.f32321p;
                if (deviceItemListener != null) {
                    deviceItemListener.r(devicesBean);
                }
            }
        });
    }

    /* renamed from: e */
    public DeviceHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.device_item, viewGroup, false);
        this.f32320o = viewGroup.getContext();
        return new DeviceHolder(inflate);
    }

    public void f(DeviceItemListener deviceItemListener) {
        this.f32321p = deviceItemListener;
    }

    public void g(List<KeyResponse.DevicesBean> list) {
        this.f32319n = list;
    }

    public int getItemCount() {
        return this.f32319n.size();
    }
}
