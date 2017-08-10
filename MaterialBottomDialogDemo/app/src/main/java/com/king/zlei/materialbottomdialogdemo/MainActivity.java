package com.king.zlei.materialbottomdialogdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Sheet(View view) {
        startActivity(new Intent(this, BottomSheetActivity.class));
    }

    //显示bottomsheetdialog
    public void SheetDialog(View view) {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View v = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
        dialog.setContentView(v);
        resetLp(v);
        dialog.show();
    }

    /**
     * 问题，bottomsheetdialog默认显示高度256dp,不完全显示，如果想要完全显示，处理的办法
     * 1.通过bottomsheetdialog中contentview得到parentView，通过parentview得到bottomsheetbehavior
     * 2.测量bottomsheetdialog布局中的content的高度，设置peekhight
     * 3.设置bottomsheetdialog的contentview对应的父布局coordinatorlayout的grivity为gravity top  gravity horizontal
     */
    public void resetLp(View v) {
        View parent = (View) v.getParent();
        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
        v.measure(0, 0);
        behavior.setPeekHeight(v.getMeasuredHeight());
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) parent.getLayoutParams();
        lp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        parent.setLayoutParams(lp);

    }

    public void SheetDialogFragment(View view) {
        new MyBottomSheetFragment().show(getSupportFragmentManager(),"");
    }
}
