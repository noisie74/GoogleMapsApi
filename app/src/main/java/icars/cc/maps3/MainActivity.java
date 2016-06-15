package icars.cc.maps3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    public static final String KEY = "Maps";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setButtons();
        setButtonClicks();


    }

    private void setButtons() {

        b1 = (Button) findViewById(R.id.sf);
        b2 = (Button) findViewById(R.id.nyc);
    }

    private void setButtonClicks() {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MapsActivitySF.class);

                intent.putExtra(KEY, 0);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MapsActivityNYC.class);
                intent.putExtra(KEY, 1);
                startActivity(intent);
            }
        });
    }
}
