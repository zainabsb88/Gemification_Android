package rootflyinfo.com.drawermenu;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import rootflyinfo.com.adapter.DashboardGridAdapter;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;

public class Dashboard extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RelativeLayout rf,rb;
// TODO: Rename and change types and number of parameters
    public static Dashboard newInstance(String param1, String param2) {
        Dashboard fragment = new Dashboard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Dashboard() {
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
   // private EditText et,et2,et3,et4;
   // private TextView tx,tx1,tx2,tx3;
    String score[]={"1037","27","76"};
    String title[]={"Score","Likes","Evolution"};
    private GridView gd_dash;
    private RelativeLayout rl_level;
    private ProgressBar pb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_dashboard_new, container, false);
        gd_dash=(GridView)rootView.findViewById(R.id.gridView5);
        rl_level=(RelativeLayout)rootView.findViewById(R.id.relative_levels);
        pb=(ProgressBar) rl_level.findViewById(R.id.progressBar2);
        gd_dash.setAdapter(new DashboardGridAdapter(getActivity(),score,title));









      /*  rf=(RelativeLayout)rootView.findViewById(R.id.dashboard_for) ;
        rb=(RelativeLayout)rootView.findViewById(R.id.dashboard_back) ;
        rb.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
        StateListDrawable bgShape = (StateListDrawable) rf.getBackground();
        bgShape.setColorFilter(Color.parseColor(GlobalColor.getForeground()), PorterDuff.Mode.SRC_IN);

        et=(EditText)rootView.findViewById(R.id.editText7);
        et2=(EditText)rootView.findViewById(R.id.editText8);
        et3=(EditText)rootView.findViewById(R.id.editText9);
        et4=(EditText)rootView.findViewById(R.id.editText10);
        tx=(TextView) rootView.findViewById(R.id.textView61);
        tx1=(TextView) rootView.findViewById(R.id.textView62);
        tx2=(TextView) rootView.findViewById(R.id.textView63);
        tx3=(TextView) rootView.findViewById(R.id.textView64);
         et.setEnabled(false);


        et.setText("John Doe");
        et2.setText("Company 2");
        et3.setEnabled(false);
        et3.setText("Project Manager");
        et2.setEnabled(false);
        et4.setText("Project in progress");
        et4.setEnabled(false);
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    et.setEnabled(false);
            }
        });
        et2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    et2.setEnabled(false);
            }
        });
        et3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    et3.setEnabled(false);
            }
        });
        et4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    et4.setEnabled(false);
            }
        });
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.isEnabled())
                {
                    et.setEnabled(false);
                    tx.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.compose), null);

                }else {
                    et.setEnabled(true);
                    tx.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.success), null);
                }
            }
        });
        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et2.isEnabled())
                {
                    et2.setEnabled(false);
                    tx1.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.compose), null);

                }else {
                    et2.setEnabled(true);
                    tx1.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.success), null);
                }
            }
        });
        tx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et3.isEnabled())
                {
                    et3.setEnabled(false);
                    tx2.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.compose), null);

                }else {
                    et3.setEnabled(true);
                    tx2.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.success), null);
                }
            }
        });
        tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et4.isEnabled())
                {
                    et4.setEnabled(false);
                    tx3.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.compose), null);

                }else {
                    et4.setEnabled(true);
                    tx3.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getResources().getDrawable(R.drawable.success), null);
                }
            }
        });*/

        return rootView;
    }
    class ProgressDrawable extends Drawable {
        private static final int NUM_SEGMENTS = 4;
        private final int mForeground;
        private final int mBackground;
        private final Paint mPaint = new Paint();
        private final RectF mSegment = new RectF();

        public ProgressDrawable(int fgColor, int bgColor) {
            mForeground = fgColor;
            mBackground = bgColor;
        }

        @Override
        protected boolean onLevelChange(int level) {
            invalidateSelf();
            return true;
        }

        @Override
        public void draw(Canvas canvas) {
            float level = getLevel() / 10000f;
            Rect b = getBounds();
            float gapWidth = b.height() / 3f;
            float segmentWidth = (b.width() - (NUM_SEGMENTS - 1) * gapWidth) / NUM_SEGMENTS;
            mSegment.set(0, 0, segmentWidth, b.height());
            mPaint.setColor(mForeground);

            for (int i = 0; i < NUM_SEGMENTS; i++) {
                float loLevel = i / (float) NUM_SEGMENTS;
                float hiLevel = (i + 1) / (float) NUM_SEGMENTS;
                if (loLevel <= level && level <= hiLevel) {
                    float middle = mSegment.left + NUM_SEGMENTS * segmentWidth * (level - loLevel);
                    canvas.drawRect(mSegment.left, mSegment.top, middle, mSegment.bottom, mPaint);
                    mPaint.setColor(mBackground);
                    canvas.drawRect(middle, mSegment.top, mSegment.right, mSegment.bottom, mPaint);
                } else {
                    canvas.drawRect(mSegment, mPaint);
                }
                mSegment.offset(mSegment.width() + gapWidth, 0);
            }
        }

        @Override
        public void setAlpha(int alpha) {
        }

        @Override
        public void setColorFilter(ColorFilter cf) {
        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSLUCENT;
        }
    }

}
