package com.example.benedict.myapplication.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.benedict.myapplication.R;
import com.example.benedict.myapplication.StructureActivity;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/* Class which is at the top of the hierarchy, Topic objects represent the general structures/themes which the user can learn about,
   for example the Topic 'cell'.
   In a future iteration this may implement an interface.
   In a future iteration Recycler view classes will be separated from class and model package all together to keep
   with the Model View Controller principles.*/

public class Topic {
    private String mTopicTitle;
    private String mImageId;


    public Topic(String title, String image_Id) {
        mTopicTitle = title;
        mImageId = image_Id;
    }

    public String getTopicTitle() {
        return mTopicTitle;
    }

    public void setTopicTitle(String TopicTitle) {
        mTopicTitle = TopicTitle;
    }

    public String getImageId() {
        return mImageId;
    }

    public void setImageId(String ImageId) {
        mImageId = ImageId;
    }

    // Class to link data in StructureComponent to the produced recycler views.

    public static class TopicAdapter extends RecyclerView.Adapter<TopicHolder> {
        private List<Topic> mTopics;
        private Context mContext;

        public TopicAdapter(List<Topic> topics, Context context) {
            mTopics = topics;
            mContext = context;
        }


        @Override
        public TopicHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(mContext.getApplicationContext());


            View view = layoutInflater.inflate(R.layout.list_item_topics, parent, false);
            return new TopicHolder(view, mContext);
        }

        @Override
        public void onBindViewHolder(TopicHolder holder, int position) {

            Topic topic = mTopics.get(position);
            holder.bindTopic(topic);

        }

        @Override
        public int getItemCount() {
            return mTopics.size();
        }
    }


    public static class TopicHolder extends RecyclerView.ViewHolder {
        private static final String TAG = TopicHolder.class.getSimpleName();
        private Topic mTopic;
        private Button mTopicTitleTextView;
        private ImageView mTopicImageView;
        private Context mContext;

        // Class to select views that will contain StructureComponent data.

        public TopicHolder(View itemView, final Context context) {
            super(itemView);

            mTopicTitleTextView = (Button) itemView.findViewById(R.id.topicButton);
            mTopicTitleTextView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    mContext = context;
                    Toast toast = Toast.makeText(mContext, mTopicTitleTextView.getText(), Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(mContext, StructureActivity.class);
                    startActivity(mContext, intent, null);
                }
            });
            mTopicImageView = (ImageView) itemView.findViewById(R.id.topicImageView);

        }

        // Sets the activity_topic recycled views with their associated data that has
        // been fetched using the adapter class.

        public void bindTopic(Topic topic) {
            mTopic = topic;
            mTopicTitleTextView.setText(mTopic.getTopicTitle());
            mTopicImageView.setImageResource(R.drawable.topicdrawings);

            // NOTE: There is no image set here as until the images have been created, a default image has been
            // set for reference
        }


    }
}
