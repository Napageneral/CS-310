package edu.sdsu.cs.util;

import java.math.BigInteger;

/**
 * Created by Tyler Brandt on 4/17/2017.
 */
public class Prime {

    public static int nearestPrimeAfter(int target){
        //Code written by Ayush Jain at http://www.geeksforgeeks.org/quick-ways-to-check-for-prime-and-find-next-prime-in-java/
        BigInteger b = new BigInteger(String.valueOf(target));
        return Integer.parseInt(b.nextProbablePrime().toString());

    }

    public boolean isPrime(int target){
        //Code written by Ayush Jain at http://www.geeksforgeeks.org/quick-ways-to-check-for-prime-and-find-next-prime-in-java/
        BigInteger b = new BigInteger(String.valueOf(target));
        return b.isProbablePrime(1);
    }

}
