package homework1;

import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    private double boxVolume;
    private double maxBoxVolume = 5.0d;
    private ArrayList<T> box = new ArrayList<>();
    private float weight;

    public FruitBox() {
        boxVolume = 0d;
    }

    public void add(T fruit) {
        if (isFullFruitBox()) return;
        box.add(fruit);
        boxVolume += fruit.weight;
    }

    public float getWeight() {
        for (T t : box) {
            weight += t.weight;
        }
        return weight;
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public int getSize() {
        return box.size();
    }

    public boolean compare(FruitBox<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void putInAnotherBox(FruitBox<T> newBox) {
        boxVolume = newBox.weight;
        for (int i = 0; i < box.size(); i++) {
            if (isFullFruitBox()) return;
            newBox.box.add(box.get(i));
            box.remove(i);
        }
    }

    private boolean isFullFruitBox() {
        if (boxVolume + 1 > maxBoxVolume) {
            System.out.println("The box is already full");
            return true;
        } else {
            return false;
        }
    }
}
