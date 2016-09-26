package rootflyinfo.com.gamification;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import rootflyinfo.com.aoa.AOADashboard;
import rootflyinfo.com.fragment.Info;
import rootflyinfo.com.fragment.NoFragment;
import rootflyinfo.com.fragment.SliderFragmentOne;
import rootflyinfo.com.utils.GlobalColor;


public class MainActivity extends Fragment {

    private static TextView mTitleTextView;
    private  ViewPager mPager;
    private ImageView img,img_second,img_third,img_fourth,img_fifth;
    private LinearLayout linearLayout;
    private static final int NUM_PAGES = 5;
    private PagerAdapter mPagerAdapter;
    private RelativeLayout rb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView=inflater.inflate(R.layout.activity_main, container, false);
        rb=(RelativeLayout)convertView.findViewById(R.id.training_back);
        rb.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
       linearLayout= (LinearLayout) convertView.findViewById(R.id.linearLayout);
        img=(ImageView)linearLayout.findViewById(R.id.imageView2);
        img_second=(ImageView)linearLayout.findViewById(R.id.imageView3);
        img_third=(ImageView)linearLayout.findViewById(R.id.imageView4);
        img_fourth=(ImageView)linearLayout.findViewById(R.id.imageView5);
        img_fifth=(ImageView)linearLayout.findViewById(R.id.imageView6);
        img.setImageResource(R.drawable.circle_selected);
        ((AOADashboard)getActivity()).setTitle("AREAS DO FASNCAOAO");
         mPager = (ViewPager) convertView.findViewById(R.id.pager_introduction);
        StateListDrawable bgShape = (StateListDrawable) mPager.getBackground();
        bgShape.setColorFilter(Color.parseColor(GlobalColor.getForeground()), PorterDuff.Mode.SRC_IN);

        mPagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("message",""+position);
                recolor();
                if(position==1){((AOADashboard)getActivity()).setTitle("REFLEX");img_second.setImageResource(R.drawable.circle_selected);}
                if(position==2){((AOADashboard)getActivity()).setTitle("REFLEX");img_third.setImageResource(R.drawable.circle_selected);}
                if(position==3){((AOADashboard)getActivity()).setTitle("REFLEX");img_fourth.setImageResource(R.drawable.circle_selected);}
                if(position==4){((AOADashboard)getActivity()).setTitle("REFLEX");img_fifth.setImageResource(R.drawable.circle_selected);}
                if(position==0){((AOADashboard)getActivity()).setTitle("AREAS DO FASNCAOAO");img.setImageResource(R.drawable.circle_selected);}
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return convertView;
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
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==1)
            {  return new Info();}
            else
            if(position==0)
            {return new SliderFragmentOne();}
            else
            { return new NoFragment();}
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    void recolor()
    {
     img_second.setImageResource(R.drawable.circle_unselected);
      img_third.setImageResource(R.drawable.circle_unselected);
      img_fourth.setImageResource(R.drawable.circle_unselected);
      img_fifth.setImageResource(R.drawable.circle_unselected);
      img.setImageResource(R.drawable.circle_unselected);
    }
}
