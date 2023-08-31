import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import big.data.DataSource;

/**
 * This is a fully documented class named NeoDatabase which will contain and manage the NearEarthObject records
 * which have been downloaded from the online dataset. The specific data structure used to implement this database
 * is up to you - any Java API class may be used or customized for this purpose. While deciding which structure to
 * use, be sure to consider the operations which will be performed on this database, as well as the pros and cons
 * for using various structures such as LinkedLists, Trees, Hashtables.
 * @Uday Turakhia 
 *     #115102637
 * <dt><b>Homework :</b><dd>
 *    Homework #7 for CSE 214, Spring 2023
 *    Recitation#: R03
 * <dt><b>Date:</b><dd>
 *    April 27, 2023
 */
public class NeoDatabase{

    /** The API key used to access the NASA API. */
    public static final String API_KEY = "VEgVPfGVuhI4ByQSPhhHwqVwXbWogiZricx5Zldr";

    /** The root URL of the NASA API. */
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";

    /** The list of NearEarthObjects in the database. */
    ArrayList<NearEarthObject> data;

    /**
     * Constructs a new NeoDatabase with an empty list of NearEarthObjects.
     */
    public NeoDatabase()
    {
        data = new ArrayList<NearEarthObject>();
    }

    /**
     * Builds a query URL for the given page number.
     *
     * @param pageNumber The page number to build the query URL for.
     * @return The query URL for the given page number.
     * @throws IllegalArgumentException If the page number is less than 0 or greater than 715.
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException
    {
        if(pageNumber<0 || pageNumber > 715)
            throw new IllegalArgumentException();

        return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
    }

    /**
     * Adds all NearEarthObjects from the given query URL to the database.
     *
     * @param queryURL The query URL to fetch NearEarthObjects from.
     * @throws IllegalArgumentException If the query URL is invalid.
     */
    public void addAll(String queryURL) throws IllegalArgumentException
    {
        if(queryURL.isEmpty() || queryURL==null)
            throw new IllegalArgumentException();

        DataSource ds = DataSource.connectJSON(queryURL);
        ds.load();

        NearEarthObject[] pageData = ds.fetchArray(
            "NearEarthObject",
            "near_earth_objects/neo_reference_id",
            "near_earth_objects/name",
            "near_earth_objects/absolute_magnitude_h",
            "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
            "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
            "near_earth_objects/is_potentially_hazardous_asteroid",
            "near_earth_objects/close_approach_data/epoch_date_close_approach",
            "near_earth_objects/close_approach_data/miss_distance/kilometers",
            "near_earth_objects/close_approach_data/orbiting_body"
         );

         for(int i = 0; i<pageData.length;i++)
         {
            data.add(pageData[i]);
         }
    }

    /**
     * Sorts the list of NearEarthObjects using the given comparator.
     *
     * @param comp The comparator to use for sorting.
     * @throws IllegalArgumentException If the comparator is null.
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException
    {
        if(comp == null)
            throw new IllegalArgumentException();

        Collections.sort(data,comp);
    }

    /**
     * Prints a table of all NearEarthObjects in the database.
     */
    public void printTable()
    {
        System.out.println("  ID   |           Name            | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits");
        System.out.println("================================================================================================");
        for(int i=0; i<data.size();i++)
        {
            System.out.println(data.get(i));
        }
    }
}
