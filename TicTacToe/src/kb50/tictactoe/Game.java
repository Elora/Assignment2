package kb50.tictactoe;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity {
	private boolean turn;
	private ImageButton btn1;
	private ImageButton btn2;
	private ImageButton btn3;
	private ImageButton btn4;
	private ImageButton btn5;
	private ImageButton btn6;
	private ImageButton btn7;
	private ImageButton btn8;
	private ImageButton btn9;
	private Resources res;
	private Drawable cross;
	private Drawable circle;
	private boolean multiplayer;
	private String Player1;
	private String Player2;	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn1 = (ImageButton) findViewById(R.id.ib_1);
        btn2 = (ImageButton) findViewById(R.id.ib_2);
        btn3 = (ImageButton) findViewById(R.id.ib_3);
        btn4 = (ImageButton) findViewById(R.id.ib_4);
        btn5 = (ImageButton) findViewById(R.id.ib_5);
        btn6 = (ImageButton) findViewById(R.id.ib_6);
        btn7 = (ImageButton) findViewById(R.id.ib_7);
        btn8 = (ImageButton) findViewById(R.id.ib_8);
        btn9 = (ImageButton) findViewById(R.id.ib_9);
        res = getResources();
        cross = res.getDrawable(R.drawable.candycane);
        circle = res.getDrawable(R.drawable.cookie);
        turn = true;
        setBaseVar();
    }

    
    private void setBaseVar(){
    	try{
    		String a = getIntent().getStringExtra("Player");
    		if (a.equals("two")){

    	    	Player1 = getIntent().getStringExtra("p1_name");
    			Player2 = getIntent().getStringExtra("p2_name");
    				if (Player1.equals("") || Player2.equals("")){
    					//something went wrong
    				}
    				else{
    					multiplayer = true;
    					int ran = new Random().nextInt(2);
    					
    					if(ran == 1){
    						turn = true;

    			        	TextView t1 = (TextView) findViewById(R.id.turn);
    						t1.setText("It is "+Player1+" 's turn");
    			    		
    					}
    					else{
    						turn = false;

    			        	TextView t1 = (TextView) findViewById(R.id.turn);

    						t1.setText("It is "+Player2+" 's turn");
    			    		
    					}
    				
    				}

    		}
    		else{
    				multiplayer = false;
    				TextView t1 = (TextView) findViewById(R.id.turn);
    				t1.setText("It is your turn");

    		}
    		
    	}
    	catch(Exception e){
    		
    	}
    
    }
    
    public void onClickBtn(View v){
    	Intent k = new Intent (this, MainActivity.class);
		startActivity(k);
    }
    
    public void onClick(View v){
    	switch(v.getId()){
    	case R.id.btn_back:
			Intent k = new Intent (this, MainActivity.class);
			startActivity(k);
			break;
    	case R.id.ib_1:    	        	
        	if(turn == true){
        		btn1.setImageDrawable(cross);
        		
        		btn1.setTag("cross");
        		
        		btn1.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn1.setImageDrawable(circle);
        		
        		btn1.setTag("circle");
        		
        		btn1.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_2:    	        	
        	if(turn == true){
        		btn2.setImageDrawable(cross);

        		btn2.setTag("cross");
        		
        		btn2.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn2.setImageDrawable(circle);
        		
        		btn2.setTag("circle");
        		
        		btn2.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_3:    	        	
        	if(turn == true){
        		btn3.setImageDrawable(cross);
        		
        		btn3.setTag("cross");
        		
        		btn3.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn3.setImageDrawable(circle);
        		
        		btn3.setTag("circle");
        		
        		btn3.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_4:    	        	
        	if(turn == true){
        		btn4.setImageDrawable(cross);
        		
        		btn4.setTag("cross");
        		
        		btn4.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn4.setImageDrawable(circle);
        		
        		btn4.setTag("circle");
        		
        		btn4.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_5:    	        	
        	if(turn == true){
        		btn5.setImageDrawable(cross);
        		
        		btn5.setTag("cross");
        		
        		btn5.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn5.setImageDrawable(circle);
        		
        		btn5.setTag("circle");
        		
        		btn5.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_6:    	        	
        	if(turn == true){
        		btn6.setImageDrawable(cross);
        		
        		btn6.setTag("cross");
        		
        		btn6.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn6.setImageDrawable(circle);
        		
        		btn6.setTag("circle");
        		
        		btn6.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_7:    	        	
        	if(turn == true){
        		btn7.setImageDrawable(cross);
        		
        		btn7.setTag("cross");
        		
        		btn7.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn7.setImageDrawable(circle);
        		
        		btn7.setTag("circle");
        		
        		btn7.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_8:    	        	
        	if(turn == true){
        		btn8.setImageDrawable(cross);
        		
        		btn8.setTag("cross");
        		
        		btn8.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn8.setImageDrawable(circle);
        		
        		btn8.setTag("circle");
        		
        		btn8.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	case R.id.ib_9:    	        	
        	if(turn == true){
        		btn9.setImageDrawable(cross);
   
        		btn9.setTag("cross");
        		
        		btn9.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = false;
        	}else{
        		btn9.setImageDrawable(circle);
        		
        		btn9.setTag("circle");
        		
        		btn9.setClickable(false);
        		check();
        		multiplayerCheck();
        		turn = true;
        	}
        	break;
    	}
    }
    
    private void multiplayerCheck(){
		if(multiplayer == false){
			onePlayer();
		}
		else{
			twoPlayers();
		}
    }
    
    private void check(){    	    	
    	Object d1 = btn1.getTag();
    	Object d2 = btn2.getTag();
    	Object d3 = btn3.getTag();
    	Object d4 = btn4.getTag();
    	Object d5 = btn5.getTag();
    	Object d6 = btn6.getTag();
    	Object d7 = btn7.getTag();
    	Object d8 = btn8.getTag();
    	Object d9 = btn9.getTag();
    	
    	//Horizontal check 
    	if(d1 != null && d2 != null && d3 != null){
    		if(d1.equals(d2) && d2.equals(d3)){
    			Context context = getApplicationContext();
    			CharSequence text = "Horizontal check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	}else if(d4 != null && d5 != null && d6 != null){
    		if(d4.equals(d5) && d5.equals(d6)){
    			Context context = getApplicationContext();
    			CharSequence text = "Horizontal check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	}else if(d7 != null && d8 != null && d9 != null){
    		if(d7.equals(d8) && d8.equals(d9)){
    			Context context = getApplicationContext();
    			CharSequence text = "Horizontal check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	}
    	
    	//Vertical check
    	if(d1 != null && d4 != null && d7 != null){
    		if(d1.equals(d4) && d4.equals(d7)){
    			Context context = getApplicationContext();
    			CharSequence text = "Vertical check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	}else if(d2 != null && d5 != null && d8 != null){
    		if(d2.equals(d5) && d5.equals(d8)){
    			Context context = getApplicationContext();
    			CharSequence text = "Vertical check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	}else if(d3 != null && d6 != null && d9 != null){
    		if(d3.equals(d6) && d6.equals(d9)){
    			Context context = getApplicationContext();
    			CharSequence text = "Vertical check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	}    	
    	
    	//Diagonal check
    	if(d1 != null && d5 != null && d9 != null){
    		if(d1.equals(d5) && d5.equals(d9)){
    			Context context = getApplicationContext();
    			CharSequence text = "Diagonal check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	}else if(d3 != null && d5 != null && d7 != null){
    		if(d3.equals(d5) && d5.equals(d7)){
    			Context context = getApplicationContext();
    			CharSequence text = "Diagonal check works";
    			int duration = Toast.LENGTH_SHORT;

    			Toast toast = Toast.makeText(context, text, duration);
    			toast.show();
        	}
    	} 	
    }
    
    private void onePlayer(){
    	if(turn == true){
        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is Your turn");
    	}else{
    		//computer action
    	}

    }

    private void twoPlayers(){    	
    	if(turn == true){
        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is "+Player1+" 's turn");
    	}else{
        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is "+Player2+" 's turn");
    	}
    } 
}
