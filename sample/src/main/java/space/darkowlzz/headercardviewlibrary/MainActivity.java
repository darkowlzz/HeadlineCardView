package space.darkowlzz.headercardviewlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import space.darkowlzz.headlinecardview.HeadlineCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeadlineCardView headlineCardView = (HeadlineCardView) findViewById(R.id.headlineCard);
        headlineCardView.setMenuOptionsHandler(new HeadlineCardView.MenuClickHandler() {
            @Override
            public void onMenuOptionClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add:
                        Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.del:
                        Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.undo:
                        Toast.makeText(getApplicationContext(), "Undo", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Unknown option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
