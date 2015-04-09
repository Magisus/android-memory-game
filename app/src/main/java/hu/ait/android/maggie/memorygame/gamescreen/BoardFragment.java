package hu.ait.android.maggie.memorygame.gamescreen;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/7/2015.
 */
public class BoardFragment extends Fragment {

    private List<Integer> availableCardFaces;

    private Random rand;

    private ToggleButton activeCard;

    private Drawable cardBack;

    private int pairsFound;
    private int pairCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rand = new Random();
        initializeCards();
    }

    protected void setCardBack(Drawable cardBack) {
        this.cardBack = cardBack;
    }

    protected void setPairCount(int pairCount) {
        this.pairCount = pairCount;
    }

    private void initializeCards() {
        availableCardFaces = new ArrayList<>();
        availableCardFaces.add(R.drawable.cf1);
        availableCardFaces.add(R.drawable.cf2);
        availableCardFaces.add(R.drawable.cf3);
        availableCardFaces.add(R.drawable.cf4);
        availableCardFaces.add(R.drawable.cf5);
        availableCardFaces.add(R.drawable.cf6);
        availableCardFaces.add(R.drawable.cf7);
        availableCardFaces.add(R.drawable.cf8);
        availableCardFaces.add(R.drawable.cf9);
        availableCardFaces.add(R.drawable.cf10);
        availableCardFaces.add(R.drawable.cf11);
        availableCardFaces.add(R.drawable.cf12);
        availableCardFaces.add(R.drawable.cf13);
        availableCardFaces.add(R.drawable.cf14);
        availableCardFaces.add(R.drawable.cf15);
        availableCardFaces.add(R.drawable.cf16);
        availableCardFaces.add(R.drawable.cf17);
        availableCardFaces.add(R.drawable.cf18);
        availableCardFaces.add(R.drawable.cf19);
        availableCardFaces.add(R.drawable.cf20);
        availableCardFaces.add(R.drawable.cf21);
        availableCardFaces.add(R.drawable.cf22);
        availableCardFaces.add(R.drawable.cf23);
        availableCardFaces.add(R.drawable.cf24);
    }

    /**
     * Return a card image that has not yet been added to the deck, removing it from the pool of
     * available cards.
     */
    private int getAvailableCardFace() {
        return availableCardFaces.remove(rand.nextInt(availableCardFaces.size()));
    }

    /**
     * Create the pool of card faces, randomly selected. Each one is added twice to ensure
     * exactly two copies of each card appear on the board
     */
    protected List<Integer> selectCardPool(int uniqueCardCount) {
        List<Integer> cardFaces = new ArrayList<>();
        for (int i = 0; i < uniqueCardCount; i++) {
            int cardFace = getAvailableCardFace();
            cardFaces.add(cardFace);
            cardFaces.add(cardFace);
        }
        Collections.shuffle(cardFaces);
        return cardFaces;
    }

    protected int calculateCardWidth(int columns, double scalingFactor) {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return (int) (size.x / (columns + scalingFactor));
    }

    protected void addButtonsToGrid(GridLayout grid, int columns, int rows, int cardWidth) {
        final List<Integer> cardFaces = selectCardPool(pairCount);
        for (int i = 0; i < columns * rows; i++) {
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
                        button.setBackground(getActivity().getResources().getDrawable(cardFaces
                                .get(button.getId())));
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

    protected void checkAgainstActiveCard(final ToggleButton newFlip) {
        if (activeCard != null) {
            //Found a pair
            if (activeCard.getBackground().getConstantState().equals(newFlip.getBackground()
                    .getConstantState())) {
                activeCard.setEnabled(false);
                newFlip.setEnabled(false);
                activeCard = null;
                pairsFound++;
                if (pairsFound == pairCount) {
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
                }, 350);
            }
        } else { //First card to be flipped
            activeCard = newFlip;
            activeCard.setEnabled(false);
        }
    }
}
