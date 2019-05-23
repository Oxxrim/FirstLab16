package ua.kpi.firstlab16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText from;
    private EditText to;
    private RadioButton eight;
    private RadioButton twelve;
    private RadioButton fifteen;
    private Button ok;
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
