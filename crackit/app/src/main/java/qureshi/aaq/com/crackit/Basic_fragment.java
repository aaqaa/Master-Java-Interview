package qureshi.aaq.com.crackit;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by asheer.qureshi on 2/17/2018.
 */

@SuppressLint("ValidFragment")
public class Basic_fragment extends Fragment {
    View view;
    int id;
    WebView webView;
    ProgressBar progressBar;
    public Basic_fragment(int id) {
        this.id = id;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.basic_fragment, container, false);
        webView = view.findViewById(R.id.webview);
        progressBar = view.findViewById(R.id.progressBar1);
        webView.setWebViewClient(new myWebClient());
        webView.getSettings().setJavaScriptEnabled(true);
        initializeWebView();
        return view;
    }

    void initializeWebView() {

        if (!DetectConnection.checkInternetConnection(getActivity())) {
            Toast.makeText(getActivity(), "No Internet!", Toast.LENGTH_SHORT).show();
        }
        else{
        switch (id) {

            case 0:
                webView.loadUrl("file:///android_asset/1.htm");
                break;

            case 1:
                webView.loadUrl("file:///android_asset/2.htm");
                break;
            case 2:
                webView.loadUrl("file:///android_asset/3.htm");
                break;
            case 3:
                webView.loadUrl("file:///android_asset/4.htm");
                break;
            case 4:
                webView.loadUrl("file:///android_asset/5.htm");
                break;
            case 5:
                webView.loadUrl("file:///android_asset/6.htm");
                break;
            case 6:
                webView.loadUrl("file:///android_asset/7.htm");
                break;
            case 7:
                webView.loadUrl("file:///android_asset/8.htm");
                break;
            case 8:
                webView.loadUrl("file:///android_asset/9.htm");
                break;
            case 9:
                webView.loadUrl("file:///android_asset/10.htm");
                break;
            case 10:
                webView.loadUrl("file:///android_asset/11.htm");
                break;
            case 11:
                webView.loadUrl("file:///android_asset/12.htm");
                break;
            case 12:
                webView.loadUrl("file:///android_asset/13.htm");
                break;
            case 13:
                webView.loadUrl("file:///android_asset/14.htm");
                break;
            case 14:
                webView.loadUrl("file:///android_asset/15.htm");
                break;

            default:
                break;
        }}


    }

    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);
        }
    }



}
