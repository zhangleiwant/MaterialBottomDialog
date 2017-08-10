package com.king.zlei.materialbottomdialogdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * <b>Create Date:</b> 2017/8/10<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> <br>
 */

public class MyBottomSheetFragment extends BottomSheetDialogFragment {

    private BottomSheetBehavior mBehavior;

    /**
     * 这里有一个坑，如果在这个方法里面创建一个dialog对象返回，
     * 然而在此fragment中oncreateview方法中加载布局，布局并不能完全展示的话，
     * 人为去改变peekheight就会出现一个问题，拿到的布局是空的，
     * 想要动手脚，须在oncreateDialog方法中实现
     * 其实使用BottomDialogFragment和BottomDialog是一样的道理，
     * BottomDialogFragment内部是使用的BottomDialog实现的
     * <p>
     * Modal bottom sheet. This is a version of {@link DialogFragment} that shows a bottom sheet
     * using {@link BottomSheetDialog} instead of a floating dialog.
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bottom_sheet_dialog_fragment, null);//默认词布局为CoordinatorLayout的子布局
        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());//
        return dialog;
    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//    }


}
