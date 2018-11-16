package cz.radejova.kaja.vedmak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import org.jetbrains.annotations.NotNull;

public class ResultActivity extends AppCompatActivity {
    private TextView result_textView_question;
    private ImageView result_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result_textView_question = findViewById(R.id.result_textView_question);


        //Hawk.init(this).build();

        //Hawk.get("otazka");
        String otazka = getIntent().getStringExtra("otazka");

        result_textView_question.setText(otazka);

        final Gson gson = new Gson();
        String url = "https://yesno.wtf/api?fbclid=IwAR0KcCLyK5HXnlHs5bmxxWJnhgO1nJqWtZlZSOtlOq9B_AuM2bOhDTzXSvY";
        Fuel.get(url).responseString(new com.github.kittinunf.fuel.core.Handler<String>() {
            @Override
            public void success(@NotNull Request request, @NotNull Response response, String s) {
                Answer answer = gson.fromJson(s, Answer.class);

                Log.d("Vedmak", answer.forced.image.url);

                Glide.with(ResultActivity.this).load(answer.forced.image.url).into(result_image);

            }

            @Override
            public void failure(@NotNull Request request, @NotNull Response response, @NotNull FuelError fuelError) {

            }
        });
    }
}
