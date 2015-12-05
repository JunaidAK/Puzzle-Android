package com.example.aptech.puzzle;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button [] buttons = new Button[16];

        buttons[0] = (Button) findViewById(R.id.n1);
        buttons[1] = (Button) findViewById(R.id.n2);
        buttons[2] = (Button) findViewById(R.id.n3);
        buttons[3] = (Button) findViewById(R.id.n4);
        buttons[4] = (Button) findViewById(R.id.n5);
        buttons[5] = (Button) findViewById(R.id.n6);
        buttons[6] = (Button) findViewById(R.id.n7);
        buttons[7] = (Button) findViewById(R.id.n8);
        buttons[8] = (Button) findViewById(R.id.n9);
        buttons[9] = (Button) findViewById(R.id.n10);
        buttons[10] = (Button) findViewById(R.id.n11);
        buttons[11] = (Button) findViewById(R.id.n12);
        buttons[12] = (Button) findViewById(R.id.n13);
        buttons[13] = (Button) findViewById(R.id.n14);
        buttons[14] = (Button) findViewById(R.id.n15);
        buttons[15] = (Button) findViewById(R.id.n16);


        String [] numlist = new String[16];
        Random r = new Random();
        int a = r.nextInt(16);
        boolean p = true;


        for (int i = 0; i < 16; i++)
        {
            numlist[i] = "-1";
            buttons[i].setHint(i+"");
        }

        int i = 0;
        while (i < 16)
        {
            for (int j = 0; j < 16; j++)
            {
                if (numlist[j] != "-1")
                {
                    if (numlist[j] == Integer.toString(a))
                    {
                        p = false;
                        break;
                    }
                }
            }

            if (p == true)
            {
                numlist[i] = Integer.toString(a);
                i++;
            }
            else
            {
                a = r.nextInt(16);
            }
            p = true;
        }

        for (int j = 0; j < 16; j++)
        {
            if (numlist[j] != Integer.toString(0))
            {
                buttons[j].setText(numlist[j]);
            }
            else
            {
                buttons[j].setText(" ");
            }
        }

        for (int j = 0; j < 16; j++)
        {
            buttons[j].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Button b = (Button) v;
                    int index = Integer.parseInt(b.getHint().toString());

                    if (((index + 1) % 4 != 0) && index < 15 && buttons[index + 1].getText().toString() == " ")
                    {
                        buttons[index + 1].setText(b.getText().toString());
                        b.setText(" ");
                    }

                    else if ((index % 4 != 0) && index > 0 && buttons[index - 1].getText().toString() == " ")
                    {
                        buttons[index - 1].setText(b.getText().toString());
                        b.setText(" ");
                    }

                    else if (index < 12 && buttons[index + 4].getText().toString() == " ")
                    {
                        buttons[index + 4].setText(b.getText().toString());
                        b.setText(" ");
                    }

                    else if (index > 3 && buttons[index - 4].getText().toString() == " ")
                    {
                        buttons[index - 4].setText(b.getText().toString());
                        b.setText(" ");
                    }
                }
            });
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
