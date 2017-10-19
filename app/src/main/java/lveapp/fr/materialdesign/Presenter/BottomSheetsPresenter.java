package lveapp.fr.materialdesign.Presenter;

import android.support.design.widget.BottomSheetBehavior;
import android.view.View;

import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.BottomSheetsView;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class BottomSheetsPresenter {
    private BottomSheetsView.IBottomSheets iBottomSheets;

    public BottomSheetsPresenter(BottomSheetsView.IBottomSheets iBottomSheets) {
        this.iBottomSheets = iBottomSheets;
    }

    public void loadData(){
        iBottomSheets.initialize();
        iBottomSheets.events();
    }

    public void retrieveUserAction(View view, BottomSheetBehavior behavior){
        switch (view.getId()){
            case R.id.btnShowSheets:
            case R.id.btnHideSheets:
                if(behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else{
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                break;
        }
    }
}
