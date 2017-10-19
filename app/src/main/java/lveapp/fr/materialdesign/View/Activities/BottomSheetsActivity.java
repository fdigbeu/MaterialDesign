package lveapp.fr.materialdesign.View.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import lveapp.fr.materialdesign.Presenter.BottomSheetsPresenter;
import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.BottomSheetsView;

public class BottomSheetsActivity extends AppCompatActivity implements BottomSheetsView.IBottomSheets {

    private BottomSheetsPresenter sheetsPresenter;
    private Button btnShowSheets, btnHideSheets;
    private View layoutBottomSheets;
    private BottomSheetBehavior behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheets);
        //--
        sheetsPresenter = new BottomSheetsPresenter(this);
        sheetsPresenter.loadData();
    }

    @Override
    public void initialize() {
        btnShowSheets = (Button)findViewById(R.id.btnShowSheets);
        btnHideSheets = (Button)findViewById(R.id.btnHideSheets);
        layoutBottomSheets = findViewById(R.id.layoutBottomSheets);
        behavior = BottomSheetBehavior.from(layoutBottomSheets);
    }

    @Override
    public void events() {
        btnShowSheets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetsPresenter.retrieveUserAction(view, behavior);
            }
        });
        //--
        btnHideSheets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetsPresenter.retrieveUserAction(view, behavior);
            }
        });
        //--
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.i("BOTTOM_SHEET_CALL_BACK", "BottomSheetBehavior.STATE_DRAGGING");
                        break;

                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.i("BOTTOM_SHEET_CALL_BACK", "BottomSheetBehavior.STATE_SETTLING");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.i("BOTTOM_SHEET_CALL_BACK", "BottomSheetBehavior.STATE_EXPANDED");
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.i("BOTTOM_SHEET_CALL_BACK", "BottomSheetBehavior.STATE_COLLAPSED");
                        break;

                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.i("BOTTOM_SHEET_CALL_BACK", "BottomSheetBehavior.STATE_HIDDEN");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.i("BOTTOM_SHEET_CALL_BACK", "slideOffset : "+slideOffset);
            }
        });
    }
}
