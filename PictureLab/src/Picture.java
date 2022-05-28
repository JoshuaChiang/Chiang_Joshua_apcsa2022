import java.awt.*;
import java.util.Arrays;
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
  
  
//Steganography project
  
  public int[] recArray;
  
  public int[] recaman(int x) 	//Recaman's Sequence: a(n) = a(n-1) + n
  {
      //Create array
      recArray = new int[x];
   
      //First term = 0
      recArray[0] = 0;
   
      for (int i = 1; i < x; i++) {
          int curr = recArray[i - 1] - i;
          for (int j = 0; j < i; j++) {
              //Checks if recArray[i-1] - i < 0 or is already in recArray[]
              if ((recArray[j] == curr) || curr < 0) {
                  curr = recArray[i - 1] + i;
                  break;
              }
          }
          recArray[i] = curr;
      }
      return recArray;
  }
  
  public void newEncode(Picture messagePict)
  {
	  Pixel[][] messagePixels = messagePict.getPixels2D();
	  Pixel[][] currPixels = this.getPixels2D();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  
	  //seq is used to increment the index for accessing recArray[]
	  int seq = 0;
	  
	  //The hundreds digit, tens digit and ones digit of the recaman number at recArray[seq]
	  int iR; 	//hundreds
	  int iG; 	//tens
	  int iB; 	//ones
	  
	  //The red, green and blue value of currpixel
	  int iRed;
	  int iGreen;
	  int iBlue;
	  
	  //The hundreds digit, tens digit and ones digit of the red value of currpixel
	  int iRed100s;
	  int iRed10s;
	  int iRed1s;
	  
	  //The hundreds digit, tens digit and ones digit of the green value of currpixel
	  int iGreen100s;
	  int iGreen10s;
	  int iGreen1s;
	  
	  //The hundreds digit, tens digit and ones digit of the blue value of currpixel
	  int iBlue100s;
	  int iBlue10s;
	  int iBlue1s;
	  
	  //Calls recaman method
	  //Creates an array with consecutive Recaman terms
	  //The number of terms is equal to the total amount of pixels in the original picture (1 term corresponds to 1 pixel)
	  recaman(this.getWidth()*this.getHeight());
	  
	  for (int row = 0; row < this.getHeight(); row++)
	  {
		  for (int col = 0; col < this.getWidth(); col++)
		  {
			  currPixel = currPixels[row][col];
			  
			  //bound the recaman number to 3 digits for the 3 RGB values
			  while(recArray[seq]>999) {
				  recArray[seq] = recArray[seq]%10;
			  }
			  
			  iR = recArray[seq]/100;
			  iG = (recArray[seq]/10)%10;
			  iB = recArray[seq]%10;
			  
			  iRed = currPixel.getRed();
			  iGreen = currPixel.getGreen();
			  iBlue = currPixel.getBlue();
			  
			  iRed100s = iRed/100;
			  iRed10s = (iRed/10)%10;
			  iRed1s = iRed%10;
			  
			  iGreen100s = iGreen/100;
			  iGreen10s = (iGreen/10)%10;
			  iGreen1s = iGreen%10;
			  
			  iBlue100s = iBlue/100;
			  iBlue10s = (iBlue/10)%10;
			  iBlue1s = iBlue%10;
			  
			  
			  // Change red value by 1 to remove all instances of accidental sequence matches
			  if (iR == iRed1s && iG == iGreen1s && iB == iBlue1s) {
				  if(iRed1s == 9) {
					  iRed1s = 8;
				  } else {
					  iRed1s=iRed1s+1;
				  }
			  }
			  
			  //encoding the message
			  if (messagePixels[row][col].colorDistance(Color.BLACK) < 50)
			  { 
				  iRed1s = iR;
				  iGreen1s = iG;
				  iBlue1s = iB;
			  
				  currPixel.setRed(iRed100s*100+iRed10s*10+iRed1s);
				  currPixel.setGreen(iGreen100s*100+iGreen10s*10+iGreen1s);
				  currPixel.setBlue(iBlue100s*100+iBlue10s*10+iBlue1s);
			  }
			  seq++;
		 }
	 }
 }
  
  public Picture newDecode()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = this.getHeight();
	  int width = this.getWidth();
	  Pixel currPixel = null;
	  //seq is used to increment the index for accessing recArray[]
	  int seq = 0;
	  
	  //The hundreds digit, tens digit and ones digit of the recaman number at recArray[seq]
	  int iR; 	//hundreds
	  int iG; 	//tens
	  int iB; 	//ones
	  
	  //The red, green and blue value of currpixel
	  int iRed;
	  int iGreen;
	  int iBlue;
	  
	  //The hundreds digit, tens digit and ones digit of the red value of currpixel
	  int iRed100s;
	  int iRed10s;
	  int iRed1s;
	  
	  //The hundreds digit, tens digit and ones digit of the green value of currpixel
	  int iGreen100s;
	  int iGreen10s;
	  int iGreen1s;
	  
	  //The hundreds digit, tens digit and ones digit of the ble value of currpixel
	  int iBlue100s;
	  int iBlue10s;
	  int iBlue1s;

	  Pixel messagePixel = null;
	  Picture messagePicture = new Picture(height,width);
	  Pixel[][] messagePixels = messagePicture.getPixels2D();
	  int count = 0;
	  
	  //Decoding
	  for (int row = 0; row < this.getHeight(); row++)
	  {
		  for (int col = 0; col < this.getWidth(); col++)
		  {
			  currPixel = pixels[row][col];
			  //bound the recaman number to 3 digits for the 3 RGB values
			  while(recArray[seq]>50) {
				  recArray[seq] = recArray[seq]%10;
			  }
			  
			  iR = recArray[seq]/100;
			  iG = (recArray[seq]/10)%10;
			  iB = recArray[seq]%10;
			  
			  iRed = currPixel.getRed();
			  iGreen = currPixel.getGreen();
			  iBlue = currPixel.getBlue();
			  
			  iRed100s = iRed/100;
			  iRed10s = (iRed/10)%10;
			  iRed1s = iRed%10;
			  
			  iGreen100s = iGreen/100;
			  iGreen10s = (iGreen/10)%10;
			  iGreen1s = iGreen%10;
			  
			  iBlue100s = iBlue/100;
			  iBlue10s = (iBlue/10)%10;
			  iBlue1s = iBlue%10;
			  
			  
			  messagePixel = messagePixels[row][col];
			  
			  //check if the ones digit of the RGB values combine to form the recaman number
			  if (iR == iRed1s && iG == iGreen1s && iB == iBlue1s)
			  {
				  messagePixel.setColor(Color.BLACK);
			  }
			  seq++;
		  }
	  }
	  return messagePicture;
  }
  
  //failed initial attempt
  /**
  public void stegEncode(Picture messagePict)
  {
	  Pixel[][] messagePixels = messagePict.getPixels2D();
	  Pixel[][] currPixels = this.getPixels2D();
	  Pixel currPixel = null;
	  Pixel prevPixel = null;
	  Pixel nextPixel = null;
	  Pixel messagePixel = null;
	  int count = 0;
	  int temp = 0;
	  int avgDiff=0;
	  int prevAvgDiff=0;
	  int nextAvgDiff=0;
	  recaman(50);
	  
	  for (int row = 0; row < currPixels.length; row++) {
		  for (int col = 1; col < currPixels[0].length-1; col++) {
			  
			  currPixel = currPixels[row][col];
			  prevPixel = currPixels[row][col-1];
			  nextPixel = currPixels[row][col+1];
			  int currAvg = (currPixel.getRed()+currPixel.getBlue()+currPixel.getGreen())/3;
			  int prevAvg = (prevPixel.getRed()+prevPixel.getBlue()+prevPixel.getGreen())/3;
			  int nextAvg = (nextPixel.getRed()+nextPixel.getBlue()+nextPixel.getGreen())/3;
			  for(int i = 1; i<recArray.length-1; i++) {
				  //Get rid of all recamans
				  if (currAvg == recArray[i] && prevAvg == recArray[i-1] && nextAvg == recArray[i+1]){
					  if(currPixel.getBlue()<=2) {
						  currPixel.setBlue(currPixel.getBlue()+1);
					  } else {
						  currPixel.setBlue(currPixel.getBlue()-1);
					  }
					  if(currPixel.getRed()<=2) {
						  currPixel.setRed(currPixel.getRed()+1);
					  } else {
						  currPixel.setRed(currPixel.getRed()-1);
					  }
					  if(currPixel.getGreen()<=2) {
						  currPixel.setGreen(currPixel.getGreen()+1);
					  } else {
						  currPixel.setGreen(currPixel.getGreen()-1);
					  }
				  }
			  }
			  messagePixel = messagePixels[row][col];
			  if (messagePixel.colorDistance(Color.BLACK) < 50){
				  int[] newArr = recArray;
				  newArr[newArr.length-1] = currAvg;
				  //sort recArray
				  Arrays.sort(newArr);
				  //find least difference recaman with original average
				  for(int a = 1; a<newArr.length-1; a++) {
					  if(newArr[a] == currAvg) {
						  if(currAvg - newArr[a-1] < newArr[a+1] - currAvg) {
							  avgDiff = currAvg - newArr[a-1];
							  currPixel.setRed(currPixel.getRed()-avgDiff);
							  currPixel.setGreen(currPixel.getGreen()-avgDiff);
							  currPixel.setBlue(currPixel.getBlue()-avgDiff);
							  currAvg = newArr[a-1];
						  } else if(currAvg - newArr[a-1] > newArr[a+1] - currAvg){
							  avgDiff = newArr[a+1] - currAvg;
							  currPixel.setRed(currPixel.getRed()+avgDiff);
							  currPixel.setGreen(currPixel.getGreen()+avgDiff);
							  currPixel.setBlue(currPixel.getBlue()+avgDiff);
							  currAvg = newArr[a+1];
						  } else {
							  currAvg = newArr[a];
						  }
					  }
					  
				  }
				  //set the prev and next RGBs
				  if(prevAvg < nextAvg) {
					  for(int b = 1; b<recArray.length-1; b++) {
						  if(recArray[b] == currAvg) {
							  prevAvgDiff = recArray[b-1] - prevAvg;
							  prevPixel.setRed(prevPixel.getRed()-prevAvgDiff);
							  prevPixel.setGreen(prevPixel.getGreen()-prevAvgDiff);
							  prevPixel.setBlue(prevPixel.getBlue()-prevAvgDiff);
							  prevAvg = recArray[b];
						  }
					  }
					  for(int d = 1; d<recArray.length-1; d++) {
						  if(recArray[d] == currAvg) {
							  nextAvgDiff = nextAvg - recArray[d+1];
							  nextPixel.setRed(nextPixel.getRed()+nextAvgDiff);
							  nextPixel.setGreen(nextPixel.getGreen()+nextAvgDiff);
							  nextPixel.setBlue(nextPixel.getBlue()+nextAvgDiff);
							  nextAvg = recArray[d];
						  }
					  }
				  } 
			  }	
		  }
	  }
  	System.out.println(count);
  }
  
  public Picture stegDecode()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = this.getHeight();
	  int width = this.getWidth();
	  Pixel currPixel = null;
	  Pixel prevPixel = null;
	  Pixel nextPixel = null;
	  Pixel messagePixel = null;
	  
	  Picture messagePicture = new Picture(height,width);
	  Pixel[][] messagePixels = messagePicture.getPixels2D();
	  int count = 0;
	  for (int row = 0; row < this.getHeight(); row++){
		  for (int col = 1; col < this.getWidth()-1; col++){
			  currPixel = pixels[row][col];
			  messagePixel = messagePixels[row][col];
			  prevPixel = pixels[row][col-1];
			  nextPixel = pixels[row][col+1];
			  int currAvg = (currPixel.getRed()+currPixel.getBlue()+currPixel.getGreen())/3;
			  int prevAvg = (prevPixel.getRed()+prevPixel.getBlue()+prevPixel.getGreen())/3;
			  int nextAvg = (nextPixel.getRed()+nextPixel.getBlue()+nextPixel.getGreen())/3;
			  for(int i=1; i<recArray.length-1; i=i+3){
				  if((recArray[i] == currAvg && recArray[i-1] == prevAvg && recArray[i+1] == nextAvg) || ( recArray[i] == currAvg && recArray[i-1] == nextAvg && recArray[i+1] == prevAvg)){
					  messagePixel.setColor(Color.BLACK);
					  count++;
				  }
			  }
		  } 
	  }
	  System.out.println(count);
	  return messagePicture;
  }
  **/
  
} // this } is the end of class Picture, put all new methods before this
