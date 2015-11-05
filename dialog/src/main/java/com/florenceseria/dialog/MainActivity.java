package com.florenceseria.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Enter the User Information");
        etName = (EditText)findViewById(R.id.etName);
        etEmail=(EditText)findViewById(R.id.etEmail);
        button1=(Button)findViewById(R.id.button1);
    }
    public void onClick(View v){
        dialogView=(View) View.inflate(MainActivity.this, R.layout.dialog1, null);
        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
        dlgEdtEmail=(EditText)dialogView.findViewById(R.id.dlgEdt2);
        AlertDialog.Builder dlg = new AlertDialog.Builder (MainActivity.this);
        dlg.setTitle("Enter the User Information");
        dlg.setIcon(R.drawable.admin);
        dlg.setView(dialogView);
        dlgEdtName.setText(etName.getText().toString());
        dlgEdtEmail.setText(etEmail.getText().toString());
        dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                etName.setText(dlgEdtName.getText().toString());
                etEmail.setText(dlgEdtEmail.getText().toString());
            }
        });
        dlg.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = new Toast(MainActivity.this);
                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                toastView = (View) View.inflate(MainActivity.this,R.layout.toast1,null);
                toastText = (TextView) toastView.findViewById(R.id.toastText1);
                int xOffset=(int) (Math.random()*display.getWidth());
                int yOffset=(int)(Math.random()*display.getHeight());
                toastText.setText("Cancelled");
                toast.setView(toastView);
                toast.setGravity(Gravity.TOP | Gravity.LEFT,xOffset,yOffset);
                toast.show();
            }
        });
        dlg.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
