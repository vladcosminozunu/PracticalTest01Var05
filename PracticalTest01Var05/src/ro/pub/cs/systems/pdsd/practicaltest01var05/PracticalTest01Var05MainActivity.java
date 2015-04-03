package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05MainActivity extends Activity {

	Button north, south, east, west, navigate;
	TextView directions;
	
	public static final String NORTH = "North";
	public static final String SOUTH = "South";
	public static final String EAST = "East";
	public static final String WEST = "West";
	
	protected Integer contor = 0;
	
	public static final int REQUEST_CODE = 21;
	
	//listener pt butoane
	private ButtonListener buttonListener = new ButtonListener();
	
	
	private class ButtonListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			int id = v.getId();
			String existing_directions = directions.getText().toString();
			
			if(id == R.id.north_button){
				if(existing_directions.isEmpty()){
					directions.setText(NORTH);
				}
				else{
					
					existing_directions += ","+ NORTH;
					directions.setText(existing_directions);
				}
			}
			else if(id == R.id.south_button){
				if(existing_directions.isEmpty()){
					directions.setText(SOUTH);
				}
				else{
					existing_directions += ","+ SOUTH;
					directions.setText(existing_directions);
				}
			}
			else if(id == R.id.east_button){
				if(existing_directions.isEmpty()){
					directions.setText(EAST);
				}
				else{
					existing_directions += ","+ EAST;
					directions.setText(existing_directions);
				}
			}
			else if(id == R.id.west_button){
				if(existing_directions.isEmpty()){
					directions.setText(WEST);
				}
				else{
					existing_directions += ","+ WEST;
					directions.setText(existing_directions);
				}
			}
			else if(id == R.id.navigate_button){
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.PracticalTest01Var05SecondaryActivity");
				intent.putExtra("direction_set", directions.getText().toString());
				intent.putExtra("contor", contor);
				directions.setText("");
				startActivityForResult(intent, REQUEST_CODE);
			}
			
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_main);
		
		//initializare butoane
		north = (Button) findViewById(R.id.north_button);
		south = (Button) findViewById(R.id.south_button);
		east = (Button) findViewById(R.id.east_button);
		west = (Button) findViewById(R.id.west_button);
		navigate = (Button) findViewById(R.id.navigate_button);
		
		north.setOnClickListener(buttonListener);
		south.setOnClickListener(buttonListener);
		east.setOnClickListener(buttonListener);
		west.setOnClickListener(buttonListener);
		navigate.setOnClickListener(buttonListener);
		
		//initializare textView
		directions = (TextView) findViewById(R.id.directions_text_view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
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
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState){
		savedInstanceState.putInt("contor", contor);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState){
		Integer savedCounter = savedInstanceState.getInt("contor");
		if(savedCounter != null)
			contor = savedCounter;
	}
	
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent intent){
		if(requestCode == REQUEST_CODE){
			if(resultCode == RESULT_OK){
				contor++;
			}
		}
	}
}
