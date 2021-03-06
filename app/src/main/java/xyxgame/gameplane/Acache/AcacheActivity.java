package xyxgame.gameplane.Acache;

import android.graphics.Bitmap;
import android.util.LruCache;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.BitmapUtils;
import xyxgame.gameplane.R;

import static android.os.Environment.isExternalStorageRemovable;

public class AcacheActivity extends BaseActivity {
    AcacheSurfaceView acacheSurfaceView;

     LruCache<String, Bitmap> memoryCache;


    @Override
    protected BaseSurfaceVIEW setView() {

        // Get max available VM memory, exceeding this amount will throw an
        // OutOfMemory exception. Stored in kilobytes as LruCache takes an
        // int in its constructor.
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        memoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };





        try {
            addBitmapToMemoryCache("bg1", BitmapUtils.decodeSampledBitmapFromResource(getResources(),R.drawable.bg1,200,800));
            addBitmapToMemoryCache("bg2", BitmapUtils.decodeSampledBitmapFromResource(getResources(),R.drawable.bg2,200,800));
            addBitmapToMemoryCache("bg3", BitmapUtils.decodeSampledBitmapFromResource(getResources(),R.drawable.bg3,200,800));
            addBitmapToMemoryCache("bg4", BitmapUtils.decodeSampledBitmapFromResource(getResources(),R.drawable.bg4,200,800));

        }finally {
            acacheSurfaceView=new AcacheSurfaceView(this,AcacheActivity.this);

        }

        return acacheSurfaceView;
    }

    @Override
    public void viewResume() {

    }

    @Override
    public void viewPause() {

    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            memoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return memoryCache.get(key);
    }


}
