// Painting Calculator by Jake Stoner
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
        int othersArea = 0;

        //Introduction
        System.out.println("\nHello welcome to Paint Calculator 2022.\nIf you do not know the sizes" +
                " of certain objects, it will use the average UK sizes. \nPlease use centimeters and integers!");

        System.out.println("\nHow many walls do you want to paint?");
        int numWalls = myScanner.nextInt();

        // Find wall sizes and calculate total area
        for (int wallNumber = 0; wallNumber < numWalls; wallNumber++) {
            int i = wallNumber + 1;
            // Find wall info
            System.out.println("What's the length of wall " + i + "?");
            int wallLength = myScanner.nextInt();

            System.out.println("What's the width of wall " + i + "?");
            int wallWidth = myScanner.nextInt();

            wallArea += wallLength * wallWidth;

            // Calculate areas
            doorsArea = calculateDoors(wallNumber);
            socketsArea = calculateSockets(wallNumber);
            windowsArea = calculateWindows(wallNumber);
            radiatorArea =  calculateRadiators(wallNumber);
            othersArea = calculateOthers(wallNumber);


        }

        // Calculate area that needs painting
        double areaToPaint = wallArea - (doorsArea + socketsArea + windowsArea + radiatorArea + othersArea);
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

        // Rounds buckets needed to two decimal places
        int bucketsNeeded = (int) Math.ceil(exactBucketsNeeded);
        System.out.println("Rounded up that would be " + bucketsNeeded + " buckets.");

        // Find total price of paint
        System.out.println("Whats the price of the paint you will use in GBP?");
        int paintCost = myScanner.nextInt();
        double totalPaintCost = paintCost * bucketsNeeded;
        System.out.println("That would be " + totalPaintCost + " GBP in paint costs.");
    }

    public static int calculateDoors(int wallNumber) {
        Scanner doorScanner = new Scanner(System.in);

        int doorsArea = 0;
        int doorSize = 15096;

        System.out.println("How many doors on wall " +  (wallNumber + 1) + "?");

        int numDoors = doorScanner.nextInt();



            if (numDoors > 0) {
                System.out.println("Do you know the size of each door? Please state true or false.");
                boolean knowsDoorSizes = doorScanner.nextBoolean();

                if (knowsDoorSizes == true) {
                    for (int i = 0; i < numDoors; i++) {
                        int j = i + 1;
                        System.out.println("What's the length of door " + j + " on wall " + (wallNumber + 1) + "?");
                        int doorLength = doorScanner.nextInt();
                        System.out.println("What's the width of door " + j + " on wall " + (wallNumber + 1) + "?");
                        int doorWidth = doorScanner.nextInt();
                        doorsArea += (doorLength * doorWidth);
                    }
                } else {
                    doorsArea = doorSize * numDoors;
                }
            }
            return doorsArea;
        }

    public static int calculateSockets(int wallNumber){
        Scanner socketsScanner = new Scanner(System.in);

        int socketsArea = 0;
        int socketSize = 126;

        System.out.println("How many sockets on wall " + (wallNumber + 1) + "?");

        int numSockets = socketsScanner.nextInt();
        if (numSockets > 0) {
            System.out.println("Do you know the size of each socket? Please state true or false.");
            boolean knowsSocketSizes = socketsScanner.nextBoolean();

            if (knowsSocketSizes == true) {
                for (int i = 0; i < numSockets; i++) {
                    int j = i + 1;
                    System.out.println("What's the length of socket " + j + " on wall " + (wallNumber + 1) + "?");
                    int socketLength = socketsScanner.nextInt();
                    System.out.println("What's the width of socket " + j + " on wall " + (wallNumber + 1) + "?");
                    int socketWidth = socketsScanner.nextInt();
                    socketsArea += (socketLength * socketWidth);
                }
            } else {
                socketsArea = socketSize * numSockets;
            }
        }
        return socketsArea;
    }

    public static int calculateWindows(int wallNumber){
        Scanner windowScanner = new Scanner(System.in);

        int windowsArea = 0;
        int windowSize = 5575;

        System.out.println("How many windows on wall " + (wallNumber + 1) + "?");

        int numWindows = windowScanner.nextInt();

        if (numWindows > 0) {
            System.out.println("Do you know the size of each window? Please state true or false.");
            boolean knowsWindowSizes = windowScanner.nextBoolean();

            if (knowsWindowSizes == true) {
                for (int i = 0; i < numWindows; i++) {
                    int j = i + 1;
                    System.out.println("What's the length of window " + j + " on wall " + (wallNumber + 1) + "?");
                    int windowLength = windowScanner.nextInt();
                    System.out.println("What's the width of window " + j + " on wall " + (wallNumber + 1) + "?");
                    int windowWidth = windowScanner.nextInt();
                    windowsArea += (windowLength * windowWidth);
                }
            } else {
                windowsArea = windowsArea * numWindows;
            }
        }
        return windowsArea;
    }

    public static int calculateRadiators(int wallNumber) {
        Scanner radiatorScanner = new Scanner(System.in);

        int radiatorArea = 0;
        int radiatorSize = 4800;

        System.out.println("How many radiators on wall " + (wallNumber + 1) + "?");

        int numRadiators = radiatorScanner.nextInt();

        if (numRadiators > 0) {
            System.out.println("Do you know the size of each radiator? Please state true or false.");
            boolean knowsWindowSizes = radiatorScanner.nextBoolean();

            if (knowsWindowSizes == true) {
                for (int i = 0; i < numRadiators; i++) {
                    int j = i + 1;
                    System.out.println("What's the length of radiator " + j + " on wall " + (wallNumber + 1) + "?");
                    int radiatorLength = radiatorScanner.nextInt();
                    System.out.println("What's the width of radiator " + j + " on wall " + (wallNumber + 1) + "?");
                    int radiatorWidth = radiatorScanner.nextInt();
                    radiatorArea += (radiatorLength * radiatorWidth);
                }
            } else {
                radiatorArea = radiatorArea * numRadiators;
            }
        }
        return radiatorArea;
    }

    public static int calculateOthers(int wallNumber){
        Scanner othersScanner = new Scanner(System.in);

        int othersArea = 0;
        int othersSize = 0;

        System.out.println("Do you have any other objects blocking this wall?");

        boolean otherItems = othersScanner.nextBoolean();

        if (otherItems == true) {


            System.out.println("How many objects on wall " + (wallNumber + 1) + "?");

            int numOthers = othersScanner.nextInt();

            if (numOthers > 0) {
                    for (int i = 0; i < numOthers; i++) {
                        int j = i + 1;
                        System.out.println("What's the length of object " + j + " on wall " + (wallNumber + 1) + "?");
                        int otherLength = othersScanner.nextInt();
                        System.out.println("What's the width of object " + j + " on wall " + (wallNumber + 1) + "?");
                        int otherWidth = othersScanner.nextInt();
                        othersArea += (otherLength * otherWidth);
                    }
                }

        }else {
            othersArea = 0;
        }
        return othersArea;
    }


}