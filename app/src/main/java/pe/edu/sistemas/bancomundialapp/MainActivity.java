package pe.edu.sistemas.bancomundialapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Llamar(View view)
    {
        //Intent i =new Intent(this,TableActivity.class);
        Intent i =new Intent(this,TestActivity.class);
        startActivity(i);
    }
}
