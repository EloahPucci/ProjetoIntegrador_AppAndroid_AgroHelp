package com.projeto.integrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CadastroActivity extends DrawerCreator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_cadastro);
        super.onCreate(savedInstanceState);
    }
}
