package rootflyinfo.com.drawermenu;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;

public class Trophies extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Trophies.
     */
    // TODO: Rename and change types and number of parameters
    public static Trophies newInstance(String param1, String param2) {
        Trophies fragment = new Trophies();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Trophies() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private GridView gd;
    private RelativeLayout rf,rb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_trofeus, container, false);
        rf=(RelativeLayout)rootView.findViewById(R.id.trofie_for) ;
        rb=(RelativeLayout)rootView.findViewById(R.id.trofie_back) ;
        rb.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
        StateListDrawable bgShape = (StateListDrawable) rf.getBackground();
        bgShape.setColorFilter(Color.parseColor(GlobalColor.getForeground()), PorterDuff.Mode.SRC_IN);
        gd= (GridView) rootView.findViewById(R.id.gridView4);
        gd.setAdapter(new NavListAdapter());
      return rootView;
    }

    public class NavListAdapter extends BaseAdapter {
        String [] data={"0","2","0","0","5","1","0","0"};
        String [] data2={"Seller Month","FANC Courses","Likes","Tips","Courses Products","Challenges","FA","Recognition"};
        private int[] image_data={R.mipmap.ic_tf1,R.mipmap.ic_tf2,R.mipmap.ic_tf3,R.mipmap.ic_tf4,R.mipmap.ic_tf5,R.mipmap.ic_tf6,R.mipmap.ic_tf7,R.mipmap.ic_tf8,};
        private ImageView ic_img;
        private TextView tx_title,tx;
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.trofus_element, parent, false);
            ic_img=(ImageView)convertView.findViewById(R.id.imageView25);
            ic_img.setImageResource(image_data[position]);
            tx_title=(TextView)convertView.findViewById(R.id.textView40);
            tx=(TextView)convertView.findViewById(R.id.textView53);
            if(data[position].equals("0"))
                tx_title.setVisibility(View.INVISIBLE);
                else {
                tx_title.setText(data[position]);
                tx_title.setVisibility(View.VISIBLE);
            }
            tx.setText(data2[position]);
            return convertView;
        }
    }
}
