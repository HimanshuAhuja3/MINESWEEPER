package com.example.himanshu.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout rootLayout;
    public int SIZE = 5;
    public ArrayList<LinearLayout> rows;
    public MSButton[][] board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.rootLayout);
        setupBoard();
    }

    private void setupBoard() {
        rows = new ArrayList<>();
        board = new MSButton[SIZE][SIZE];
        rootLayout.removeAllViews();

        for (int i = 0; i < SIZE; i++) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(linearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
            linearLayout.setLayoutParams(layoutParams);
            rootLayout.addView(linearLayout);
            rows.add(linearLayout);
        }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    MSButton msButton=new MSButton(this);
                    LinearLayout.LayoutParams layoutParams=
                            new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);

                    msButton.setLayoutParams(layoutParams);
                    msButton.setOnClickListener(this);
                    LinearLayout row=rows.get(i);
                    row.addView(msButton);
                    board[i][j]=msButton;
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_value,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.reset)
        {
            setupBoard();
        }
        else if(id==R.id.item1)
        {
            SIZE=5;
            setupBoard();
        }
        else if(id==R.id.item2)
        {
            SIZE=6;
            setupBoard();
        }
        else if(id==R.id.item3)
        {
            SIZE=7;
            setupBoard();
        }
        else if(id==R.id.item4)
        {
            SIZE=8;
            setupBoard();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
