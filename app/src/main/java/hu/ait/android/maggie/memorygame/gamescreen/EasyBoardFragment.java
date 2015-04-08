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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/5/2015.
 */
public class EasyBoardFragment extends BoardFragment {

    public static final String TAG = "EasyBoardFragment";
    public static final int GRID_SIZE = 4;
    public static final int PAIR_COUNT = GRID_SIZE  * GRID_SIZE / 2;

    private Resources res;
    private GridLayout grid;

    private ToggleButton activeCard;

    private Drawable cardBack;

    private int pairsFound;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.board_fragment, container, false);
        res = getActivity().getResources();

        RelativeLayout baseLayout = (RelativeLayout) getActivity().findViewById(R.id.bottomLayout);
        int backgroundColor = res.getColor(R.color.light_purple);
        baseLayout.setBackgroundColor(backgroundColor);
        rootView.setBackgroundColor(backgroundColor);
        ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(res.getColor(R.color.dark_purple)));

        grid = (GridLayout) rootView.findViewById(R.id.boardLayout);
        grid.setRowCount(GRID_SIZE);

        cardBack = res.getDrawable(R.drawable.easy_button_back);

        addButtonsToGrid();

        return rootView;
    }


    private void addButtonsToGrid() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int cardWidth = size.x / (GRID_SIZE + 1);


        final List<Integer> cardFaces = selectCardPool(PAIR_COUNT);
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
            final ToggleButton button = new ToggleButton(getActivity());
            //Wanted to use a style here but couldn't get it working
            button.setTextOff("");
            button.setTextOn("");
            button.setBackground(cardBack);
            button.setId(i);
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        button.setBackground(res.getDrawable(cardFaces.get(button.getId())));
                        checkAgainstActiveCard(button);
                    } else {
                        button.setBackground(cardBack);
                        button.setEnabled(true);
                    }
                }
            });
            grid.addView(button, cardWidth, cardWidth);
            //Some weirdness here, the default text still draws until the button has been toggled,
            // despite being set to ""
//            button.toggle();
//            button.toggle();
        }
    }

    protected void checkAgainstActiveCard(final ToggleButton newFlip){
        if(activeCard != null){
            //Found a pair
            if(activeCard.getBackground().getConstantState().equals(newFlip.getBackground().getConstantState())){
                activeCard.setEnabled(false);
                newFlip.setEnabled(false);
                activeCard = null;
                pairsFound++;
                if(pairsFound == PAIR_COUNT){
                    Toast.makeText(getActivity(), "You win!", Toast.LENGTH_LONG).show();
                }
            } else { //Did not find a pair
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        activeCard.toggle();
                        activeCard.setEnabled(true);
                        activeCard = null;
                        newFlip.setChecked(false);
                        newFlip.setBackground(cardBack);
                        newFlip.setEnabled(true);
                    }
                }, 250);
            }
        } else { //First card to be flipped
            activeCard = newFlip;
            //activeCard.setBackground(res.getDrawable(R.drawable.med_button_back));
            activeCard.setEnabled(false);
        }
    }

}
