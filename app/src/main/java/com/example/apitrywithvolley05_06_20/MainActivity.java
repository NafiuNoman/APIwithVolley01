package com.example.apitrywithvolley05_06_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display= findViewById(R.id.showtxt);

        RequestQueue requestQueue;

        requestQueue= Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos/1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                  //  Log.d("myapp", "This is the response" + response.getString("title"));

                    String n= response.getString("title");
                    String x= response.getString("completed");

                 //trick to display two value in single display with enter;
                    display.setText(n+"\n\n"+x);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },new  Response.ErrorListener()
        {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp","Somthing went wrong");

            }
        }


                );


        requestQueue.add(jsonObjectRequest);

    }
}


//This my first try with JSONplacholder(Fake api) with volley.
