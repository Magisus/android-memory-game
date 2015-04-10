package hu.ait.android.maggie.memorygame.tutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/9/2015.
 */
public class GoFastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fast_fragment, container, false);
        return rootView;
    }
}
