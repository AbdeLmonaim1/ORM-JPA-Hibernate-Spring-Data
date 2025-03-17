# ORM-JPA-Hibernate-Spring-Data

## Overview
The goal of this practical activity is to acquire skills in web application development with Spring Boot and JPA. It involves installing and configuring IntelliJ Ultimate, creating a Spring Boot project with the necessary dependencies, and modeling a Patient entity while configuring the persistence unit. The use of Spring Data JPA facilitates interaction with the database through a Repository interface, allowing CRUD operations on patients. The activity also includes migrating from H2 to MySQL for more advanced data management. Finally, it aims to deepen the modeling of a management system by implementing other entities such as Medecin, Patient, Consultation, Users, and Roles.
## Technologies Used

- <img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" width="30" height="30"/> &nbsp;&nbsp;**Java**
- <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Spring_Boot.svg/768px-Spring_Boot.svg.png" width="30" height="30"/>   **Spring Boot**
- <img src="https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg" width="30" height="30"/> &nbsp;&nbsp;**IntelliJ IDEA**
- <img src="https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png" width="30" height="30"/> &nbsp;&nbsp;**Git**
- <img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" width="30" height="30"/> &nbsp;&nbsp;**GitHub**
## Practical Activity
### Entities Layer:
#### Entity Patient:
```java
@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private boolean sick;
    private int score;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
```
#### Entity Medecin:
```java
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "medecin")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<RendezVous> rendezVous;
}
```
#### Entity Consultation:
```java
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date consultationDate;
    private String rapport;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RendezVous rendezVous;
}
```
#### Entity RendezVous:
```java
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
```
##### Enumeration StatusRDV:
```java
public enum StatusRDV {
    PENDING,
    CANCLED,
    DONE
}
```
### Dao Layer:
#### PatientRepository:
```java
public interface PatientRepository extends JpaRepository<Patient, Long> {
   Patient findByName(String name);
}
```
#### MedecinRepository:
```java
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByName(String name);
}
```
#### ConsultationRepository:
```java
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
```
#### RendezVousRepository:
```java
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
```
