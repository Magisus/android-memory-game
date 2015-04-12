package hu.ait.android.maggie.memorygame.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import hu.ait.android.maggie.memorygame.R;
import hu.ait.android.maggie.memorygame.tutorial.InitializeSettingsFragment;

public class SettingsActivity extends ActionBarActivity {

    public static final String SETTINGS = "SettingsSharedPreferences";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String GENDER = "gender";

    private boolean editMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editMode = getIntent().getBooleanExtra(InitializeSettingsFragment.EDIT_MODE, false);
        if (editMode) {
            showFragment(EditUserFragment.TAG);
        } else {
            showFragment(SettingsDisplayFragment.TAG);
        }
    }

    public void showFragment(String tag) {
        Fragment fragment = null;
        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag(tag);
        if (fragment == null) {
            if (SettingsDisplayFragment.TAG.equals(tag)) {
                fragment = new SettingsDisplayFragment();
            } else if (EditUserFragment.TAG.equals(tag)) {
                fragment = EditUserFragment.newInstance(editMode);
            }
        }

        if (fragment != null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.layoutContainer, fragment, tag);
            transaction.commit();
        }
    }
}
