package abhishek.basicuserform.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class displayFormDetail extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_form_detail);

        Intent newIntent = getIntent();

        Bundle bundle = newIntent.getExtras();

        String name = bundle.getString("NAME");
        String email = bundle.getString("EMAIL");
        String gender = bundle.getString("GENDER");
        String occupation = bundle.getString("OCCUPATION");
        String read = bundle.getString("READ");
        String write = bundle.getString("WRITE");
        String speak = bundle.getString("SPEAK");

        ((TextView)findViewById(R.id.displayNameTextView)).setText(name);
        ((TextView)findViewById(R.id.displayEmailTextView)).setText(email);
        ((TextView)findViewById(R.id.displayGenderTextView)).setText(gender);
        if(occupation == "Select"){
            ((TextView)findViewById(R.id.displayOccupationTextView)).setText(null);
        } else {
            ((TextView) findViewById(R.id.displayOccupationTextView)).setText(occupation);
        }
        ((TextView)findViewById(R.id.displayReadTextView)).setText(read);
        ((TextView)findViewById(R.id.displaySpeakTextView)).setText(speak);
        ((TextView)findViewById(R.id.displayWriteTextView)).setText(write);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_form_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
