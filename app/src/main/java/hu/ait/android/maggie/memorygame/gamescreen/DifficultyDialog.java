package hu.ait.android.maggie.memorygame.gamescreen;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/4/2015.
 */
public class DifficultyDialog extends DialogFragment implements DialogInterface.OnClickListener {

    public static final String TAG = "DifficultyDialog";

    private OptionsFragmentInterface optionsFragmentInterface;

    private String[] difficulties;

    public interface OptionsFragmentInterface {
        public void onOptionsFragmentResult(String difficulty);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle("Choose a difficulty:");
        difficulties = new String[] {getActivity().getString(R.string.easy_text),
                getActivity().getString(R.string.medium_text), getActivity().getString(R.string
                .hard_text)};
        builder.setItems(difficulties, this);
        return builder.create();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            optionsFragmentInterface = (OptionsFragmentInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OptionsFragmentInterface");
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int choice) {
        optionsFragmentInterface.onOptionsFragmentResult(difficulties[choice]);
    }
}
