/**
 * A comparator that compares NearEarthObjects based on their reference ID.
 * @Uday Turakhia 
 *     #115102637
 * <dt><b>Homework :</b><dd>
 *    Homework #7 for CSE 214, Spring 2023
 *    Recitation#: R03
 * <dt><b>Date:</b><dd>
 *    April 27, 2023
 */
public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject> {

    /**
     * Compares two NearEarthObjects based on their reference ID.
     *
     * @param o1 The first NearEarthObject to compare.
     * @param o2 The second NearEarthObject to compare.
     * @return 0 if the objects have the same reference ID, a positive integer if o1's reference ID is greater than o2's,
     *         or a negative integer if o1's reference ID is less than o2's.
     */
    @Override
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        int a = o1.getReferenceID();
        int b = o2.getReferenceID();
        if(a == b)
            return 0;
        else if(a > b)
            return 1;
        else
            return -1;
    }
}
