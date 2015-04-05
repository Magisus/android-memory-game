package hu.ait.android.maggie.memorygame.gamescreen;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/5/2015.
 */
public class MediumBoardFragment extends Fragment {

    public static final String TAG = "MediumBoardFragment";
    public static final int GRID_SIZE = 6;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.board_fragment, container, false);
        GridLayout grid = (GridLayout) rootView.findViewById(R.id.boardLayout);
        grid.setRowCount(GRID_SIZE);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int cardWidth = size.x / (GRID_SIZE + 1);
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
            Button button = new Button(getActivity());
            button.setText(Integer.toString(i));
            grid.addView(button, cardWidth, cardWidth);
        }
        return rootView;
    }
}
