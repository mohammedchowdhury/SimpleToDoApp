package coolguy.com.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static coolguy.com.simpletodo.MainActivity.ITEM_POSITION;
import static coolguy.com.simpletodo.MainActivity.ITEM_TEXT;


public class EditItemActivity extends AppCompatActivity {


    //track edit text
    EditText etItemText;

    //position of edit items in list
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        //resolve edit text from layout
        etItemText = (EditText)findViewById(R.id.etItemText);

        //set edit text value from intent extra
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));

        //update postion from intent exras

        position = getIntent().getIntExtra(ITEM_POSITION,0);

        getSupportActionBar().setTitle("Edit Item");


    }

    /// save when button clicked
    public void onSaveItem(View v){
        //prepare new intent for result
        Intent i = new Intent();

        //pass updated item text as extras
        i.putExtra(ITEM_TEXT,etItemText.getText().toString());

        //pass original position as extras
        i.putExtra(ITEM_POSITION, position);

        //set intent as the reseult of the activity
        setResult(RESULT_OK,i);

        //close the activity and redirect back to main;
        finish();

    }


}
