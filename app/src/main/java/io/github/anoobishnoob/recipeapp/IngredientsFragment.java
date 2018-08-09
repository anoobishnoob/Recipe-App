package io.github.anoobishnoob.recipeapp;

/**
 * Created by saqan on 8/9/2018.
 */

public class IngredientsFragment extends CheckBoxesFragment{
    @Override
    public String[] getContents(int index) {
       return Recipes.ingredients[index].split("`");
    }
}
