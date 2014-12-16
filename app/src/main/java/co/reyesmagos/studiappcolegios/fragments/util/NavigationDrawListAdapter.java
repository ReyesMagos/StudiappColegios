package co.reyesmagos.studiappcolegios.fragments.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by Alexis-PC on 29/11/2014.
 */
public class NavigationDrawListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavigationDrawItem> navDrawItems;

    public NavigationDrawListAdapter(Context context, ArrayList<NavigationDrawItem> navDrawerItems){
        this.context = context;
        this.navDrawItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawItems.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return navDrawItems.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView imageIcon = (ImageView)convertView.findViewById(R.id.icon);
        TextView textViewTitle = (TextView)convertView.findViewById(R.id.title);
        TextView textViewCount = (TextView)convertView.findViewById(R.id.counter);

        imageIcon.setImageResource(navDrawItems.get(position).getIcon());
        textViewTitle.setText(navDrawItems.get(position).getTitle());

        if(navDrawItems.get(position).isCounterVisible()){
            textViewCount.setText(navDrawItems.get(position).getCount());
        }else {
            textViewCount.setVisibility(View.GONE);
        }

        return convertView;
    }
}
