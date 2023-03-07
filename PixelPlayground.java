import java.awt.Color;
public class PixelPlayground {

    //Removes blue values from all RGBs of pixels in picture, return Picture
    public static Picture zeroBlue(Picture picture){
        Picture newPic = picture;
        Pixel[][] pixels = newPic.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                pixels[i][j].setBlue(0);
            }
        }


        return picture;
    }
    public static void main(String[] args) {
        Picture beachPic = new Picture("beach.jpg");
        beachPic.explore();
        Picture beachPicNoBlue = zeroBlue(beachPic);
        beachPicNoBlue.explore();
    }
}
