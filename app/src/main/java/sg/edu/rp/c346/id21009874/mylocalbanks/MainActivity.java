package sg.edu.rp.c346.id21009874.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDbs;
    Button btnOcbc;
    Button btnUob;
    String wordClicked ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbs = findViewById(R.id.buttonDBS);
        btnOcbc = findViewById(R.id.buttonOCBC);
        btnUob = findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDbs);
        registerForContextMenu(btnOcbc);
        registerForContextMenu(btnUob);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            btnDbs.setText("DBS");
            btnOcbc.setText("OCBC");
            btnUob.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            btnDbs.setText("星展银行");
            btnOcbc.setText("华侨银行");
            btnUob.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        if (v == btnDbs){
            wordClicked = "DBS";
        }else if (v == btnOcbc){
            wordClicked = "OCBC";
        }else if (v == btnUob){
            wordClicked = "UOB";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id =item.getItemId();

        if (wordClicked == "DBS"){
            if (id == R.id.websiteSelection){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com"));
                startActivity(intent);

                return true;

            } else if (id == R.id.contactSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);
                return true;
            }
        }
        else if (wordClicked == "OCBC"){
            if (id == R.id.websiteSelection){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intent);

                return true;

            } else if (id == R.id.contactSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);
                return true;
            }
        }
        else if (wordClicked == "UOB"){
            if (id == R.id.websiteSelection){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uob.com"));
                startActivity(intent);

                return true;

            } else if (id == R.id.contactSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }


}


