package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField,numberField, businessField, addressField, provinceField;
    private MyApplicationData appState;

    /**
     * Method that creates a new Create Contact activity and connects the Button and EditText
     * variables to objects made in the corresponding XML file
     *
     * @param savedInstanceState is the most recent app data so app is updated correctly
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
    }

    /**
     *  Method that creates a new business and adds the inputted data to the firebase database
     *  when the Create Business button is clicked
     *
     * @param v is the view variable passed in by the button
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String businessID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        int number = Integer.parseInt(numberField.getText().toString());
        String business = businessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact newBusiness = new Contact(businessID, name, number, business, address, province);

        appState.firebaseReference.child(businessID).setValue(newBusiness);

        finish();

    }
}
