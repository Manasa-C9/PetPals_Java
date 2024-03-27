package com.mns;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public void recordDonation() {
        System.out.println("Item donation of type '" + itemType + "' recorded by " + getDonorName() + " of amount $" + getAmount());
    }

    
}
