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


    //mirrors left to right
    public static Picture mirrorVert1 (Picture p) {
        Picture np = new Picture(p);
        Pixel [][] pixels = np.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                pixels[i][np.getWidth()-j-1].setColor(pixels[i][j].getColor());
            }
        }
        return np;
    }

    //mirrors right to left
    public static Picture mirrorVert2 (Picture p) {
        Picture np = new Picture(p);
        Pixel [][] pixels = np.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=np.getWidth()-1; j>0; j--){
                pixels[i][np.getWidth()-j].setColor(pixels[i][j].getColor());
            }
        }
        return np;
    }

    //mirrors top to bottom
    public static Picture mirrorHorizontal1 (Picture p) {
        Picture np = new Picture(p);
        Pixel [][] pixels = np.getPixels2D();
        for(int i=0; i<pixels.length; i++){
            for(int j=0; j<pixels[0].length; j++){
                pixels[np.getHeight()-i-1][j].setColor(pixels[i][j].getColor());
            }
        }
        return np;
    }

    //mirrors bottom to top
    public static Picture mirrorHorizontal2 (Picture p) {
        Picture np = new Picture(p);
        Pixel [][] pixels = np.getPixels2D();
        for(int i=np.getHeight()-1; i>0; i--){
            for(int j=0; j<pixels[0].length; j++){
                pixels[np.getHeight()-i][j].setColor(pixels[i][j].getColor());
            }
        }
        return np;
    }


    public static Picture mirrorDiagonal(Picture p) {
        Picture np = new Picture(p);
        Pixel [][] pixels = np.getPixels2D();



        for(int i=0; i<Math.min(np.getWidth(), np.getHeight()); i++){
            for(int j=0; j<i+1; j++){
                pixels[j][i].setColor(pixels[i][j].getColor());
            }
        }
        return np;
    }

    public static Picture mirrorTemple(Picture p) {
        Picture np = new Picture(p);
        int mirrorPoint = 276;
        Pixel leftPixel;
        Pixel rightPixel;
        Pixel[][] pixels = np.getPixels2D();
        // loop through the rows
        for (int row = 27; row < 97; row++) {
        // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }

        }
        return np;
    }   


    public static void main(String[] args) {
        Picture beachPic = new Picture("beardgrowing.jpg");
        beachPic.explore();
        Picture beachPicNoBlue = mirrorDiagonal(beachPic);
        beachPicNoBlue.explore();
    }
}
