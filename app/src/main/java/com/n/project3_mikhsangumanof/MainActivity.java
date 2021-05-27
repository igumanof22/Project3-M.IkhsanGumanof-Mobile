package com.n.project3_mikhsangumanof;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spin1,spin2;
    Button btnSub,btnNext,btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1ItemListener();
        spin2AddItemListener();
        addButtonSubmitAction();
        addButtonNextAction();
        addButtonExitAction();
    }

    private void spin1ItemListener() {
        spin1 = findViewById(R.id.Spin1);

        spin1.setOnItemSelectedListener(new Spinner1ItemListener());
    }

    private void spin2AddItemListener() {
        spin2 = findViewById(R.id.Spin2);

        List<String> arraySkill = new ArrayList<>();

        arraySkill.add("Basic");
        arraySkill.add("Intermediate");
        arraySkill.add("Advance");

        ArrayAdapter<String> adapterSkill = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySkill);
        adapterSkill.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapterSkill);
    }

    private void addButtonSubmitAction() {
        spin1 = findViewById(R.id.Spin1);
        spin2 = findViewById(R.id.Spin2);
        btnSub = findViewById(R.id.btnSubmit);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Pilihan Bahasa Pemograman : "+spin1.getSelectedItem().toString()+
                                "\nPilihan Skill Pemograman : "+spin2.getSelectedItem(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addButtonNextAction() {
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Exit() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("KELUAR").setIcon(R.drawable.exit).setMessage("Anda Yakin Ingin Keluar?")
        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        })
        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void addButtonExitAction() {
        btnExit = findViewById(R.id.btnExit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Exit();
    }
}
