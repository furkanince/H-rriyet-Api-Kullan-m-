package com.example.furkan.apiexample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.furkan.apiexample.Adapter.HisseAdapter;
import com.example.furkan.apiexample.Classes.Hisse;
import com.example.furkan.apiexample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HisseAdapter mHisseAdapter;
    private ArrayList<Hisse> mHisseList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hurriyet Api Uygulaması(Hissedarlar)");


        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mHisseList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);

        parseJSON();
    }
    private void parseJSON() {
        String url = "http://bigpara.hurriyet.com.tr/api/v1/hisse/list";

        JsonObjectRequest request =  new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject datas = jsonArray.getJSONObject(i);

                                String sirket_ismi = datas.getString("ad");
                                String sirket_kodu = datas.getString("kod");
                                String sirket_tipi = datas.getString("tip");

                                mHisseList.add(new Hisse(sirket_kodu,sirket_ismi,sirket_tipi));

                            }
                            mHisseAdapter = new HisseAdapter(MainActivity.this,mHisseList);
                            mRecyclerView.setAdapter(mHisseAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);

    }

}
