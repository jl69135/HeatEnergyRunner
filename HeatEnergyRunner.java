import java.util.Scanner;

public class HeatEnergyRunner {
    
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the mass of the water, in grass");
        double mass = reader.nextDouble();
        System.out.println("Enter the initial temerpature, in Celsius");
        double initialTemp = reader.nextDouble();
        if(initialTemp < -273.14)
            initialTemp = -273.14;
        System.out.println("Enter the final temperature, in Celsius");
        double finalTemp = reader.nextDouble();
        if(finalTemp < -273.14)
            finalTemp = -273.14;
        //we will now start phase, phase of matter and state of matter are being used interchangeably here
        //a String data type is a set of chrracters usually for words and phrases, though numbers can also go in a String
        //initialPhase is being declared as a String and being initialized to "liquid"
        //which means "liquid" is the default phase so we must then check for the non-default phrases
        //initialPhase is solid when temperature is less than 0
        String initialPhase = "liquid";
        if(initialTemp  0)
            initialPhase = "solid";
        if(initialTemp > 100)
            initialPhase = "vapor";
        //we need finalPhase string now, you can copy and paste
        String finalPhase = "liquid";
        if(finalTemp  0)
            finalPhase = "solid";
        if(finalTemp > 100)
            finalPhase = "vapor";
            
        System.out.println("Mass: " + mass + "g");
        System.out.println("Initial Temperature: " + initialTemp + "C " + initialPhase);
        System.out.println("Final Temperature: " + finalTemp + "C " + finalPhase);
        // we now want to determine if we are having an endothermic case or exothermic case 
        boolean endothermic = false;
        if(finalTemp > initialTemp)
            endothermic = true
        //endothermic has a value of true, that means we are in the endothermic case
        // if endothermic has a value of false, that means we are in the exothermic case
        // we dont need another variable called exothermic becuz exothermic case is covered by the variable called endothermic false
        // if i initialize endothermic to false, i need to check the other case which is when endothermic is true
        // remember we are talking about the heat of the water, not the surroundings
        
    } //main ends here
        //endTemp is only the final temperature if the final phase is ice or solid
    //if the final phase is liquid or vapor, then endTemp needs to be 0 becuz we stop at the melting NullPointerException
    //we have 5 parameters, things the method needs to know to its work is:
    //double mass, double startTemp, double endTemp, String endPhase, and boolean endothermic
    
    //we need to have a double mass as one of our parameters
    //parameters are what you plug in, return is what you are solving for
    //heating, cooling methods, and the fusion and vaoprisation methods ALL return
    //we'll use kJ, heat energy is going to return a double type
    //so we can do public static double
    //supporting methods will go here before the class ends
    public static double tempChangeSolid(double mass, double startTemp, double endTemp, String endPhase, boolean endothermic) {
        if(!endPhase.equals("solid"))
            endTemp = 0;
        double energyChange = mass*0.002108*(endTemp - startTemp);
        if(endothermic)
            System.out.printlin("Heating (solid): " + energyChange + "kJ")
        else
            System.out.printlin("Cooling (solid): " + energyChange + "kJ")
            //you can do if(!endothermic or you could do else)
        //we are returning energyChange
        return energyChange;
        
        //remember the energy change = mass*shc*change in temperature
    //we want to change endTemp to 0 if the endPhase is NOT solid, becuz we are on the solid method
    //make the statement for it's NOT solid is we put a not sign (!) in front
    }
    public static double tempChangeLiquid(double mass, double startTemp, double endTemp, String endPhase, boolean endothermic) {
        if(endPhase.equals("solid"))
        //this one says that it IS solid if endTemp is 0 while the method above this one is saying (!)not solid
            endTemp = 0;
        if(endPhase.equals("vapor"))
            endTemp = 100;
        double energyChange = mass*0.004184*(endTemp - startTemp);
        if(endothermic)
            System.out.printlin("Heating (liquid): " + energyChange + "kJ")
        else
            System.out.printlin("Cooling (liquid): " + energyChange + "kJ")
        return energyChange;
    }
    public static double tempChangeVapor(double mass, double startTemp, double endTemp, String endPhase, boolean endothermic) {
        if(!endPhase.equals("vapor"))
            endTemp = 0;
        double energyChange = mass*0.001996*(endTemp - startTemp);
        if(endothermic)
            System.out.printlin("Heating (vapor): " + energyChange + "kJ")
        else
            System.out.printlin("Cooling (vapor): " + energyChange + "kJ")
        return energyChange;
    }
    //for the heat energy absorbed or released by fusion (melting/freezing), multiply mass * the laten heat constant
    public static double fusion(double mass, boolean endothermic) {
        double energyChange;
        if(endothermic) {
            energyChange = round(0.333*mass);
            System.out.println("Melting: " + energyChange + "kJ");
        }
        else{
            energyChange = round(-0.333*mass);
            System.out.println("Freezing: " + energyChange + "kJ");
        }
        return energyChange;
    }
        //need the braces in those certain spaces because we have TWO statements that are subject to the if 
         //you need braces if more than 1 statement is subject to the if (or else, while, etc.)
    public static double vaporization(double mass, boolean endothermic) {
        double energyChange;
        if(endothermic) {
            energyChange = round(2.257*mass);
            System.out.println("Evaporation: " + energyChange + "kJ");
        }
        else{
            energyChange = round(-2.257*mass);
            System.out.println("Condensation: " + energyChange + "kJ");
        }
        return energyChange;
    }

    public static double round(double x) {
        x *= 1000;
        if(x > 0)
            return (int)(x + 0.5)/1000.0;
        else
            return (int)(x - 0.5)/1000.0;
        
    }
} //the entire class ends here
