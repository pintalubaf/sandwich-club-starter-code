package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            Sandwich sandwich = new Sandwich();

            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameJsonObject = jsonObject.getJSONObject("name");

            sandwich.setMainName(nameJsonObject.getString("mainName"));

            List<String> alsoKnownAs = new ArrayList<>();
            JSONArray alsoKnownAsJsonArray = nameJsonObject.getJSONArray("alsoKnownAs");
            if (alsoKnownAsJsonArray != null) {
                for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                    alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
                }
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);

            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(jsonObject.getString("description"));
            sandwich.setImage(jsonObject.getString("image"));

            List<String> ingredients = new ArrayList<>();
            JSONArray ingredientsJsonArray = jsonObject.getJSONArray("ingredients");
            if (ingredientsJsonArray != null) {
                for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                    ingredients.add(ingredientsJsonArray.getString(i));
                }
            }
            sandwich.setIngredients(ingredients);

            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
