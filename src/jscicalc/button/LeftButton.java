/** @file
 * Copyright (C) 2005 John D Lamb (J.D.Lamb@btinternet.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package jscicalc.button;
import jscicalc.CalculatorApplet;
import jscicalc.pobject.Left;

/**
 * Button to move left.
 *
 * @author J.&nbsp;D.&nbsp;Lamb
 * @version $Revision: 14 $
 */
public class LeftButton extends CalculatorButton {

    /**
     * Constructor. Sets PObject to Left.
     * @param applet The <em>controller</em> object.
     */
    public LeftButton( CalculatorApplet applet ){
	this.applet = applet;
	pobject = new Left();
 	//setText();
 	//setTextSize();
 	tooltip = pobject.tooltip();
 	setToolTipText();
	int size = applet.minSize();
	if( size < 3 ) size = 3;
	if( size > 9 ) size = 9;
	StringBuilder s = new StringBuilder( "/" );
	s.append( Integer.toString( size ) );
	s.append( "leftarrow.png" );
	java.io.InputStream inputStream =
	    getClass().getResourceAsStream( s.toString() );
	java.io.BufferedInputStream bufferedInputStream
	    = new java.io.BufferedInputStream( inputStream );
	byte[] buffer = new byte[4096];
	try {
	    bufferedInputStream.read( buffer, 0, 4096 );
	} catch( Exception e ){
	    System.err.println( "Failed to read image." );
	}
	java.awt.Image image
	    = java.awt.Toolkit.getDefaultToolkit().createImage( buffer );
	setIcon( new javax.swing.ImageIcon( image ) );
	addActionListener( this );
    }

    /**
     * Moves the caret position to the left (unless it&rsquo;s already at zero) and
     * updates DisplayLabel.
     * @param actionEvent The event that generated this method call: usually a button
     * press or called when CalculatorApplet responded to the key associated with
     * this button
     */
    public void actionPerformed( java.awt.event.ActionEvent actionEvent ){
	if( getApplet().getMode() != 0 )
	    return;
	getApplet().left();
	getApplet().updateDisplay( true, true );
	getApplet().requestFocusInWindow();
    }
    
    private static final long serialVersionUID = 1L;   
}
