package RSA;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public static void main(String[] args) {
        //产生两个素数
        /*System.out.println(BigInteger.probablePrime(10,new Random()));
        System.out.println(BigInteger.probablePrime(10,new Random()));*/
        //881,757
        //获得两个素数的乘积，和两个素数减一的乘积
        /*System.out.println(881*757);
        System.out.println((881-1)*(757-1));*/
        //666917,665280
        //随机获得一个素数作为公钥，公钥不能与一开始产生的素数相等且要小于一开始产生2个素数减一的乘积
      /*System.out.println(BigInteger.probablePrime(10,new Random()));*/
        //631
        //获取私钥:358471
        /*for(Integer i=0;i<665280;i++){
            if((631 * i)%665280==1){
                System.out.println("私钥"+i);
            }
        }*/
        //使用公钥模指运算(实质为加密数据的xx-1次方除以xx数)加密数据为123456
        System.out.println(new BigInteger("123456").modPow(new BigInteger("631"),new BigInteger("666917")));
        //加密后数据30215
        //使用私钥模指运算解密
        System.out.println(new BigInteger("30215").modPow(new BigInteger("358471"),new BigInteger("666917")));
    }
}
