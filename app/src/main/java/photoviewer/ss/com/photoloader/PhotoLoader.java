package photoviewer.ss.com.photoloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by sujan on 11/20/2016.
 */

public interface PhotoLoader {
    public void loadPhoto(ImageView imageView, int index);
    public int getPhotoCount();
}
