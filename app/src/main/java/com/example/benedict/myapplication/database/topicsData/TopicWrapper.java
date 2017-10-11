package com.example.benedict.myapplication.database.topicsData;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.benedict.myapplication.database.topicsData.TopicDbSchema;
import com.example.benedict.myapplication.model.Topic;


public class TopicWrapper extends CursorWrapper {

    public TopicWrapper(Cursor cursor) {
        super(cursor);
    }

    public Topic getTopic() {
        String topicTitle = getString(getColumnIndex(TopicDbSchema.TopicsTable.Cols.TITLE));
        String topicImageId = getString(getColumnIndex(TopicDbSchema.TopicsTable.Cols.IMAGE_ID));

        Topic mTopic = new Topic(topicTitle, topicImageId);
        return mTopic;
    }
}

