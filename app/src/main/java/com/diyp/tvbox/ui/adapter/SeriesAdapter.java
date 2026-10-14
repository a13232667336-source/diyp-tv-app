package com.diyp.tvbox.ui.adapter;

import android.graphics.Color;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.diyp.tvbox.R;
import com.diyp.tvbox.base.BaseActivity;
import com.diyp.tvbox.bean.VodInfo;

import java.util.ArrayList;

/**
 * @author pj567
 * @date :2020/12/22
 * @description:
 */
public class SeriesAdapter extends BaseQuickAdapter<VodInfo.VodSeries, BaseViewHolder> {
    public SeriesAdapter() {
        super(R.layout.item_series, new ArrayList<>());
    }

    @Override
    protected void convert(BaseViewHolder helper, VodInfo.VodSeries item) {
        TextView tvSeries = helper.getView(R.id.tvSeries);
        if (item.selected) {
            // takagen99: Added Theme Color
//            tvSeries.setTextColor(mContext.getResources().getColor(R.color.color_theme));
            tvSeries.setTextColor(((BaseActivity) mContext).getThemeColor());
        } else {
            tvSeries.setTextColor(Color.WHITE);
        }
        helper.setText(R.id.tvSeries, item.name);
    }
}