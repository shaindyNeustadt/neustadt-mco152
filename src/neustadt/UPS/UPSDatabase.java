package neustadt.UPS;

import java.text.Bidi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
private HashMap<Package, Location> tracking;

public UPSDatabase(){
	tracking = new HashMap<Package, Location>();
}
	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation( Location location, Package pkg ) {
		tracking.put(pkg, location);
	}
	
	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation( Package pkg, Location location ) {
		addPackageToLocation(location, pkg);
	}
	
	/**
	 * @return a Set of Packages at the specified Location or an empty Set if 
	 * the Location doesn't exist or there are no Packages at that Location.
	 */
	public Set<Package> getPackages( Location location ) {
		HashSet<Package> set = new HashSet<Package>();
				
		if(!tracking.containsValue(location)){
			return set;
		}
		location.hashCode();
		/*if(tracking.hashCode() == (location.hashCode())){
			set.add(tracking.putAll(m);)
		}
		//Map.Entry<Package, Location> pak = new Entry<Package, Location>(tracking) ;
		//tracking
		//.getKey(location);
		//tracking.mapEntry().getKey(location);
		//
		
		//set.addAll(tracking);
		//tracking.containsValue(key);
	/*	for ( Map.Entry<Package, Location> entry : tracking.entrySet()) {
	            if(entry.getValue().equals(location)){
	            	set.add(entry.getKey());
	            }
	        }*/
		return set;
	}
	
	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return tracking.get(pkg);
	}
	
	
}
