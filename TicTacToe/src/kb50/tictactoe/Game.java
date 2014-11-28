package kb50.tictactoe;

import android.app.Activity;
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
        setContentView(R.layout.activity_main);
        
        turn = true;
    }
    
    public void onClick(View v){
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
    }
}
