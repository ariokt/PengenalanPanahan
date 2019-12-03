package com.example.ariowaskito.pengenalanpanahan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class listTittle extends Activity {
		int jd;
		String[]arrid;
		String[]arrnama;
		String[]arrdeskripsi;
		String[]arrketerangan;
		int[]arrGbr;


		/** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.listtittle);


//isidata
	   jd=14;
	   arrid=new String[jd];
	   arrnama=new String[jd];
	   arrdeskripsi=new String[jd];
	   arrketerangan=new String[jd];
	   arrGbr=new int[jd];
	    			
	   arrdeskripsi[0]="Terdapat 3 jenis dan setiap jenis berbeda bahan pembuatan";
	   arrid[0]="1";
	   arrnama[0]="Busur";
	   arrketerangan[0]="a.Standard Bow\n" +
			   "Busur jenis ini memiliki unsur kayu dan fiber, serta anak panah yang terbuat dari bahan alumunium. Busur ini merupakan pengembangan busur nasional yang semula busur dan anak panahnya terbuat dari kayu dan diproduksi oleh Indonesia.\n\n" +
			   "b.Recursive Bow\n" +
			   "Busur ini merupakan bukti dari perkembangan IPTEK, Recursive Bow merupakan jenis busur yang paling umum digunakan di olahraga panahan saat ini. Busur ini terbuat dari bahan metal dan pada anak panahnya menggunakan fiber.\n\n" +
			   "c.Compund\n" +
			   "Busur Compound merupakan busur awalnya digunakan untuk berburu. Busur ini memiliki berat sekitar 40lbs hingga 80lbs. Oleh karena itu busur ini cenderung digunakan oleh orang dewasa atau pemanah yang sudah terlatih dalam segi teknik.";
	   arrGbr[0]=R.drawable.no_image;

		arrdeskripsi[1]="Digunakan pada tangan";
		arrid[1]="2";
		arrnama[1]="Finger Tab";
		arrketerangan[1]="Finger Tab atau pelingung jari memiliki fungsi untuk melindungi  ketiga jari penarik, agar pemanah tidak merasakan sakit pada saat jari penarik mengait tali busur (String) dalam kegiatan memanah.";
		arrGbr[1]=R.drawable.fingertab2;

		arrdeskripsi[2]="Atur grip hingga nyaman saat digunakan";
	    arrid[2]="3";
	    arrnama[2]="Grip";
	    arrketerangan[2]="Grip merupakan komponen utama yang terdapat pada busur yang terdapat di busur yang digunakan untuk memegang busur saat melakukan panahan. Tiap individu dapat mengatur gipnya sendiri hingga terasa nyaman saat digunakan, contohnya dengan melilitkan hand grip karet untuk menambah volume ukuran grip atau menempelkan bahan kulit pada grip.";
	    arrGbr[2]=R.drawable.no_image;

	    arrdeskripsi[3]="Pemasangan limb harus sesuai";
	    arrid[3]="4";
	    arrnama[3]="Limb";
	    arrketerangan[3]="Limb atau sayap busur, yaitu bagian busur yang membengkok pada saat dilakukan penarikan dan memberikan tenaga lontar pada anak panah. Seiring perkembangan jaman limb ini dapat dibongkar pasang dan apabila ingin memasangnya lagi harus sesuai dengan semula pada bagian atas disebut Upper limb dan bagian bawah disebut Lower limb. Dan pada ujung limb terdapat String groove yang berfungsi untuk mengkaitkan tali busur.";
	    arrGbr[3]=R.drawable.no_image;

	    arrdeskripsi[4]="Tempat limb dipasang";
	    arrid[4]="5";
	    arrnama[4]="Riser";
	    arrketerangan[4]="Riser/handle merupakan bagian pegangan busur yang berfungsi untuk tempat ditempelnya limb. Bahan yang biasa digunakan dalam kegiatan panahan biasanya terbuat dari alumunium, magnesium, machined alumunium, dan composites. Sejak tahun 1972 untuk pertama kalinya riser diperkenalkan oleh earl hoyt.";
	    arrGbr[4]=R.drawable.no_image;

	    arrdeskripsi[5]="Tempat anak panah dipasang";
	    arrid[5]="6";
	    arrnama[5]="Tali Busur";
	    arrketerangan[5]="Tali busur berfungsi untuk mentransfer energi dari tangan pemanah ke limb atau dari limb ke anak panah. Tali busur terbuat dari material sintetis seperti Kevlar dan tali busur yang dibuat harus memiliki Nock Point untuk meletakkan anak panah. String atau tali busur yang siap digunakan pelu di tuning dahulu yang disebut dengan String Alignment.";
	    arrGbr[5]=R.drawable.talibusur2;

			arrdeskripsi[6]="Tempat anak panah pada busur";
			arrid[6]="7";
			arrnama[6]="Arrow Rest";
			arrketerangan[6]="Arrow Rest merupakan tempat meletakkan anak panah pada busur. Arrow Rest dapat terbuat dari bulu, plastik, dan besi. ";
			arrGbr[6]=R.drawable.bowsight2;

			arrdeskripsi[7]="Melindungi tangan";
			arrid[7]="8";
			arrnama[7]="Arm Guard";
			arrketerangan[7]="Arm Guard atau pelindung lengan berfungsi untuk melindungi tangan pemegang busur agar tidak terluka pada bagian lengan pada saat melakukan kegiatan panahan.\n\n" +
					"Arm Guard yang yang benar memiliki 2 tali pengikat. Arm Guard dengan model 3/4 tali pengikat lebih banyak digunakan oleh pemanah pemula, arm guard 3/4 berbentuk lebih panjang (melindungi dari lengan hingga ke siku).";
			arrGbr[7]=R.drawable.armguard2;

			arrdeskripsi[8]="Merupakan pelindung dada";
			arrid[8]="9";
			arrnama[8]="Chest Guard";
			arrketerangan[8]="Chest Guard merupakan pelindung dada yang digunakan pada dada sebelah kanan untuk pemanah kanan dan kiri untuk pemanah kiri, yang bertujuan untuk melindungi dada saat pelepasan panah sehingga tidak terhambat oleh baju longgar atau jilbab.";
			arrGbr[8]=R.drawable.chestguard2;

			arrdeskripsi[9]="Tempat anak panah diletakkan sebelum dipasang";
			arrid[9]="10";
			arrnama[9]="Quiver";
			arrketerangan[9]="Quiver merupakan kantung anak panah yamg digunakan oleh peserta panahan atau atlet panahan untuk meletakkan anak panah. Pemakaian quiver ini adalah dengan mengikatkannya di pinggang pemanah.";
			arrGbr[9]=R.drawable.quiver2;

			arrdeskripsi[10]="Tempat meletakkan panah saat tidak digunakan";
			arrid[10]="11";
			arrnama[10]="Bow Stand";
			arrketerangan[10]="Bow Stand merupakan salah satu aksesoris panahan yang berfungsi untuk meletakkan panah pada saat tidak digunakan.";
			arrGbr[10]=R.drawable.bowstand2;

			arrdeskripsi[11]="Dapat digunakan untuk mencabut anak panah";
			arrid[11]="12";
			arrnama[11]="Puller";
			arrketerangan[11]="Puller merupakan alat bantu untuk mencabut anak panah. Fungsinya untuk melindungi telepak tangan dari gesekan langsung dengan anak panah.";
			arrGbr[11]=R.drawable.puller2;

			arrdeskripsi[12]="Aksesoris tambahan pada busur";
			arrid[12]="13";
			arrnama[12]="Stabilizer";
			arrketerangan[12]="Stabilizer adalah aksesoris tambahan yang digunakan oleh para pemanah dengan tujuan untuk memberikan kestabilan pada busur, mampu meminimalisir getaran pada saat melepaskan anak panah.";
			arrGbr[12]=R.drawable.no_image;

			arrdeskripsi[13]="Aksesoris tambahan pada busur";
			arrid[13]="13";
			arrnama[13]="Bow Sight";
			arrketerangan[13]="Bow Sight atau Visir berfungsi untuk memudahkan seorang pemanah untuk menentukan posisi bidikan pada target atau sasaran. Pada Bow Sight terdapat ukuran yang dapat disesuaikan pada jarak-jarak penembakan sehingga seorang pemanah tidak membidik berdasarkan per kiraan.";
			arrGbr[13]=R.drawable.bowsight2;


	   ArrayList<ItemDetails> image_details = GetSearchResults();
	        
	   final ListView lv1 = (ListView) findViewById(R.id.listV_main);
	   lv1.setAdapter(new ItemListBaseAdapter(this, image_details));
	        
	   lv1.setOnItemClickListener(new OnItemClickListener() {
	   @Override
	   public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
	        		Object o = lv1.getItemAtPosition(position);
	            	ItemDetails obj_itemDetails = (ItemDetails)o;
	        	  	  	}
	        });
	    }
	    
	    private ArrayList<ItemDetails> GetSearchResults(){
	    	ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();
	    	ItemDetails item_details = null;
	    	for(int j=0;j<jd;j++){
		    	item_details = new ItemDetails();
		    	item_details.setName(arrnama[j]);
		    	item_details.setItemDescription(arrketerangan[j]);
		    	item_details.setGambar(arrGbr[j]);
		    	item_details.setalamat(arrdeskripsi[j]);
		    	results.add(item_details);
	    	}
   	
	    	return results;
	    }
	}



