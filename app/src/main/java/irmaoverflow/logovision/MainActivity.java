package irmaoverflow.logovision;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.test_butt);
        btn.setOnClickListener(this);
    }

    /** Called when the user touches the button */
    @Override
    public void onClick(View view) {
        if(btn.getText() == "XD")
            btn.setText("X");
        else
            btn.setText("XD");
    }
}
