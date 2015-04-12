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
public class TrackScoresFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.track_scores_fragment, container, false);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        ImageView screenshot = (ImageView) rootView.findViewById(R.id.screenshot);
        screenshot.setAdjustViewBounds(true);
        screenshot.setMaxWidth((int)(size.x * 0.75));
        screenshot.setMaxHeight((int)(size.y * 0.7));

        return rootView;
    }
}
