package ch.heig_vd.iict.sym_exercice2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import ch.heig_vd.iict.sym_exercice2.fragments.ImageFragment;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                CharSequence sTitle = mSectionsPagerAdapter.getPageTitle(position);
                try {
                    getSupportActionBar().setSubtitle(sTitle);
                } catch(NullPointerException e) { /* BEST EFFORT */ }
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });

        //init subtitle with first fragment title
        CharSequence sTitle = mSectionsPagerAdapter.getPageTitle(0);
        try {
            getSupportActionBar().setSubtitle(sTitle);
        } catch(NullPointerException e) { /* BEST EFFORT */ }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final String[] sections = {
                getString(R.string.sct_0),
                getString(R.string.sct_2),
                getString(R.string.sct_3),
        };

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return ImageFragment.newInstance(ImageFragment.Type.RESOURCES);
                case 1:
                    return ImageFragment.newInstance(ImageFragment.Type.ASYNCTASK);
                case 2:
                    return ImageFragment.newInstance(ImageFragment.Type.THREAD_EXECUTOR);
            }
            return null; //FIXME
        }

        @Override
        public int getCount() {
            return sections.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sections[position];
        }
    }
}
