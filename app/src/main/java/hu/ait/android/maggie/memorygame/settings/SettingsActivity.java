package hu.ait.android.maggie.memorygame.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import hu.ait.android.maggie.memorygame.R;

public class SettingsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        showFragment(SettingsDisplayFragment.TAG);
    }

    public void showFragment(String tag) {
        Fragment fragment = null;
        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag(tag);
        if (fragment == null) {
            if (SettingsDisplayFragment.TAG.equals(tag)) {
                fragment = new SettingsDisplayFragment();
            }
        }

        if (fragment != null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.layoutContainer, fragment, tag);
            transaction.commit();
        }
    }
}
