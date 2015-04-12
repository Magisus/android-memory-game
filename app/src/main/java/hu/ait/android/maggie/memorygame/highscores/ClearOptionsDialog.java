package hu.ait.android.maggie.memorygame.highscores;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/12/2015.
 */
public class ClearOptionsDialog extends DialogFragment {

    public static final String TAG = "ClearOptionsDialog";

    private String[] difficulties;

    private List<String> selectedItems;

    private MultiOptionsFragmentInterface parent;

    public interface MultiOptionsFragmentInterface {
        public void onOptionsFragmentResult(List<String> choices);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle(getActivity().getString(R.string.hs_clear_dialog_title));
        difficulties = new String[]{Score.Difficulty.EASY.toString(),
                Score.Difficulty.MEDIUM.toString(), Score.Difficulty.HARD.toString()};
        selectedItems = new ArrayList<>();
        builder.setMultiChoiceItems(difficulties, new boolean[]{false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index, boolean isChecked) {
                if (isChecked) {
                    selectedItems.add(difficulties[index]);
                } else {
                    selectedItems.remove(difficulties[index]);
                }
            }
        });

        builder.setPositiveButton(getActivity().getString(R.string.clear_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                parent.onOptionsFragmentResult(selectedItems);
            }
        });
        builder.setNegativeButton(getActivity().getString(R.string.cancel_btn),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClearOptionsDialog.this.dismiss();
                    }
                });
        return builder.create();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            parent = (MultiOptionsFragmentInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OptionsFragmentInterface");
        }
    }
}
