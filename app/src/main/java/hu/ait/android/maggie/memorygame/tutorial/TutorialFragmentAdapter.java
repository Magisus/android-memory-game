package hu.ait.android.maggie.memorygame.tutorial;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/9/2015.
 */
public class TutorialFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public TutorialFragmentAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new DifficultyFragment();
            case 1:
                return new PremiseFragment();
            case 2:
                return new TrackScoresFragment();
            case 3:
                return new InitializeSettingsFragment();
            default:
                return new PremiseFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.tutorial_label_difficulty);
            case 1:
                return context.getString(R.string.tutorial_label_play);
            case 2:
                return context.getString(R.string.tutorial_label_scores);
            case 3:
                return context.getString(R.string.tutorial_label_start);
            default:
                return context.getString(R.string.tutorial_label_play);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
