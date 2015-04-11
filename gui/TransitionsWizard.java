import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class TransitionsWizard extends JFrame {
	// Class Variables
	// private ArrayList<String> a;
	// private ArrayList<String> q;
	private AFDTable table;
	private JLabel label1;
	private JLabel label2;
	private String boxvalue;
	// private int boxindex;
	// private String lonelyState;
	private int i;
	private AFDNode currentNode;
	private int j;
	private boolean finished;
	// private Container currentFrame;
	// private JComboBox<String> box;
	
	public TransitionsWizard ( AFDTable t ) {
		this.table = t;
		this.i = 0;
		this.j = 0;
		this.finished = false;
		
		this.setTitle( "Welcome to Transitions Wizard" );
		this.setSize( 480, 640 );
		this.setLocationRelativeTo( null );
		this.setVisible( true );
		this.setResizable( false );
		
		buildFrame ();
	}
	
	public void buildFrame () {
		Container current = this.getContentPane();
		current.setLayout( new BorderLayout() );
		JPanel grid = new JPanel();
		grid.setLayout( new GridLayout( 3, 1, 10, 10 ) );
		current.add( grid , BorderLayout.CENTER );
		
		JPanel border1 = new JPanel();
		border1.setLayout( new BorderLayout() );
		JPanel border2 = new JPanel();
		border2.setLayout( new BorderLayout() );
		JPanel border3 = new JPanel();
		border3.setLayout( new BorderLayout() );
		
		grid.add( border1 );
		grid.add( border2 );
		grid.add( border3 );
		
		JLabel standingLabel = new JLabel( "If I'm currently at:  " );
		standingLabel.setFont( new Font ( "Arial", Font.BOLD + Font.ITALIC, 18 ) );
		JLabel readLabel = new JLabel( "And I read:  " );
		readLabel.setFont( new Font ( "Arial", Font.BOLD + Font.ITALIC, 18 ) );
		JLabel transitionLabel = new JLabel( "Where do I go?:  " );
		transitionLabel.setFont( new Font ( "Arial", Font.BOLD + Font.ITALIC, 18 ) );
		
		border1.add( standingLabel, BorderLayout.NORTH );
		border2.add( readLabel, BorderLayout.NORTH );
		border3.add( transitionLabel, BorderLayout.NORTH );
	
		JButton nextBtn = new JButton ( "Next!" );
		nextBtn.setHorizontalAlignment( SwingConstants.CENTER );
		nextBtn.setFont( new Font ( "Arial", Font.BOLD, 16 ) );
		nextBtn.setBackground( Color.BLUE );
		nextBtn.setForeground( Color.WHITE );
		border3.add( nextBtn, BorderLayout.SOUTH );
		this.label1 = new JLabel();
		// this.label1.setFont( new Font ( "Arial", Font.BOLD, 20 ) );
		// label1.setForeground( new Color ( 131, 189, 133 ) );
		// this.label1.setText( "Press Next button to" );
		label1.setFont( new Font ( "Arial", Font.BOLD, 38 ) );
		label1.setForeground( new Color ( 127, 127, 127 ) );
		label1.setBorder( new EmptyBorder( new Insets(0, 120, 0, 100 ) ) );
		label1.setText( this.table.get( i ).get( j ).getValue().toString() );
		this.label2 = new JLabel();
		// this.label2.setText( "START" );
		// this.label2.setFont( new Font ( "Arial", Font.BOLD, 24 ) );
		// label2.setForeground( new Color ( 131, 189, 133 ) );
		label2.setFont( new Font ( "Arial", Font.BOLD, 38 ) );
		label2.setForeground( new Color ( 127, 127, 127 ) );
		label2.setText( this.table.get( i ).get( j ).getReads().toString() );
		label2.setBorder( new EmptyBorder( new Insets(0, 120, 0, 100 ) ) );
		
		
		border1.add( Box.createHorizontalGlue(), BorderLayout.WEST );
		border1.add( label1, BorderLayout.CENTER );
		border2.add( Box.createHorizontalGlue(), BorderLayout.WEST );
		border2.add( label2, BorderLayout.CENTER );
		
		String[] array = new String [ this.table.getStates().size() ];
		int k = 0;
		for ( String single : this.table.getStates() ) {
			array[ k ] = single;
			k++;
		}
		k = 0;
		/*
		ArrayList<String> linked = new ArrayList<String>();
		linked = this.table.getStates();
		*/
		JPanel pane = new JPanel();
		pane.setLayout( new FlowLayout() );
		JComboBox<String> box = new JComboBox<String> ( array );
		box.setSelectedIndex( 0 );
		box.setBorder( new EmptyBorder( new Insets( 0 , 100, 0, 100 ) ) );
		pane.add( box );
		border3.add( pane, BorderLayout.CENTER );

		box.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boxvalue =String.valueOf( box.getSelectedItem() ); // It returns a String in this case.
				System.out.println( boxvalue );
				// boxindex = box.getSelectedIndex(); // It returns an integer.
				
			}
		} );
		/*
		AFDNode node = new AFDNode();
		ArrayList<AFDNode> col = new ArrayList<AFDNode>();
		for ( int i = 0; i < this.table.size() ; i++) {
			col = this.table.get( i );
			for ( int j = 0; j < col.size(); j++ ) {
				node = col.get( j );
				label1.setText( node.getValue().toString() );
				label2.setText( node.getReads().toString() );
				
			}
		}
		 */
		nextBtn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList <AFDNode> col = new ArrayList<AFDNode>();
				if ( ! finished ) {
					col = table.get( i );
					currentNode = col.get( j++ );
					label1.setText( currentNode.getValue() );
					label2.setText( currentNode.getReads() );
					currentNode.setDestination( boxvalue );
		
					if ( j == col.size() ) {
						j = 0;
						i++;
					}
					if ( i == table.size() ) {
						finished = true;
						close();
						table.printWholeTable();
					}
				}
			}
		} );
	}
	
	public boolean showStatement ( AFDTable t ) {
		
		if ( t.size() == 0 || t == null ) {
			System.out.println( "Wrong or no data loaded to the current Table." );
			return false;
		}
		else {

			// TODO como determinar cual es el q inicial. ¿Le pregunto al usuario?. Nuevo frame :S
			/*
			String word = this.table.getW();
			char[] array = word.toCharArray();
			String node;
			
			for ( char c :  array ) {
				if ( this.table. ) {
					
				}
			}
			// String w = table.;
			/*
			for (  ) {
				table
			}
			*/
			col = new;
			Node n = new;
			for ( int k = 0; k < array.length; k++ ) {
				for ( int i = 0; i < table.size(); i++ ) {
					col = table.get( i ); // Im getting the whole colum of ArrayLists.
					for ( int j = 0; j < col.size(); j++ ) {
						node = col.get( j ); // For traveling node by node.
						if ( node.getValue().equals() == SHALALALALA ) {
							
						}
						
					}
				}
			} // end of fors.
		}
		return false;
	}
	
	public void close () {
		this.setVisible( false );
	}
}