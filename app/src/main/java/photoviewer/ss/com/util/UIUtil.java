package photoviewer.ss.com.util;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

/**
 * Created by sujan on 11/20/2016.
 */

public class UIUtil {
    public static void showSnackBar(CoordinatorLayout layout, String message){
        Snackbar snackbar = Snackbar
                .make(layout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
