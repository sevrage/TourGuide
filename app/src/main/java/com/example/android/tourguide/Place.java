package com.example.android.tourguide;

/**
 * {@link Place} represents a place in the a city
 */
public class Place {

    private static final int NO_RESOURCE_PROVIDED = -1;

    private int mNameResourceId;

    private int mAddressResourceId = NO_RESOURCE_PROVIDED;

    private int mWebSiteResourceId = NO_RESOURCE_PROVIDED;

    private int mAudioResourceId = NO_RESOURCE_PROVIDED;

    private int mImageResourceId = NO_RESOURCE_PROVIDED;


    public Place(int nameResourceId, int addressResourceId, int webSiteResourceId,
                 int imageResourceId) {
        mNameResourceId = nameResourceId;
        mAddressResourceId = addressResourceId;
        mWebSiteResourceId = webSiteResourceId;
        mImageResourceId = imageResourceId;
    }

    public Place(int nameResourceId, int addressResourceId, int imageResourceId) {
        mNameResourceId = nameResourceId;
        mAddressResourceId = addressResourceId;
        mImageResourceId = imageResourceId;
    }

    public int getNameResourceId() {
        return mNameResourceId;
    }

    public int getWebsiteResourceId() {
        return mWebSiteResourceId;
    }

    public int getAddressResourceId() {
        return mAddressResourceId;
    }

    //public int getPhoneResourceId() {return mPhoneResourceId;}
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasAddress() {
        return mAddressResourceId != NO_RESOURCE_PROVIDED;
    }

    public boolean hasWebsite() {
        return mWebSiteResourceId != NO_RESOURCE_PROVIDED;
    }

    public boolean hasAudio() {
        return mAudioResourceId != NO_RESOURCE_PROVIDED;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_RESOURCE_PROVIDED;
    }


}