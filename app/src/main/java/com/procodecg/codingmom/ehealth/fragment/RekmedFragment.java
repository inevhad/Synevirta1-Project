package com.procodecg.codingmom.ehealth.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.rekam_medis.RekmedDinamisFragment;
import com.procodecg.codingmom.ehealth.rekam_medis.RekmedStatisFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbookpro on 8/29/17.
 */

public class RekmedFragment extends Fragment {

    public static RekmedFragment newInstance() {
        RekmedFragment fragment = new RekmedFragment();
        return fragment;
    }
//
//    boolean buka = false;
//
//    //    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////
////    }
//
//    private SectionsPagerAdapter mSectionsPagerAdapter;
//
//    /**
//     * The {@link ViewPager} that will host the section contents.
//     */
//    private ViewPager mViewPager;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
////        // Create the adapter that will return a fragment for each of the three
////        // primary sections of the activity.
////        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
////
////        // Set up the ViewPager with the sections adapter.
////        mViewPager = (ViewPager) findViewById(R.id.container);
////        mViewPager.setAdapter(mSectionsPagerAdapter);
////
////        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
////        tabLayout.setupWithViewPager(mViewPager);
//
//
//    }
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        final View view = inflater.inflate(R.layout.rekmed, container, false);
//        ((BottombarActivity) getActivity()).setTitleText("Rekam Medis");
//        ((BottombarActivity) getActivity()).setSubTitleText();
//
//
//
////        Button btnStatis = (Button) view.findViewById(R.id.btnStatis);
////        final LinearLayout contentStatis = (LinearLayout) view.findViewById(R.id.contentStatis);
////
////        btnStatis.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                if(buka == false){
////                    contentStatis.setVisibility(View.VISIBLE);
////                    buka = true;
////                }else{
////                    contentStatis.setVisibility(View.GONE);
////                    buka = false;
////                }
////            }
////        });
////
////        Button btnDinamis = (Button) view.findViewById(R.id.btnDinamis);
////        final LinearLayout contentDinamis = (LinearLayout) view.findViewById(R.id.contentDinamis);
////
////        btnDinamis.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                if(buka == false){
////                    contentDinamis.setVisibility(View.VISIBLE);
////                    buka = true;
////                }else{
////                    contentDinamis.setVisibility(View.GONE);
////                    buka = false;
////                }
////            }
////        });
//
////        Button btnTambah = (Button)view.findViewById(R.id.btnTambah);
////        btnTambah.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent activity = new Intent(getActivity(), IsirekammedisActivity.class);
////                startActivity(activity);
////
////            }
////
////        });
////
////
//        return view;
//    }
//
//
//
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position){
//                case 0:
//                    return new RekmedStatisFragment();
//                case 1:
//                    return new RekmedDinamisFragment();
////                case 2:
////                    return new Tab3();
//            }
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 2;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "REKAM MEDIS DINAMIS";
//                case 1:
//                    return "REKAM MEDIS STATIS";
////                case 2:
////                    return "SECTION 3";
//            }
//            return null;
//        }
//    }
//}

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rekmed,container, false);
        ((BottombarActivity) getActivity()).setTitleText("Rekam Medis");
        ((BottombarActivity) getActivity()).setSubTitleText();

        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.result_tabs);
        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);


        return view;

    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {

        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new RekmedDinamisFragment(), "Dinamis");
        adapter.addFragment(new RekmedStatisFragment(), "Statis");
//        adapter.addFragment(new RMDinamis(), "Dinamis");
//        adapter.addFragment(new RMStatis(), "Statis");
        viewPager.setAdapter(adapter);
    }



    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(RekmedDinamisFragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        public void addFragment(RekmedStatisFragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}