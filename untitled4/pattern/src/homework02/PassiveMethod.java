package homework02;

public class PassiveMethod implements Passive {
    int j=1;
    @Override
    public void abc(int num) {
        for(int i=0;i<num;i++){
             j=j+1;
        }
    }
}
