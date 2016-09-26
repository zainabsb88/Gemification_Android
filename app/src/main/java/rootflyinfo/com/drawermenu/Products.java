package rootflyinfo.com.drawermenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.os.Bundle;import android.support.v4.app.Fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import rootflyinfo.com.adapter.StartUpListAdapter;
import rootflyinfo.com.fragment.TipsInfo;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;

public class Products extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // TODO: Rename and change types and number of parameters
    public static Products newInstance(String param1, String param2) {
        Products fragment = new Products();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Products() {
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
    private ListView ls;
    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;

    private RelativeLayout rf;
   private FrameLayout rb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView=inflater.inflate(R.layout.fragment_products, container, false);
        rf=(RelativeLayout)convertView.findViewById(R.id.tips_for) ;
        rb=(FrameLayout) convertView.findViewById(R.id.product_c) ;
        rb.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
        StateListDrawable bgShape = (StateListDrawable) rf.getBackground();
        bgShape.setColorFilter(Color.parseColor(GlobalColor.getForeground()), PorterDuff.Mode.SRC_IN);

        ls= (ListView) convertView.findViewById(R.id.listView6);
        ls.setAdapter(new StartAdapter(getActivity()));
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = new TipsInfo();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.product_c, fragment);
                fragmentTransaction.commit();
            }
        });
        return convertView;
    }


    public class StartAdapter extends BaseAdapter {

       private String[] tx_resource={"Professional for armature","1st Difference","Processor","Lens Enhancement","Why 7000D"};
        private LayoutInflater inflater;
        private Context c;
        private ImageView img;
        private TextView tx_title;

        public StartAdapter(Context c) {
            this.c = c;
            inflater = LayoutInflater.from(c);

        }
        @Override
        public int getCount() {
            return tx_resource.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.startup_listview_product, parent, false);
            img=(ImageView)convertView.findViewById(R.id.imageView7);
            tx_title=(TextView)convertView.findViewById(R.id.textView2);
             tx_title.setText(tx_resource[position]);
            return convertView;
        }
    }


}
