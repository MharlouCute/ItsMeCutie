package com.example.debtcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editname,editMoney,editLocation,editDate;
    Button btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editname = (EditText)findViewById(R.id.ename);
        editMoney = (EditText)findViewById(R.id.eMoney);
        editLocation = (EditText)findViewById(R.id.elocation);
        editDate = (EditText)findViewById(R.id.edate);
        btnsave = (Button) findViewById(R.id.btnreserve);
        AddData();

    }

    public void AddData(){
        btnsave = (Button) findViewById(R.id.btnreserve);
        btnsave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtName = editname.getText().toString();
                String txtMoney = editMoney.getText().toString();
                String txtLocation = editLocation.getText().toString();
                String txtDate = editDate.getText().toString();

                boolean isInserted =  myDb.insertData(txtName,txtMoney,txtLocation,txtDate);
                if(isInserted =  true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}