package xyxgame.gameplane.schoolGif.Tool;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import xyxgame.gameplane.R;

public class UIAlertDialog {

    public static AlertDialog showDialogA( Context context){

//        AlertDialog.Builder alertDialog=new  AlertDialog.Builder(context);
//        //Uncomment the below code to Set the message and title from the strings.xml file
//        alertDialog.setMessage("连接中") .setTitle("请稍候");

//        //Setting message manually and performing action on button click
//        alertDialog.setMessage("Do you want to close this application ?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//
//
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //  Action for 'NO' Button
//                        dialog.cancel();
//
//                    }
//                });
        //Creating dialog box
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = View.inflate(context, R.layout.loading, null);
        ImageView iv_gif = dialogView.findViewById(R.id.iv_gif);
//        dialogView.findViewById(R.id.tv_loading).setVisibility(View.GONE);
        Glide.with(context).load(R.drawable.fb01).into(iv_gif);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.setCancelable(false);
         alertDialog.getWindow().setLayout(500,400);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return alertDialog;
    }









}
