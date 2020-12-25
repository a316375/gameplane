package xyxgame.gameplane.GIf;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;

public class GifActivity extends BaseActivity {

    GifView gifView;
    @Override
    protected BaseSurfaceVIEW setView() {
        gifView =new GifView(GifActivity.this);

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

        return gifView;
    }

    @Override
    protected void viewResume() {

        gifView.startT();
    }

    @Override
    protected void viewPause() {

        gifView.stopT();
    }
}
