package com.example.benedict.myapplication.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benedict.myapplication.R;

import java.util.List;

/*  Class represents the lowest structure in the hierarchy, for example: If the Topic is the cell and the structure is the nucleus,
    then the StructureComponent may be the nucleolus, or the nuclear envelope.
    In a future iteration this may implement an interface.
    In a future iteration Recycler view classes will be separated from class and model package all together to keep
    with the Model View Controller principles.*/


public class StructureComponent {
    private String mStructureTitle;
    private String mImageId;
    private String mDescription;
    private String mPurpose;
    private String mOrganelle;


    public StructureComponent(String structureTitle, String description, String purpose, String imageId, String organelle) {
        mStructureTitle = structureTitle;
        mDescription = description;
        mPurpose = purpose;
        mImageId = imageId;
        mOrganelle = organelle;
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
        mImageId = ImageId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String Description) {
        mDescription = Description;
    }

    public String getPurpose() {
        return mPurpose;
    }

    public void setPurpose(String Purpose) {
        mPurpose = Purpose;
    }

    public String getOrganelle() {
        return mOrganelle;
    }

    public void setOrganelle(String Organelle) {
        mOrganelle = Organelle;
    }




    // Class to link data in StructureComponent to the produced recycler views.

    public static class ComponentAdapter extends RecyclerView.Adapter<ComponentHolder>{

        private List<StructureComponent> mComponents;
        private Context mContext;

        public ComponentAdapter(List<StructureComponent> components, Context context){
            mComponents = components;
            mContext = context;
        }

        @Override
        public ComponentHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(mContext.getApplicationContext());



            View view = layoutInflater.inflate(R.layout.list_item_structure_component, parent, false);
            return new ComponentHolder(view);

        }

        @Override
        public void onBindViewHolder(ComponentHolder holder, int position) {
            StructureComponent component = mComponents.get(position);
            holder.bindComponent(component);
        }

        @Override
        public int getItemCount() {
            return mComponents.size();
        }
    }

    // Class to select views that will contain StructureComponent data.

    public static class ComponentHolder extends RecyclerView.ViewHolder{

        private StructureComponent mStructureComponent;
        private TextView mComponentTitleTextView;
        private ImageView mComponentImageView;
        private TextView mComponentDescriptionTextView;
        private TextView mComponentPurposeTextView;
        private Context mContext;


        public ComponentHolder(View itemView) {
            super(itemView);

            mComponentTitleTextView = (TextView) itemView.findViewById(R.id.componentTitle);
            mComponentImageView = (ImageView) itemView.findViewById(R.id.componentImageView);
            mComponentDescriptionTextView = (TextView) itemView.findViewById(R.id.componentDescription);
            mComponentPurposeTextView = (TextView) itemView.findViewById(R.id.componentPurpose);
        }


        // Sets the activity_structure_component recycled views with their associated data that has
        // been fetched using the adapter class.

        public void bindComponent(StructureComponent component){
            StructureComponent mComponent = component;
            mComponentTitleTextView.setText(mComponent.getStructureTitle());
            mComponentDescriptionTextView.setText(mComponent.getDescription());
            mComponentPurposeTextView.setText(mComponent.getPurpose());

            // NOTE: There is no image set here as until the images have been created, a default image has been
            // set for reference
        }
    }

}
