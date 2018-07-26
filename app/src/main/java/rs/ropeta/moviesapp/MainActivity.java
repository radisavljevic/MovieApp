package rs.ropeta.moviesapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rs.ropeta.moviesapp.adapter.MojAdapter;
import rs.ropeta.moviesapp.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager moviesViewPager;
    private TextView textView;
    private Button button;
    private  MojAdapter mojAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabovi);
        moviesViewPager = (ViewPager) findViewById(R.id.pager);



        ucitaj();

    }

    private void ucitaj() {

        mojAdapter = new MojAdapter(getSupportFragmentManager());
        moviesViewPager.setOffscreenPageLimit(2);
        moviesViewPager.setAdapter(mojAdapter);

        tabLayout.setupWithViewPager(moviesViewPager);


    }


}
