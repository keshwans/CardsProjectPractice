package org.c4q.cardsprojectpractice.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import org.c4q.cardsprojectpractice.R;
import org.c4q.cardsprojectpractice.adapters.FeedCardsAdapter;
import org.c4q.cardsprojectpractice.models.CardData;
import org.c4q.cardsprojectpractice.models.TestData;
import org.c4q.cardsprojectpractice.ui.helpers.SimpleItemTouchHelperCallback;

import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvFeedCards = (RecyclerView) findViewById(R.id.rv_feed_cards);
        rvFeedCards.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvFeedCards.setLayoutManager(llm);

        FeedCardsAdapter feedCardsAdapter = new FeedCardsAdapter();
        rvFeedCards.setAdapter(feedCardsAdapter);

        List<CardData> cardDataList = TestData.getTestData();
        feedCardsAdapter.setCardDataList(cardDataList);
//        feedCardsAdapter.notifyDataSetChanged();

        ItemTouchHelper.Callback callback =
                new SimpleItemTouchHelperCallback(feedCardsAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rvFeedCards);
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
