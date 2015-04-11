package hu.ait.android.maggie.memorygame.highscores;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/11/2015.
 */
public class ScoreAdapter extends BaseAdapter {

    public static final int SCORE_SLOTS = 10;

    private List<Score> scores;
    private Context context;

    public ScoreAdapter(List<Score> scores, Context context) {
        this.scores = scores;
        this.context = context;

        //If not enough scores come from the database, make some placeholders
        for(int i = scores.size(); i < SCORE_SLOTS; i++){
            scores.add(new Score(-1.0, "--", null, null));
        }
    }

    @Override
    public int getCount() {
        return SCORE_SLOTS;
    }

    @Override
    public Object getItem(int position) {
        return scores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        private TextView index;
        private TextView time;
        private TextView name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(context).inflate(R.layout.score_row, null);
            ViewHolder holder = new ViewHolder();
            holder.index = (TextView) v.findViewById(R.id.indexText);
            holder.time = (TextView) v.findViewById(R.id.timeText);
            holder.name = (TextView) v.findViewById(R.id.nameText);
            v.setTag(holder);
        }

        Score score = scores.get(position);
        if(score != null){
            ViewHolder holder = (ViewHolder) v.getTag();
            holder.index.setText((position + 1) + ".");
            //If there is no score saved for this index, display placeholder text
            String time = score.getTimeSeconds() == -1.0 ? "--" : (score.getTimeSeconds() + "s");
            holder.time.setText(time);
            holder.name.setText(score.getName());
        }
        return v;
    }
}
