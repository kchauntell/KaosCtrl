package com.kchauntell.KaosCtrl_Backend.Controller;

import jakarta.validation.Valid;
import com.kchauntell.KaosCtrl_Backend.DAO.ListRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Lists;
import com.kchauntell.KaosCtrl_Backend.Entity.GeneralStatus;
import com.kchauntell.KaosCtrl_Backend.Services.ListsServices.ListApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
public class ListController {
    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ListApplication listApplication;

    @GetMapping("/lists")
    public List<Lists> getAllLists() {
        return listRepository.findAll();
    }

    @PostMapping("/createList")
    public GeneralStatus createList(@RequestBody @Valid Lists lists) throws Exception{
        return this.listApplication.createLists(lists);
    }

    @PutMapping("/updateList")
    public Lists updateList(@RequestBody @Valid Lists lists) throws Exception{
        return this.listApplication.updateLists(lists);
    }

    @DeleteMapping("/deleteList")
    public void deleteList(@RequestBody @Valid Lists lists) throws Exception{
        this.listApplication.deleteLists(lists);
    }
}
