package deprins.chrono;

import com.example.chrono.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ChronoActivity extends Activity implements OnClickListener, Runnable{
	
	private Button startButton;
	private Button continueButton;
	private Button stopButton;
	
	private Chrono chrono;
	private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        
        chrono = new Chrono();
        chrono.addListener(this);
        
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);
        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(this);
		text = (TextView) findViewById(R.id.textView1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chrono, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		if(startButton.getId() == ((Button)v).getId() ){
	          chrono.start();
	      }
	      else if(continueButton.getId() == ((Button)v).getId() ){
	          chrono.pause();
	      }
	      else if(stopButton.getId() == ((Button)v).getId() ){
	          chrono.stop();
	      }
	}

	@Override
	public void run() {
		this.runOnUiThread(new Runnable(){
			@Override
			public void run() {
				text.setText(Integer.toString(chrono.getTimeInSeconds()));
			}
		});
	}
    
}
