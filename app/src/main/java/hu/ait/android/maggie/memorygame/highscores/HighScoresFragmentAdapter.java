package hu.ait.android.maggie.memorygame.highscores;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/10/2015.
 */
public class HighScoresFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public HighScoresFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return new EasyScoresFragment();
            case 1:
                return new MediumScoresFragment();
            case 2:
                return new HardScoresFragment();
            default:
                return new EasyScoresFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.hs_easy);
            case 1:
                return context.getString(R.string.hs_medium);
            case 2:
                return context.getString(R.string.hs_hard);
            default:
                return context.getString(R.string.hs_easy);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
