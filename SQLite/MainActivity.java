import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button insert, delete, update, view, condition;
    EditText name, contact, dob;
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.am1_btn_insert);
        delete = findViewById(R.id.am1_btn_delete);
        update = findViewById(R.id.am1_btn_update);
        view = findViewById(R.id.am1_btn_viewAll);

        name = findViewById(R.id.am1_edt_name);
        contact = findViewById(R.id.am1_edt_contact);
        dob = findViewById(R.id.am1_edt_dateOfBirth);

        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        view.setOnClickListener(this);
        delete.setOnClickListener(this);

         db= new DBhelper(this);
    }

    @Override
    public void onClick(View v) {
      
      // insert
        if(v.getId() == R.id.am1_btn_insert)
        {
            String txt_name = name.getText().toString();
            String txt_contact = contact.getText().toString();
            String txt_dob = dob.getText().toString();

            Boolean insertData = db.inserUserData(txt_name,txt_contact,txt_dob);
          
            if(insertData == true)
            {
                Toast.makeText(this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Not Inserted", Toast.LENGTH_SHORT).show();
            }
        }
      
      
      // update
        else if(v.getId() == R.id.am1_btn_update)
        {
            String txt_name = name.getText().toString();
            String txt_contact = contact.getText().toString();
            String txt_dob = dob.getText().toString();

            Boolean updateData = db.upadateUserData(txt_name,txt_contact,txt_dob);

            if(updateData == true)
            {
                Toast.makeText(this, " Updated", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        }
      
      
      // delete
        else if(v.getId()== R.id.am1_btn_delete)
        {
            String txt_name = name.getText().toString();

            Boolean deleteData = db.deleteData(txt_name);

            if(deleteData == true)
            {
                Toast.makeText(this, " Deleted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Not Deleted", Toast.LENGTH_SHORT).show();
            }

        }
      
      
      // shwowing data
      else if(v.getId() == R.id.am1_btn_viewAll)
        {
            Cursor res = db.getData();
            if(res.getCount() ==0)
            {
                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            }
            StringBuffer stringBuffer = new StringBuffer();
                while(res.moveToNext())
                {
                    //stringBuffer.append("Name: "+res.getString(Column number)+"\n");
                    stringBuffer.append("Name: "+res.getString(0)+"\n");
                    stringBuffer.append("Contact: "+res.getString(1)+"\n");
                    stringBuffer.append("Date Of birth: "+res.getString(2)+"\n\n\n");
                }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true).setTitle("User Entities").setMessage(stringBuffer.toString()).show();
        }
      
      

    }
}
