package com.nmp.phuc.applearnlanguage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.navigationView);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer(MenuItem menuItem){
        Fragment  myFragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.drawer_tuVung:
                fragmentClass = tuvung.class;
                break;
            case R.id.drawer_hocTu:
                fragmentClass = hoctu.class;
                break;
            case R.id.drawer_kiemTra:
                fragmentClass = kiemtra.class;
                break;
            case R.id.drawer_chat:
                fragmentClass = chat.class;
                break;
            case R.id.drawer_info:
                fragmentClass = thongtinnguoidung.class;
                break;
            case R.id.drawer_tuyChinh:
                fragmentClass = tuychinh.class;
                break;
            case R.id.drawer_logout:
                fragmentClass = dangxuat.class;
                break;
            default:
                fragmentClass = tuvung.class;
        }
        try {
            myFragment = (Fragment) fragmentClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent,myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }
}