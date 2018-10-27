package wooqer.com.wooqer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MoviesResponse {
    @SerializedName("description")
    private String description;
    @SerializedName("items")
    private List<Movie> items;
    @SerializedName("id")
    private String id;


    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public List<Movie> getItems() {
        return items;
    }

    public void setItems(List<Movie> items) {
        this.items = items;
    }

     public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }
}
