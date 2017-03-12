package shortestdistance;

/**
 * Expresses the distance to another city
 * 
 */
public class Destination implements Comparable<Destination> {
	private String targetName;
	private int distanceTo;

	public Destination(String targetName, int distanceTo) {
		this.targetName = targetName;
		this.distanceTo = distanceTo;
	}

	@Override
	public int compareTo(Destination other) {
		return distanceTo - other.distanceTo;
	}
	
	public String getTargetName() {
		return targetName;
	}

	public int getDistanceTo() {
		return distanceTo;
	}

	
}
