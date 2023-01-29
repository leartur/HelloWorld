package com.example.helloworldthree;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDisplayButton(); // calling option to perform method upon first starting app
        initClearButton();
    }
    private void initDisplayButton()    {                               //private method only usable by this class
        Button displayButton = findViewById(R.id.buttonDisplay) ;       //associate code w/button in layout via findViewById command & id of the button/widget
        displayButton.setOnClickListener(new View.OnClickListener() {   //attaching click listener to display button so the following method/action is performed if button is clicked
                                                                        // ^^^ can be replaced with lambda

            @Override                                                   //display input in text view if clicked
            public void onClick(View view) {
                EditText editName = findViewById(R.id.editTextFirstName) ;   // reference input field
                EditText editLast = findViewById(R.id.editTextLastName) ;
                                                            // REFERENCING LAST NAME INPUT FIELD
                TextView textDisplay = findViewById(R.id.textViewDisplay)   ;   //reference where text will be displayed
                String firstToDisplay = editName.getText().toString()    ;           //retrieve user input > store data in string nameToDisplay
                String lastToDisplay = editLast.getText().toString()    ;

                Resources res = getResources(); //asking system for access to the values files
                String displayString = res.getString(R.string.welcome_message, firstToDisplay, lastToDisplay)   ; // creating string with a message and name
                textDisplay.setText(displayString)   ; // changed FROM textDisplay.setText("Hello " + nameToDisplay)
            }
        });
    }

    private void initClearButton()  {   //private clear method
        Button clearButton = findViewById(R.id.buttonClear) ; // associate code w/clear button in layout via findViewById command & id of clear button/widget
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            EditText editName = findViewById(R.id.editTextFirstName)   ;
            EditText editLast = findViewById(R.id.editTextLastName)    ;

            editName.setText("")    ;
            editLast.setText("")    ;

            /*
            TextView textDisplay = findViewById(R.id.textViewDisplay)   ;   //reference where text will be displayed

                Resources res = getResources(); //asking system for access to the values files
               String displayString    ; // creating string with a message and name
                textDisplay.setText("Hello World!");

                 */
            }
        });
    }
}