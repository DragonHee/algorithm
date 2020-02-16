package backjoon.coopang2020_1;

import java.util.Arrays;

public class problem1 {
    static class Good implements Comparable<Good>{
        int price;
        int cnt;

        public Good(int price, int cnt){
            this.price = price;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Good o) {
            return o.price - price;
        }
    }

    static class Coupon implements Comparable<Coupon>{
        int sales;
        int cnt;

        public Coupon(int sales, int cnt) {
            this.sales = sales;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Coupon o) {
            return o.sales - sales;
        }
    }
    public static void main(String[] args) {
        int[][] goods = {{3100,2}, {7700,1},{3100, 2}};
        int[][] coupons = {{33, 4}};
        solution(goods, coupons);
    }

    public static long solution(int[][] goods, int[][] coupons){
        long answer = 0;
        int couponIndex = 0;

        Good goodArr[] = new Good[goods.length];
        Coupon couponArr[] = new Coupon[coupons.length];

        for(int i = 0 ; i < goods.length; i++){
            for(int j = 0 ; j < goods[0].length; j++){
                goodArr[i] = new Good(goods[i][0], goods[i][1]);
            }
        }

        for(int i = 0 ; i < coupons.length; i++){
            for(int j = 0 ; j < coupons[0].length; j++){
                couponArr[i] = new Coupon(coupons[i][0], coupons[i][1]);
            }
        }

        Arrays.sort(goodArr);
        Arrays.sort(couponArr);

        for(int i = 0; i < goodArr.length; i++){
            while(true){
                if(goodArr[i].cnt == 0) break;

                if(couponIndex >= couponArr.length){
                    answer += goodArr[i].price;
                    goodArr[i].cnt--;
                }else{
                    answer += goodArr[i].price * (100 - couponArr[couponIndex].sales) / 100;
                    goodArr[i].cnt--;
                    couponArr[couponIndex].cnt--;

                    if(couponArr[couponIndex].cnt == 0) couponIndex++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
