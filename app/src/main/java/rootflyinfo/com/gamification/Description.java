package rootflyinfo.com.gamification;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import rootflyinfo.com.fragment.Characteristics;
import rootflyinfo.com.fragment.PlaceholderFragment;
import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.GlobalColor;

public class Description extends ActionBarActivity {

    private ProgressBar progressBar;
    private Dialog dialog_event;
    private Button bt_close;
    private TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='"+GlobalColor.getHeader_text()+"'>Canon Eos 700D </font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(GlobalColor.getHeader())));
        dialog_event=new Dialog(this);
        dialog_event.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_event.setContentView(R.layout.dialog_quiz);
        setContentView(R.layout.activity_description);
        bt_close=(Button)dialog_event.findViewById(R.id.button5);
        tx=(TextView)dialog_event.findViewById(R.id.textView32);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_event.dismiss();
            }
        });
        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(10);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_description, menu);
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
           dialog_event.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */


}
