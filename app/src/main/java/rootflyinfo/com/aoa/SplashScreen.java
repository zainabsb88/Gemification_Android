package rootflyinfo.com.aoa;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;

import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import rootflyinfo.com.gamification.R;
import rootflyinfo.com.utils.DbDynamic;
import rootflyinfo.com.utils.GlobalColor;

public class SplashScreen extends ActionBarActivity {

    ProgressBar mprogressBar;
    RelativeLayout relativeLayout;
    TextView tx_splash;
    ImageView img_splash;
    DbDynamic db;
     public static final String createProjectUrl="http://logicious.net/gamification/api/employee/app_layout/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DbDynamic(this);
        Cursor c = db.getAllUser();
        if (c.getCount() > 0) {
            while (c.moveToNext()) {
                GlobalColor.setHeader(c.getString(1));
                GlobalColor.setHeader_text(c.getString(2));
                GlobalColor.setForeground(c.getString(3));
                GlobalColor.setBackground(c.getString(4));
                GlobalColor.setContent(c.getString(5));
                GlobalColor.setLogo(c.getString(6));
                Log.e("Database Details", c.getString(1) + " " + c.getString(2) + " " + c.getString(3) + " " + c.getString(4) + " " + c.getString(5) + " " + c.getString(6));
            }
        } else
        {
            GlobalColor.setHeader("#FFFFFF");
            GlobalColor.setHeader_text("#E6AD22");
            GlobalColor.setForeground("#FFFFFF");
            GlobalColor.setBackground("#E6AD22");
            GlobalColor.setContent("#000000");
            GlobalColor.setLogo("");

        }
        getColoer();
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        mprogressBar = (ProgressBar) findViewById(R.id.progressBar);
        relativeLayout = (RelativeLayout) findViewById(R.id.splash_relative);
       tx_splash = (TextView) findViewById(R.id.gm);
       img_splash = (ImageView) findViewById(R.id.imageView28);
        if(!GlobalColor.getLogo().equals(""))
            loadImageFromStorage(GlobalColor.getLogo());

       relativeLayout.setBackgroundColor(Color.parseColor(GlobalColor.getBackground()));
       tx_splash.setBackgroundColor(Color.parseColor(GlobalColor.getContent()));

       LayerDrawable layer = (LayerDrawable) mprogressBar.getProgressDrawable();

       ClipDrawable shape = (ClipDrawable) layer
               .findDrawableByLayerId(android.R.id.progress);
       shape.setColorFilter(Color.parseColor("#469978"), PorterDuff.Mode.SRC_IN);

        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
        anim.setDuration(1800);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent=new Intent(SplashScreen.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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
    private String saveToInternalStorage(Bitmap bitmapImage) throws IOException {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"company.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
        Log.e("image directory",directory.getAbsolutePath());
        return directory.getAbsolutePath();
    }
    private void loadImageFromStorage(String path)
    {

        try {
            File f=new File(path, "company.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            img_splash.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    void getColoer()
    {
        StringRequest req = new StringRequest(Request.Method.POST, createProjectUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("responseLogin", response.toString());
                        try {
                            JSONObject jsonResponse = new JSONObject(response.toString());

                            for (int i = 0; i <jsonResponse.length(); i++) {
                                db.deleteData();
                               db.addData("Company 1",jsonResponse.getString("Header_Background_Color"),jsonResponse.getString("Heading_Text_Color"),jsonResponse.getString("App_Forground_Color"),jsonResponse.getString("App_Background_Color"),jsonResponse.getString("Content_Text_Color"),jsonResponse.getString("logo"));
                                getImage(jsonResponse.getString("logo"));

                            }

                            }catch (JSONException e){e.printStackTrace();}

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("error", error.toString());
                        if(error.toString().equals("com.android.volley.TimeoutError"))
                            Toast.makeText(SplashScreen.this,"Failed to connect please Logout or Try Again",Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params_ = new HashMap<String, String>();

                return params_;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        Volley.newRequestQueue(SplashScreen.this).add(req);
    }
    void getImage(String url)
    {
        ImageRequest ir = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                try {
                    db.updatelogo("Company 1",saveToInternalStorage(response));
                    Log.e("image found",""+response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 0, null, null);
        Volley.newRequestQueue(SplashScreen.this).add(ir);
    }
}
