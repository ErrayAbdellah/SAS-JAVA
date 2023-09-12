package controller;

import entity.Emprunteur;

import entity.Livre;
import service.EmprunteurService;
import service.LivreService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmprunteurController {

    private final EmprunteurService emprunteurService ;
    private final LivreService livreService;
    Scanner scanner = new Scanner(System.in);

    public EmprunteurController(EmprunteurService emprunteurService, LivreService livreService) {
        this.emprunteurService = emprunteurService;
        this.livreService = livreService;
    }
    public static Date convertDate(String startDate) {
        try {

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/mm/dd");
            java.util.Date date = sdf1.parse(startDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            System.out.println(sqlStartDate);
            return sqlStartDate ;
        }catch (ParseException e){
            e.getMessage();
        }
        return null;
    }

    public void emprunteLivre(Emprunteur emprunteur ,Livre livre) throws Exception {

        emprunteur.setLivre(livre);
        emprunteurService.ajouterEmprunte(emprunteur);

    }
}
