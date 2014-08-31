package abhishek.basicuserform.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText name, email;
    RadioGroup gender;
    RadioButton male, female;
    CheckBox read, speak, write;
    Spinner occupation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameEditText);
        email = (EditText) findViewById(R.id.emailEditText);

        gender = (RadioGroup)findViewById(R.id.genderRadioGroup);
        male = (RadioButton) findViewById(R.id.maleRadioButton);
        female = (RadioButton)findViewById(R.id.femaleRadioButton);

        read = (CheckBox) findViewById(R.id.readCheckBox);
        speak = (CheckBox) findViewById(R.id.speakCheckBox);
        write = (CheckBox) findViewById(R.id.writeCheckBox);

        occupation = (Spinner) findViewById(R.id.occupationSpinner);
        occupation.setPrompt("Graduate");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void resetFields(View view){

        ((EditText)findViewById(R.id.nameEditText)).setText(null);
        ((EditText)findViewById(R.id.emailEditText)).setText(null);
        ((RadioButton) findViewById(R.id.maleRadioButton)).setChecked(false);
        ((RadioButton) findViewById(R.id.femaleRadioButton)).setChecked(false);
        ((CheckBox) findViewById(R.id.speakCheckBox)).setChecked(false);
        ((CheckBox) findViewById(R.id.readCheckBox)).setChecked(false);
        ((CheckBox) findViewById(R.id.writeCheckBox)).setChecked(false);
        ((Spinner) findViewById(R.id.occupationSpinner)).setSelection(0,true);

    }

    public void submitForm(View view){

        String pass_name = name.getText().toString();
        String pass_email = email.getText().toString();

        String pass_gender;
        if(male.isChecked()) {
            pass_gender = "Male";
        } else if(female.isChecked()) {
            pass_gender = "Female";
        } else {
            pass_gender = null;
        }

        String pass_skill_read = (read.isChecked()) ? "Read":"";
        String pass_skill_speak = (speak.isChecked()) ? "speak":"";
        String pass_skill_write = (write.isChecked()) ? "write":"";

        String pass_occupation = (occupation.getSelectedItem().toString());

        Bundle newBundle = new Bundle();

        newBundle.putString("NAME",pass_name);
        newBundle.putString("EMAIL",pass_email);
        newBundle.putString("GENDER",pass_gender);
        newBundle.putString("READ",pass_skill_read);
        newBundle.putString("SPEAK",pass_skill_speak);
        newBundle.putString("WRITE",pass_skill_write);
        newBundle.putString("OCCUPATION",pass_occupation);


        Intent newIntent = new Intent(this,displayFormDetail.class);

        newIntent.putExtras(newBundle);
        startActivity(newIntent);


    }
}
