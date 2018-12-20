import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class BookUpdate implements ActionListener,ItemListener
{
	
	Container  UbaseCon;
	JComboBox  UbookNameCB, UbookTypeCB;
	JTextArea  USummaryTA,UfullListTA;

	JTextField  UepubPriceTF,UmobiPriceTF,UhardcopyPriceTF;
	JPanel UbookBasePan, UupperBookPan, UupperSummaryPan,
			UupperBasePan, UmiddleLeftPan,UmiddleRightPan,ULowerPan,middleBasePan;
	JScrollPane scrollPane;
	JButton updateAllBN;
	JFrame updateF;
	JCheckBox ePubC, mobiC,hardCopyC;
	JLabel UePubPriceJL, UmobiPriceJL, UhardCopyPriceJL;

	JMenuBar mb;
	JMenu booklistM;
	JMenuItem fullListMI,clearMI;
	
	String selectedBook,  selectedType,
				displayedComment,tempActionCommand;
	int selectedIndex;
	
	BookList myBookList;
	final String e = "ePub";
	final String m = "mobi";
	final String h = "Hard Copy";
	
	DecimalFormat twoDecimal;
	
	
	public BookUpdate(BookList inputList)
	{
		myBookList = inputList;
		
	}
	
	public void populateBookName() 
	{
		for (int i = 0; i < myBookList.bkList.length; i++) 
		{
			UbookNameCB.addItem(myBookList.bkList[i].getStrBookTitle());
		}
	}
	
	public void createUpdateScreen()
	{
		twoDecimal= new DecimalFormat("0.00");
		Font myFont = new Font("Arial", Font.ITALIC+Font.BOLD, 14);
		Font updateBNFont = new Font("Arial", Font.BOLD+Font.ITALIC,24);
		Font fullListFont = new Font("Helvetica", Font.BOLD + Font.ITALIC, 12);
		
		//upper panel////////////////////////////////////////////////////
		UbookNameCB = new JComboBox();
		UbookNameCB.addItemListener(this);
				
		
		UbookTypeCB = new JComboBox();
		UbookTypeCB.addItemListener(this);
		UbookTypeCB.addItem("Adventure");
		UbookTypeCB.addItem("Horror");
		UbookTypeCB.addItem("Romance");
		UbookTypeCB.addItem("Sci-Fi");
		
		UupperBookPan = new JPanel(new FlowLayout());
		UupperBookPan.setBorder(new TitledBorder("Current/(Change to) Book Type"));
		UupperBookPan.add(UbookTypeCB);
		
		
		USummaryTA= new JTextArea();
		USummaryTA.setBackground(Color.WHITE);
		USummaryTA.setLineWrap(true);
		
		UupperSummaryPan = new JPanel(new GridLayout(1, 1));
		UupperSummaryPan.setBorder(new TitledBorder("Add Story Summary"));
		UupperSummaryPan.add(USummaryTA);
		
		
		UbookBasePan = new JPanel();
		UbookBasePan.setLayout(new FlowLayout());
		UbookBasePan.add(UbookNameCB);
		
		
		
		UupperBasePan= new JPanel(new GridLayout(1, 3,5,5));
		
		UupperBasePan.add(UbookBasePan);
		UupperBasePan.add(UupperBookPan);
		UupperBasePan.add(UupperSummaryPan);
		
		//middle panel////////////////////////////////////////////////////
		
		ePubC = new JCheckBox(e);
		ePubC.setFont(myFont);
		ePubC.setActionCommand(e);
		
		mobiC =  new JCheckBox(m);
		mobiC.setFont(myFont);
		mobiC.setActionCommand(m);
		
		hardCopyC = new JCheckBox(h);
		hardCopyC.setFont(myFont);
		hardCopyC.setActionCommand(h);
	

		UmiddleLeftPan = new JPanel(new GridLayout(3, 2,2,2));
		UmiddleLeftPan.add(ePubC);
		UmiddleLeftPan.add(new JLabel());
		UmiddleLeftPan.add(mobiC);
		UmiddleLeftPan.add(new JLabel());
		UmiddleLeftPan.add(hardCopyC);
		UmiddleLeftPan.add(new JLabel());
		UmiddleLeftPan.setBorder(new TitledBorder("Book Formats Available"));
		
		UmiddleRightPan = new JPanel(new GridLayout(3, 2, 5,2));
		
		
		UePubPriceJL = new JLabel(e+" Price:");
		UePubPriceJL.setFont(myFont);
		UePubPriceJL.setHorizontalAlignment(JLabel.RIGHT);
		UmobiPriceJL =new JLabel(m+" Price:");
		UmobiPriceJL.setFont(myFont);
		UmobiPriceJL.setHorizontalAlignment(JLabel.RIGHT);
		UhardCopyPriceJL=new JLabel(h+" Price");
		UhardCopyPriceJL.setFont(myFont);
		UhardCopyPriceJL.setHorizontalAlignment(JLabel.RIGHT);
		
		UepubPriceTF = new JTextField();
		UepubPriceTF.setFont(myFont);
		UepubPriceTF.setBackground(Color.yellow);
		UepubPriceTF.addActionListener(this);
		
		UmobiPriceTF = new JTextField();
		UmobiPriceTF.setFont(myFont);
		UmobiPriceTF.setBackground(Color.green);
		UmobiPriceTF.addActionListener(this);
			
		UhardcopyPriceTF = new JTextField();
		UhardcopyPriceTF.setFont(myFont);
		UhardcopyPriceTF.setBackground(Color.white);
		UhardcopyPriceTF.addActionListener(this);
		
		
		UmiddleRightPan.add(UePubPriceJL);
		UmiddleRightPan.add(UepubPriceTF);
		UmiddleRightPan.add(UmobiPriceJL);
		UmiddleRightPan.add(UmobiPriceTF);
		UmiddleRightPan.add(UhardCopyPriceJL);
		UmiddleRightPan.add(UhardcopyPriceTF);
		
		UmiddleRightPan.setBorder(new TitledBorder("Price"));
		
		middleBasePan = new JPanel(new GridLayout(1, 2));
		middleBasePan.add(UmiddleLeftPan);
		middleBasePan.add(UmiddleRightPan);
		
		//lower panel////////////////////////////////////////////////////
		ULowerPan = new JPanel(new GridLayout(1, 2));
		updateAllBN = new JButton("Update ALL");
		updateAllBN.setFont(updateBNFont);
		updateAllBN.addActionListener(this);
		
		UfullListTA = new JTextArea();
		UfullListTA.setBackground(Color.orange);
		UfullListTA.setFont(fullListFont);
		scrollPane= new JScrollPane(UfullListTA);
		
			
		ULowerPan.add(updateAllBN);
		ULowerPan.add(scrollPane);
		
		
		//menubar////////////////////////////////////////////////////
		
		mb = new JMenuBar();
		booklistM = new JMenu("Book List");
	    booklistM.setMnemonic('b');
	    
	    fullListMI = new JMenuItem("Full List");
	    fullListMI.setMnemonic('f');
	    fullListMI.addActionListener(this);
	    
	    clearMI = new JMenuItem("Clear");
	    clearMI.setMnemonic('c');
	    clearMI.addActionListener(this);
	    
	    booklistM.add(fullListMI);
	    booklistM.add(clearMI);
	    
	    
	    mb.add(booklistM);
	    
	    
		
	    updateF = new JFrame("Book Update");
	    updateF.setLayout(new GridLayout(3, 1,5,5));
	    updateF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    updateF.setSize(750, 500);
	    updateF.setVisible(true);
		
	    updateF.add(UupperBasePan);
	    updateF.add(middleBasePan);
	    updateF.add(ULowerPan);
	    updateF. setJMenuBar(mb);
	    
	   populateBookName();
	}
	
	public void saveToType()
	{
		String temp =UbookTypeCB.getSelectedItem().toString();
		char first = Character.toLowerCase(temp.charAt(0));
		myBookList.bkList[selectedIndex].setChBookType(first);
	}
	public void saveToSummary()
	{
		myBookList.bkList[selectedIndex].setStrBookComment(USummaryTA.getText());;
	}
	
	public void saveToFormat()
	{
		boolean[] temp = new boolean[3];
		temp[0] = ePubC.isSelected();
		temp[1] = mobiC.isSelected();
		temp[2] = hardCopyC.isSelected();
		
		myBookList.bkList[selectedIndex].setBoolBookFormatAvail(temp);
	
	}
	
	public void saveToPrice()
	{
		double[] temp = new double[3];
		temp[0] = Double.parseDouble(UepubPriceTF.getText());
		temp[1]=Double.parseDouble(UmobiPriceTF.getText());
		temp[2]=Double.parseDouble(UhardcopyPriceTF.getText());	
		
		myBookList.bkList[selectedIndex].setDoubBookPrice(temp);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) //button, text, menu
	{
		if(e.getSource() instanceof JTextField)
		{
			
			if(e.getSource() == UepubPriceTF)
			{
				UepubPriceTF.setText(
						twoDecimal.format(Double.parseDouble(UepubPriceTF.getText()))
						);
			}else if (e.getSource() == UmobiPriceTF)
			{
				UmobiPriceTF.setText(
						twoDecimal.format(Double.parseDouble(UmobiPriceTF.getText()))
						);
			}else {
				UhardcopyPriceTF.setText(
						twoDecimal.format(Double.parseDouble(UhardcopyPriceTF.getText()))
						);
			}
		}else if (e.getSource() instanceof JButton)
		{
			saveToType();
			saveToSummary();
			saveToFormat();
			saveToPrice();
				
			MSG.confirmUpdate();
		}else if (e.getSource() instanceof JMenuItem)
		{
			if(e.getSource() == fullListMI)
			{
				getFullList();
			}else {
				UfullListTA.setText(null);
			}
		}
		
	}
	
	public void getFullList()
	{
		String temp=null;
			for (int i = 0; i < myBookList.bkList.length; i++) 
			{
				temp += myBookList.bkList[i].getStrBookTitle();
				
				for(int id =0;id<3;id++)
				{
					temp += " | ";
					if( id == 0 &&myBookList.bkList[i].getBoolBookFormatAvail()[id] ==true)
					{
						temp += e;
					}
					if (id == 1 &&myBookList.bkList[i].getBoolBookFormatAvail()[id] ==true)
					{
						temp +=m;
					}
					if ( id == 2 &&myBookList.bkList[i].getBoolBookFormatAvail()[id] ==true)
					{
						temp +=h;
					}
				}
				
				temp +=" | "+ myBookList.bkList[i].getChBookType() +"\r\n";
			
			}
		UfullListTA.setText(temp);
		
	}	
	
	
	public void getFromBookType(char input)
	{
		if(input == 'a')
		{
			UbookTypeCB.setSelectedIndex(0);
		}else 	if(input == 'h')
		{
			UbookTypeCB.setSelectedIndex(1);
		}else if (input == 'r')
		{
			UbookTypeCB.setSelectedIndex(2);
		}else {
			UbookTypeCB.setSelectedIndex(3);
		}
		
	}
	
	public void getFromBookFormat(boolean[] input)
	{
		ePubC.setSelected(input[0]);	
		mobiC.setSelected(input[1]);
		hardCopyC.setSelected(input[2]);
	}
	
	public void getFromPrices(double[] inputPrice)
	{
		UepubPriceTF.setText(String.valueOf(inputPrice[0]));
		UmobiPriceTF.setText(String.valueOf(inputPrice[1]));	
		UhardcopyPriceTF.setText(String.valueOf(inputPrice[2]));
	}

	private void populateEntireForm(int selectIndex) 
	{
	
		getFromBookType(myBookList.bkList[selectIndex].getChBookType());
		USummaryTA.setText(myBookList.bkList[selectIndex].getStrBookComment());
		getFromBookFormat(myBookList.bkList[selectIndex].getBoolBookFormatAvail());
		getFromPrices(myBookList.bkList[selectIndex].getDoubBookPrice());
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JComboBox)
		{
			if(e.getSource() == UbookNameCB)
			{
				selectedIndex=UbookNameCB.getSelectedIndex();
				populateEntireForm(selectedIndex);
			}
		}
	}
}












