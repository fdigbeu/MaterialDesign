package lveapp.fr.materialdesign.View.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import lveapp.fr.materialdesign.Presenter.BottomNavPresenter;
import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.BottomNavView;

public class BottomNavActivity extends AppCompatActivity implements BottomNavView.IBottomNav {

    private BottomNavPresenter bottomNavPresenter;
    private BottomNavigationView bottomNavigation;
    private TextView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        //--
        bottomNavPresenter = new BottomNavPresenter(this);
        bottomNavPresenter.loadData();
    }

    @Override
    public void initialize() {
        bottomNavigation = (BottomNavigationView)findViewById(R.id.bottomNavigation);
        textContent = (TextView) findViewById(R.id.textContent);
    }

    @Override
    public void events() {
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                bottomNavPresenter.retrieveUserAction(item, BottomNavActivity.this);
                return false;
            }
        });
    }

    @Override
    public void displayContent(String text) {
        textContent.setText(text);
    }
}
