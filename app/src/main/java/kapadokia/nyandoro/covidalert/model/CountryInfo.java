package kapadokia.nyandoro.covidalert.model;

import com.google.gson.annotations.SerializedName;

public class CountryInfo {

    @SerializedName("_id")
  
    private Integer id;
    @SerializedName("iso2")
  
    private String iso2;
    @SerializedName("iso3")
  
    private String iso3;
    @SerializedName("lat")
  
    private Integer lat;
    @SerializedName("long")
  
    private Integer _long;
    @SerializedName("flag")
  
    private String flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLong() {
        return _long;
    }

    public void setLong(Integer _long) {
        this._long = _long;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
