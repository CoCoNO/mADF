import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Tarea2 extends JFrame {
	// Class variables.
	protected JLabel statusbar;
	protected ArrayList<String> alphabet;
	protected ArrayList<String> Q;
	// protected ArrayList<String> transitions;
	protected ArrayList<String> finalStates;
	protected String w;
	protected AFDTable table;
	protected boolean resolution;
	
	// Methods start here.
	public Tarea2 () { // This is the very basic set up for the frame.
		this.setTitle ( "Minimizador Automatas Finitos Deterministas" );
		this.setSize( 800, 720);
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setResizable( false );
		
		buildFrame (); // Useful for creating the GUI.
	}
	
	public void buildFrame () { // Here I create the main frame of the program. Part by part.
		Container current = this.getContentPane();
		current.setLayout( new BorderLayout() );
		JPanel grid = new JPanel();
		grid.setLayout( new GridLayout ( 6, 1, 5, 5 ) ); // rows, cols, horizontal gap, vertical gap.
		current.add( grid, BorderLayout.CENTER ); // At the center, obviously.
		
		JMenuBar bar = new JMenuBar();
		current.add( bar, BorderLayout.NORTH );
		JMenu fileMenu = new JMenu ( "File" );
		bar.add( fileMenu );
		
		ImageIcon closeIcon = new ImageIcon( "tarea2" + File.separator + "img" + File.separator + "close-icon.png" );
		JMenuItem closeItem = new JMenuItem( "Exit", closeIcon );
		fileMenu.add( closeItem );
		closeItem.setToolTipText( "Exit of the application" );
		
		closeItem.addActionListener( new ActionListener () {

			@Override
			public void actionPerformed( ActionEvent e ) {
				System.exit( 0 ); // Quit from the application.
			}
		} );
		
		bar.add( Box.createHorizontalGlue () ); // This forces the next element to stick to the right side of the bar.
		JMenu helpMenu = new JMenu( "Help" );
		helpMenu.setEnabled( false );
		bar.add( helpMenu );
		
		ImageIcon itesologo = new ImageIcon( "tarea2" + File.separator + "img" + File.separator + "iteso_full_logo.png" );
		// JLabel iteso = new JLabel( "ITESO  Libres para transformar." );
		this.statusbar = new JLabel( "Ready" );
		this.statusbar.setBorder( new EmptyBorder( new Insets ( 0, 5, 0, 0 ) ) ); // I have no idea what this line is used for. The only thing I know is I wrote it :S
		this.add( this.statusbar , BorderLayout.SOUTH );
		
		// Creating Panels for every row on grid.
		JPanel row1 = new JPanel();
		row1.setLayout( new BorderLayout() );
		JPanel row2 = new JPanel();
		row2.setLayout( new BorderLayout() );
		JPanel row3 = new JPanel();
		row3.setLayout( new BorderLayout() );
//		JPanel row4 = new JPanel();
//		row4.setLayout( new BorderLayout() );
		JPanel row5 = new JPanel();
		row5.setLayout( new BorderLayout() );
		JPanel row6 = new JPanel();
		row6.setLayout( new BorderLayout() );
		
		grid.add( row1 );
		grid.add( row2 );
		grid.add( row3 );
//		grid.add( row4 );
		grid.add( row5 );
		grid.add( row6 );
		
//		JLabel iteso = new JLabel( itesologo );
//		row1.add( iteso, BorderLayout.WEST );
//		row1.setBackground( new Color ( 90, 90, 90 ) );
//		JLabel author = new JLabel( "Alejandro Ruiz Mendoza - is684522" );
//		author.setFont( new Font ( "TimeRoman", Font.BOLD + Font.ITALIC, 18 ) );
//		author.setForeground( Color.BLUE );
//		author.setHorizontalAlignment( SwingConstants.CENTER );
//		author.setBorder( BorderFactory.createEmptyBorder(0, 0, 0, 10) );
//		row1.add( author, BorderLayout.EAST );
		
		// Preparing all the other rows (The data rows).
		// Fonts for everybody!
		
		JLabel label1 = new JLabel( "Input the alphabet's symbols:" ); 
		label1.setFont( new Font ( "Courier New", Font.BOLD + Font.ITALIC, 12 ) );
		label1.setToolTipText( "Example: a, b, c, d, e, f" );
		JLabel label2 = new JLabel( "Input all the Q states:" ); 
		label2.setFont( new Font ( "Courier New", Font.BOLD + Font.ITALIC, 12 ) );
		label2.setToolTipText( "Example: q0, q1, q2, q3, q4, q5" );
		JLabel label3 = new JLabel( "Input all final states included in F:" ); 
		label3.setFont( new Font ( "Courier New", Font.BOLD + Font.ITALIC, 12 ) );
		label3.setToolTipText( "Example: q0, q1" );
//		JLabel label4 = new JLabel( "Input the String you want to validate:" ); 
//		label4.setFont( new Font ( "Courier New", Font.BOLD + Font.ITALIC, 12 ) );
//		label4.setToolTipText( "Example: abbbadffac" );
		
		// Adding the just-created labels to every single row on my grid.
		row2.add( label1, BorderLayout.NORTH );
		row3.add( label2, BorderLayout.NORTH );
		row4.add( label3, BorderLayout.NORTH );
//		row5.add( label4, BorderLayout.NORTH );
		
		// Creating the text field in which the user will input the data:
		JTextField alphabetField = new JTextField();
		alphabetField.setColumns( 64 );
		alphabetField.setToolTipText( "Example: a, b, c, d, e, f" );
		JTextField statesField = new JTextField();
		statesField.setColumns( 64 );
		statesField.setToolTipText( "Example: q0, q1, q2, q3, q4, q5" );
		JTextField finalField = new JTextField();
		finalField.setColumns( 64 );
		finalField.setToolTipText( "Example: q0, q1" );
//		JTextField stringField = new JTextField();
//		stringField.setColumns( 64 );
//		stringField.setToolTipText( "Example: abbbadffac" );
		
		// This is a programming trick. :B
		JPanel flow1 = new JPanel();
		flow1.setLayout( new FlowLayout() );
		JPanel flow2 = new JPanel();
		flow1.setLayout( new FlowLayout() );
		JPanel flow3 = new JPanel();
		flow1.setLayout( new FlowLayout() );
//		JPanel flow4 = new JPanel();
//		flow1.setLayout( new FlowLayout() );
		// Adding my new flow layouts to the grid.
		row2.add( flow1, BorderLayout.WEST );
		row3.add( flow2, BorderLayout.WEST );
//		row4.add( flow3, BorderLayout.WEST );
//		row5.add( flow4, BorderLayout.WEST );
		
		// Adding the text fields to the flow layouts.
		flow1.add( alphabetField );
		flow2.add( statesField );
		flow3.add( finalField );
//		flow4.add( stringField );
		// Some buttons so the user can input his/her information.
		JButton button1 = new JButton("Input");
		JButton button2 = new JButton("Input");
		JButton button3 = new JButton("Input");
//		JButton button4 = new JButton("Input");
		// Adding buttons to panel.
		flow1.add(button1);
		flow2.add(button2);
		flow3.add(button3);
//		flow4.add(button4);

		// Adding the events so the buttons on frame will trigger some tasks.
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String stringAlphabet = removeAllWhiteSpaces( alphabetField.getText() );
				alphabet = explode ( stringAlphabet, "," );
			}
		} );

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String stringQ = removeAllWhiteSpaces( statesField.getText() );
				Q = explode ( stringQ, "," );
			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String stringFinal = removeAllWhiteSpaces( finalField.getText() );
				finalStates = explode ( stringFinal, "," );
				
				if ( Q == null || Q.isEmpty() || finalStates == null || finalStates.isEmpty() || w == null || w.length() == 0 || table == null ) {
					for ( int i = 0; i < finalStates.size(); i++ ) {
						
						
						if( ! Q.contains( finalStates.get( i ) ) ) {
							finalStates = null;
							JOptionPane.showMessageDialog( null,
								    "Some final States are not include on Q.\nDeleting final states data...\nTry again please.",
								    "Wrong data inputted !",
								    JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					for ( int i = 0; i < finalStates.size(); i++ ) {
						for ( int j = i + 1; j < finalStates.size(); j++ ) {
							if ( finalStates.get( i ).equals( finalStates.get( j ) ) ) {
								finalStates = null;
								JOptionPane.showMessageDialog( null,
									    "There are repeated final States.\nDeleting final states data...\nMake sure every final state is different.",
									    "Wrong data inputted !",
									    JOptionPane.ERROR_MESSAGE);
								break;
							}
						}
				}
				
				
				}
			}
		} );

//		button4.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				w = removeAllWhiteSpaces( stringField.getText() );
//				
//				char[] array = w.toCharArray();
//				for ( char c : array ) {
//					if ( ! alphabet.contains( Character.toString( c ) ) ) {
//						w = null;
//						JOptionPane.showMessageDialog( null,
//							    "Some elements on your string are not included on the alphabet.\nDeleting inputted string...\nMake sure all your string symbols are included on alphabet.",
//							    "Wrong data inputted !",
//							    JOptionPane.ERROR_MESSAGE);
//						break;
//					} 
//				}	
//				startTheAction ();
//				table.createTableHeader();
//				table.addingCells();
//			}
//		} );
		// row6.setBackground( Color.BLACK );
		
		// THIS IS ALL ABOUT THE LAST ROW:
		JLabel transitionLabel = new JLabel( "We're gonna spend some time adding transtions:" );
		transitionLabel.setFont( new Font ( "Courier New", Font.BOLD + Font.ITALIC, 12 ) );
		JButton button5 = new JButton( "Transitions..." ); 
		row6.add( transitionLabel , BorderLayout.NORTH);
		row6.add( button5, BorderLayout.WEST );
		JButton actionBtn = new JButton( "LAUNCH!" );
		actionBtn.setBackground( Color.RED );
		actionBtn.setForeground( Color.WHITE );
		actionBtn.setFont( new Font ( "Arial", Font.BOLD, 30 ) );
		row6.add( actionBtn, BorderLayout.EAST );
		
		button5.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				// TransitionsWizard wizar = new TransitionsWizard( alphabet, Q );
				
				if ( Q == null || Q.isEmpty() || alphabet == null || alphabet.isEmpty() || w == null || finalStates == null || finalStates.isEmpty() ) {
					statusbar.setText( "There's some data missing. Fix that before proceeding..." );
				}
				else {
					TransitionsWizard wizard = new TransitionsWizard( table );
					statusbar.setText( "Ready" );
					wizard.setVisible( true ); // Build GUI. Doesn nothing yet.
				}
			}
		} );
		
		actionBtn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO SHOWTIME!!
				
				if (  Q == null || Q.isEmpty() || alphabet == null || alphabet.isEmpty() || w == null || finalStates == null || finalStates.isEmpty() )
					statusbar.setText(  "Data Missing !" );
				else {
					TransitionsWizard wizard = new TransitionsWizard( table );
					table.setW( w );
					wizard.showStatement( table );
					table.setW( w );
				}
			}
		} );
		
	}
	
	// This is used just like explode on PHP. It separates a string into substrings via providing it with the separator.
	protected ArrayList<String> explode( String input, String separator ) { // I receive a single string, with the content separated by a String separator (i.e. ",", " " ...)
		ArrayList<String> linked = new ArrayList<String>();
		String[] slices = input.trim().split( separator );
		
		for ( String single : slices ) {
			linked.add( single );
		}
		return linked;
	}
	
	// Remove all whitespace characters.
	static String removeAllWhiteSpaces(String value) {
		return value.replaceAll("\\s", "");
	}
	
	public void startTheAction () {
		this.table = new AFDTable( this.alphabet , this.Q );
		this.table.setW( this.w );
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater( new Runnable () {
			@Override
			public void run () {
				Tarea2 tarea = new Tarea2();
				tarea.setVisible( true );
			}
		} );
	}
}
