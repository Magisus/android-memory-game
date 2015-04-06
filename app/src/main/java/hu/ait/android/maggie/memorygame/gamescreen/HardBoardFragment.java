package hu.ait.android.maggie.memorygame.gamescreen;

import android.content.res.Resources;
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
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/6/2015.
 */
public class HardBoardFragment extends Fragment {

    public static final String TAG = "HardBoardFragment";
    public static final int GRID_WIDTH = 6;
    public static final int GRID_HEIGHT = 8;

    private Resources res;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.board_fragment, container, false);
        res = getActivity().getResources();

        RelativeLayout baseLayout = (RelativeLayout) getActivity().findViewById(R.id.bottomLayout);
        int backgroundColor = res.getColor(R.color.light_yellow);
        baseLayout.setBackgroundColor(backgroundColor);
        rootView.setBackgroundColor(backgroundColor);
        ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(res.getColor(R.color.dark_yellow)));

        GridLayout grid = (GridLayout) rootView.findViewById(R.id.boardLayout);
        grid.setRowCount(GRID_HEIGHT);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int cardWidth = (int)(size.x / (GRID_WIDTH + 1.7));
        for (int i = 0; i < GRID_HEIGHT * GRID_WIDTH; i++) {
            final ToggleButton button = new ToggleButton(getActivity());
            //Wanted to use a style here but couldn't get it working
            button.setBackground(res.getDrawable(R.drawable.hard_button_back));
            button.setTextOff("");
            button.setTextOn("");
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        //show card face
                        button.setBackground(res.getDrawable(R.drawable.easy_button_back));
                        //disable so the user can't re-flip cards
                        button.setEnabled(false);
                    } else {
                        button.setBackground(res.getDrawable(R.drawable.hard_button_back));
                        button.setEnabled(true);
                    }
                }
            });
            grid.addView(button, cardWidth, cardWidth);
            button.toggle();
            button.toggle();
        }
        return rootView;
    }
}
