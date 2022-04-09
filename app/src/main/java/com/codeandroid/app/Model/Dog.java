package com.codeandroid.app.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dog implements Parcelable {
    private String bred_for;
    private String breed_group;
    private Height height;
    private String id;
    private String life_span;
    private String name;
    private String origin;
    private String temperament;
    private Weight weight;
    private String url;

    public Dog(String bred_for, String breed_group, Height height, String id, String life_span, String name, String origin, String temperament, Weight weight, String url) {
        this.bred_for = bred_for;
        this.breed_group = breed_group;
        this.height = height;
        this.id = id;
        this.life_span = life_span;
        this.name = name;
        this.origin = origin;
        this.temperament = temperament;
        this.weight = weight;
        this.url = url;
    }
    public Dog(){

    }

    protected Dog(Parcel in) {
        bred_for = in.readString();
        breed_group = in.readString();
        id = in.readString();
        life_span = in.readString();
        name = in.readString();
        origin = in.readString();
        temperament = in.readString();
        url = in.readString();
    }

    public static final Creator<Dog> CREATOR = new Creator<Dog>() {
        @Override
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        @Override
        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };

    public String getBred_for() {
        return bred_for;
    }

    public void setBred_for(String bred_for) {
        this.bred_for = bred_for;
    }

    public String getBreed_group() {
        return breed_group;
    }

    public void setBreed_group(String breed_group) {
        this.breed_group = breed_group;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bred_for);
        parcel.writeString(breed_group);
        parcel.writeString(id);
        parcel.writeString(life_span);
        parcel.writeString(name);
        parcel.writeString(origin);
        parcel.writeString(temperament);
        parcel.writeString(url);
    }
}
