package Communication;

public class Container {
    private boolean isEmpty;
    private Food food;
    public Container(){
        isEmpty=true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
class Food{
    String name;
    int price;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }
}