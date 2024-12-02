public class Primes {
    public static void main(String[] args) {
        // initialize: build a Boolean array of size n + 1 
        // and set all the elements with index > 1 to true:
        final int n = Integer.parseInt(args[0]);
        boolean[] arr = new boolean [n+1];
        System.out.println("Prime numbers up to " + n + ":");
        primeNums(n, arr);
        System.out.println("There are " + primeAmount(n, arr) + " primes between 2 and " + n + 
                           " (" + primePerc(primeAmount(n, arr), n - 1) + "% are primes)");
    }
    // Prints all the prime numbers from 2 to n
    public static void primeNums(int n, boolean[] arr) {
        int i = 2;
        int x = 2;
        while (i <= n) {
            arr[i] = true;
            i++;
        }
        i = 2;
        while ((i <= n)) { 
            if ((i % x == 0) && (i != x)) {
                arr[i] = false;
            } 
            i++; 
            if ((i == n) && (x <= Math.sqrt(n))) {
                x++;
            }
        } 
        i = 2;
        while (i <= n) {
            if (arr[i] == true) {
                System.out.println(i);
            }
            i++;
        }
    }
    // Returns the amount of prime numbers from 2 to n
    public static int primeAmount(int n, boolean[] arr) {
        int i = 2;
        int count = 0;
            while (i <= n) {
                if (arr[i] == true) {
                    count++;
                }
                i++;
            }
            return count;
    }
    // Returns the pecentage of prime numbers from 2 to n
    public static int primePerc(int primeAmount, int numAmount) {
        return (int) (((double) primeAmount / numAmount) * 100);
    }
    
}
