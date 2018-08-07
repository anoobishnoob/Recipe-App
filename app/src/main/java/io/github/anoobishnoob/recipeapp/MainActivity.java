package io.github.anoobishnoob.recipeapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface {
//extends AppCompatActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment savedFragment = (ListFragment) getFragmentManager().findFragmentById(R.id.placeholder); // this creates a saved instance of your fragment at OnCreate.

        if (savedFragment == null){ // code only launches once, so the fragments don't create new fragments when say rotating the screen, if this is null it will come in this code block
            ListFragment fragment = new ListFragment();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder, fragment);
            fragmentTransaction.commit();
        }



    }

    @Override
    public void onListRecipeSelected(int index) {
        Toast.makeText(MainActivity.this, Recipes.names[index], Toast.LENGTH_LONG).show();
    }
}
