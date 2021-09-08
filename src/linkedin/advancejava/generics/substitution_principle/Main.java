package linkedin.advancejava.generics.substitution_principle;

import java.util.ArrayList;
import java.util.List;

/**
 * The substitution principle (also known "list of substitution of principle") - maintainable and reusable code.
 * If you have a variable of a given type, you can assign it to a value of a subtype of that type.
 * classes:
 *  - Building
 *  - Office w/c extends Building
 *
 */
public class Main {
    public static void main(String[] args) {
        Building building = new Building();
        Office office = new Office();
        build(building);
        build(office);
        /*
        Because, office is a subtype of the Building, OR office extends to Building.
        We can pass it into this method. - This is the substitution principle

        It is also important When is substitution principle doesn't apply
        You might think that office is a subtype of a building.
        The (list of type office)   is a subtype of a (list of type building). However, this isn't actually the case.

         */

        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Office()); // because of substitution principle, I can add Office on the list. Office is a subtype of a Building.
        printBuildings(buildings);
        // Running this code - will run as expected & prints out what type of building each

        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());
        List<House> houses = new ArrayList<>();
        houses.add(new House());
        houses.add(new House());
//        printBuildings(offices); // ERROR => List<Office> and List<Building> are incompatible types.
        // so substitution principle is not apply here.
        // NAIVE SOLUTION: to create method each of it's class.
        // BEST SOLUTION: Using wildcards in generic programming
        printBuildingsCorrect(offices); // CORRECT!
        printBuildingsCorrect(houses); // CORRECT!
    }

    static void build(Building building) {
        System.out.println("Constructing a new " + building.toString());
    }

    static void printBuildings(List<Building> buildingList) {
        for (int i = 0; i <buildingList.size(); i++) {
            System.out.println(i + 1 + ": " + buildingList.get(i).toString());
        }
    }

    /**
     * To use a wildcard - put a ? (question mark) then write "extends" before buildingList.
     * This means that I can pass in any type of List of any type that only extends Building.
     * so printBuilding() method no longer get any errors.
     * <p>
     * In this method, I pass in a list which provides data which I used inside method.
     * so this is an invariable - with it, it makes sense to use extends.
     * @param buildingList
     */
    static void printBuildingsCorrect(List<? extends Building> buildingList) {
        for (int i = 0; i <buildingList.size(); i++) {
            System.out.println(i + 1 + ": " + buildingList.get(i).toString());
        }
    }

    /**
     * Currently you can Only pass in List of Houses, but I if I want to pass in Building (supertype of House)
     * If you don't know (unsure) what to use "extends" OR "super" with wildcards - you can think about
     * In-variables and Out-variables
     * <p>
     * In this method, I use method to give additional data by adding to the list.
     * so this is an outvariable - with it, it makes sense to use super.
     * @param buildings
     */
    static void addHouseToList(List<House> buildings) {
        buildings.add(new House());
        System.out.println();
    }

    /*
    NOTE: generally, it's bad idea to use wildcards as a return types for a method.
    If I did this, anyone else who used these methods will spend time working on
    Hierarchies in this code.
    When use in the right places wildcards can make your code more flexible and
    helps to get rid of duplicate methods.
     */
}
