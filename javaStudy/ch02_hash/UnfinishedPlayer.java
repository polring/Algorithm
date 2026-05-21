package javaStudy.ch02_hash;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * programmers : 완주하지 못한 선수
 * 유형 : 해시를 이용한 빈도수 세기 and 차집합
 *
 */
public class UnfinishedPlayer {

    public  String solution(String[] participant, String[] completion){
        Map<String,Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        for(String c : completion){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
        }

        for (String s : map.keySet()) {
            if(map.get(s) > 0){
                return s;
            }
        }
        return "";
    }
}
class unifinishedPlayerTest{
    UnfinishedPlayer solver = new UnfinishedPlayer();
    @Test
    void 테스트_케이스(){

        assertThat(solver.solution(new String[]{"leo", "kiki"}, new String[]{"kiki"})).isEqualTo("leo");

    }
    @Test
    @DisplayName("동명이인이 있는 경우")
    void test1() {
        UnfinishedPlayer solver = new UnfinishedPlayer();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        assertThat(solver.solution(participant, completion)).isEqualTo("mislav");
    }


}
