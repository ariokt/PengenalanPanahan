package com.example.ariowaskito.pengenalanpanahan;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listdataDB extends ListActivity {
	public final static String ID_EXTRA="OK";
	Cursor model=null;
	drvAdapter adapter=null;
	myDbHelper helper=null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdb);
        helper=new myDbHelper(this);
        //cekDatabase();
        
        model=helper.getAll();        
        startManagingCursor(model);
        adapter=new drvAdapter(model);
        setListAdapter(adapter);
    }
	@Override
	public void onDestroy(){
		super.onDestroy();
		helper.close();
	}
	@Override
	public void onListItemClick(ListView list, View view, int position, long id){
		Intent i=new Intent(listdataDB.this, detailDB.class);
		i.putExtra(ID_EXTRA, String.valueOf(id));
		startActivity(i);
	}

	class drvAdapter extends CursorAdapter{
		drvAdapter (Cursor c){super(listdataDB.this, c);}
		@Override
		public void bindView(View row, Context ctxt, Cursor c){
			drvHolder holder=(drvHolder)row.getTag();
			holder.populateFrom(c, helper);
		}
		@Override
		public View newView(Context ctxt, Cursor c, ViewGroup parent){
			LayoutInflater inflater=getLayoutInflater();
			View row=inflater.inflate(R.layout.rowdb, parent, false);
			drvHolder holder=new drvHolder(row);
			row.setTag(holder);
			return(row);
		}
	}
	static class drvHolder{
		private TextView txt_nama=null;
		private TextView txt_usia=null;
		private TextView txt_hasil=null;
		private TextView txt_keterangan=null;
		private ImageView icon=null;
		private View row=null;
		
		drvHolder(View row){
			this.row=row;
			txt_nama=(TextView)row.findViewById(R.id.lnama);
			txt_usia=(TextView)row.findViewById(R.id.lusia);
			txt_hasil=(TextView)row.findViewById(R.id.lhasil);
			txt_keterangan=(TextView)row.findViewById(R.id.lketerangan);
			icon=(ImageView)row.findViewById(R.id.icon);
		}
		void populateFrom(Cursor c, myDbHelper helper){
			txt_nama.setText(helper.getnama(c));
			txt_usia.setText("Usia "+helper.getusia(c)+" Thn");
			txt_hasil.setText("Skor "+helper.gethasil(c)+" Point");
			txt_keterangan.setText("Tgl: "+helper.getwaktu(c));
			if(helper.getjk(c).equals("Laki-laki")){
				icon.setImageResource(R.drawable.pria);
			}
			else{
				icon.setImageResource(R.drawable.perempuan);
				}
			}
	}	
	
	
	public void cekDatabase(){
		helper=new myDbHelper(this);        
		Cursor c=helper.getAll();
		c.moveToFirst();
		int row = c.getCount();
		if (row==0){
			}
		}
}


