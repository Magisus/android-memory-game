package hu.ait.android.maggie.memorygame.gamescreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/7/2015.
 */
public class BoardFragment extends Fragment {

    private List<Integer> availableCardFaces;

    private Random rand;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rand = new Random();
        initializeCards();
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
     Create the pool of card faces, randomly selected. Each one is added twice to ensure
     exactly two copies of each card appear on the board
     **/
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
}
