package com.example.ariowaskito.pengenalanpanahan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class inputnama extends Activity {
	EditText txtnama,txtusia;
	RadioButton radPa,radPi;
	String jk="Laki-laki";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputnama);
        callMarquee();
        
        txtnama= (EditText) findViewById(R.id.inama);
        txtusia= (EditText) findViewById(R.id.iusia);
        
        radPa= (RadioButton) findViewById(R.id.radPa);
        radPa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			jk="Laki-laki";
			}
		});

        radPi= (RadioButton) findViewById(R.id.radPi);
        radPi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				jk="Perempuan";
			}
		});
        
        Button btnOk= (Button) findViewById(R.id.iOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			String nama=txtnama.getText().toString();
			String usia=txtusia.getText().toString();
			if(nama.length()<1){lengkapi("Nama");}
			else if(usia.length()<1){lengkapi("Usia");}
			else{
				Intent put= new Intent(getBaseContext(), soalsoal.class);
					put.putExtra("nama", nama);
					put.putExtra("usia", usia);
					put.putExtra("jk", jk);
				startActivity(put);
			}
			}
		});
        
        Button btnBatal= (Button) findViewById(R.id.iBatal);
        btnBatal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				keluar();
			}
		});
		Button btnLihat= (Button) findViewById(R.id.ilihat);
		btnLihat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent j = new Intent(inputnama.this, listdataDB.class);
				startActivity(j);
			}
		});
    }
    
    public void lengkapi(String item){
    	new AlertDialog.Builder(this)
		.setTitle("Lengkapi Data")
		.setMessage("Silakan lengkapi data "+item)
		.setNeutralButton("OK", new OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
			}})
		.show();
    }
    
    public void keluar(){
    	new AlertDialog.Builder(this)
		.setTitle("Quis")
		.setMessage("Semoga quis ini bermanfaat")
		.setNeutralButton("Tutup", new OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
			finish();
			}})
		.show();
    }
    public void keluarYN(){
    	AlertDialog.Builder ad=new AlertDialog.Builder(inputnama.this);
            	ad.setTitle("Konfirmasi");
            	ad.setMessage("Apakah ingin keluar dari menu quis?");
            	
            	ad.setPositiveButton("YA",new OnClickListener(){
       			@Override
    			public void onClick(DialogInterface dialog, int which) {
    					keluar();
    				}});
            	
            	ad.setNegativeButton("TIDAK",new OnClickListener(){
        			public void onClick(DialogInterface arg0, int arg1) {
        			}});
            	
            	ad.show();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	keluarYN();
                return true;
        }
    return super.onKeyDown(keyCode, event);
}    
    void callMarquee(){
  		Calendar cal = Calendar.getInstance();           
  		int jam = cal.get(Calendar.HOUR);
  		int menit= cal.get(Calendar.MINUTE);
  		int detik= cal.get(Calendar.SECOND);

  		int tgl= cal.get(Calendar.DATE);
  		int bln= cal.get(Calendar.MONTH);
  		int thn= cal.get(Calendar.YEAR);

  		String stgl=String.valueOf(tgl)+"-"+String.valueOf(bln)+"-"+String.valueOf(thn);
  		String sjam=String.valueOf(jam)+":"+String.valueOf(menit)+":"+String.valueOf(detik);
  		
  		TextView  txtMarquee=(TextView)findViewById(R.id.txtMarquee);
  		txtMarquee.setSelected(true);
  		String kata="Selamat Datang di Aplikasi Android Pengenalan Panahan. Selamat Mengerjakan /"+stgl+"/"+sjam+" #";
  		String kalimat=String.format("%1$s",TextUtils.htmlEncode(kata));
  		txtMarquee.setText(Html.fromHtml(kalimat+kalimat+kalimat));  
  	}
    
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Arsip").setIcon(R.drawable.keluar);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case 1:	
        	Intent put= new Intent(getBaseContext(), listdataDB.class);		
        	startActivity(put);
        	return true;
        }
        return false;
    }
    String getTime(){
	Calendar cal = Calendar.getInstance();           
		int jam = cal.get(Calendar.HOUR);
		int menit= cal.get(Calendar.MINUTE);
		int detik= cal.get(Calendar.SECOND);

		int tgl= cal.get(Calendar.DATE);
		int bln= cal.get(Calendar.MONTH);
		int thn= cal.get(Calendar.YEAR);

		String stgl=String.valueOf(tgl)+"-"+String.valueOf(bln)+"-"+String.valueOf(thn);
		String sjam=String.valueOf(jam)+":"+String.valueOf(menit)+":"+String.valueOf(detik);
		String gb=stgl+", "+sjam +" WIB";
return gb;	
}
}
