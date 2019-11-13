package controller;

import dao.CardsDAO;
import dto.CardsDTO;
import java.util.ArrayList;

 public class CardController {

    public static ArrayList<CardsDTO> cardsAll(){
        return CardsDAO.cardsAll();
    }

}

