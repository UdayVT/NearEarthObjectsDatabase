/**
 * A comparator that compares NearEarthObjects based on their miss distance.
 * @Uday Turakhia 
 *     #115102637
 * <dt><b>Homework :</b><dd>
 *    Homework #7 for CSE 214, Spring 2023
 *    Recitation#: R03
 * <dt><b>Date:</b><dd>
 *    April 27, 2023
 */
public class MissDistanceComparator implements java.util.Comparator<NearEarthObject> {

    /**
     * Compares two NearEarthObjects based on their miss distance.
     *
     * @param o1 The first NearEarthObject to compare.
     * @param o2 The second NearEarthObject to compare.
     * @return 0 if the objects have the same miss distance, a positive integer if o1's miss distance is greater than o2's,
     *         or a negative integer if o1's miss distance is less than o2's.
     */
    @Override
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        double a = o1.getMissDistance();
        double b = o2.getMissDistance();
        if(a == b)
            return 0;
        else if(a > b)
            return 1;
        else
            return -1;
    }
}
