package com.vk.sly.qr;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

/**
 * Created by Vadim on 30.07.2015.
 */
public class Request  {


    //private static final String _ID = "_id";



    protected String url;
    private String jsonResponse;
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

                jsonResponse = "";

                String id = jsonArray.getString("id");
                String respons = jsonArray.getString("response");  //RESPONSE
                String country = jsonArray.getString("country");
                String region = jsonArray.getString("region");
                String sub_region = jsonArray.getString("sub_region");
                String brand = jsonArray.getString("brand");
                String wine_type = jsonArray.getString("wine_type");
                String scanned_count = jsonArray.getString("scand_count");
                String unique_id = jsonArray.getString("unique_id");
                String link = jsonArray.getString("link");

                jsonResponse += "Id: " + id + "\n\n";
                jsonResponse += "Response: " + response + "\n\n";
                jsonResponse += "Country: " + country + "\n\n";
                jsonResponse += "Brand: " + brand + "\n\n";
                jsonResponse += "Unique id: " + unique_id + "\n\n";

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
