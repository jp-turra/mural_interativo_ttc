package com.novacasa.tictactoe_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ImageView buttonUp, buttonDown, buttonRight, buttonLeft, buttonAction;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuItemBluetoothConnect){
            Toast.makeText(this, "Opção bluetooth em dev.", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAction  = findViewById(R.id.buttonAction);
        buttonDown  = findViewById(R.id.buttonDown);
        buttonLeft  = findViewById(R.id.buttonLeft);
        buttonRight  = findViewById(R.id.buttonRight);
        buttonUp  = findViewById(R.id.buttonUp);

        
    }
}