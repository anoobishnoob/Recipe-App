package io.github.anoobishnoob.recipeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import static io.github.anoobishnoob.recipeapp.Recipes.directions;

/**
 * Created by saqan on 8/7/2018.
 */

public class DirectionsFragment extends CheckBoxesFragment{
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
    
}
