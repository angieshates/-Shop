package com.irvin.ushop;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.ParseException;


public class Registro extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void enviarRegistro(View view){

        EditText username1 = (EditText)findViewById(R.id.usernamereg);
        String username = username1.getText().toString();

        EditText pasw1 = (EditText)findViewById(R.id.paswreg);
        String  password = pasw1.getText().toString();

        EditText email1 = (EditText)findViewById(R.id.emailreg);
        String email = email1.getText().toString();

        EditText phone1 = (EditText)findViewById(R.id.telefonoreg);
        String phone = phone1.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        //"650-253-0000"
        user.put("phone",phone);

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    TextView mostrar = (TextView)findViewById(R.id.mensajereg);
                    mostrar.setText("Hooray! Let them use the app now.");

                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    TextView mostrar = (TextView)findViewById(R.id.mensajereg);
                    mostrar.setText("Sign up didn't succeed. Look at the ParseException");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}