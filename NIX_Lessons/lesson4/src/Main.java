public class Main {

    static class PrimeNumber{

        private static int count = 2;


//      WORK FOR ONLY POSITIV NUMBERS
        public static boolean isPrimeNumber(int number){

            if (number == 0 || number == 1)
                return false;
            if (number == count)
                return true;
            if (number > count)
                if (number % count == 0)
                    return false;
                else {
                    count++;
                    return isPrimeNumber(number);
                }
            return true;
        }

        public static void clearCount(){

            count = 2;
        }


    }
    public static void main(String[] args) {

        System.out.println(PrimeNumber.isPrimeNumber(7));

    }


}