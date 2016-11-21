package photoviewer.ss.com.photoloader;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujan on 11/20/2016.
 */

public class LocalPhotoLoader implements PhotoLoader {

    private List<Integer> photoIdList;
    private Context ctx;

    public LocalPhotoLoader(Context ctx) {
        photoIdList = new ArrayList<Integer>();
        this.ctx = ctx;

        loadPhotos();
    }

    public void loadPhotos() {
        Cursor cursor = ctx.getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{}, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            photoIdList.add(cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media._ID)));
            cursor.moveToNext();

        }
        cursor.close();
    }

    @Override
    public void loadPhoto(ImageView imageView, int index){
        Bitmap bitmap = MediaStore.Images.Thumbnails.getThumbnail(
                ctx.getContentResolver(), photoIdList.get(index), MediaStore.Images.Thumbnails.MINI_KIND, null);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public int getPhotoCount() {
        return photoIdList.size();
    }
}
