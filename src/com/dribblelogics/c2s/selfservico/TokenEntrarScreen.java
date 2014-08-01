/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.selfservico;

import com.dribblelogics.c2sselfservico.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TokenEntrarScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.token_entrar_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.token_entrar_screen, menu);
		return true;
	}

}
