package Section19.Model;

public class Store {
    private Item[][] items;
    public Store() {
        this.items = new Item[7][3]; // [
    }
    public Item getItems (int row, int column) {
        if(row < items.length && column < items[row].length){
            return new Item (this.items[row][column]);
        }else {
            System.out.println("Invalid aisle/row selection");
            return null;
        }

    }
    public void setItems(int row, int column, Item item) {
        this.items[row][column] = new Item (item);
    }
    public String toString(){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            switch (i) {
                case 0: temp.append("\tDRINKS:        "); break;
                case 1: temp.append("\tCEREAL:        "); break;
                case 2: temp.append("\tDAIRY:         "); break;
                case 3: temp.append("\tDELI:          "); break;
                case 4: temp.append("\tGREENS:        "); break;
                case 5: temp.append("\tCLOTHING:      "); break;
                case 6: temp.append("\tELECTRONICS:   "); break;
            }
            for (int j = 0; j < items[i].length; j++) {
                temp.append(items[i][j].toString()).append("\t\t");
            }
            temp.append("\n\n");
        }
        return temp.toString();
    }

}
