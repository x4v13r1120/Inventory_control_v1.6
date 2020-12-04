package Restaurant;

import java.math.BigDecimal;

public class Item {

    //attributes of item
    private String item_name;
    private Integer item_id;
    private BigDecimal price_per_unit;
    private String item_type;
    private Integer quantity;

    //GETTERS AND SETTERS
    public BigDecimal getPricePerUnit() {
        return price_per_unit;
    }

    public void setPricePerUnit(BigDecimal price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public int getIdNumber() {
        return item_id;
    }

    public void setIdNumber(Integer idNumber) {
        this.item_id = idNumber;
    }

    public String getName() {
        return item_name;
    }

    public void setName(String name) {
        this.item_name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }
}