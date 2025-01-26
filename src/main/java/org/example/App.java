package org.example;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        LocalDate birthDate1 = LocalDate.of(1990, 03, 05);
        LocalDate birthDate2 = LocalDate.of(1985, 11, 28);
        LocalDate birthDate3 = LocalDate.of(1986, 11, 28);
        LocalDate birthDate4 = LocalDate.of(1986, 11, 28);

//        Student student1 = new Student("Maria", "Popa", birthDate1, "female", "2900305762139");
//        Student student2 = new Student("Ion","Cernea",birthDate2,"male", "1851128364129");
//        Student student3 = new Student("Ilie","Cernea",birthDate3,"male", "186112836416x");
//        Student student4 = new Student("Ion","Cernea",birthDate4,"male", "1851128364129");

        CatalogAdministrator adminCatalog = new CatalogAdministrator();

        adminCatalog.addStudentInCatalog("Ilie","Cernea",birthDate3,"male", "186112836416x");
        adminCatalog.addStudentInCatalog("Maria", "Popa", birthDate1, "female", "2900305762139");
        adminCatalog.addStudentInCatalog("Ion","Cernea",birthDate2,"male", "1851128364129");
        adminCatalog.addStudentInCatalog("Ion","Cernea",birthDate4,"male", "1851128364129");

//        adminCatalog.deleteStudentFromCatalog(29003057621L);


        System.out.println(adminCatalog.catalog);
    }
}
