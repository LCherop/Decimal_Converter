package lorenzo2;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.DecimalFormat;
import java.util.Random;
public class Lorenzo2 {
    private double x;
    
    public Lorenzo2(){
        this.x=0.0;
    }
    
    public static double RandomNumbers(){ //Generates 30 floating point numbers and appends them to an array
      
      Random rand = new Random();
 
          int num = rand.nextInt(50); //Generate a random integer value
          double nums= rand.nextDouble();//Generate a random double value

          double number = (double)num+nums;//Add the generated numbers
          
          DecimalFormat df = new DecimalFormat("###.###");
          number = parseDouble(df.format(number));//Round off the number to 3 decimal places
          
        return number;
    }
   public double splitter(double x) //Function to split the integer and decimal part for individual conversion
    {
       
        String doubleAsString = String.valueOf(x);
        int indexOfDecimal = doubleAsString.indexOf(".");//used to identify the decimal pont
        String a = doubleAsString.substring(0, indexOfDecimal); //a stores the integer part of the number in string format
        String b = doubleAsString.substring(indexOfDecimal); //b stores the decimal part of the number in string format
        
        //Convert the strings to double and integer values
        int a1 = parseInt(a); 
        double b1 = parseDouble(b);
        
        
        return b1;
    }
    
   public void IntToBinary(double x) //Function to convert the integer part to Binary
   {
       String doubleAsString = String.valueOf(x);
        int indexOfDecimal = doubleAsString.indexOf(".");
        String a = doubleAsString.substring(0, indexOfDecimal); //a stores the integer part of the number
        int a1 = parseInt(a);
        
       int[] resulty = new int[10]; //Array that stores the binar values
        if(a1 == 1){
            resulty[0] = 1;
        }else if(a1 == 0){
            resulty[0] = 0;
        }else if(a1>1){
               for(int i = 0; i<resulty.length;i++){
                   resulty[i] = a1%2;
                   a1 = a1/2;
               }
        }
        
        for (int j = resulty.length-1; j >= 0; j--){//For loop to read the values backwards
            System.out.print(resulty[j]);
        }
   }
   
   public void FractionToBinary( double x){ //Function to convert the fraction part to binary
       Lorenzo2 frac = new Lorenzo2();
       
       double fraction = frac.splitter(x);//Split to get the fraction/double part of the number
       
       int[] resultF = new int[4];//Array to store the binary digits
       double remainder;
       if(fraction==0.0){
           resultF[0]=0;
       }else if(fraction > 0.0){
           for(int i=0;i<=3;i++){
           remainder=fraction*2;//mltiply the fraction by two
           fraction = frac.splitter(remainder);//obtain the fraction part after multiplication
           int binary = (int) (remainder - fraction);//get the remainder
           resultF[i]=binary;       //append the remainder to the array
           }
       }
       for (int j = 0; j <resultF.length; j++){//output the array
            System.out.print(resultF[j]);
        }
   }
   

   

    
   
   
   public static void main(String[] args) 
    {
        for(int i=1;i<=30;i++){//Repeat 30 times to get 30 random numbers
            System.out.println(i);
        double one = RandomNumbers();
        Lorenzo2 bs = new Lorenzo2();
        
        double two =bs.splitter(one);
        
        
        System.out.println("Random Number :"+one);
        
        bs.IntToBinary(one);
        System.out.print(".");
        bs.FractionToBinary(two);
        
        System.out.println(" ");
        
        System.out.println("Remarks : Approximate");//All the values are approximate due to truncation
        
        System.out.println(" ");
        } 
        
    }
    
    
   
    
}
