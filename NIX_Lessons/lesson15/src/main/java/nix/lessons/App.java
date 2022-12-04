package nix.lessons;

public class App
{
    public static void main( String[] args )
    {
        FunctionalInterfaces fi = new FunctionalInterfaces();
        
        System.out.println(fi.predicateIsPrime(23));
        fi.consumerRandomGenerate(20.5);
        System.out.println(fi.supplierGetDay());
        System.out.println(fi.functionRoundDoubleToLong(25.481));
        System.out.println(fi.unaryOperatorFibo(1));
    }
}
