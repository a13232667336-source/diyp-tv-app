package com.diyp.tvbox.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.diyp.tvbox.R;
import com.diyp.tvbox.bean.VodInfo;
import com.diyp.tvbox.cache.RoomDataManger;
import com.diyp.tvbox.cache.VodCollect;
import com.diyp.tvbox.ui.activity.CollectActivity;
import com.diyp.tvbox.ui.activity.HistoryActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ConfirmClearDialog extends BaseDialog {
    private final TextView tvYes;
    private final TextView tvNo;

    public ConfirmClearDialog(@NonNull @NotNull Context context, String type) {
        super(context);
        setContentView(R.layout.dialog_confirm);
        setCanceledOnTouchOutside(true);
        tvYes = findViewById(R.id.btnConfirm);
        tvNo = findViewById(R.id.btnCancel);

        tvYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if removing all Favorites
                if (type == "Collect") {
                    List<VodCollect> vodInfoList = new ArrayList<>();
                    CollectActivity.collectAdapter.setNewData(vodInfoList);
                    CollectActivity.collectAdapter.notifyDataSetChanged();
                    RoomDataManger.deleteVodCollectAll();
                    // if removing all History
                } else if (type == "History") {
                    List<VodInfo> vodInfoList = new ArrayList<>();
                    HistoryActivity.historyAdapter.setNewData(vodInfoList);
                    HistoryActivity.historyAdapter.notifyDataSetChanged();
                    RoomDataManger.deleteVodRecordAll();
                }

                ConfirmClearDialog.this.dismiss();
            }
        });
        tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmClearDialog.this.dismiss();
            }
        });
    }

}