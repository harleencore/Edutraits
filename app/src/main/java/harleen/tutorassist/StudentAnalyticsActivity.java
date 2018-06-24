package harleen.tutorassist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;


public class StudentAnalyticsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WorkHistoryAdapter adapter;
    private List<WorkHistoryItem> workHistList;
    String[] names = new String[]{
            "Abdul Nazrin",
            "Xiao Tong",
            "Derek Zoolander",
            "Xuan Wei",
            "Jamie Tan",
            "Zachary Tan",
            "Sophia Danial",
            "Kwan Ming"


    };

    FloatingActionButton fab;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_analytics_page);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.student_id);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(names[Integer.parseInt(message)]+ "'s performance chart");
        fab = findViewById(R.id.fab);
        int[][] graphData ={
                {2,5,6,2,5},
                {3,2,7,1,4},
                {2,3,6,2,4},
                {5,5,6,6,4},
                {6,3,7,7,1},
                {5,4,5,2,3},
                {6,1,4,6,6},
                {1,7,2,6,3}
                };

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {


                    new DataPoint(0, graphData[Integer.parseInt(message)][0]),
                    new DataPoint(1, graphData[Integer.parseInt(message)][1]),
                    new DataPoint(2, graphData[Integer.parseInt(message)][2]),
                    new DataPoint(3, graphData[Integer.parseInt(message)][3]),
                    new DataPoint(4, graphData[Integer.parseInt(message)][4])

        });
        graph.addSeries(series);
        // styling series
        series.setTitle("Random Curve 1");
        series.setColor(Color.RED);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);
//
//        // custom paint to make a dotted line
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10);
//        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
//        series.setCustomPaint(paint);


        //floating action button

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddItemDialog(StudentAnalyticsActivity.this);            }
        });


        recyclerView = findViewById(R.id.recycler_view);

        workHistList = new ArrayList<>();
        adapter = new WorkHistoryAdapter(this, workHistList);
//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepWorkHistory(Integer.parseInt(message));
    }
    private void prepWorkHistory(int i) {

        if (i == 0) {
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
            a = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(a);
            a = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(a);
            a = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(a);
            a = new WorkHistoryItem("english", "text", 10, 3);
            workHistList.add(a);
            a = new WorkHistoryItem("science", "word problems", 15, 3);
            workHistList.add(a);
            adapter.notifyDataSetChanged();
        }
        else if (i == 1){
            WorkHistoryItem b = new WorkHistoryItem("math", "mcq", 15, 5);
            workHistList.add(b);
            b = new WorkHistoryItem("english", "video", 8, 3);
            workHistList.add(b);
            b = new WorkHistoryItem("malay", "text", 6, 2);
            workHistList.add(b);
            b = new WorkHistoryItem("english", "video", 11, 2);
            workHistList.add(b);
            b = new WorkHistoryItem("science", "word problems", 12, 3);
            workHistList.add(b);
            b = new WorkHistoryItem("math", "short answer", 20, 5);
            workHistList.add(b);
            b = new WorkHistoryItem("math", "video", 30, 2);
            workHistList.add(b);
            b = new WorkHistoryItem("malay", "short answer", 15, 3);
            workHistList.add(b);
            b = new WorkHistoryItem("science", "short answer", 30, 4);
            workHistList.add(b);
            b = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(b);
            b = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(b);
            b = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(b);
            adapter.notifyDataSetChanged();
        }
        else if (i == 2){
            WorkHistoryItem c = new WorkHistoryItem("math", "mcq", 15, 5);
            workHistList.add(c);
            c = new WorkHistoryItem("english", "video", 8, 3);
            workHistList.add(c);
            c = new WorkHistoryItem("chinese", "text", 6, 2);
            workHistList.add(c);
            c = new WorkHistoryItem("english", "video", 11, 2);
            workHistList.add(c);
            c = new WorkHistoryItem("science", "word problems", 12, 3);
            workHistList.add(c);
            c = new WorkHistoryItem("math", "short answer", 20, 5);
            workHistList.add(c);
            c = new WorkHistoryItem("math", "video", 30, 2);
            workHistList.add(c);
            c = new WorkHistoryItem("chinese", "short answer", 15, 3);
            workHistList.add(c);
            c = new WorkHistoryItem("science", "short answer", 30, 4);
            workHistList.add(c);
            c = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(c);
            c = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(c);
            c = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(c);
            adapter.notifyDataSetChanged();
        }
        else if (i == 3){
            WorkHistoryItem d = new WorkHistoryItem("math", "mcq", 15, 5);
            workHistList.add(d);
            d = new WorkHistoryItem("english", "video", 8, 3);
            workHistList.add(d);
            d = new WorkHistoryItem("chinese", "text", 6, 2);
            workHistList.add(d);
            d = new WorkHistoryItem("english", "video", 11, 2);
            workHistList.add(d);
            d = new WorkHistoryItem("science", "word problems", 12, 3);
            workHistList.add(d);
            d = new WorkHistoryItem("math", "short answer", 20, 5);
            workHistList.add(d);
            d = new WorkHistoryItem("math", "video", 30, 2);
            workHistList.add(d);
            d = new WorkHistoryItem("chinese", "short answer", 15, 3);
            workHistList.add(d);
            d = new WorkHistoryItem("science", "short answer", 30, 4);
            workHistList.add(d);
            d = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(d);
            d = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(d);
            d = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(d);
            adapter.notifyDataSetChanged();
        }
        else if (i == 4){
            WorkHistoryItem e = new WorkHistoryItem("math", "mcq", 15, 5);
            workHistList.add(e);
            e = new WorkHistoryItem("english", "video", 8, 3);
            workHistList.add(e);
            e = new WorkHistoryItem("malay", "text", 6, 2);
            workHistList.add(e);
            e = new WorkHistoryItem("english", "video", 11, 2);
            workHistList.add(e);
            e = new WorkHistoryItem("science", "word problems", 12, 3);
            workHistList.add(e);
            e = new WorkHistoryItem("math", "short answer", 20, 5);
            workHistList.add(e);
            e = new WorkHistoryItem("math", "video", 30, 2);
            workHistList.add(e);
            e = new WorkHistoryItem("malay", "short answer", 15, 3);
            workHistList.add(e);
            e = new WorkHistoryItem("science", "short answer", 30, 4);
            workHistList.add(e);
            e = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(e);
            e = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(e);
            e = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(e);
            adapter.notifyDataSetChanged();
        }
        else if (i == 5){
            WorkHistoryItem f = new WorkHistoryItem("math", "mcq", 15, 5);
            workHistList.add(f);
            f = new WorkHistoryItem("english", "video", 8, 3);
            workHistList.add(f);
            f = new WorkHistoryItem("english", "video", 11, 2);
            workHistList.add(f);
            f = new WorkHistoryItem("science", "word problems", 12, 3);
            workHistList.add(f);
            f = new WorkHistoryItem("math", "short answer", 20, 5);
            workHistList.add(f);
            f = new WorkHistoryItem("math", "video", 30, 2);
            workHistList.add(f);
            f = new WorkHistoryItem("science", "short answer", 30, 4);
            workHistList.add(f);
            f = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(f);
            f = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(f);
            f = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(f);
            f = new WorkHistoryItem("english", "text", 10, 3);
            workHistList.add(f);
            f = new WorkHistoryItem("science", "word problems", 15, 3);
            workHistList.add(f);
            adapter.notifyDataSetChanged();
        }
        else if (i == 6){
            WorkHistoryItem g = new WorkHistoryItem("math", "mcq", 15, 5);
            workHistList.add(g);
            g = new WorkHistoryItem("english", "video", 8, 3);
            workHistList.add(g);
            g = new WorkHistoryItem("english", "video", 11, 2);
            workHistList.add(g);
            g = new WorkHistoryItem("science", "word problems", 12, 3);
            workHistList.add(g);
            g = new WorkHistoryItem("math", "short answer", 20, 5);
            workHistList.add(g);
            g = new WorkHistoryItem("math", "video", 30, 2);
            workHistList.add(g);
            g = new WorkHistoryItem("science", "short answer", 30, 4);
            workHistList.add(g);
            g = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(g);
            g = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(g);
            g = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(g);
            g = new WorkHistoryItem("english", "text", 10, 3);
            workHistList.add(g);
            g = new WorkHistoryItem("science", "word problems", 15, 3);
            workHistList.add(g);
            adapter.notifyDataSetChanged();
        }
        else if (i == 7){
            WorkHistoryItem h = new WorkHistoryItem("math", "mcq", 15, 5);
            workHistList.add(h);
            h = new WorkHistoryItem("english", "video", 8, 3);
            workHistList.add(h);
            h = new WorkHistoryItem("chinese", "text", 6, 2);
            workHistList.add(h);
            h = new WorkHistoryItem("english", "video", 11, 2);
            workHistList.add(h);
            h = new WorkHistoryItem("science", "word problems", 12, 3);
            workHistList.add(h);
            h = new WorkHistoryItem("math", "short answer", 20, 5);
            workHistList.add(h);
            h = new WorkHistoryItem("math", "video", 30, 2);
            workHistList.add(h);
            h = new WorkHistoryItem("chinese", "short answer", 15, 3);
            workHistList.add(h);
            h = new WorkHistoryItem("science", "short answer", 30, 4);
            workHistList.add(h);
            h = new WorkHistoryItem("science", "video", 15, 3);
            workHistList.add(h);
            h = new WorkHistoryItem("english", "text", 30, 4);
            workHistList.add(h);
            h = new WorkHistoryItem("math", "word problems", 20, 4);
            workHistList.add(h);
            adapter.notifyDataSetChanged();
        }
    }
    private void showAddItemDialog(Context context) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Enter performance log");

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText titleBox = new EditText(context);
        titleBox.setHint("Subject");
        layout.addView(titleBox);


        final EditText descriptionBox = new EditText(context);
        descriptionBox.setHint("Category");
        layout.addView(descriptionBox);

        final EditText durnBox = new EditText(context);
        durnBox.setHint("Duration");
        layout.addView(durnBox);

        final EditText rating = new EditText(context);
        rating.setHint("rating");
        layout.addView(rating);

        // Set click listener for alert dialog buttons
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        // User clicked the Yes button
                        Toast.makeText(StudentAnalyticsActivity.this, "submiited!", Toast.LENGTH_SHORT).show();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        // User clicked the No button
                        break;
                }
            }
        };

        // Set the alert dialog yes button click listener
        dialog.setPositiveButton("Yes", dialogClickListener);

        // Set the alert dialog no button click listener
        dialog.setNegativeButton("No",dialogClickListener);



        dialog.setView(layout); // Again this is a set method, not add
        dialog.show();
    }




}


