package lveapp.fr.materialdesign.Presenter;

import android.content.Context;
import android.view.MenuItem;

import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.BottomNavView;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class BottomNavPresenter {
    private BottomNavView.IBottomNav iBottomNav;

    public BottomNavPresenter(BottomNavView.IBottomNav iBottomNav) {
        this.iBottomNav = iBottomNav;
    }

    public void loadData(){
        iBottomNav.initialize();
        iBottomNav.events();
    }

    public void retrieveUserAction(MenuItem item, Context context){
        switch (item.getItemId()){
            case R.id.action_item_1:
                iBottomNav.displayContent(context.getResources().getString(R.string.contentNav_1));
                break;

            case R.id.action_item_2:
                iBottomNav.displayContent(context.getResources().getString(R.string.contentNav_2));
                break;

            case R.id.action_item_3:
                iBottomNav.displayContent(context.getResources().getString(R.string.contentNav_3));
                break;
        }
    }
}
