package src.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by yongjin on 2018-09-21.
 */
public class Programmers42576 {

    public static void main(String[] args) {
        /**
         * description : 프로그래머스 42576번 참가자 배열과 완주자 배열이 주어지고
         *               참가자 중 한 사람은 완주자 배열에서 제외되어 있다.
         *               주의) 참가자명은 중복이 존재할 수 있다.
         * solution : 1. 해쉬맵을 하나 만들고 해쉬맵에 key : 참가자명, value : 숫자로 저장한다.
         *            2. 참가자 명의 중복이 존재 할 수 있으므로 key가 이미 있을 경우 value에 + 1를 해준다.
         *            3. 완주자 배열을 돌면서 hm에 value가 1이면 삭제, 1이상이면 value 값을 -1 해준다.
         *            4. 마지막으로 남는 hm의 값을 출력한다.
         */
        Map<String, Integer> hm = new HashMap<>();

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        int participantLength = participant.length;
        int completionLength = completion.length;

        for(int i = 0; i < participantLength; i++) {
            if(hm.containsKey(participant[i])) {
                if (hm.get(participant[i]) >= 1) {
                    hm.put(participant[i], hm.get(participant[i]) + 1);
                }
            }else{
                hm.put(participant[i], 1);
            }
        }

        for(int i = 0; i < completionLength; i++){
            if(hm.containsKey(completion[i])) {
                if (hm.get(completion[i]) == 1) {
                    hm.remove(completion[i]);
                }else{
                    hm.put(completion[i], hm.get(completion[i]) - 1);
                }
            }
        }

        for( String key : hm.keySet() ) {
            System.out.println(key);
        }
    }
}
