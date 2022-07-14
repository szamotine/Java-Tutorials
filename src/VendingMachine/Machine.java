package VendingMachine;

public class Machine {
    private  Item[][] items;

    public Machine(Item[][] source) {
        items = new Item[3][3];

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                this.items[i][j] = new Item (source[i][j]);
            }
        }
    }

    public String toString(){
        String temp = "";

        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                if (items[i][j] != null){
                    temp += "\n Item name: " + items[i][j].getName() + "\tPrice: " + items[i][j].getPrice() + "\t\t" +
                            "Quantity" +
                            ": " + items[i][j].getQuantity();
                }

            }
        }
        return temp;
    }

    public boolean dispense(int row, int column){
        if (items[row][column].getQuantity()>0){
            items[row][column].setQuantity(items[row][column].getQuantity()-1);
            return true;
        }else return false;

    }


    //region Getter, Setter
    public Item getItems(int row, int column) {
        return items[row][column];
    }

    public void setItems(Item item, int row, int column) {
        this.items[row][column] = new Item(item);
    }
    //endregion
}
