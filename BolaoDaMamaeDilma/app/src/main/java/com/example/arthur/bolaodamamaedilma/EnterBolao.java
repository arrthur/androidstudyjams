package com.example.arthur.bolaodamamaedilma;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;



public class EnterBolao extends FragmentActivity implements DatePickerDialog.OnDateSetListener {
    String nome;
    Boolean lulaPreso;
    String dataEscolhida;
    public final static String NOMEINTENT = "com.example.arthur.bolaodamamaedilma.EnterBolao.NOMEINTENT";
    public final static String DATAINTENT = "com.example.arthur.bolaodamamaedilma.EnterBolao.DATAINTENT";
    public final static String CHECKLULAINTENT = "com.example.arthur.bolaodamamaedilma.EnterBolao.CHECKLULAINTENT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_bolao);

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        dataEscolhida = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(), (EnterBolao)getActivity(), year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

        }


    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");

    }

    public void saveBolao(View view){
        Intent intent = new Intent(this, SucessBolao.class);
        EditText editText = (EditText) findViewById(R.id.nome);
        CheckBox lula_checkbox = (CheckBox) findViewById(R.id.lula_preso);
        lulaPreso = lula_checkbox.isChecked();
        nome = editText.getText().toString();
        intent.putExtra(NOMEINTENT, nome);
        intent.putExtra(CHECKLULAINTENT, lulaPreso);
        intent.putExtra(DATAINTENT, dataEscolhida);
        if (dataEscolhida==null) {
            Toast.makeText(this, "Informe a data", Toast.LENGTH_SHORT).show();
        }
        else {
            if(TextUtils.isEmpty(nome)){
                Toast.makeText(this, "Informe o seu nome", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(intent);
            }
        }


    }

}
