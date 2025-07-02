package POO_2.Porquinho;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pig {
    private boolean broken;
    private List<Coin> coins;
    private List<Item> items;
    private final int volumeMax;

    public Pig(int volumeMax) {
        this.volumeMax = volumeMax;
        this.broken = false;
        this.coins = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public boolean addCoin(Coin coin) {
        if (this.isBroken()) {
            throw new RuntimeException("fail: the pig is broken");
        }
        if (this.getVolume() + coin.getVolume() > this.getVolumeMax()) {
            throw new RuntimeException("fail: the pig is full");
        }
        this.coins.add(coin);
        return true;
    }

    public boolean addItem(Item item) {
        if (this.isBroken()) {
            throw new RuntimeException("fail: the pig is broken");
        }
        if (this.getVolume() + item.getVolume() > this.getVolumeMax()) {
            throw new RuntimeException("fail: the pig is full");
        }
        this.items.add(item);
        return true;
    }

    public boolean breakPig() {
        if (!this.isBroken()) {
            this.broken = true;
            return true;
        }
        return false;
    }

    public List<Coin> extractCoins() {
        if (!this.isBroken()) {
            throw new RuntimeException("fail: you must break the pig first");
        }
        List<Coin> extractedCoins = new ArrayList<>(this.coins);
        this.coins.clear();
        return extractedCoins;
    }

    public List<Item> extractItems() {
        if (!this.isBroken()) {
            throw new RuntimeException("fail: you must break the pig first");
        }
        List<Item> extractedItems = new ArrayList<>(this.items);
        this.items.clear();
        return extractedItems;
    }

    public double getValue() {
        return this.coins.stream().mapToDouble(Coin::getValue).sum();
    }
    
    public int getVolume() {
        if (this.isBroken()) {
            return 0;
        }
        int totalVolume = 0;
        for (Coin coin : this.coins) {
            totalVolume += coin.getVolume();
        }
        for (Item item : this.items) {
            totalVolume += item.getVolume();
        }
        return totalVolume;
    }
    
    public int getVolumeMax() {
        return this.volumeMax;
    }

    public boolean isBroken() {
        return this.broken;
    }

    @Override
    public String toString() {
        String state = this.isBroken() ? "broken" : "intact";
        String valueStr = String.format("%.2f", this.getValue());
        
        return String.format("state=%s : coins=%s : items=%s : value=%s : volume=%d/%d",
                state,
                this.coins.toString(),
                this.items.toString(),
                valueStr,
                this.getVolume(),
                this.getVolumeMax());
    }
}
