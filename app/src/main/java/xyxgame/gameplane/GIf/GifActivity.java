package xyxgame.gameplane.GIf;

import xyxgame.gameplane.Base.BaseActivity;

public class GifActivity extends BaseActivity {

    GifGame gifGame;
    @Override
    protected void setView() {
        gifGame =new GifGame(GifActivity.this);
       setContentView(gifGame);
//       setContentView(R.layout.layout_wait);
//       GUI gui=new GUI(this);
//        RelativeLayout viewById = findViewById(R.id.rl);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
//        layoutParams.leftMargin=500;
//        gui.setLayoutParams(layoutParams);
//        viewById.addView(gui);

//
//        GifImageView imageView=findViewById(R.id.imageView);

//        Glide.with(this).asGif().load(R.drawable.gif_xue).into(imageView);

    }

    @Override
    protected void viewResume() {

        gifGame.startT();
    }

    @Override
    protected void viewPause() {

        gifGame.stopT();
    }
}
