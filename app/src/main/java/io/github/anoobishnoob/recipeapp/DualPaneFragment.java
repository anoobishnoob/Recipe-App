package io.github.anoobishnoob.recipeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static io.github.anoobishnoob.recipeapp.ViewPagerFragment.KEY_RECIPE_INDEX;

/**
 * Created by saqan on 8/9/2018.
 */

public class DualPaneFragment extends Fragment {

    private String INGREDIENTS_FRAGMENT = "ingredients_fragment";
    private String DIRECTIONS_FRAGMENT = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        //Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_LONG).show(); for debugging
        getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_dualpane, container, false); // create the view, and basically attaches the view onto the farment_viewpager

        FragmentManager fragmentManager = getChildFragmentManager();

        IngredientsFragment savedIngredientsFragment = (IngredientsFragment) fragmentManager.findFragmentByTag(INGREDIENTS_FRAGMENT);
        if (savedIngredientsFragment == null){
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX, index);
            ingredientsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.leftPlaceholder, ingredientsFragment, INGREDIENTS_FRAGMENT)
                    .commit();
        }

        DirectionsFragment savedDirectionsFragment = (DirectionsFragment) fragmentManager.findFragmentByTag(DIRECTIONS_FRAGMENT);
        if (savedDirectionsFragment == null){
            DirectionsFragment directionsFragment = new DirectionsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX, index);
            directionsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.rightPlaceholder, directionsFragment, DIRECTIONS_FRAGMENT)
                    .commit();
        }

/* used as reference
        final IngredientsFragment ingredientsFragment = new IngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        ingredientsFragment.setArguments(bundle);
        final DirectionsFragment directionsFragment = new DirectionsFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        directionsFragment.setArguments(bundle);
*/
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }


}
