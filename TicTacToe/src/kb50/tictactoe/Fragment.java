package kb50.tictactoe;

import android.app.DialogFragment;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class Fragment extends DialogFragment{
	
	static Fragment newInstance(String title){
		Fragment frag = new Fragment();
		Bundle args = new Bundle();
		args.putString("title", title);
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		String title = getArguments().getString("title");
		return new AlertDialog.Builder(getActivity())
		//.setIcon(R.drawable.icon)
		.setTitle(title)
		.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,
					int whichButton) {
				((Game)
						getActivity()).doPositiveClick();
			}
		})
		.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,
					int whichButton) {
				((Game)
						getActivity()).doNegativeClick();
			}
		}).create();
	}
}

