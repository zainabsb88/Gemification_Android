package rootflyinfo.com.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;

/**
 * A simple {@link Fragment} subclass.
 */
public class Third extends Fragment {

    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    private Button bt_next,bt_prev;
    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_characteristics_third, container, false);
        TextView tx= (TextView) rootView.findViewById(R.id.textView5);
        TextView tx2= (TextView) rootView.findViewById(R.id.textView9);
        TextView tx3= (TextView) rootView.findViewById(R.id.textView11);
        TextView tx4= (TextView) rootView.findViewById(R.id.textView13);
        TextView tx5= (TextView) rootView.findViewById(R.id.textView15);
        TextView tx6= (TextView) rootView.findViewById(R.id.textView17);
        TextView tx7= (TextView) rootView.findViewById(R.id.textView19);
        TextView tx8= (TextView) rootView.findViewById(R.id.textView21);
        tx.setTextColor(Color.parseColor(GlobalColor.getContent()));
        tx2.setTextColor(Color.parseColor(GlobalColor.getContent()));
        tx3.setTextColor(Color.parseColor(GlobalColor.getContent()));
        tx4.setTextColor(Color.parseColor(GlobalColor.getContent()));
        tx5.setTextColor(Color.parseColor(GlobalColor.getContent()));
        tx6.setTextColor(Color.parseColor(GlobalColor.getContent()));
        tx7.setTextColor(Color.parseColor(GlobalColor.getContent()));
        tx8.setTextColor(Color.parseColor(GlobalColor.getContent()));

        bt_next=(Button)rootView.findViewById(R.id.button2);
        bt_prev=(Button)rootView.findViewById(R.id.button3);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fourth();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });
        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Second();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });
        return rootView;

    }


}
