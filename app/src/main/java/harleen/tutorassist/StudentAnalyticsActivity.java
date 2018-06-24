package harleen.tutorassist;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;


public class StudentAnalyticsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WorkHistoryAdapter adapter;
    private List<WorkHistoryItem> workHistList;

//    FloatingActionButton fab = findViewById(R.id.fab);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_analytics_page);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.student_id);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText("Student " + message + "'s performance graph");

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
        // styling series
        series.setTitle("Random Curve 1");
        series.setColor(Color.GREEN);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);

        // custom paint to make a dotted line
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
        series.setCustomPaint(paint);


//        //floating action button
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        recyclerView = findViewById(R.id.recycler_view);

        workHistList = new ArrayList<>();
        adapter = new WorkHistoryAdapter(this, workHistList);
//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.addItemDecoration(new MainActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepWorkHistory();
    }
    private void prepWorkHistory() {

        WorkHistoryItem a = new WorkHistoryItem("math", "mcq", 15, 5);
        workHistList.add(a);

        a = new WorkHistoryItem("english", "video", 8, 3);
        workHistList.add(a);

        a = new WorkHistoryItem("english", "video", 11, 2);
        workHistList.add(a);

        a = new WorkHistoryItem("science", "word problems", 12, 3);
        workHistList.add(a);

        a = new WorkHistoryItem("math", "short answer", 20, 5);
        workHistList.add(a);

        a = new WorkHistoryItem("math", "video", 30, 2);
        workHistList.add(a);

        a = new WorkHistoryItem("science", "short answer", 30, 4);
        workHistList.add(a);

        adapter.notifyDataSetChanged();
    }


    }


