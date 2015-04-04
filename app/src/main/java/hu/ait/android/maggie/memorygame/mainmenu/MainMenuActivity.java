package hu.ait.android.maggie.memorygame.mainmenu;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import hu.ait.android.maggie.memorygame.R;
import hu.ait.android.maggie.memorygame.mainmenu.MainMenuFragment;


public class MainMenuActivity extends FragmentActivity {

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
