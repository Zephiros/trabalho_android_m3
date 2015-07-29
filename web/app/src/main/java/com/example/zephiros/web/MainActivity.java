package com.example.zephiros.web;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        btn = (Button) findViewById(R.id.button);
//        btn.setClickable(False);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v) {
        Button btn = (Button) findViewById(R.id.button);
        btn.setEnabled(false);

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setEnabled(false);

        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText("YOU LOST THE GAME!!!");
    }

    public void alive(View v){
        blah();
    }

    public void blah() {
        new AsyncTask<Void, Void, Void>() {

            String password = "";
            String url = "http://172.20.10.3/unlock/";
            Boolean unlock = false;

            @Override
            protected void onPreExecute()
            {
                EditText edit = (EditText) findViewById(R.id.editText);
                password = edit.getText().toString();
                // here is for code you do before the network call. you
                // leave it empty
            }

            @Override
            protected Void doInBackground(Void... params)
            {
                HttpResponse response;
                HttpClient httpClient = new DefaultHttpClient();
                HttpContext localContext = new BasicHttpContext();
                //HttpGet httpGet = new HttpGet("http://172.20.10.3/unlock/" + password);
                url = url + password;
                HttpGet httpGet = new HttpGet(url);
                try {
                    response = httpClient.execute(httpGet, localContext);
                    StatusLine statusLine = response.getStatusLine();
                    if(statusLine.getStatusCode() == HttpStatus.SC_OK)
                    {
                        unlock = true;
                    }
                } catch (Exception e) {
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void res)
            {
                Button btn = (Button) findViewById(R.id.button);
                btn.setEnabled(unlock);

                if(unlock) {
                    TextView text = (TextView) findViewById(R.id.textView2);
                    text.setText("YES!!!");
                }
            }
        }.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
