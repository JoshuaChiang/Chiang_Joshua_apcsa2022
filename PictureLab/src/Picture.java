import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixelixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixelixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixelixel.getColor());
      }
    } 
  }
//--------------------------------------------A7.1
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixelixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixelixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixelixel.getColor());
      }
    }
    System.out.println(count);
  }
//----------------------------------------------  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixelixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixelixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixelixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixelixel.setColor(Color.BLACK);
        else
          leftPixelixel.setColor(Color.WHITE);
      }
    }
  }
 //-------------------------------------------------------------
  public void keepOnlyBlue() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel p = null;
	  for (int r = 0; r < pixels.length; r++) {
		  for (int c = 0; c < pixels[0].length; c++) {
			  p = pixels[r][c];
			  p.setRed(0);
			  p.setGreen(0);
		  }
	  }
  }
  
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel p = null;
	  for (int r = 0; r < pixels.length; r++) {
		  for (int c = 0; c < pixels[0].length; c++) {
			  p = pixels[r][c];
			  p.setRed(255-p.getRed());
			  p.setGreen(255-p.getGreen());
			  p.setBlue(255-p.getBlue());
		  }
	  }
  }
  
  public void grayscale(){
      Pixel[][] pixels = this.getPixels2D(); 
      Pixel p = null;
      int total = 0;
      int avg = 0;
      for (int r = 0; r < pixels.length; r++)
      {
          for (int c = 0; c < pixels[0].length; c++) {
              total = 0;
              p = pixels[r][c];
              total = total + p.getRed();
              total = total + p.getGreen();
              total = total + p.getBlue();
              avg = total / 3;
              p.setColor(new Color(avg, avg, avg));
          }
      }
  }
  
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D(); 
      Pixel p = null;
      int total = 0;
      int avg = 0;
      for (int r = 0; r < pixels.length; r++)
      {
          for (int c = 0; c < pixels[0].length; c++) {
              total = 0;
              p = pixels[r][c];
              p.setRed(p.getRed() * 3);
          }
      }
  }
  
  public void mirrorVerticalRightToLeft() {
	  Pixel[][] pixels = this.getPixels2D(); 
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int width = pixels[0].length;
      for (int r = 0; r < pixels.length; r++)
      {
          for (int c = 0; c < pixels[0].length; c++) {
              leftPixel = pixels[r][c];
              rightPixel = pixels[r][width-c-1];
              leftPixel.setColor(rightPixel.getColor());
          }
      }
  }
  
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D(); 
      Pixel topPixel = null;
      Pixel botPixel = null;
      int height = pixels.length;
      for (int r = 0; r < pixels.length; r++)
      {
          for (int c = 0; c < pixels[0].length; c++) {
              topPixel = pixels[r][c];
              botPixel = pixels[height-r-1][c];
              botPixel.setColor(topPixel.getColor());
          }
      }
  }
  
  public void mirrorHorizontalBotToTop() {
	  Pixel[][] pixels = this.getPixels2D(); 
      Pixel topPixel = null;
      Pixel botPixel = null;
      int height = pixels.length;
      for (int r = 0; r < pixels.length; r++)
      {
          for (int c = 0; c < pixels[0].length; c++) {
              topPixel = pixels[r][c];
              botPixel = pixels[height-r-1][c];
              topPixel.setColor(botPixel.getColor());
          }
      }
  }
  
  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D(); 
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      //max mirror area; min of width or height
      int max = pixels.length;
      if (pixels[0].length < max) {
    	  max = pixels[0].length;
      }
      
      //loop through to left of diagonal line; r=c
      for (int r = 0; r < pixels.length; r++){
    	  for (int c = 0; c < pixels[0].length; c++) {
    		  leftPixel = pixels[r][c];
              rightPixel = pixels[c][r];
              rightPixel.setColor(leftPixel.getColor());
          }
      }     
  }
  
  public void mirrorArms() {
	  int mirrorpt = 350;
	  Pixel[][] pixels = this.getPixels2D(); 
      Pixel topPixel = null;
      Pixel botPixel = null;
      
      //loop through rows
      for (int r = 225; r < 330; r++){
    	  //loop through columns
    	  for (int c = 100; c < 170; c++) {
    		  topPixel = pixels[r][c];
              botPixel = pixels[195-r+195][c];
              botPixel.setColor(topPixel.getColor());
          }
      }     
      
      //loop through rows
      for (int r = 155; r < 195; r++){
    	  //loop through columns
    	  for (int c = 249; c < 295; c++) {
    		  topPixel = pixels[r][c];
              botPixel = pixels[195-r+195][c];
              botPixel.setColor(topPixel.getColor());
          }
      }     
  }
  
  public void mirrorGull() {
	  Pixel[][] pixels = this.getPixels2D(); 
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int mirrorPoint = 350;
      
      //loop through rows
      for (int r = 225; r < 330; r++){
    	  //loop from 13 to just before mirrorPoint
    	  for (int c = 220; c < mirrorPoint; c++) {
    		  leftPixel = pixels[r][c];
              rightPixel = pixels[r][mirrorPoint-c];
              rightPixel.setColor(leftPixel.getColor());
          }
      }       
  }
  
  public void copy2(Picture fromPic, int fromStartRow, int fromStartCol, int fromEndRow, int fromEndCol, int toStartRow, int toStartCol) {
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
	for (int fromRow = fromStartRow, toRow = toStartRow; 
	  fromRow <= fromEndRow && toRow < toPixels.length; 
	  fromRow++, toRow++) {
		for (int fromCol = fromStartCol, toCol = toStartCol; 
		    fromCol <= fromEndCol && toCol < toPixels[0].length;  
		    fromCol++, toCol++) {
		 fromPixel = fromPixels[fromRow][fromCol];
		 toPixel = toPixels[toRow][toCol];
		 toPixel.setColor(fromPixel.getColor());
		}
	}  
  }
  
  public void edgeDetection2(int edgeDist) {
	  Picture copy = new Picture(this);
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  
	  // compare a pixel with one to the right
	  for (int r = 0; r < pixels.length; r++){
		  for (int c = 0; c < pixels[0].length; c++) {
			  leftPixel = pixels[r][c];
			  rightPixel = pixels[r][c+1];
			  rightColor = rightPixel.getColor();
			  if (leftPixel.colorDistance(rightColor) > edgeDist) {
				  leftPixel.setColor(Color.BLACK);
			  } else {
				  leftPixel.setColor(Color.WHITE);
			  }
    	  }
	  }
	  // compare a pixel with one below
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  Pixel[][] copyPixels = this.getPixels2D();
	  Color botColor = null;
	  
	  // compare a pixel with one to the right
	  for (int r = 0; r < copyPixels.length; r++){
		  for (int c = 0; c < copyPixels[0].length; c++) {
			  topPixel = copyPixels[r][c];
			  botPixel = copyPixels[r+1][c];
			  botColor = botPixel.getColor();
			  if (topPixel.colorDistance(botColor) > edgeDist) {
				  pixels[r][c].setColor(Color.BLACK);
			  }
    	  }
	  }
  }
  
  public void chromakey(Picture from){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] pixels2 = from.getPixels2D();
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	        if(pixels[row][col].getBlue() > pixels[row][col].getRed()) {
	          pixels[row][col].setColor(pixels2[row][col].getColor());
	        }
	      }
	    }
  }
  
  public void encode(Picture msg){
      Pixel[][] thisPixels = this.getPixels2D();
      Pixel[][] fromPixels = msg.getPixels2D();

      for(int r = 0; r < thisPixels.length; r++){
          for(int c = 0; c < fromPixels[r].length; c++){
              if(thisPixels[r][c].getRed()%2==1)
                  thisPixels[r][c].setRed(thisPixels[r][c].getRed()-1);
          }
      }

      for(int r = 0; r < thisPixels.length; r++){
          for(int c = 0; c < thisPixels[r].length; c++){
              if(fromPixels[r][c].colorDistance(Color.BLACK)<50){
                  if(thisPixels[r][c].getRed()%2==0)
                      thisPixels[r][c].setRed(thisPixels[r][c].getRed()+1);
              }
          }
      }
  }
  
  public Picture decode(){
      Picture now = new Picture(this.getHeight(), this.getWidth());
      Pixel[][] thisPixels = this.getPixels2D();
      Pixel[][] nowPixels = now.getPixels2D();

      for(int r = 0; r < thisPixels.length; r++){
          for(int c = 0; c < thisPixels[r].length; c++){
              if(thisPixels[r][c].getRed()%2==1)
                  nowPixels[r][c].setColor(Color.BLACK);
          }
      }

      return now;
  }
  
  public int getCountRedOverValue( int value )
  {
      int count = 0;
      Pixel[][] pixels = this.getPixels2D();
      Pixel currPixel = null;
      for ( int row = 0; row < pixels.length; row++ )
      {
          for ( int col = 0; col < pixels[0].length; col++ )
          {
              currPixel = pixels[row][col];
              if ( currPixel.getRed() > value )
              {
                  count++;
              }
          }
      }
      return count;
  }
  
  public void setRedToHalfValueInTopHalf()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel currPixel = null;
      for ( int row = 0; row < pixels.length / 2; row++ )
      {
          for ( int col = 0; col < pixels[0].length; col++ )
          {
              currPixel = pixels[row][col];
              currPixel.setRed( currPixel.getRed() / 2 );
          }
      }
  }

  public void clearBlueOverValue( int value )
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel currPixel = null;
      for ( int row = 0; row < pixels.length; row++ )
      {
          for ( int col = 0; col < pixels[0].length; col++ )
          {
              currPixel = pixels[row][col];
              if ( currPixel.getBlue() > value )
              {
                  currPixel.setBlue( 0 );
              }
          }
      }
  }

  public int[] getAverageForColumn( int col )
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel currPixel = null;
      int[] averageArray = new int[pixels[col].length];
      int total = 0;

      for ( int row = 0; row < pixels.length; row++ )
      {
          currPixel = pixels[row][col];
          total = currPixel.getRed() + currPixel.getGreen()
              + currPixel.getBlue();
          averageArray[row] = total / 3;
      }
      return averageArray;
  }
  
  
} // this } is the end of class Picture, put all new methods before this
