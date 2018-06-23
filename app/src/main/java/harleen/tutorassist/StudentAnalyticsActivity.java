package harleen.tutorassist;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RetryPolicy;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class StudentAnalyticsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    List<WorkHistoryUtils> workHistoryUtilsList;

    RequestQueue rq;

    String request_url = "http://192.168.0.1/feed.php";
//    FloatingActionButton fab = findViewById(R.id.fab);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_analytics_page);

//        // Get the Intent that started this activity and extract the string
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.student_id);
//
//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView);
//        textView.setText("Student " + message + "'s performance graph");
//
//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graph.addSeries(series);
//        // styling series
//        series.setTitle("Random Curve 1");
//        series.setColor(Color.GREEN);
//        series.setDrawDataPoints(true);
//        series.setDataPointsRadius(10);
//        series.setThickness(8);
//
//        // custom paint to make a dotted line
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10);
//        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
//        series.setCustomPaint(paint);

        // Load work history

        rq = Volley.newRequestQueue(this);


        recyclerView =  findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        workHistoryUtilsList = new ArrayList<>();



        sendRequest();

//        //floating action button
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    WorkHistoryUtils workHistoryUtils = new WorkHistoryUtils();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        workHistoryUtils.setWorkname(jsonObject.getString("workname"));
                        workHistoryUtils.setType(jsonObject.getString("type"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    workHistoryUtilsList.add(workHistoryUtils);

                }

                adapter = new WorkHistoryAdapter(StudentAnalyticsActivity.this, workHistoryUtilsList);

                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", "error:" + error);
            }
        });

        rq.add(jsonArrayRequest);
        

    }


}
