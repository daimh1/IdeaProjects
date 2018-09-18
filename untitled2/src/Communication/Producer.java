package Communication;

import java.util.Random;

public class Producer implements Runnable{
    Container container;
    private Food[] foodMenu={
            new Food("a",10),
            new Food("b",3),
            new Food("豆沙包", 1),
            new Food("蟹黄包", 100),
            new Food("牛肉包", 20),
            new Food("烧麦", 2)};
    public Producer(Container container){
        this.container=container;
    }
    @Override
    public void run() {
        while (true){
            synchronized (container){
                if(!container.isEmpty()){
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    Food food=makeFood();
                    container.setFood(food);
                    System.out.println("放包子："+food);
                    container.setEmpty(false);
                    container.notify();
                }
            }
        }
    }
    private Food makeFood(){
        Random random=new Random();
        int i=random.nextInt();
        while (i<0){
            i=random.nextInt();
        }
        return foodMenu[i%foodMenu.length];
    }
}
