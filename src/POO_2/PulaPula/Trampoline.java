package POO_2.PulaPula;

import java.util.ArrayList;
import java.util.List;

public class Trampoline {
    private List<Kid> playing;
    private List<Kid> waiting;
    
    
    public Trampoline() {
        this.playing = new ArrayList<>();
        this.waiting = new ArrayList<>();
    
    }
    
    private static Kid removeFromList(String name, List<Kid> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return list.remove(i);
            }
        }
        return null;
    }
    
    public void arrive(Kid kid) {
        waiting.add(0, kid);
        
    }
    
    public void enter() {
        if(!waiting.isEmpty()) {
            Kid kid = waiting.remove(waiting.size() - 1);
            playing.add(0, kid);
        }
    }
    
    public void leave() {
        if(!playing.isEmpty()) {
            Kid kid = playing.remove(playing.size() - 1);
            waiting.add(0, kid);
        }
    }
    
    public Kid removeKid(String name) {
        Kid kid = removeFromList(name, waiting);
        if(kid == null) {
            kid = removeFromList(name, playing);
        }
        
        return kid;
    }
    
    @Override
    public String toString() {
        return waiting.toString() + " => " + playing.toString();
    }
}
