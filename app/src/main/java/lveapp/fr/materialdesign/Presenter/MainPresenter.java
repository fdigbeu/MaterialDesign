package lveapp.fr.materialdesign.Presenter;

import android.view.View;

import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Activities.BottomNavActivity;
import lveapp.fr.materialdesign.View.Activities.BottomSheetsActivity;
import lveapp.fr.materialdesign.View.Activities.LoginActivity;
import lveapp.fr.materialdesign.View.Activities.NavDrawerActivity;
import lveapp.fr.materialdesign.View.Interfaces.MainView;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class MainPresenter {

    private MainView.IMain iMain;

    public MainPresenter(MainView.IMain iMain) {
        this.iMain = iMain;
    }

    public void loadData(){
        iMain.initialize();
        iMain.events();
    }

    public void retrieveUserAction(View view){
        switch (view.getId()){
            case R.id.formLoginPassword:
                iMain.launch(LoginActivity.class);
                break;

            case R.id.bottomSheets:
                iMain.launch(BottomSheetsActivity.class);
                break;

            case R.id.navigationDrawer:
                iMain.launch(NavDrawerActivity.class);
                break;

            case R.id.bottomNavigation:
                iMain.launch(BottomNavActivity.class);
                break;
        }
    }
}
