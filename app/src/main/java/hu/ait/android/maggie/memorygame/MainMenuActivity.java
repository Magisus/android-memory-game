package hu.ait.android.maggie.memorygame;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainMenuActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        showFragment(MainMenuFragment.TAG);
    }

    private void showFragment(String fragmentTag) {
        if (MainMenuFragment.TAG.equals(fragmentTag)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();

            MainMenuFragment fragmentLogin = new MainMenuFragment();
            fragmentTransaction.replace(R.id.layoutContainer, fragmentLogin,
                    MainMenuFragment.TAG);

            fragmentTransaction.commit();
        }
    }
}
