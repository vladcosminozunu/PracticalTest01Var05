package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends Activity {

	TextView contor, directions;
	Button register, cancel;
	
	private ButtonListener buttonListener = new ButtonListener();
	
	private class ButtonListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			int id = v.getId();
			
			if(id == R.id.register_button){
				setResult(RESULT_OK);
			}
			else if(id == R.id.cancel_button){
				setResult(RESULT_CANCELED);
			}
			
			finish();
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
		
		contor = (TextView) findViewById(R.id.counter_text_view);
		directions = (TextView) findViewById(R.id.direction_set_text_view);
		
		register = (Button) findViewById(R.id.register_button);
		cancel = (Button) findViewById(R.id.cancel_button);
		register.setOnClickListener(buttonListener);
		cancel.setOnClickListener(buttonListener);
		
		Intent intent = getIntent();
		if(intent != null){
			contor.setText(String.valueOf(intent.getIntExtra("contor", 0)));
			directions.setText(intent.getStringExtra("direction_set"));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var05_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
