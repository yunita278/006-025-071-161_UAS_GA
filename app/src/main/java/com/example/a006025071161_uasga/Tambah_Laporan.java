package com.example.a006025071161_uasga;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Tambah_Laporan extends AppCompatActivity {

    private EditText txtidlaporan;
    private EditText txtnamalaporan;
    private EditText txtlatitude;
    private EditText txtlongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_laporan);

        txtidlaporan = (EditText) findViewById(R.id.txtidlaporan);
        txtnamalaporan = (EditText) findViewById(R.id.txtnamalaporan);
        txtlatitude = (EditText) findViewById(R.id.txtlatitude);
        txtlongitude = (EditText) findViewById(R.id.txtlongitude);
    }

    public void tambahlapor(View view) {
        final String id             = txtidlaporan.getText().toString().trim();
        final String nama           = txtnamalaporan.getText().toString().trim();
        final String latitude       = txtlatitude.getText().toString().trim();
        final String longitude      = txtlongitude.getText().toString().trim();

        class tambahlapor2 extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Tambah_Laporan.this,
                        "Add", "wait", false, false);
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("nama", nama);
                params.put("latitude", latitude);
                params.put("longitude", longitude);
                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://192.168.254.154/uasGis/tambah_laporan.php", params);
                return res;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                //pindah ke menu utama
                if (s.equals("berhasil")) {
                    Intent i = new Intent(Tambah_Laporan.this, MapsActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(Tambah_Laporan.this,
                            "Data harus lengkap", Toast.LENGTH_SHORT).show();
                }
            }
        }
        tambahlapor2 ae = new tambahlapor2();
        ae.execute();
    }
}