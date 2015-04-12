package hu.ait.android.maggie.memorygame.tutorial;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/9/2015.
 */
public class DifficultyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.difficulty_fragment, container, false);

        ImageView screens = (ImageView) rootView.findViewById(R.id.difficultyScreens);
        screens.setAdjustViewBounds(true);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screens.setMaxWidth((int) (size.x * 0.85));
        screens.setMaxHeight((int)(size.y * 0.70));
        return rootView;
    }
}
