import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
//    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testReflection()
  {
    Picture swan = new Picture("swan.jpg");
 //   swan.reflection();
    swan.explore();
  }
  
  /** Method to test testMathColorize */
  public static void testMathColorize()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mathColorize();
    beach.explore();
  }
  
  /** Method to test rowMaker */
  public static void testRowMaker(int rowHeight)
  {
    Picture beach = new Picture("beach.jpg");
//    beach.explore();
    beach.rowMaker(rowHeight, Color.BLUE);
    beach.explore();
  }
  
  /** Method to test rowMaker */
  public static void testColMaker(int colWidth)
  {
    Picture beach = new Picture("beach.jpg");
//    beach.explore();
    beach.colMaker(colWidth, new Color(111, 222, 0));
    beach.explore();
  }
  
  /** Method to test rowMaker */
  public static void testCheckerBoardMaker(int rowHeight, int colWidth)
  {
    Picture beach = new Picture("beach.jpg");
//    beach.explore();
    beach.checkerBoardMaker(rowHeight, colWidth, Color.BLUE, new Color(111, 222, 0));
    beach.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
//    testMirrorVertical();
//      testReflection();

    testMathColorize();
//    testRowMaker(20);
//    testColMaker(50);
//    testCheckerBoardMaker(20, 50);

    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}