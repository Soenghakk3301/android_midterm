package kh.edu.rupp.ite.onlineshop.api.model;
import com.google.gson.annotations.SerializedName;

public class ProfileModel {

    @SerializedName("first_name")
    private String firstname;

    @SerializedName("last_name")
    private String lastname;

    private String email;

    @SerializedName("phone-number")
    private String phoneNumber;

    private String gender;

    @SerializedName("image-url")
    private String imageUrl;

    private String birthday;

    private String address;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
}
