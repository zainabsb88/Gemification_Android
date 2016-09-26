package rootflyinfo.com.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import rootflyinfo.com.gamification.R;

/**
 * Created by Mithun Manoharan on 8/23/2016.
 */
public class DashboardGridAdapter extends BaseAdapter {

   private Context c;
   private LayoutInflater inflater;
   private String[] score,title;
   private TextView tx_digit,tx_title,tx_arrow;

    public DashboardGridAdapter(Context c, String[] score, String[] title)
    {
    this.c=c;
    this.score=score;
    this.title=title;
    this.inflater=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return score.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private ImageView d_img;
    private Button b1;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View rootView = inflater.inflate(R.layout.dashboard_grid_new, parent, false);
         tx_digit=(TextView)rootView.findViewById(R.id.textView77);
         tx_title=(TextView)rootView.findViewById(R.id.textView78);
         tx_arrow=(TextView)rootView.findViewById(R.id.textView79);
         tx_digit.setText(score[position]);
         tx_title.setText(title[position]);
        if (position==score.length-1)
        {
            tx_arrow.setVisibility(View.INVISIBLE);
        }
         return rootView;
    }
}
