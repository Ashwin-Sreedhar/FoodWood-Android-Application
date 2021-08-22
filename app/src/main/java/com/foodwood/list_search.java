package com.foodwood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.androidnetworking.AndroidNetworking.post;

public class list_search extends AppCompatActivity {
    ListView listView;
    ArrayList<module_list_search> mod_list;
    private adapter_search mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_search);
        String categoryName=getIntent().getStringExtra("search_value");
        listView = findViewById(R.id.list_search);
        mod_list=new ArrayList<>();


        post(Config.baseURL + "search.php")
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
                                    mod_list.add(new module_list_search(s,link));

                                    Log.d("Recipe Name",recipe.getString("recipename"));
                                }

                                Log.d("king", "onResponse:");
//                                JSONArray recipe = response.getJSONArray("recipe");
                            }else{
                                Toast.makeText(list_search.this, "No Data Found", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (JSONException e){
                            Log.e("JSONError","Error while parsing json",e);
                        }

                        mAdapter=new adapter_search(list_search.this,mod_list);
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
