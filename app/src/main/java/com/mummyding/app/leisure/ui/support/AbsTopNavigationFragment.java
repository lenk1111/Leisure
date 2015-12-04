package com.mummyding.app.leisure.ui.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mummyding.app.leisure.R;
import com.mummyding.app.leisure.support.Utils;
import com.mummyding.app.leisure.support.adapter.PagerAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by mummyding on 15-11-13.
 */
public abstract class AbsTopNavigationFragment extends Fragment{
    protected View parentView;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private SmartTabLayout smartTabLayout;
    protected abstract PagerAdapter initPagerAdapter();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //    setRetainInstance(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = View.inflate(getContext(), R.layout.layout_top_navigation,null);
        viewPager = (ViewPager) parentView.findViewById(R.id.inner_viewpager);
        smartTabLayout = (SmartTabLayout) getActivity().findViewById(R.id.tab_layout);
        smartTabLayout.setVisibility(View.VISIBLE);
        pagerAdapter = initPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        smartTabLayout.setViewPager(viewPager);
        return parentView;
    }
    public void onDestroyView() {
        super.onDestroyView();
        parentView = null;
        viewPager = null;
        pagerAdapter = null;
        smartTabLayout = null;
        Utils.DLog("special~~~~~~~~");
    }
}