package com.example.android.tourguide;

/**
 * Created by Massimiliano on 08/02/2018.
 */

public class Info {

    //** This is the name of the place or the restaurant or the hotel or the event*/
    private String mNameInfo;

    //** This is the address where the nameInfo is*/
    private String mAddress;

    //** This is the google map position of the location*/
    private String mPositionLink;

    /** Image resource ID for the location */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Image resource ID for the InfoActivity*/

    private int mImageResourceIdIA = NO_IMAGE_PROVIDED;

    /**The description of the Info*/
    private String mDescription;

    /**The Link to the media resource**/
    private String mMediaLink;

    /** Image resource ID of the icon of the description link in the activity_info.xml*/
    private int mImageResourceIdDI;

    /** The string of the descriprition resource in the activity_info.xml*/
    private String mDescrSourceText;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Info object.
     *
     *
     * @param nameInfo is the name of the place
     * @param address is the address of the place
     * @param positionLink is the google maps link of the position of the location
     *
     * @param imageResourceId is the drawable resource ID for the image associated with the location
     * @param imageResourceIdIA is the drawable resource ID for the image associated with the location for the InfoActivity
     * @param description is the short description of the location
     * @param imageResourceIdDI is the image resource ID of the icon of the description link in the activity_info.xml
     * @param descrSourceText The string of the descriprition resource in the activity_info.xml
     *
     */
    public Info(String nameInfo, String address, String positionLink, int imageResourceId, int imageResourceIdIA, String description, int imageResourceIdDI, String descrSourceText) {
        this.mNameInfo = nameInfo;
        this.mAddress = address;
        this.mPositionLink = positionLink;
        this.mImageResourceId = imageResourceId;
        this.mImageResourceIdIA = imageResourceIdIA;
        this.mDescription = description;
        this.mImageResourceIdDI = imageResourceIdDI;
        this.mDescrSourceText = descrSourceText;
    }

    /**
     * Create a new Info object.
     *
     *
     * @param nameInfo is the name of the place
     * @param address is the address of the place
     * @param positionLink is the google maps link of the position of the location
     *
     * @param imageResourceId is the drawable resource ID for the image associated with the nameInfo
     * @param imageResourceIdIA is the drawable resource ID for the image associated with the location for the InfoActivity
     * @param description is the short description of the location
     * @param imageResourceIdDI is the image resource ID of the icon of the description link in the activity_info.xml
     * @param mediaLink is the link to the media source
     * @param descrSourceText The string of the descriprition resource in the activity_info.xml
     *
     */
    public Info(String nameInfo, String address, String positionLink, int imageResourceId, int imageResourceIdIA, String description, int imageResourceIdDI, String mediaLink, String descrSourceText ) {
        this.mNameInfo = nameInfo;
        this.mAddress = address;
        this.mPositionLink = positionLink;
        this.mImageResourceId = imageResourceId;
        this.mImageResourceIdIA = imageResourceIdIA;
        this.mDescription = description;
        this.mImageResourceIdDI = imageResourceIdDI;
        this.mMediaLink = mediaLink;
        this.mDescrSourceText = descrSourceText;
    }

    public String getNameInfo() {
        return mNameInfo;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPositionLink() {
        return mPositionLink;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public int getImageResourceIdIA(){
        return mImageResourceIdIA;
    }

    public String getDescription(){
        return mDescription;
    }

    public int getImageResourceIdDI() { return mImageResourceIdDI; }

    public String getMediaLink() {return mMediaLink;}

    public String getDescrSourceText() {return mDescrSourceText;}

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
