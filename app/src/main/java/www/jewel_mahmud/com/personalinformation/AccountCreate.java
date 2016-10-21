package www.jewel_mahmud.com.personalinformation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountCreate extends AppCompatActivity {

    EditText contactName, contactMobile, contactEMail;
    private Button create;

    Context context = this;
    UserDBHelper userDBHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create);

        contactName = (EditText) findViewById(R.id.name);
        contactMobile = (EditText) findViewById(R.id.phone);
        contactEMail = (EditText) findViewById(R.id.email);


        create = (Button) findViewById(R.id.create_account);
    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = contactName.getText().toString();
                String mob = contactMobile.getText().toString();
                String email = contactEMail.getText().toString();

                if(!name.equals("") && !mob.equals("") && !email.equals("")) {


                    userDBHelper = new UserDBHelper(context);
                    sqLiteDatabase = userDBHelper.getWritableDatabase();

                    userDBHelper.insertInformation(name, mob, email, sqLiteDatabase);
                    Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();


                    userDBHelper.close();
                }
                else{
                    Toast.makeText(getBaseContext(), "Please Fill up everything.", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
