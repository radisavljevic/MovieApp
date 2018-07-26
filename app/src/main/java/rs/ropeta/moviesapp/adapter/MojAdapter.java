package rs.ropeta.moviesapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import rs.ropeta.moviesapp.fragments.FavoriteFragment;
import rs.ropeta.moviesapp.fragments.PopularMovieFragment;
import rs.ropeta.moviesapp.fragments.SearchFragment;
import rs.ropeta.moviesapp.fragments.TopRatedMovieFragment;
import rs.ropeta.moviesapp.fragments.UpcomingFragment;

public class MojAdapter extends FragmentPagerAdapter {

    private String SearchText;

    public MojAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PopularMovieFragment();
            case 1:
                return new UpcomingFragment();
            case 2:
                return new TopRatedMovieFragment();
            case 3:
                return new FavoriteFragment();
            case 4:
                return new SearchFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "POPULAR";
            case 1:
                return "UP COMING";
            case 2:
                return "TOP RATED";
            case 3:
                return "FAVORITE";
            case 4:
                return "SEARCH";
            default:
                return null;
        }
    }
    public void setSearchText(String setSearchText){
        this.SearchText = setSearchText;
    }
}
