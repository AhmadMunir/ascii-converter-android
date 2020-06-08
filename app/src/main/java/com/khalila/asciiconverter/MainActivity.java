package com.khalila.asciiconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button gen_btn;
    EditText stock, ascii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gen_btn = (Button) findViewById(R.id.btn_gen);
        stock = (EditText) findViewById(R.id.stock_char);
        ascii = (EditText) findViewById(R.id.ascii);
        ascii.setEnabled(false);

        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ori = stock.getText().toString();
                if (ori.length() != 0){
                    if (ori.length() < 2){
                        GetAscii(ori);
                    }else {
                        Toast.makeText(MainActivity.this, "Input just 1 character", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Character cant be null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void GetAscii(String ori) {
        char ch_ori = ori.charAt(0);
        int ch_ascii = (int) ch_ori;

        ascii.setText(Integer.toString(ch_ascii));
    }

}