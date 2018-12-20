// Assign4 Fall 2018
/*
  Note for book type:
   
  a    Adventure
  r    Romance
  s    Sci-Fi
  h    Horror
  
  E for ePub
  M for mobi
  H for hardcopy
  
  book format [0] for ePub  true/false
  book format [1] for mobi true/false
  book format [2] for hardcopy true/false
 
  book price[0]  for ePub price
  book price[1]  for mobi price
  book price[2]  for hard copy price
  
*/
class BookInfo
{

  private String strBookTitle;
  private char chBookType;
  private boolean boolBookFormatAvail[] = new  boolean[3];
  private double doubBookPrice[] = new double[3];
  private String strBookCover;
  private String strBookComment;  
  

  BookInfo(String title, char cType, 
		  boolean boolFormatE, boolean boolFormatM, 
		  boolean boolFormatH, double doubEPrice, 
		  double doubMPrice, double doubHPrice, 
		  String cover,String strBookCmt)
  {
  
     strBookTitle = title;
	  chBookType = cType;
     boolBookFormatAvail[0] = boolFormatE;
	  boolBookFormatAvail[1] = boolFormatM;
     boolBookFormatAvail[2] = boolFormatH;
     
     doubBookPrice[0] = doubEPrice;
     doubBookPrice[1] = doubMPrice;
      doubBookPrice[2] = doubHPrice;
      strBookCover = cover; 
	  strBookComment = strBookCmt;
	   

  }

  ////////////////////////////////////////////////
  //Finish this class by writing the various public set/get methods
  // for the above instance variables
  ////////////////////////////////////////////////  
  

  public String getStrBookTitle() {
	return strBookTitle;
}


public void setStrBookTitle(String strBookTitle) {
	this.strBookTitle = strBookTitle;
}


public char getChBookType() {
	return chBookType;
}


public void setChBookType(char chBookType) {
	this.chBookType = chBookType;
}


public boolean[] getBoolBookFormatAvail() {
	return boolBookFormatAvail;
}


public void setBoolBookFormatAvail(boolean[] boolBookFormatAvail) {
	this.boolBookFormatAvail = boolBookFormatAvail;
}


public double[] getDoubBookPrice() {
	return doubBookPrice;
}


public void setDoubBookPrice(double[] doubBookPrice) {
	this.doubBookPrice = doubBookPrice;
}


public String getStrBookCover() {
	return strBookCover;
}


public void setStrBookCover(String strBookCover) {
	this.strBookCover = strBookCover;
}


public String getStrBookComment() {
	return strBookComment;
}


public void setStrBookComment(String strBookComment) {
	this.strBookComment = strBookComment;
}
  
  
  
}

///////////////////////////////

class BookList
{

  BookInfo[] bkList;
  
  public void createList()
  {
  
     bkList = new BookInfo[29];
		bkList[0] = new BookInfo("20,000 Leagues Under the Sea",'a', 
				true,true,true,34.86,23.99,9.99,"20000 leagues under the sea.jpg",
				"<html>Undersea adventure <br />with captain nemo.</html>");
		bkList[1] = new BookInfo("A Knight in Shining Armour",'r', 
				false,true,true,30.86,12.99,7.99,"A Knight in Shining Armour.jpg",
				"A knight in shining armour");

		bkList[2] = new BookInfo("Around the World in Eighty Days",'a', 
				true,true,false,34.86,23.99,5.99,"Around the World in Eighty Days.jpg",
				"Travelling before travel agents");

		bkList[3] = new BookInfo("Do Androids dream of Electric Sheep",'s', 
				true,false,true,25.45,10.92,8.99,"Do Androids dream of Electric Sheep.jpg",
				"<html>Rick Decard must retire 5 replicants<br /> and wants to be called BladeRunner.</html>");

		bkList[4] = new BookInfo("Dracula",'h', 
				false,false,false,
				24.86,23.99,44.99,"Dracula.jpg",
				"<html>Yes, it's the guy<br />with the fangs and a liquid diet.</html>");

		bkList[5] = new BookInfo("Dune",'s', true,false,true,24.86,23.99,29.99,"dune.jpg","Desert worms with spice, delicious.");
		bkList[6] = new BookInfo("Ender's Game",'s', false,true,true,30.86,12.99,7.99,"Enders Game.jpg","It's the End game");

		bkList[7] = new BookInfo("Interview with the Vampire",'h', true,true,false,34.86,23.99,5.99,"Interview with the Vampire.jpg","Interview with the Vampire.");

		bkList[8] = new BookInfo("It",'h', true,false,true,25.45,10.92,8.99,"it.jpg","Clown with balloon.");

		bkList[9] = new BookInfo("Jurassic Park",'s', false,false,false,24.86,23.99,44.99,"Jurassic Park.jpg","<html>Yes, it's the dinosaurs<br />with the fangs and a meat diet.</html>");
	
   
   
		bkList[10] = new BookInfo("Life of Pi",'a', true,true,true,34.86,23.99,9.99,"life of pi.jpg","Cooking adventure with pies.");
		bkList[11] = new BookInfo("Misery",'h', false,true,true,30.86,12.99,7.99,"misery.jpg","Author meets crazy fan.");

		bkList[12] = new BookInfo("Neuromancer",'s', true,true,false,34.86,23.99,5.99,"Neuromancer.jpg","Magic with Science");

		bkList[13] = new BookInfo("Ready Player One",'s', true,false,true,25.45,10.92,8.99,"Ready Player One.jpg","Nothing, just not ready.");

		bkList[14] = new BookInfo("Shane",'a', false,false,false,24.86,23.99,44.99,"shane.jpg","Yes, it's the guy on a horse.");

		bkList[15] = new BookInfo("Something Wicked this way comes",'h', true,true,true,34.86,23.99,9.99,"Something Wicked this way comes.jpg","It's called an exam.");
		bkList[16] = new BookInfo("Star Trek - Death in Winter",'s', false,true,true,30.86,12.99,7.99,"Star Trek - Death in Winter.jpg","Better than summer.");

		bkList[17] = new BookInfo("Star Trek - Mission to Horatius",'s', true,true,false,34.86,23.99,5.99,"Star Trek - Mission to Horatius.jpg","Classic action with Kirk and Spock.");

		bkList[18] = new BookInfo("Starship Troopers",'s', true,false,true,25.45,10.92,8.99,"Starship Troopers.jpg","Kill those bugs.");

		bkList[19] = new BookInfo("Stranger in a strange land",'s', false,false,false,24.86,23.99,44.99,"Stranger in a strange land.jpg","Yes, it's strange.");



      bkList[20] = new BookInfo("The Black Lyon",'r', true,true,true,34.86,23.99,9.99,"The Black Lyon.jpg","Less said the better.");
		bkList[21] = new BookInfo("The Count of Monte Cristo",'a', false,true,true,30.86,12.99,7.99,"The count of Monte Cristo.jpg","This is the other count.");

		bkList[22] = new BookInfo("The Day of the Duchess",'r', true,true,false,34.86,23.99,5.99,"The Day of the Duchess.jpg","Yes, it's that day");

		bkList[23] = new BookInfo("The Handmaid's Tale",'s', true,false,true,25.45,10.92,8.99,"The Hand maids Tale.jpg","And what a tale.");

		bkList[24] = new BookInfo("The Notebook",'r', false,false,false,24.86,23.99,44.99,"The Notebook.jpg","Yes, it's the guy with a notebook.");

		bkList[25] = new BookInfo("The Thirty-nine steps",'a', true,true,true,34.86,23.99,9.99,"The Thirty-nine steps.jpg","One step too many.");
		bkList[26] = new BookInfo("The Time Traveler's Wife",'r', false,true,true,30.86,12.99,7.99,"The Time travelers Wife.jpg","Doctor Who.");

		bkList[27] = new BookInfo("The Woman in Black",'h', true,true,false,34.86,23.99,5.99,"The Woman in Black.jpg","There was no other colour.");

		bkList[28] = new BookInfo("True Grit",'a', true,false,true,25.45,10.92,8.99,"true grit.jpg","Yes, it's true.");

		
     
  
  }


} 
