package com.agustin.trabajointegrador5.ui.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agustin.trabajointegrador5.model.Usuario;
import com.agustin.trabajointegrador5.request.ApiClient;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> clienteMutableLiveData;
    Context context;

    public MutableLiveData<Usuario> getClienteMutableLiveData() {
        if(clienteMutableLiveData == null)
            clienteMutableLiveData = new MutableLiveData<>();
        return clienteMutableLiveData;
    }

    public LoginViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public Usuario login( String username, String password)
    {
        return ApiClient.login(context, username, password);
    }

}
