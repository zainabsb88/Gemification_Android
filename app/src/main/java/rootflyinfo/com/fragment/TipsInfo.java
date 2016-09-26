package rootflyinfo.com.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import rootflyinfo.com.adapter.MessagesListAdapter;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.modelclass.Msg;
import rootflyinfo.com.utils.GlobalColor;

public class TipsInfo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public TipsInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipsInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static TipsInfo newInstance(String param1, String param2) {
        TipsInfo fragment = new TipsInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
 private ImageView img,img_m;
    private TextView tx,tx_m;
    private Dialog d;
    private Button b;
    private EditText edt;

    ListView listMsg;
    ArrayList<Msg> listMessages;
    MessagesListAdapter adapter;
    RelativeLayout rf,rb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView = inflater.inflate(R.layout.fragment_thirdslider_info, container, false);
        rf=(RelativeLayout)convertView.findViewById(R.id.tipinfo_for) ;
        rb=(RelativeLayout)convertView.findViewById(R.id.tipinfo_back) ;
        rb.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
        StateListDrawable bgShape = (StateListDrawable) rf.getBackground();
        bgShape.setColorFilter(Color.parseColor(GlobalColor.getForeground()), PorterDuff.Mode.SRC_IN);

        img=(ImageView)convertView.findViewById(R.id.imageView24);
        d=new Dialog(getActivity(),android.R.style.Theme_Translucent_NoTitleBar);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);

        d.setContentView(R.layout.fragment_tips);

        b=(Button)d.findViewById(R.id.button9);
        edt=(EditText)d.findViewById(R.id.editText6);

        img_m=(ImageView)convertView.findViewById(R.id.imageView23);
        tx=(TextView) convertView.findViewById(R.id.textView39);
        tx_m=(TextView) convertView.findViewById(R.id.textView38);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h=Integer.parseInt(tx.getText().toString())+1;
                tx.setText(""+h);
            }
        });
       img_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt.setText("");
               d.show();
            }
        });
        listMsg= (ListView) d.findViewById(R.id.listView7);
        listMessages=new ArrayList<>();
        listMessages.add(new Msg("first","second","Robot","gre8 tip",true,"fifth","28-May","15:03"));
        listMessages.add(new Msg("first","second","Carie ","ya true",true,"fifth","28-May","15:04"));
        listMessages.add(new Msg("first","second","John","perfect for me",true,"fifth","28-May","15:05"));
        listMessages.add(new Msg("first","second","Samtha","camera saved my pic",true,"fifth","28-May","15:06"));
        adapter = new MessagesListAdapter(getActivity(), listMessages);
        listMsg.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listMessages.add(new Msg("first","second",edt.getText().toString(),"",false,"fifth","28-May","15:10"));
                adapter.notifyDataSetChanged();
                edt.setText("");
                reply();
            }
        });
        return convertView;
    }
    void reply()
    {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                d.dismiss();
                tx_m.setText("13");

            }
        }, 2000);
    }
}

