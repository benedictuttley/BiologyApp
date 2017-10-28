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

import com.example.benedict.myapplication.R;
import com.example.benedict.myapplication.StructureComponentActivity;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/*Class represents the sub Topic, for example if the Topic is the cell, then the structure is the nucleus.
  In a future iteration this may implement an interface.
  In a future iteration Recycler view classes will be separated from class and model package all together to keep
  with the Model View Controller principles.*/

public class Structure {

    private String mStructureTitle;
    private String mImageId;
    private String mTopicDescription;

    public Structure(String title, String imageId, String description) {
        mStructureTitle = title;
        mImageId = imageId;
        mTopicDescription = description;
    }


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


    // Class to link data in Structure to the produced recycler views.

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

    // Class to select views that will contain Structure data.
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
            mStructureDescription = (TextView) itemView.findViewById(R.id.structureDescriptionTextView);

            // Created the link between the button associated with that Structure and its sub-structure objects
            // called StructureComponents

            mStructureButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context mContext = context;

                    Intent intent = new Intent(mContext, StructureComponentActivity.class);
                    startActivity(mContext, intent, null);
                }


            });
        }

        // Sets the activity_structure recycled views with their associated data that has
        // been fetched using the adapter class.

        public void bindStructure(Structure structure) {
            mStructure = structure;
            mStructureButton.setText(mStructure.getStructureTitle());
            mStructureImageView.setImageResource(R.drawable.cellwall);
            mStructureDescription.setText(mStructure.getTopicDescription());
        }


    }

}






