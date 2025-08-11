package data;

import java.util.List;

public class IStoreImpl implements IStore {

    public List<String> getTags(){
        return Store.getTags();
    }
    public void delete(String tag){
        Store.delete(tag);
    }
    public void insert(String tag){
        Store.insert(tag);
    }
}
