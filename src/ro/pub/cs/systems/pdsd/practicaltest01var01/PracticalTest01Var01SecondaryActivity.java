package ro.pub.cs.systems.pdsd.practicaltest01var01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;

public class PracticalTest01Var01SecondaryActivity extends Activity {
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 private class ButtonClickListener implements Button.OnClickListener {
		 
		    @Override
		    public void onClick(View view) {
		      switch(view.getId()) {
		        case R.id.okb:
		          setResult(RESULT_OK, new Intent());
		          finish();
		          break;
		        case R.id.cancelb:
		          setResult(RESULT_CANCELED, new Intent());
		          finish();
		          break;
		      }
		    }
		  }  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_secondary); 
		Intent intent = getIntent();
	    if (intent != null) {
	    	String out = new String();
	    	if(intent.getBooleanExtra("phone", false) == true){
	    		out = out + "Phone,";
	    	}
	    	if(intent.getBooleanExtra("email", false) == true){
	    		out = out + "Email,";
	    	}
	    	if(intent.getBooleanExtra("im", false) == true){
	    		out = out + "Instant Messaging,";
	    	}
	    	TextView text =  (TextView) findViewById(R.id.textView1);
	    	text.setText(out);
	    }
	    Button buttonOk = (Button)findViewById(R.id.okb);
	    buttonOk.setOnClickListener(buttonClickListener);
	    Button buttonCancel = (Button)findViewById(R.id.cancelb);
	    buttonCancel.setOnClickListener(buttonClickListener);  
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
	
}
