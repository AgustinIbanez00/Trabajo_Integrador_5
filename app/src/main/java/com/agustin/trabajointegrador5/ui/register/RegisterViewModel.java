package com.agustin.trabajointegrador5.ui.register;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agustin.trabajointegrador5.model.Usuario;
import com.agustin.trabajointegrador5.request.ApiClient;

public class RegisterViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> clienteMutableLiveData;
    Context context;

    public MutableLiveData<Usuario> getClienteMutableLiveData() {
        if(clienteMutableLiveData == null)
            clienteMutableLiveData = new MutableLiveData<>();
        return clienteMutableLiveData;
    }

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void register(String username, String password, String email)
    {
        Usuario usuario = new Usuario(username, password, email);
        ApiClient.guardar(context, usuario);
        clienteMutableLiveData.setValue(usuario);
    }

    public void obtener()
    {
        clienteMutableLiveData.setValue(ApiClient.leer(context));
    }

}
