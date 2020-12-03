package com.example.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Define second activity */
        Button buttonOpenSecondActivity = findViewById(R.id.second_activity);

        /* On click*/
        buttonOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        /* Define  dialog */
        Button buttonOpenDialog = findViewById(R.id.open_dialog);

        /* On click do  */
        buttonOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Define dialog */
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle(R.string.dialog_description);

                builder.setPositiveButton(R.string.dialog_positive_text, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast toast = Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                builder.setNegativeButton(R.string.dialog_negative_text, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast toast = Toast.makeText(MainActivity.this, "You closed dialog", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                /* Members array */
                final String [] selectedItems = getResources().getStringArray(R.array.team_member_names);

                /* Multiple choice of members*/
                builder.setMultiChoiceItems(R.array.team_member_names, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            /* Notifications based on action */
                            @Override
                            public void onClick(DialogInterface dialog, int name, boolean selected) {
                                if (selected) {
                                    Toast.makeText(MainActivity.this, selectedItems[name] + " checked",Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, selectedItems[name] + " unchecked",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                /* Show dialog */
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
