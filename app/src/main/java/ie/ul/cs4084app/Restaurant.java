package ie.ul.cs4084app;

public class Restaurant {
    int image;
    String info;

    public Restaurant(int image, String info) {
        this.image = image;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
