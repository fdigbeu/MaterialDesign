package lveapp.fr.materialdesign.Presenter;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class CommonPresenter {
    public static boolean emailValidator(String email){
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void closeMenuDrawer(DrawerLayout drawer){
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    public static void openMenuDrawer(DrawerLayout drawer){
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }
}
