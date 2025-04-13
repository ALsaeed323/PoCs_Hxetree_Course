package com.android.zerohextree;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startExploitButton = findViewById(R.id.start_exploit_button);

        startExploitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExploitSelectionDialog();
            }
        });
    }

    private void showExploitSelectionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Exploit to Run");

        // Creating an array of exploit options
        final String[] exploitOptions = {"Start Flag5 Exploit", "Start Flag7 Exploit", "Start Flag8 Exploit","Start Flag9 Exploit","Start Flag10 Exploit",
                "Start Flag11 Exploit","Start Flag12 Exploit","Start Flag22 Exploit","Start Flag23 Exploit","Start Flag14 Exploit","Start Flag15 Exploit"
        , "Start Flag30 Exploit","Start Flag31 Exploit","Start Flag32 Exploit","Start Flag33_1 Exploit","Start Flag33_2 Exploit","Start Flag34 Exploit"
                ,"Start Flag35 Exploit","Start Flag36 Exploit","Start Flag38 Exploit","Start Flag39 Exploit","Start Flag40 Exploit","Start Flag41 Exploit"
                ,"Start Flag16 Exploit","Start Flag18 Exploit","Start Flag17 Exploit","Start Flag19 Exploit","Start Flag20 Exploit","Start Flag21 Exploit"
                ,"Start Flag24 Exploit","Start Flag25 Exploit","Start Flag26 Exploit","Start Flag27 Exploit","Start Flag28 Exploit","Start Flag29 Exploit"};

        // Track the selected item
        final int[] selectedIndex = {0}; // Default to first option (Flag5)

        builder.setSingleChoiceItems(exploitOptions, selectedIndex[0], new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedIndex[0] = which; // Update the selected index
            }
        });

        builder.setPositiveButton("Run Exploit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;

                switch (selectedIndex[0]) {
                    case 0: // Flag5
                        intent = new Intent(MainActivity.this, flag5.class);
                        break;
                    case 1: // Flag7
                        intent = new Intent(MainActivity.this, flag7.class);
                        break;
                    case 2: // Flag8
                        intent = new Intent(MainActivity.this, HextreeFlag8.class);
                        break;

                    case 3: // Flag9
                        intent = new Intent(MainActivity.this, Hextreefalg9.class);
                        break;
                    case 4: // Flag10
                        intent = new Intent(MainActivity.this, flag10.class);
                        break;
                    case 5: // Flag11
                        intent = new Intent(MainActivity.this, flag11.class);
                        break;
                    case 6: // Flag12
                        intent = new Intent(MainActivity.this, flag12.class);
                        break;
                    case 7: // Flag22
                        intent = new Intent(MainActivity.this, flag22.class);
                        break;
                    case 8: // Flag23
                        intent = new Intent(MainActivity.this, HijackActivity.class);
                        break;
                    case 9: // Flag14
                        intent = new Intent(MainActivity.this, ExploitFlag14.class);
                        break;
                    case 10: // Flag15
                        intent = new Intent(MainActivity.this, flag15.class);
                        break;
                    case 11: // Flag30
                        intent = new Intent(MainActivity.this, flag30.class);
                        break;
                    case 12: // Flag31
                        intent = new Intent(MainActivity.this, flag31.class);
                        break;
                    case 13: // Flag32
                        intent = new Intent(MainActivity.this, flag32.class);
                        break;
                    case 14: // Flag33_1
                        intent = new Intent(MainActivity.this, flag33_1.class);
                        break;
                    case 15: // Flag33_2
                        intent = new Intent(MainActivity.this, flag33_2.class);
                        break;
                    case 16: // Flag34
                        intent = new Intent(MainActivity.this, flag34.class);
                        break;
                    case 17: // Flag35
                        intent = new Intent(MainActivity.this, flag35.class);
                        break;
                    case 18: // Flag36
                        intent = new Intent(MainActivity.this, flag36.class);
                        break;
                    case 19: // Flag38
                        intent = new Intent(MainActivity.this, flag38.class);
                        break;
                    case 20: // Flag39
                        intent = new Intent(MainActivity.this, flag39.class);
                        break;
                    case 21: // Flag40
                        intent = new Intent(MainActivity.this, flag40.class);
                        break;
                    case 22: // Flag41
                        intent = new Intent(MainActivity.this, flag41.class);
                        break;
                    case 23: // Flag16
                        intent = new Intent(MainActivity.this, flag16.class);
                        break;
                    case 24: // Flag18
                        intent = new Intent(MainActivity.this, flag18.class);
                        break;
                    case 25: // Flag17
                        intent = new Intent(MainActivity.this, flag17.class);
                        break;
                    case 26: // Flag19
                        intent = new Intent(MainActivity.this, flag19.class);
                        break;
                    case 27: // Flag20
                        intent = new Intent(MainActivity.this, flag20.class);
                        break;
                    case 28: // Flag21
                        intent = new Intent(MainActivity.this, flag21.class);
                        break;
                    case 29: // Flag24
                        intent = new Intent(MainActivity.this, flag24.class);
                        break;
                    case 30: // Flag25
                        intent = new Intent(MainActivity.this, flag25.class);
                        break;
                    case 31: // Flag26
                        intent = new Intent(MainActivity.this, flag26.class);
                        break;
                    case 32: // Flag27
                        intent = new Intent(MainActivity.this, flag27.class);
                        break;
                    case 33: // Flag28
                        intent = new Intent(MainActivity.this, flag28.class);
                        break;
                    case 34: // Flag29
                        intent = new Intent(MainActivity.this, flag29.class);
                        break;


                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
