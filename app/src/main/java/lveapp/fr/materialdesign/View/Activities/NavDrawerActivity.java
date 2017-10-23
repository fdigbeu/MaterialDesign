package lveapp.fr.materialdesign.View.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import lveapp.fr.materialdesign.Presenter.NavDrawerPresenter;
import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.NavDrawerView;

public class NavDrawerActivity extends AppCompatActivity
        implements NavDrawerView.INavDrawer {

    private NavDrawerPresenter drawerPresenter;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        //--
        drawerPresenter = new NavDrawerPresenter(this);
        drawerPresenter.loadData();
    }

    @Override
    public void onBackPressed() {
        drawerPresenter.drawerOnBackPress(drawer, NavDrawerActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerPresenter.retrieveUserAction(item, null);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initialize() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    @Override
    public void events() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerPresenter.retrieveUserAction(view);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerPresenter.retrieveUserAction(item, drawer);
                return true;
            }
        });
    }
}
