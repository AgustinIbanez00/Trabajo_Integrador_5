package com.agustin.trabajointegrador5.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.agustin.trabajointegrador5.R;
import com.agustin.trabajointegrador5.model.Usuario;
import com.agustin.trabajointegrador5.ui.login.LoginActivity;
import com.agustin.trabajointegrador5.ui.login.LoginViewModel;

public class RegisterActivity extends AppCompatActivity {

    RegisterViewModel mainViewModel;

    EditText etUsername, etPassword, etEmail;
    Button btnRegistro;
    Intent intent;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        configView();

        mainViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        mainViewModel.getClienteMutableLiveData().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if(usuario != null)
                {
                    etUsername.setText(usuario.getUsername());
                    etPassword.setText(usuario.getPassword());
                    etEmail.setText(usuario.getCorreo());
                    btnRegistro.setText("Guardar cambios");
                }
            }
        });
        intent = getIntent();
        value = intent.getStringExtra("l");
        if(value != null)
        {
            if(value.equals("1"))
            {
                mainViewModel.obtener();
            }
        }
    }

    private void configView()
    {
        etUsername = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etContraseña);
        etEmail = findViewById(R.id.etCorreo);
        btnRegistro = findViewById(R.id.btnRegistrarse);
        btnRegistro.setText("Registrarse");
    }

    public void register(View view)
    {
        if(value.equals("1"))
        {
            mainViewModel.register(etUsername.getText().toString(), etPassword.getText().toString(), etEmail.getText().toString());
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }
        else
        {
            mainViewModel.register(etUsername.getText().toString(), etPassword.getText().toString(), etEmail.getText().toString());
        }

    }

}
