package jp.suntech.c22007.bmicalculatorc007;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public  class OrderConfirmDialogFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(@NonNull Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("警告");
        builder.setMessage("適切な肥満度を求めるためには、6歳未満の場合はカウブ指数が、6歳から15歳まではローレル指数が使われます。本アプリはBMIのみに対応しています。");
        builder.setPositiveButton("確認",new DialogButtonClickListener());
            /*builder.setTitle(R.string.bt_confirm);
            builder.setMessage(R.string.tv_title+R.string.tv_name+R.string.tv_mail+R.string.tv_comment);*/
        AlertDialog dialog = builder.create();
        return dialog;
    }
    private  class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which){
            int view;
            String msg="";
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg = "OK";
                    break;
            }
        }
    }
}
