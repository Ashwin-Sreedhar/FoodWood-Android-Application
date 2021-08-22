package com.foodwood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import static com.androidnetworking.AndroidNetworking.*;

public class registration extends AppCompatActivity {
    Button b;
    EditText name,username,phoneno,email,password,confirmpssword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        b = findViewById(R.id.regi);
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        phoneno = findViewById(R.id.phone_number);
        confirmpssword=findViewById(R.id.confirmpass);
        password =findViewById(R.id.password);
        //final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l = name.getText().toString();
                String m = email.getText().toString();
                String n = phoneno.getText().toString();
                String o = username.getText().toString();
                String p = password.getText().toString();
                String q = confirmpssword.getText().toString();

                String MobilePattern = "[0-9]{10}";
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (l.equals("") || m.equals("") || n.equals("") || o.equals("") || p.equals("") || q.equals(""))
                {
                    Toast.makeText(registration.this, "Incomplete Detail", Toast.LENGTH_SHORT).show();
                }

                else if (!phoneno.getText().toString().matches(MobilePattern))
                {
                    Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
                }

                else if(!email.getText().toString().matches(emailPattern))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Valid Email Address",Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(registration.this, "Loading", Toast.LENGTH_SHORT).show();
                    if (password.getText().toString().equals(confirmpssword.getText().toString()))
                        post(Config.baseURL + "registration.php")
                                .addBodyParameter("name", name.getText().toString())
                                .addBodyParameter("username", username.getText().toString())
                                .addBodyParameter("phoneno", phoneno.getText().toString())
                                .addBodyParameter("email", email.getText().toString())
                                .addBodyParameter("password", password.getText().toString())
                                .setTag("test")
                                .setPriority(Priority.MEDIUM)
                                .build()
                                .getAsJSONObject(new JSONObjectRequestListener() {
                                    @Override
                                    public void onResponse(JSONObject response) {

                                        try{
                                            if(response.getString("status").equals("success")){
                                                Toast.makeText(registration.this, "Successfully Registered", Toast.LENGTH_SHORT).show();

                                                Intent i1 = new Intent(registration.this,MainActivity.class);
                                                startActivity(i1);
                                            }else{
                                                Toast.makeText(registration.this, "Duplicate Data", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                        catch (JSONException e){
                                            Log.e("JSONError","Error while parsing json",e);
                                        }

                                        //Toast.makeText(registration.this, "Successfully Registered", Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onError(ANError error) {
                                        // handle error
                                        Log.e("Error", error.getMessage(), error);
                                        Toast.makeText(registration.this, "Server Error", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    else {
                        Toast.makeText(registration.this, "Confirm Your Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }


}
