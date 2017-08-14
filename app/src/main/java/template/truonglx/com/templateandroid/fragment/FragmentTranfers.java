package template.truonglx.com.templateandroid.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import template.truonglx.com.templateandroid.R;
import template.truonglx.com.templateandroid.fragment.tranfers.*;

/**
 * Created by truonglx on 14/08/2017.
 */

public class FragmentTranfers extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tranfers, container, false);
        setHasOptionsMenu(true);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        Log.v("Layout", "Tabs");
        tabs = (TabLayout) view.findViewById(R.id.tabs);
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        tabs.setTabTextColors(Color.parseColor("#707070"), Color.parseColor("#FFFFFF"));
        assert viewPager != null;
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new FragmentMyDevices(), "My Devices");
        adapter.addFragment(new FragmentFriends(), "Friends");
        adapter.addFragment(new FragmentNearby(), "Nearby");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
