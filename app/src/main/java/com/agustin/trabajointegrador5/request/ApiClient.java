package com.agustin.trabajointegrador5.request;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.agustin.trabajointegrador5.model.Usuario;

import java.sql.Date;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context)
    {
        if(sp == null) sp = context.getSharedPreferences("datos", 0);
        return sp;
    }

    public static void guardar(Context context, Usuario usuario)
    {
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Username", usuario.getUsername());
        editor.putString("Password", usuario.getPassword());
        editor.putString("Email", usuario.getCorreo());
//        editor.putString("FechaNac",  usuario.getFecha_nacimiento().toString());
        editor.commit();
    }

    public static Usuario leer(Context context)
    {
        SharedPreferences sp = conectar(context);
        String username = sp.getString("Username", "-1");
        String password = sp.getString("Password", "-1");
        String email = sp.getString("Email", "-1");
        String fechaNac = sp.getString("FechaNac", "-1");


        Usuario usuario = new Usuario(username, password, email);
        return usuario;
    }

    public static Usuario login(Context context, String username, String password)
    {
        SharedPreferences sp = conectar(context);
        Usuario usuario = leer(context);

        if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password))
        {
            return usuario;
        }
        else return null;
    }

}
