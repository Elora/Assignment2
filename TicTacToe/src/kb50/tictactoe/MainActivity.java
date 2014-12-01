package kb50.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
    public void onClick(View v){
    	switch(v.getId()){
    	case R.id.btn_oneplayer:
    		Intent single = new Intent(this, Difficulty.class);
    		startActivity(single);
    		break;
    	
    	case R.id.btn_twoplayer:
    		Intent multi = new Intent(this, MultiPlayer.class);
    		startActivity(multi);
    		break;
    		
    	}
    	
    }
}
