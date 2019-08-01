package com.chai.colin.CustomerService;

import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chai.colin.R;
import com.chai.colin.util.AppUtil;

import java.util.List;

public class VxAdapter extends BaseQuickAdapter<QQKefu, BaseViewHolder> {
    //    CircleImageView circleImageView;
    ImageView circleImageView;

    public VxAdapter(int layoutResId, @Nullable List<QQKefu> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QQKefu item) {

        circleImageView = helper.getView(R.id.home_read_piv_iv);
        Glide.with(mContext).load(item.getQqTempUrl()).transform(new CircleCrop()).into(circleImageView);
        helper.setText(R.id.tv_account, item.getQq());
        helper.setText(R.id.tv_vx, new StringBuilder("微信客服").append(helper.getAdapterPosition() + 1));
        helper.setText(R.id.tv_name, item.getQqName());
        ImageButton ib = helper.getView(R.id.btn_vx_kefu);
        ib.setOnClickListener(view -> {
//            AppUtil.getWechatApi(mContext);
            AppUtil.startAPP(mContext,"com.tencent.mm");
        });
    }
}
