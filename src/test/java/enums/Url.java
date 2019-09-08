package enums;

public enum Url {
    BASEURL("http://www.amazon.com");

    String url;

    Url(String url){
        this.url = url;
    }

    public String getURL() {
        return url;
    }



}
