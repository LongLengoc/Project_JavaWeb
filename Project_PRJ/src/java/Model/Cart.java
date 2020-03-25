/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cart {
    // Danh sach san pham
    private List<Item> items;
    
    public Cart() {
        items = new ArrayList<>();
    }
    
    // Them san pham vao gio hang
    public void add (Item it) {
        for (Item x: items)
            // Neu ma san pham them vao trung vs
            // ma san pham da co thi cong so luong sp len 1
            if (it.getMahang().equalsIgnoreCase(x.getMahang())) {
                x.setSoluong(x.getSoluong() + 1);
                return;
            }
        // Neu id san phan them vao ko trung vs
        // id san pham nao thi them san pham do vao gio hang
        items.add(it);
    }
    
    // Xoa san pham khoi gio hang
    public void remove (String mahang) {
        for (int i = 0; i < items.size(); i ++) {
            if (items.get(i).getMahang() == mahang) {
                items.remove(i);
            }
        }
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public int getAmount() {
        int m = 0;
        for (Item x: items) {
            m += x.getSoluong() * x.getGia();
        }
        return m;
    }
}
