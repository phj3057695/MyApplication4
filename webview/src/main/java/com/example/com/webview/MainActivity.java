package com.example.com.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtUrl;
    Button btnGo, btnBack;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUrl=(EditText) findViewById(R.id.edtUrl);
        btnGo=(Button)findViewById(R.id.btnGo);
        btnBack=(Button)findViewById(R.id.btnBack);
        web=(WebView)findViewById(R.id.webView1);
        web.setWebViewClient(new FloraWebViewClient());
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

    }
    public void btn_onClick(View v){
        String temp=edtUrl.getText().toString();
        boolean value = temp.contains("http://");
        switch(v.getId()){
            case R.id.btnGo:
                if(value == false) {
                    edtUrl.setText("http://" + temp);
                    web.loadUrl(edtUrl.getText().toString());
                }
                else
                    web.loadUrl(edtUrl.getText().toString());
                break;
            case R.id.btnBack:
                web.goBack();
                break;
            case R.id.btnforward:
                web.goForward();
                break;
        }
    }
    class FloraWebViewClient extends WebViewClient{
       // String url;
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.getRootView();
            url = view.getUrl();
            edtUrl.setText(url.toString());
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}
