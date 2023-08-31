/**
 * A comparator that compares NearEarthObjects based on their closest approach date.
 * @Uday Turakhia 
 *     #115102637
 * <dt><b>Homework :</b><dd>
 *    Homework #7 for CSE 214, Spring 2023
 *    Recitation#: R03
 * <dt><b>Date:</b><dd>
 *    April 27, 2023
 */
public class ApproachDateComparator implements java.util.Comparator<NearEarthObject> {

    /**
     * Compares two NearEarthObjects based on their closest approach date.
     *
     * @param o1 The first NearEarthObject to compare.
     * @param o2 The second NearEarthObject to compare.
     * @return 0 if the objects have the same closest approach date, a positive integer if o1's closest approach date is later than o2's,
     *         or a negative integer if o1's closest approach date is earlier than o2's.
     */
    @Override
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        long a = o1.getClosestApproachDate().getTime();
        long b = o2.getClosestApproachDate().getTime();
        if(a == b)
            return 0;
        else if(a > b)
            return 1;
        else
            return -1;
    }
}
