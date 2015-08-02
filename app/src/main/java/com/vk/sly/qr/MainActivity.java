package com.vk.sly.qr;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////location
       // ImageView img_v = (ImageView)findViewById(R.id.marker);

       //TextView textView2 = (TextView)findViewById(R.id.textView2);
       // TextView tv3 = (TextView)findViewById(R.id.textView3);
///         location надо
       // TextView tv14 = (TextView)findViewById(R.id.textView4);



       // tv14.setText();
    }




    public void img_click (View v) {

        switch(v.getId()){



            case R.id.result:


                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);


                    intent.putExtra("_id", _id);
                    intent.putExtra("title", title);
                    intent.putExtra("country", country);
                    intent.putExtra("region", region);
                    intent.putExtra("brand", brand);
                    intent.putExtra("item_code", item_code);
                    intent.putExtra("scanned_count", scanned_count);
                    intent.putExtra("unique_id", unique_id);

                    intent.putExtra("counter", counter);
                    intent.putExtra("status", status);
                    intent.putExtra("link", link);
            //    intent.putExtra("error", error);

                    //intent.putExtra("error", );
                    startActivity(intent);

        }
    }

    public void scanBar(View v) {

        try{

            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE" );
            startActivityForResult(intent,0);

        }catch(ActivityNotFoundException anfe) {

            showDialog(MainActivity.this, "Сканнер не найден", "Установить сканер с Play Market?", "Да", "Нет").show();
        }
    }

    public void scanQR(View v) {

        try{
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "QR_SCAN_MODE");
            startActivityForResult(intent, 0);
        } catch(ActivityNotFoundException anfe) {

            showDialog(MainActivity.this, "Сканер не найден", "Установить сканер с Google Play", "Да", "Нет").show();
        }
//        Button result = (Button)findViewById(R.id.result);
  //      result.setVisibility(View.VISIBLE);

    }

    private static AlertDialog showDialog(final Activity act, CharSequence title,
                                          CharSequence message,
                                          CharSequence buttonYes, CharSequence buttonNo) {

        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Uri uri = Uri.parse("https://play.google.com/store/search?q=pname" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {

                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if(requestCode == 0) {




            if(resultCode == RESULT_OK) {
                    Button result = (Button)findViewById(R.id.result);
                    result.setVisibility(View.VISIBLE);

               // TextView tv4 = (TextView)findViewById(R.id.textView4);
                //String qqq = getIntent().getStringExtra("_id");
                //tv4.setText(qqq);



                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
               // TextView tv2 = (TextView)findViewById(R.id.textView2);
               // TextView tv3 = (TextView)findViewById(R.id.textView3);




                new Request(contents);
               // tv2.setText(tv2.getText().toString() + " " + contents);
               // tv3.setText(tv3.getText().toString()+ " " + format);

                ImageView stat = (ImageView)findViewById(R.id.stat);
                //stat.getDrawable(R.drawable.yes);
                //stat.setImageBitmap(R.drawable.yes);
                stat.setImageResource(R.drawable.yes);
                stat.setVisibility(View.VISIBLE);

               // Toast.makeText(this, "Yes!" , Toast.LENGTH_SHORT).show();
                //Toast toast = Toast.makeText(this, "Содержание: " + contents + " Формат: " + format, Toast.LENGTH_LONG);
                //toast.show();
                //Button result = (Button)findViewById(R.id.result);
                //result.setVisibility(View.VISIBLE);



            }else {
                //Toast.makeText(this, "No!", Toast.LENGTH_SHORT).show();

            ImageView stat2 = (ImageView)findViewById(R.id.stat);
            stat2.setImageResource(R.drawable.no);
            stat2.setVisibility(View.VISIBLE);}
        }
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

   // private String jsonResponse="";
    //private String jsonResponse2="";
 //   private String jsonResponse3="";
   // private String jsonResponse4="";
   // private String jsonResponse5="";


   // private boolean error=false;
    private String _id ="";
    private String title="";
    private String country="";
    private String region = "";
    private String brand="";
    private String item_code="";
    private String scanned_count="";
    private String unique_id="";
    private String counter="";
    private String status="";
    private String link="";


    public class Request  {

        //private static final String _ID = "_id";

        protected String url;
        public Request(String url) {

            this.url = url;
            new qwe().execute();
        }

        class qwe extends AsyncTask<Void, String, String> {



            @Override
            protected String doInBackground(Void... params) {
                String result = "";

                HttpGet
                        request = new HttpGet("http://148.251.92.60:3333/api/v1/verification/check?url="+url);

                try {
                    HttpParams params_con = new BasicHttpParams();
                    params_con.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

                    HttpClient httpClient = new DefaultHttpClient(params_con);
                    HttpResponse response = httpClient.execute(request);

                    result = "" + response.getStatusLine().getStatusCode();
                    JSONObject jsonArray = new JSONObject(EntityUtils.toString(response.getEntity()));

                    //jsonResponse = "";



                  //  error = jsonArray.getBoolean("error");




                    _id= jsonArray.getString("_id");
                    title= jsonArray.getJSONObject("response").getString("title");
                    country= jsonArray.getJSONObject("response").getString("Country");
                    region= jsonArray.getJSONObject("response").getString("Region");
                    brand= jsonArray.getJSONObject("response").getString("Brand");
                    item_code = jsonArray.getJSONObject("response").getString("Item Code");
                    scanned_count = jsonArray.getJSONObject("response").getString("Scanned Count");
                    unique_id = jsonArray.getJSONObject("response").getString("Unique ID");

                    counter = jsonArray.getString("counter");
                    status = jsonArray.getString("status");
                    link = jsonArray.getString("link");


                    Log.i("RESULT", jsonArray.toString());

                } catch (Exception e) {

                    Log.i("exception:", e.toString());
                }

                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if (result!=null) {
                    ///  registrationComplete.onRegistrationComplete(new User());
                }
            }


        }
    }
}
