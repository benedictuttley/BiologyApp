package com.example.benedict.myapplication.model;


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
}
