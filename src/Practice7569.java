import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Practice7569 {
    public static void main(String[] args) throws Exception {

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
