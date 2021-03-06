package org.graphstream.distributed.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIHelper {
	
	private RMIHelper() {
	}
	
	/**
	 * 
	 * @param id
	 * @param host
	 */
	public static void bind(String id, String host) {
		try	{
			Naming.rebind( String.format( "//"+host+"/%s", id ), new RMIDGraph(id) );
			System.out.println("binding " + id + " on " + host + " done");
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param uri
	 * @return
	 */
	public static RMIDGraphAdapter register(String uri) {
		try {
			return (RMIDGraphAdapter)Naming.lookup(uri) ;
		}
		catch (RemoteException exp) {
				System.out.println("RemoteException dans register : " +	exp);
				return null ;
		}
		catch (NotBoundException exp) {
				System.out.println("NotBoundException dans register : "	+ exp);
				return null ;
		}
		catch (MalformedURLException exp) {
				System.out.println("MalformedURLException dans register : " + exp);
				return null ;
		}
	}
	
	/**
	 * 
	 * @param DGraph
	 * @param method
	 * @param params
	 * @return
	 */
	public static Object RMICall(RMIDGraphAdapter DGraph, String ObjectName, String MethodName, Object[] params) {
		try {
			return DGraph.exec(ObjectName, MethodName, params);
		}
		catch(RemoteException e) {
			System.out.println("Error rmiCall");
			return null ;
		}
	}
	
	public static Object RMICall(RMIDGraphAdapter DGraph, String ObjectName, ArrayList<String> MethodName, ArrayList<Object[]> params) {
		try {
			return DGraph.exec(ObjectName, MethodName, params);
		}
		catch(RemoteException e) {
			System.out.println("Error rmiCall");
			return null ;
		}
	}
	
		
}
