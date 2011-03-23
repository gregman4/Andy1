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
	
	public EditText theString;
	private Button butt;
	private Button ib;
	public Button oneButton, twoButton;
	
	private int turn;
	private int [] board = new int[ ] {-1,0,0,0,0,0,0,0,0,0};
	
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
    	
    //	ib = (Button)findViewById(R.id.button);
    	//butt.setOnClickListener(buttListener);
   
    	turn =1;
    	ButtListener buttListener = new ButtListener(this);
    	oneButton = (Button)findViewById(R.id.oneButton);
    	twoButton = (Button)findViewById(R.id.twoButton);
    	oneButton.setOnClickListener(buttListener);
    	twoButton.setOnClickListener(buttListener);
    	
    	
    }
    
    /*(private OnClickListener buttListener = new OnClickListener() {
    	public void onClick(View v) {

    		//   oneButton.setBackgroundResource(R.drawable.x); //how do I set this so that the image changes instead of disappearin	
    	}
    };
    private void calculate(){	
    }*/
    
   public boolean valid (int spot){
	   if(board[spot]==0)
		   return true;
	   else
		   return false;
   }
   
   public String whosTurn(){
	   if(turn==1)
	   return "x";
	   else
		   return "y";
   }
   
   public void makeMove(int spot){
	   //should I check if its valid?
	   board[spot]=turn;
	   if (turn==1)
		   turn=2;
	   else
		   turn=1;   
   }
}

class ButtListener implements Button.OnClickListener
{
	private HelloAndroid ttt;
	public ButtListener(HelloAndroid ttt){
		this.ttt=ttt;
	}
	
	public void onClick(View v) {
		if(v==ttt.oneButton){
			ttt.theString.setText("butt1");
			move(1);
		}    
		if(v==ttt.twoButton){
			ttt.theString.setText("butt2");
			move(2);
		}    
	}

	private void move (int spot){
		if(ttt.valid(spot)){
			if(ttt.whosTurn().equals("x")){
				switch (spot) {
				case 1:  ttt.oneButton.setBackgroundResource(R.drawable.x);       break;
				case 2:  ttt.twoButton.setBackgroundResource(R.drawable.x);		  break;
				}
			}
			else{
				switch (spot) {
				case 1:  ttt.oneButton.setBackgroundResource(R.drawable.o);       break;
				case 2:  ttt.twoButton.setBackgroundResource(R.drawable.o);		  break;
				}
			}
			
			ttt.makeMove(spot);
		}

	}
}