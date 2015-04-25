package bob.sun.mpod;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import bob.sun.mpod.fragments.MainMenu;
import bob.sun.mpod.view.WheelView;


public class MainActivity extends ActionBarActivity {
    private FragmentManager fragmentManager;
    private MainMenu mainMenu;
    private WheelView wheelView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        mainMenu = (MainMenu) fragmentManager.findFragmentById(R.id.id_screen_fragment_container);
        if(mainMenu == null){
            mainMenu = new MainMenu();
            fragmentManager.beginTransaction()
                    .add(R.id.id_screen_fragment_container,mainMenu,"mainMenu").commit();
        }
        wheelView = (WheelView) findViewById(R.id.id_wheel_view);
        wheelView.setOnTickListener(mainMenu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
