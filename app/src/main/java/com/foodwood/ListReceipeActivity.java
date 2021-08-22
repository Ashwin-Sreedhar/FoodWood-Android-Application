package com.foodwood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.androidnetworking.AndroidNetworking.post;

public class ListReceipeActivity extends AppCompatActivity {
    public ListView listView;

    private ArrayList<module_list> mod_list;

    private adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_receipe);
        String categoryName=getIntent().getStringExtra("category");
        listView = findViewById(R.id.list);
        mod_list=new ArrayList<>();


        post(Config.baseURL + "FetchRecipe.php")
                .addBodyParameter("value", categoryName)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try{
                            if(response.getString("status").equals("success")){
                                JSONArray recipes=response.getJSONArray("recipe");
                                for(int i=0;i<recipes.length();i++){
                                    Log.d("Recipe",recipes.get(i).toString());
                                    JSONObject recipe=recipes.optJSONObject(i);
                                    String s = recipe.getString("recipename");
                                    String link = recipe.getString("image");
                                    mod_list.add(new module_list(s,link));

                                    Log.d("Recipe Name",recipe.getString("recipename"));
                                }

                                Log.d("king", "onResponse:");
//                                JSONArray recipe = response.getJSONArray("recipe");
                            }else{
                                Toast.makeText(ListReceipeActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (JSONException e){
                            Log.e("JSONError","Error while parsing json",e);
                        }

                        mAdapter=new adapter(ListReceipeActivity.this,mod_list);
                        listView.setAdapter(mAdapter);


                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.e("Error", error.getMessage(), error);
                    }

                });




    }
}
