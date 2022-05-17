package com.example.tourguideapp;


public class Word {

    private String mlandmark;
    private static final int NO_IMAGE_PROVIDED = -1;
    private static int mImageResourceId = NO_IMAGE_PROVIDED;
    private static double latitude;
    private static double longtude;

    public Word(String landmark, int imgid, double longtude, double latitude) {

        mlandmark = landmark;
        mImageResourceId = imgid;
        this.latitude = latitude;
        this.longtude = longtude;
    }

    public String getMlandmark() {
        return mlandmark;
    }

    public void setLabel(String label) {
        this.mlandmark = mlandmark;
    }

    public static int getmImageResourceId() {
        return mImageResourceId;
    }

    public static boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public static double getLatitude() {
        return latitude;
    }


    public static double getLongtude() {
        return longtude;
    }

}
