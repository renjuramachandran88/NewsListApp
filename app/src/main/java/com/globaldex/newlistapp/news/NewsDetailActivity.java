package com.globaldex.newlistapp.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.globaldex.newlistapp.R;
import com.globaldex.newlistapp.databinding.ActivityNewsDetailBinding;

public class NewsDetailActivity extends AppCompatActivity {
    private ActivityNewsDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(NewsDetailActivity.this, R.layout.activity_news_detail);
        binding.webview.getSettings().setJavaScriptEnabled(true);
        String html = getIntent().getExtras().getString("html");
        binding.webview.loadUrl(html);
    }

}
