import java.util.*;

/**
 * Created by yong on 2018. 8. 6..
 */

class Nation implements Comparable<Nation>{
    private int num;
    private int gold;
    private int silver;
    private int bronze;
    private int rank;

    public Nation(int num, int gold, int silver, int bronze){
        this.num    = num;
        this.gold   = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank   = 1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Nation nation) {
        if(this.gold > nation.gold){
            return -1;
        }else if(this.gold == nation.gold){

            if(this.silver > nation.silver){
                return - 1;
            }else if(this.silver == nation.silver){
                if(this.bronze > nation.bronze){
                    return -1;
                }else if(this.bronze == nation.bronze){
                    return 0;
                }
            }
        }

        return 1;
    }
}

public class Practice11 {

    public static void main(String[] args){

        /*
        *  문제 : 올림픽 (백준 8979번)
        *  입력 : 입력의 첫 줄은 국가의 수 N(1 ≤ N ≤ 1,000)과 등수를 알고 싶은 국가 K(1 ≤ K ≤ N)가 빈칸을 사이에 두고 주어진다.
        *        각 국가는 1부터 N 사이의 정수로 표현된다. 이후 N개의 각 줄에는 차례대로 각 국가를 나타내는 정수와 이 국가가 얻은 금, 은, 동메달의 수가 빈칸을 사이에 두고 주어진다.
        *        전체 메달 수의 총합은 1,000,000 이하이다.
        *  출력 : 출력은 단 한 줄이며, 입력받은 국가 K의 등수를 하나의 정수로 출력한다. 등수는 반드시 문제에서 정의된 방식을 따라야 한다.
        * */


        Scanner scan = new Scanner(System.in);
        String[] firstLine = scan.nextLine().split(" ");

        int inputNum        = Integer.parseInt(firstLine[0]);
        int nation          = Integer.parseInt(firstLine[1]);
        Nation[] nationArr  = new Nation[inputNum];

        for(int i = 0; i < inputNum; i++){

            String[] line = scan.nextLine().split(" ");
            nationArr[i] = new Nation(
                    Integer.parseInt(line[0]),
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2]),
                    Integer.parseInt(line[3])
            );

        }

        Arrays.sort(nationArr);

        calcRank(nationArr);
        /*
        System.out.println("sort하기 전");

        for(int i = 0; i < inputNum; i++){
            System.out.println(nationArr[i]);
        }

        Arrays.sort(nationArr);

        System.out.println("sort한 후");

        Nation.calcRank(nationArr);

        for(int i = 0; i < inputNum; i++){
            System.out.println(nationArr[i]);
        }

        System.out.println("상태");
        */
        for(int i = 0; i < inputNum; i++) {
            if(nationArr[i].getNum() == nation) {
                System.out.println(nationArr[i].getRank());
                break;
            }
        }
    }

    public static void calcRank(Nation[] nationArr) {
        for(int i = 1; i < nationArr.length; i++) {
            if(nationArr[i].getGold() == nationArr[i-1].getGold()
                    && nationArr[i].getSilver() == nationArr[i-1].getSilver()
                    && nationArr[i].getBronze() == nationArr[i-1].getBronze()) {
                nationArr[i].setRank(nationArr[i-1].getRank());
            } else {
                nationArr[i].setRank(i+1);
            }
        }
    }

}


