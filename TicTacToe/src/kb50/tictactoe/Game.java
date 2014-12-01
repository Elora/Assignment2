package kb50.tictactoe;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game extends Activity {
	private boolean turn;
	private boolean multiplayer;
	private String Player1;
	private String Player2;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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
    	default: 
    		if(multiplayer == false){
    			onePlayer(v);
    		}
    		else{
    			twoPlayers(v);
    		}
    		break;

    	}
    }

    
    private void onePlayer(View v){
    	ImageButton btn = (ImageButton) findViewById(v.getId());
    	
    	Resources res = getResources();
    	Drawable cross = res.getDrawable(R.drawable.candycane);
    	Drawable circle = res.getDrawable(R.drawable.cookie);
    	
    	if(turn == true){
    		btn.setImageDrawable(cross);
    		btn.setClickable(false);


        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is Your turn");
    		
    		turn = false;
    	}else{
    		btn.setImageDrawable(circle);
    		btn.setClickable(false);
    		
    		//computer action
    		
    		turn = true;
    	}

    }

    private void twoPlayers(View v){
    	ImageButton btn = (ImageButton) findViewById(v.getId());
    	
    	Resources res = getResources();
    	Drawable cross = res.getDrawable(R.drawable.candycane);
    	Drawable circle = res.getDrawable(R.drawable.cookie);
    	
    	if(turn == true){
    		btn.setImageDrawable(cross);
    		btn.setClickable(false);

        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is "+Player1+" 's turn");
    		
    		turn = false;
    	}else{
    		btn.setImageDrawable(circle);
    		btn.setClickable(false);
    		

        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is "+Player2+" 's turn");
    		
    		turn = true;
    	}
    } 
    
    
    
}
