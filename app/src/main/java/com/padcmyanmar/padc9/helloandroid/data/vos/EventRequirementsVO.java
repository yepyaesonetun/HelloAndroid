package com.padcmyanmar.padc9.helloandroid.data.vos;

public class EventRequirementsVO {
    private int gender;
    private String ageRange;
    private String privacy;
    private int maxPeopleAvailable;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public int getMaxPeopleAvailable() {
        return maxPeopleAvailable;
    }

    public void setMaxPeopleAvailable(int maxPeopleAvailable) {
        this.maxPeopleAvailable = maxPeopleAvailable;
    }
}
