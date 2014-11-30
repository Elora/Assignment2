package kb50.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Game extends Activity {
	private boolean turn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        
        turn = true;
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
    		ImageButton btn = (ImageButton) findViewById(v.getId());
        	
        	Resources res = getResources();
        	Drawable cow2 = res.getDrawable(R.drawable.cow2);
        	Drawable cow3 = res.getDrawable(R.drawable.cow3);
        	
        	if(turn == true){
        		btn.setImageDrawable(cow2);
        		btn.setClickable(false);
        		turn = false;
        	}else{
        		btn.setImageDrawable(cow3);
        		btn.setClickable(false);
        		turn = true;
        	}
        	break;
    	}
    }
}
