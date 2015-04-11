package hu.ait.android.maggie.memorygame.highscores;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/10/2015.
 */
public class HardScoresFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.score_fragment, container, false);

        List<Score> scores = Score.find(Score.class, "difficulty = ?", "HARD");
        Collections.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score lhs, Score rhs) {
                return lhs.getTime().compareTo(rhs.getTime());
            }
        });

        ListView scoreList = (ListView) rootView.findViewById(R.id.scoreList);
        scoreList.setAdapter(new ScoreAdapter(scores, getActivity().getApplicationContext()));

        return rootView;
    }
}
