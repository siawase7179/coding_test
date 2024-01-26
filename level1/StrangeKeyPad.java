package level1;

import java.util.*;

public class StrangeKeyPad {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        answer = new int[keymap.length];
        HashMap<Character, Integer> keypad = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            for (int j =0; j<keymap[i].length(); j++){
                if (keypad.containsKey(keymap[i].charAt(j))){
                    int min = Math.min(keypad.get(keymap[i].charAt(j)), j+1);
                    keypad.put(keymap[i].charAt(j), min);
                }else{
                    keypad.put(keymap[i].charAt(j), j+1);
                }
            }
        }

        for (int i=0; i<targets.length; i++){
            int count=0;
            boolean fail = false;
            for (int j=0; j<targets[i].length(); j++){
                if (keypad.containsKey(targets[i].charAt(j))){
                    count += keypad.get(targets[i].charAt(j));
                }else{
                    fail= true;
                    break;
                }
            }
            answer[i] = fail == true ? -1 : count;
        }
        return answer;
    }
    public static void main(String[] args){
        String[] keymap = {"ABACD", "BCEFD"};
        String[] target = {"ABCD","AABB"};
        StrangeKeyPad sol = new StrangeKeyPad();
        System.out.println(Arrays.toString(sol.solution(keymap, target)));
    }
}
