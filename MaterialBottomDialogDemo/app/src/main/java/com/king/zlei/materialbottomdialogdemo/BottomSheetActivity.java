package com.king.zlei.materialbottomdialogdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * <b>Create Date:</b> 2017/8/4<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> bottomsheet<br>
 */
public class BottomSheetActivity extends AppCompatActivity {

    BottomSheetBehavior mBehavior;


    //按钮改变现实隐藏
    public void SheetClick(View view) {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomsheet);

        View bottomSheet = findViewById(R.id.bootom_sheet);
        mBehavior = BottomSheetBehavior.from(bottomSheet);
        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //bottomsheet状态改变

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //bottomsheet滑动拖拽改变slideoffest做动画

            }
        });
    }
}
