package kb50.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Difficulty extends Activity{
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_difficulty);
	}
	
	public void onClick(View v){
		switch(v.getId()){
		case R.id.btn_easy:
			Intent i = new Intent (this, Game.class);
			startActivity(i);
			break;
		case R.id.btn_hard:
			Intent j = new Intent (this, Game.class);
			startActivity(j);
			break;
		}
	}

}
