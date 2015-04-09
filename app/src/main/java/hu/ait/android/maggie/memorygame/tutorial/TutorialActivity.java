package hu.ait.android.maggie.memorygame.tutorial;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import hu.ait.android.maggie.memorygame.R;

public class TutorialActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new TutorialFragmentAdapter(getSupportFragmentManager(), getApplicationContext()));
    }

}
