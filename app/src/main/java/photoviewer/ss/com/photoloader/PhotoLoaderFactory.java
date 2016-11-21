package photoviewer.ss.com.photoloader;

import android.content.Context;

/**
 * Created by sujan on 11/20/2016.
 */

public class PhotoLoaderFactory {
    public static PhotoLoader getPhotoLoader(Context ctx){
        return new LocalPhotoLoader(ctx);
    }
}
