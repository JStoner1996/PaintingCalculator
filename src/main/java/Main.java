import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Declare variables needed
        int wallArea = 0;
        int doorsArea = 0;
        int socketsArea = 0;
        int windowsArea = 0;
        int radiatorArea = 0;

        //Introduction
        System.out.println("Hello welcome to Paint Calculator 2022. If you do not know the sizes" +
                " of certain things, it will use average sizes. Please use centimeters!");

        System.out.println("How many walls do you want to paint?");
        int numWalls = myScanner.nextInt();

        // Find wall sizes and calculate total area
        for (int i = 0; i < numWalls; i++) {
            int j = i + 1;
            // Find wall info
            System.out.println("What's the length of wall " + j + "?");
            int wallLength = myScanner.nextInt();

            System.out.println("What's the width of wall " + j + "?");
            int wallWidth = myScanner.nextInt();

            wallArea += wallLength * wallWidth;

            // Calculate areas
            doorsArea = calculateDoors();
            socketsArea = calculateSockets();
            windowsArea = calculateWindows();
            radiatorArea =  calculateRadiators();

        }

        // Calculate area that needs painting
        double areaToPaint = wallArea - (doorsArea + socketsArea + windowsArea + radiatorArea);
        // how much area 1 litre of paint covers in cm
        int litrePerArea = 169000;

        System.out.println("You need to paint " + areaToPaint + "cm. Rounded up.");
        double paintAmount = areaToPaint / litrePerArea;

        // Find paint bucket size
        System.out.println("What size paint buckets will you use, in litres?");
        double paintSize = myScanner.nextDouble();
        // Find amount of buckets needed
        double exactBucketsNeeded = Math.round((paintAmount / paintSize)*100.0)/100.0;
        System.out.println("This means " + exactBucketsNeeded + " buckets of paint is needed to cover the walls. Or " +
                ((int)(exactBucketsNeeded * 100)) + "% of a bucket." );


        int bucketsNeeded = (int) Math.ceil(exactBucketsNeeded);
        System.out.println("Rounded up that would be " + bucketsNeeded + " buckets.");

        // Find total price of paint
        System.out.println("Whats the price of the paint you will use in GBP?");
        int paintCost = myScanner.nextInt();
        double totalPaintCost = paintCost * bucketsNeeded;
        System.out.println("That would be " + totalPaintCost + " GBP in paint costs.");
    }

    public static int calculateDoors(){
        Scanner doorScanner = new Scanner(System.in);
        int doorsArea = 0;
        // Find door info
        System.out.println("How many doors?");
        // Default door size
        int doorSize = 15096;
        int numDoors = doorScanner.nextInt();
        doorsArea = 0;
        if (numDoors > 0) {
            System.out.println("Do you know the size of each door? Please state true or false.");
            boolean knowsDoorSizes = doorScanner.nextBoolean();

            if (knowsDoorSizes == true) {
                for (int i = 0; i < numDoors; i++) {
                    int j = i + 1;
                    System.out.println("What's the length of door " + j + "?");
                    int doorLength = doorScanner.nextInt();
                    System.out.println("What's the width of door " + j + "?");
                    int doorWidth = doorScanner.nextInt();
                    doorsArea += (doorLength * doorWidth);
                }
            } else {
                doorsArea = doorSize * numDoors;
            }
        }
        return doorsArea;
    }

    public static int calculateSockets(){
        Scanner socketsScanner = new Scanner(System.in);
        int socketsArea = 0;
        // Find socket info
        System.out.println("How many sockets?");
        //default socket size
        int socketSize = 126;
        int numSockets = socketsScanner.nextInt();
        if (numSockets > 0) {
            System.out.println("Do you know the size of each socket? Please state true or false.");
            boolean knowsSocketSizes = socketsScanner.nextBoolean();

            if (knowsSocketSizes == true) {
                for (int i = 0; i < numSockets; i++) {
                    int j = i + 1;
                    System.out.println("What's the length of socket " + j + "?");
                    int socketLength = socketsScanner.nextInt();
                    System.out.println("What's the width of socket " + j + "?");
                    int socketWidth = socketsScanner.nextInt();
                    socketsArea += (socketLength * socketWidth);
                }
            } else {
                socketsArea = socketSize * numSockets;
            }
        }
        return socketsArea;
    }

    public static int calculateWindows(){
        Scanner windowScanner = new Scanner(System.in);
        int windowsArea = 0;

        // Find window info
        System.out.println("How many windows?");
        // Default window size
        int windowSize = 5575;
        int numWindows = windowScanner.nextInt();

        if (numWindows > 0) {
            System.out.println("Do you know the size of each window? Please state true or false.");
            boolean knowsWindowSizes = windowScanner.nextBoolean();

            if (knowsWindowSizes == true) {
                for (int i = 0; i < numWindows; i++) {
                    int j = i + 1;
                    System.out.println("What's the length of window " + j + "?");
                    int windowLength = windowScanner.nextInt();
                    System.out.println("What's the width of window " + j + "?");
                    int windowWidth = windowScanner.nextInt();
                    windowsArea += (windowLength * windowWidth);
                }
            } else {
                windowsArea = windowsArea * numWindows;
            }
        }
        return windowsArea;
    }

    private static int calculateRadiators() {
        Scanner radiatorScanner = new Scanner(System.in);
        int radiatorArea = 0;

        // Find window info
        System.out.println("How many radiators?");
        // Default window size
        int radiatorSize = 4800;
        int numRadiators = radiatorScanner.nextInt();

        if (numRadiators > 0) {
            System.out.println("Do you know the size of each radiator? Please state true or false.");
            boolean knowsWindowSizes = radiatorScanner.nextBoolean();

            if (knowsWindowSizes == true) {
                for (int i = 0; i < numRadiators; i++) {
                    int j = i + 1;
                    System.out.println("What's the length of radiator " + j + "?");
                    int radiatorLength = radiatorScanner.nextInt();
                    System.out.println("What's the width of radiator " + j + "?");
                    int radiatorWidth = radiatorScanner.nextInt();
                    radiatorArea += (radiatorLength * radiatorWidth);
                }
            } else {
                radiatorArea = radiatorArea * numRadiators;
            }
        }
        return radiatorArea;
    }

}