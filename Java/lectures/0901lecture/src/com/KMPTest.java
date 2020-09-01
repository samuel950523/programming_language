package com;

import java.util.Arrays;

//우리는 “접두사와 접미사가 같은 최대 길이”를 구하고 있다. 그렇다면 첫 문자열이 다르다는 것은 그 뒤의 문자열을 비교할 가치도 없게 되는 것이다.
public class KMPTest {

    public static void main(String[] args) {
        String pattern = "ABABACA";
        System.out.println(Arrays.toString(getPI(pattern)));
    }

    static int[] getPI(String p) {

        int[] pi = new int[p.length()];

    // i 개의 부분 문자열을 만들면서 접두, 접미가 일치하는 최대 값을 각 문자열별로 계산한다.
    // i == 0 <-- 0
    // 패턴의 부분 문자열의 2개 3개 4개를 만드는 방법은?
    //  i 가 증가하면 0 ~ i 번째 문자열이 부분 문자열이 됨.
    //  하지만 i 가 증가할 때마다 0 ~ i 까지 계속 새로 계산하지 않음.
    //  i-1 단계 까지의 결과값을 활용함.
    //  i 는 1 부터 계속 증가하므로 접두, 접미 비교를 위한 새로운 변수 j 를 사용
    // j 는 최초 0 으로 시작, 
    //        이후 i와 일치하는 상황이면 1 증가하고 그 값을 pi[i] 값으로 입력
    //        i와 일치하지 않는 상황이면 일치하거나 0 이 될 때까지 이전 pi[] 값으로 변경
    //
    for( int i=1, j=0; i<p.length(); i++) {

        while( j>0 && p.charAt(i) != p.charAt(j) ) {
            j = pi[j-1]; //
        }

        if( p.charAt(i) == p.charAt(j) ) pi[i] = ++j;
    }
    
    return pi;
}
}
/*

pi[0] = 0         

    i=1                AB --> 0
(접미) A B A A B A B 
(접두)   A B A A B A B
        j=0

    i=1                AB --> 0
(접미) A B A A B A B 
(접두)   A B A A B A B
        j=0

*/