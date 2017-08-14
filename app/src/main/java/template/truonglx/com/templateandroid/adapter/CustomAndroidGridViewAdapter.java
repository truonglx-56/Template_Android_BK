package template.truonglx.com.templateandroid.adapter;

/**
 * Created by truonglx on 14/08/2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import template.truonglx.com.templateandroid.R;
import template.truonglx.com.templateandroid.fragment.FragmentTool;

/**
 * Created by HP on 5/11/2016.
 */

public class CustomAndroidGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] string;
    private final int[] Imageid;

    public CustomAndroidGridViewAdapter(FragmentTool c, String[] string, int[] Imageid) {
        mContext = c.getContext();
        this.Imageid = Imageid;
        this.string = string;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int p) {
        return string[p];
    }

    @Override
    public long getItemId(int p) {
        return string[p].hashCode();
    }

    @Override
    public View getView(int p, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item_tool, null);
            TextView textView = (TextView) grid.findViewById(R.id.gridview_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.gridview_image);
            textView.setText(string[p]);
            imageView.setImageResource(Imageid[p]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}