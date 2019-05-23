package ua.kpi.firstlab16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

import ua.kpi.firstlab16.domain.Way;
import ua.kpi.firstlab16.util.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper helper = new DatabaseHelper(this);

    private EditText from;
    private EditText to;
    private RadioButton eight;
    private RadioButton twelve;
    private RadioButton fifteen;
    private Button ok;
    private Button open;
    private TextView result;

    private String trainFrom;
    private String trainTo;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        from = findViewById(R.id.from);
        to = findViewById(R.id.to);
        eight = findViewById(R.id.radio_eight);
        twelve = findViewById(R.id.radio_twelve);
        fifteen = findViewById(R.id.radio_fifteen);
        ok = findViewById(R.id.ok);
        open = findViewById(R.id.open);
        result = findViewById(R.id.result);

        eight.setOnClickListener(radioButtonClickListener);
        twelve.setOnClickListener(radioButtonClickListener);
        fifteen.setOnClickListener(radioButtonClickListener);



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainFrom = from.getText().toString();
                trainTo = to.getText().toString();
                result.setText(trainFrom  + " -> " + trainTo + " at " + time);
                Way way = new Way(result.getText().toString());
                try {
                    helper.addWay(way);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Way has been added to db", Toast.LENGTH_SHORT).show();
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListOfWaysActivity.class));
            }
        });
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radio_eight:
                    time = eight.getText().toString();
                    break;
                case R.id.radio_twelve:
                    time = twelve.getText().toString();
                    break;
                case R.id.radio_fifteen:
                    time = fifteen.getText().toString();
                    break;
                default:
                    break;
            }
        }
    };
}
