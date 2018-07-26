package rs.ropeta.moviesapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ConfigurationResponse {

    @SerializedName("images")
    Images images;
    @SerializedName("change_keys")
    String[] changeKeys;

    public Images getImages() {
        return images;
    }

    public String getBaseUrl() {
        return getImages() != null ? getImages().getBaseUrl() : null;
    }

    public String[] getPosterSizes() {
        return getImages() != null ? getImages().getPosterSizes() : null;
    }

    @Override
    public String toString() {
        return "ConfigurationResponse{" +
                "images=" + images +
                ", changeKeys=" + Arrays.toString(changeKeys) +
                '}';
    }

    public static class Images {
        @SerializedName("base_url")
        String baseUrl;
        @SerializedName("secure_base_url")
        String secureBaseUrl;
        @SerializedName("logo_sizes")
        String[] logoSizes;
        @SerializedName("poster_sizes")
        String[] posterSizes;
        @SerializedName("profile_sizes")
        String[] profileSizes;
        @SerializedName("still_sizes")
        String[] stillSizes;


        public String getBaseUrl() {
            return baseUrl;
        }

        public String[] getPosterSizes() {
            return posterSizes;
        }

        @Override
        public String toString() {
            return "Images{" +
                    "baseUrl='" + baseUrl + '\'' +
                    ", secureBaseUrl='" + secureBaseUrl + '\'' +
                    ", logoSizes=" + Arrays.toString(logoSizes) +
                    ", posterSizes=" + Arrays.toString(posterSizes) +
                    ", profileSizes=" + Arrays.toString(profileSizes) +
                    ", stillSizes=" + Arrays.toString(stillSizes) +
                    '}';
        }
    }


}
