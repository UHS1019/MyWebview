package com.example.mywebview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editUrl;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.editUrl);
        webview = findViewById(R.id.webView);

        webview.setWebViewClient(new WebViewClient());

        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnGoNaver).setOnClickListener(this);
        findViewById(R.id.btnGoGoogle).setOnClickListener(this);
        findViewById(R.id.btnBack).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editUrl.getWindowToken(), 0);

        switch (v.getId()){
            case R.id.btnClear:
                editUrl.setText("");
                break;
            case R.id.btnGoNaver:
                webview.loadUrl("https://search.naver.com/search.naver?query=" + editUrl.getText().toString());
                break;
            case R.id.btnGoGoogle:
                webview.loadUrl("https://www.google.com/search?q=" + editUrl.getText().toString());
                break;
            case R.id.btnBack:
                webview.goBack();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.menu1:
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("TEST")
                   .setMessage("안녕하세요")
                   .setPositiveButton("확인", null)
                   .show();
                break;
            case R.id.menu2:
                View dlgView = View.inflate(this, R.layout.profile, null);
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(this);
                dlg2.setTitle("이름 변경")
                        .setView(dlgView)
                        .setIcon(R.drawable.googlelogo)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //EditText를 읽어서 앱의 Title바에 세팅
                                EditText editText = dlgView.findViewById(R.id.dlg_id);
                                String nickname = editText.getText().toString().trim();
                                if(nickname.length() > 0){
                                    setTitle(nickname + "의 웹뷰");
                                }
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                break;
            case R.id.menu3:
                finish();
                break;
            case R.id.menu4:
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
        }
        return true;
    }
}