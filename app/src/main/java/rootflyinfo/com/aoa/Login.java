package rootflyinfo.com.aoa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.StringTokenizer;

import rootflyinfo.com.Basic;
import rootflyinfo.com.fragment.Characteristics;
import rootflyinfo.com.fragment.Quiz;
import rootflyinfo.com.gamification.MainActivity;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;
import rootflyinfo.com.utils.QuizGlobal;

public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }
        private Button bt_sign;
        private TextView tx,tx_forgot;
        private EditText uet,pet;
        private ImageView img_company;
        private Spinner spc;
        private RelativeLayout relativeLayout,rf;
        private RelativeLayout rel_company,rel_login;
       public FragmentManager fragmentManager;
        public FragmentTransaction fragmentTransaction;
        private boolean select=false;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_login_new, container, false);
            Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(),
                    "font/Roboto.ttf"); //use this.getAssets if you are calling from an Activity
            rel_company= (RelativeLayout) rootView.findViewById(R.id.relativeLayout2);
            rel_login= (RelativeLayout) rootView.findViewById(R.id.relative_new_login);
            bt_sign= (Button) rel_login.findViewById(R.id.button10);
            uet= (EditText) rel_login.findViewById(R.id.editText11);
            pet= (EditText) rel_login.findViewById(R.id.editText12);
            img_company= (ImageView) rel_company.findViewById(R.id.imageView31);
            tx_forgot= (TextView) rel_login.findViewById(R.id.textView66);

            tx_forgot.setTypeface(roboto);
            uet.setTypeface(roboto);
            pet.setTypeface(roboto);

            if(!GlobalColor.getLogo().equals(""))
            loadImageFromStorage(GlobalColor.getLogo());
            rel_login.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
            //tx_forgot.setTextColor(Color.parseColor(GlobalColor.getContent()));

            bt_sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent i = new Intent(getActivity(), AOADashboard.class);
                        startActivity(i);
                        getActivity().finish();

                }
            });



           /* tx=(TextView)rootView.findViewById(R.id.textView43);
            relativeLayout=(RelativeLayout)rootView.findViewById(R.id.login_main);
            rf=(RelativeLayout)rootView.findViewById(R.id.relative_login);
            tx_forgot=(TextView)rootView.findViewById(R.id.textView45);
            QuizGlobal.setCmp_name("");
            uet=(EditText)rootView.findViewById(R.id.editText);
            pet=(EditText)rootView.findViewById(R.id.editText2);
            spc=(Spinner)rootView.findViewById(R.id.spinner3);
            relativeLayout.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
            StateListDrawable bgShape = (StateListDrawable) rf.getBackground();
            bgShape.setColorFilter(Color.parseColor(GlobalColor.getForeground()),PorterDuff.Mode.SRC_IN);
            bt_sign=(Button)rootView.findViewById(R.id.button7);
           uet.setEnabled(false);pet.setEnabled(false);
            spc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position>0) {
                        uet.setEnabled(true);
                        pet.setEnabled(true);
                        select=true;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            bt_sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (select) {
                        Intent i = new Intent(getActivity(), AOADashboard.class);
                        startActivity(i);
                        getActivity().finish();
                    }else {
                        Toast.makeText(getActivity(),"Please Select Company First",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            tx_forgot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            tx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.support.v4.app.Fragment fragment = new SignUp();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                }
            });*/
            return rootView;
        }
        private void loadImageFromStorage(String path)
        {

            try {
                File f=new File(path, "company.jpg");
                Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
                img_company.setImageBitmap(b);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

        }

    }
    public static class SignUp extends Fragment {
        public FragmentManager fragment_Manager;
        public FragmentTransaction fragment_Transaction;
        public SignUp() {
        }
        private Button bt_sign;
        private TextView tx;
        private Button bt_next;
        public FragmentManager fragmentManager;
        public FragmentTransaction fragmentTransaction;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_signup, container, false);
            android.support.v4.app.Fragment fragment = new SignUpChoose();
            fragmentManager = getActivity().getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            return rootView;
        }
    }
    public static class SignUpChoose extends Fragment {
        public FragmentManager fragment_Manager;
        public FragmentTransaction fragment_Transaction;
        public SignUpChoose() {
        }
        private Button bt_sign;
        private TextView tx;
        private Button bt_next;
        public FragmentManager fragmentManager;
        public FragmentTransaction fragmentTransaction;
        public ImageView img_company;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_choose_signup, container, false);
            FrameLayout fm= (FrameLayout) rootView.findViewById(R.id.company_signup);
            tx=(TextView)fm.findViewById(R.id.textView48);
            if (!QuizGlobal.getCmp_name().equals(""))
            tx.setText(QuizGlobal.getCmp_name());
            img_company=(ImageView)fm.findViewById(R.id.imageView27);
            img_company.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.support.v4.app.Fragment fragment1 = new SignUpChoose();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment1);
                    fragmentTransaction.commit();

                   android.support.v4.app.Fragment fragment = new SignUpCompany();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.company_signup, fragment);
                    fragmentTransaction.commit();





                }
            });
            FrameLayout fm2= (FrameLayout) rootView.findViewById(R.id.employee_signup);

            img_company=(ImageView)fm2.findViewById(R.id.imageView26);

            img_company.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(QuizGlobal.getCmp_name().equals(""))
                    {
                        Toast.makeText(getActivity(),"Please Select Company First",Toast.LENGTH_SHORT).show();
                    }else {
                    android.support.v4.app.Fragment fragment1 = new SignUpChoose();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment1);
                    fragmentTransaction.commit();
                    android.support.v4.app.Fragment fragment = new SignUpEmployee();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.employee_signup, fragment);
                    fragmentTransaction.commit();
                    }


                }
            });
            return rootView;
        }
    }
    public static class SignUpCompany extends Fragment {
        public FragmentManager fragment_Manager;
        public FragmentTransaction fragment_Transaction;
        public SignUpCompany() {
        }
        private Button bt_sign;
        private TextView tx;
        private Button bt_next;
        public FragmentManager fragmentManager;
        public FragmentTransaction fragmentTransaction;
        public ImageView img_company;
        public Spinner sp_company;
        private String []comp={"","Company 1","Company 2","Company 3"};
        private int [] avilable={0,8,5,12};
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_signp_company, container, false);
                sp_company= (Spinner) rootView.findViewById(R.id.spinner2);
                tx=(TextView)rootView.findViewById(R.id.textView50);
                sp_company.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        QuizGlobal.setCmp_name(comp[position]);
                        tx.setVisibility(View.VISIBLE);
                        tx.setText(avilable[position]+" more seats available");
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            return rootView;
        }
    }
    public static class SignUpEmployee extends Fragment {
        public FragmentManager fragment_Manager;
        public FragmentTransaction fragment_Transaction;
        public SignUpEmployee() {
        }
        private Button bt_sign;
        private TextView tx;
        private Button bt_next;
        public FragmentManager fragmentManager;
        public FragmentTransaction fragmentTransaction;
        public ImageView img_company;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_signup_employee, container, false);

            return rootView;
        }
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PlaceholderFragment())
                .commit();
    }
}
