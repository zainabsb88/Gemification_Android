package rootflyinfo.com.adapter;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import rootflyinfo.com.gamification.R;

/**
 * Created by Mithun Manoharan on 8/23/2016.
 */
public class FourthGridAdapter extends BaseAdapter {

   private int[] img_resource={R.mipmap.ic_g1,R.mipmap.ic_g2,R.mipmap.ic_g3,R.mipmap.ic_g5,R.mipmap.ic_g6,R.mipmap.ic_g7,R.mipmap.ic_g8,R.mipmap.ic_g9,R.mipmap.ic_g4};
    private Context c;
    private LayoutInflater inflater;
    private ImageView img;
    private Dialog d;
    private int request;
    public FourthGridAdapter(Context c,int request){
    this.c=c;
    this.request=request;
    this.inflater=LayoutInflater.from(c);

    d=new Dialog(c);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    @Override
    public int getCount() {
        return img_resource.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private ImageView d_img;
    private Button b1;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = inflater.inflate(R.layout.layout_gridelement_charcteristics, parent, false);
        img=(ImageView)rootView.findViewById(R.id.imageView13);
        img.setTag(position);

       d.setContentView(R.layout.dialog_gridview);

        d_img= (ImageView) d.findViewById(R.id.imageView14);
        b1=(Button)d.findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        img.setImageResource(img_resource[position]);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k= (int) v.getTag();
                d_img.setImageResource(img_resource[k]);
                    d.show();
            }
        });
        return rootView;
    }
}
