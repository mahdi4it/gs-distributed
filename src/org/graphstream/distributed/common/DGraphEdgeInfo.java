package org.graphstream.distributed.common;

import java.util.HashMap;


public class DGraphEdgeInfo {

	private String graphId1 ;
	private String graphTag1 ;
	private String graphId2 ;
	private String graphTag2 ;
	
	private HashMap<String,String> data ;

	/**
	 *
	 * @param from
	 * @param to
	 */
	public DGraphEdgeInfo(String from, String to) {
		DGraphParseTag pFrom = new DGraphParseTag(from) ;
		DGraphParseTag pTo = new DGraphParseTag(to) ;
		this.graphId1 = pFrom.getElementId() ;
		this.graphId2 = pTo.getElementId() ;
		this.graphTag1 = pFrom.getGraphId() ;
		this.graphTag2 = pTo.getGraphId();
	}

	public DGraphEdgeInfo() {
	}

	public void setEdgeInfo(String from, String to) {
		DGraphParseTag pFrom = new DGraphParseTag(from) ;
		DGraphParseTag pTo = new DGraphParseTag(to) ;
		this.graphId1 = pFrom.getElementId() ;
		this.graphId2 = pTo.getElementId() ;
		this.graphTag1 = pFrom.getGraphId() ;
		this.graphTag2 = pTo.getGraphId();
	}

	public boolean isIntraEdge() {
		if(this.graphTag1.equals(this.graphTag2)) return true ;
		else return false ;
	}

	public String getGraphId1() {
		return this.graphId1 ;
	}

	public String getGraphId2() {
		return this.graphId2 ;
	}

	public String getGraphTag1() {
		return this.graphTag1 ;
	}

	public String getGraphTag2() {
		return this.graphTag2 ;
	}

	public String getElement1() {
		return (this.graphTag1+"/"+this.graphId1) ;
	}

	public String getElement2() {
		return (this.graphTag2+"/"+this.graphId2) ;
	}

}
