package org.example;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        LocalDate birthDate1 = LocalDate.of(1990, 3, 5);
        LocalDate birthDate2 = LocalDate.of(1985, 11, 28);
        LocalDate birthDate3 = LocalDate.of(1986, 11, 28);
        LocalDate birthDate4 = LocalDate.of(1990, 8, 12);

        CatalogAdministrator adminCatalog = new CatalogAdministrator();

//        adminCatalog.addStudentInCatalog("Ilie","Cernea",birthDate3,"male", "1861128364169");
//        adminCatalog.addStudentInCatalog("Maria", "Popa", birthDate1, "female", "2900305762139");
//        adminCatalog.addStudentInCatalog("Ion","Cernea",birthDate2,"male", "1851128364129");
////        adminCatalog.addStudentInCatalog("Ion","Cernea",birthDate2,"male", "1851128364129");
//        adminCatalog.addStudentInCatalog("Elena","Mitrea",birthDate4,"female", "2900912545874");

        adminCatalog.deleteStudentFromCatalog("2900912545874");
//        adminCatalog.deleteStudentFromCatalog("2900912545874");


        System.out.println(adminCatalog.repository);
        System.out.println(adminCatalog.repository.retrieveAllWithSpecificAge(35));
    }
}
