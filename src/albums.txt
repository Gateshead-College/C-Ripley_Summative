public class Albums {

    public int albumID;
    public String albumTitle;
    public String albumArtist;
    double albumPrice;
    int albumStock;

    public Albums(int albumID, String albumTitle, String albumArtist, double albumPrice, int albumStock) {
        this.albumID = albumID;
        this.albumTitle = albumTitle;
        this.albumArtist = albumArtist;
        this.albumPrice = albumPrice;
        this.albumStock = albumStock;
    }
}