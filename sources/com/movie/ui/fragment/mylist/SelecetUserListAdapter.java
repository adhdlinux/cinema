package com.movie.ui.fragment.mylist;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.database.entitys.UserListEntity;
import com.yoku.marumovie.R;
import java.util.List;

class SelecetUserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public List<UserListEntity> f33395n;

    public class UserViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        TextView f33398j;

        /* renamed from: k  reason: collision with root package name */
        CheckBox f33399k;

        /* renamed from: l  reason: collision with root package name */
        ImageButton f33400l;

        public UserViewHolder(View view) {
            super(view);
            this.f33398j = (TextView) view.findViewById(R.id.userNameTextView);
            this.f33399k = (CheckBox) view.findViewById(R.id.userEnableCheckBox);
            this.f33400l = (ImageButton) view.findViewById(R.id.deleteUserButton);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(UserListEntity userListEntity, int i2, View view) {
            h(userListEntity, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(int i2, DialogInterface dialogInterface, int i3) {
            SelecetUserListAdapter.this.f33395n.remove(i2);
            SelecetUserListAdapter.this.notifyDataSetChanged();
        }

        private void h(UserListEntity userListEntity, int i2) {
            AlertDialog.Builder title = new AlertDialog.Builder(this.itemView.getContext()).setTitle("Delete List");
            title.g("Are you sure you want to delete " + userListEntity.f19320b + "?").l("Yes", new u(this, i2)).i("No", (DialogInterface.OnClickListener) null).q();
        }

        public void d(UserListEntity userListEntity, int i2) {
            this.f33398j.setText(userListEntity.f19320b);
            this.f33399k.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            this.f33399k.setChecked(userListEntity.f19324f);
            this.f33399k.setOnCheckedChangeListener(new s(userListEntity));
            this.f33400l.setOnClickListener(new t(this, userListEntity, i2));
        }
    }

    public SelecetUserListAdapter(List<UserListEntity> list) {
        this.f33395n = list;
    }

    public List<UserListEntity> d() {
        return this.f33395n;
    }

    /* renamed from: e */
    public void onBindViewHolder(final UserViewHolder userViewHolder, int i2) {
        userViewHolder.d(this.f33395n.get(i2), i2);
        userViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckBox checkBox = userViewHolder.f33399k;
                checkBox.setChecked(!checkBox.isChecked());
            }
        });
    }

    /* renamed from: f */
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new UserViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_user, viewGroup, false));
    }

    public int getItemCount() {
        return this.f33395n.size();
    }
}
