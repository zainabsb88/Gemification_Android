package rootflyinfo.com.fragment;


import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import rootflyinfo.com.adapter.FourthGridAdapter;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.QuizGlobal;

/**
 * A simple {@link Fragment} subclass.
 */
public class Quiz extends Fragment {

    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    private Button bt_next,bt_prev;
    private ProgressBar progressBar;
    private TextView atx,atx2,atx3,atx4,qtx;
    private Drawable d;
    public Quiz() {
        // Required empty public constructor
    }
    private Button bt;
    private Dialog dialog_event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dialog_event=new Dialog(getActivity());
        dialog_event.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_event.setContentView(R.layout.dialog_score);
        bt= (Button) dialog_event.findViewById(R.id.button6);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);
        bt_next = (Button) rootView.findViewById(R.id.button2);
        bt_prev = (Button) rootView.findViewById(R.id.button3);
        qtx=(TextView)rootView.findViewById(R.id.textView24);
        atx=(TextView)rootView.findViewById(R.id.textView25);
        progressBar=(ProgressBar)getActivity().findViewById(R.id.progressBar);
        atx2=(TextView)rootView.findViewById(R.id.textView26);
        atx3=(TextView)rootView.findViewById(R.id.textView27);
        atx4=(TextView)rootView.findViewById(R.id.textView28);

        switch (QuizGlobal.getQuiz_no())
        {
            case 1:qtx.setText("Qual a resolução de Sensor?");
                    atx.setText("Zoom 9X");
                    atx2.setText("Sensor Hybrid CMOS AF 18 megapixéis");
                    atx3.setText("CMOS DE 1/2,3");
                    atx4.setText("ZOOM 20x");
                atx4.setVisibility(View.VISIBLE);
                     break;
            case 2:qtx.setText("Qual a velocidade de Disparo?");
                progressBar.setProgress(50);
                atx.setText("10 imagens por segundo");
                atx2.setText("3 imagens por segundo");
                atx3.setText("5 imagens por segundo");
                atx4.setText("1 imagens por segundo");
                atx4.setVisibility(View.VISIBLE);
                break;
            case 3:qtx.setText("Qual a Expressão que melho  Up-Selling?");
                progressBar.setProgress(55);
                atx.setText("“Têm aqui esta Canon adequada às suasnecessidades”");
                atx2.setText("“Por mais 50€, o processador desta câmara é bastante mais rápido, considero”");
                atx3.setText("“Não precisa de uma mala para o trasnportar a sua máquina em segurança?” ");
                atx4.setVisibility(View.GONE);
                break;
            case 4:qtx.setText("Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.  Donec veli");
                atx.setText("Velit neque");
                atx2.setText("Amet aliquam");
                progressBar.setProgress(60);
                atx3.setText("Orci luctus");
                atx4.setText("Sit amet ligula");
                atx4.setVisibility(View.VISIBLE);
                break;
        }
        d=getActivity().getResources().getDrawable(R.mipmap.ic_tick);
        d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
        atx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    normal();
                atx.setBackgroundResource(R.drawable.button_rounded_green);
                atx.setTextColor(getResources().getColor(R.color.white));
                atx.setCompoundDrawablePadding(50);
                atx.setPadding(10,10,10,10);
                atx.setCompoundDrawables(d,null,null,null);

            }
        });
        atx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normal();
                atx2.setBackgroundResource(R.drawable.button_rounded_green);
                atx2.setTextColor(getResources().getColor(R.color.white));
                atx2.setCompoundDrawablePadding(50);
                atx2.setPadding(10, 10, 10, 10);
                atx2.setCompoundDrawables(d, null, null, null);

            }
        });
        atx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normal();
                atx3.setBackgroundResource(R.drawable.button_rounded_green);
                atx3.setTextColor(getResources().getColor(R.color.white));
                atx3.setCompoundDrawablePadding(50);
                atx3.setPadding(10, 10,10 ,10);
                atx3.setCompoundDrawables(d, null, null, null);
            }
        });
        atx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normal();
                atx4.setBackgroundResource(R.drawable.button_rounded_green);
                atx4.setTextColor(getResources().getColor(R.color.white));
                atx4.setCompoundDrawablePadding(50);
                atx4.setPadding(10,10,10,10);
                atx4.setCompoundDrawables(d, null, null, null);
            }
        });



        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QuizGlobal.getQuiz_no()==4)
                {
                    dialog_event.show();

                }else{
                    android.support.v4.app.Fragment fragment = new Quiz();
                    QuizGlobal.setQuiz_no(QuizGlobal.getQuiz_no()+1);
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QuizGlobal.getQuiz_no()==1){
                    android.support.v4.app.Fragment fragment = new Fourth();
                    QuizGlobal.setQuiz_no(1);
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                }else {
                    android.support.v4.app.Fragment fragment = new Quiz();
                    QuizGlobal.setQuiz_no(QuizGlobal.getQuiz_no() - 1);
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
        return rootView;
    }
        void normal(){
            atx.setBackgroundResource(R.drawable.button_rounded_gray);
            atx2.setBackgroundResource(R.drawable.button_rounded_gray);
            atx3.setBackgroundResource(R.drawable.button_rounded_gray);
            atx4.setBackgroundResource(R.drawable.button_rounded_gray);
            atx.setTextColor(getResources().getColor(R.color.dark_grey));
            atx2.setTextColor(getResources().getColor(R.color.dark_grey));
            atx3.setTextColor(getResources().getColor(R.color.dark_grey));
            atx4.setTextColor(getResources().getColor(R.color.dark_grey));
            atx.setCompoundDrawables(null,null,null,null);
            atx.setPadding(100,20,20,20);
            atx2.setPadding(100,20,20,20);
            atx3.setPadding(100,20,20,20);
            atx4.setPadding(100,20,20,20);
           atx2.setCompoundDrawables(null,null,null,null);
           atx3.setCompoundDrawables(null,null,null,null);
           atx4.setCompoundDrawables(null,null,null,null);

        }

}
