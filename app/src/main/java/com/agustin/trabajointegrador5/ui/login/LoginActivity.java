package com.agustin.trabajointegrador5.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.agustin.trabajointegrador5.R;
import com.agustin.trabajointegrador5.model.Usuario;
import com.agustin.trabajointegrador5.ui.register.RegisterActivity;
import com.agustin.trabajointegrador5.ui.register.RegisterViewModel;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel mainViewModel;
    Usuario usuario_act;
    EditText etUsername;
    EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        configView();

        mainViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        mainViewModel.getClienteMutableLiveData().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                usuario_act.setUsername(usuario.getUsername());
                usuario_act.setPassword(usuario.getPassword());
                usuario_act.setCorreo(usuario.getCorreo());
            }
        });
    }

    private void configView()
    {
        etUsername = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etContraseña);
    }

    public void login(View view)
    {
        if(mainViewModel.login(etUsername.getText().toString(), etPassword.getText().toString()) != null)
        {
            Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
            i.putExtra("l", "1");
            startActivity(i);
        }
    }

}
