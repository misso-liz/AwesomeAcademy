 package aa.com.resources.utils;
 
 import java.awt.Image;
 import java.awt.image.BufferedImage;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.IOException;

 import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
 import com.sun.image.codec.jpeg.JPEGImageEncoder;
 
 
 
 public class ThumbnailUtils
 {
   private File file = null;
   private String inputDir;
   private String outputDir;
   private String inputFileName;
   private String outputFileName;
   private int outputWidth = 100;
   private int outputHeight = 100;
   private boolean proportion = true;
   
   public ThumbnailUtils()
   {
     this.inputDir = "";
     this.outputDir = "";
     this.inputFileName = "";
     this.outputFileName = "";
     this.outputWidth = 100;
     this.outputHeight = 100;
   }
   
   public long getPicSize(String path)
   {
     this.file = new File(path);
     return this.file.length();
   }
   
   private String compressPic()
   {
     try
     {
       this.file = new File(this.inputDir + this.inputFileName);
       if (!this.file.exists()) {
         return "";
       }
       Image img = ImageIO.read(this.file);
       if (img.getWidth(null) == -1)
       {
         System.out.println(" can't read,retry!");
         return "no";
       }
       int newHeight;
       int newWidth;
       if (this.proportion)
       {
         double rate1 = img.getWidth(null) / this.outputWidth + 0.1D;
         double rate2 = img.getHeight(null) / 
           this.outputHeight + 0.1D;
         
         double rate = rate1 > rate2 ? rate1 : rate2;
         newWidth = (int)(img.getWidth(null) / rate);
         newHeight = (int)(img.getHeight(null) / rate);
       }
       else
       {
         newWidth = this.outputWidth;
         newHeight = this.outputHeight;
       }
       BufferedImage tag = new BufferedImage(newWidth, 
         newHeight, 1);
       
 
       tag.getGraphics().drawImage(
         img.getScaledInstance(newWidth, newHeight, 
         4), 0, 0, null);
       FileOutputStream out = new FileOutputStream(this.outputDir + 
         this.outputFileName);
       
       JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
       encoder.encode(tag);
       out.close();
     }
     catch (IOException ex)
     {
       ex.printStackTrace();
     }
     return "ok";
   }
   
   public String compressPic(String inputDir, String inputFileName, String outputDir, String outputFileName)
   {
     this.inputDir = inputDir;
     
     this.outputDir = outputDir;
     
     this.inputFileName = inputFileName;
     
     this.outputFileName = outputFileName;
     return compressPic();
   }
   
   public String compressPic(String inputDir, String inputFileName, String outputDir, String outputFileName, int width, int height, boolean gp)
   {
     this.inputDir = inputDir;
     
     this.outputDir = outputDir;
     
     this.inputFileName = inputFileName;
     
     this.outputFileName = outputFileName;
     
 
     this.outputWidth = width;
     this.outputHeight = height;
     
     this.proportion = gp;
     return compressPic();
   }
 }





