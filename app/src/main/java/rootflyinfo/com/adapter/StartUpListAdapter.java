package rootflyinfo.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import rootflyinfo.com.gamification.R;

/**
 * Created by Mithun Manoharan on 8/22/2016.
 */
public class StartUpListAdapter extends BaseAdapter{

    private int[] img_resource={R.mipmap.ic_book,R.mipmap.ic_music,R.mipmap.ic_game,R.mipmap.ic_gallery,R.mipmap.ic_tv};
    private String[] tx_resource={"Livros e Papelaria","Música e Instrumentos","Gaming e Videojogos","Foto e Vídeo","Filmes e Séries TV"};
    private LayoutInflater inflater;
    private Context c;
    private ImageView img;
    private TextView tx_title;

    public StartUpListAdapter(Context c) {
        this.c = c;
        inflater = LayoutInflater.from(c);

    }
    @Override
    public int getCount() {
        return img_resource.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.startup_listview_element, parent, false);
        img=(ImageView)convertView.findViewById(R.id.imageView7);
        tx_title=(TextView)convertView.findViewById(R.id.textView2);
        img.setImageResource(img_resource[position]);
        tx_title.setText(tx_resource[position]);
        return convertView;
    }
}
