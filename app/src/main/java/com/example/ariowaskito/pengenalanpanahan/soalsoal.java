package com.example.ariowaskito.pengenalanpanahan;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariowaskito.pengenalanpanahan.driver.XMLParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class soalsoal extends Activity {
	RadioButton radA,radB,radC,radD;
	String sNama="",sUsia="-",sJK="-",sCatatan="";
	int ke=0,jumsoal=10,jumBenar=0;
	int jd;
	String[]arr_idsoal;
	String[]arr_pertanyaan;
	String[]arr_jawabA;
	String[]arr_jawabB;
	String[]arr_jawabC;
	String[]arr_jawabD;
	String[]arr_jawabBenar;
	String[]arr_gambar;

	static final String KEY_record = "soal";
	public static final String KEY_pertanyaan = "pertanyaan";
	public static final String KEY_jawabA = "jawabA";
	public static final String KEY_jawabB = "jawabB";
	public static final String KEY_jawabC = "jawabC";	
	public static final String KEY_jawabD = "jawabD";
	public static final String KEY_jawabBenar = "jawabBenar";	
	public static final String KEY_gambar = "gambar";	
	public static final String KEY_idsoal = "idsoal";
	
	ImageView imgGambar;
	TextView txtTanya,txtTanyake;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soalsoal);
        
        Intent i = this.getIntent();
        sNama=i.getStringExtra("nama");
        sUsia=i.getStringExtra("usia");
        sJK=i.getStringExtra("jk");
        
        callMarquee();
        callData();
    	    	
        txtTanya= (TextView) findViewById(R.id.txtTanya);
        txtTanyake= (TextView) findViewById(R.id.txtTanyaKe);
        imgGambar= (ImageView) findViewById(R.id.myGambar);

        
        radA= (RadioButton) findViewById(R.id.radA);
        radA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cekJawaban("A");
				ke=ke+1;
				if(ke>=jumsoal){selesai();}
				else{lihat();}
			}
		});

        radB= (RadioButton) findViewById(R.id.radB);
        radB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cekJawaban("B");
				ke=ke+1;
				if(ke>=jumsoal){selesai();}
				else{lihat();}
			}
		});
        radC= (RadioButton) findViewById(R.id.radC);
        radC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cekJawaban("C");
				ke=ke+1;
				if(ke>=jumsoal){selesai();}
				else{lihat();}
			}
		});
        radD= (RadioButton) findViewById(R.id.radD);
        radD.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cekJawaban("D");
				ke=ke+1;
				if(ke>=jumsoal){selesai();}
				else{lihat();}
			}
		});
        lihat();
    } 
    
void cekJawaban(String pil){
	if(arr_jawabBenar[ke].equals(pil)){
		jumBenar=jumBenar+1;
		sCatatan=sCatatan+"Soal ke-"+(ke+1)+" Benar\n";
		Toast.makeText(getBaseContext()," Pilihan Anda "+pil+" : Benar!", Toast.LENGTH_LONG).show(); 
	}
	else{
		sCatatan=sCatatan+"Soal ke-"+(ke+1)+" Salah\n";
		Toast.makeText(getBaseContext()," Pilihan Anda "+pil+" : Salah!", Toast.LENGTH_LONG).show(); 
	}
}    
//untuk menampilkan soal
void lihat(){   	
    	radA.setChecked(false);
    	radB.setChecked(false);
    	radC.setChecked(false);
    	radD.setChecked(false);
    	int ike=ke;
    	txtTanya.setText((ke+1)+"."+arr_pertanyaan[ike]);
    	radA.setText(arr_jawabA[ike]);
    	radB.setText(arr_jawabB[ike]);
    	radC.setText(arr_jawabC[ike]);
    	radD.setText(arr_jawabD[ike]);
    	txtTanyake.setText("Pertanyaan ke "+(ke+1) +" dari "+jumsoal+" pertanyaan !");
        String uri = null;
        int imageResource = R.drawable.no_image;
        
        uri="drawable/"+arr_gambar[ike];
        Drawable image = null;
        try {
            imageResource=getResources().getIdentifier(uri, null, getPackageName());
            image=getResources().getDrawable(imageResource);
		} catch (NotFoundException e) {

		}
        imgGambar.setImageDrawable(image);
    }
  
    void callMarquee(){
		Calendar cal = Calendar.getInstance();           
		int jam = cal.get(Calendar.HOUR);
		int menit= cal.get(Calendar.MINUTE);
		int detik= cal.get(Calendar.SECOND);

		int tgl= cal.get(Calendar.DATE);
		int bln= cal.get(Calendar.MONTH)+1;
		int thn= cal.get(Calendar.YEAR);

		String stgl=String.valueOf(tgl)+"-"+String.valueOf(bln)+"-"+String.valueOf(thn);
		String sjam=String.valueOf(jam)+":"+String.valueOf(menit)+":"+String.valueOf(detik);
		
		TextView  txtMarquee=(TextView)findViewById(R.id.txtMarquee);
		txtMarquee.setSelected(true);
		String kata="Selamat Datang di Aplikasi Android Pengenalan Olahraga Panahan. Selamat Mengerjakan /"+stgl+"/"+sjam+" #";
		String kalimat=String.format("%1$s",TextUtils.htmlEncode(kata));
		txtMarquee.setText(Html.fromHtml(kalimat+kalimat+kalimat));  
	}

    public void selesai(){
    	new AlertDialog.Builder(this)
		.setTitle("Hasil QUIZ")
		.setMessage("Yth: "+sNama+"\nUsia:"+sUsia+" thn\nSkor anda : "+jumBenar+" Point")
		.setNeutralButton("INFO SKOR", new OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
			finish();
			Intent put= new Intent(getBaseContext(), hasil.class);
			put.putExtra("nama", sNama);
			put.putExtra("usia", sUsia);
			put.putExtra("jk", sJK);
			put.putExtra("nilai", String.valueOf(jumBenar));
			put.putExtra("catatan", sCatatan);			
		startActivity(put);
			}})
		.show();
    }
    public void keluar(){
    	new AlertDialog.Builder(this)
		.setTitle("Menutup Aplikasi")
		.setMessage("Terimakasih. Anda Telah Menggunakan Aplikasi Ini")
		.setNeutralButton("Tutup", new OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
			finish();
			}})
		.show();
    }
    public void keluarYN(){
    	AlertDialog.Builder ad=new AlertDialog.Builder(soalsoal.this);
            	ad.setTitle("Konfirmasi");
            	ad.setMessage("Apakah benar ingin keluar?");
            	
            	ad.setPositiveButton("OK",new OnClickListener(){
       			@Override
    			public void onClick(DialogInterface dialog, int which) {
    					keluar();
    				}});
            	
            	ad.setNegativeButton("No",new OnClickListener(){
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
    void callData(){
    	ArrayList<HashMap<String, String>> recordsList = new ArrayList<HashMap<String, String>>();
		XMLParser parser = new XMLParser();
		String xml=null;

		
InputStream in_s=null;
try {
Resources res = getResources();
      in_s = res.openRawResource(R.raw.xml_soal); 
      byte[] b = new byte[in_s.available()];
      in_s.read(b);
      xml=new String(b);
      } 
catch (Exception e) {xml=null;}
	

		
		Document doc = parser.getDomElement(xml);
		NodeList nl = doc.getElementsByTagName(KEY_record);
		jd=nl.getLength();
		arr_idsoal=new String[jd];
		arr_pertanyaan=new String[jd];
		arr_jawabA=new String[jd];
		arr_jawabB=new String[jd];
		arr_jawabC=new String[jd];
		arr_jawabD=new String[jd];
		arr_jawabBenar=new String[jd];
		arr_gambar=new String[jd];
		
		for (int j = 0; j < jd; j++) {
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(j);
			String l_idsoal=parser.getValue(e, KEY_idsoal);if(l_idsoal.length()<1){l_idsoal="-";}arr_idsoal[j]=l_idsoal;
			String l_pertanyaan=parser.getValue(e, KEY_pertanyaan);if(l_pertanyaan.length()<1){l_pertanyaan="-";}arr_pertanyaan[j]=l_pertanyaan;
			String l_jawabA=parser.getValue(e, KEY_jawabA);if(l_jawabA.length()<1){l_jawabA="-";}arr_jawabA[j]=l_jawabA;
			String l_jawabB=parser.getValue(e, KEY_jawabB);if(l_jawabB.length()<1){l_jawabB="-";}arr_jawabB[j]=l_jawabB;
			String l_jawabC=parser.getValue(e, KEY_jawabC);if(l_jawabC.length()<1){l_jawabC="-";}arr_jawabC[j]=l_jawabC;
			String l_jawabD=parser.getValue(e, KEY_jawabD);if(l_jawabD.length()<1){l_jawabD="-";}arr_jawabD[j]=l_jawabD;
			String l_jawabBenar=parser.getValue(e, KEY_jawabBenar);if(l_jawabBenar.length()<1){l_jawabBenar="-";}arr_jawabBenar[j]=l_jawabBenar;
			String l_gambar=parser.getValue(e, KEY_gambar);if(l_gambar.length()<1){l_gambar="-";}arr_gambar[j]=l_gambar;
					
			map.put(KEY_idsoal, l_idsoal);
			map.put(KEY_pertanyaan, l_pertanyaan);
			map.put(KEY_jawabA, l_jawabA);
			map.put(KEY_jawabB, l_jawabB);
			map.put(KEY_jawabC, l_jawabC);
			map.put(KEY_jawabD, l_jawabD);
			map.put(KEY_jawabBenar, l_jawabBenar);
			map.put(KEY_gambar, l_gambar);
			recordsList.add(map);
		}		
    }
}
