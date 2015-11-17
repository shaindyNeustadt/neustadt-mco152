package neustadt.UPS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	private HashMap<Package, Location> tracking1;
	private HashMap<Location, Set<Package>> tracking2;

	public UPSDatabase() {
		tracking1 = new HashMap<Package, Location>();
		tracking2 = new HashMap<Location, Set<Package>>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		tracking1.put(pkg, location);
		if (!tracking2.containsKey(location)) {
			tracking2.put(location, new HashSet<Package>());
		}
		tracking2.get(location).add(pkg);
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		tracking2.get(tracking1.get(pkg)).remove(pkg);
		addPackageToLocation(location, pkg);
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		HashSet<Package> set = new HashSet<Package>();

		if (!tracking2.containsKey(location)) {
			return set;
		}
		return tracking2.get(location);

	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return tracking1.get(pkg);
	}

}
