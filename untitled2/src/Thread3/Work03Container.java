package Thread3;

public class Work03Container {
    boolean isEmpty = true;
    Bullet bullet;
    static int m=0;//让程序停止

    public synchronized Bullet chargeBullet() {
        if (isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.isEmpty = true;
            System.out.println("装弹：" + this.bullet);
            m++;
            this.notify();
            return this.bullet;
        }
        return null;
    }

    public synchronized void shootBullet(Bullet bullet) {
        if (!isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.bullet=bullet;
            isEmpty = false;
            System.out.println("射击：" + this.bullet.toString());
            m++;
            this.notify();
        }
    }
}

class Bullet {
    @Override
    public String toString() {
        return "Bullet{}";
    }
}