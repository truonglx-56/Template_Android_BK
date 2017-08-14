package template.truonglx.com.templateandroid;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import template.truonglx.com.templateandroid.fragment.FragmentMe;
import template.truonglx.com.templateandroid.fragment.FragmentTool;
import template.truonglx.com.templateandroid.fragment.FragmentTranfers;
import template.truonglx.com.templateandroid.navigationbar.BottomNavigation;
import template.truonglx.com.templateandroid.navigationbar.events.OnSelectedItemChangeListener;

public class MainActivity extends AppCompatActivity {

    private BottomNavigation mBottomNavigation;
    private FragmentTransaction transaction;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        mBottomNavigation = (BottomNavigation) findViewById(R.id.bottom_navigation);
        mBottomNavigation.setDefaultItem(0);
        mBottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId) {
                    case R.id.tab_tranfers:
                        transaction = getSupportFragmentManager().beginTransaction();
                        toolbar.setTitle(R.string.app_name);
                        FragmentTranfers fragmentTranfers = new FragmentTranfers();

                        transaction.setCustomAnimations(R.anim.fragment_slide_left_enter,
                                R.anim.fragment_slide_left_exit,
                                R.anim.fragment_slide_right_enter,
                                R.anim.fragment_slide_right_exit);
                        transaction.replace(R.id.frame_fragment_containers, fragmentTranfers);
                        break;

                    case R.id.tab_tools:
                        transaction = getSupportFragmentManager().beginTransaction();
                        toolbar.setTitle(R.string.bottom_tools);
                        FragmentTool fragmentTool = new FragmentTool();

                        transaction.setCustomAnimations(R.anim.fragment_slide_left_enter,
                                R.anim.fragment_slide_left_exit,
                                R.anim.fragment_slide_right_enter,
                                R.anim.fragment_slide_right_exit);
                        transaction.replace(R.id.frame_fragment_containers, fragmentTool);
                        break;
                    case R.id.tab_me:
                        transaction = getSupportFragmentManager().beginTransaction();
                        toolbar.setTitle(R.string.bottom_me);

                        FragmentMe fragmentMe = new FragmentMe();


                        transaction.setCustomAnimations(R.anim.fragment_slide_left_enter,
                                R.anim.fragment_slide_left_exit,
                                R.anim.fragment_slide_right_enter,
                                R.anim.fragment_slide_right_exit);
                        transaction.replace(R.id.frame_fragment_containers, fragmentMe);
                        break;
                }
                transaction.commit();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_1:
                Toast.makeText(this, "action 1 selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.action_2:
                Toast.makeText(this, "action 2 selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu   , menu);
        return true;
    }

}
