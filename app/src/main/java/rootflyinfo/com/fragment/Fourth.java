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
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import rootflyinfo.com.adapter.FourthGridAdapter;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;
import rootflyinfo.com.utils.QuizGlobal;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fourth extends Fragment {

    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    private Button bt_next,bt_prev;
    private GridView gd_acc;
    private ProgressBar progressBar;
    public Fourth() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_characteristics_fourth, container, false);
        TextView tx= (TextView) rootView.findViewById(R.id.textView5);
        tx.setTextColor(Color.parseColor(GlobalColor.getContent()));

        progressBar=(ProgressBar)getActivity().findViewById(R.id.progressBar);
        progressBar.setProgress(40);
        bt_next = (Button) rootView.findViewById(R.id.button2);
        bt_prev = (Button) rootView.findViewById(R.id.button3);
        gd_acc=(GridView)rootView.findViewById(R.id.gridView);
        gd_acc.setAdapter(new FourthGridAdapter(getActivity(),0));
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Quiz();
                QuizGlobal.setQuiz_no(1);
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });
        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Third();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }
    }
