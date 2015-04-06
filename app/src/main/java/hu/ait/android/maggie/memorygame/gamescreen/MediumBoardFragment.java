package hu.ait.android.maggie.memorygame.gamescreen;

import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/5/2015.
 */
public class MediumBoardFragment extends Fragment {

    public static final String TAG = "MediumBoardFragment";
    public static final int GRID_HEIGHT = 6;
    public static final int GRID_WIDTH = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.board_fragment, container, false);

        RelativeLayout baseLayout = (RelativeLayout) getActivity().findViewById(R.id.bottomLayout);
        int backgroundColor = getActivity().getResources().getColor(R.color.light_blue);
        baseLayout.setBackgroundColor(backgroundColor);
        rootView.setBackgroundColor(backgroundColor);
        ActionBar actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getActivity().getResources().getColor(R.color.dark_blue)));

        GridLayout grid = (GridLayout) rootView.findViewById(R.id.boardLayout);
        grid.setRowCount(GRID_HEIGHT);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int cardWidth = (int)(size.x / (GRID_WIDTH + 1.3));
        for (int i = 0; i < GRID_HEIGHT * GRID_WIDTH; i++) {
            Button button = new Button(getActivity());
            button.setBackground(getActivity().getResources().getDrawable(R.drawable.medium_button));
            grid.addView(button, cardWidth, cardWidth);
        }
        return rootView;
    }
}