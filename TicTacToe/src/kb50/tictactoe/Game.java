package kb50.tictactoe;

import java.util.ArrayList;
import java.util.List;
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
import android.util.Log;

import java.util.Random;

public class Game extends Activity {
	private boolean turn;
	private boolean difEasy;
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
	private String player1;
	private String player2;	
	private boolean multiplayer;
	
	ImageButton[] btns;




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
		btns = new ImageButton[] { btn1, btn2, btn3, btn4, btn5, btn6, btn7,
				btn8, btn9 };
		res = getResources();
		cross = res.getDrawable(R.drawable.candycane);
		circle = res.getDrawable(R.drawable.cookie);
		turn = true;
		setBaseVar();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// example = save value
		int sbValue = 1;

		outState.putInt("testKey", sbValue);
		outState.putBoolean("turn", turn);

		outState.putBoolean("dif", difEasy);
		outState.putBoolean("mul", multiplayer);
		outState.putString("p1", player1);
		outState.putString("p2", player2);
		


		Object d1 = btn1.getTag();
		Object d2 = btn2.getTag();
		Object d3 = btn3.getTag();
		Object d4 = btn4.getTag();
		Object d5 = btn5.getTag();
		Object d6 = btn6.getTag();
		Object d7 = btn7.getTag();
		Object d8 = btn8.getTag();
		Object d9 = btn9.getTag();
		String[] a = new String[9];

		if (d1 != null) {
			a[0] = d1.toString();
		}
		if (d2 != null) {
			a[1] = d2.toString();
		}
		if (d3 != null) {
			a[2] = d3.toString();
		}
		if (d4 != null) {
			a[3] = d4.toString();
		}
		if (d5 != null) {
			a[4] = d5.toString();
		}
		if (d6 != null) {
			a[5] = d6.toString();
		}
		if (d7 != null) {
			a[6] = d7.toString();
		}
		if (d8 != null) {
			a[7] = d8.toString();
		}
		if (d9 != null) {
			a[8] = d9.toString();
		}

		outState.putStringArray("a", a);

		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {

		// example
		super.onRestoreInstanceState(savedInstanceState);
		// restore the values in demo
		int i = (int) savedInstanceState.getInt("testKey");

		turn = savedInstanceState.getBoolean("turn"); // example key
		multiplayer = savedInstanceState.getBoolean("mul");

		difEasy = savedInstanceState.getBoolean("dif");

		player1 = savedInstanceState.getString("p1");
		player2 = savedInstanceState.getString("p2");
	
	

		String[] a = new String[9];
		a = savedInstanceState.getStringArray("a");
		if (a[0] != null) {
			returnButtons(a[0], btn1);
		}
		if (a[1] != null) {
			returnButtons(a[1], btn2);
		}
		if (a[2] != null) {
			returnButtons(a[2], btn3);
		}
		if (a[3] != null) {
			returnButtons(a[3], btn4);
		}
		if (a[4] != null) {
			returnButtons(a[4], btn5);
		}
		if (a[5] != null) {
			returnButtons(a[5], btn6);
		}
		if (a[6] != null) {
			returnButtons(a[6], btn7);
		}
		if (a[7] != null) {
			returnButtons(a[7], btn8);
		}
		if (a[8] != null) {
			returnButtons(a[8], btn9);
		}

	}

	private void returnButtons(String a, ImageButton btn) {
		if (a.equals("cross")) {
			btn.setImageDrawable(cross);
			btn.setTag("cross");
			btn.setClickable(false);
		} else if (a.equals("circle")) {
			btn.setImageDrawable(circle);
			btn.setTag("circle");
			btn.setClickable(false);
		} else {
		}

	}

	private void setBaseVar() {
		try {
			String a = getIntent().getStringExtra("Player");
			if (a.equals("two")) {

				player1 = getIntent().getStringExtra("p1_name");
				player2 = getIntent().getStringExtra("p2_name");
				if (player1.equals("") || player2.equals("")) {
					// something went wrong
				} else {
					multiplayer = true;
					int ran = new Random().nextInt(2);

					if (ran == 1) {
						turn = true;

						TextView t1 = (TextView) findViewById(R.id.turn);
						t1.setText("It is " + player1 + " 's turn");

					} else {
						turn = false;

						TextView t1 = (TextView) findViewById(R.id.turn);

						t1.setText("It is " + player2 + " 's turn");

					}

				}

			} else {
				String dif = getIntent().getStringExtra("dif");
				if (dif.equals("easy")) {
					difEasy = true;
				} else {
					difEasy = true;
				}
				turn = true;
				multiplayer = false;
				TextView t1 = (TextView) findViewById(R.id.turn);
				t1.setText("It is your turn");

			}

		} catch (Exception e) {

		}

	}

    public void onClickBtn(View v){
    	Intent k = new Intent (this, MainActivity.class);
		startActivity(k);
	}




	private void onePlayer() {
		if (turn == true) {
			TextView t1 = (TextView) findViewById(R.id.turn);
			// t1.setText("It is Your turn");
		} else {
			aiEasy(btns);

			check();

			turn = true;

		}

	}


	private void multiplayerCheck() {
		if (multiplayer == false) {
			onePlayer();
		} else {
			twoPlayers();
		}
	}

	private void clearScreen(){
		btn1.setImageDrawable(null);
		btn1.setTag(null);
		btn1.setClickable(true);
		btn2.setImageDrawable(null);
		btn2.setTag(null);
		btn2.setClickable(true);
		btn3.setImageDrawable(null);
		btn3.setTag(null);
		btn3.setClickable(true);
		btn4.setImageDrawable(null);
		btn4.setTag(null);
		btn4.setClickable(true);
		btn5.setImageDrawable(null);
		btn5.setTag(null);
		btn5.setClickable(true);
		btn6.setImageDrawable(null);
		btn6.setTag(null);
		btn6.setClickable(true);
		btn7.setImageDrawable(null);
		btn7.setTag(null);
		btn7.setClickable(true);
		btn8.setImageDrawable(null);
		btn8.setTag(null);
		btn8.setClickable(true);
		btn9.setImageDrawable(null);
		btn9.setTag(null);
		btn9.setClickable(true);
		
		
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
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}else if(d4 != null && d5 != null && d6 != null){
    		if(d4.equals(d5) && d5.equals(d6)){
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}else if(d7 != null && d8 != null && d9 != null){
    		if(d7.equals(d8) && d8.equals(d9)){
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}
    	
    	//Vertical check
    	if(d1 != null && d4 != null && d7 != null){
    		if(d1.equals(d4) && d4.equals(d7)){
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}else if(d2 != null && d5 != null && d8 != null){
    		if(d2.equals(d5) && d5.equals(d8)){
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}else if(d3 != null && d6 != null && d9 != null){
    		if(d3.equals(d6) && d6.equals(d9)){
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}    	
    	
    	//Diagonal check
    	if(d1 != null && d5 != null && d9 != null){
    		if(d1.equals(d5) && d5.equals(d9)){
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}else if(d3 != null && d5 != null && d7 != null){
    		if(d3.equals(d5) && d5.equals(d7)){
    			if(turn == true){
    				winDialog();
    			}else{
    				loseDialog();
    			}
        	}
    	}
    	
    	//Draw check 
    	if(d1 != null && d2 != null && d3 != null && d4 != null && d5 != null && d6 != null && d7 != null && d8 != null && d9 != null){
    		drawDialog();
    	}
    }
    
    private void drawDialog(){
    	Fragment dialogFragment = Fragment.newInstance("It's a draw! Want to play again?");
		dialogFragment.show(getFragmentManager(), "dialog"); 
    }
    
    private void loseDialog(){
    	if(multiplayer == false){
        	Fragment dialogFragment = Fragment.newInstance("You've lost and now Santa is sad! Want to try to cheer him up?");
    		dialogFragment.show(getFragmentManager(), "dialog");    		
    	}else{
        	Fragment dialogFragment = Fragment.newInstance(player2 + " wins! Want to play again?");
    		dialogFragment.show(getFragmentManager(), "dialog");    		
    	}
    }
    
    private void winDialog(){
    	if(multiplayer == false){
        	Fragment dialogFragment = Fragment.newInstance("You've won and Santa is very pleased. Care to play again?");
    		dialogFragment.show(getFragmentManager(), "dialog");
    	}else{
    		Fragment dialogFragment = Fragment.newInstance(player1 + " wins! Want to play again?");
    		dialogFragment.show(getFragmentManager(), "dialog");
    	}
    }
    
    public void doPositiveClick(){
    	clearScreen();
    }
    
    public void doNegativeClick(){
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
    
   

    private void twoPlayers(){    	
    	if(turn == true){
        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is "+player2+" 's turn");
    	}else{
        	TextView t1 = (TextView) findViewById(R.id.turn);
        	t1.setText("It is "+player1+" 's turn");
    	}
    }
   	

	private Drawable getImage2(ImageButton a) {

		return a.getDrawable();
	}

	public void aiEasy(ImageButton[] o) {

		Random nm = new Random();
		List<ImageButton> btns = new ArrayList<ImageButton>();
		for (int i = 0; i < o.length; i++) {

			if (o[i].getTag() == null) {
				btns.add(o[i]);

			}

		}
		if (!btns.isEmpty()) {
			int max = btns.size();
			int placeRandom = nm.nextInt(max);
			btns.get(placeRandom).setImageDrawable(circle);
			btns.get(placeRandom).setTag("circle");
			btns.get(placeRandom).setClickable(false);
		}
	}

}
