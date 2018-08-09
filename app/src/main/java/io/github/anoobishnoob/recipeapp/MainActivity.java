package io.github.anoobishnoob.recipeapp;

//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface{
public static final String LIST_FRAGMENT = "list_fragment";
public static final String VIEWPAGER_FRAGMENT = "view_fragment"; // ctrl+D duplicates a line
//public static final String LIST_FRAGMENT = "listfragment";
//public static final String LIST_FRAGMENT = "listfragment";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        //Toast.makeText(this,isTablet +"" , Toast.LENGTH_SHORT).show();
        if (!isTablet){
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager()
                    .findFragmentByTag(LIST_FRAGMENT); // this creates a saved instance of your fragment at OnCreate.

            if (savedFragment == null){ // code only launches once, so the fragments don't create new fragments when say rotating the screen, if this is null it will come in this code block
                ListFragment fragment = new ListFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeholder, fragment, LIST_FRAGMENT); // these PSFS give it something to identify with, and make it so these are just using key value pairs to identify it
                fragmentTransaction.commit();
            }
        }
        else{
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager()
                    .findFragmentByTag(LIST_FRAGMENT); // this creates a saved instance of your fragment at OnCreate.

            if (savedFragment == null){ // code only launches once, so the fragments don't create new fragments when say rotating the screen, if this is null it will come in this code block
                GridFragment fragment = new GridFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeholder, fragment, LIST_FRAGMENT); // these PSFS give it something to identify with, and make it so these are just using key value pairs to identify it
                fragmentTransaction.commit();
            }
        }






    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {

    }
}
