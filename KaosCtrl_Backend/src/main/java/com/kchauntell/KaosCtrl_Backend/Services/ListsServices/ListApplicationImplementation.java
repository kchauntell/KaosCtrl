package com.kchauntell.KaosCtrl_Backend.Services.ListsServices;

import com.kchauntell.KaosCtrl_Backend.DAO.ListRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.GeneralStatus;
import com.kchauntell.KaosCtrl_Backend.Entity.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ListApplicationImplementation implements ListApplication {
    @Autowired
    public ListRepository listRepository;

    public ListApplicationImplementation(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public List<Lists> findAllLists() {
        return listRepository.findAll();
    }

    @Override
    public Optional<Lists> findListById(Integer id) {
        return listRepository.findById(id);
    }

    @Override
    public Optional<Lists> findListByCategory(String category) {
        return listRepository.findByCategory(category);
    }

    @Override
    public GeneralStatus createLists(Lists newLists) {
        Optional<Lists> existingLists = listRepository.findById(newLists.getId());
        if (existingLists.isPresent()) {
            System.out.println("List Item Already Created For This Board");
            return GeneralStatus.ALREADY_EXISTS;
        }

        this.listRepository.save(newLists);
        return GeneralStatus.SUCCESS;
    }

    @Override
    public Lists updateLists(Lists newLists) throws Exception {
        Optional<Lists> listToUpdateOptional = listRepository.findById(newLists.getId());
        if (listToUpdateOptional.isEmpty()) {
            return null;
        }

        Lists listToUpdate = listToUpdateOptional.get();

        if(newLists.getCategory() != null){
            listToUpdate.setCategory(newLists.getCategory());
        }
        if(newLists.getPosition() != null) {
            listToUpdate.setPosition(newLists.getPosition());
        }
        listToUpdate.setUpdatedAt(LocalDateTime.now());
        return this.listRepository.save(listToUpdate);
    }

    @Override
    public void deleteLists(Lists list) throws Exception {
        int id = list.getId();

        Optional<Lists> listToDeleteOptional = this.listRepository.findById(id);
        if (listToDeleteOptional.isEmpty()) {
            throw new Exception("List Not Found");
        }
        Lists listToDelete = listToDeleteOptional.get();
        this.listRepository.delete(listToDelete);
    }
}
