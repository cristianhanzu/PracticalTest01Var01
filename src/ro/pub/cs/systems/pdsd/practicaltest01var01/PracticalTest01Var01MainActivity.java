package ro.pub.cs.systems.pdsd.practicaltest01var01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends Activity {
	 private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_main);
		CheckBox phone = (CheckBox)findViewById(R.id.phone);
		CheckBox email = (CheckBox)findViewById(R.id.email);
		CheckBox im = (CheckBox)findViewById(R.id.im);
		TextView text =  (TextView) findViewById(R.id.textim);
		 if (savedInstanceState != null) {
			 Boolean phonec = savedInstanceState.getBoolean("phonec");
			 Boolean imc = savedInstanceState.getBoolean("imc");
			 Boolean emailc = savedInstanceState.getBoolean("emailc");
			 Integer a = 0;
			 if(phonec != null){
				 phone.setChecked(phonec);
				 if(phonec){
				 a++;
				 }
			 }
			 if(imc != null){
				 im.setChecked(imc);
				 if(imc){
					 a++;
					 }
			 }
			 if(emailc != null){
				 email.setChecked(emailc);
				 if(emailc){
					 a++;
					 }
			 }
			 text.setText(a.toString());
		 }
		
		
		
		 
		
		phone.setOnClickListener(new OnClickListener() {           
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CheckBox checkBox = (CheckBox) findViewById(R.id.phone);
				TextView text =  (TextView) findViewById(R.id.textim);
				if(checkBox.isChecked()){
					int a = 0;
					Integer value = Integer.parseInt(text.getText().toString())+1;
					text.setText(value.toString());
				}else{
					int a = 0;
					Integer value = Integer.parseInt(text.getText().toString())-1;
					text.setText(value.toString());
				}
			}
        });
		
		email.setOnClickListener(new OnClickListener() {           
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CheckBox checkBox = (CheckBox) findViewById(R.id.email);
				TextView text =  (TextView) findViewById(R.id.textim);
				if(checkBox.isChecked()){
					int a = 0;
					Integer value = Integer.parseInt(text.getText().toString())+1;
					text.setText(value.toString());
				}else{
					int a = 0;
					Integer value = Integer.parseInt(text.getText().toString())-1;
					text.setText(value.toString());
				}
			}
        });
		
		im.setOnClickListener(new OnClickListener() {           
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CheckBox checkBox = (CheckBox) findViewById(R.id.im);
				TextView text =  (TextView) findViewById(R.id.textim);
				if(checkBox.isChecked()){
					int a = 0;
					Integer value = Integer.parseInt(text.getText().toString())+1;
					text.setText(value.toString());
				}else{
					int a = 0;
					Integer value = Integer.parseInt(text.getText().toString())-1;
					text.setText(value.toString());
				}
			}
        });
		Button but = (Button)findViewById(R.id.button1);
		but.setOnClickListener(new OnClickListener() {           
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(getBaseContext(), PracticalTest01Var01SecondaryActivity.class);
                CheckBox phone = (CheckBox)findViewById(R.id.phone);
        		CheckBox email = (CheckBox)findViewById(R.id.email);
        		CheckBox im = (CheckBox)findViewById(R.id.im);
                intent.putExtra("phone", phone.isChecked());
                intent.putExtra("email",  email.isChecked());
                intent.putExtra("im",  im.isChecked());
              //  startActivity(intent);
                startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
			}
        });
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var01_main, menu);
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
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
		CheckBox phone = (CheckBox)findViewById(R.id.phone);
		CheckBox email = (CheckBox)findViewById(R.id.email);
		CheckBox im = (CheckBox)findViewById(R.id.im);
		savedInstanceState.putBoolean("phonec", phone.isChecked());
		savedInstanceState.putBoolean("emailc", email.isChecked());
		savedInstanceState.putBoolean("imc", im.isChecked());		
	  }
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	  }
}
