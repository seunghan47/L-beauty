package com.paulim.lbeauty.newitem;

import java.util.List;

public interface NewItemService {
    NewItem saveNewItem(NewItem item);
    List<NewItem> getAll();

}
