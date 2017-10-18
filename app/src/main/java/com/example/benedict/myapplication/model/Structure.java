package com.example.benedict.myapplication.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benedict.myapplication.R;
import com.example.benedict.myapplication.StructureActivity;
import com.example.benedict.myapplication.StructureComponentActivity;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


/**
 * Created by Benedict on 09/10/2017.
 */

public class Structure {

    private String mStructureTitle;
    private String mImageId;
    private String mTopicDescription;

    public Structure(String title, String imageId, String description) {
        mStructureTitle = title;
        mImageId = imageId;
        mTopicDescription = description;
    }

    ;


    public String getStructureTitle() {
        return mStructureTitle;
    }

    public void setStructureTitle(String StructureTitle) {
        mStructureTitle = StructureTitle;
    }

    public String getImageId() {
        return mImageId;
    }

    public void setImageId(String ImageId) {
        mImageId = mImageId;
    }

    public String getTopicDescription() {
        return mTopicDescription;
    }

    public void setTopicDescription(String TopicDescription) {
        mTopicDescription = TopicDescription;
    }

    public static class StructureAdapter extends RecyclerView.Adapter<StructureHolder> {
        private List<Structure> mStructures;
        private Context mContext;


        public StructureAdapter(List<Structure> structures, Context context) {
            mStructures = structures;
            mContext = context;

        }

        @Override
        public StructureHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext.getApplicationContext());

            View view = layoutInflater.inflate(R.layout.list_item_structures, parent, false);
            return new StructureHolder(view, mContext);

        }

        @Override
        public void onBindViewHolder(StructureHolder holder, int position) {


            Structure structure = mStructures.get(position);
            holder.bindStructure(structure);
        }

        @Override
        public int getItemCount() {
            return mStructures.size();
        }
    }


    private static class StructureHolder extends RecyclerView.ViewHolder {

        private Structure mStructure;
        private TextView mStructureTitle;
        private Button mStructureButton;
        private TextView mStructureDescription;
        private Context mContext;
        private ImageView mStructureImageView;


        public StructureHolder(View itemView, final Context context) {
            super(itemView);

            mStructureButton = (Button) itemView.findViewById(R.id.structureButton);
            mStructureImageView = (ImageView) itemView.findViewById(R.id.structureImageView);
            //mStructureDescription = (TextView) itemView.findViewById(R.id.structureDescriptionTextView);


            mStructureButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context mContext = context;

                    Intent intent = new Intent(mContext, StructureComponentActivity.class);
                    startActivity(mContext,intent,null);

                    Toast toast = Toast.makeText(mContext, mStructureButton.getText(), Toast.LENGTH_SHORT);
                    toast.show();
                }


            });
        }


        public void bindStructure(Structure structure) {
            mStructure = structure;
            mStructureButton.setText(mStructure.getStructureTitle());
            mStructureImageView.setImageResource(R.drawable.cellwall);

            //mTopicImageView.setImageResource(ic_launcher);
        }


    }

}






