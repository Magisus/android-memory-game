package hu.ait.android.maggie.memorygame.gamescreen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import hu.ait.android.maggie.memorygame.R;
import hu.ait.android.maggie.memorygame.highscores.HighScoresActivity;
import hu.ait.android.maggie.memorygame.mainmenu.MainMenuActivity;

/**
 * Created by Magisus on 4/12/2015.
 */
public class EndGameNavDialog extends DialogFragment {

    public static final String TAG = "EndGameNavDialog";

    private static final String TIME_ARG = "TIME";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("You win!");
        builder.setCancelable(false);

        builder.setMessage("Your time:\n" + getArguments().getString(TIME_ARG));

        builder.setPositiveButton(getActivity().getString(R.string.play_again),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EndGameNavDialog.this.startActivity(new Intent(getActivity(), GameScreenActivity.class));
                    }
                });
        builder.setNeutralButton(getActivity().getString(R.string.high_scores), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EndGameNavDialog.this.startActivity(new Intent(getActivity(), HighScoresActivity.class));
            }
        });
        builder.setNegativeButton(getActivity().getString(R.string.main_menu), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EndGameNavDialog.this.startActivity(new Intent(getActivity(), MainMenuActivity.class));
            }
        });
        return builder.create();
    }

    static EndGameNavDialog newInstance(String time){
        EndGameNavDialog dialog = new EndGameNavDialog();

        Bundle args = new Bundle();
        args.putString(TIME_ARG, time);
        dialog.setArguments(args);
        return dialog;
    }
}
