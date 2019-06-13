package com.example.motochika.weatherreport;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * トップ画面を制御するActivityクラス.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 画面を表示する.

     * @param savedInstanceState savedInstanceState
     */
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.button1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextView();
            }
        });

    }

    /**
     * テキストラベルを変更する.
     */

    public void changeTextView() {
        // 非同期処理(AsyncHttpRequest#doInBackground())を呼び出す
        try {
            new AsyncHttpRequest(this).execute(new URL("http://weather.livedoor.com/forecast/webservice/json/v1?city=270000"));
            Log.d("MainActivity","good");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}