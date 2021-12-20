package hello.itemservice.domain.item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


class ItemRepositoryTest {

ItemRepository itemRepository=new ItemRepository();


    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void Save(){
        Item item=new Item("itemA",1000,10);//item생성
        Item saveItem=itemRepository.save(item);//item저장
        Item findItem =itemRepository.findById(item.getId()); //
        Assertions.assertThat(findItem).isEqualTo(saveItem);//가지고 오는게 맞는지 확인

    }

    @Test
    void find(){
        Item item1=new Item("itemA",1000,10);
        Item item2=new Item("itemB",1000,10);

        itemRepository.save(item1);
        itemRepository.save(item2);
        List<Item> result=itemRepository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }


}
