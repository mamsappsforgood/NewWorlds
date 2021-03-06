package com.example.newworlds;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents an Education site consisting of a name, an address, a type, closing hours, and opening hours.
 */
public class Education implements Parcelable {
    private String name;
    private String address;
    private String type;
    private String ohours;
    private String chours;

    /**
     * Creates a new Education object
     * @param name is the name of the Education site
     * @param type is the type of Education site
     * @param address is the address of the Education site
     * @param ohours is the opening hours of the Education site
     * @param chours is the closing hours of the Education site
     */
    public Education (String name,String type, String address, String ohours, String chours)
    {
        this.name=name;
        this.address =address;
        this.type=type;
        this.chours=chours;
        this.ohours=ohours;
    }

    /**
     * Accesses the name of the Education site
     * @return the name
     */
    public String getName()
    {
        return  name;
    }

    /**
     * Accesses the address of the Education site
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Accesses the type of Education site
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Accesses the closing hours of the Education site
     * @return the closing hours
     */
    public String getChours() {
        return  chours;
    }

    /**
     * Accesses the opening hours of the Education site
     * @return the opening hours
     */
    public String getOhours() {
        return ohours;
    }

    //The following methods make the Education site parcelable.
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {name,address,type,chours,ohours});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Education createFromParcel(Parcel in){
            String[] string = in.createStringArray();
            Education toReturn = new Education(string[0],string[1],string[2],string[3],string[4]);
            return toReturn;
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    /**
     * Allows the Education site to be converted to a String
     * @return the name
     */
    public String toString(){
        return name;
    }

}
