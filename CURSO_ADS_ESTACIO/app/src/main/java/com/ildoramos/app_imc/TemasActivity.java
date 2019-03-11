package com.ildoramos.app_imc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class TemasActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener, View.OnClickListener {


    private CheckBox ckdCi;
    private CheckBox ckdFu;
    private CheckBox ckdGa;
    private CheckBox ckdIn;
    private CheckBox ckdLi;
    private CheckBox ckdTe;
    private TextView txtSel;
    private Button btnEX;
    private Button btnDes;
    private int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);

        ckdCi = findViewById(R.id.ckdCinema);
        ckdFu = findViewById(R.id.ckdFutubol);
        ckdGa = findViewById(R.id.ckdGastronomia);
        ckdIn = findViewById(R.id.ckdInformatica);
        ckdLi = findViewById(R.id.ckdLiteratura);
        ckdTe = findViewById(R.id.ckdTeatro);

        txtSel= findViewById(R.id.txtTotalSelecionado);
        btnEX = findViewById(R.id.btnExibir);
        btnDes = findViewById(R.id.btnDesmarcar);


        ckdCi.setOnCheckedChangeListener(this);
        ckdFu.setOnCheckedChangeListener(this);
        ckdGa.setOnCheckedChangeListener(this);
        ckdIn.setOnCheckedChangeListener(this);
        ckdLi.setOnCheckedChangeListener(this);
        ckdTe.setOnCheckedChangeListener(this);

        btnEX.setOnClickListener( this);
        btnDes.setOnClickListener(this);

        cont=0;

        exibirSeleconados();
    }

    private void exibirSeleconados() {

        //Recuperar texto contino no TextView
        String txt = getResources().getString(R.string.txt_selecionados);
        txtSel.setText(String.format("%s=%d",txt,cont));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked){
            cont++;
        }else {
            cont--;
        }
        exibirSeleconados();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnExibir:
                String txt = "Temas Selecionados\n\n";
                txt+=ckdCi.isChecked()?"Cinema\n":"";
                txt+=ckdFu.isChecked()?"Futebol\n":"";
                txt+=ckdGa.isChecked()?"Gastronomia\n":"";
                txt+=ckdIn.isChecked()?"Informatica\n":"";
                txt+=ckdLi.isChecked()?"Literatura\n":"";
                txt+=ckdTe.isChecked()?"Teatro\n":"";

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage(txt);
                dlg.setPositiveButton("OK",null);
                dlg.show();
                break;

            case R.id.btnDesmarcar:
                ckdCi.setChecked(false);
                ckdFu.setChecked(false);
                ckdGa.setChecked(false);
                ckdIn.setChecked(false);
                ckdLi.setChecked(false);
                ckdTe.setChecked(false);

                break;

        }
    }
}
