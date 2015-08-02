package com.vk.sly.qr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);


        TextView tv11 = (TextView)findViewById(R.id.tv11);
        String lol11 = getIntent().getStringExtra("_id");
        tv11.setText(lol11);

        TextView tv22 = (TextView)findViewById(R.id.tv22);
        String lol22 = getIntent().getStringExtra("title");
        tv22.setText(lol22);

        TextView tv33 = (TextView)findViewById(R.id.tv33);
        String lol33 = getIntent().getStringExtra("country");
        tv33.setText(lol33);

        TextView tv44 = (TextView)findViewById(R.id.tv44);
        String lol44 = getIntent().getStringExtra("region");
        tv44.setText(lol44);

        TextView tv55 = (TextView)findViewById(R.id.tv55);
        String lol55 = getIntent().getStringExtra("brand");
        tv55.setText(lol55);

        TextView tv66 = (TextView)findViewById(R.id.tv66);
        String item_code = getIntent().getStringExtra("item_code");
        tv66.setText(item_code);

        TextView tv77 = (TextView)findViewById(R.id.tv77);
        String scanned_count = getIntent().getStringExtra("scanned_count");
        tv77.setText(scanned_count);

        TextView tv88 = (TextView)findViewById(R.id.tv88);
        String unique_id = getIntent().getStringExtra("unique_id");
        tv88.setText(unique_id);

        TextView tv99 = (TextView)findViewById(R.id.tv99);
        String counter = getIntent().getStringExtra("counter");
        tv99.setText(counter);

        TextView tv1010 = (TextView)findViewById(R.id.tv1010);
        String status = getIntent().getStringExtra("status");
        tv1010.setText(status);

       // TextView tv1111 = (TextView)findViewById(R.id.tv1111);
        //String link = getIntent().getStringExtra("link");
        //tv1111.setText(link);

        Button btn_back = (Button)findViewById(R.id.btn_back);





   //     TextView error = (TextView)findViewById(R.id.error);
     //   String er = getIntent().getStringExtra("error");
       // error.setText(er);

        //intent.putExtra("item_code", item_code);

//        TextView tv1 = (TextView)findViewById(R.id.textView);
 //       String lol1 = getIntent().getStringExtra("jsonResponse");
  ///      tv1.setText(lol1);






//        TextView tv2 = (TextView)findViewById(R.id.textView6);
//        String lol2 = getIntent().getStringExtra("jsonResponse2");
//        tv2.setText(lol2);

//
//        TextView tv5 = (TextView)findViewById(R.id.textView5);
 //       String lol3 = getIntent().getStringExtra("jsonResponse3");
   //     tv5.setText(lol3);
//
     //   TextView tv6 = (TextView)findViewById(R.id.textView7);
       // String lol4 = getIntent().getStringExtra("jsonResponse4");
        //tv6.setText(lol4);
//
//        TextView tv7 = (TextView)findViewById(R.id.textView7);
//        String lol5 = getIntent().getStringExtra("lol5");
//        tv7.setText(lol5);
//
 //       TextView tv8 = (TextView)findViewById(R.id.textView8);
   //    String lol6 = getIntent().getStringExtra("jsonResponse5");
     //   tv8.setText(lol6);
//
//


    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_back:
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
                finish();


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
