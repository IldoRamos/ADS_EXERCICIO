package com.ildoramos.app_imc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener{

    //ATRIBUTOS
    private EditText edtPeso;
    private EditText edtAltura;
    private EditText edtResultado;
    private Button btnCalcular;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //REFERENCIAR OS CONTROLES
        edtPeso =  findViewById(R.id.edtPeso);
        edtAltura =findViewById(R.id.edtAltura);
        edtResultado =findViewById(R.id.edtResultado);

        btnCalcular =findViewById(R.id.btnCalcular);
        btnLimpar =findViewById(R.id.btnLimpar);

        //ASSOCIAR TRATADOR DE EVENTOS
        btnCalcular.setOnClickListener( this);
        btnLimpar.setOnClickListener( this);

    }


    // TRATATOR DE EVENTOS
    public void onClick(View v) {
        if ( v.getId() == R.id.btnCalcular){
            double peso =Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado =(peso/Math.pow(altura,2));

            edtResultado.setText(String.format("%.2f",resultado));


            //Adicionar Caixas de Diálogos (Dialogs)
           /* AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.app_name);
            dlg.setMessage(String.format("IMC= %.2f",resultado));
            dlg.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {}});
            dlg.show();*/

        }else if ( v.getId() == R.id.btnLimpar){
            edtPeso.setText("");
            edtAltura.setText("");
            edtResultado.setText("");
            edtPeso.requestFocus();

            Toast.makeText(this,"Os dados foram apagados com sucesso!",Toast.LENGTH_LONG).show();
        }
    }



}
