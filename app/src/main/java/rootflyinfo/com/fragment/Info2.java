package rootflyinfo.com.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import rootflyinfo.com.gamification.Description;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;


public class Info2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  TextView mTitleTextView;
    private Button bt_info;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Info.
     */
    // TODO: Rename and change types and number of parameters
    public static Info2 newInstance(String param1, String param2) {
        Info2 fragment = new Info2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Info2() {
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
    private RelativeLayout rf,rb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView=inflater.inflate(R.layout.fragment_info_1, container, false);
        rf=(RelativeLayout)convertView.findViewById(R.id.info_for) ;
        rb=(RelativeLayout)convertView.findViewById(R.id.info_back) ;
        rb.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
        StateListDrawable bgShape = (StateListDrawable) rf.getBackground();
        bgShape.setColorFilter(Color.parseColor(GlobalColor.getForeground()), PorterDuff.Mode.SRC_IN);

        bt_info=(Button)convertView.findViewById(R.id.button);
        bt_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Description.class);
                startActivity(i);
            }
        });
       return convertView;
    }

}
