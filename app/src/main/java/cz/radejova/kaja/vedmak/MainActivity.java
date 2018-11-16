package cz.radejova.kaja.vedmak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    private EditText main_editText_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hawk.init(this).build();


    }

    public void askQuestion(View view) {
        main_editText_question = findViewById(R.id.main_editText_question);

        String otazka = main_editText_question.getText().toString();

        /*if (otazka.length()== 0) {
            Toast.makeText(this, "Zeptej se a nezapomeň na otazník :-)", Toast.LENGTH_LONG).show();
        } else {
            //Hawk.put("otazka", otazka);*/
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("otazka", otazka);
        startActivity(intent);


    }


}

