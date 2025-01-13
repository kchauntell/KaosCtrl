package com.kchauntell.KaosCtrl_Backend.Services.ListsServices;

import com.kchauntell.KaosCtrl_Backend.Entity.GeneralStatus;
import com.kchauntell.KaosCtrl_Backend.Entity.Lists;
import java.util.List;
import java.util.Optional;

public interface ListApplication {
    public List<Lists> findAllLists();
    public Optional<Lists> findListById(Integer id);
    public Optional<Lists> findListByCategory(String category);
    public GeneralStatus createLists(Lists lists) throws Exception;
    public Lists updateLists(Lists lists) throws Exception;
    public void deleteLists(Lists lists) throws Exception;
}
