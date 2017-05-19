package net.karthikponnam.textrepeatersample;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.karthikponnam.tr.Repeater;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity {
    String TAG = getClass().getName();

    @BindView(R.id.text_repeat)
    EditText text_repeat;
    @BindView(R.id.number)
    EditText count;
    @BindView(R.id.generate)
    Button generate;
    @BindView(R.id.display)
    TextView display;
    @BindView(R.id.add_space)
    CheckBox add_space;
    @BindView(R.id.add_new_line)
    CheckBox add_new_line;
    @BindView(R.id.add_other)
    CheckBox add_other;
    @BindView(R.id.other_char)
    EditText other_char;
    @BindView(R.id.developer)
    RelativeLayout developer;

    String text, o_char;
    int number;
    Boolean space_checked = false;
    Boolean new_line_checked = false;
    Boolean other_checked = false;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*
        Add Other Character Check Box setOnCheckedChangeListener
         */
        add_other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    other_checked = true;
                    other_char.setEnabled(true);
                } else {
                    other_checked = false;
                    other_char.setEnabled(false);
                }
            }
        });

        /*
        Generate Button Click
        This will start Generating Repeat Text
         */
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count.getText().toString().trim().length() != 0) {
                    if(Integer.parseInt(count.getText().toString().trim()) > 5000) {
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setTitle("Warning")
                                .setMessage(Html.fromHtml("You have entered the count above <strong>5000</strong> which may freeze your phone some times.Please be careful.<br><br>If no share dialog is appeared the text is <strong>copied</strong> to clipboard you can <strong>paste</strong> as message"))
                                .setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        new GenText().execute();
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .create();
                        alertDialog.show();
                    } else {
                        new GenText().execute();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please Enter the Count", Toast.LENGTH_SHORT).show();
                }
            }
        });

        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://twitter.com/PonnamKarthik"));
                startActivity(i);
            }
        });
    }

    /*
   Generating Text in Backgroung without effecting the Main UI
   this will check for empty texts and extra
    */
    public class GenText extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            display.setText("");
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Generating Text...");
            progressDialog.show();

            space_checked = add_space.isChecked();
            new_line_checked = add_new_line.isChecked();
            other_checked = add_other.isChecked();
            text = text_repeat.getText().toString().trim();
            number  = 0;
            if(count.getText().toString().trim().length() != 0) {
                number = Integer.parseInt(count.getText().toString());
            } else {
                Toast.makeText(MainActivity.this, "Please Enter the Count", Toast.LENGTH_SHORT).show();
            }
            o_char = other_char.getText().toString().trim();
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = Repeater.repeat(text,number,space_checked,new_line_checked,other_checked,o_char);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            display.setText(s);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
