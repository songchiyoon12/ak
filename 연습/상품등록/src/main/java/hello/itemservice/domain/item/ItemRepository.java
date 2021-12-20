package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
private static final Map<Long,Item> store=new HashMap<>();
private static long sequence=0L;

public Item save(Item item){
    item.setId(++sequence);
    store.put(item.getId(),item);
    return item;
}

public Item findById(Long id){
    return store.get(id);
}
public List<Item> findAll(){
    return new ArrayList<Item>(store.values());
}

public void clearStore(){
    store.clear();
}
public void update(Long itemid ,Item updateItem){
    Item findItem=findById(itemid);
    findItem.setItemName(updateItem.getItemName());
    findItem.setPrice(updateItem.getPrice());
    findItem.setQuantity(updateItem.getQuantity());

}



}
