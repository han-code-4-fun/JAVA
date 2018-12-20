	import java.awt.*;
	import java.awt.event.*;
import java.io.NotActiveException;
import java.text.DecimalFormat;

import javax.annotation.processing.RoundEnvironment;
import javax.swing.*;
	import java.util.*;
	import javax.swing.event.*;  // for the ListSelectionListener required by JList



import javax.swing.border.*;
	
public class BookBuy  extends JFrame implements ActionListener, 
											ItemListener,ListSelectionListener, MouseListener
{
		final private String password= "5555";
		private String enteredPasswd;
		Vector bookVT, selectedBookVT, selectedBookPrice;
		Container baseCon, UbaseCon;
		JComboBox bookTypeCB, orderNumCB, UbookCB, UbookType;
		JTextArea  UaddSummaryTA,UlowerTA;
		JPasswordField passwdPF;
		JTextField  totalPriceTF,creditCardTF,
							UepubPriceTF,UmobiPriceTF,UhardcopyPriceTF;
		JPanel upperBasePan, middleBasePan, lowerBasePan,bookBasePan,
				middleLeftPan,lowerLeftPan,lowerMiddlePan,lowerRightPan, 
				passwdPan, enterResetPan,upperBookPan, upperSummaryPan,
				UbookBasePan, UupperBookPan, UupperSummaryPan,
				creditCardLeftPan,creditCardRightPan,creditCardBasePan,
				UupperBasePan, UmiddleLeftPan,UmiddleRightPan,ULowerPan;
		JFrame mainAppF, updateF;
		JButton middleRightBN,enterBN, resetBN,clearBN,
						clearAllBN,submitBN,updateAllBN;
		JButton passwdBN[];
		ButtonGroup leftBG;
		JRadioButton ePub,mobi,hardCopy;
		JCheckBox ePubC, mobiC,hardCopyC;
		JLabel summaryJL, keyPadJL, creditCardJL, UePubPriceJL, 
			UmobiPriceJL, UhardCopyPriceJL;
		ImageIcon buy, coverImage;
		JList bookSelectedL, bookL;
		JScrollPane bookScroll, bookSelectScroll;
		JMenuBar mb;
		JMenu booklistM;
		JMenuItem fullListMI,clearMI;
		
		String selectedBook,  selectedType,
					displayedComment,tempActionCommand;
		double totalPrice;
		final String totalP = "Total: $";
		
		final String e = "ePub";
		final String m = "mobi";
		final String h = "Hard Copy";
		final char dollor = '$';
		double prices[];
		
		BookList mybooks;
		Font myFont ;
		boolean bookFormat[];
		DecimalFormat twoDecimal;
		
		public void setDefaultPriceText()
		{
			ePub.setText(e);
			mobi.setText(m);
			hardCopy.setText(h);
		}
		
		public void createScreen()
		{
			enteredPasswd = "";
			selectedBookVT = new Vector();
			selectedBookPrice = new Vector();
			myFont = new Font("Arial", Font.ITALIC+Font.BOLD, 14);
			 twoDecimal= new DecimalFormat("#.00");
			//upper panel////////////////////////////////////////////////////
			
			bookTypeCB = new JComboBox();
			bookTypeCB.addItem("Please Select type of Book");
			bookTypeCB.addItem("All Types");
			bookTypeCB.addItem("Adventure");
			bookTypeCB.addItem("Horror");
			bookTypeCB.addItem("Romance");
			bookTypeCB.addItem("Sci-Fi");
			
			bookTypeCB.addItemListener(this);
			
			bookL = new JList();
			bookL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			bookL.setFont(myFont);
			
			bookL.addListSelectionListener(this);
			
			//scroll panel ////////////////////////////////////////////////////
			bookScroll = new JScrollPane(bookL);
		
			upperBookPan = new JPanel(new GridLayout(1, 1));
			upperBookPan.setBorder(new TitledBorder("Book Titles Available"));
			upperBookPan.add(bookScroll);
			
			summaryJL= new JLabel();
			summaryJL.setOpaque(true);
			summaryJL.setBackground(Color.YELLOW);
			summaryJL.addMouseListener(this);
			summaryJL.setFont(myFont);
			
			
			upperSummaryPan = new JPanel(new GridLayout(1, 1));
			upperSummaryPan.setBorder(new TitledBorder("Cover/Story Summary"));
			upperSummaryPan.add(summaryJL);
			
			
			bookBasePan = new JPanel();
			bookBasePan.setLayout(new FlowLayout());
			bookBasePan.add(bookTypeCB);
			bookBasePan.setSize(200,200);
			
			
			upperBasePan= new JPanel(new GridLayout(1, 3,5,5));
			
			upperBasePan.add(bookBasePan);
			upperBasePan.add(upperBookPan);
			upperBasePan.add(upperSummaryPan);
			
			
			//middle panel//////////////////////////////////////////////////////
			
			ePub = new JRadioButton(e);
			ePub.setFont(myFont);
			ePub.addItemListener(this);
			ePub.setActionCommand(e);
			
			mobi = new JRadioButton(m);
			mobi.setFont(myFont);
			mobi.addItemListener(this);
			mobi.setActionCommand(m);
			
			hardCopy = new JRadioButton(h);
			hardCopy.setFont(myFont);
			hardCopy.addItemListener(this);
			hardCopy.setActionCommand(h);
			
			setDefaultPriceText();
			
			leftBG = new ButtonGroup();
			leftBG.add(ePub);
			leftBG.add(mobi);
			leftBG.add(hardCopy);
				
			orderNumCB = new JComboBox();
			orderNumCB.addItem("1 copy(ies)");
			orderNumCB.addItem("2 copy(ies)");
			orderNumCB.addItem("3 copy(ies)");
			orderNumCB.addItem("4 copy(ies)");
			orderNumCB.addItem("5 copy(ies)");
			orderNumCB.setEnabled(false);
			
			middleLeftPan = new JPanel(new GridLayout(3, 2,2,2));
			middleLeftPan.add(ePub);
			middleLeftPan.add(new JLabel());
			middleLeftPan.add(mobi);
			middleLeftPan.add(new JLabel());
			middleLeftPan.add(hardCopy);
			middleLeftPan.add(orderNumCB);
			middleLeftPan.setBorder(new TitledBorder("Format/Prices"));
			
			buy = new ImageIcon("picture/buyLogo1.GIF");
			middleRightBN = new JButton(buy);
			middleRightBN.addActionListener(this);
			
			middleBasePan = new JPanel(new GridLayout(1, 2));
			middleBasePan.add(middleLeftPan);
			middleBasePan.add(middleRightBN);
			
			//lower panel////////////////////////////////////////////////////
			
			
			//lowerleft////////////////////////////////////////////////////
			keyPadJL = new JLabel("Use Keypad to enter password for settings");
			
			passwdPan = new JPanel(new GridLayout(2, 5,2,2));
			
			passwdBN= new JButton[10];
			for (int i = 0; i< 10;i++)
			{
				passwdBN[i]= new JButton(String.valueOf(i));
				passwdBN[i].addActionListener(this);
				passwdPan.add(passwdBN[i]);
			}
			
			
			
			enterResetPan = new JPanel(new GridLayout(1, 2,2,2));
			enterBN = new JButton("Enter");
			enterBN.addActionListener(this);
			
			resetBN = new JButton("Reset");
			resetBN.addActionListener(this);
			
			enterResetPan.add(enterBN);
			enterResetPan.add(resetBN);
			
			
			passwdPF = new JPasswordField();
			passwdPF.setEchoChar('#');
			passwdPF.setEditable(false);
			
			
			lowerLeftPan = new JPanel(new GridLayout(4, 1, 3, 3));
			lowerLeftPan.add(keyPadJL);
			lowerLeftPan.add(passwdPan);
			lowerLeftPan.add(enterResetPan);
			lowerLeftPan.add(passwdPF);
			lowerLeftPan.setBorder(new TitledBorder("For Employee use ONLY"));
			lowerLeftPan.setBackground(Color.red);
			
			//lower middle////////////////////////////////////////////////////
			bookSelectedL = new JList();
			bookSelectedL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			bookSelectScroll = new JScrollPane(bookSelectedL);

			lowerMiddlePan = new JPanel(new GridLayout(1, 1));
			lowerMiddlePan.add(bookSelectScroll);
			lowerMiddlePan.setBorder(new TitledBorder("Your Selection"));
			
			//lower right////////////////////////////////////////////////////
			lowerRightPan = new JPanel(new GridLayout(5,1,5,5));
			
			clearBN = new JButton("Clear");
			clearBN.setFont(myFont);
			clearBN.addActionListener(this);
			
			clearAllBN =new JButton("Clear All");
			clearAllBN.setFont(myFont);
			clearAllBN.addActionListener(this);
			
			totalPriceTF = new JTextField(totalP);
			totalPriceTF.setBackground(Color.cyan);
			totalPriceTF.setFont(myFont);
			
			creditCardJL = new JLabel("Enter Credit Card#:");
			creditCardTF = new JTextField();
			
			creditCardLeftPan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			creditCardLeftPan.add(creditCardJL);
			creditCardLeftPan.add(new JLabel());
			
			creditCardRightPan = new JPanel(new GridLayout(1, 1));
			creditCardRightPan.add(creditCardTF);
		
			creditCardBasePan= new JPanel(new GridLayout(1, 2));
			creditCardBasePan.add(creditCardLeftPan);
			creditCardBasePan.add(creditCardRightPan);
			
			submitBN = new JButton("Submit");
			submitBN.setFont(myFont);
			submitBN.addActionListener(this);
			
			lowerRightPan.add(clearBN);
			lowerRightPan.add(clearAllBN);
			lowerRightPan.add(totalPriceTF);
			lowerRightPan.add(creditCardBasePan);
			lowerRightPan.add(submitBN);
			
			
			
			lowerBasePan = new JPanel(new GridLayout(1, 3, 5, 5));
			lowerBasePan.add(lowerLeftPan);
			lowerBasePan.add(lowerMiddlePan);
			lowerBasePan.add(lowerRightPan);
			
			//add all panel into base panel
			mainAppF = new JFrame("Han Zhou Book Buy App");
			mainAppF.setLayout(new GridLayout(3,1,5,5));
			mainAppF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainAppF.setSize(900, 500);
			mainAppF.setVisible(true);
			
			mainAppF.add(upperBasePan);
			mainAppF.add(middleBasePan);
			mainAppF.add(lowerBasePan);
			
			
			mybooks = new BookList();
			mybooks.createList();
		}
		public static boolean isInteger(String s) {
			   
		    for(int i = 0; i < s.length(); i++) {
		    	if(s.charAt(i)<'0' || s.charAt(i)>'9')
		    	{	
		    		return false;
	    		}
		    }
		    return true;
		}
		
		public void fillBookContent(String selectTerm)
		{
			
			
			bookVT = new Vector<>();
			switch(selectTerm)
			{
					case "All Types":
							
							for(int i=0; i< mybooks.bkList.length;i++)
							{
								bookVT.addElement(mybooks.bkList[i].getStrBookTitle());
							}
					break;
					case "Adventure":
							
							for(int i=0; i< mybooks.bkList.length;i++)
							{
								if(mybooks.bkList[i].getChBookType() == 'a')
									bookVT.addElement(mybooks.bkList[i].getStrBookTitle());
							}
					break;
					case "Horror":
							for(int i=0; i< mybooks.bkList.length;i++)
							{
								if(mybooks.bkList[i].getChBookType() == 'h')
									bookVT.addElement(mybooks.bkList[i].getStrBookTitle());
							}
					break;
					case "Romance":
							for(int i=0; i< mybooks.bkList.length;i++)
							{
								if(mybooks.bkList[i].getChBookType() == 'r')
									bookVT.addElement(mybooks.bkList[i].getStrBookTitle());
							}
					break;
					case "Sci-Fi":
							for(int i=0; i< mybooks.bkList.length;i++)
							{
								if(mybooks.bkList[i].getChBookType() == 's')
									bookVT.addElement(mybooks.bkList[i].getStrBookTitle());
							}
					break;
					case "Please Select type of Book":
							
						emptyBookandFormat();
					break;
					
			}
			
					
			
	
			
		}
		
		public void emptyBookandFormat()
		{
			if(bookVT.isEmpty()==false)
			{
				bookVT.removeAllElements();
				
			}
			bookL.clearSelection();
			bookL.setListData(bookVT);
			
			setDefaultPriceText();
		}
		
		
		
		public void itemStateChanged(ItemEvent event)
		{
			if(event.getSource() instanceof JComboBox)
			{
				if(event.getSource() == bookTypeCB)
				{
					selectedType = bookTypeCB.getSelectedItem().toString();
					
					fillBookContent(selectedType);
					bookL.removeAll();
					bookL.setListData(bookVT);
				}
				
			}else if(event.getSource() instanceof JRadioButton)
			{
				if(event.getSource() == hardCopy)
				{
					if(hardCopy.isSelected())
					{
						orderNumCB.setEnabled(true);
					}else {
						orderNumCB.setEnabled(false);
					}
				}
			}
			
		}
		
		public String searchBookCover(String bookName)
		{
			String output;
			for (int i = 0; i < mybooks.bkList.length; i++) {
				if(bookName.equals(mybooks.bkList[i].getStrBookTitle()))
					return mybooks.bkList[i].getStrBookCover();
			}
			return "n/a";
		}
		
		public String searchBookComment(String bookName)
		{
			String output;
			for (int i = 0; i < mybooks.bkList.length; i++) {
				if(bookName.equals(mybooks.bkList[i].getStrBookTitle()))
					return mybooks.bkList[i].getStrBookComment();
			}
			return "n/a";
		}
		
		public void configureRadioButton(String bookName)
		{
			for (int i = 0; i < mybooks.bkList.length; i++) {
				if(bookName.equals(mybooks.bkList[i].getStrBookTitle()))
				{
					 bookFormat=mybooks.bkList[i].getBoolBookFormatAvail();
					 prices = mybooks.bkList[i].getDoubBookPrice();
					 
					 ePub.setEnabled(bookFormat[0]);
					 ePub.setText(e+" "+ dollor+prices[0]);
					 
					 
					 mobi.setEnabled(bookFormat[1]);
					 mobi.setText(m+" "+dollor+prices[1]);
					 
					 hardCopy.setEnabled(bookFormat[2]);
					 hardCopy.setText(h+" "+ dollor+prices[2]);
					 if(bookFormat[0] == true)
					 {
						 leftBG.setSelected(ePub.getModel(), true);
					 }else if(bookFormat[1] == true)
					 {
						 leftBG.setSelected(mobi.getModel(), true);
					 }else if (bookFormat[2] == true)
					 {
						 leftBG.setSelected(hardCopy.getModel(), true);
					 }
					 
					 
				}
			}
		}
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
				if(arg0.getSource() instanceof JList)
				{
					if(arg0.getSource() == bookL)
					{
						if(bookL.getSelectedIndex() != -1)
						{
							 selectedBook=bookL.getSelectedValue().toString();
							 
							 //coverImage = new ImageIcon(new ImageIcon("picture/"+searchBookCover(selectedBook))
								//	 .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
							 coverImage = new ImageIcon("picture/"+searchBookCover(selectedBook));
							 
							 summaryJL.setIcon(coverImage);		
							 summaryJL.setVerticalAlignment(JLabel.CENTER);
							 summaryJL.setHorizontalAlignment(JLabel.CENTER);
							 
							 configureRadioButton(selectedBook);
							
						}
					
					}
				}
			
		}

		
		public void buyHandling(ActionEvent e) throws NoFormatErrorHandling
		{
			tempActionCommand=leftBG.getSelection().getActionCommand();
			
			
			if(ePub.isEnabled()== false && mobi.isEnabled()== false && hardCopy.isEnabled()==false)
			{
				throw new NoFormatErrorHandling();
			}
			
			bookSelectedL.setListData(selectedBookVT);
			
			switch(tempActionCommand)
			{
				case "ePub":
					totalPrice +=prices[0];
					selectedBookPrice.addElement(prices[0]);
				break;
				case "mobi":
					totalPrice +=prices[1];
					selectedBookPrice.addElement(prices[1]);
				break;
				case "Hard Copy":
					if(orderNumCB.isEnabled())
					{
						totalPrice +=(prices[2]*(1+orderNumCB.getSelectedIndex()));	
						selectedBookPrice.addElement(prices[2]*(1+orderNumCB.getSelectedIndex()));
					}
				break;
			}
			if(orderNumCB.isEnabled())
			{
				selectedBookVT.addElement(selectedBook+" ("+
						(1+orderNumCB.getSelectedIndex())+
						") (for "+tempActionCommand+")");
			}else
			{
				selectedBookVT.addElement(selectedBook+" (for "+tempActionCommand+")");
			}
			
			updatePrice();
		}
	
		public void updatePrice()
		{
			totalPriceTF.setText(totalP+twoDecimal.format(totalPrice));
		}
		public void emptyPrice()
		{
			totalPriceTF.setText(totalP+"0.00");
			totalPrice = 0;
			selectedBookPrice.removeAllElements();
		}
		
		public void emptySelection()
		{
			selectedBookVT.removeAllElements();
			bookSelectedL.setListData(selectedBookVT);
		}
	
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if(e.getSource() instanceof JButton)
			{
				if(e.getSource() == enterBN)
				{
					if(enteredPasswd.equals(password))
					{
						ePub.setEnabled(false);
						mobi.setEnabled(false);
						hardCopy.setEnabled(false);
						bookTypeCB.setSelectedIndex(0);
						if(bookL.getSelectedIndex()!= -1)
						{
							emptyBookandFormat();	
						}						
						BookUpdate myUpdate = new BookUpdate( mybooks);
						myUpdate.createUpdateScreen();
					}else {
						MSG.wrongPasswd();
					}
					
				}else if (e.getSource() == middleRightBN)
				{
					try
					{
						buyHandling(e);
						
					}catch (NullPointerException err) 
					{
						MSG.noTitleSelect();
						
					}catch(NoFormatErrorHandling err2)
					{
						MSG.noFormat();
					}
					
				}else if (e.getSource() == submitBN)
				{
					int response = 0;
					if (creditCardTF.getText().length() != 16 ||
							isInteger(creditCardTF.getText())== false )
					{
						MSG.wrongCreditCard();
					}else {
						response = MSG.lastConfirmationbeforeBuy();
					}
					if(response == JOptionPane.YES_OPTION)
					{
						if(selectedBookVT.isEmpty())
						{

							MSG.noBookSelect();
						}else {
							
							emptySelection();

							MSG.purchase(twoDecimal,totalPrice);
							emptyPrice();
						}
						
						
					}
				}else if(e.getSource() == clearBN)
				{
					if(bookSelectedL.getSelectedIndex()!= -1)
					{
						totalPrice  = totalPrice  - (double)selectedBookPrice.get(bookSelectedL.getSelectedIndex());
						selectedBookVT.remove(bookSelectedL.getSelectedIndex());
						selectedBookPrice.remove(bookSelectedL.getSelectedIndex());
						bookSelectedL.setListData(selectedBookVT);
						updatePrice();
					}else
					{
						MSG.noBookSelect();
					}

				}else if (e.getSource() == clearAllBN)
				{
					int res = 0;

					res= MSG.confirmPurchase();
					if(res == JOptionPane.YES_OPTION)
					{
						emptySelection();
						emptyPrice();
					}
				}else if(e.getSource() == resetBN)
				{
					enteredPasswd = "";
					passwdPF.setText(null);
				}else 
				{
					
					enteredPasswd +=e.getActionCommand();
					passwdPF.setText(enteredPasswd);
				}
				
			}
		}

		
		
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource() instanceof JLabel)
			{
				if(arg0.getSource() == summaryJL)
				{
					if(bookL.getSelectedIndex() != -1)
					{
						 selectedBook=bookL.getSelectedValue().toString();
						 displayedComment = searchBookComment(selectedBook);
						 summaryJL.setIcon(null);
						 summaryJL.setText(displayedComment);
						 summaryJL.setVerticalAlignment(JLabel.TOP);
						 summaryJL.setHorizontalAlignment(JLabel.LEFT);
					}
					
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
			if(arg0.getSource() instanceof JLabel)
			{
				if(arg0.getSource() == summaryJL)
				{
					if(bookL.getSelectedIndex() != -1)
					{
						
						 summaryJL.setIcon(coverImage);		
						 summaryJL.setText("");
						 summaryJL.setVerticalAlignment(JLabel.CENTER);
						 summaryJL.setHorizontalAlignment(JLabel.CENTER);
					}
					
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


	
		public static void main(String[] args) 
		{	
			BookBuy myBook = new BookBuy();
			
			myBook.createScreen();

		}

		

		public class NoFormatErrorHandling  extends Exception
		{

		}
		
	
}

