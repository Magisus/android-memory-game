package hu.ait.android.maggie.memorygame.gamescreen;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

import hu.ait.android.maggie.memorygame.R;
import hu.ait.android.maggie.memorygame.highscores.Score;

/**
 * Created by Magisus on 4/5/2015.
 */
public class EasyBoardFragment extends BoardFragment {

    public static final String TAG = "EasyBoardFragment";
    public static final int GRID_SIZE = 4;
    public static final int PAIR_COUNT = GRID_SIZE  * GRID_SIZE / 2;

    private Resources res;
    private GridLayout grid;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        res = getActivity().getResources();

        RelativeLayout baseLayout = (RelativeLayout) getActivity().findViewById(R.id.bottomLayout);
        int backgroundColor = res.getColor(R.color.light_purple);
        baseLayout.setBackgroundColor(backgroundColor);
        rootView.setBackgroundColor(backgroundColor);
        ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(res.getColor(R.color.dark_purple)));

        grid = (GridLayout) rootView.findViewById(R.id.boardLayout);
        grid.setRowCount(GRID_SIZE);

        //Set up parent
        setCardBack(res.getDrawable(R.drawable.easy_button_back));
        setPairCount(PAIR_COUNT);
        setDifficulty(Score.Difficulty.EASY);

        addButtonsToGrid(grid, GRID_SIZE, GRID_SIZE, calculateCardWidth(GRID_SIZE, 1));

        return rootView;
    }






}
