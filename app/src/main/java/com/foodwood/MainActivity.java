package com.foodwood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import static com.androidnetworking.AndroidNetworking.post;

public class MainActivity extends AppCompatActivity {
    TextView t;
    Button b;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.password);
        b = findViewById(R.id.b1);
        t = findViewById(R.id.signin);
        final ProgressDialog p=new ProgressDialog(MainActivity.this);
        p.setTitle("Loading");

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,registration.class);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = e1.getText().toString();
                String c = e2.getText().toString();
                if(a.equals("") || c.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Incomplete Detail", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Loading", Toast.LENGTH_SHORT).show();

                    p.show();
                    post(Config.baseURL + "log.php")
                            .addBodyParameter("username", e1.getText().toString())
                            .addBodyParameter("password", e2.getText().toString())
                            .setTag("test")
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    // do anything with response
                                    try{
                                        if(response.getString("status").equals("success")){
                                            p.dismiss();
                                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                            Intent i1 = new Intent(MainActivity.this,Mainhome.class);
                                            startActivity(i1);
                                        }else{
                                            Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                                            p.dismiss();
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
                                    Toast.makeText(MainActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                                }

                            });
                    }




//                    Intent i1 = new Intent(MainActivity.this, Mainhome.class);
//                    startActivity(i1);
                }

        });
    }

}
