package hu.ait.android.maggie.memorygame.highscores;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/10/2015.
 */
public class HardScoresFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.score_fragment, container, false);
        return rootView;
    }
}
