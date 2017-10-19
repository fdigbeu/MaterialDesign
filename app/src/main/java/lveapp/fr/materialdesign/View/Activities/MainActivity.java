package lveapp.fr.materialdesign.View.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lveapp.fr.materialdesign.Presenter.MainPresenter;
import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.MainView;

public class MainActivity extends AppCompatActivity implements MainView.IMain {

    private Button formLoginPassword, bottomSheets, navigationDrawer, bottomNavigation;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        mainPresenter.loadData();
    }

    @Override
    public void initialize() {
        formLoginPassword = (Button)findViewById(R.id.formLoginPassword);
        bottomSheets = (Button)findViewById(R.id.bottomSheets);
        navigationDrawer = (Button)findViewById(R.id.navigationDrawer);
        bottomNavigation = (Button)findViewById(R.id.bottomNavigation);
    }

    @Override
    public void events() {
        formLoginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.retrieveUserAction(view);
            }
        });
        bottomSheets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.retrieveUserAction(view);
            }
        });
        navigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.retrieveUserAction(view);
            }
        });
        bottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.retrieveUserAction(view);
            }
        });
    }


    @Override
    public void launch(Class c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
