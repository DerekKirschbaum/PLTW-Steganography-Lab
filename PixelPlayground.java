import java.awt.Color;
public class PixelPlayground {

    /**
     * @param picture - original picture to modify
     * @return - new modified picture with no blue
     * Sets all blue values to zero
     */
    public static Picture zeroBlue(Picture picture){
        Picture newPic = new Picture(picture);
        Pixel[][] pixels = newPic.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                pixels[i][j].setBlue(0);
            }
        }
        return picture;
    }

    /**
     * @param picture - original picture to modify
     * @return - new modified picture with only blue
     * Sets all red and green values to zero
     */
    public static Picture keepOnlyBlue(Picture p){
        Picture np = new Picture(p);
        Pixel[][] pixels = np.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                pixels[i][j].setRed(0);
                pixels[i][j].setGreen(0);
            }
        }
        return np;
    }

    /**
     * @param picture - original picture to modify
     * @return - new modified picture with all pixels negated
     * Sets all RGB values to (255-priginal value)
     */
    public static Picture negate(Picture p){
        Picture np = new Picture(p);
        Pixel[][] pixels = np.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                pixels[i][j].setRed(255-pixels[i][j].getRed());
                pixels[i][j].setGreen(255-pixels[i][j].getGreen());
                pixels[i][j].setBlue(255-pixels[i][j].getBlue());
            }
        }
        return np;
    }

    /**
     * @param picture - original picture to modify
     * @return - new modified picture in gray scale
     * Sets all RGB values to average of original three values
     */
    public static Picture grayScale(Picture p){
        Picture np = new Picture(p);
        Pixel[][] pixels = np.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                int avg = (pixels[i][j].getRed() + pixels[i][j].getGreen() + pixels[i][j].getBlue())/3;
                pixels[i][j].setRed(avg);
                pixels[i][j].setGreen(avg);
                pixels[i][j].setBlue(avg);
            }
        }
        return np;
    }

    /**
     * @param picture - original picture to modify
     * @return - new modified picture with fish more visible
     * Sets fish RGB values to be more visible
     */
    public static Picture fishRevealer(Picture p){
        Picture np = new Picture(p);
        Pixel[][] pixels = np.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                if(pixels[i][j].getBlue()>153 && pixels[i][j].getRed()<26){
                    pixels[i][j].setBlue(pixels[i][j].getBlue()+80);
                    pixels[i][j].setRed(pixels[i][j].getRed()+200);
                }
            }
        }
        return np;
    }


    public static void main(String[] args) {
        Picture beachPic = new Picture("water.jpg");
        beachPic.explore();
        Picture beachPicNoBlue = fishRevealer(beachPic);
        beachPicNoBlue.explore();
    }
}
