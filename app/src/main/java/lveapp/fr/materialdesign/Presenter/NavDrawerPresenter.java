package lveapp.fr.materialdesign.Presenter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.NavDrawerView;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class NavDrawerPresenter {
    private NavDrawerView.INavDrawer iNavDrawer;

    public NavDrawerPresenter(NavDrawerView.INavDrawer iNavDrawer) {
        this.iNavDrawer = iNavDrawer;
    }

    public void loadData(){
        iNavDrawer.initialize();
        iNavDrawer.events();
    }

    /**
     * When Floatin Button is selected
     * @param view
     */
    public void retrieveUserAction(View view){
        int id = view.getId();
        switch (id){
            case R.id.fab:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
        }
    }

    /**
     * When menu more item or menu drawer item is selected
     * @param item
     * @param drawer
     */
    public void retrieveUserAction(MenuItem item, DrawerLayout drawer){
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                break;

            case R.id.nav_camera:
                break;

            case R.id.nav_gallery:
                break;

            case R.id.nav_slideshow:
                break;

            case R.id.nav_manage:
                break;

            case R.id.nav_share:
                break;

            case R.id.nav_send:
                break;
        }
        //--
        CommonPresenter.closeMenuDrawer(drawer);
    }

    public void drawerOnBackPress(DrawerLayout drawer, Context context){
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            ((Activity)context).finish();
        }
    }
}
