import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Practice7568 {
    public static void main(String[] args) throws Exception {
        /**
         * description : 백준 7568번 덩치
         * solution : 1. weight 와 height 를 가진 Person 객체를 만든다.
         *            2. 모든 객체를 loop 를 돌면서 비교하여 랭킹을 구한다.
         *            * Comparable 를 사용하여 더 깔끔하게 코드를 짤 수 있겠지만, 일단은 생각나는 데로 코드를 작성하였음.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];
        for(int i = 0; i < N; i++) {
            String[] strs = br.readLine().trim().split(" ");
            person[i] = Person.of(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        }

        for (Person person1 : person) {
            for (Person person2 : person) {
                person1.ranking(person2);
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(person[i].getRanking() + " ");
        }
    }
}

class Person {
    private int weight;
    private int height;
    private int ranking = 1;

    private Person () {}
    private Person (int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public static Person of(int weight, int height) {
        return new Person(weight, height);
    }

    public void ranking(Person person) {
        if (isLowRanking(person)) {
            this.ranking++;
        }
    }

    private boolean isLowRanking(Person person) {
        return this.weight < person.weight && this.height < person.height;
    }

    public int getRanking() {
        return ranking;
    }
}
