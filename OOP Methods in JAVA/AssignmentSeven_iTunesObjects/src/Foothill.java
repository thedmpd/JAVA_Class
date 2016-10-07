/* Source Program for Assignment #7 for CS 1A
 * Written by Diogo Delgado 7/11/2015
 */


public class Foothill {
   
   //main
   public static void main(String[] args) throws Exception{
      //check for bad arguments for mutator's work and accessors 
      iTunes newWorld;
      newWorld = new iTunes();
      badSongName(newWorld.setSongName(""));
      badBitRate(newWorld.setBitRate(-65));
      newWorld.display();
      
      iTunes oldWorld;
      oldWorld = new iTunes("What?", "Who?", 543, 75400);
      oldWorld.display();
      oldWorld.setBitRate(128);
      oldWorld.setArtistName("The WHO");
      oldWorld.display();
      
      iTunes hello;
      hello = new iTunes("just", "RHCP", 200, 36500);
      hello.display();
      hello.setArtistName("Who are you?");
      hello.setBitRate(500);
      hello.setSongName("YMCA");
      hello.setTotalTime(70000);
      hello.display();
      
      iTunes helloNoParams;
      helloNoParams = new iTunes();
      helloNoParams.display();
      helloNoParams.setArtistName("I used to be undefined!");
      helloNoParams.setBitRate(128);
      helloNoParams.setSongName("Fly me to the Moon");
      helloNoParams.setTotalTime(56000);
      helloNoParams.display();
      
      iTunes theInvalid;
      theInvalid = new iTunes("why", "The lovers", 64, 60550);
      theInvalid.display();
      theInvalid.setArtistName("");
      theInvalid.setSongName("");
      theInvalid.setBitRate(-54);
      theInvalid.setTotalTime(-222);
      theInvalid.display();
   }
   public static boolean badSongName(boolean check){
      if (!check){
         System.out.println("You have entered an incorrect song name.");
         return true;
      }
      else
         return false;
   }
   public static boolean badBitRate(boolean check){
      if (!check){
         System.out.println("You have entered an incorrect bit rate.");
         return true;
      }
      else
         return false;
   }
}

class iTunes{
   //member data and shared constants
   private String songName;
   private String artistName;
   private int bitRate;
   private int totalTime;
   public static final int MIN_BITRATE = 64;
   public static final int MAX_BITRATE = 705;
   public static final int MIN_STR_LENGTH = 1;
   public static final int MAX_STR_LENGTH = 80;
   public static final int MIN_PLAY_TIME = 1000;
   public static final int MAX_PLAY_TIME = 1000*60*60;
   public static final int DEFAULT_BITRATE = 64;
   public static final int DEFAULT_PLAY_TIME = 1000;
   public static final String DEFAULT_STRING = " (undefined) ";
   //default constructor
   iTunes(){
      songName = DEFAULT_STRING;
      artistName = DEFAULT_STRING;
      bitRate = DEFAULT_BITRATE;
      totalTime = DEFAULT_PLAY_TIME;
   }
   //default constructor with 4 formal parameters
   iTunes(String songName, String artistName, int bitRate, int totalTime){
      if ( validString(songName))
         this.songName = songName;
      else
         this.songName = DEFAULT_STRING;
      
      if ( validString(artistName))
         this.artistName = artistName;
      else
         this.artistName = DEFAULT_STRING;
      
      if ( validBitRate(bitRate))
         this.bitRate = bitRate;
      else
         this.bitRate = DEFAULT_BITRATE;
      
      if ( validTotalTime(totalTime))
         this.totalTime = totalTime;
      else
         this.totalTime = DEFAULT_PLAY_TIME;
   }
   //private tester for valid string
   private boolean validString(String str){
      if (str == null || str.length() < MIN_STR_LENGTH || 
            str.length() > MAX_STR_LENGTH)
         return false;
      else
         return true;
   }
   //private tester for play time
   private boolean validTotalTime(int totalTime){
      if (totalTime >= MIN_PLAY_TIME && totalTime <= MAX_PLAY_TIME)
         return true;
      else
         return false;
   }
   //private tester for bit rate
   private boolean validBitRate(int bitRate){
      if (bitRate >= 64 && bitRate <= 705)
         return true;
      else
         return false;
   }
   //mutate methods for the four data sets 
   //songName, artistName, bitRate, totalTime
   public boolean setSongName(String str){
      if (validString(str)){
         songName = str;
         return true;
      }
      else
         return false;
   }
   public boolean setArtistName(String str){
      if (validString(str)){
         artistName = str;
         return true;
      }
      else
         return false;
   }
   public boolean setBitRate(int bitRate){
      if (validBitRate(bitRate)){
         this.bitRate = bitRate;
         return true;
      }
      else
         return false;
   }
   public boolean setTotalTime(int totalTime){
      if (validTotalTime(totalTime)){
         this.totalTime = totalTime;
         return true;
      }
      else
         return false;
   }
   //accessor methods for the four data sets
   //songName, artistName, bitRate, totalTime
   public String getSongName(){
      return songName;
   }
   public String getArtistName(){
      return artistName;
   }
   public int getBitRate(){
      return bitRate;
   }
   public int getTotalTime(){
      return totalTime;
   }
   // String toString formatting of an object's information
   public String toString(){
      String nicePackage;
      String correctTime;
      int seconds;
      seconds = totalTime/1000;
      //correct spelling of 1 second
      if (seconds == 1)
         correctTime = " second";
      else
         correctTime = " seconds";
      //format the string
      nicePackage = "Title: " + songName + " | Artist: " +
         artistName + " | Playing Time: " + seconds + correctTime +
         " | Bit Rate: " + bitRate;
      return nicePackage;
   }
   public void display(){
      System.out.println(toString() + System.lineSeparator());
   }
}
