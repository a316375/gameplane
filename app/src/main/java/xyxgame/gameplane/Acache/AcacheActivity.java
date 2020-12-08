package xyxgame.gameplane.Acache;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.LruCache;

import androidx.annotation.Nullable;

import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;

import xyxgame.gameplane.Base.BitmapUtils;
import xyxgame.gameplane.Base.NUMManager;
import xyxgame.gameplane.GL.GLActivity;
import xyxgame.gameplane.R;

import static android.os.Environment.isExternalStorageRemovable;

public class AcacheActivity extends GLActivity {
    AcacheSurfaceView acacheSurfaceView;

     LruCache<String, Bitmap> memoryCache;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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
    acacheSurfaceView=new AcacheSurfaceView(this,new NUMManager(point.x,point.y),this);
    setContentView(acacheSurfaceView);
}





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
