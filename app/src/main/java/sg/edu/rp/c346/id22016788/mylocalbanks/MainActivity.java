package sg.edu.rp.c346.id22016788.mylocalbanks;

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

    Button Bank1Name, Bank2Name, Bank3Name;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bank1Name = findViewById(R.id.Bank1);
        Bank2Name = findViewById(R.id.Bank2);
        Bank3Name = findViewById(R.id.Bank3);

        registerForContextMenu(Bank1Name);
        registerForContextMenu(Bank2Name);
        registerForContextMenu(Bank3Name);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == Bank1Name) {
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact the Bank");
        }
        else if (v == Bank2Name) {
            menu.add(1, 0, 0, "Website");
            menu.add(1, 1, 1, "Contact the Bank");
        }
        else if (v == Bank3Name) {
            menu.add(2, 0, 0, "Website");
            menu.add(2, 1, 1, "Contact the Bank");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            Bank1Name.setText("DBS");
            Bank2Name.setText("OCBC");
            Bank3Name.setText("UOB");
            return true;
        } else if (id == R.id.mandarinSelection) {
            Bank1Name.setText("星展銀行");
            Bank2Name.setText("華僑銀行");
            Bank3Name.setText("大華銀行");
            return true;
        } else {
            Bank1Name.setText("Error translation");
            Bank2Name.setText("Error translation");
            Bank3Name.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int groupID = item.getGroupId();
        if (groupID == 0) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+63330033));
                startActivity(intentCall);
                return true;
            }
        }
        else if (groupID == 1) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/personal-banking/"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+63633888));
                startActivity(intentCall);
                return true;
            }
        }
        else if (groupID == 2) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/index.page"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+66682087));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}