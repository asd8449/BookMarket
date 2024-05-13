package bookmarket.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> itemList = new ArrayList<>();
    int numItems = 0;

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public int getNumItems() {
        return itemList.size();
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public List<CartItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<CartItem> itemList) {
        this.itemList = itemList;
    }

    public String getItemInfo(int index) {
        return itemList.get(index).toString();
    }

    public void addItem(Book book) {
        CartItem item = getCartItem(book);
        if (item == null) {
            itemList.add(new CartItem(book));
        } else {
            item.addQuantity(1);
        }
    }

    private CartItem getCartItem(Book book) {
        for (int i = 0 ; i < getNumItems() ; i++) {
            if (itemList.get(i).getBook() == book) {
            	System.out.println(itemList.get(i).getBook().toString());
                return itemList.get(i);
            }
        }
        return null;
    }

    public boolean deleteItem(Book book) {
    	CartItem item = getCartItem(book);
    	if(item == null)return false;
    	else {
    		itemList.remove(itemList.indexOf(item));
    		return true;
    	}
    }

    public void resetCart() {
        itemList.clear();
//        this.itemList = new CartItem[64];
    }
}
