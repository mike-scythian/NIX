package nix.lessons;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;



public class FunctionalInterfaces {
    
    public boolean predicateIsPrime(Integer number){
        
        Predicate<Integer> predicate = x ->{
            if(x<=1)
                return false;
            for(int i=2; i< x; ++i)
                if(x % i == 0)
                    return false;
            return true;
        };
        return predicate.test(number);
    }
    
    public void consumerRandomGenerate(Double bound){
        
         Consumer<Double> consumer = x ->  System.out.println(new Random().nextDouble()* x);
         consumer.accept(bound);
    } 
    
    public DayOfWeek supplierGetDay(){
        
        Supplier<DayOfWeek> supplier = () -> LocalDate.now().getDayOfWeek();
        return supplier.get();
    }
    
    public Long functionRoundDoubleToLong(Double number){
        
        Function<Double,Long> function = x -> {
            String longString = x.toString().substring(0,x.toString().indexOf('.'));
            
            if(isUpLastNumber(x))
                return Long.valueOf(replaceSymbolIncraesedOne(longString,longString.length()-1));
            return Long.valueOf(longString);
        };
        return function.apply(number);
    }
    
    public Integer unaryOperatorFibo(Integer bound){
        
        UnaryOperator<Integer> unaryOperator = n ->{
            if(n == 0 || n == 1)
              return n;
            Integer fiboNumber = 0;
            Integer n1 = 0, n2 = 1;
            
            for(int i = 2; i <= n; i++){
                fiboNumber = Integer.sum(n1,n2);
                n1 = n2;
                n2 = fiboNumber;
            }
            return fiboNumber;  
        };
        return unaryOperator.apply(bound);
    }
    
     private static boolean isUpLastNumber(Double number){

        StringBuilder numberAsString = new StringBuilder(number.toString());
        int commaIndex = numberAsString.indexOf(".");
        boolean flagIncreaseNexnNumber = false;
        for(int i = numberAsString.length()-1; i > commaIndex; i--) {
            if (flagIncreaseNexnNumber)
                numberAsString.replace(0, numberAsString.length(),replaceSymbolIncraesedOne(numberAsString.toString(), i));
            if (Integer.parseInt(String.valueOf(numberAsString.charAt(i))) > 4)
                flagIncreaseNexnNumber = true;
            else
                flagIncreaseNexnNumber = false;
        }
        return flagIncreaseNexnNumber;
    }
    private static String replaceSymbolIncraesedOne(String string, int index){

        String oldSymbol = String.valueOf(string.charAt(index));
        String resultString = "";
        int incr = Integer.parseInt(oldSymbol);

        incr++;

        for(int i=0; i<string.length();i++)
            if(i == index)
                resultString += incr;
            else
                resultString += string.charAt(i);
        return resultString;
    }
}
