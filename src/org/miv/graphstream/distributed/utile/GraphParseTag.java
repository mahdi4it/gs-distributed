/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.miv.graphstream.distributed.utile;

public class GraphParseTag {


	// Fields

	private String elementId ;
	private String graphId ;
	private boolean isValidString ;


	// Constructors

	public GraphParseTag() {
	}

	public GraphParseTag(String value) {
		this.parse(value);
	}


	// Modifiers

	// Parse a string
	public GraphParseTag parse(String value) {
		String[] res = value.split("/") ;
		if(res.length > 1) {
			this.isValidString = true ;
			this.graphId = res[0];
			this.elementId = res[1];
		}
		else {
			this.isValidString = false ;
			this.graphId = "";
			this.elementId = value;
		}
		return this ;
	}


	// Accessors

	// evaluate if the string is parseable or not and return a boolean
	public boolean isValidString() {
		return this.isValidString ;
	}

	// return the id of the graph
	public String getGraphId() {
		return graphId ;
	}

	// return the id of the element
	public String getElementId() {
		return this.elementId ;
	}


}