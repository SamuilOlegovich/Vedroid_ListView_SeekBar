package com.samuilolegovich.vedroid_listview_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]{"Jon", "Bob", "George", "Alex"};
    private ListView listView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list();
    }

    // отслеживаем любые нажатия
    public void list() {
        listView = (ListView) findViewById(R.id.listView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        // адаптирует наш масив
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.names, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // получаем позицию из списка которую выблали
                        String val = (String) listView.getItemAtPosition(position);
                        Toast.makeText(
                                MainActivity.this,
                                "Позици: " + position + ", значение: " + val + ", прогресс - "
                                        + seekBar.getProgress(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }
}