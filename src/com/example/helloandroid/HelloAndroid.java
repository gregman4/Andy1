package com.example.helloandroid;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HelloAndroid extends Activity {
	
	private EditText theString;
	private Button butt;
	private Button ib;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        //TextView tv = new TextView(this);
        //tv.setText("Greg is here");
       // setContentView(tv);
    }
    
    private void init(){
    	theString = (EditText)findViewById(R.id.stringVar);
    	butt = (Button)findViewById(R.id.button1);
    	ib = (Button)findViewById(R.id.button);
    	butt.setOnClickListener(buttListener);
    	
    }
    
    private OnClickListener buttListener = new OnClickListener() {
		public void onClick(View v) {
			theString.setText("you clicked");
		  ib.setBackgroundResource(0); //how do I set this so that the image changes instead of disappearing
		
		}
    };
    
    private void calculate(){
    	
    	
    }
}