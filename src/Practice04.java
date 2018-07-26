import java.util.*;

/**
 * Created by yong on 2018. 7. 24..
 */
public class Practice04 {
    public static void main(String[] args) {
        /*
        *
        * 표준 출력으로 총 N 줄을 출력한다.
        * 출력의 i번째 (1 ≤ i ≤ N) 줄에 정확히 한 글자를 출력하는데, 출력하는 글자는 A, B, D 중 하나로 라운드 i의 결과를 나타낸다.
        * 각 라운드의 결과는 A가 승자라면 A, B가 승자라면 B, 무승부라면 D이다
        *
        * CASE 1
        *   input
        *   5
            1 4
            4 3 3 2 1
            5 2 4 3 2 1
            4 4 3 3 1
            4 3 2 1 1
            4 2 3 2 1
            4 4 3 2 1
            3 4 3 2
            5 4 4 2 3 1
            5 4 2 4 1 3

            output
            A
            B
            B
            A
            D

          CASE 2

            input
            4
            4 4 3 2 1
            4 1 4 3 2
            4 3 3 2 1
            4 4 3 3 3
            4 4 3 3 3
            4 3 4 3 2
            4 3 2 1 1
            3 3 2 1

            output
            D
            B
            A
            A
        * */
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        int round;
        round = scan1.nextInt();


        List<String> strList1 = new ArrayList<String>();
        List<String> strList2 = new ArrayList<String>();
        List<String> resultArr = new ArrayList<String>();

        for (int i = 0; i < round * 2; i++) {
            String a;
            a = scan2.nextLine();
            if((i % 2) == 0){
                //짝수 번째
                strList1.add(a);
            }else{
                strList2.add(a);
            }
        }

        System.out.print(strList1);
        System.out.print(strList2);

        int idx = strList1.size();

        for (int i = 0; i < idx; i++) {

            String a = strList1.get(i);
            String b = strList2.get(i);
            //Scanner로 가져온 값 세팅
            String[] arrA = a.split(" ");
            String[] arrB = b.split(" ");


            if (round * 2 > 1000) {
                System.out.println("라운드 수는 최대 500번 입니다.");
                return;
            }

            int arrALen = arrA.length;
            int arrBLen = arrB.length;

            if ((arrALen < 1 || arrALen > 100) && (arrBLen < 1 || arrBLen > 100)) {
                System.out.println("a와 b의 총 개수는 1 이상 100 이하 입니다.");
                return;
            }

            //자료 구조 선언
            Map<Integer, Integer> mapA = new HashMap<Integer, Integer>(); //A의 자료구조
            Map<Integer, Integer> mapB = new HashMap<Integer, Integer>(); //B의 자료구조


            mapA.put(4, 0); // 별
            mapA.put(3, 0); // 네모
            mapA.put(2, 0); // 동그라미
            mapA.put(1, 0); // 세모

            mapB.put(4, 0); // 별
            mapB.put(3, 0); // 네모
            mapB.put(2, 0); // 동그라미
            mapB.put(1, 0); // 세모


            // arrA 세팅
            Map<Integer, Integer> hmA = setMapCnt(arrA, mapA);

            // arrB 세팅
            Map<Integer, Integer> hmB = setMapCnt(arrB, mapB);


            //System.out.println(hmA);
            //System.out.println(hmB);

            String result = getResult(hmA,hmB);
            resultArr.add(result);
        }

        for(int i = 0; i < resultArr.size(); i++){
            System.out.print(resultArr.get(i));
        }
    }

    public static Map<Integer, Integer> setMapCnt(String[] arr, Map<Integer, Integer> hm){
        for (int i = 0; i < arr.length; i++){

            int arrBInt = Integer.parseInt(arr[i]);

            if(arrBInt == 1){
                int triSum = hm.get(1); //세모의 갯수
                hm.put(1, (triSum + 1));
            }else if(arrBInt == 2){
                int cirSum = hm.get(2); //동그라미의 갯수
                hm.put(2, (cirSum + 1));
            }else if(arrBInt == 3){
                int recSum = hm.get(3); //네모의 갯수
                hm.put(3, (recSum + 1));
            }else{
                int starSum = hm.get(4); //별의 갯수
                hm.put(4, (starSum + 1));
            }
        }

        return hm;
    }

    public static String getResult(Map<Integer,Integer> hmA, Map<Integer,Integer> hmB){

        //System.out.println("A = " + hmA.get(4));
        //System.out.println("B = " + hmB.get(4));

        if(hmA.get(4) > hmB.get(4)){ // 별 갯수 비교
            //System.out.println("A 큼");
            return "A";
        }else if(hmA.get(4) == hmB.get(4)){
            //System.out.println("A B 같음");
            if(hmA.get(3) > hmB.get(3)){ // 별 갯수 비교
                return "A";
            }else if(hmA.get(3) == hmB.get(3)){
                if(hmA.get(3) > hmB.get(3)){ // 별 갯수 비교
                    return "A";
                }else if(hmA.get(3) == hmB.get(3)){
                    if(hmA.get(2) > hmB.get(2)){ // 별 갯수 비교
                        return "A";
                    }else if(hmA.get(2) == hmB.get(2)){
                        if(hmA.get(1) > hmB.get(1)){ // 별 갯수 비교
                            return "A";
                        }else if(hmA.get(1) == hmB.get(1)){
                            return "D";
                        }else{
                            return "B";
                        }

                    }else{
                        return "B";
                    }

                }else{
                    return "B";
                }
            }else{
                return "B";
            }
        }else{
            //System.out.println("B가 큼");
            return "B";
        }
    }
}
