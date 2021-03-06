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

package jscicalc;
import jscicalc.pobject.*;

/**
 * CalculatorPanel that handse boolean functions (actually just removes some
 * functions)
 * Replaces ShiftPanel if CalculatorApplet base is not Base.DECIMAL.
 *
 * @author J.&nbsp;D.&nbsp;Lamb 
 * @version $Revision: 14 $
 */
public class ShiftHexPanel extends CalculatorPanel {
    /**
     * Constructor. See CalculatorPanel.createCalculatorPanel() to see what
     * this does.
     * @param applet The CalculatorApplet object needed for the buttons and
     * DisplayPanel
     * @param sbt Used to identify what to construct
     * @param colour What colour should the panel background be?
     */
    public ShiftHexPanel( CalculatorApplet applet, SpecialButtonType sbt,
			  java.awt.Color colour ){
	super( applet, sbt, colour );
	if( sbt != SpecialButtonType.SHIFT_HEX )
	    throw new RuntimeException( "ShiftHexPanel instantiated wrongly." );
	base( Base.HEXADECIMAL );
    }

    /**
     * Defines all the standard buttons for this panel. This is where
     * you add new functions or change which button is associated with each
     * function.
     */
    protected void setButtons(){
	buttons().elementAt( 24 ).setPObject( new Pi() );
	buttons().elementAt( 13 ).setPObject( new Root() );
	createKeyMap();
    }

    private static final long serialVersionUID = 1L;   
}
