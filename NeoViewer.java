import java.util.Scanner;

/**
 *  a fully-documented class named NeoViewer which allows a user to view 
 * datasets obtained from the NASA NeoW API. This class should contain a 
 * main() method which creates a database and prompts the user to add a page 
 * to the database, sort the current database, and display the database.
 * @Uday Turakhia 
 *     #115102637
 * <dt><b>Homework :</b><dd>
 *    Homework #7 for CSE 214, Spring 2023
 *    Recitation#: R03
 * <dt><b>Date:</b><dd>
 *    April 27, 2023
 */
public class NeoViewer {

    /** The NeoDatabase being viewed. */
    NeoDatabase data;

    /** The scanner used for user input. */
    public static Scanner input = new Scanner(System.in);

    /**
     * Reads the next integer from the user input and consumes the rest of the line.
     *
     * @return The next integer from the user input.
     */
    public static int nextInt()
    {
        int answer = input.nextInt();
        input.nextLine();
        return answer;
    }/**
     * The main method that runs the NEO Viewer program.
     *
     * @param args The command line arguments passed to the program.
     */
    public static void main(String[] args) 
    {
        NeoDatabase database = new NeoDatabase();
        System.out.println("Welcome to NEO Viewer!\n");
        boolean quit = false;
    
        while(!quit)
        {
            System.out.print("Option Menu:\n"
            +"   A) Add a page to the database\n"
            +"   S) Sort the database\n"
            +"   P) Print the database as a table.\n"
            +"   Q) Quit\n");
    
            System.out.print("\nSelect a menu option: ");
            char inp = input.nextLine().toUpperCase().charAt(0);
    
            if(inp == 'A')
            {
                System.out.print("\nEnter the page to load: ");
                try 
                {
                    database.addAll(database.buildQueryURL(nextInt()));
                    System.out.println("\nPage loaded successfully!\n");
                    
                }catch(IllegalArgumentException e)
                {
                    System.out.println("\nInvalid page number\n");
                } catch (Exception e) 
                {
                    System.out.println("\nSomething went wrong, please try again...\n");
                    quit =true;
                }
            }
            else if(inp == 'S')
            {
                System.out.println();
                System.out.print("R) Sort by referenceID\n"
                +"D) Sort by diameter\n"
                +"A) Sort by approach date\n"
                +"M) Sort by miss distance\n");
    
                System.out.print("\nSelect a menu option: ");
                char sortInp = input.nextLine().toUpperCase().charAt(0);
    
                if(sortInp == 'R')
                {
                    database.sort(new ReferenceIDComparator());
                    System.out.println("\nTable sorted on referenceId.\n");
                }
                else if(sortInp == 'D')
                {
                    database.sort(new DiameterComparator());
                    System.out.println("\nTable sorted on diameter.\n");
                }
                else if(sortInp == 'A')
                {
                    database.sort(new ApproachDateComparator());
                    System.out.println("\nTable sorted on approach date.\n");
                }
                else if(sortInp == 'M')
                {
                    database.sort(new MissDistanceComparator());
                    System.out.println("\nTable sorted on miss distance.\n");
                }
                else
                {
                    System.out.println("\nInvalid input.\n");
                }
            }
            else if(inp == 'P')
            {
                System.out.println();
                database.printTable();
                System.out.println();
            }
            else if(inp == 'Q')
            {
                quit = true;
            }
            else
            {
                System.out.println("\nInvalid input\n");
            }
        }
        System.out.println("\nProgram terminating normally...");
    }
}
