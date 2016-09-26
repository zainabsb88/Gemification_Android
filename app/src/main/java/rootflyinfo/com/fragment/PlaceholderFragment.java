package rootflyinfo.com.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import rootflyinfo.com.gamification.R;

/**
 * A simple {@link Fragment} subclass.
 */
public  class PlaceholderFragment extends android.support.v4.app.Fragment {
    private Button bt_next;
    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    private ProgressBar progressBar;
    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_description, container, false);
        bt_next=(Button)rootView.findViewById(R.id.button2);
        progressBar=(ProgressBar)getActivity().findViewById(R.id.progressBar);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = new Characteristics();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
                progressBar.setProgress(20);
            }
        });
        return rootView;
    }
}