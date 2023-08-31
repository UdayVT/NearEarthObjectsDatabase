import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This is a fully documented class named NearEarthObject. This class represents a record in the database of
 * asteroids currently tracked by NASA. It should be noted that this class will always be constructed by the
 * BigData library, and serves as a data container for the information that is already hosted by the NeoW API.
 * @Uday Turakhia 
 *     #115102637
 * <dt><b>Homework :</b><dd>
 *    Homework #7 for CSE 214, Spring 2023
 *    Recitation#: R03
 * <dt><b>Date:</b><dd>
 *    April 27, 2023
 */
public class NearEarthObject 
{
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     * Constructs a new NearEarthObject with the given properties.
     *
     * @param referenceID The unique ID of the NEO.
     * @param name The name of the NEO.
     * @param absoluteMagnitude The absolute magnitude of the NEO.
     * @param minDiameter The minimum diameter of the NEO.
     * @param maxDiameter The maximum diameter of the NEO.
     * @param isDangerous Whether the NEO is potentially hazardous.
     * @param closestDateTimestamp The timestamp of the closest approach date of the NEO.
     * @param missDistance The miss distance of the NEO.
     * @param orbitingBody The name of the orbiting body of the NEO.
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, 
    double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody)   
    {
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = Math.round(absoluteMagnitude*10.0)/10.0;
        this.averageDiameter = (minDiameter + maxDiameter) / 2;
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }

    /**
     * Gets the absolute magnitude of the NEO.
     *
     * @return The absolute magnitude of the NEO.
     */
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    /**
     * Gets the average diameter of the NEO.
     *
     * @return The average diameter of the NEO.
     */
    public double getAverageDiameter() {
        return averageDiameter;
    }

    /**
     * Gets the closest approach date of the NEO.
     *
     * @return The closest approach date of the NEO.
     */
    public Date getClosestApproachDate() {
        return closestApproachDate;
    }

    /**
     * Gets the miss distance of the NEO.
     *
     * @return The miss distance of the NEO.
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * Gets the name of the NEO.
     *
     * @return The name of the NEO.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name of the orbiting body of the NEO.
     *
     * @return The name of the orbiting body of the NEO.
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     * Gets the reference ID of the NEO.
     *
     * @return The reference ID of the NEO.
     */
    public int getReferenceID() {
        return referenceID;
    }

    /**
     * Determines whether the NEO is potentially hazardous.
     *
     * @return True if the NEO is potentially hazardous, false otherwise.
     */
    public boolean isDangerous(){
        return isDangerous;
    }

    /**
     * Sets the absolute magnitude of the NEO.
     *
     * @param absoluteMagnitude The new absolute magnitude of the NEO.
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * Sets the average diameter of the NEO.
     *
     * @param averageDiameter The new average diameter of the NEO.
     */
    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    /**
     * Sets the closest approach date of the NEO.
     *
     * @param closestApproachDate The new closest approach date of the NEO.
     */
    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * Sets whether the NEO is potentially hazardous.
     *
     * @param isDangerous Whether the NEO is potentially hazardous.
     */
    public void setDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

    /**
     * Sets the miss distance of the NEO.
     *
     * @param missDistance The new miss distance of the NEO.
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * Sets the name of the NEO.
     *
     * @param name The new name of the NEO.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the name of the orbiting body of the NEO.
     *
     * @param orbitingBody The new name of the orbiting body of the NEO.
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    /**
     * Sets the reference ID of the NEO.
     *
     * @param referenceID The new reference ID of the NEO.
     */
    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    /**
     * Returns a string representation of the NEO in a formatted table row.
     *
     * @return A string representation of the NEO in a formatted table row.
     */
    public String toString()
    {
        String date = new SimpleDateFormat("MM-dd-yyyy").format(closestApproachDate);
        String sName = name.substring(0, Math.min(name.length(),26));
        return String.format("%-9d%-28s%-8.1f%-10.3f%-10s%-12s%-12.0f%s",referenceID,sName,absoluteMagnitude,
        averageDiameter,isDangerous,date,missDistance,orbitingBody);
    }
}
