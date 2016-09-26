package rootflyinfo.com.drawermenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;

import rootflyinfo.com.adapter.MessagesListAdapter;
import rootflyinfo.com.aoa.AOADashboard;
import rootflyinfo.com.aoa.Login;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.modelclass.Msg;
import rootflyinfo.com.utils.GlobalColor;

public class Chat extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView listMsg;
    ArrayList<Msg> listMessages;
    MessagesListAdapter adapter;


    // TODO: Rename and change types and number of parameters
    public static Chat newInstance(String param1, String param2) {
        Chat fragment = new Chat();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Chat() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        listMessages = new ArrayList<Msg>();

    }
    private ImageButton chat;
    TextView mTitleTextView;
    private EditText edt;
    private RelativeLayout rb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView=inflater.inflate(R.layout.fragment_chat, container, false);
        listMsg= (ListView) convertView.findViewById(R.id.listView5);
        listMsg.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
        rb=(RelativeLayout)convertView.findViewById(R.id.chart_back);
        rb.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
        ((AOADashboard)getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.layout_actionbar, null);
        mTitleTextView = (TextView) mCustomView.findViewById(R.id.textView);
        mTitleTextView.setText("Chat");
        ((AOADashboard)getActivity()).getSupportActionBar().setCustomView(mCustomView);

        chat= (ImageButton) convertView.findViewById(R.id.button8);
        edt= (EditText) convertView.findViewById(R.id.editText3);
        listMessages.add(new Msg("first","second","hello","how are you",true,"fifth","28-May","15:03"));
        listMessages.add(new Msg("first","second","did you ","completed your task",true,"fifth","28-May","15:04"));
        listMessages.add(new Msg("first","second","hello","i am fine",false,"fifth","28-May","15:05"));
        listMessages.add(new Msg("first","second","yes","i will mail you right now",false,"fifth","28-May","15:06"));
        adapter = new MessagesListAdapter(getActivity(), listMessages);
        listMsg.setAdapter(adapter);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listMessages.add(new Msg("first","second",edt.getText().toString(),"",true,"fifth","28-May","15:10"));
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
                listMessages.add(new Msg("first","second","Okay","",false,"fifth","28-May","15:12"));
                adapter.notifyDataSetChanged();

            }
        }, 2000);
    }

}