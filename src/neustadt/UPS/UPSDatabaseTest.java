package neustadt.UPS;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase ups = new UPSDatabase();
		Location loc = new Location(32, 32);
		Package pkg = new Package("456");
		ups.addPackageToLocation(loc, pkg);
		Assert.assertEquals(loc, ups.getLocation(pkg));
		Assert.assertTrue(ups.getPackages(loc).contains(pkg));
		
	}
	
	@Test 
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase ups = new UPSDatabase();
		Location loc = new Location(32, 32);
		Location loc2 = new Location(40, 45);
		Package pkg = new Package("456");
		ups.addPackageToLocation(loc, pkg);
		ups.updatePackageLocation(pkg, loc2);
		Assert.assertEquals(loc2, ups.getLocation(pkg));
		Assert.assertTrue(ups.getPackages(loc2).contains(pkg));
		Assert.assertFalse(ups.getPackages(loc).contains(pkg));
	}
	
	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase ups = new UPSDatabase();
		Assert.assertTrue(ups.getPackages(new Location(32, 32)).size()== 0);
		//Assert.assertNull(ups.getPackages(new Location(32, 32)));
	}
	
	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase ups = new UPSDatabase();
		Assert.assertNull(ups.getLocation(new Package("456")));
	}
}
