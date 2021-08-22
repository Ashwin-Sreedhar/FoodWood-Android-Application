package com.foodwood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.androidnetworking.AndroidNetworking.post;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Button b =findViewById(R.id.Video);
        String categoryName=getIntent().getStringExtra("recipe_name");
        TextView t = findViewById(R.id.recipename);
        final TextView ingre = findViewById(R.id.ingredients);
        final TextView maint = findViewById(R.id.mainrecipename);
        post(Config.baseURL + "recipedetail.php")
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
                                    final JSONObject recipe=recipes.optJSONObject(i);
                                    Log.d("detail",recipe.toString());
                                    ingre.setText(recipe.getString("ingredients"));
                                    maint.setText(recipe.getString("method"));

                                    b.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            try {
                                                watchYoutubeVideo(getApplicationContext(),recipe.getString("videolink"));
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });

                                }

                            }else{
                                Toast.makeText(detail.this, "No Data Found", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (JSONException e){
                            Log.e("JSONError","Error while parsing json",e);
                        }

                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.e("Error", error.getMessage(), error);
                    }

                });

        Log.d("name_yes",categoryName);
        t.setText(categoryName);

    }
    public static void watchYoutubeVideo(Context context, String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        appIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        webIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
        }
    }
}
