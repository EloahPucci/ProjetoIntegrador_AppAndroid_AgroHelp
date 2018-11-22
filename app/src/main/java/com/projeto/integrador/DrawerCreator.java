package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class DrawerCreator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayoutMain;
    private ActionBarDrawerToggle actionBarDrawerToggleMain;
    private NavigationView navigationViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.inclusao);
        int layoutid = savedInstanceState.getInt("layout");
        View view = getLayoutInflater().inflate(layoutid, layout, false);
        layout.addView(view);

        /**Linha 27 à linha 37 -> Implementação de Drawer_menu**/
        drawerLayoutMain = (DrawerLayout) findViewById(R.id.activity_main);

        actionBarDrawerToggleMain = new ActionBarDrawerToggle(this, drawerLayoutMain, R.string.abrir, R.string.fechar);

        drawerLayoutMain.addDrawerListener(actionBarDrawerToggleMain);
        actionBarDrawerToggleMain.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationViewMain = (NavigationView) findViewById(R.id.navigationMain);
        navigationViewMain.setNavigationItemSelectedListener(this);

    }

    /**
     * Este método controla o abrir e fechar do Drawer_menu
     **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggleMain.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    /**
     * Este método controla o que cada item do Drawer_menu irá fazer
     **/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Intent intent;
        switch (id) {

            case R.id.propostas:
                intent = new Intent(this, PropostasActivity.class);
                startActivity(intent);
                break;
            case R.id.user:
                intent = new Intent(this, CadastroActivity.class);
                startActivity(intent);
                break;
        }

        return false;
    }
}
