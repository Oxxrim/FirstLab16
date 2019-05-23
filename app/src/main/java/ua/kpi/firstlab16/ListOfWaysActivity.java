package ua.kpi.firstlab16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import ua.kpi.firstlab16.domain.Way;
import ua.kpi.firstlab16.util.DatabaseHelper;

public class ListOfWaysActivity extends AppCompatActivity {

    private DatabaseHelper helper = new DatabaseHelper(this);
    private List<Way> ways;
    private LinearLayout linLayout;
    private Way way;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_ways);
        getSupportActionBar().hide();

        try {
            ways = helper.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        linLayout = findViewById(R.id.linLayout);
        inflater = getLayoutInflater();

        if (ways.size() == 0){
            Toast.makeText(this, "Database is empty", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < ways.size(); i++){
                way = ways.get(i);
                View item = inflater.inflate(R.layout.item, linLayout, false);
                TextView path = item.findViewById(R.id.path);
                path.setText(way.getPathway());
                linLayout.addView(item);
            }
        }
    }
}
