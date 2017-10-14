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
import com.example.benedict.myapplication.TopicActivity;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;
import static com.example.benedict.myapplication.R.mipmap.ic_launcher;

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

    /**
     * Created by Benedict on 09/10/2017.
     */

    public static class TopicAdapter extends RecyclerView.Adapter<TopicHolder> {
        private List<Topic> mTopics;
        private Context mContext;

        public TopicAdapter(List<Topic> topics, Context context){
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

    /**
     * Created by Benedict on 09/10/2017.
     */

    public static class TopicHolder extends RecyclerView.ViewHolder {
        private static final String TAG = TopicHolder.class.getSimpleName();
        private Topic mTopic;
        private Button mTopicTitleTextView;
        private ImageView mTopicImageView;
        private Context mContext;


        public TopicHolder(View itemView, final Context context) {
            super(itemView);
            // find values from the layout .xml files

            mTopicTitleTextView = (Button) itemView.findViewById(R.id.topicButton);
            mTopicTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext = context;
                Toast toast = Toast.makeText(mContext,mTopicTitleTextView.getText(),Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(mContext, StructureActivity.class);
                startActivity(mContext,intent,null);
                    }
        });
            mTopicImageView = (ImageView) itemView.findViewById(R.id.topicImageView);

        }

        // Binds views to their respective data
        public void bindTopic(Topic topic){
            mTopic = topic;
            Log.i(TAG,"test");
            mTopicTitleTextView.setText(mTopic.getTopicTitle());
           // mTopicImageView.setImageResource(mContext.getResources().getIdentifier(mTopic.getImageId(),"drawable", mContext.getPackageName()));
            mTopicImageView.setImageResource(ic_launcher);
        }




    }
}
