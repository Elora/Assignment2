package kb50.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MultiPlayer extends Activity {

	private EditText inputP1;
	private EditText inputP2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiplayer);
	
		inputP1 = (EditText) findViewById(R.id.input_p1);
		inputP2 = (EditText) findViewById(R.id.input_p2);
	}
	
	public void onClick(View v){
		switch(v.getId()){
		case R.id.btn_play:
			Intent play = new Intent(this, Game.class);
			
			String nameP1 = inputP1.getText().toString(); 
			
			String nameP2 = inputP2.getText().toString();
			
			if(nameP1.equals("") || nameP2.equals("")){
				Context context = getApplicationContext();
				CharSequence text = "Fill in the names";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();

			}else{
				play.putExtra("p1_name", nameP1);
				play.putExtra("p2_name", nameP2);

				play.putExtra("Player", "two");
				
//				startActivityForResult(play,1);
				startActivity(play);
			}
			
			break;
			
		case R.id.btn_back:
			Intent i = new Intent(this, MainActivity.class);
			
			startActivity(i);
			break;
		}
		}
	
	
}
