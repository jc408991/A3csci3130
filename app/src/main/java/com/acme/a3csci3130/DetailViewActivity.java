package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 *
 */

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, businessField, addressField, provinceField;
    Contact receivedBusinessInfo;
    private MyApplicationData appState;

    /**
     * Method that creates a new Detail View Activity when a business is added to the database to
     * display the current data the database has on that business
     *
     * @param savedInstanceState latest add data to be updated
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Contact)getIntent().getSerializableExtra("Business");

        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedBusinessInfo != null){
            nameField.setText(receivedBusinessInfo.name);
            numberField.setText(receivedBusinessInfo.number);
            businessField.setText(receivedBusinessInfo.business);
            addressField.setText(receivedBusinessInfo.address);
            provinceField.setText(receivedBusinessInfo.province);
        }
    }

    /**
     * Method that updates the current info of a business with new user inputted information
     *
     * @param v view that is passed in by the "Update Data" button
     */

    public void updateContact(View v){
        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        nameField.setText(receivedBusinessInfo.name);
        numberField.setText(receivedBusinessInfo.number);
        businessField.setText(receivedBusinessInfo.business);
        addressField.setText(receivedBusinessInfo.address);
        provinceField.setText(receivedBusinessInfo.province);

    }

    /**
     * Method that deletes a selected business from the database
     *
     * @param v view that is passed in by the "Delete Contact" button
     */

    public void eraseContact(View v)
    {
        appState.firebaseDBInstance.getReference().child(receivedBusinessInfo.uid).removeValue();

    }
}
