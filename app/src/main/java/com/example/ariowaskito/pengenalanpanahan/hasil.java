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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class hasil extends Activity {
	TextView txtnama,txtusia,txtnilai;
	EditText txtPilih;
	String stgl,sjam;
	myDbHelper helper=null;
	ImageView myGambar;
	String nama,usia,jk,nilai,catatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);
        helper=new myDbHelper(this);

		Intent i = this.getIntent();
         nama=i.getStringExtra("nama");
         usia=i.getStringExtra("usia");
         jk=i.getStringExtra("jk");
         nilai=i.getStringExtra("nilai");
         catatan=i.getStringExtra("catatan");

		TextView txtnama= (TextView) findViewById(R.id.hnama);
		TextView txtusia= (TextView) findViewById(R.id.husia);
		TextView txtnilai= (TextView) findViewById(R.id.hNilai);
		TextView txtcat= (TextView) findViewById(R.id.hPilih);

		myGambar= (ImageView) findViewById(R.id.myGambar);
int gb=R.drawable.perempuan;
if(jk.equalsIgnoreCase("Laki-laki")){gb=R.drawable.pria;}
		myGambar.setImageResource(gb);


		txtnama.setText(nama);
		txtusia.setText(usia+" thn");
		txtnilai.setText(nilai);
		txtcat.setText(catatan);

		callMarquee();

        Button btnSimpan= (Button) findViewById(R.id.hSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				helper.insertDb(nama, usia,jk,nilai,stgl,catatan);
				sukses();
			}
		});
        
        Button btnBatal= (Button) findViewById(R.id.hKembali);
        btnBatal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				keluar();
			}
		});
        
    }
    
    public void sukses(){
    	new AlertDialog.Builder(this)
		.setTitle("Simpan OK")
		.setMessage(" Simpan data berhasil....")
		.setNeutralButton("OK", new OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
			finish();
			Intent put= new Intent(getBaseContext(), listdataDB.class);		
        	startActivity(put);
			}})
		.show();
    }
    
    public void keluar(){
    	new AlertDialog.Builder(this)
		.setTitle("Quis")
		.setMessage("Hasil quis tidak disimpan.")
		.setNeutralButton("Tutup", new OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
			finish();
			}})
		.show();
    }
    public void keluarYN(){
    	AlertDialog.Builder ad=new AlertDialog.Builder(hasil.this);
            	ad.setTitle("Konfirmasi");
            	ad.setMessage("Anda tidak ingin menyimpan data hasil quis?");
            	
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
  		int bln= cal.get(Calendar.MONTH)+1;
  		int thn= cal.get(Calendar.YEAR);

  		stgl=String.valueOf(tgl)+"-"+String.valueOf(bln)+"-"+String.valueOf(thn);
  		sjam=String.valueOf(jam)+":"+String.valueOf(menit)+":"+String.valueOf(detik);
  		
  		TextView  txtMarquee=(TextView)findViewById(R.id.txtMarquee);
  		txtMarquee.setSelected(true);
  		String kata="Selamat Datang di Aplikasi Android  Panahan /"+stgl+"/"+sjam+" #";
  		String kalimat=String.format("%1$s",TextUtils.htmlEncode(kata));
  		txtMarquee.setText(Html.fromHtml(kalimat+kalimat+kalimat));  
  	}
}
