package controller;

import java.util.List;

import dao.CardsDAO;
import dto.CardsDTO;

 public class CardController {

    public static List<CardsDTO> getAll(){
        return CardsDAO.getAll();
    }

}

