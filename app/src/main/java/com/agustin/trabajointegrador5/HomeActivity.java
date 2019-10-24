package com.agustin.trabajointegrador5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.agustin.trabajointegrador5.R;
import com.agustin.trabajointegrador5.ui.login.LoginActivity;
import com.agustin.trabajointegrador5.ui.register.RegisterActivity;
import com.agustin.trabajointegrador5.ui.register.RegisterViewModel;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openRegister(View view)
    {
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
    }

    public void  openLogin(View view)
    {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }



}
