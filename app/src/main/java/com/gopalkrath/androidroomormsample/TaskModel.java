package com.gopalkrath.androidroomormsample;

/**
 * Created by gopal on 2/2/18.
 */

public class TaskModel {

    public int mId;
    public String mSubject;
    public String mDescription;
    public String mStatus;

    public TaskModel(String mSubject, String mDescription, String mStatus) {
        this.mSubject = mSubject;
        this.mDescription = mDescription;
        this.mStatus = mStatus;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmSubject() {
        return mSubject;
    }

    public void setmSubject(String mSubject) {
        this.mSubject = mSubject;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}
