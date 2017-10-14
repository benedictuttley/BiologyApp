package com.example.benedict.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.benedict.myapplication.database.topicsData.TopicBaseHelper;
import com.example.benedict.myapplication.database.topicsData.TopicDbSchema;
import com.example.benedict.myapplication.database.topicsData.TopicWrapper;
import com.example.benedict.myapplication.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private RecyclerView mTopicRecycler;
    private Topic.TopicAdapter mAdapter;
    private static final String TAG = TopicActivity.class.getSimpleName();
    private Button button;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = new TopicBaseHelper(this).getWritableDatabase();
        setContentView(R.layout.activity_topic);
        Topic topic;
        addTopic(topic = new Topic("Cell", "cell"));
        mTopicRecycler = (RecyclerView) findViewById(R.id.topic_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mTopicRecycler.setLayoutManager(linearLayoutManager);
        updateUI();

    }

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        TopicWrapper cursor = queryTopics(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Log.i(TAG, cursor.getTopic().getTopicTitle());
                topics.add(cursor.getTopic());
                cursor.moveToNext();
            }

        } finally {
            {
                cursor.close();
            }
        }
        topics.add(new Topic("test1", "test"));
        topics.add(new Topic("test1", "test"));
        return topics;


    }

    public void addTopic(Topic topic) {
        ContentValues values = getContentValues(topic);
        mDatabase.insert(TopicDbSchema.TopicsTable.NAME,
                null, values);
    }


    public static ContentValues getContentValues(Topic topic) {
        ContentValues values = new ContentValues();

        values.put(TopicDbSchema.TopicsTable.Cols.TITLE,
                topic.getTopicTitle());

        values.put(TopicDbSchema.TopicsTable.Cols.IMAGE_ID,
                topic.getImageId());
        return values;

    }


    private TopicWrapper queryTopics(String whereClause, String whereArgs[]) {
        Cursor cursor = mDatabase.query(
                TopicDbSchema.TopicsTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new TopicWrapper(cursor);
    }

    private void updateUI() {
        Log.i(TAG, "test");
        List<Topic> topics = getTopics();
        Log.i(TAG, getTopics().toString());
        mAdapter = new Topic.TopicAdapter(topics, this);
        mTopicRecycler.setAdapter(mAdapter);


    }
}
