import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    
	    Scanner reader = new Scanner(System.in);
		System.out.println("Enter the mass of the water, in grams");
		double mass = reader.nextDouble();
		System.out.println("Enter the initial temperature, in Celcius");
		double initialTemp = reader.nextDouble();
		if(initialTemp < -273.14)
		    initialTemp = -273.14;
		System.out.println("Enter the final temperature, in Celcius");
		double finalTemp = reader.nextDouble();
		if(finalTemp < -273.14)
		    finalTemp = -273.14;
		    
		    String initialPhase = "liquid";
		    if(initialTemp < 0)
		        initialPhase = "solid";
		    if(initialTemp > 100)
		        initialPhase = "vapor";
		        
		    String finalPhase = "liquid";
		    if(finalTemp < 0)
		        finalPhase = "solid";
		    if(finalTemp > 100)
		        finalPhase = "vapor";
		        
		    
		System.out.println("Mass: " + mass + "g");
		System.out.println("Initial temperature: " + initialTemp + "C" + initialPhase);
		System.out.println("Final temperature: " + finalTemp + "C" + finalPhase);
		
		boolean endothermic = false;
		if(finalTemp > initialTemp)
		    endothermic = true;

	}//main ends here
	
	
	//supporting methods
	
	public static double tempChangeSolid(double mass, double startTemp, double finalTemp, String endPhase, boolean endothermic)
	{
	    if(!endPhase.equals("solid"))
	        endTemp = 0;
	    double energyChange = round(mass*0.002108*(endTemp - startTemp));
	    if(endothermic)
	        System.out.println("Heating (solid): " + energyChange + "kJ");
	    else 
	        System.out.println("Cooling (solid): " + energyChange + "kJ");
	    return energyChange;
	}
	
	public static double tempChangeSolid(double mass, double startTemp, double finalTemp, String endPhase, boolean endothermic)
	{
	    if(endPhase.equals("solid"))
	        endTemp = 0;
	    if(endPhase.equals("vapor"))
	        endTemp = 100;
	    double energyChange = round(mass*0.004184*(endTemp - startTemp));
	    if(endothermic)
	        System.out.println("Heating (liquid): " + energyChange + "kJ");
	    else 
	        System.out.println("Cooling (liquid): " + energyChange + "kJ");
	    return energyChange;
	        
	public static double tempChangeSolid(double mass, double startTemp, double finalTemp, String endPhase, boolean endothermic) {
	    if(endPhase.equals("vapor"))
	        endTemp = 100;
	    double energyChange = round(mass*0.001996*(endTemp - startTemp));
	    if(endothermic)
	        System.out.println("Heating (vapor): " + energyChange + "kJ");
	    else 
	        System.out.println("Cooling (vapor): " + energyChange + "kJ");
	    return energyChange;
	}
	
	public static double fusion(double mass, boolean endothermic) {
	    double energyChange;
	    if(endothermic) {
	        energyChange = round(0.333*mass);
	        System.out.print("Melting: " + energyChange + "kJ");
	    }
	    else {
	       energyChange = round(-0.333*mass);
	        System.out.print("Freezing: " + energyChange + "kJ");
	    }
	    return energyChange;
	}
	
	public static double vaporization(double mass, boolean endothermic) {
	    double energyChange;
	    if(endothermic) {
	        energyChange = round(2.257*mass);
	        System.out.print("Evaporation: " + energyChange + "kJ");
	    }
	    else {
	       energyChange = round(-2.257*mass);
	        System.out.print("Condensation: " + energyChange + "kJ");
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
	
}//class ends here



