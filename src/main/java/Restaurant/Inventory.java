package Restaurant;


import mangement.inventoryManagement;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Inventory {
    inventoryManagement manager;

    private BigDecimal price;

    //prompts user for new item specs.  Only a manager option
    //should add to database/file
    public void addItem() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Item item = new Item();

        System.out.println("Please enter item name.");
        item.setName(scanner.nextLine());

        System.out.println("Please enter the item type.");
        item.setItem_type(scanner.nextLine());

        System.out.println("Please enter the price per unit.");
        setPrice(scanner.nextBigDecimal());
        item.setPricePerUnit(getPrice());

        System.out.println("Please enter the quantity.");
        item.setQuantity(scanner.nextInt());

        System.out.println("Thank you, your item has been added.");

        manager.add(item.getName(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());

    }

    //prompts user for item id to delete. deletes item from inventory Only a manager option
    //should remove from database
    public void deleteItem() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What item are you removing ? Please type the item id number.");
        int itemId = (scanner.nextInt());

        System.out.println("Thank you, your item has now been deleted.");
        manager.delete(itemId);

    }

    //prints entire database
    public void printItems() {
        manager.selectAll();
    }

    //ask user if they want to change any aspect of an item only a manager option
    public void updateItem() throws IOException {
        Item item = new Item();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the id of the item you wish to select.");
        item.setIdNumber(scanner.nextInt());

        System.out.println("Enter new name or current name if no change.");
        item.setName(scanner.nextLine());

        System.out.println("Enter new price per unit or current price if no change.");
        item.setPricePerUnit(scanner.nextBigDecimal());

        System.out.println("Enter new item type or current if no change.");
        item.setItem_type(scanner.nextLine());

        System.out.println("Enter new quantity or current if no change.");
        item.setQuantity(scanner.nextInt());

        //String item_name, int item_Id, BigDecimal price_per_unit, String item_type, int quantity

        manager.update(item.getIdNumber(), item.getName(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());

    }

    //getters and setters

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
