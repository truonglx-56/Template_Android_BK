package template.truonglx.com.templateandroid.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import template.truonglx.com.templateandroid.MainActivity;
import template.truonglx.com.templateandroid.R;
import template.truonglx.com.templateandroid.adapter.CustomAndroidGridViewAdapter;

/**
 * Created by truonglx on 14/08/2017.
 */

public class FragmentTool extends Fragment {
    Toolbar toolbar;
    GridView gridView;
    CoordinatorLayout rootLayoutAndroid;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;

    ArrayList arrayList;

    public static String[] gridViewStrings = {
            "File",
            "Record Screen",
            "Backup",
            "Booster",
            "Find Phone",
            "Tethering",
            "Desktop Notif"


    };
    public static int[] gridViewImages = {
            R.drawable.a_avator,
            R.drawable.a_avator,
            R.drawable.a_avator,
            R.drawable.a_avator,
            R.drawable.a_avator,
            R.drawable.a_avator,
            R.drawable.a_avator,

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        gridView = (GridView) view.findViewById(R.id.grid);
        initInstances(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = (GridView) view.findViewById(R.id.grid);
        final CustomAndroidGridViewAdapter customAndroidGridViewAdapter = new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages);
        gridView.setAdapter(customAndroidGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getContext(), "----" + position + "-----" + customAndroidGridViewAdapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
                if (customAndroidGridViewAdapter.getItem(position).equals(gridViewStrings[5])) {
                    Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            }
        });

    }

    private void initInstances(View view) {
        rootLayoutAndroid = (CoordinatorLayout) view.findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_android_layout);

    }
}
