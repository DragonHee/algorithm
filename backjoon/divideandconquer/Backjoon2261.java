package backjoon.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//x, y 좌표를 가지고 x오름차순 정렬을 위한 COmparable 인터페이스 구현.
class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        int result = this.x - o.x;
        if(result == 0) result = this.y - o.y;

        return result;
    }
}
// y좌표 오름차순 정렬을 위한 클래스
class YComparator implements Comparator<Point>{
    @Override
    public int compare(Point o1, Point o2) {
        return o1.y - o2.y;
    }
}
public class Backjoon2261 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        // x 좌표 오름차순으로 정렬.
        Collections.sort(list);
        System.out.println(closestDist(list, 0, n - 1));
    }
    // 피타고라스 정리를 이용한 거리 구하는 공식
    public static int findDist(Point x, Point y){
        return (x.x - y.x) * (x.x - y.x) + (x.y - y.y) * (x.y - y.y);
    }

    // 모든 점의 거리를 구하여 최고값을 반환하는 함수 시간복잡도(O(n^2))
    public static int bruteForce(List<Point> list, int start, int end){
        int ans = -1;

        for(int i = start; i <= end - 1; i++){
            for(int j = i + 1; j <= end; j++){
                int dist = findDist(list.get(i), list.get(j));
                if(ans == -1 || ans > dist)
                    ans = dist;
            }
        }
        return ans;
    }

    public static int closestDist(List<Point> list, int start, int end){
        // 크기가 3이하일 경우 완전 탐색
        if(end - start <= 2) return bruteForce(list, start, end);

        // 중간에 기준점을 지정
        int mid = (start + end) >> 1;
        // 기준점 왼쪽 중 최소값
        int left = closestDist(list, start, mid);
        // 기준점 오른쪽 중 최소값
        int right = closestDist(list, mid + 1, end);
        // 왼쪽 최소값, 오른쪽 최소값 중 최소값 저장
        int minDist = Math.min(left, right);

        // minDist 보다 x좌표 상 큰 값은 배제하고 나머지를 List에 저장
        List<Point> yList = new ArrayList<>();

        for(int i = start; i <= end; i++){
            int d =list.get(mid).x - list.get(i).x;
            if(minDist > d * d)
                yList.add(list.get(i));
        }

        // y좌표 오름차순 정렬
        Collections.sort(yList, new YComparator());

        int yListSize = yList.size();
        // 맨 처음부터 y좌표 차이가 minDist 보다 큰 경우 배제하고 계산
        for(int i = 0; i < yListSize - 1; i++){
            for(int j = i + 1; j < yListSize; j++){
                int yDist = yList.get(j).y - yList.get(i).y;
                if(minDist < yDist * yDist) break;

                int dist = findDist(yList.get(i), yList.get(j));
                if(dist < minDist)
                    minDist = dist;
            }
        }
        return minDist;
    }
}
